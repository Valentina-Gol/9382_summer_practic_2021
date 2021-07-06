package Sort;

import org.junit.Assert;
import org.junit.Test;
import logic.Sort.EvenOdd;

public class EvenOddTest extends SortTest {

    @Test
    public void EvenOddSortAscending() {
        int[] arr1ResProg = new EvenOdd().sortAscending(testArr1);
        int[] arr2ResProg = new EvenOdd().sortAscending(testArr2);
        int[] arr3ResProg = new EvenOdd().sortAscending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }

    @Test
    public void EvenOddSortDescending() {
        int[] arr1ResProg = new EvenOdd().sortDescending(testArr1);
        int[] arr2ResProg = new EvenOdd().sortDescending(testArr2);
        int[] arr3ResProg = new EvenOdd().sortDescending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resDesArr2, arr2ResProg);
        Assert.assertArrayEquals(resDesArr3, arr3ResProg);
    }
}
