package org.aptech.myapp;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Main {
    public static void main(String[] args) {
        ContactManagementForm contactManagementForm = new ContactManagementForm("App");


    }
}
/*
CREATE DATABASE c2108g1;
USE c2108g1;
CREATE TABLE T_CONTACT(
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    contact_no VARCHAR(20),
    address VARCHAR(20),
    gender VARCHAR(20)
);
INSERT INTO T_CONTACT(id, first_name, last_name, contact_no, address, gender) VALUES
('11', 'alan', 'greenspan', '12u8343', 'djsdfhsjfshdfdf', 'female'),
('22', 'alagmfjgnfnn', 'greenfdngjspan', '12u8dmrfd343', 'djsdfhsjfshdfdf', 'female'),
('33', 'f,dkfgalan', 'greenspfmdjkgan', '12u8343', 'djsdfhsjfshdfdf', 'male');
 */