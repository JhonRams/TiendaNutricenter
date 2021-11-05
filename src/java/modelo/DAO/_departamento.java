/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.departamento;

/**
 *
 * @author JR
 */
public class _departamento {

    private static conexion db = new conexion();

    private static int Departamento(departamento obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setNombre(rs.getString(2));
            obj.setEstado(rs.getString(3));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<departamento> Departamentos(ResultSet rs) {
        ArrayList<departamento> list = new ArrayList<>();
        try {
            while (rs.next()) {
                departamento obj = new departamento();
                obj.setId(rs.getString(1));
                obj.setNombre(rs.getString(2));
                obj.setEstado(rs.getString(3));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(departamento obj) {
        String sql = "INSERT INTO departamentos (nombre,estado) VALUES(?,?)";
        Object val[]={obj.getNombre(),obj.getEstado()};
        return db.transac(sql, val);
    }

    public static int Actualizar(departamento obj) {
        String sql = "UPDATE departamentos SET nombre=? WHERE id=?";
        Object val[]={obj.getNombre()};
        return db.transac(sql, val);
    }

    public static int Estado(departamento obj) {
        String sql = "UPDATE departamentos SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(departamento obj) {
        String sql = "SELECT * FROM departamentos WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Departamento(obj, db.consulta(sql, val));
    }

    public static ArrayList<departamento> Ver_todo() {
        String sql = "SELECT * FROM departamentos";
        return Departamentos(db.consulta(sql, null));

    }

  
    public static ArrayList<departamento> Ver_x_estado() {
        String sql = "SELECT * FROM departamentos WHERE estado='1'";
        return Departamentos(db.consulta(sql, null));
    }

    
}
