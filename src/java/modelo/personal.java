/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._personal;

/**
 *
 * @author JR
 */
public class personal extends persona{
private int pivilegio;
private privilegio perfil;

    public personal() {
    }

    public personal(String documento) {
        super(documento);
    }

    public personal(int pivilegio, privilegio perfil, String documento, String tipo_doc, String correo, String password, String nombre, String apellido, String foto, String fecha_nac, String fecha_reg, String telefono, String direccion, String genero, String estado) {
        super(documento, tipo_doc, correo, password, nombre, apellido, foto, fecha_nac, fecha_reg, telefono, direccion, genero, estado);
        this.pivilegio = pivilegio;
        this.perfil = perfil;
    }

    public int getPivilegio() {
        return pivilegio;
    }

    public void setPivilegio(int pivilegio) {
        this.pivilegio = pivilegio;
    }

    public privilegio getPerfil() {
        return perfil;
    }

    public void setPerfil(privilegio perfil) {
        this.perfil = perfil;
    }



    
    public Object Datos(){
        Object datos[]={
            this.getDocumento(),
            this.getTipo_doc(),
            this.getPassword(),
            this.getCorreo(),
            this.getNombre(),
            this.getApellido(),
            this.getFecha_nac(),
            this.getTelefono(),
            this.getDireccion(),
            this.getFecha_reg(),
            this.getGenero(),
            this.getFoto(),
            this.perfil,
            this.getEstado()
            };
        return datos;
    }
    
    
    
    
    public boolean Session(){
      return _personal.Session(this);
  }
    public int Insertar(){
       return _personal.Insertar(this);
    }
    public int Actualizar(){
       return _personal.Actualizar(this);
    }
    public int Estado(){
        if(super.getEstado()=="1"){
            super.setEstado("0");
        }else{
           super.setEstado("1");
        }
       return _personal.Estado(this);
    }
    public int Ver_x_id(){
       return _personal.Ver_x_id(this);
    }
   public ArrayList<personal> Ver_todo(){
        return _personal.Ver_todo();
    }
   public ArrayList<personal> Ver_x_estado(){
        return _personal.Ver_x_estado(this);
        
    }
}
