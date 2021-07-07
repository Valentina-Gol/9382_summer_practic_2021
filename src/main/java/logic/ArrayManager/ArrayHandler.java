package logic.ArrayManager;

public class ArrayHandler {
    public static int[] createArray(int arrayLen, int maxNumber, int minNumber){
        int[] array = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++){
            array[i] = (int)(Math.random()*maxNumber) + minNumber;
        }
        return  array;
    }
}
