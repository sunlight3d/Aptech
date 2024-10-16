package org.bookmanager.forms;

import org.bookmanager.database.Database;
import org.bookmanager.models.Book;
import org.bookmanager.models.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import static org.bookmanager.forms.Utility.alert;

public class  BookManagerFrame extends JFrame{
    private JPanel mainPanel;//load from UI
    private JTextField textFieldBookCode;
    private JTextField textFieldBookName;
    private JComboBox comboBoxCategory;
    private JTextField textFieldPrice;
    private JButton buttonUpdate;
    private JButton buttonAddNew;
    private JButton buttonShowAll;
    private JButton buttonDelete;
    private BookListFrame bookListFrame;
    private Category selectedCategory;

    public Category getSelectedCategory() {
        return selectedCategory == null ? categories.get(0) : selectedCategory;
    }

    private ArrayList<Category> categories;

    private Database database;
    public BookManagerFrame(String title) {
        this.setTitle(title);
        this.setContentPane(mainPanel);
        this.setSize(800, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2-this.getSize().width/2,
                dimension.height/2-this.getSize().height/2);

        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setVisible(true);
        this.setupActions();
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        database = Database.getInstance();
        try {
            database.getConnection();
            categories = database.getCategories();
            comboBoxCategory.removeAllItems();
            comboBoxCategory.setModel(
                    new DefaultComboBoxModel(categories.toArray()));
            comboBoxCategory.addItemListener((ItemEvent itemEvent) -> {
                if(itemEvent.getStateChange() == 1) {
                    selectedCategory = (Category)comboBoxCategory.getSelectedItem();
                    //alert(selectedCategory.getCategoryName());
                }
            });
            //test update, delete
            //database.updateBook("x22", new Book("x22", "javaaa2", 22.33f, 13));
            //database.deleteBook("x22");
        }catch (Exception e) {

        }
    }
    private void setupActions() {
        buttonUpdate.addActionListener((ActionEvent actionEvent) -> {
            alert("Ban bam nut update");
        });
        buttonAddNew.addActionListener((ActionEvent actionEvent) -> {
            //alert("Ban bam nut buttonAddNew");
            //get data from UI, validate ? Yes - homework
            String code = textFieldBookCode.getText();
            String name = textFieldBookName.getText();
            //int categoryId = Integer.valueOf(comboBoxCategory.getName());
            int categoryId = getSelectedCategory().getCategoryId();
            float price = textFieldPrice.getText().trim().length() == 0 ? 0
                                : Float.valueOf(textFieldPrice.getText());
            boolean invalidState = code.trim().length() == 0 ||
                    name.trim().length() == 0 ||
                    price <= 0;
            if(invalidState) {
                alert("Please check input ");
                return;
            }
            try {
                database.insertBook(code, name, categoryId, price);
            }catch (Exception e) {
                alert(e.getMessage());
            }
        });
        buttonShowAll.addActionListener((ActionEvent actionEvent) -> {
            //alert("Ban bam nut buttonShowAll");

            this.bookListFrame = bookListFrame == null ?
                    new BookListFrame("Bool list"): bookListFrame;
            this.bookListFrame.setVisible(true);
            this.bookListFrame.bookManagerFrame = this;
            this.setVisible(false);

        });
        buttonDelete.addActionListener((ActionEvent actionEvent) -> {
            alert("Ban bam nut buttonDelete");
        });
    }

}
