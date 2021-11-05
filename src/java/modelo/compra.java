/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._compra;

/**
 *
 * @author JR
 */
public class compra {
   private String id;
   private String fecha_orden;
   private double costo;
   private String usuario;
   private String estado;
   private personal objPersonal;

    public compra() {
    }

    public compra(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public personal getObjPersonal() {
        return objPersonal;
    }

    public void setObjPersonal(personal objPersonal) {
        this.objPersonal = objPersonal;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
     public ArrayList<compra> Ver_x_estado(){
        return _compra.Ver_x_estado(this.estado);
    }
 public  int Ver_x_id(){
     return _compra.Ver_x_id(this);
 }
 public int Insertar(){
     return _compra.Insertar(this);
 }
}
