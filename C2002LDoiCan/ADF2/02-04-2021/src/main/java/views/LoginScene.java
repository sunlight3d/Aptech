package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class LoginScene extends Scene implements IScene{
    private final GridPane gridPane;
    private final TextField textFieldEmail = new TextField();
    private final PasswordField textFieldPassword = new PasswordField();
    private final Button buttonLogin = new Button("Login");

    public LoginScene(GridPane gridPane, final Double width, final Double height){
        super(gridPane, width, height);
        this.gridPane = gridPane;
        setupUI();
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
                this.textFieldEmail
            }
        });

    }
}
