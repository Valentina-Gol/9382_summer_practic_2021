package GUI.Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event){

        JComboBox comboBox = (JComboBox) event.getSource();

        // Print the selected items and the action command.
        Object selected = comboBox.getSelectedItem();

        System.out.println("Selected Item  = " + selected);

        }

}

