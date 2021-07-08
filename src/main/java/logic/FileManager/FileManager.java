package logic.FileManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final Logger log = Logger.getLogger(FileManager.class);
    /**
     * читает из файла числа, записанные по одному в строке
     * @param file объект файла для чтения чисел
     * @return массив типа int
     */
    public static int[] fileInput(File file) {
        List<Integer> arrayL = new ArrayList<Integer>();
        //File file = new File(filename);
        int[] array = new int[0];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null) {
                arrayL.add(Integer.parseInt(text));
            }
            array = new int[arrayL.size()];
            for (int i = 0; i < arrayL.size(); i++) {
                array[i] = arrayL.get(i);
            }
        } catch (FileNotFoundException e) {
            log.error("File not found");
            System.out.println("File not found");
        } catch (IOException e) {
            log.error("IO trouble");
            System.out.println("IO trouble");
        } catch (NumberFormatException e) {
            log.error("Bad number format");
            System.out.println("Bad number format");
        } catch (Exception e) {
            log.error("Some trouble when reading a file");
            System.out.println("Some trouble when reading a file");
        }
        if (array.length > 100){
            System.out.println("Too much size of the array");
            return new int[0];
        }
        return array;
    }

    /**
     * производит запись массива чисел типа int в файл
     * @param file объект файла для сохранения
     * @param array массив чисел для сохранения
     * @return true, если запись чисел в айл произошла успешно, false в противном случае
     */
    public static boolean fileOutput(File file, int[] array) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < array.length; i++){
                myWriter.write(String.format("%d\n", array[i]));
            }
            myWriter.close();
            return true;
        } catch (IOException e) {
            log.error("An error when writing in file");
            System.out.println("An error when writing in file");
            return false;
        }
    }
}
