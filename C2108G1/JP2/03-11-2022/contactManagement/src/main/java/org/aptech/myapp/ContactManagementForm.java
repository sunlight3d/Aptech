package org.aptech.myapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ContactManagementForm extends JFrame{
    private ArrayList<Contact> contacts = new ArrayList<>();
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
        this.setSize(800, 600);
        this.mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        //this.pack();
        this.setVisible(true);
        this.setupActions();
        //get data from DB
        try {
            this.contacts = database.getContacts();
            this.loadDataToTable();
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
    private void loadDataToTable() {
        String[] columnNames = { "id", "First name", "Last name", "Contact no", "address", "gender" };
        Object[][] data = new Object[this.contacts.toArray().length][6];
        int rowIndex = 0;
        for(rowIndex = 0; rowIndex < this.contacts.toArray().length; rowIndex++) {
            Contact contact = this.contacts.get(rowIndex);
            data[rowIndex][0] = String.valueOf(contact.getId());
            data[rowIndex][1] = contact.getFirstName();
            data[rowIndex][2] = contact.getLastName();
            data[rowIndex][3] = contact.getContactNo();
            data[rowIndex][4] = contact.getAddress();
            data[rowIndex][5] = contact.getGender();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        //rows
        this.tableContact.setModel(model);
        tableContact.getSelectionModel().addListSelectionListener((ListSelectionEvent event)->{
            if(event.getValueIsAdjusting()) {
                Contact contact = contacts.get(tableContact.getSelectedRow());
                System.out.println("You pressed: "+contact.getFirstName());
            }

        });

    }
}
