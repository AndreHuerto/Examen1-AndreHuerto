package com.example.examen1.models;

public class Producto {
    private String uuid;
    private String nombre;
    private double precio;
    private String codigo;

    public Producto() {
    }

    public Producto(String uuid, String nombre, double precio, String codigo) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
