package Sort;
import java.lang.Math;

public class Comb extends Sort{

    public Comb(int[] arr){
        this.array = arr;
    }

    /**
     * Метод сортировки массива по возрастанию элементов
     * @return возвращает массив чисел типа int
     */
    public int[] sortAscending(){
        int gap = array.length;
        int j;
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));  // minimum gap is 1
            for (int i = 0; i < array.length - gap; i++){
                j = i + gap;
                elem1 = array[i];
                elem2 = array[j];
                if (array[i] > array[j]){
                    int current = array[i];
                    array[i] = array[j];
                    array[j] = current;
                }
            }
        }
        return array;
    }

    /**
     * Метод сортировки массива по убыванию элементов
     * @return возвращает массив чисел типа int
     */
    public int[] sortDescending(){
        int gap = array.length;
        int j;
        while (gap > 1){
            gap = Math.max(1, (int)(gap / 1.25));  // minimum gap is 1
            for (int i = 0; i < array.length - gap; i++){
                j = i + gap;
                elem1 = array[i];
                elem2 = array[j];
                if (array[i] < array[j]){
                    int current = array[i];
                    array[i] = array[j];
                    array[j] = current;
                }
            }
        }
        return array;
    }
}
