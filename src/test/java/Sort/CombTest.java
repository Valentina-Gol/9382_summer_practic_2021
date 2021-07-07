package Sort;

import org.junit.Assert;
import org.junit.Test;
import logic.Sort.Comb;

public class CombTest extends SortTest {

    @Test
    public void combSortAscending() {
        int[] arr1ResProg = new Comb().sortAscending(testArr1);
        int[] arr2ResProg = new Comb().sortAscending(testArr2);
        int[] arr3ResProg = new Comb().sortAscending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }

    @Test
    public void combSortDescending() {
        int[] arr1ResProg = new Comb().sortDescending(testArr1);
        int[] arr2ResProg = new Comb().sortDescending(testArr2);
        int[] arr3ResProg = new Comb().sortDescending(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resDesArr2, arr2ResProg);
        Assert.assertArrayEquals(resDesArr3, arr3ResProg);
    }
}
