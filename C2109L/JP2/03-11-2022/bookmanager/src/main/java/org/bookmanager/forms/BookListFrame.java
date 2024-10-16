package org.bookmanager.forms;

import org.bookmanager.database.Database;
import org.bookmanager.models.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import static org.bookmanager.forms.Utility.alert;

public class BookListFrame extends JFrame{
    private JPanel mainPanel;
    private JTable tableBooks;
    private JButton buttonClose;
    public BookManagerFrame bookManagerFrame;
    public BookListFrame(String title) {
        this.setTitle(title);
        this.setContentPane(mainPanel);
        this.setSize(800, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2-this.getSize().width/2,
                dimension.height/2-this.getSize().height/2);

        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setVisible(true);
        setupActions();
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.loadDataToTable();
    }
    private void loadDataToTable() {
        String[] columnNames = { "code", "bookName","price","categoryId" };
        try {
            ArrayList<Book> books = Database.getInstance().getBooks();
            Object[][] data = new Object[books.size()][columnNames.length];
            int rowIndex = 0;
            for(rowIndex = 0; rowIndex < books.size(); rowIndex++) {
                Book book = books.get(rowIndex);
                data[rowIndex][0] = book.getCode();
                data[rowIndex][1] = book.getBookName();
                data[rowIndex][2] = book.getPrice();
                data[rowIndex][3] = book.getCategoryId();
            }

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            //rows
            this.tableBooks.setModel(model);
            tableBooks.getSelectionModel().addListSelectionListener((ListSelectionEvent event)->{
                if(event.getValueIsAdjusting()) {
                    Book book = books.get(tableBooks.getSelectedRow());
                    alert(book.getBookName());
                }

            });
        }catch (Exception e) {
            alert("Cannot get books");
        }

    }
    private void setupActions() {
        buttonClose.addActionListener((ActionEvent actionEvent) -> {
            bookManagerFrame.setVisible(true);
            //this.setVisible(false);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }
}
