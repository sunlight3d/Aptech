import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import views.LoginScene;
//--module-path "/Users/nguyenduchoang/Desktop/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml
//--module-path "/Users/nguyenduchoang/Desktop/javafx-sdk-16/lib" --add-modules javafx.controls,javafx.fxml

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //System.out.println("haha");
        Button btnLogin = new Button();
        LoginScene loginScene = new LoginScene(new GridPane(), 800.0, 600.0);
        stage.setScene(loginScene);
        //truy cap xuong db, ko qua service
        stage.show();
    }

    public static void main(String[] args) {
        //System.out.println("haha");
        Application.launch(args);
    }
}
