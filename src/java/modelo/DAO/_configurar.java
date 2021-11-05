/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JR
 */
public class _configurar {
     private static conexion db = new conexion();
     
     public static int IGV() {
         try {
             String sql = "SELECT IGV FROM configurar ";
             ResultSet rs=db.consulta(sql, null);
             rs.next();
             return rs.getInt(1);
         } catch (SQLException ex) {
             return 0;
         }
    }
     public static String Empresa() {
         try {
             String sql = "SELECT nombre FROM configurar ";
             ResultSet rs=db.consulta(sql, null);
             rs.next();
             return rs.getString(1);
         } catch (SQLException ex) {
             return "";
         }
    }
     public static int Actualizar(int IGV,String nombre) {
        String sql = "UPDATE configurar SET IGV=?,nombre=?, WHERE id='1'";
        Object val[]={IGV,nombre};
        return db.transac(sql, val);
    }
}
