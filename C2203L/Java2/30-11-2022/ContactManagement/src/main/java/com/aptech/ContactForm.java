package com.aptech;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm implements IAction{
    private JFrame frame;
    private JTextField textFieldContactID;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldContactNo;
    private JTextArea textAreaAddress;
    private JComboBox comboBoxGender;
    private JTable tableContact;
    private JButton buttonAdd;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private JButton buttonClear;
    private JPanel mainPanel;

    public ContactForm(String title) {
        this.frame = new JFrame(title);
        this.frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        this.setupActions();
    }
    public void show() {
        this.frame.setVisible(true);
    }
    @Override
    public void setupActions() {
        buttonAdd.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("You pressed buttonAdd");
        });
        buttonClear.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("You pressed buttonClear");
        });
        buttonDelete.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("You pressed buttonDelete");
        });
        buttonUpdate.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("You pressed buttonUpdate");
        });


    }
}
