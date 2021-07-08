package logic;

import logic.Sort.Sort;

public class DataClass {

    private static DataClass dataClass = new DataClass();


    private DataClass() {
    }

    public static DataClass getInstance() {

        return dataClass;
    }

    public int[] mainArray = null;
    public Sort sort = null;
    public int speed = -1;
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
