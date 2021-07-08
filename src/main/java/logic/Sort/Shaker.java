package logic.Sort;

import logic.DataClass;

public class Shaker extends VisibleSort implements Sort,Runnable {
    Thread thread;

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
        int speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        int i = 0;
        int count = 0;
        int leng = arrneedsort.mainArray.length;
        while (count != leng / 2) {
            while (i < leng - 1 - count) {
                //DataClass.getInstance().elem1 = array[i];
                //DataClass.getInstance().elem2 = array[i + 1];
                if (arrneedsort.mainArray[i + 1] < arrneedsort.mainArray[i]) {
                    int current = arrneedsort.mainArray[i];
                    arrneedsort.mainArray[i] = arrneedsort.mainArray[i + 1];
                    arrneedsort.mainArray[i + 1] = current;
                    try {
                        Thread.sleep(speed);
                    } catch (Exception e) {
                    }
                    repaint();

                }
                i++;
            }
            while (i > count) {
                //DataClass.getInstance().elem1 = array[i - 1];
                //DataClass.getInstance().elem2 = array[i];
                if (arrneedsort.mainArray[i - 1] > arrneedsort.mainArray[i]) {
                    int current = arrneedsort.mainArray[i];
                    arrneedsort.mainArray[i] = arrneedsort.mainArray[i - 1];
                    arrneedsort.mainArray[i - 1] = current;
                    try {
                        Thread.sleep(speed);
                    } catch (Exception e) {
                    }
                    repaint();

                }
                i--;
            }
            count++;
            i = count;
        }


        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
}