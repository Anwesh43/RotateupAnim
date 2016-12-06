package com.anwesome.uiview.rotateupanim;

import android.app.Activity;
import android.view.*;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 07/12/16.
 */
public class RotateUpAnim {
    private ConcurrentLinkedQueue<RotateUpAnimElement> elements = new ConcurrentLinkedQueue<>();
    private Thread currentThread;
    private Activity activity;
    public RotateUpAnim(Activity activity) {
        this.activity = activity;
        init();
    }
    public void addView(View view) {
        elements.add(new RotateUpAnimElement(view));
    }
    private void init() {
        currentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (RotateUpAnimElement element : elements) {
                                if(!element.isAnimDone()) {
                                    element.move();
                                }
                                else {
                                    elements.remove(element);
                                }
                            }
                        }
                    });

                    try {
                        Thread.sleep(100);
                    }
                    catch (Exception ex) {

                    }
                }
            }
        });
    }
    public void start() {
        currentThread.start();
    }
    private class RotateUpAnimElement {
        private int mode = 0;
        private View view;
        private boolean animDone = false;
        public RotateUpAnimElement(View view) {
            this.view = view;
        }
        public void move() {
            if(!animDone) {
                switch (mode) {
                    case 0:
                        view.setRotation(view.getRotation() + 40);
                        if (view.getRotation() % 360 == 0) {
                            mode = 1;
                        }
                        break;
                    case 1:
                        view.setScaleX(view.getScaleX() + 0.2f);
                        view.setScaleY(view.getScaleY() + 0.2f);
                        if (view.getScaleX() >= 2.0f) {
                            mode = 2;
                        }
                        break;
                    case 2:
                        view.setScaleX(view.getScaleX() - 0.2f);
                        view.setScaleY(view.getScaleY() - 0.2f);
                        if (view.getScaleX() <= 1.0f) {
                            animDone = true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        public boolean isAnimDone() {
            return animDone;
        }
        public int hashCode() {
            return mode+view.hashCode();
        }
    }
}
