package logic.Sort;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;

import javax.swing.*;
import java.awt.*;

public class VisibleSort extends JPanel implements Runnable {
    public Thread thread;
    protected int gap;//большой шаг итерации
    protected int itr;//маленький шаг итерации
    protected int[] arr;
    private int speed;
    private boolean pauseThreadFlag;

    VisibleSort() {
        itr = 0;
        gap = 0;
        pauseThreadFlag = false;
    }

    public boolean next() {
        return true;
    }

    public void doSort() {}

    @Override
    public void run() {
        try {
            while (true) {
                if (!thread.isInterrupted()) {
                    checkForPaused();
                    doSort();
                    repaint();
                    if (speed != 0) {
                        Thread.sleep(speed);
                        if (!next()) {
                            TheBestLogger.getInstance().logInfo("Sort was finished!");
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

    public void startSort(int value) {
        TheBestLogger.getInstance().logInfo("Sort was started!");
        arr = DataClass.getInstance().mainArray;
        speed = value;
        thread.start();
    }

    public void makeStep() {
        resumeThread();
    }

    private void checkForPaused() {
        synchronized (thread) {
            while (pauseThreadFlag) {
                try {
                    thread.wait();
                } catch (Exception e) {
                    TheBestLogger.getInstance().logException(e.getMessage());
                }
            }
        }
    }

    public void pauseThread() {
        pauseThreadFlag = true;
    }

    public void resumeThread() {
        synchronized (thread) {
            pauseThreadFlag = false;
            thread.notify();
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, 1500, 800);
        for (int i = 0; i < arr.length; i++) {
            if ((i == DataClass.getInstance().elem1) || (i == DataClass.getInstance().elem2)) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(i * 10 + 100, (500 - (arr[i] * 4)), 10, arr[i] * 4);
        }
    }
}
 