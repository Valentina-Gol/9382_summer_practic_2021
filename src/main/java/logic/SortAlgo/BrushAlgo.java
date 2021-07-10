package logic.SortAlgo;
import logic.DataClass;
import logic.Sort.Comb;
import org.apache.log4j.Logger;

public class BrushAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    BrushAlgo( int newgap){
        gap = newgap;
        itr = 0;
    };

    public void smallGap(int[] arr){
       int j = itr + gap;
       if (arr[itr] > arr[j]) {
            int current = arr[itr];
            arr[itr] = arr[j];
            arr[j] = current;
       };
    };
    public void bigGap(int[] arr ){
        for (; itr < arr.length - gap; itr++){
            smallGap(arr);
        }
    }
    public  void useSort(int[] arr){
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));
            bigGap(arr);
        }
    }

}
