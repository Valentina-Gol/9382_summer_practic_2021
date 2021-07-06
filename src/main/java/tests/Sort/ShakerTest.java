package Sort;

import org.junit.Assert;
import org.junit.Test;
import logic.Sort.Shaker;

public class ShakerTest extends SortTest {

    @Test
    public void ShakerSortAscending() {
        int[] arr1ResProg = new Shaker().sortAscending(testArr1);
        int[] arr2ResProg = new Shaker().sortAscending(testArr2);
        int[] arr3ResProg = new Shaker().sortAscending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }

    @Test
    public void ShakerSortDescending() {
        int[] arr1ResProg = new Shaker().sortDescending(testArr1);
        int[] arr2ResProg = new Shaker().sortDescending(testArr2);
        int[] arr3ResProg = new Shaker().sortDescending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resDesArr2, arr2ResProg);
        Assert.assertArrayEquals(resDesArr3, arr3ResProg);
    }
}
