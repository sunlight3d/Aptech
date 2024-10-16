package views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.Product;

public class ProductDetailScene extends Scene implements IScene {
    private Product product;
    private VBox vBox;
    private TextField textFieldProductName = new TextField();
    private TextField textFieldYear = new TextField();
    private TextField textFieldPrice = new TextField();
    private Button buttonOK = new Button("Save");
    private Button buttonCancel = new Button("Cancel");

    public ProductDetailScene(VBox vBox, Product product){
        super(vBox);
        this.product = product;
        this.vBox = vBox;
        this.setupUI();
        this.setupActions();

    }

    @Override
    public void setupActions() {
        buttonOK.setOnMouseClicked(mouseEvent -> {

        });
    }

    @Override
    public void setupUI() {
        this.textFieldProductName.setPromptText("Enter product's name : ");
        this.textFieldProductName.setText(product.getProductName());
        this.textFieldYear.setPromptText("Enter product's year : ");
        this.textFieldYear.setText(String.valueOf(product.getProductYear()));
        this.textFieldPrice.setPromptText("Enter product's price : ");
        this.textFieldPrice.setText(String.valueOf(product.getPrice()));
        buttonCancel.setCancelButton(true);
        this.vBox.getChildren().addAll(textFieldProductName,
                textFieldYear,
                textFieldPrice,
                buttonOK,
                buttonCancel
        );
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);
    }
}

