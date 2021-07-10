package logic.Sort;

import logic.DataClass;
import logic.SortAlgo.ShakerAlgo;

public class Shaker extends VisibleSort {
    public Shaker() {
        thread = new Thread(this);
    }

    @Override
    public void doSort() {
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(2000);
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