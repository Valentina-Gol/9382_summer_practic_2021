package main.java.logic.Sort;

import main.java.logic.DataClass;

public class Comb extends VisibleSort implements Sort,Runnable {
    Thread thread;

    public Comb(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                startSort();
            } catch (Exception e) {}
        }

    }

    @Override
    public void startSort() {
        int speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}
        int gap = arrneedsort.leg();
        int j;
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));  // minimum gap is 1
            for (int i = 0; i < arrneedsort.leg() - gap; i++){
                j = i + gap;
//                DataClass.getInstance().elem1 = array[i];
//                DataClass.getInstance().elem2 = array[j];
                if (arrneedsort.get(i) > arrneedsort.get(j)){
                    int current = arrneedsort.get(i);
                    arrneedsort.set(arrneedsort.get(j), i);
                    arrneedsort.set(current, j);
                    try {
                        Thread.sleep(speed);
                    } catch (Exception e) {}
                    repaint();
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

