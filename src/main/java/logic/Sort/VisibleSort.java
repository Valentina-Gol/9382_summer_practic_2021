package main.java.logic.Sort;

import main.java.logic.DataClass;

import javax.swing.*;
import java.awt.*;

public class VisibleSort extends JPanel{
    DataClass arrneedsort;
    VisibleSort() {
        arrneedsort = DataClass.getInstance();
    }


    public void paint(Graphics g) {
        g.clearRect(0, 0, 1500,800);



        for (int i = 0; i < arrneedsort.leg(); i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i*10+100,(500-(arrneedsort.get(i)*4)),10, arrneedsort.get(i)*4);
        }

    }

}
 