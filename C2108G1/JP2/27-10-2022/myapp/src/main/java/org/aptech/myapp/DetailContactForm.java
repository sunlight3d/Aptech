package org.aptech.myapp;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DetailContactForm extends JFrame{
    public ContactManagementForm contactManagementForm;
    private JButton buttonGoBack;
    private JPanel mainPanel;

    public DetailContactForm(String formName) {
        this.setTitle(formName);
        //JFrame frame = new JFrame(formName);
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.buttonGoBack.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("buttonClear");
            this.contactManagementForm.setVisible(true);
            this.setVisible(false);
        });

    }
}
