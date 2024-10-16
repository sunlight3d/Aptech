/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;
import com.aptech.de05.Computer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ComputerFrame extends JFrame {
    private JTextField txtComputerId;
    private JTextField txtPrice;
    private JTextField txtName;
    private JTextField txtManufacture;
    private JButton btnShowAll;
    private JButton btnAddNew;
    private JButton btnFind;
    private JTable tblProducts;
    private Client client;
    private WebTarget webTarget;
    private List<Computer> computers = new ArrayList<Computer>();

    public ComputerFrame() {
        initComponents();
        webTarget = client.target("http://localhost:8080/computers");
    }
    
    
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Product Form");

        // Create labels
        JLabel lblComputerId = new JLabel("Computer ID:");
        JLabel lblPrice = new JLabel("Price:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblManufacture = new JLabel("Manufacture:");

        // Create text fields
        txtComputerId = new JTextField(10);
        txtPrice = new JTextField(10);
        txtName = new JTextField(20);
        txtManufacture = new JTextField(20);

        // Create buttons
        btnShowAll = new JButton("Show All");
        btnAddNew = new JButton("Add New");
        btnFind = new JButton("Find");

        // Create table
        tblProducts = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblProducts);

        // Set layout
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        inputPanel.add(lblComputerId, gbc);
        gbc.gridx++;
        inputPanel.add(txtComputerId, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(lblPrice, gbc);
        gbc.gridx++;
        inputPanel.add(txtPrice, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(lblName, gbc);
        gbc.gridx++;
        inputPanel.add(txtName, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(lblManufacture, gbc);
        gbc.gridx++;
        inputPanel.add(txtManufacture, gbc);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnShowAll);
        buttonPanel.add(btnAddNew);
        buttonPanel.add(btnFind);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnShowAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllProducts();
            }
        });

        btnAddNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewProduct();
            }
        });

        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findProduct();
            }
        });

        pack();
    }

    private void showAllProducts() {
        // Get data from the database or any other source
        Vector<Vector<String>> productsData = new Vector<Vector<String>>();
        // Populate productsData with the product information
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {            
            this.computers = response.readEntity(new GenericType<List<Computer>>() {});            
        } 
        // Create table model
        for (Computer computer : computers) {
            Vector<String> rowData = new Vector<String>();
            rowData.add(computer.getId());
            rowData.add(String.valueOf(computer.getPrice()));
            rowData.add(computer.getName());
            rowData.add(computer.getManufacturer());
            productsData.add(rowData);
        }
        // Create table model
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Computer ID");
        columnNames.add("Price");
        columnNames.add("Name");
        columnNames.add("Manufacturer");
        DefaultTableModel model = new DefaultTableModel(productsData, columnNames);
        // Set the table model
        tblProducts.setModel(model);
    }

    private void addNewProduct() {
        String computerId = txtComputerId.getText();
        String price = txtPrice.getText();
        String name = txtName.getText();
        String manufacture = txtManufacture.getText();
        // Create a new Computer object
        Computer computer = new Computer();
        computer.setId(computerId);
        computer.setPrice(Float.parseFloat(price));
        computer.setName(name);
        computer.setManufacturer(manufacture);
        
        // Add the new product to the database or any other storage
        Response response = webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(computer, MediaType.APPLICATION_JSON));
        if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            System.out.println("Computer added successfully");
        } 
        // Clear the input fields
        txtComputerId.setText("");
        txtPrice.setText("");
        txtName.setText("");
        txtManufacture.setText("");

        // Refresh the table
        showAllProducts();
    }

    private void findProduct() {
        // Implement the find functionality
    }
    
}
