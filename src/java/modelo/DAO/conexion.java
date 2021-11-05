/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author JR
 */
public class conexion {

    Connection conn = null;
    public String message = "";

    public conexion() {
        try {
            if (conn == null) {
//                Properties prop = new Properties();
//                InputStream inputStream = conexion.class.getClassLoader().getResourceAsStream("confdb.properties");
//                prop.load(inputStream);
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/dbbioseguridad";
                String user = "root";
                String password = "";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);

                if (!conn.isClosed()) {
                    this.message = "conexion establecida";
                }
            }
        } catch (Exception e) {
            this.message = "imposible conetar a db" + e;
        }
    }
public PreparedStatement ps(String sql, Object val[]){
    try {
         PreparedStatement ps = conn.prepareStatement(sql);
            if (val != null) {
                for (int i = 0; i < val.length; i++) {
                    ps.setString(i + 1,val[i].toString());
                }
            }
            return ps;
    } catch (SQLException ex) {
        this.message = "Error Query" + ex;
            System.out.println("Errorsqa   " + ex);
            return null;
    }
}
    public int transac(String sql, Object val[]) {
        try {
            return ps(sql, val).executeUpdate();
        } catch (SQLException ex) {
            this.message = "Error En transaccion sql" + ex;
            System.out.println("Error En transaccion sql" + ex);
            return -1;
        } 
    }
    public ResultSet consulta(String sql, Object val[]) {
        try {
            return ps(sql, val).executeQuery();
        } catch (SQLException ex) {
            this.message = "Error en consulta sql" + ex;
            System.out.println("Error en consulta sql   " + ex);
            return null;
        }
    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            this.message = "Error close" + ex;
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
   
}
