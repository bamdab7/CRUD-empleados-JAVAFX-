package com.example.empregadocrud;

import com.example.empregadocrud.dao.EmpleadosDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmpleadosDAO dao = new EmpleadosDAO();
        dao.crearTabla();
    }
}