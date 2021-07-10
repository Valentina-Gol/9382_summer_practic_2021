package GUI.Listeners;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        DataClass sources = DataClass.getInstance();
        try {
            sources.sort.thread.interrupt();
            sources.sort.startSort(0);
        } catch (Exception e) {
            TheBestLogger.getInstance().logInfo("Nothing entered");
        }
    }
}