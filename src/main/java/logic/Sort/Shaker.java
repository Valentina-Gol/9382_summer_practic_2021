package logic.Sort;

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
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        int i = 0;
        int count = 0;
        int leng = arrneedsort.leg();
        while (count != leng / 2) {
            while (i < leng - 1 - count) {
                //DataClass.getInstance().elem1 = array[i];
                //DataClass.getInstance().elem2 = array[i + 1];
                if (arrneedsort.get(i + 1) < arrneedsort.get(i)) {
                    int current = arrneedsort.get(i);
                    arrneedsort.set(arrneedsort.get(i + 1), i);
                    arrneedsort.set(current, i + 1);

                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                    repaint();

                }
                i++;
            }
            while (i > count) {
                //DataClass.getInstance().elem1 = array[i - 1];
                //DataClass.getInstance().elem2 = array[i];
                if (arrneedsort.get(i - 1) > arrneedsort.get(i)) {
                    int current = arrneedsort.get(i);
                    arrneedsort.set(arrneedsort.get(i - 1), i);
                    arrneedsort.set(current, i - 1);

                    try {
                        Thread.sleep(10);
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