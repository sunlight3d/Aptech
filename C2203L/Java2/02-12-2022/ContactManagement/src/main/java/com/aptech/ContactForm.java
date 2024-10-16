package com.aptech;

import com.aptech.models.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private ContactRepository contactRepository;

    public ContactForm(String title) {
        contactRepository = new ContactRepository();
        this.frame = new JFrame(title);
        this.frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //frame.pack();
        this.setupActions();
    }
    private void reloadTable() {
        try {

            ArrayList<Contact> contacts = contactRepository.getContacts();
            ContactTableModel tableModel = new ContactTableModel(contacts);
            tableContact.setModel(tableModel);
            tableModel.fireTableDataChanged();
        }catch (Exception e) {
            System.out.println("cannot show data"+e.getMessage());
        }
    }
    public void show() {
        reloadTable();
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
