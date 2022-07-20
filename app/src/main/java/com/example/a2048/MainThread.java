package com.example.a2048;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private GameManager gameManager;
    private SurfaceHolder surfaceHolder;
    private int targetFPS = 60;
    private Canvas canvas;
    private boolean running;

    public MainThread(SurfaceHolder surfaceHolder, GameManager gameManager) {
        super();
        this.gameManager = gameManager;
        this.surfaceHolder = surfaceHolder;
    }

    public void setRunning(boolean isRunning) {
       running = isRunning;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        long startTime, timeMillis, waitTime;

        long targetTime = 1000 / targetFPS;

        while (running) {
            canvas = null;
            startTime = System.nanoTime();

            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    gameManager.update();
                    gameManager.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 100000;
            waitTime = targetTime - timeMillis;

            try {
                if (waitTime > 0) {
                    sleep(waitTime);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
