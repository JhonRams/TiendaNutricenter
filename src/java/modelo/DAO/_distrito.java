/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.distrito;
import modelo.provincia;

/**
 *
 * @author JR
 */
public class _distrito {

    private static conexion db = new conexion();

    private static int Distrito(distrito obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setNombre(rs.getString(2));
            obj.setProvincia(rs.getString(3));
            provincia objdep = new provincia(rs.getString(3));
            objdep.Ver_x_id();
            obj.setObjProvincia(objdep);
            obj.setEstado(rs.getString(4));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<distrito> Distritos(ResultSet rs) {
        ArrayList<distrito> list = new ArrayList<>();
        try {
            while (rs.next()) {
                distrito obj = new distrito();
                obj.setId(rs.getString(1));
                obj.setNombre(rs.getString(2));
                obj.setProvincia(rs.getString(3));
                provincia objdep = new provincia(rs.getString(3));
                objdep.Ver_x_id();
                obj.setObjProvincia(objdep);
                obj.setEstado(rs.getString(4));
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(distrito obj) {
        String sql = "INSERT INTO distritos (nombre,provincia,estado) VALUES(?,?)";
        Object val[] = {obj.getNombre(), obj.getProvincia(), obj.getEstado()};
        return db.transac(sql, val);
    }

    public static int Actualizar(distrito obj) {
        String sql = "UPDATE distritos SET nombre=?,provincia=? WHERE id=?";
        Object val[] = {obj.getNombre(), obj.getProvincia(), obj.getId()};
        return db.transac(sql, val);
    }

    public static int Estado(distrito obj) {
        String sql = "UPDATE distritos SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(distrito obj) {
        String sql = "SELECT * FROM distritos WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Distrito(obj, db.consulta(sql, val));
    }

    public static ArrayList<distrito> Ver_todo() {
        String sql = "SELECT * FROM distritos";
        return Distritos(db.consulta(sql, null));

    }

    public static ArrayList<distrito> Ver_x_estado() {
        String sql = "SELECT * FROM distritos WHERE estado='1'";
        return Distritos(db.consulta(sql, null));
    }
    
        public static ArrayList<distrito>  Ver_X_prov(String pro){
        try {
            String sql = "SELECT id,nombre FROM distritos WHERE provincia=? AND estado=?";
            Object val[]={pro,"1"};
            ResultSet rs=db.consulta(sql, val);
            ArrayList<distrito>  lista=new ArrayList<>();
            while (rs.next()) {
                distrito objpr=new distrito();
                objpr.setId(rs.getString(1));
                objpr.setNombre(rs.getString(2));
                lista.add(objpr);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

}
