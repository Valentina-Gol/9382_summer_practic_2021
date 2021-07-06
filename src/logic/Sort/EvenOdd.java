package src.logic.Sort;
/**
 * Класс для сортировки чёт-нечёт, хранит массив и текущие элементы для сравнения в нём
 */
public class EvenOdd implements Sort {
    /**
     * Метод сортировки массива по возрастанию элементов
     * @return возвращает массив чисел типа int
     */
    @Override
    public int[] sortAscending(int[] arr) {
    int arrLen = arr.length; //длина массива
        for (int i = 0; i < arrLen; i++) {
            // (i % 2) ? 0 : 1 возвращает 0, если i четное, 1, если i не четное
            for (int j = (i % 2 == 0) ? 0 : 1; j < arrLen - 1; j += 2) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    /**
     * Метод сортировки массива по убыванию элементов
     * @return возвращает массив чисел типа int
     */
    @Override
    public int[] sortDescending(int[] arr) {
        int arrLen = arr.length; //длина массива
        for (int i = 0; i < arrLen; i++) {
            // (i % 2) ? 0 : 1 возвращает 0, если i четное, 1, если i не четное
            for (int j = (i % 2 == 0) ? 0 : 1; j < arrLen - 1; j += 2) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
