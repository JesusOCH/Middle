package com.example.middle.Usuario;

public class NewsItemsUsuario {
    private String nombreEmpresa, precio, nombre;

    public NewsItemsUsuario(String nombre, String nombreEmpresa, String precio) {
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.precio = precio;

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
