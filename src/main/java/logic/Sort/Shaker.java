package logic.Sort;

import logic.DataClass;
import logic.SortAlgo.ShakerAlgo;

public class Shaker extends VisibleSort implements Sort,Runnable {
    Thread thread;
    public int speed;
    public Shaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                startSort();
            } catch (Exception e) {
            }
        }

    }

    @Override
    public void startSort() {
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        ShakerAlgo alg = new ShakerAlgo(0);
        alg.useSort(arrneedsort.mainArray, this);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
}