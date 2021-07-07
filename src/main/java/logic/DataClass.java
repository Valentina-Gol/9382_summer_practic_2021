package logic;

/**
 * класс для хранения массива для сортировки
 * реализован с помщью паттерна Singleton
 */
public class DataClass {

    private static DataClass dataClass = new DataClass( );

    private DataClass() { }

    public static DataClass getInstance( ) {
        return dataClass;
    }

    public int[] mainArray = null;
    public int elem1 = -1;
    public int elem2 = -1;

}
