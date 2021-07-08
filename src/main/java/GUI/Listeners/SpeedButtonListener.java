package main.java.GUI.Listeners;

import main.java.logic.DataClass;

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
                DataClass.getInstance().speed = 24;
            } else if (value == 2) {
                DataClass.getInstance().speed = 12;
            } else if (value == 3) {
                DataClass.getInstance().speed = 8;
            } else if (value == 4) {
                DataClass.getInstance().speed = 6;
            } else {
                System.out.println("invalid value");
            }
        }
    }
}