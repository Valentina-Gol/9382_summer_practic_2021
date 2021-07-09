package logic.Sort;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;
import org.apache.log4j.Logger;

public class Comb extends VisibleSort implements Sort,Runnable {
    private static final Logger log = Logger.getLogger( Comb.class);
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
        int gap = arrneedsort.mainArray.length;
        int j;
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));  // minimum gap is 1
            for (int i = 0; i < arrneedsort.mainArray.length - gap; i++){
                j = i + gap;
//                DataClass.getInstance().elem1 = array[i];
//                DataClass.getInstance().elem2 = array[j];
                if (arrneedsort.mainArray[i] > arrneedsort.mainArray[j]){
                    int current = arrneedsort.mainArray[i];
                    arrneedsort.mainArray[i] = arrneedsort.mainArray[j];
                    arrneedsort.mainArray[j] = current;
                    try {
                        Thread.sleep(speed);
                    } catch (Exception e) {}
                    TheBestLogger.getInstance().logException("File not found");
                    repaint();
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

