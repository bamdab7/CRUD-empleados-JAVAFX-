module com.example.empregadocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.empregadocrud to javafx.fxml;
    exports com.example.empregadocrud;
    exports com.example.empregadocrud.dao;
    opens com.example.empregadocrud.dao to javafx.fxml;
}