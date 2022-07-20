package com.example.a2048;

public interface GameManagerCallback {
    void gameOver();
    void updateScore(int delta);
}
