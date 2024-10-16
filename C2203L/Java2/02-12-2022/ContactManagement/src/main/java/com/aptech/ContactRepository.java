package com.aptech;

import com.aptech.models.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
CREATE DATABASE c2203l;
USE c2203l;
CREATE TABLE T_CONTACT(
    id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    contact_no VARCHAR(20) NOT NULL UNIQUE,
    address VARCHAR(20),
    gender VARCHAR(20)
);
ALTER TABLE T_CONTACT
ADD CONSTRAINT UC_T_CONTACT UNIQUE (contact_no);
* */
public class ContactRepository {
    public static final String TABLE_CONTACT="T_CONTACT";
    private Database database = Database.getInstance();
    public ArrayList<Contact> getContacts() throws Exception{
        ArrayList<Contact> result = new ArrayList<Contact>();
        try {
            Statement statement = database.getConnection().createStatement();
            String sql = "SELECT * FROM "+TABLE_CONTACT;
            ResultSet resultSet = statement.executeQuery(sql);
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Contact contact = new Contact();
                contact.setId(resultSet.getString("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setContactNo(resultSet.getString("contact_no"));
                contact.setAddress(resultSet.getString("address"));
                contact.setGender(resultSet.getString("gender"));
                result.add(contact);
            }
            return result;
        } catch (Exception exception) {
            throw new Exception("cannot get data from DB");
        }
    }
    public void insertContact(Contact contact) throws Exception{
        try {
            String sql = "INSERT INTO "+TABLE_CONTACT+"(id, first_name, last_name,contact_no,address,gender) " +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = database.getConnection()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //prevent SQL injection
            statement.setString(1, contact.getId());
            statement.setString(2, contact.getFirstName());
            statement.setString(3, contact.getLastName());
            statement.setString(4, contact.getContactNo());
            statement.setString(5, contact.getAddress());
            statement.setString(6, contact.getGender());
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot insert, please do later");
        }
    }
    public void updateContact(String contactId, Contact contact) throws Exception{
        try {
            String sql = "UPDATE "+TABLE_CONTACT+" SET first_name=?, last_name=?,contact_no=?,address=?,gender=?" +
                    " WHERE id = ?";
            PreparedStatement statement = database.getConnection()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //prevent SQL injection
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setString(3, contact.getContactNo());
            statement.setString(4, contact.getAddress());
            statement.setString(5, contact.getGender());
            statement.setString(6, contactId);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot update, please do later");
        }
    }
    public void deleteContact(String contactId) throws Exception{
        try {
            String sql = "DELETE FROM "+TABLE_CONTACT+" WHERE id = ?";
            PreparedStatement statement = database.getConnection()
                                            .prepareStatement(sql);
            //prevent SQL injection
            statement.setString(1, contactId);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot insert, please do later");
        }
    }
}
