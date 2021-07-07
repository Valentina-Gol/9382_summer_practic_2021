package GUI.Listeners;

import logic.ArrayManager.ArrayHandler;
import logic.DataClass;
import logic.FileManager.FileManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        int[] arr = null;
        JComboBox comboBox = (JComboBox) event.getSource();
        // Print the selected items and the action command.
        Object selected = comboBox.getSelectedItem();
        try {
            if (selected == "Import from the file") {
                JFrame jFrame = new JFrame();
                String fileName = null;
                fileName = JOptionPane.showInputDialog(jFrame, "Введите имя файла");
                arr = FileManager.fileInput(fileName);
            } else if (selected == "Create an array randomly") {


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
