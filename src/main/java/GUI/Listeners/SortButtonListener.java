package main.java.GUI.Listeners;

import main.java.logic.DataClass;
import main.java.logic.Sort.Comb;
import main.java.logic.Sort.EvenOdd;
import main.java.logic.Sort.Shaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event){
        int[]arr = null;
        JComboBox comboBox = (JComboBox) event.getSource();
        Object selected = comboBox.getSelectedItem();

        try {
            if (selected == "Odd-Even sorting") {
                DataClass.getInstance().sort = new EvenOdd();
            } else if (selected == "Brush sorting") {
                DataClass.getInstance().sort = new Comb();
            } else if (selected == "Shaker sorting") {
                DataClass.getInstance().sort = new Shaker();
            }
        } catch(Exception e){
            System.out.println("Nothing entered");
        }




        //System.out.println("Selected Item  = " + selected);

        }

}

