package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginScene extends Scene implements IScene{
    private final GridPane gridPane;
    private final TextField textFieldEmail = new TextField();
    private final PasswordField textFieldPassword = new PasswordField();
    private final Button buttonLogin = new Button("Login");
    private Alert alert;
    public LoginScene(GridPane gridPane, final Double width, final Double height){
        super(gridPane, width, height);
        this.gridPane = gridPane;
        setupUI();
        this.textFieldEmail.setText("hoang@gmail.com");
        this.textFieldPassword.setText("123456");
        setupActions();
    }
    @Override
    public void setupUI() {

        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);
        this.gridPane.setPadding(new Insets(10,10,10,10));

        this.gridPane.add(new Label("Email: "), 0,0);
        this.gridPane.add(textFieldEmail, 1,0);
        this.gridPane.add(new Label("Password: "), 0,1);
        this.gridPane.add(textFieldPassword, 1,1);
        this.gridPane.add(buttonLogin, 0, 2);
    }
    private void showAlert(String content, Alert.AlertType alertType) {
        alert = new Alert(alertType);
        alert.setContentText(content);
        Window window = alert.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(e -> alert.hide());
        alert.showAndWait();
    }
    Stage getStage() {
      return (Stage) LoginScene.this.getWindow();
    }
    @Override
    public void setupActions() {
        /*
        this.buttonLogin.setOnMouseClicked((MouseEvent mouseEvent) -> {
            this.textFieldEmail
        });
        */
        this.buttonLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String email = LoginScene.this.textFieldEmail.getText().trim();
                String password = LoginScene.this.textFieldPassword.getText().trim();
                if(email.equals("hoang@gmail.com") && password.equals("123456")) {
                    //showAlert("login successfull", Alert.AlertType.INFORMATION);
                    ProductsScene productsScene = new ProductsScene(new VBox());
                    LoginScene.this.getStage().setScene(productsScene);
                } else {
                    showAlert("wrong pass or email", Alert.AlertType.ERROR);
                }
                /*
                alert.setOnHiding(new EventHandler<DialogEvent>() {
                    @Override
                    public void handle(DialogEvent dialogEvent) {

                    }
                });
                */
            }
        });

    }
}
