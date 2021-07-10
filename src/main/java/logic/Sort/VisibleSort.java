package logic.Sort;

import logic.DataClass;

import javax.swing.*;
import java.awt.*;

public class VisibleSort extends JPanel implements Sort, Runnable {
    DataClass arrneedsort;
    public Thread thread;
    public int speed;

    VisibleSort() {
        arrneedsort = DataClass.getInstance();
    }

    @Override
    public void startSort() {
        thread.start();
    }

    public void doSort() {};

    @Override
    public void run() {
        while(true) {
            try {
                if (!thread.isInterrupted()) {
                    this.doSort();
                } else return;
            } catch (Exception e) {}
        }

    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, 1500,800);
        for (int i = 0; i < arrneedsort.mainArray.length; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i*10+100,(500-(arrneedsort.mainArray[i]*4)),10, arrneedsort.mainArray[i]*4);
        }

    }

}
 