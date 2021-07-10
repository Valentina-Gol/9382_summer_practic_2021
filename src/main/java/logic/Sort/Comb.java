package logic.Sort;

import logic.DataClass;
import logic.SortAlgo.BrushAlgo;
import org.apache.log4j.Logger;

public class Comb extends VisibleSort {
    private static final Logger log = Logger.getLogger( Comb.class);
    public Comb(){
        thread = new Thread(this);
    }

    @Override
    public void doSort() {
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        BrushAlgo alg = new BrushAlgo(arrneedsort.mainArray.length);
        alg.useSort(arrneedsort.mainArray, this);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

