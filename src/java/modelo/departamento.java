/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._departamento;

/**
 *
 * @author JR
 */
public class departamento {
     private String id;
    private String nombre;
    private String estado;

    public departamento() {
    }

    public departamento(String id) {
        this.id = id;
    }

    public departamento(String id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
 public int Insertar() {
        return _departamento.Insertar(this);
    }

    public int Actualizar() {
        return _departamento.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado ="0";
        } else {
           this.estado ="1";
        }
        return _departamento.Estado(this);
    }

    public int Ver_x_id() {
        return _departamento.Ver_x_id(this);
    }

    public ArrayList<departamento> Ver_todo() {
        return _departamento.Ver_todo();
    }

    public ArrayList<departamento> Ver_x_estado() {
        return _departamento.Ver_x_estado();

    }
    

   
    
    
}
