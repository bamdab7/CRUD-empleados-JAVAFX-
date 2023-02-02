module com.example.empregadocrud {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.empregadocrud to javafx.fxml;
    exports com.example.empregadocrud;
}