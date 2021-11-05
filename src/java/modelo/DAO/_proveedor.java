/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.proveedor;

/**
 *
 * @author JR
 */
public class _proveedor {

    private static conexion db = new conexion();

    private static int Proveedor(proveedor obj, ResultSet rs) {
        try {
            rs.next();
            obj.setDocumento(rs.getString(1));
            obj.setTipo_doc(rs.getString(2));
            obj.setNombre(rs.getString(3));
            obj.setTelefono(rs.getString(4));
            obj.setCorreo(rs.getString(5));
            obj.setDireccion(rs.getString(6));
            obj.setCalificacion(rs.getInt(7));
            obj.setEstado(rs.getString(8));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<proveedor> Proveedores(ResultSet rs) {
        ArrayList<proveedor> list = new ArrayList<proveedor>();
        try {
            while (rs.next()) {
                proveedor obj = new proveedor();
                obj.setDocumento(rs.getString(1));
                obj.setTipo_doc(rs.getString(2));
                obj.setNombre(rs.getString(3));
                obj.setTelefono(rs.getString(4));
                obj.setCorreo(rs.getString(5));
                obj.setDireccion(rs.getString(6));
                obj.setCalificacion(rs.getInt(7));
                obj.setEstado(rs.getString(8));

                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(proveedor obj) {
        String sql = "INSERT INTO proveedores (documento,tipo_doc,nombre,telefono,correo,direccion,calificacion,estado) VALUES(?,?,?,?,?,?,?,?)";
        return db.transac(sql, obj.DATOS());
    }

    public static int Actualizar(proveedor obj) {
        String sql = "UPDATE proveedores SET nombre=?,telefono=?,correo=?,direccion=?,calificacion=? WHERE documento=?";
        return db.transac(sql, obj.DATOS_U());
    }

    public static int Estado(proveedor obj) {
        String sql = "UPDATE proveedores SET estado=? WHERE documento=?";
        Object val[] = {
            obj.getEstado(),
            obj.getDocumento()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(proveedor obj) {
        String sql = "SELECT * FROM proveedores WHERE documento=?";
        return Proveedor(obj, db.consulta(sql, obj.Persona_doc()));
    }

    public static ArrayList<proveedor> Ver_todo() {
        String sql = "SELECT * FROM proveedores";
        return Proveedores(db.consulta(sql, null));

    }

    public static ArrayList<proveedor> Ver_x_estado(proveedor obj) {
        String sql = "SELECT * FROM proveedores WHERE estado='s'";

        return Proveedores(db.consulta(sql,null));
    }

}
