package dev.kreaker.kbcrypt.dto;

public class HashRequest {
    private String password;
    private int rounds = 12;

    public HashRequest() {}

    public HashRequest(String password, int rounds) {
        this.password = password;
        this.rounds = rounds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
