package logic;

import logic.Sort.VisibleSort;

public class DataClass {
    public int[] mainArray = null;
    public VisibleSort sort;
    public int speed = 48;
    public int elem1 = -1;
    public int elem2 = -1;

    private static DataClass dataClass = new DataClass();
    private DataClass() {}
    public static DataClass getInstance() {
        return dataClass;
    }
}
