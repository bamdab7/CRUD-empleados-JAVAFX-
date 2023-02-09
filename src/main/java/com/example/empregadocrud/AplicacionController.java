package com.example.empregadocrud;

import com.example.empregadocrud.dao.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Date;
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
    private int id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new EmpleadosDAO();
        dao.getConnection();
        mostrarEmpleados();
    }

    public void btnEdit(ActionEvent actionEvent) {
    }

    public void btnInsert(ActionEvent actionEvent) {
        Empleados empleado = new Empleados();
        empleado.setIdEmpleado(id);
        empleado.setNombre(txtNombre.getText());
        empleado.setApellidos(txtApellidos.getText());

        Date date = java.sql.Date.valueOf(txtFecha.getValue());
        empleado.setFecha_nacimiento(date);

        empleado.setCategoria(enumCategoria.getSelectionModel().getSelectedItem().toString());

        dao.insertarEmpleados(empleado);
        id = 0 ;
        //PARA QUE LOS VALORES SE ACTUALICEN
        mostrarEmpleados();
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void mostrarEmpleados(){
        tabladb.setItems(dao.obtenerListaEmpleados());
    }
}