package org.aptech.myapp;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    static final String DB_URL = "jdbc:mysql://localhost:3306/c2108g1";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String TABLE_CONTACT = "T_CONTACT";
    public Connection getConnection() throws Exception{
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception exception) {
          throw new Exception("Cannot connect DB, error: "+exception.getMessage());
        }
    }

    public ArrayList<Contact> getContacts() throws Exception{
        ArrayList<Contact> result = new ArrayList<Contact>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_CONTACT);
                // Extract data from result set
                while (resultSet.next()) {
                    // Fetch data to object
                    Contact contact = new Contact();
                    contact.setId(resultSet.getString("id"));
                    contact.setFirstName(resultSet.getString("first_name"));
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
            PreparedStatement statement = this.getConnection()
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
    public void updateContact(int contactId, Contact contact) throws Exception{
        try {
            String sql = "UPDATE "+TABLE_CONTACT+" SET first_name=?, last_name=?,contact_no=?,address=?,gender=?" +
                    " WHERE id = ?";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //prevent SQL injection
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setString(3, contact.getContactNo());
            statement.setString(4, contact.getAddress());
            statement.setString(5, contact.getGender());
            statement.setInt(6, contactId);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot update, please do later");
        }
    }
    public void deleteContact(int contactId) throws Exception{
        try {String sql = "DELETE FROM "+TABLE_CONTACT+" WHERE id = ?";
            PreparedStatement statement = this.getConnection().prepareStatement(sql);
            //prevent SQL injection
            statement.setInt(1, contactId);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot insert, please do later");
        }
    }
}

