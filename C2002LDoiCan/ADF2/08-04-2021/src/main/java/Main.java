import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.WebService;
import views.LoginScene;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btnLogin = new Button();
        LoginScene loginScene = new LoginScene(new GridPane(), 800.0, 600.0);
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        WebService xx = new WebService();

        try {
            xx.get("https://jsonplaceholder.typicode.com/posts");
        }catch (Exception e) {
            System.out.println("kaka");
        }
        //Application.launch(args);
    }
}
