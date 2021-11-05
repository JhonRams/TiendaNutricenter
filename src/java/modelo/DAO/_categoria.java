/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.categoria;


/**
 *
 * @author JR
 */
public class _categoria {

    private static conexion db = new conexion();

    private static int Categoria(categoria obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setDescripcion(rs.getString(3));
            obj.setEstado(rs.getString(4));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<categoria> Categorias(ResultSet rs) {
        ArrayList<categoria> list = new ArrayList<categoria>();
        try {
            while (rs.next()) {
                categoria obj = new categoria();
                obj.setId(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setDescripcion(rs.getString(3));
                obj.setEstado(rs.getString(4));

                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(categoria obj) {
        String sql = "INSERT INTO categorias (nombre,descripcion,estado) VALUES(?,?,?)";
        return db.transac(sql, obj.Datos());
    }

    public static int Actualizar(categoria obj) {
        String sql = "UPDATE categorias SET nombre=?,descripcion=?, WHERE id=?";
        Object val[]={obj.getNombre(),obj.getDescripcion()};
        return db.transac(sql, val);
    }

    public static int Estado(categoria obj) {
        String sql = "UPDATE categorias SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(categoria obj) {
        String sql = "SELECT * FROM categorias WHERE id=?";
        return Categoria(obj, db.consulta(sql, obj.ID()));
    }

    public static ArrayList<categoria> Ver_todo() {
        String sql = "SELECT * FROM categorias";
        return Categorias(db.consulta(sql, null));

    }

  
    public static ArrayList<categoria> Ver_x_estado() {
        String sql = "SELECT * FROM categorias WHERE estado='s'";

        return Categorias(db.consulta(sql, null));
    }

    
}
