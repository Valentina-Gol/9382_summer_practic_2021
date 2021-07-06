package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SimpleGui extends JFrame {
    private JComboBox import_ ;
    private JComboBox sort;
    private JComboBox sep;
    private JButton answer;
    private JPanel rootPanel;
    private JPanel answerLabel;
    private JButton экспортButton;
    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public SimpleGui()
    {
        //само окно
        super("Project");
        this.setBounds(100, 100, 1600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //import
        setContentPane(rootPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    }

