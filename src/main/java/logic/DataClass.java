package logic;

import logic.Sort.Sort;

public class DataClass {

    private static DataClass dataClass = new DataClass();


    private DataClass() {
    }

    public static DataClass getInstance() {

        return dataClass;
    }

    public int[] mainArray = {3, 67, 12 , 78, 3, 6, 67, 34, 25, 7, 8};
    public Sort sort;
    public int speed;
//    private int elem1 = -1;
//    private int elem2 = -1;

    public int get(int i) {

        return mainArray[i];
    }

    public void set(int temp, int i) {

        mainArray[i] = temp;
    }
    public int leg(){
        return mainArray.length;
    }
}
