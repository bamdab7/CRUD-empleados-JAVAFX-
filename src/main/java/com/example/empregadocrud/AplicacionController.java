package com.example.empregadocrud;

import com.example.empregadocrud.dao.EmpleadosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.*;

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

        tabladb.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                Empleados empleados = tabladb.getSelectionModel().getSelectedItem();
                //SETEAMOS VALORES
                txtNombre.setText(empleados.getNombre());
                txtApellidos.setText(empleados.getApellidos());
                    Date input = empleados.getFecha_nacimiento();
                    LocalDate date = new java.sql.Date((empleados.getFecha_nacimiento()).getTime()).toLocalDate();
                txtFecha.setValue(date);
                enumCategoria.setValue(empleados.getCategoria());
                id = empleados.getIdEmpleado();
                System.out.print(empleados);
            }
        });
    }

    public void btnEdit(ActionEvent actionEvent) {
        Empleados empleado = new Empleados();
        if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getValue() == null ||enumCategoria.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Todos los campos deben estar cubiertos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            empleado.setIdEmpleado(id);
            empleado.setNombre(txtNombre.getText());
            empleado.setApellidos(txtApellidos.getText());

            Date date = java.sql.Date.valueOf(txtFecha.getValue());
            empleado.setFecha_nacimiento(date);

            empleado.setCategoria(enumCategoria.getSelectionModel().getSelectedItem().toString());

            dao.updateEmpleados(empleado);
            id = 0 ;
            //PARA QUE LOS VALORES SE ACTUALICEN
            mostrarEmpleados();
            eliminarCampos();
        }

    }
    public void eliminarCampos(){
        txtNombre.clear();
        txtApellidos.clear();
        txtFecha.setValue(null);
        enumCategoria.setValue(null);
        id = 0;
    }
    public void btnInsert(ActionEvent actionEvent){
        Empleados empleado = new Empleados();
        //COMPROBAR
        if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getValue() == null ||enumCategoria.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(new JFrame(), "Todos los campos deben estar cubiertos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            empleado.setIdEmpleado(id);
            empleado.setNombre(txtNombre.getText());
            empleado.setApellidos(txtApellidos.getText());

            Date date = java.sql.Date.valueOf(txtFecha.getValue());
            empleado.setFecha_nacimiento(date);

            empleado.setCategoria(enumCategoria.getSelectionModel().getSelectedItem().toString());

            dao.insertarEmpleados(empleado);
            id = 0;
            //PARA QUE LOS VALORES SE ACTUALICEN
            mostrarEmpleados();
            eliminarCampos();
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        Empleados empleados = tabladb.getSelectionModel().getSelectedItem();
        if(empleados == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Debes seleccionar un empleado!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            dao.deleteEmpleados(empleados);
            mostrarEmpleados();
        }
        eliminarCampos();

    }

    public void mostrarEmpleados(){
        tabladb.setItems(dao.obtenerListaEmpleados());
    }
}