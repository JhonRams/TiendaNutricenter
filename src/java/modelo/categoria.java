/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._categoria;

/**
 *
 * @author JR
 */
public class categoria {

    private int id;
    private String nombre;
    private String descripcion;
    private String estado;

    public categoria() {
    }

    public categoria(int id) {
        this.id = id;
    }

    public categoria(String nombre, String descripcion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public categoria(int id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Object[] Datos() {
        Object datos[] = {this.nombre, this.descripcion, this.estado};
        return datos;
    }

    public Object[] ID() {
        Object datos[] = {this.id};
        return datos;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int Insertar() {
        return _categoria.Insertar(this);
    }

    public int Actualizar() {
        return _categoria.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado ="0";
        } else {
           this.estado ="1";
        }
        return _categoria.Estado(this);
    }

    public int Ver_x_id() {
        return _categoria.Ver_x_id(this);
    }

    public ArrayList<categoria> Ver_todo() {
        return _categoria.Ver_todo();
    }

    public ArrayList<categoria> Ver_x_estado() {
        return _categoria.Ver_x_estado();

    }

}
