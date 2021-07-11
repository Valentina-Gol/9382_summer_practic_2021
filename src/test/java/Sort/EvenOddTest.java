package Sort;

import logic.SortAlgo.EvenOddAlgo;
import org.junit.Assert;
import org.junit.Test;

public class EvenOddTest extends tests.Sort.SortTest {

    @Test
    public void EvenOddSortAscending() {
        int[] arr1ResProg = new EvenOddAlgo().useSort(testArr1);
        int[] arr2ResProg = new EvenOddAlgo().useSort(testArr2);
        int[] arr3ResProg = new EvenOddAlgo().useSort(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }
}
