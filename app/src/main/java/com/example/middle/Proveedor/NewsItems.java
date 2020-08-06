package com.example.middle.Proveedor;

public class NewsItems {
    private String descripcion, precio;

    public NewsItems(String descripcion, String precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }
}
