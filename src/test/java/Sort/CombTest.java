package Sort;

import org.junit.Assert;
import org.junit.Test;
import logic.SortAlgo.BrushAlgo;

public class CombTest extends tests.Sort.SortTest {

    @Test
    public void combSortAscending() {
        int[] arr1ResProg = new BrushAlgo().useSort(testArr1);
        int[] arr2ResProg = new BrushAlgo().useSort(testArr2);
        int[] arr3ResProg = new BrushAlgo().useSort(testArr3);
        Assert.assertArrayEquals(resArr1, arr1ResProg);
        Assert.assertArrayEquals(resAsArr2, arr2ResProg);
        Assert.assertArrayEquals(resAsArr3, arr3ResProg);
    }
}
