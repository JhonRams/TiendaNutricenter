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
import modelo.delivery;
import modelo.personal;

/**
 *
 * @author JR
 */
public class _delivery {

    private static conexion db = new conexion();

    private static int Delivery(delivery obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getInt(1));
            obj.setDias(rs.getString(2));
            obj.setHora_inicio(rs.getString(3));
            obj.setHora_fin(rs.getString(4));
            obj.setEstado(rs.getString(5));
            obj.setUsuario(rs.getString(6));
            personal objperso = new personal(rs.getString(6));
            objperso.Ver_x_id();
            obj.setObjPersonal(objperso);
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<delivery> Deliveries(ResultSet rs) {
        ArrayList<delivery> list = new ArrayList<>();
        try {
            while (rs.next()) {
                delivery obj = new delivery();
                obj.setId(rs.getInt(1));
                obj.setDias(rs.getString(2));
                obj.setHora_inicio(rs.getString(3));
                obj.setHora_fin(rs.getString(4));
                obj.setEstado(rs.getString(5));
                obj.setUsuario(rs.getString(6));
                personal objperso = new personal(rs.getString(6));
                objperso.Ver_x_id();
                obj.setObjPersonal(objperso);
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(delivery obj) {
        String sql = "INSERT INTO delivery (dias,hora_inicio,hora_fin,estado,usuario) VALUES(?,?,?,?,?)";
        return db.transac(sql, obj.DELIVERY());
    }

    public static int Actualizar(delivery obj) {
        String sql = "UPDATE delivery SET dias=?,hora_inicio=?,hora_fin=?,usuario=? WHERE id=?";
        Object val[] = {obj.getDias(),
            obj.getHora_inicio(),
            obj.getHora_fin(),
            obj.getUsuario()
        };
        return db.transac(sql, val);
    }

    public static int Estado(delivery obj) {
        String sql = "UPDATE delivery SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(delivery obj) {
        String sql = "SELECT * FROM delivery WHERE id=?";
        return Delivery(obj, db.consulta(sql, obj.ID()));
    }
    public static int Ver_x_personal(delivery obj) {
        String sql = "SELECT * FROM delivery WHERE usuario=?";
        Object val[]={obj.getUsuario()};
        return Delivery(obj, db.consulta(sql, val));
    }

    public static ArrayList<delivery> Ver_todo() {
        String sql = "SELECT * FROM delivery";
        return Deliveries(db.consulta(sql, null));

    }

    public static ArrayList<delivery> Ver_x_estado() {
        String sql = "SELECT * FROM delivery WHERE estado='s'";

        return Deliveries(db.consulta(sql, null));
    }

}
