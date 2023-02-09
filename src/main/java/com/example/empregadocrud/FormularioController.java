package com.example.empregadocrud;

import com.example.empregadocrud.dao.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable {

    public TextField txtNombre;
    public TextField txtApellidos;
    public DatePicker txtFecha;
    public ComboBox enumCategoria;
    public Button btnEdit;
    public Button btnInsert;
    public Button btnDelete;
    public TableView<Empleados> tabladb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmpleadosDAO dao = new EmpleadosDAO();
        dao.getConnection();
    }

    public void btnEdit(ActionEvent actionEvent) {
    }

    public void btnInsert(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }
}