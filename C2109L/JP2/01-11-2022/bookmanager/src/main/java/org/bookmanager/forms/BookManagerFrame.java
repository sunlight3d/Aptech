package org.bookmanager.forms;

import org.bookmanager.database.Database;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        database = new Database();
        try {
            database.getConnection();
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
            int categoryId = 1222;
            float price = Float.valueOf(textFieldPrice.getText());
            try {
                database.insertBook(code, name, categoryId, price);
            }catch (Exception e) {
                alert(e.getMessage());
            }
        });
        buttonShowAll.addActionListener((ActionEvent actionEvent) -> {
            //alert("Ban bam nut buttonShowAll");

//            this.bookListFrame = bookListFrame == null ?
//                    new BookListFrame("Bool list"): bookListFrame;
            this.setVisible(false);

        });
        buttonDelete.addActionListener((ActionEvent actionEvent) -> {
            alert("Ban bam nut buttonDelete");
        });
    }

}
