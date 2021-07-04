/**
 * Класс для шейкерной сортировки, хранит массив и текущие элементы для сравнения в нём
 */
public class Shaker{
    /**
     * elem1, elem2 - текущие номера элементов в массиве для сравнения
    */
    private int elem1 = 0;
    private int elem2 = 0;
    private int[] array = null;

    public static void main(String[] args){
    }

    public Shaker(int[] arr){
        this.array = arr;
    }

    public int[] getArray(){
        return this.array;
    }

    public int getElem1(){
        return this.elem1;
    }

    public int getElem2(){
        return this.elem2;
    }

    /**
     * Метод сортировки массива по возрастанию элементов
     * @param array массив для сортировки
     * @return возвращает массив чисел типа int
     */
    public int[] shakerSortAscending(){
        int i = 0, j = 0;
        int count = 0;
        while (count != array.length / 2){
            while (i < array.length - 1 - count){
                elem1 = array[i];
                elem2 = array[i+1];
                if (array[i + 1] < array[i]) {
                    int current = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = current;
                }
                i++;
            }
            while (i > count){
                elem1 = array[i - 1];
                elem2 = array[i];
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
     * @param array массив для сортировки
     * @return возвращает массив чисел типа int
     */
    public int[] shakerSortDescending(){
        int i = 0, j = 0;
        int count = 0;
        while (count != array.length / 2){
            while (i < array.length - 1 - count){
                elem1 = array[i];
                elem2 = array[i+1];
                if (array[i + 1] > array[i]) {
                    int current = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = current;
                }
                i++;
            }
            while (i > count){
                elem1 = array[i - 1];
                elem2 = array[i];
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
