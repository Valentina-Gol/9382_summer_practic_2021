package logic.Sort;


import logic.DataClass;
import logic.SortAlgo.EvenOddAlgo;
import logic.SortAlgo.ShakerAlgo;

public class EvenOdd extends VisibleSort implements Sort,Runnable {
    Thread thread;
    public int speed;
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
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        EvenOddAlgo alg = new EvenOddAlgo(0);
        alg.useSort(arrneedsort.mainArray, this);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}




