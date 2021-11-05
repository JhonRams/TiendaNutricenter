/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cliente;

/**
 *
 * @author JR
 */
public class _cliente {

    private static conexion db = new conexion();

    private static int Cliente(cliente obj, ResultSet rs) {
        try {
           rs.next();
                obj.setDocumento(rs.getString(1));
                obj.setTipo_doc(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setCorreo(rs.getString(4));
                obj.setNombre(rs.getString(5));
                obj.setApellido(rs.getString(6));
                obj.setFoto(rs.getString(7));
                obj.setFecha_nac(rs.getString(8));
                obj.setFecha_reg(rs.getString(9));
                obj.setTelefono(rs.getString(10));
                obj.setDireccion(rs.getString(11));
                obj.setGenero(rs.getString(12));
                obj.setDescuento(rs.getInt(13));
                obj.setEstado(rs.getString(14));
                return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<cliente> Clientes(ResultSet rs) {
        ArrayList<cliente> list = new ArrayList<>();
        try {
            while (rs.next()) {
                cliente obj = new cliente();
obj.setDocumento(rs.getString(1));
                obj.setTipo_doc(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setCorreo(rs.getString(4));
                obj.setNombre(rs.getString(5));
                obj.setApellido(rs.getString(6));
                obj.setFoto(rs.getString(7));
                obj.setFecha_nac(rs.getString(8));
                obj.setFecha_reg(rs.getString(9));
                obj.setTelefono(rs.getString(10));
                obj.setDireccion(rs.getString(11));
                obj.setGenero(rs.getString(12));
                obj.setDescuento(rs.getInt(13));
                obj.setEstado(rs.getString(14));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(cliente obj) {
        String sql = "INSERT INTO clientes (documento,tipo_documento,password,correo,nombre,apellido,foto,fech_nac,fech_reg,telefono,direccion,genero,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return db.transac(sql, obj.Persona());
    }

    public static int Actualizar(cliente obj) {
        String sql = "UPDATE clientes SET documento=?,tipo_documento=?, nombre=?,apellido=?,foto=?,fech_nac=?,telefono=?,direccion=?,genero=? WHERE correo=?";
        return db.transac(sql, obj.Persona_U());
    }

    public static int Estado(cliente obj) {
        String sql = "UPDATE privilegios SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getDocumento()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(cliente obj) {
        String sql = "SELECT * FROM clientes WHERE documento=?";
        return Cliente(obj, db.consulta(sql, obj.Persona_doc()));
    }

    public static ArrayList<cliente> Ver_todo() {
        String sql = "SELECT * FROM privilegios";
        return Clientes(db.consulta(sql, null));

    }

    public static ArrayList<cliente> Ver_x_estado(cliente obj) {
        String sql = "SELECT * FROM privilegios WHERE estado=?";

        return Clientes(db.consulta(sql, obj.Persona_doc()));
    }

    public static boolean Session(cliente obj) {
        try {
            String sql = "SELECT password,documento FROM clientes WHERE correo=? AND estado=?";
            Object val[] = {obj.getCorreo(),"s"};
            ResultSet rs = db.consulta(sql, val);
            rs.next();
            if(rs.getRow()>0){
            if (rs.getString(1).equals(obj.getPassword())) {
                obj.setDocumento(rs.getString(2));
                Ver_x_id(obj);
                return true;
            } else {
                return false;
            }
            } 
             return false;
        } catch (Exception ex) {
            obj.setDireccion("Error ami esta muy mal"+ex.toString());
            return false;
        }
    }

}
