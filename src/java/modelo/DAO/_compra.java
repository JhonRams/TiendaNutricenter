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
import modelo.compra;
import modelo.personal;

/**
 *
 * @author JR
 */
public class _compra {

    private static conexion db = new conexion();

    private static int Compra(compra obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setFecha_orden(rs.getString(2));
            obj.setCosto(rs.getDouble(3));
            obj.setUsuario(rs.getString(4));
            personal objperso = new personal(rs.getString(4));
             objperso.Ver_x_id();
            obj.setObjPersonal(objperso);
            obj.setEstado(rs.getString(5));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<compra> Compras(ResultSet rs) {
        ArrayList<compra> list = new ArrayList<>();
        try {
            while (rs.next()) {
                compra obj = new compra();
                obj.setId(rs.getString(1));
                obj.setFecha_orden(rs.getString(2));
                obj.setCosto(rs.getDouble(3));
                obj.setUsuario(rs.getString(4));
                personal objperso = new personal(rs.getString(4));
                objperso.Ver_x_id();
                obj.setObjPersonal(objperso);
                obj.setEstado(rs.getString(5));

                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(compra obj) {
        String sql = "INSERT INTO compra (fecha_compra,costo,usuario,estado) VALUES(?,?,?,?)";
        Object val[]={obj.getFecha_orden(),obj.getCosto(),obj.getUsuario(),obj.getEstado()};
        return db.transac(sql, val);
    }

    public static int Actualizar(compra obj) {
        String sql = "UPDATE compra SET fecha_compra=?,costo=?,usuario=? WHERE id=?";
        Object val[] = {obj.getId()};
        return db.transac(sql, val);
    }

    public static int Estado(compra obj) {
        String sql = "UPDATE compra SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }
    public static int Completado(Object val[]) {
        String sql = "UPDATE compra SET estado=? WHERE id=?";
        return db.transac(sql, val);
    }


    public static int Ver_x_id(compra obj) {
        String sql = "SELECT * FROM compra WHERE id=?";
        Object val[] = {obj.getId()};
        return Compra(obj, db.consulta(sql, val));
    }
    public static String ultimoIn() {
        try {
            String sql = "SELECT MAX(id) FROM compra";
            ResultSet rs=db.consulta(sql, null);
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException ex) {
           
        }
        return "";
    }

    public static ArrayList<compra> Ver_todo() {
        String sql = "SELECT * FROM compra";
        return Compras(db.consulta(sql, null));

    }

    public static ArrayList<compra> Ver_x_estado(String est) {
        String sql = "SELECT * FROM compra WHERE estado=?";
        Object val[] = {est};
        return Compras(db.consulta(sql, val));
    }
}
