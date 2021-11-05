/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._distrito;


/**
 *
 * @author JR
 */
public class distrito {
     private String id;
    private String nombre;
    private String provincia;
    private provincia objProvincia;
    private String estado;

    public distrito() {
    }

    public distrito(String id) {
        this.id = id;
    }

    public distrito(String id, String nombre, String provincia, provincia objProvincia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.objProvincia = objProvincia;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public provincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(provincia objProvincia) {
        this.objProvincia = objProvincia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
 public int Insertar() {
        return _distrito.Insertar(this);
    }

    public int Actualizar() {
        return _distrito.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado ="0";
        } else {
           this.estado ="1";
        }
        return _distrito.Estado(this);
    }

    public int Ver_x_id() {
        return _distrito.Ver_x_id(this);
    }

    public ArrayList<distrito> Ver_todo() {
        return _distrito.Ver_todo();
    }

    public ArrayList<distrito> Ver_x_estado() {
        return _distrito.Ver_x_estado();

    }
    

   
    
    
}
