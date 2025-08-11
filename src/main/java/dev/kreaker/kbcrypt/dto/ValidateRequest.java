package dev.kreaker.kbcrypt.dto;

public class ValidateRequest {
    private String password;
    private String hash;

    public ValidateRequest() {}

    public ValidateRequest(String password, String hash) {
        this.password = password;
        this.hash = hash;
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
}
