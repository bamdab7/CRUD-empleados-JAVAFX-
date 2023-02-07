package com.example.empregadocrud.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpleadosDAO {
    public void crearTabla() {
        //ESTABLECEMOS LA CONEXION CON LA BBDD
        try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleadosdb", "root", "");){
            System.out.printf("Hola");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
