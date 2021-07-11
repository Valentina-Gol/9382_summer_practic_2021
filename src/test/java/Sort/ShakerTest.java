package Sort;

import logic.SortAlgo.ShakerAlgo;
import org.junit.Assert;
import org.junit.Test;

public class ShakerTest extends tests.Sort.SortTest {

    @Test
    public void ShakerSortAscending() {
        int[] arr1ResProg = new ShakerAlgo().useSort(testArr1);
        int[] arr2ResProg = new ShakerAlgo().useSort(testArr2);
        int[] arr3ResProg = new ShakerAlgo().useSort(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }
}
