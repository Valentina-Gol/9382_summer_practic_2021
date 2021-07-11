package logic.SortAlgo;
import logic.MyLogger.TheBestLogger;
import logic.Sort.Comb;
import org.apache.log4j.Logger;
public class ShakerAlgo {
    private static final Logger log = Logger.getLogger( Comb.class);
    public ShakerAlgo(){};

    public int[] smallGap(int[] arr, boolean flag, int itr){
        if(flag){
            TheBestLogger.getInstance().logInfo(String.format("Checked elements in position %d, %d", itr, itr + 1));
            if (arr[itr + 1] < arr[itr]) {
                TheBestLogger.getInstance().logInfo("Swap elements!");
                int current = arr[itr];
                arr[itr] = arr[itr + 1];
                arr[itr + 1] = current;
            }
        }
        else{
            TheBestLogger.getInstance().logInfo(String.format("Checked elements in position %d, %d", itr - 1, itr));
            if (arr[itr - 1] > arr[itr]) {
                TheBestLogger.getInstance().logInfo("Swap elements!");
                int current = arr[itr];
                arr[itr] = arr[itr - 1];
                arr[itr - 1] = current;
            }
        }
        return arr;
    }

    public int[] bigGap(int[] arr, int gap, int itr){
        while (itr < arr.length - 1 - gap){
            arr = smallGap(arr,true,  itr);
            itr++;
        }
        while (itr > gap){
            arr = smallGap(arr, false, itr);
            itr--;
        }
        return arr;
    }
    public  int[] useSort(int[] arr){
        int gap = 0, itr = 0;
        while (gap != arr.length / 2) {
            arr = bigGap(arr, gap, itr);
            gap++;
            itr = gap;
        }
        return arr;
    }
}
