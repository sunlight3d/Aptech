package org.aptech.myapp;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ContactManagementForm extends JFrame{
    private Database database = new Database();
    //private JFrame frame;
    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    public ContactManagementForm(String formName) {
        this.setTitle(formName);
        //JFrame frame = new JFrame(formName);
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setupActions();
        //get data from DB
        try {
            database.getContacts();
        }catch (Exception e) {
            //show alert in UI
            alert(e.getMessage());
        }
    }
    /*
    public ContactManagementForm(String formName) {
        this.frame = new JFrame(formName);
        this.frame.setTitle(formName);
        //JFrame frame = new JFrame(formName);
        this.frame.setContentPane(this.mainPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    */

    private JPanel mainPanel;
    private JTable tableContact;
    private JTextField textFieldContactID;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldContactNo;
    private JTextField textFieldAddress;
    private JComboBox comboBoxGender;
    private JButton buttonAdd;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private JButton buttonClear;
    private DetailContactForm detailContactForm;
    private void setupActions(){
        this.buttonAdd.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("buttonAdd");
            /*
            detailContactForm = detailContactForm == null ?
                    new DetailContactForm("Contact form"): detailContactForm;
            detailContactForm.contactManagementForm = this;
            detailContactForm.setVisible(true);
            this.setVisible(false);
             */
            String id = textFieldContactID.getText();
            String firstName = textFieldFirstName.getText();
            String lastName = textFieldLastName.getText();
            String contactNo = textFieldContactNo.getText();
            String address = textFieldAddress.getText();
            String gender = (String)(comboBoxGender.getModel().getSelectedItem());
            try {
                this.database.insertContact(new Contact(id, firstName,
                        lastName, contactNo, address, gender));
            } catch (Exception e) {
                alert(e.getMessage());
            }
        });
        this.buttonUpdate.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("buttonUpdate");
        });
        this.buttonDelete.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("buttonDelete");
        });
        this.buttonClear.addActionListener((ActionEvent actionEvent) -> {
            System.out.println("buttonClear");
        });

    }
}
