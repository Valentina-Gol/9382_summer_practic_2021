package logic.SortAlgo;
import logic.DataClass;
import logic.Sort.Comb;
import org.apache.log4j.Logger;
public class ShakerAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    ShakerAlgo( int newgap){
        gap = newgap;
        itr = 0;
    };

    public void smallGap(int[] arr, boolean flag){
        if(flag){
            if (arr[gap + 1] < arr[gap]) {
                int current = arr[gap];
                arr[gap] = arr[gap + 1];
                arr[gap + 1] = current;
            }
        }
        else{
            if (arr[gap - 1] < arr[gap]) {
                int current = arr[gap];
                arr[gap] = arr[gap - 1];
                arr[gap - 1] = current;
            }
        }
    };
    public void bigGap(int[] arr ){
        while (gap < arr.length - 1 - itr){
            smallGap(arr,true);
            gap++;
        }
        while (gap > itr){
            smallGap(arr, false);
            gap--;
        }
    }
    public  void useSort(int[] arr){
        while (itr != arr.length / 2) {
            bigGap(arr);
            itr++;
            gap= itr;
        }
    }
}
