package dev.kreaker.kbcrypt.dto;

public class BcryptResponse {
    private boolean success;
    private String hash;
    private String message;
    private Boolean matches;

    public BcryptResponse() {}

    public BcryptResponse(boolean success, String hash, String message, Boolean matches) {
        this.success = success;
        this.hash = hash;
        this.message = message;
        this.matches = matches;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getMatches() {
        return matches;
    }

    public void setMatches(Boolean matches) {
        this.matches = matches;
    }
}
