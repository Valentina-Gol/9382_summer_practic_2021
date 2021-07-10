package logic.SortAlgo;
import logic.DataClass;
import logic.Sort.Comb;
import logic.Sort.Shaker;
import org.apache.log4j.Logger;
public class ShakerAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    public ShakerAlgo(int newgap){
        gap = newgap;
        itr = 0;
    };

    public void smallGap(int[] arr, boolean flag, Shaker mox){
        if(flag){
            if (arr[gap + 1] < arr[gap]) {
                int current = arr[gap];
                arr[gap] = arr[gap + 1];
                arr[gap + 1] = current;
            }
        }
        else{
            if (arr[gap - 1] > arr[gap]) {
                int current = arr[gap];
                arr[gap] = arr[gap - 1];
                arr[gap - 1] = current;
            }
        }
        try {
            Thread.sleep(mox.speed);
        } catch (Exception e) {
        }
        mox.repaint();
    };
    public void bigGap(int[] arr, Shaker mox ){
        while (gap < arr.length - 1 - itr){
            smallGap(arr,true, mox);
            gap++;
        }
        while (gap > itr){
            smallGap(arr, false, mox);
            gap--;
        }
    }
    public  void useSort(int[] arr, Shaker mox){
        while (itr != arr.length / 2) {
            bigGap(arr, mox);
            itr++;
            gap= itr;
        }
    }
}
