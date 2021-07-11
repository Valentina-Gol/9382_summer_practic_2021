package logic.Sort;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;

import javax.swing.*;
import java.awt.*;

public class VisibleSort extends JPanel implements Runnable {
    public Thread thread;
    protected int gap;
    protected int itr;
    protected int[] arr;
    private int speed;
    private boolean pauseThreadFlag = false;

    VisibleSort() {
        itr = 0;
        gap = 0;
    }

    public void startSort(int value) {
        arr = DataClass.getInstance().mainArray;
        speed = value;
        thread.start();
    }

    public void makeStep() {
        resumeThread();
    }

    @Override
    public void run() {
        try {
        while (true) {
            if (!thread.isInterrupted()) {
                checkForPaused();
                doSort();
                repaint();
                TheBestLogger.getInstance().logInfo(gap + " " + itr);
                if (speed != 0) {
                    Thread.sleep(speed);
                    if (!next()) {
                        TheBestLogger.getInstance().logInfo("false");
                        return;
                    }
                } else
                    pauseThread();
            } else return;
        }
        } catch (Exception e) {
            TheBestLogger.getInstance().logException(e.getMessage());
        }
    }

    private void checkForPaused() {
        synchronized (thread) {
            while (pauseThreadFlag) {
                try {
                        thread.wait();
                } catch (Exception e) {}
            }
        }
    }

    public void pauseThread() throws InterruptedException {
        pauseThreadFlag = true;
    }

    public void resumeThread() {
        synchronized(thread) {
            pauseThreadFlag = false;
            thread.notify();
        }
    }

    public boolean next() {return true; }

    public void doSort() {}


    public void paint(Graphics g) {
        g.clearRect(0, 0, 1500,800);
        for (int i = 0; i < arr.length; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i*10+100,(500-(arr[i]*4)),10, arr[i]*4);
        }

    }

}
 