/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.servicio;

/**
 *
 * @author JR
 */
public class _servicio {

    private static conexion db = new conexion();
    private static int Servicio(servicio obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setNombre(rs.getString(2));
            obj.setDetalle(rs.getString(3));
            obj.setCosto(rs.getFloat(4));
            obj.setFoto(rs.getString(5));
            obj.setEstado(rs.getString(6));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }
 private static ArrayList<servicio> Servicios(ResultSet rs) {
        ArrayList<servicio> list = new ArrayList<>();
        try {
            while (rs.next()) {
                servicio obj = new servicio();
                obj.setId(rs.getString(1));
                obj.setNombre(rs.getString(2));
                obj.setDetalle(rs.getString(3));
                obj.setCosto(rs.getFloat(4));
                obj.setFoto(rs.getString(5));
                obj.setEstado(rs.getString(6));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    public static ArrayList<servicio> Ver_x_estado(servicio obj) {
        String sql = "SELECT * FROM servicios WHERE estado='s'";

        return Servicios(db.consulta(sql, null));
    }
    
    public static int Ver_x_id(servicio obj) {
        String sql = "SELECT * FROM servicios WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Servicio(obj, db.consulta(sql, val));
    }
}
