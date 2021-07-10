package logic.Sort;


import logic.DataClass;
import logic.SortAlgo.EvenOddAlgo;

public class EvenOdd extends VisibleSort {
    public EvenOdd(){
        thread = new Thread(this);
    }

    @Override
    public void doSort() {
        speed = DataClass.getInstance().speed;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        EvenOddAlgo alg = new EvenOddAlgo(0);
        alg.useSort(arrneedsort.mainArray, this);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}




