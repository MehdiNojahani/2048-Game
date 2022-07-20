package com.example.a2048;

import android.graphics.Bitmap;

import com.example.a2048.sprites.Tile;

public interface TileManagerCallback {
    Bitmap getBitmap(int count);
    void finishingMoving(Tile t);
    void updateScore(int delta);
}
