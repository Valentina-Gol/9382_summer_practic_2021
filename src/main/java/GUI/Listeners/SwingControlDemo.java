package GUI.Listeners;

import logic.ArrayManager.ArrayHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingControlDemo {
    public JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private int[] array = null;

    public SwingControlDemo() {

        prepareGUI();
    }

    public int[] getArray(){
        return array;
    }

    void prepareGUI() {
        mainFrame = new JFrame("Random array generation");
        mainFrame.setSize(1000, 250);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

    }

    public void showTextFieldDemo() {
        mainFrame.setVisible(true);
        headerLabel.setText("Введите значения для генерации массива");

        JLabel namelabel = new JLabel("Количество элементов: ", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Нижняя граница: ", JLabel.CENTER);
        JLabel pLabel = new JLabel("Верхняя граница: ", JLabel.LEFT);

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
                if ((arr1.length == 1) && (arr1[0] <= 100) && (arr2.length == 1) && (arr3.length == 1)) {
                    array = ArrayHandler.createArray(arr1[0], arr2[0], arr3[0]);
                    //for (int i=0;i<array.length;i++){System.out.println(array[i]);}
                    mainFrame.dispose();
                    //mainFrame.setVisible(false);
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

    public void close(){
        mainFrame.dispose();
    }
}