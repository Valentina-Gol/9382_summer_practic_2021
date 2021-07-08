package logic;

import logic.Sort.Sort;

public class DataClass {
    public int[] mainArray = null;
    public Sort sort = null;
    public int speed = 24;
//    private int elem1 = -1;
//    private int elem2 = -1;

    private static DataClass dataClass = new DataClass();
    private DataClass() {}
    public static DataClass getInstance() {
        return dataClass;
    }
}
