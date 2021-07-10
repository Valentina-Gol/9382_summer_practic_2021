package GUI;

import GUI.Listeners.*;
import logic.DataClass;
import logic.MyLogger.TheBestLogger;
import logic.Sort.StateMachine;
import org.apache.log4j.BasicConfigurator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleGui extends javax.swing.JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JTextArea textArea = new JTextArea("");
    JButton nextButton;
    JButton playButton;
    private JFrame frame = new JFrame("Program");
    private StateMachine stateMachine = new StateMachine();
    private boolean isFirstTime = true;


    //Singleton!
    private static SimpleGui simpleGui = new SimpleGui();
    private SimpleGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();
        //***************************** Настройка менюшки справа *************************************//
        GridBagConstraints layConstraints;
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        leftPanel.setBorder(new EmptyBorder(4, 4, 4, 4)); // отступ внутри панели на 4 пикселя со всех сторон
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23}; // высоты кнопок
        layout.rowWeights = new double[26];
        layout.rowWeights[layout.rowWeights.length - 1] = Double.MIN_VALUE;
        layout.columnWeights = new double[]{1.0};

        frame.getContentPane().add(splitPane);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(300);                    // the initial position of the divider is 200 (our window is 400 pixels high)
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

        /*
         * Первые два параметра конструктора GridLayout определяют количество
         * строк и столбцов в таблице. Вторые 2 параметра - расстояние между
         * ячейками по горизонтали и вертикали
         */

        JPanel playerPanel = new JPanel(new GridLayout(1, 3, 5, 0));
        var gridLayout = new GridBagLayout();
        gridLayout.rowHeights = layout.rowHeights;
        gridLayout.rowWeights = layout.rowWeights;
        gridLayout.rowWeights[gridLayout.rowWeights.length - 1] = Double.MIN_VALUE;
        gridLayout.columnWeights = layout.columnWeights;

        rightPanel.setLayout(gridLayout);

        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        downPanel.add(playerPanel, BorderLayout.NORTH);
        layConstraints = getGridBagConstraints(0, 0, 1);
        rightPanel.add(downPanel, layConstraints);
        //reset
        JButton resetButton = new JButton("reset");
        resetButton.addActionListener(new ResetButtonListener());
        playerPanel.add(resetButton);

        //play
        playButton = new JButton("play");
        playButton.addActionListener(new PlayListener());
        playerPanel.add(playButton);

        //next
        nextButton = new JButton("next");
        nextButton.addActionListener(new NextButtonListener());
        playerPanel.add(nextButton);

        frame.setSize(1500, 700);
        frame.setMinimumSize(new Dimension(1500, 700));
        frame.getContentPane().add(mainPanel, BorderLayout.SOUTH);
        pack();

        //Прокрутка
        textArea.setSize(400, 400);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        /*Appender defaultAppender = Logger.getRootLogger().getAppender("app");
        defaultAppender = new WriterAppender(layout, textArea);
        writerAppender.append(event);
        logList.add(stringWriter.toString());*/

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        layConstraints = getGridBagConstraints(10, 1, 2);
        layConstraints.gridheight = 20;
        leftPanel.add(scroll, layConstraints);
        frame.setVisible(true);
    }
    public static SimpleGui getInstance() {
        return simpleGui;
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
        BasicConfigurator.configure();
        SimpleGui s = SimpleGui.getInstance();
    }

    public static void addInTextArea(String s){
        simpleGui.textArea.append(s + "\n");
    }

    public void showSort() {
        var layConstraints = getGridBagConstraints(1, 0, 1);
        layConstraints.gridheight = 50;
        rightPanel.add(stateMachine.currentState, layConstraints);
        setEnabledLeftPanel(false);
    }
    public void setEnabledLeftPanel(boolean flag) {
        for (var i = 0; i < leftPanel.getComponentCount();i++) {
            leftPanel.getComponent(i).setEnabled(flag);
        }
    }

    public class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            DataClass sources = DataClass.getInstance();
            try {
                if (!(sources.sort == null || sources.mainArray == null)) {
                    if (isFirstTime) {
                        stateMachine.initStateMachine(0);
                        showSort();
                        isFirstTime = false;
                        playButton.setEnabled(false);
                    }
                    if (stateMachine.doStep()) {
                        TheBestLogger.getInstance().logInfo("Step is done");
                    } else
                        TheBestLogger.getInstance().logException("Sort is finished");
                }
            } catch (Exception e) {
                TheBestLogger.getInstance().logInfo("NextButton");
            }
            frame.setVisible(true);
        }
    }

    public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            DataClass sources = DataClass.getInstance();
            try {
                if (!(sources.sort == null || sources.mainArray == null)) {
                    stateMachine.initStateMachine(DataClass.getInstance().speed);
                    showSort();
                    nextButton.setEnabled(false);
                }
            } catch (Exception e) {
                TheBestLogger.getInstance().logInfo("PlayButton");
            }
            frame.setVisible(true);
        }
    }
}
