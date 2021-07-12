package logic.SortAlgo;
import logic.DataClass;
import logic.MyLogger.TheBestLogger;

public class BrushAlgo {
    public BrushAlgo(){}

    public int[] smallGap(int[] arr, int gap, int itr) {
        int j = itr + gap;
        DataClass.getInstance().elem1 = itr;
        DataClass.getInstance().elem2 = j;
        TheBestLogger.getInstance().logInfo(String.format("Checked elements in position %d, %d", itr, itr + 1));
        if (arr[itr] > arr[j]) {
            TheBestLogger.getInstance().logInfo("Swap elements!");
            int current = arr[itr];
            arr[itr] = arr[j];
            arr[j] = current;
        }
        return arr;
    }

    public int[] bigGap(int[] arr, int gap) {
        for (int itr = 0; itr < arr.length - gap; itr++) {
            arr = smallGap(arr, gap, itr);
        }
        return arr;
    }

    public  int[] useSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap = Math.max(1, (int) (gap / 1.25));
            arr = bigGap(arr, gap);
        }
        return arr;
    }
}
