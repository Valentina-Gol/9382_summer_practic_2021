package logic.Sort;

import logic.SortAlgo.ShakerAlgo;

public class Shaker extends VisibleSort {
    ShakerAlgo alg;
    public Shaker() {
        super();
        alg = new ShakerAlgo();
        thread = new Thread(this);
    }

    @Override
    public boolean next() {
        if (itr < (arr.length - 1 - gap))
            itr++;
        else if (itr > gap)
            itr--;
        else {
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