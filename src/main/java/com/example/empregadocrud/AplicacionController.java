package com.example.empregadocrud;

import com.example.empregadocrud.dao.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AplicacionController implements Initializable {

    public TextField txtNombre;
    public TextField txtApellidos;
    public DatePicker txtFecha;
    public ComboBox enumCategoria;
    public Button btnEdit;
    public Button btnInsert;
    public Button btnDelete;
    public TableView<Empleados> tabladb;
    EmpleadosDAO dao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new EmpleadosDAO();
        dao.getConnection();
        mostrarEmpleados();
    }

    public void btnEdit(ActionEvent actionEvent) {
    }

    public void btnInsert(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void mostrarEmpleados(){
        tabladb.setItems(dao.obtenerListaEmpleados());
    }
}