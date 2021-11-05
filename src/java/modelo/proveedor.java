/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._proveedor;

/**
 *
 * @author JR
 */
public class proveedor extends persona {

    private int calificacion;

    public proveedor() {
    }

    public proveedor(String documento) {
        super(documento);
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Object[] ID() {
        Object datos[] = {super.getDocumento()};
        return datos;
    }

    public Object[] DATOS_U() {
        Object datos[] = {
            super.getNombre(),
            super.getTelefono(),
            super.getCorreo(),
            super.getDireccion(),
            this.calificacion,
            super.getDocumento(),
            
        };
        return datos;
    }
    public Object[] DATOS() {
        Object datos[] = {
            super.getDocumento(),
            super.getTipo_doc(),
            super.getNombre(),
            super.getTelefono(),
            super.getCorreo(),
            super.getDireccion(),
            this.calificacion,
            super.getEstado(),
            
        };
        return datos;
    }
    public int Insertar(){
       return _proveedor.Insertar(this);
    }
    public int Actualizar(){
       return _proveedor.Actualizar(this);
    }
    public int Estado(){
        if(super.getEstado()=="1"){
            super.setEstado("0");
        }else{
           super.setEstado("1");
        }
       return _proveedor.Estado(this);
    }
    public int Ver_x_id(){
       return _proveedor.Ver_x_id(this);
    }
   public ArrayList<proveedor> Ver_todo(){
        return _proveedor.Ver_todo();
    }
   public ArrayList<proveedor> Ver_x_estado(){
        return _proveedor.Ver_x_estado(this);
        
    }   
}
