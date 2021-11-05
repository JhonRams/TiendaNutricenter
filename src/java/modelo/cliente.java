/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

import modelo.DAO._cliente;
import modelo.DAO._privilegio;

/**
 *
 * @author JR
 */
public class cliente extends persona{
    private int descuento;

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    public cliente() {
    }

    public cliente(String documento) {
        super(documento);
    }

    public cliente(String documento, String tipo_doc, String correo, String password, String nombre, String apellido, String foto, String fecha_nac, String fecha_reg, String telefono, String direccion, String genero, String estado) {
        super(documento, tipo_doc, correo, password, nombre, apellido, foto, fecha_nac, fecha_reg, telefono, direccion, genero, estado);
    }

  public boolean Session(){
      return _cliente.Session(this);
  }
    public int Insertar(){
       return _cliente.Insertar(this);
    }
    public int Actualizar(){
       return _cliente.Actualizar(this);
    }
    public int Estado(){
        if(super.getEstado()=="1"){
            super.setEstado("0");
        }else{
           super.setEstado("1");
        }
       return _cliente.Estado(this);
    }
    public int Ver_x_id(){
       return _cliente.Ver_x_id(this);
    }
   public ArrayList<cliente> Ver_todo(){
        return _cliente.Ver_todo();
    }
   public ArrayList<cliente> Ver_x_estado(){
        return _cliente.Ver_x_estado(this);
        
    }   
}
