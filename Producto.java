/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Producto {
    private int id;
    private String nombre;
    private String detalle;
    private String fechaCompra;
    private double precioCompra;
    private double PrecioVenta;
    private int stock;

    public Producto() {
    }

    public Producto(int id, String nombre, String detalle, String fechaCompra, double precioCompra, double PrecioVenta, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.fechaCompra = fechaCompra;
        this.precioCompra = precioCompra;
        this.PrecioVenta = PrecioVenta;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + ", fechaCompra=" + fechaCompra + ", precioCompra=" + precioCompra + ", PrecioVenta=" + PrecioVenta + ", stock=" + stock + '}';
    }
    
    
}

