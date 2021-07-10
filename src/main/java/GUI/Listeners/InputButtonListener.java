package GUI.Listeners;

import logic.ArrayManager.ArrayHandler;
import logic.DataClass;
import logic.FileManager.FileManager;
import logic.MyLogger.TheBestLogger;
import GUI.SimpleGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    private int[] arr = null;

    public void actionPerformed(ActionEvent event) {
        //int[] arr = null;
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
                    TheBestLogger.getInstance().logInfo("Nothing entered");
                }
            } else if (selected == "Create an array randomly") {
                JFrame frame = new JFrame();
                JTextField firstName = new JTextField();
                JTextField lastName = new JTextField();
                JTextField password = new JTextField();
                final JComponent[] inputs = new JComponent[] {
                        new JLabel("Количество элементов"),
                        firstName,
                        new JLabel("Нижняя граница"),
                        lastName,
                        new JLabel("Верхняя граница"),
                        password
                };
                int result = JOptionPane.showConfirmDialog(null, inputs, "Input data", JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int[] arr1 = ArrayHandler.splitArrayFromString(firstName.getText());
                    int[] arr2 = ArrayHandler.splitArrayFromString(lastName.getText());
                    int[] arr3 = ArrayHandler.splitArrayFromString(password.getText());
                    if ((arr1.length == 1) && (arr1[0] <= 100)){
                        if ((arr2.length == 1)){
                            if (arr3.length == 1){
                                arr =  ArrayHandler.createArray(arr1[0], arr2[0], arr3[0]);
                            } else{
                                TheBestLogger.getInstance().logInfo("Incorrect count value");
                                JOptionPane.showMessageDialog(null, "Некорректное количество элементов");
                            }
                        } else{
                            TheBestLogger.getInstance().logInfo("Incorrect min border value");
                            JOptionPane.showMessageDialog(null, "Некорректная нижняя граница");
                        }
                    } else{
                        TheBestLogger.getInstance().logInfo("Incorrect max border value");
                        JOptionPane.showMessageDialog(null, "Некорректная верхняя граница");
                    }
                }
            } else if (selected == "Set array") {
                JFrame jFrame = new JFrame();
                String arrayString = null;
                jFrame.add(new TextArea());
                arrayString = JOptionPane.showInputDialog(jFrame, "Введите числа через пробел");
                arr = ArrayHandler.splitArrayFromString(arrayString);
            }
        } catch(Exception e){
            TheBestLogger.getInstance().logInfo("Nothing entered");
        }
        DataClass.getInstance().mainArray = arr;
    }

}
