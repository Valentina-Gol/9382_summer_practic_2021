package Sort;

public class SortTest {
    protected int[] testArr1 = new int[0];
    protected int[] testArr2 = new int[] {10, 100, 0, 34, 45, 20, 1, 90, 34, 56};
    protected int[] testArr3 = new int[] {80, 49, 94, 56, 44, 93, 68, 90, 58, 28, 65,
            60, 89, 20, 62, 82, 84, 69, 91, 22, 47, 91, 85, 10, 97, 55, 10, 97, 54, 8,
                70, 33, 57, 63, 89, 100, 55, 56, 89, 13, 84, 54, 73, 73, 73, 34, 54, 57, 3, 44,
                    78, 49, 35, 63, 59, 32, 17, 68, 29, 70, 75, 98, 3, 31, 60, 91, 30, 15, 47, 19, 27,
                        31, 73, 100, 3, 45, 33, 57, 2, 36, 1, 80, 85, 36, 42, 43, 68, 59, 10, 96, 28, 85, 93,
                            31, 15, 52, 21, 45, 67, 68};
    protected int[] resArr1 = new int[0];
    protected int[] resAsArr2 = new int[] { 0, 1,10, 20, 34, 34, 45, 56, 90, 100};
    protected int[] resDesArr2 = new int[] { 100, 90, 56, 45, 34, 34, 20,10, 1, 0};
    protected int[] resAsArr3 = new int[] { 1, 2, 3, 3, 3, 8, 10, 10, 10, 13, 15, 15,
            17, 19, 20, 21, 22, 27, 28, 28, 29, 30, 31, 31, 31, 32, 33, 33, 34, 35, 36,
                36, 42, 43, 44, 44, 45, 45, 47, 47, 49, 49, 52, 54, 54, 54, 55, 55, 56, 56, 57,
                    57, 57, 58, 59, 59, 60, 60, 62, 63, 63, 65, 67, 68, 68, 68, 68, 69, 70, 70, 73, 73,
                        73, 73, 75, 78,80, 80, 82, 84, 84, 85, 85, 85, 89, 89, 89, 90, 91, 91, 91, 93, 93, 94,
                            96, 97, 97, 98, 100, 100};
    protected int[] resDesArr3 = new int[] { 100, 100, 98, 97, 97, 96, 94, 93, 93, 91,
            91, 91, 90, 89, 89, 89, 85, 85, 85, 84, 84, 82, 80,80, 78, 75, 73, 73, 73, 73, 70,
                70, 69, 68, 68, 68, 68, 67, 65, 63, 63, 62, 60, 60, 59, 59, 58, 57, 57, 57, 56, 56, 55,
                    55, 54, 54, 54, 52, 49, 49, 47, 47, 45, 45, 44, 44, 43, 42, 36, 36, 35, 34, 33, 33, 32, 31,
                        31, 31, 30, 29, 28, 28, 27, 22, 21, 20, 19, 17, 15, 15, 13, 10, 10, 10, 8, 3, 3, 3, 2, 1};
    
    public void testAscending(){}
    public void testDescending(){}
}
