package logic.Sort;


import logic.SortAlgo.EvenOddAlgo;

public class EvenOdd extends VisibleSort {
    EvenOddAlgo alg;

    public EvenOdd() {
        super();
        alg = new EvenOddAlgo();
        thread = new Thread(this);
    }

    @Override
    public boolean next() {
        if (itr + 2 < (arr.length - 1))
            itr += 2;
        else if (gap < arr.length) {
            gap++;
            itr = (gap % 2 == 0) ? 0 : 1;
        } else
            return false;
        return true;
    }

    @Override
    public void doSort() {
        arr = alg.smallGap(arr, itr);
    }
}




