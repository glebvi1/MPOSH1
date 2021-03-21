package com.example.mposh;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class SurfaceView1 extends SurfaceView implements SurfaceHolder.Callback{

    private DrawThread thread;
    public ArrayList<Float> points;

    public SurfaceView1(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public void get1(ArrayList<Float> points) {
        this.points=points;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new DrawThread(surfaceHolder);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                //
            }
        }
    }

    class DrawThread extends Thread {
        private SurfaceHolder surfaceHolder;
        private volatile boolean running = true;

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void requestStop() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = surfaceHolder.lockCanvas();
                if (canvas != null) {
                    Paint paint = new Paint();
                    paint.setColor(Color.GREEN);
                    for (int i = 0; i < canvas.getHeight(); i++) {
                        for (int j = 0; j < canvas.getWidth(); j++) {
                            canvas.drawPoint(i,j,paint);
                        }
                    }
                    paint.setColor(Color.RED);

                    for (int i = 1; i < points.size()-1; i++) {
                        canvas.drawLine((float) Math.ceil(canvas.getWidth()/(points.size()*i)), points.get(i), (float) Math.ceil(canvas.getWidth()/(points.size()*(i+1))), points.get(i+1), paint);
                    }

                    getHolder().unlockCanvasAndPost(canvas);
                }

                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}