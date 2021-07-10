package logic.Sort;

import logic.DataClass;
import logic.SortAlgo.BrushAlgo;
import org.apache.log4j.Logger;

public class Comb extends VisibleSort implements Sort,Runnable {
    private static final Logger log = Logger.getLogger( Comb.class);
    Thread thread;
    public int speed;

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
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        BrushAlgo alg = new BrushAlgo(arrneedsort.mainArray.length);
        alg.useSort(arrneedsort.mainArray, this);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

