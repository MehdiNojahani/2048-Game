package com.example.a2048.sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.a2048.R;

public class Grid implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private Bitmap grid;

    public Grid(Resources resources, int screenWidth, int screenHeight, int standardSize) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        Bitmap bmp = BitmapFactory.decodeResource(resources, R.drawable.grids);
        grid = Bitmap.createScaledBitmap(bmp, (standardSize * 4),
                (standardSize * 4), false);

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(grid, screenWidth / 2 - grid.getWidth() / 2,
                screenHeight / 2  - grid.getHeight() / 2, null);
    }

    @Override
    public void update() {

    }
}
