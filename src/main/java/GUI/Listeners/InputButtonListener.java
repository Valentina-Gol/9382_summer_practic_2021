package GUI.Listeners;

import main.java.logic.ArrayManager.ArrayHandler;
import logic.DataClass;
import logic.FileManager.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InputButtonListener implements ActionListener {
    /**
     * реализует функционал нажатия на кнопку выбора ввода
     * можно выбрать:
     * ввод массива из файла
     * ввод массива в приложении
     * генерация массива в приложении
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        int[] arr = null;
        JComboBox comboBox = (JComboBox) event.getSource();
        // Print the selected items and the action command.
        Object selected = comboBox.getSelectedItem();
        try {
            if (selected == "Import from the file") {
                JFrame frame = new JFrame();
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    arr = FileManager.fileInput(file);
                } else {
                    System.out.println("Nothing entered");
                }
            } else if (selected == "Create an array randomly") {
                JFrame jFrame = new JFrame();
                String arrayString = null;
                arrayString = JOptionPane.showInputDialog(jFrame, "Введите три числа через пробел(кол-во элементов, нижняя и верхняя граница)");
                arr = ArrayHandler.splitArrayFromString(arrayString);
                arr = ArrayHandler.createArray(arr[0], arr[1], arr[2]);
            } else if (selected == "Set array") {
                JFrame jFrame = new JFrame();
                String arrayString = null;
                arrayString = JOptionPane.showInputDialog(jFrame, "Введите числа через пробел");
                arr = ArrayHandler.splitArrayFromString(arrayString);
            }
        } catch(Exception e){
            System.out.println("Nothing entered");
        }
        DataClass.getInstance().mainArray = arr;
    }

}
