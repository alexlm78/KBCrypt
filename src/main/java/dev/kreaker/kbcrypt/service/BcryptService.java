package dev.kreaker.kbcrypt.service;

import dev.kreaker.kbcrypt.dto.HistoryEntry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class BcryptService {

    private final ConcurrentLinkedQueue<HistoryEntry> history = new ConcurrentLinkedQueue<>();
    private static final int MAX_HISTORY_SIZE = 100;

    public String generateHash(String password, int rounds) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }

        if (rounds < 4 || rounds > 31) {
            throw new IllegalArgumentException("Los rounds deben estar entre 4 y 31");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(rounds);
        String hash = encoder.encode(password);

        // Agregar al historial
        addToHistory("GENERATE", password, hash, rounds, null);

        return hash;
    }

    public boolean validateHash(String password, String hash) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }

        if (hash == null || hash.trim().isEmpty()) {
            throw new IllegalArgumentException("El hash no puede estar vacío");
        }

        if (!hash.startsWith("$2a$") && !hash.startsWith("$2b$") && !hash.startsWith("$2y$")) {
            throw new IllegalArgumentException("El hash no tiene un formato BCrypt válido");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(password, hash);

        // Extraer rounds del hash
        int rounds = extractRoundsFromHash(hash);

        // Agregar al historial
        addToHistory("VALIDATE", password, hash, rounds, matches);

        return matches;
    }

    private void addToHistory(String operation, String password, String hash, int rounds, Boolean matches) {
        HistoryEntry entry = new HistoryEntry();
        entry.setOperation(operation);
        entry.setPassword(maskPassword(password));
        entry.setHash(hash);
        entry.setRounds(rounds);
        entry.setMatches(matches);
        entry.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        history.offer(entry);

        // Mantener el tamaño del historial
        while (history.size() > MAX_HISTORY_SIZE) {
            history.poll();
        }
    }

    private String maskPassword(String password) {
        if (password == null || password.length() <= 2) {
            return "***";
        }
        return password.substring(0, 2) + "*".repeat(Math.min(password.length() - 2, 6));
    }

    private int extractRoundsFromHash(String hash) {
        try {
            // El formato es $2a$10$... donde 10 son los rounds
            String[] parts = hash.split("\\$");
            if (parts.length >= 3) {
                return Integer.parseInt(parts[2]);
            }
        } catch (Exception e) {
            // Silenciar error y devolver valor por defecto
        }
        return 10; // Valor por defecto
    }

    public List<HistoryEntry> getHistory() {
        return new ArrayList<>(history);
    }

    public void clearHistory() {
        history.clear();
    }
}
