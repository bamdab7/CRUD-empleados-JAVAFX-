package com.example.empregadocrud;

import java.util.Date;

public class Empleados {
    private Integer idEmpleado;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private Enum categoria;

    public Empleados(Integer idEmpleado, String nombre, String apellidos, Date fecha_nacimiento, Enum categoria) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.categoria = categoria;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Enum getCategoria() {
        return categoria;
    }

    public void setCategoria(Enum categoria) {
        this.categoria = categoria;
    }
}
