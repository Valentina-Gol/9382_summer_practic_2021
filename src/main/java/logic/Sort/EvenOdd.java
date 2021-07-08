package logic.Sort;


import logic.DataClass;

public class EvenOdd extends VisibleSort implements Sort,Runnable {
    Thread thread;
    public EvenOdd(){
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
        int arrLen = arrneedsort.mainArray.length; //длина массива
        for (int i = 0; i < arrLen; i++) {
            // (i % 2) ? 0 : 1 возвращает 0, если i четное, 1, если i не четное
            for (int j = (i % 2 == 0) ? 0 : 1; j < arrLen - 1; j += 2) {
                //DataClass.getInstance().elem1 = arrn[j];
                //DataClass.getInstance().elem2 = arr[j + 1];
                if (arrneedsort.mainArray[j] > arrneedsort.mainArray[j + 1]) {
                    int temp = arrneedsort.mainArray[j];
                    arrneedsort.mainArray[j] = arrneedsort.mainArray[j + 1];
                    arrneedsort.mainArray[j + 1] = temp;
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




