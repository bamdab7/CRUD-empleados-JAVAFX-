package com.example.empregadocrud.dao;
import com.example.empregadocrud.Empleados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmpleadosDAO {

    public Connection getConnection() {
        //ESTABLECEMOS LA CONEXION CON LA BBDD
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empleadosdb", "root", "");
            return conn;
        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Empleados> obtenerListaEmpleados(){
        ObservableList<Empleados> empleadosList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM empleados";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Empleados empleados;
            while (rs.next()){
                empleados = new Empleados(rs.getInt("idEmpleado"),rs.getString("nombre"),
                        rs.getString("apellidos"), rs.getDate("fecha_nacimiento"), rs.getString("categoria"));
                empleadosList.add(empleados);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return empleadosList;
    }

    public void insertarEmpleados(Empleados empleado){
        Connection conn = getConnection();
        String query = "INSERT INTO empleados (idEmpleado, nombre, apellidos, fecha_nacimiento, categoria) VALUES ('" +
                empleado.getIdEmpleado()+"','"+ empleado.getNombre()+"','" + empleado.getApellidos()+"','"+empleado.getFecha_nacimiento()+"','"+ empleado.getCategoria() + "')";
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateEmpleados(Empleados empleados){
        Connection conn = getConnection();
        String query = "UPDATE empleados " +
                "SET nombre = '" + empleados.getNombre()
                + "',apellidos = '"+ empleados.getApellidos()
                + "',fecha_nacimiento = '" + empleados.getFecha_nacimiento()
                + "',categoria = '" + empleados.getCategoria()
                + "' WHERE idEmpleado = " + empleados.getIdEmpleado();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteEmpleados(Empleados empleados){
        String query = "DELETE from empleados WHERE idEmpleado = "+ empleados.getIdEmpleado();
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
