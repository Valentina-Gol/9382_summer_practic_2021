package Sort;

import Sort.Comb;
import org.junit.Assert;
import java.lang.Math;

import java.util.Arrays;
import org.junit.Test;

public class CombTest {

    @Test
    public void sortAscending() {
        int[] arr1 = new int[0];
        int[] arr2 = new int[10];
        int[] arr3 = new int[100];
        for (int i = 0; i < 100; i++){
            if (i < 10){
                arr2[i] = (int)(Math.random()*2000) - 1000;
            }
            arr3[i] = (int)(Math.random()*2000) - 1000;
        }
        int[] arr1ResAuto = arr1.clone();
        int[] arr2ResAuto = arr2.clone();
        int[] arr3ResAuto = arr3.clone();
        Arrays.sort(arr1ResAuto);
        Arrays.sort(arr2ResAuto);
        Arrays.sort(arr3ResAuto);

        int[] arr1ResProg = new Comb(arr1).sortAscending();
        int[] arr2ResProg = new Comb(arr2).sortAscending();
        int[] arr3ResProg = new Comb(arr3).sortAscending();
        Assert.assertArrayEquals(arr1ResAuto, arr1ResProg);
        Assert.assertArrayEquals(arr2ResAuto, arr2ResProg);
        Assert.assertArrayEquals(arr3ResAuto, arr3ResProg);
    }

    @Test
    public void sortDescending() {
        int[] arr1 = new int[0];
        int[] arr2 = new int[10];
        int[] arr3 = new int[100];
        for (int i = 0; i < 100; i++){
            if (i < 10){
                arr2[i] = (int)(Math.random()*2000) - 1000;
            }
            arr3[i] = (int)(Math.random()*2000) - 1000;
        }
        int[] arr1ResAuto = arr1.clone();
        int[] arr2ResAuto = arr2.clone();
        int[] arr3ResAuto = arr3.clone();
        Arrays.sort(arr1ResAuto);
        Arrays.sort(arr2ResAuto);
        Arrays.sort(arr3ResAuto);
        int arr2Len = arr2ResAuto.length;
        for (int i = 0; i < arr2Len / 2; i++){
            int current = arr2ResAuto[i];
            arr2ResAuto[i] = arr2ResAuto[arr2Len - i - 1];
            arr2ResAuto[arr2Len - i - 1] = current;
        }
        int arr3Len = arr3ResAuto.length;
        for (int i = 0; i < arr3Len / 2; i++){
            int current = arr3ResAuto[i];
            arr3ResAuto[i] = arr3ResAuto[arr3Len - i - 1];
            arr3ResAuto[arr3Len - i - 1] = current;
        }
        int[] arr1ResProg = new Comb(arr1).sortDescending();
        int[] arr2ResProg = new Comb(arr2).sortDescending();
        int[] arr3ResProg = new Comb(arr3).sortDescending();
        Assert.assertArrayEquals(arr1ResAuto, arr1ResProg);
        Assert.assertArrayEquals(arr2ResAuto, arr2ResProg);
        Assert.assertArrayEquals(arr3ResAuto, arr3ResProg);
    }
}
