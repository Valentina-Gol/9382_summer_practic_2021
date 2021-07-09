package GUI.Listeners;

import logic.DataClass;
import logic.MyLogger.TheBestLogger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedButtonListener implements ChangeListener {
    public void stateChanged(ChangeEvent changeEvent) {
        Object source = changeEvent.getSource();
        if (source instanceof JSlider) {
            JSlider slider = (JSlider) source;
            int value = slider.getValue();
            if (value == 1) {
                DataClass.getInstance().speed = 48;
            } else if (value == 2) {
                DataClass.getInstance().speed = 24;
            } else if (value == 3) {
                DataClass.getInstance().speed = 10;
            } else if (value == 4) {
                DataClass.getInstance().speed = 1;
            } else {
                TheBestLogger.getInstance().logException("invalid value");
            }
        }
    }
}