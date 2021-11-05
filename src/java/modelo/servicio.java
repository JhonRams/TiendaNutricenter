/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._servicio;

/**
 *
 * @author JR
 */
public class servicio {
   private String id;
   private String nombre;
   private String detalle;
   private float costo;
   private String foto;
   private String estado;

    public servicio() {
    }

    public servicio(String id) {
        this.id = id;
    }



    public servicio(String nombre, String detalle, float costo, String foto, String estado) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.costo = costo;
        this.foto = foto;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Object[] Id(){
        Object id[]={this.id};
        return  id;
    }
 public ArrayList<servicio> Ver_x_estado(){
        return _servicio.Ver_x_estado(this);
    }
 public  int Ver_x_id(){
     return _servicio.Ver_x_id(this);
 }
}
