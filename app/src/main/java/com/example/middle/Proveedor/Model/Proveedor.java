package com.example.middle.Proveedor.Model;

public class Proveedor {
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String rubro;
    private String ofrece;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getOfrece() {
        return ofrece;
    }

    public void setOfrece(String ofrece) {
        this.ofrece = ofrece;
    }
}
