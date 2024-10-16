package org.bookmanager.forms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void setupActions() {
        buttonClose.addActionListener((ActionEvent actionEvent) -> {
            bookManagerFrame.setVisible(true);
            this.setVisible(false);
        });
    }
}
