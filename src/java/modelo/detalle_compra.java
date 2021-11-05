/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._detalle_compra;

/**
 *
 * @author JR
 */
public class detalle_compra {
    private String id;
    private String idorden;
    private String idProducto;
    private producto objProducto;
    private double costo;
    private int cantidad;
    private double subtotal;
    private String fecha_ingreso;
    private String estado;

    public detalle_compra() {
    }

    public detalle_compra(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(producto objProducto) {
        this.objProducto = objProducto;
    }

    public String getIdorden() {
        return idorden;
    }

    public void setIdorden(String idorden) {
        this.idorden = idorden;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
         public ArrayList<detalle_compra> Ver_x_estado(){
        return _detalle_compra.Ver_x_estado(this.estado);
    }
 public  int Insertar(){
     return _detalle_compra.Insertar(this);
 }
 public  int Ver_x_id(){
     return _detalle_compra.Ver_x_id(this);
 }
}
