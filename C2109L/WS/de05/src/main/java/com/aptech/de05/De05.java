/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aptech.de05;

import javax.swing.SwingUtilities;
import screens.ComputerFrame;

/**
 *
 * @author hoangnd
 */
public class De05 {

    public static void main(String[] args) {
        ComputerFrame computerFrame = new ComputerFrame();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                computerFrame.setVisible(true);
            }
        });
    }
}
/*
CREATE DATABASE de05;
USE de05;
CREATE TABLE tblComputer(   
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(30) NOT NULL DEFAULT '', 
    price float CHECK(price > 0),
    manufacturer VARCHAR(30) DEFAULT ''
);

INSERT INTO tblComputer (id, name, price, manufacturer)
VALUES
  ('PC001', 'Desktop A', 999.99, 'Manufacturer X'),
  ('PC002', 'Desktop B', 799.99, 'Manufacturer Y'),
  ('PC003', 'Laptop A', 1499.99, 'Manufacturer Z'),
  ('PC004', 'Laptop B', 699.99, 'Manufacturer X'),
  ('PC005', 'Desktop C', 1299.99, 'Manufacturer Y'),
  ('PC006', 'Laptop C', 1999.99, 'Manufacturer Z'),
  ('PC007', 'Desktop D', 899.99, 'Manufacturer X'),
  ('PC008', 'Laptop D', 1699.99, 'Manufacturer Y'),
  ('PC009', 'Desktop E', 1099.99, 'Manufacturer Z'),
  ('PC010', 'Laptop E', 1599.99, 'Manufacturer X');

*/
