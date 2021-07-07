package GUI.Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IOButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {

        JComboBox comboBox = (JComboBox) event.getSource();

        // Print the selected items and the action command.
        Object selected = comboBox.getSelectedItem();
        if (selected == "Import from the file"){

        } else if (selected == "Create an array randomly"){

        } else if (selected == "Set array"){
            
        }
    }
}
