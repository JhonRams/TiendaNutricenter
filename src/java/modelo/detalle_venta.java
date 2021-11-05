/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.DAO._detalle_venta;

/**
 *
 * @author JR
 */
public class detalle_venta {

    private String id;
    private String venta;
    private String producto;
    private int cantidad;
    private String servicio;
    private float precio;
    private float subtotal;
    private producto objProducto;
    private servicio objServicio;
    private venta objVenta;

    public detalle_venta() {
    }

    public detalle_venta(String id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String proString) {
        this.producto = proString;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Object getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(producto objProducto) {
        this.objProducto = objProducto;
    }

    public servicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(servicio objServicio) {
        this.objServicio = objServicio;
    }

    public venta getObjVenta() {
        return objVenta;
    }

    public void setObjVenta(venta objVenta) {
        this.objVenta = objVenta;
    }

    public Object[] ID() {
        Object idv[] = {
            this.id
        };
        return idv;
    }

    public Object[] DETALLE() {
        Object dtll_vn[] = {this.venta,
            this.producto,
            this.cantidad,
            this.servicio,
            this.precio,
            this.subtotal
        };
        return dtll_vn;
    }

    public void costo_producto() {
        this.objProducto = new producto(this.producto);
        this.objProducto.Ver_x_id();
        this.precio = objProducto.getPrecio();
        this.subtotal = this.precio * this.cantidad;
    }

    public void costo_servicio() {
        this.objServicio = new servicio(this.servicio);
        this.objServicio.Ver_x_id();
        this.precio = this.objServicio.getCosto();
        this.subtotal = this.precio * this.cantidad;
    }

    public int Insertar() {
        return _detalle_venta.Insertar(this);
    }

}
