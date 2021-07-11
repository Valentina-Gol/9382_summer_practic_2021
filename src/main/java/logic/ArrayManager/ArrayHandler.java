package logic.ArrayManager;

import logic.MyLogger.TheBestLogger;

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
            TheBestLogger.getInstance().logInfo("Min array border more than maxborder");
            TheBestLogger.getInstance().logInfo("Swap borders!");
            int current = minNumber;
            minNumber = maxNumber;
            maxNumber = current;
        }
        try{
            for (int i = 0; i < arrayLen; i++){
                array[i] = (int)(Math.random()*maxNumber) + minNumber;
            }
        } catch(NumberFormatException e){
            TheBestLogger.getInstance().logException("Wrong number format");
        } catch (NegativeArraySizeException e){
            TheBestLogger.getInstance().logException("Negative array length");
        }
        if (array.length > 100){
            TheBestLogger.getInstance().logException("Too much size of the array(max size is 100)");
            return new int[0];
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
                TheBestLogger.getInstance().logException("Too much size of the array(max size is 100)");
            }
        } catch (NumberFormatException e){
            TheBestLogger.getInstance().logException("Wrong number format");
        } catch (Exception e){
            TheBestLogger.getInstance().logException(e.getMessage());
        }
        return arr;
    }
}
