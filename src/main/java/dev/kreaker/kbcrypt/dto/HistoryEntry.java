package dev.kreaker.kbcrypt.dto;

public class HistoryEntry {
    private String operation;
    private String password;
    private String hash;
    private int rounds;
    private Boolean matches;
    private String timestamp;

    public HistoryEntry() {}

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Boolean getMatches() {
        return matches;
    }

    public void setMatches(Boolean matches) {
        this.matches = matches;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
