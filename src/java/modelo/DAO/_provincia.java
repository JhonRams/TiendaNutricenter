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
import modelo.departamento;
import modelo.provincia;

/**
 *
 * @author JR
 */
public class _provincia {

    private static conexion db = new conexion();

    private static int Provincia(provincia obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setNombre(rs.getString(2));
            obj.setDepartamento(rs.getString(3));
            departamento objdep = new departamento(rs.getString(3));
            objdep.Ver_x_id();
            obj.setObjDepartamento(objdep);
            obj.setEstado(rs.getString(4));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<provincia> Provincias(ResultSet rs) {
        ArrayList<provincia> list = new ArrayList<>();
        try {
            while (rs.next()) {
                provincia obj = new provincia();
                obj.setId(rs.getString(1));
                obj.setNombre(rs.getString(2));
                obj.setDepartamento(rs.getString(3));
                departamento objdep = new departamento(rs.getString(3));
                objdep.Ver_x_id();
                obj.setObjDepartamento(objdep);
                obj.setEstado(rs.getString(4));
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(provincia obj) {
        String sql = "INSERT INTO provincias (nombre,departamento,estado) VALUES(?,?)";
        Object val[] = {obj.getNombre(),obj.getDepartamento(), obj.getEstado()};
        return db.transac(sql, val);
    }

    public static int Actualizar(provincia obj) {
        String sql = "UPDATE provincias SET nombre=?,departamento=? WHERE id=?";
        Object val[] = {obj.getNombre(),obj.getDepartamento(),obj.getId()};
        return db.transac(sql, val);
    }

    public static int Estado(provincia obj) {
        String sql = "UPDATE provincias SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(provincia obj) {
        String sql = "SELECT * FROM provincias WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Provincia(obj, db.consulta(sql, val));
    }

    public static ArrayList<provincia> Ver_todo() {
        String sql = "SELECT * FROM provincias";
        return Provincias(db.consulta(sql, null));

    }

    public static ArrayList<provincia>  Ver_X_depart(String depa){
        try {
            String sql = "SELECT id,nombre FROM provincias WHERE departamento=? AND estado=?";
            Object val[]={depa,"1"};
            ResultSet rs=db.consulta(sql, val);
            ArrayList<provincia>  lista=new ArrayList<>();
            while (rs.next()) {
                provincia objpr=new provincia();
                objpr.setId(rs.getString(1));
                objpr.setNombre(rs.getString(2));
                lista.add(objpr);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static ArrayList<provincia> Ver_x_estado() {
        String sql = "SELECT * FROM provincias WHERE estado='1'";
        return Provincias(db.consulta(sql, null));
    }

}
