package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SimpleGui extends javax.swing.JFrame {
    private  JPanel inputPanel;
    private  JSplitPane splitPane;

    public SimpleGui() {
    }

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
        splitPane = new JSplitPane();
        //***************************** Настройка менюшки справа *************************************//
        GridBagConstraints layConstraints;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        leftPanel.setBorder(new EmptyBorder(4, 4, 4, 4)); // отступ внутри панели на 4 пикселя со всех сторон
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23}; // высоты кнопок
        layout.rowWeights = new double[26];
        layout.rowWeights[layout.rowWeights.length - 1] = Double.MIN_VALUE;
        layout.columnWeights = new double[] {1.0};

        frame.getContentPane().add(splitPane);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(250);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(leftPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(rightPanel);
        leftPanel.setLayout(layout);

        //import
        String[] importItems = {"Create array", "Import from the file", "Create an array randomly", "Set array"};
        JComboBox importBox = new JComboBox(importItems);
        layConstraints = getGridBagConstraints(1, 1, 1);
        leftPanel.add(importBox, layConstraints); // добавление кнопки на панель с учётом разметки

        //export
        JButton exportButton = new JButton("export");
        layConstraints = getGridBagConstraints(1, 2, 1);
        leftPanel.add(exportButton, layConstraints);


        //Type of sort
        String[] sortItems = {"Choose type of sorting", "Odd-Even sorting", "Brush sorting", "Shaker sorting"};
        JComboBox sortBox = new JComboBox(sortItems);
        layConstraints = getGridBagConstraints(3, 1, 2);
        leftPanel.add(sortBox, layConstraints);

        //Speed
        JLabel speedLabel = new JLabel("Choose speed of auto sort");
        layConstraints = getGridBagConstraints(5, 1, 2);
        leftPanel.add(speedLabel, layConstraints);

        JSlider speedSlider = new JSlider(1, 4, 1);
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setMajorTickSpacing(1);
        layConstraints = getGridBagConstraints(6, 1, 2);
        leftPanel.add(speedSlider, layConstraints);
        //Start sorting
        JButton startButton = new JButton("Start sorting");
        layConstraints = getGridBagConstraints(8, 1, 2);
        leftPanel.add(startButton, layConstraints);

        /*
         * Первые два параметра конструктора GridLayout определяют количество
         * строк и столбцов в таблице. Вторые 2 параметра - расстояние между
         * ячейками по горизонтали и вертикали
         */
        JPanel sortPanel = new JPanel();
        JPanel playerPanel = new JPanel(new GridLayout(1, 3, 5, 0) );
        rightPanel.setLayout( new FlowLayout(FlowLayout.CENTER));
        rightPanel.add(sortPanel, BorderLayout.NORTH);
        rightPanel.add(playerPanel, BorderLayout.SOUTH);
        //reset
        JButton resetButton = new JButton("reset");
 //       layConstraints = getGridBagConstraints(24,  1, 1);
        playerPanel.add(resetButton);

        //play
        JButton nextButton = new JButton("next");
//        layConstraints = getGridBagConstraints(24, 2, 1);
        playerPanel.add(nextButton);

        //next
        JButton playButton = new JButton("play");
//        layConstraints = getGridBagConstraints(25, 1, 2);
        playerPanel.add(playButton);

        frame.getContentPane().setBackground(Color.RED);
        frame.setSize(900, 670);
        frame.setMinimumSize(new Dimension(900, 670));
        frame.getContentPane().add(mainPanel, BorderLayout.WEST);
        pack();
        frame.setVisible(true);

    }
}