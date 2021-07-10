package logic.SortAlgo;
import logic.DataClass;
import logic.Sort.Comb;
import logic.Sort.EvenOdd;
import logic.Sort.Shaker;
import org.apache.log4j.Logger;
public class EvenOddAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    public EvenOddAlgo(int newgap){
        gap = newgap;
        itr = 0;
    };

    public void smallGap(int[] arr, EvenOdd mox){

        if (arr[gap] > arr[gap + 1]) {
            int temp = arr[gap];
            arr[gap] = arr[gap + 1];
            arr[gap + 1] = temp;
        };
        try {
            Thread.sleep(mox.speed);
        } catch (Exception e) {
        }
        mox.repaint();
    };
    public void bigGap(int[] arr, EvenOdd mox ){
        for (; gap < arr.length - 1; gap += 2) {
            smallGap(arr, mox);
        }
    }
    public  void useSort(int[] arr, EvenOdd mox){
        for (; itr < arr.length; itr++) {
            gap = (itr % 2 == 0) ? 0 : 1;
            bigGap(arr, mox);
        }
    }
}
