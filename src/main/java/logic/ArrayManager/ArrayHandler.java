package logic.ArrayManager;

import java.util.ArrayList;
import java.util.List;

/**
 * класс реализующий вспомощательный методы для работы с массивом целых чисел
 */
public class ArrayHandler {
    /**
     * генерирует массив случайных чисел определённой длины из выбранного интервала
     * @param arrayLen длина массива для генерации
     * @param maxNumber верхняя граница чисел
     * @param minNumber нижняя граница чисел
     * @return возвращает сгенериованный массив целых чисел
     */
    public static int[] createArray(int arrayLen, int minNumber, int maxNumber){
        int[] array = new int[arrayLen];
        if (maxNumber < minNumber){
            System.out.println("Min array border more than maxborder");
            System.out.println("Swap borders!");
            int current = minNumber;
            minNumber = maxNumber;
            maxNumber = current;
        }
        try{
            for (int i = 0; i < arrayLen; i++){
                array[i] = (int)(Math.random()*maxNumber) + minNumber;
            }
        } catch(NumberFormatException e){
            System.out.println("Wrong number format");
        } catch (NegativeArraySizeException e){
            System.out.println("Negative array length");
        }
        return  array;
    }

    /**
     * извлекает из строки целые числа, записанные черз пробел
     * @param str строка с целыми числами, записанными через пробел
     * @return возвращает извлеченный массив
     */
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
