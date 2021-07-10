package logic.SortAlgo;
import logic.Sort.Comb;
import org.apache.log4j.Logger;

public class BrushAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    private int gap;
    private int itr;

    public BrushAlgo(int newgap){
        gap = newgap;
        itr = 0;
    }

    public void smallGap(int[] arr, Comb mox){
       int j = itr + gap;
       if (arr[itr] > arr[j]) {
            int current = arr[itr];
            arr[itr] = arr[j];
            arr[j] = current;
       }
        try {
            Thread.sleep(mox.speed);
        } catch (Exception e) {
        }
       mox.repaint();
    }

    public void bigGap(int[] arr, Comb mox){
        for (itr = 0; itr < arr.length - gap; itr++){
            smallGap(arr, mox);
        }
    }

    public  void useSort(int[] arr, Comb mox){
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));
            bigGap(arr, mox);
        }
    }
}
