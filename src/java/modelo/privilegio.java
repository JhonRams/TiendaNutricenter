/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

import modelo.DAO._privilegio;

/**
 *
 * @author JR
 */
public class privilegio {

    private int id;
    private String nombre;
    private String permisos;
    private String estado;

    public privilegio() {
    }

    public privilegio(int id) {
        this.id = id;
    }

    public privilegio(String nombre, String permisos, String estado) {
        this.nombre = nombre;
        this.permisos = permisos;
        this.estado = estado;
    }

    public privilegio(int id, String nombre, String permisos, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
        this.estado = estado;
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

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean[] Permisos() {
        String datos[] = this.permisos.split("/"); 
        boolean permiso[] = new boolean[datos.length];
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].equals("1")) {
                permiso[i] = true;
            } else {
                permiso[i] = false;
            }
        }
        return permiso;

    }

    public Object[] datos() {
        Object datos[] = {this.id, this.nombre, this.permisos, this.estado};
        return datos;
    }

    public Object[] dato_id() {
        Object datos[] = {this.id};
        return datos;
    }

    public int Insertar() {
        return _privilegio.Insertar(this);
    }

    public int Actualizar() {
        return _privilegio.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado = "0";
        } else {
            this.estado = "1";
        }
        return _privilegio.Estado(this);
    }

    public int Ver_x_id() {
        return _privilegio.Ver_x_id(this);
    }

    public ArrayList<privilegio> Ver_todo() {
        return _privilegio.Ver_todo();
    }

    public ArrayList<privilegio> Ver_x_estado() {
        return _privilegio.Ver_x_estado(this);

    }


}
