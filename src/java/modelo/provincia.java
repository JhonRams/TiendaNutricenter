/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._provincia;

/**
 *
 * @author JR
 */
public class provincia {
     private String id;
    private String nombre;
    private String departamento;
    private departamento objDepartamento;
    private String estado;

    public provincia() {
    }

    public provincia(String id) {
        this.id = id;
    }

    public provincia(String id, String nombre, String departamento, departamento objDepartamento, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.objDepartamento = objDepartamento;
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
 public int Insertar() {
        return _provincia.Insertar(this);
    }

    public int Actualizar() {
        return _provincia.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado ="0";
        } else {
           this.estado ="1";
        }
        return _provincia.Estado(this);
    }

    public int Ver_x_id() {
        return _provincia.Ver_x_id(this);
    }

    public ArrayList<provincia> Ver_todo() {
        return _provincia.Ver_todo();
    }

    public ArrayList<provincia> Ver_x_estado() {
        return _provincia.Ver_x_estado();

    }
    

   
    
    
}
