package GUI.Listeners;

import logic.DataClass;
import logic.FileManager.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExportButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event){
        try {
            JFrame jFrame = new JFrame();
            String fileName = null;
            fileName = JOptionPane.showInputDialog(jFrame, "Введите имя файла");
            boolean flag = FileManager.CreateFile(fileName);

            if (!flag) {
                FileManager.fileOutput(fileName, DataClass.getInstance().mainArray);
            } else {
                System.out.println("Failed to save the result");
            }
        } catch(Exception e){
            System.out.println("Nothing entered");
        }
    }
}