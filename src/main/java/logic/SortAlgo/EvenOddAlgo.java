package logic.SortAlgo;
public class EvenOddAlgo {

    public EvenOddAlgo(){}

    public int[] smallGap(int[] arr, int itr){
        if (arr[itr] > arr[itr + 1]) {
            int temp = arr[itr];
            arr[itr] = arr[itr + 1];
            arr[itr + 1] = temp;
        }
        return arr;
    }

    public int[] bigGap(int[] arr, int itr){
        for (; itr < arr.length - 1; itr += 2) {
            arr = smallGap(arr, itr);
        }
        return arr;
    }
    public int[] useSort(int[] arr){
        for (int gap = 0; gap < arr.length; gap++) {
            int itr = (gap % 2 == 0) ? 0 : 1;
            arr = bigGap(arr, itr);
        }
        return arr;
    }
}
