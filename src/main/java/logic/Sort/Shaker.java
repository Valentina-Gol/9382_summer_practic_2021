package logic.Sort;

import logic.DataClass;

/**
 * Класс для шейкерной сортировки, хранит массив и текущие элементы для сравнения в нём
 */
public class Shaker implements Sort {
    /**
     * Метод сортировки массива по возрастанию элементов
     * @return возвращает массив чисел типа int
     */
    public int[] sortAscending(int[] array){
        int i = 0;
        int count = 0;
        while (count != array.length / 2){
            while (i < array.length - 1 - count){
                DataClass.getInstance().elem1 = array[i];
                DataClass.getInstance().elem2 = array[i + 1];
                if (array[i + 1] < array[i]) {
                    int current = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = current;
                }
                i++;
            }
            while (i > count){
                DataClass.getInstance().elem1 = array[i - 1];
                DataClass.getInstance().elem2 = array[i];
                if (array[i - 1] > array[i]) {
                    int current = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = current;
                }
                i--;
            }
            count++;
            i = count;
        }
        return array;
    }

    /**
     * Метод сортировки массива по убыванию элементов
     * @return возвращает массив чисел типа int
     */
    public int[] sortDescending(int[] array){
        int i = 0;
        int count = 0;
        while (count != array.length / 2){
            while (i < array.length - 1 - count){
//                elem1 = array[i];
//                elem2 = array[i+1];
                if (array[i + 1] > array[i]) {
                    int current = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = current;
                }
                i++;
            }
            while (i > count){
//                elem1 = array[i - 1];
//                elem2 = array[i];
                if (array[i - 1] < array[i]) {
                    int current = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = current;
                }
                i--;
            }
            count++;
            i = count;
        }
        return array;
    }
}