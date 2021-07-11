package logic.SortAlgo;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;

public class EvenOddAlgo {
    public EvenOddAlgo(){}

    public int[] smallGap(int[] arr, int itr) {
        DataClass.getInstance().elem1 = itr;
        DataClass.getInstance().elem2 = itr + 1;
        TheBestLogger.getInstance().logInfo(String.format("Checked elements in position %d, %d", itr, itr + 1));
        if (arr[itr] > arr[itr + 1]) {
            TheBestLogger.getInstance().logInfo("Swap elements!");
            int temp = arr[itr];
            arr[itr] = arr[itr + 1];
            arr[itr + 1] = temp;
        }
        return arr;
    }

    public int[] bigGap(int[] arr, int itr) {
        for (; itr < arr.length - 1; itr += 2) {
            arr = smallGap(arr, itr);
        }
        return arr;
    }

    public int[] useSort(int[] arr) {
        for (int gap = 0; gap < arr.length; gap++) {
            int itr = (gap % 2 == 0) ? 0 : 1;
            arr = bigGap(arr, itr);
        }
        return arr;
    }
}
