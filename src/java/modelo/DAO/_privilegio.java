/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.privilegio;

/**
 *
 * @author JR
 */
public class _privilegio {

    private static conexion db = new conexion();

    private static int Privilegio(privilegio obj, ResultSet rs) {
        try {
            rs.next();
            if (rs.getRow() == 1) {
                obj.setNombre(rs.getString("nombre"));
                obj.setPermisos(rs.getString("permisos"));
                obj.setEstado(rs.getString("estado"));
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<privilegio> Privilegios(ResultSet rs) {
        ArrayList<privilegio> list = new ArrayList<privilegio>();
        try {
            while (rs.next()) {
                privilegio obj = new privilegio();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("nombre"));
                obj.setPermisos(rs.getString("permisos"));
                obj.setEstado(rs.getString("estado"));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(privilegio obj) {
        String sql = "INSERT INTO privilegios (nombre,permisos,estado) VALUES(?,?,?)";
        Object val[] = {obj.getNombre(),
            obj.getPermisos(),
            obj.getEstado()
        };
        return db.transac(sql, val);
    }

    public static int Actualizar(privilegio obj) {
        String sql = "UPDATE privilegios SET nombre=?,permisos=?,estado=? WHERE id=?";
        Object val[] = {obj.getNombre(),
            obj.getPermisos(),
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Estado(privilegio obj) {
        String sql = "UPDATE privilegios SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(privilegio obj) {
        String sql = "SELECT * FROM privilegios WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Privilegio(obj, db.consulta(sql, val));
    }

    public static ArrayList<privilegio> Ver_todo() {
        String sql = "SELECT * FROM privilegios";
        return Privilegios(db.consulta(sql,null));

    }
    public static ArrayList<privilegio> Ver_x_estado(privilegio obj) {
        String sql = "SELECT * FROM privilegios WHERE estado=?";
        Object val[] = {
            obj.getId()
        };
        return Privilegios(db.consulta(sql,val));

    }


}
