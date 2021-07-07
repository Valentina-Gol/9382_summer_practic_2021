package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SimpleGui {

    private GridBagConstraints getGridBagConstraints(int col, int row, int size) {
        GridBagConstraints layConstraints = new GridBagConstraints();
        layConstraints.fill = GridBagConstraints.BOTH; // заполняет ячейку целиком
        layConstraints.gridwidth = size;
        layConstraints.gridx = row; // координаты ячейки, в которую помещается кнопка
        layConstraints.gridy = col;
        return layConstraints;
    }

    public static void main(String[] args) {
        new SimpleGui().start();
    }

    public void start() {

        JFrame frame = new JFrame("Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //***************************** Настройка менюшки справа *************************************//
        GridBagConstraints layConstraints;

        JPanel eastPanel = new JPanel();
        JPanel eastPanel2 = new JPanel();
        eastPanel.setBorder(new EmptyBorder(4, 4, 4, 4)); // отступ внутри панели на 4 пикселя со всех сторон
        eastPanel2.setBorder(new EmptyBorder(4, 4, 4, 4)); // отступ внутри панели на 4 пикселя со всех сторон
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23}; // высоты кнопок
        layout.rowWeights = new double[26];
        layout.rowWeights[layout.rowWeights.length - 1] = Double.MIN_VALUE;
        layout.columnWeights = new double[] {1.0};
        eastPanel.setLayout(layout);

        //import
        String[] importItems = {"Create array", "Import from the file", "Create an array randomly", "Set array"};
        JComboBox importBox = new JComboBox(importItems);
        layConstraints = getGridBagConstraints(1, 1, 1);
        eastPanel.add(importBox, layConstraints); // добавление кнопки на панель с учётом разметки

        //export
        JButton exportButton = new JButton("export");
        layConstraints = getGridBagConstraints(1, 2, 1);
        eastPanel.add(exportButton, layConstraints);


        //Type of sort
        String[] sortItems = {"Choose type of sorting", "Odd-Even sorting", "Brush sorting", "Shaker sorting"};
        JComboBox sortBox = new JComboBox(sortItems);
        layConstraints = getGridBagConstraints(3, 1, 2);
        eastPanel.add(sortBox, layConstraints);

        //Speed
        String[] speedItems = {"Choose speed of auto sort", "x1", "x2", "x4"};
        JComboBox speedBox = new JComboBox(speedItems);
        layConstraints = getGridBagConstraints(5, 1, 2);
        eastPanel.add(speedBox, layConstraints);

        //Start sorting
        JButton startButton = new JButton("Start sorting");
        layConstraints = getGridBagConstraints(7, 1, 2);
        eastPanel.add(startButton, layConstraints);

        eastPanel2.setLayout(layout);
        //reset
        JButton resetButton = new JButton("reset");
        layConstraints = getGridBagConstraints(22,  1, 1);
        eastPanel2.add(resetButton, layConstraints);

        //play
        JButton nextButton = new JButton("next");
        layConstraints = getGridBagConstraints(22, 2, 1);
        eastPanel2.add(nextButton, layConstraints);

        //next
        JButton playButton = new JButton("play");
        layConstraints = getGridBagConstraints(23, 1, 2);
        eastPanel2.add(playButton, layConstraints);



        frame.setSize(900, 600);
        frame.setMinimumSize(new Dimension(900, 600));
        frame.getContentPane().add(eastPanel, BorderLayout.WEST);
        frame.getContentPane().add(eastPanel2, BorderLayout.LINE_END);
        frame.setVisible(true);

    }
}