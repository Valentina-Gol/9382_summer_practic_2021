package logic.ArrayManager;

import java.util.ArrayList;
import java.util.List;

public class ArrayHandler {
    public static int[] createArray(int arrayLen, int maxNumber, int minNumber){
        int[] array = new int[arrayLen];
        try{
            for (int i = 0; i < arrayLen; i++){
                array[i] = (int)(Math.random()*maxNumber) + minNumber;
            }
        } catch(NumberFormatException e){
            System.out.println("Wrong number format");
        } catch (Exception e){
            System.out.println("Negative array length");
        }
        return  array;
    }

    public static int[] splitArrayFromString(String str){
        int[] arr = null;
        String[] arrOfStr = str.split(" ");
        arr = new int[arrOfStr.length];
        try {
            for (int i = 0; i < arrOfStr.length; i++) {
                arr[i] = Integer.parseInt(arrOfStr[i]);
            }
            if (arr.length > 100){
                throw new Exception("Too much size of the array");
            }
        } catch (NumberFormatException e){
            System.out.println("Wrong number format");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return arr;
    }
}
