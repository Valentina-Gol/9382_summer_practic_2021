package GUI.Listeners;

import logic.DataClass;
import logic.FileManager.FileManager;
import logic.MyLogger.TheBestLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExportButtonListener implements ActionListener {
    /**
     * реализует функционал нажатия на кнопку экспорта(сохранение массива)
     * @param event объект класса события
     */
    public void actionPerformed(ActionEvent event){
        try {
            JFrame frame = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(frame);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                FileManager.fileOutput(file, DataClass.getInstance().mainArray);
            } else {
                TheBestLogger.getInstance().logInfo("Nothing entered");
            }
        } catch(Exception e){
            TheBestLogger.getInstance().logInfo("Nothing entered");
        }
    }
}
