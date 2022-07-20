package com.example.a2048;

public interface SwipeCallback {
    void onSwipe(Directions directions);

    enum Directions {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
