package GUI;

import GUI.Listeners.ExportButtonListener;
import GUI.Listeners.InputButtonListener;
import GUI.Listeners.SortButtonListener;
import GUI.Listeners.SpeedButtonListener;

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
        importBox.addActionListener(new InputButtonListener());
        //export
        JButton exportButton = new JButton("export");
        layConstraints = getGridBagConstraints(1, 2, 1);
        leftPanel.add(exportButton, layConstraints);
        exportButton.addActionListener(new ExportButtonListener());


        //Type of sort
        String[] sortItems = {"Choose type of sorting", "Odd-Even sorting", "Brush sorting", "Shaker sorting"};
        JComboBox sortBox = new JComboBox(sortItems);
        layConstraints = getGridBagConstraints(3, 1, 2);
        leftPanel.add(sortBox, layConstraints);
        sortBox.addActionListener(new SortButtonListener());

        //Speed
        JLabel speedLabel = new JLabel("Choose speed of auto sort");
        layConstraints = getGridBagConstraints(5, 1, 2);
        leftPanel.add(speedLabel, layConstraints);

        JSlider speedSlider = new JSlider(1, 4, 1);
        speedSlider.addChangeListener(new SpeedButtonListener());
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

        JPanel playerPanel = new JPanel(new GridLayout(1, 3, 5, 0) );
        var gridLayout = new GridBagLayout();
        gridLayout.rowHeights = layout.rowHeights;
        gridLayout.rowWeights = layout.rowWeights;
        gridLayout.rowWeights[gridLayout.rowWeights.length - 1] = Double.MIN_VALUE;
        gridLayout.columnWeights = layout.columnWeights;

        rightPanel.setLayout(gridLayout);

        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        downPanel.add(playerPanel, BorderLayout.NORTH);
        layConstraints = getGridBagConstraints(0,0,1);
        rightPanel.add(downPanel, layConstraints);
        //reset
        JButton resetButton = new JButton("reset");
        playerPanel.add(resetButton);

        //play
        JButton nextButton = new JButton("next");
        playerPanel.add(nextButton);

        //next
        JButton playButton = new JButton("play");
        playerPanel.add(playButton);

        frame.setSize(900, 670);
        frame.setMinimumSize(new Dimension(900, 670));
        frame.getContentPane().add(mainPanel, BorderLayout.WEST);
        pack();


        //Прокрутка
        JTextArea textArea = new JTextArea("");
        textArea.setSize(400,400);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        layConstraints = getGridBagConstraints(10, 1, 2);
        layConstraints.gridheight = 20;
        leftPanel.add(scroll, layConstraints);

    // РАБОЧАЯ ОБЛАСТЬ
       // var workpan = new Comb();
      //  layConstraints = getGridBagConstraints(1,0,1);
       // layConstraints.gridheight = 50;
      //  rightPanel.add(workpan,layConstraints);
        frame.setVisible(true);

    }
}