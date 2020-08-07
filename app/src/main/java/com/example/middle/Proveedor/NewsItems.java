package com.example.middle.Proveedor;

public class NewsItems {
    private String descripcion, precio, nombre;

    public NewsItems(String nombre, String descripcion, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
