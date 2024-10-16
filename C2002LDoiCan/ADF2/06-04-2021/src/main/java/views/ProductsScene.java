package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import models.Product;

public class ProductsScene extends Scene implements IScene{
    private VBox vBox;
    private TableView<Product> tableView = new TableView<Product>();
    private TableColumn columnProductName = new TableColumn("product's name");
    private TableColumn columnProductYear = new TableColumn("product's year");
    private TableColumn columnProductPrice = new TableColumn("product's price");
    private ContextMenu contextMenu = new ContextMenu();
    private ObservableList<Product> products =
            FXCollections.observableArrayList(
                    new Product("iphon3 3", 2013, 123.0),
                    new Product("iphon4 4", 2014, 444.0),
                    new Product("iphon5 5", 2015, 555.0)
            );
    public ProductsScene(VBox vBox){
        super(vBox);
        this.vBox = vBox;
        this.setupUI();
    }

    @Override
    public void setupActions() {

    }
    private void setupTableView(){
        columnProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        columnProductYear.setCellValueFactory(new PropertyValueFactory<>("productYear"));
        columnProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView.getColumns().addAll(columnProductName, columnProductPrice, columnProductYear);
        tableView.setItems(products);
        tableView.setRowFactory(new Callback<TableView<Product>, TableRow<Product>>() {
            @Override
            public TableRow<Product> call(TableView<Product> productTableView) {
                final TableRow tableRow = new TableRow<>();
                tableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if(mouseEvent.getClickCount() == 2 && !tableRow.isEmpty()) {
                            System.out.println("Bam double click");
                        } else if(mouseEvent.getButton() == MouseButton.SECONDARY) {
                            System.out.println("Bam right click");
                            MenuItem menuItemProperties = new MenuItem("Properties");
                            MenuItem menuItemEdit = new MenuItem("Edit");
                            contextMenu.getItems().addAll(menuItemProperties);
                            contextMenu.getItems().addAll(menuItemEdit);
                            contextMenu.show(tableView, mouseEvent.getScreenX(), mouseEvent.getSceneY()+contextMenu.getHeight());
                        }
                    }
                });
                return tableRow;
            }
        });
    }
    @Override
    public void setupUI() {
        this.vBox.getChildren().add(new Label("List of products here: "));
        setupTableView();
        this.vBox.getChildren().add(this.tableView);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);
    }
}
