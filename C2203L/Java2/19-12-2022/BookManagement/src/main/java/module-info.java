module com.mycompany.bookmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bookmanagement to javafx.fxml;
    exports com.mycompany.bookmanagement;
}
