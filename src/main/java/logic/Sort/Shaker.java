package logic.Sort;

import logic.SortAlgo.ShakerAlgo;

public class Shaker extends VisibleSort {
    ShakerAlgo alg;
    boolean flag = true;
    public Shaker() {
        super();
        alg = new ShakerAlgo();
        thread = new Thread(this);
    }

    @Override
    public boolean next() {
        if (itr + 1 < (arr.length - 1 - gap) && flag)
            itr++;
        else if (itr > gap) {
            flag = false;
            itr--;
        }
        else {
            flag = true;
            if (gap != arr.length / 2) {
                gap++;
                itr = gap;
            } else
                return false;
        }
        return true;
    }

    @Override
    public void doSort() {
        if (itr < arr.length - 1 - gap)
            arr = alg.smallGap(arr, true, itr);
        else if (itr > gap)
            arr = alg.smallGap(arr, false, itr);
    }
}