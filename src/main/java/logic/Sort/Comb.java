package logic.Sort;

import logic.SortAlgo.BrushAlgo;

public class Comb extends VisibleSort {
    BrushAlgo alg;
    public Comb(){
        super();
        alg = new BrushAlgo();
        thread = new Thread(this);
    }

    @Override
    public void startSort(int value) {
        super.startSort(value);
        gap = Math.max(1, (int) (arr.length / 1.25));
    }

    @Override
    public boolean next() {
        if (itr + 1 < (arr.length - gap))
            itr++;
        else {
            itr = 0;
            if (gap > 1) {
                gap = Math.max(1, (int) (gap / 1.25));
            } else
                return false;
        }
        return true;
    }

    @Override
    public void doSort() {
        arr = alg.smallGap(arr, gap, itr);
    }
}

