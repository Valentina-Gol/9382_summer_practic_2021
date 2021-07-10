package logic.SortAlgo;
import logic.DataClass;
import logic.Sort.Comb;
import org.apache.log4j.Logger;
public class EvenOddAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    EvenOddAlgo( int newgap){
        gap = newgap;
        itr = 0;
    };

    public void smallGap(int[] arr){

        if (arr[gap] > arr[gap + 1]) {
            int temp = arr[gap];
            arr[gap] = arr[gap + 1];
            arr[gap + 1] = temp;
        };
    };
    public void bigGap(int[] arr ){
        for (; gap < arr.length - 1; gap += 2){
            smallGap(arr);
        }
    }
    public  void useSort(int[] arr){
        for (; itr < arr.length; itr++) {
            gap = (itr % 2 == 0) ? 0 : 1;
            bigGap(arr);
        }
    }
}
