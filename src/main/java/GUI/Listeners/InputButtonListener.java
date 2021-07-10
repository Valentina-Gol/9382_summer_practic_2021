package GUI.Listeners;

import logic.ArrayManager.ArrayHandler;
import logic.DataClass;
import logic.FileManager.FileManager;
import logic.MyLogger.TheBestLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class InputButtonListener implements ActionListener {

    class SwingControlDemo {
        private JFrame mainFrame;
        private JLabel headerLabel;
        private JLabel statusLabel;
        private JPanel controlPanel;

        public SwingControlDemo(){
            prepareGUI();
        }

        void prepareGUI(){
            mainFrame = new JFrame("Random array generation");
            mainFrame.setSize(1000,250);
            mainFrame.setLayout(new GridLayout(3, 1));

            mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    System.exit(0);
                }
            });
            headerLabel = new JLabel("", JLabel.CENTER);
            statusLabel = new JLabel("",JLabel.CENTER);
            statusLabel.setSize(350,100);

            controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());

            mainFrame.add(headerLabel);
            mainFrame.add(controlPanel);
            mainFrame.add(statusLabel);
            mainFrame.setVisible(true);
        }
        public void showTextFieldDemo(){
            headerLabel.setText("Введите значения для генерации массива");

            JLabel  namelabel= new JLabel("Количество элементов: ", JLabel.RIGHT);
            JLabel  passwordLabel = new JLabel("Нижняя граница: ", JLabel.CENTER);
            JLabel  pLabel = new JLabel("Верхняя граница: ", JLabel.LEFT);

            final JTextField userText = new JTextField(6);
            final JTextField passwordText = new JTextField(6);
            final JTextField pText = new JTextField(6);
            JButton loginButton = new JButton("Проверить");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int[] arr1 = ArrayHandler.splitArrayFromString(userText.getText());
                    int[] arr2 = ArrayHandler.splitArrayFromString(passwordText.getText());
                    int[] arr3 = ArrayHandler.splitArrayFromString(pText.getText());
                    //for (int i = 0; i < arr1.length; i++){System.out.println(arr1[i]);}

                    String data = "Количество элементов " + userText.getText() + " (" + (((arr1.length == 1) && (arr1[0] <= 100)) ? "OK" : "BAD") + ")";
                    data += ", Нижняя граница: " + new String(passwordText.getText()) + " (" + ((arr2.length == 1) ? "OK" : "BAD") + ") "
                            + ", Верхняя граница: " + new String(pText.getText()) + " (" + ((arr3.length == 1) ? "OK" : "BAD") + ")";
                    statusLabel.setText(data);
                }
            });
            JButton createButton = new JButton("Сгенерировать");
            createButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int[] arr1 = ArrayHandler.splitArrayFromString(userText.getText());
                    int[] arr2 = ArrayHandler.splitArrayFromString(passwordText.getText());
                    int[] arr3 = ArrayHandler.splitArrayFromString(pText.getText());
                    //for (int i = 0; i < arr1.length; i++){System.out.println(arr1[i]);}
                    if ((arr1.length == 1) && (arr1[0] <= 100) && (arr2.length == 1) && (arr3.length == 1) ){
                        arr =  ArrayHandler.createArray(arr1[0], arr2[0], arr3[0]);
                        mainFrame.dispose();
                    } else {
                        statusLabel.setText("Некорректные данные, проверьте перед генерацией");
                    }

                }
            });
            controlPanel.add(namelabel);
            controlPanel.add(userText);
            controlPanel.add(passwordLabel);
            controlPanel.add(passwordText);
            controlPanel.add(pLabel);
            controlPanel.add(pText);
            controlPanel.add(loginButton);
            controlPanel.add(createButton);

            mainFrame.setVisible(true);
        }
    }
    /**
     * реализует функционал нажатия на кнопку выбора ввода
     * можно выбрать:
     * ввод массива из файла
     * ввод массива в приложении
     * генерация массива в приложении
     * @param event
     */

    static int[] arr = null;

    public void actionPerformed(ActionEvent event) {
        //int[] arr = null;
        JComboBox comboBox = (JComboBox) event.getSource();
        // Print the selected items and the action command.
        Object selected = comboBox.getSelectedItem();
        try {
            if (selected == "Import from the file") {
                JFrame frame = new JFrame();
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    arr = FileManager.fileInput(file);
                } else {
                    TheBestLogger.getInstance().logInfo("Nothing entered");
                }
            } else if (selected == "Create an array randomly") {
                SwingControlDemo  swingControlDemo = new SwingControlDemo();
                swingControlDemo.showTextFieldDemo();
            } else if (selected == "Set array") {
                JFrame jFrame = new JFrame();
                String arrayString = null;
                jFrame.add(new TextArea());
                arrayString = JOptionPane.showInputDialog(jFrame, "Введите числа через пробел");
                arr = ArrayHandler.splitArrayFromString(arrayString);
            }
        } catch(Exception e){
            TheBestLogger.getInstance().logInfo("Nothing entered");
        }
        DataClass.getInstance().mainArray = arr;
    }

}
