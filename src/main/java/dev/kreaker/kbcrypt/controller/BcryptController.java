package dev.kreaker.kbcrypt.controller;

import dev.kreaker.kbcrypt.service.BcryptService;
import dev.kreaker.kbcrypt.dto.HashRequest;
import dev.kreaker.kbcrypt.dto.ValidateRequest;
import dev.kreaker.kbcrypt.dto.BcryptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BcryptController {

    @Autowired
    private BcryptService bcryptService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hashRequest", new HashRequest());
        model.addAttribute("validateRequest", new ValidateRequest());
        return "index";
    }

    @PostMapping("/generate")
    @ResponseBody
    public BcryptResponse generateHash(@RequestBody HashRequest request) {
        try {
            String hash = bcryptService.generateHash(request.getPassword(), request.getRounds());
            return new BcryptResponse(true, hash, "Hash generado exitosamente", null);
        } catch (Exception e) {
            return new BcryptResponse(false, null, "Error al generar hash: " + e.getMessage(), null);
        }
    }

    @PostMapping("/validate")
    @ResponseBody
    public BcryptResponse validateHash(@RequestBody ValidateRequest request) {
        try {
            boolean isValid = bcryptService.validateHash(request.getPassword(), request.getHash());
            String message = isValid ? "La contraseña coincide con el hash" : "La contraseña NO coincide con el hash";
            return new BcryptResponse(true, null, message, isValid);
        } catch (Exception e) {
            return new BcryptResponse(false, null, "Error al validar hash: " + e.getMessage(), null);
        }
    }

    @GetMapping("/history")
    @ResponseBody
    public Object getHistory() {
        return bcryptService.getHistory();
    }

    @PostMapping("/history/clear")
    @ResponseBody
    public BcryptResponse clearHistory() {
        bcryptService.clearHistory();
        return new BcryptResponse(true, null, "Historial limpiado exitosamente", null);
    }
}
