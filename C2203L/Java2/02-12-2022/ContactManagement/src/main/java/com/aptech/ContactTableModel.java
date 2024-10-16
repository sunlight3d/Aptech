package com.aptech;

import com.aptech.models.Contact;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ContactTableModel extends AbstractTableModel {
    private ArrayList<Contact> contacts;
    private String[] columnNames = {
            "Id",
            "First Name",
            "Last Name",
            "Contact No",
            "Address",
            "Gender"
    };
    public ContactTableModel(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
    @Override
    public int getRowCount() {
        return this.contacts.size();
    }

    private String[] convertContactToStringArray(Contact contact) {
            String[] row = new String[6];
            row[0] = contact.getId();
            row[1] = contact.getFirstName();
            row[2] = contact.getLastName();
            row[3] = contact.getContactNo();
            row[4] = contact.getAddress();
            row[5] = contact.getGender();
            return row;
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contact contact = contacts.get(rowIndex);
        String[] row = this.convertContactToStringArray(contact);
        return row[columnIndex];
    }
}
