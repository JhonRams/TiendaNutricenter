/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.detalle_compra;
import modelo.producto;

/**
 *
 * @author JR
 */
public class _detalle_compra {

    private static conexion db = new conexion();

    private static int Detalle_compra(detalle_compra obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setIdorden(rs.getString(2));
            obj.setIdProducto(rs.getString(3));
            producto objprod = new producto(rs.getString(3));
            objprod.Ver_x_id();
            obj.setObjProducto(objprod);
            obj.setCosto(rs.getDouble(4));
            obj.setCantidad(rs.getInt(5));
            obj.setSubtotal(rs.getDouble(6));
            obj.setFecha_ingreso(rs.getString(7));
            obj.setEstado(rs.getString(8));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<detalle_compra> Detalle_compras(ResultSet rs) {
        ArrayList<detalle_compra> list = new ArrayList<>();
        try {
            while (rs.next()) {
                detalle_compra obj = new detalle_compra();
                obj.setId(rs.getString(1));
                obj.setIdorden(rs.getString(2));
                obj.setIdProducto(rs.getString(3));
                producto objprod = new producto(rs.getString(3));
                objprod.Ver_x_id();
                obj.setObjProducto(objprod);
                obj.setCosto(rs.getDouble(4));
                obj.setCantidad(rs.getInt(5));
                obj.setSubtotal(rs.getDouble(6));
                obj.setFecha_ingreso(rs.getString(7));
                obj.setEstado(rs.getString(8));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(detalle_compra obj) {
        String sql = "INSERT INTO detalle_compras (cod_compra,producto,costo,cantidad,subtotal,estado) VALUES(?,?,?,?,?,?)";
       Object val[]={obj.getIdorden(),
       obj.getIdProducto(),
       obj.getCosto(),
       obj.getCantidad(),
       obj.getSubtotal(),
       obj.getEstado() };
        return db.transac(sql, val);
    }

    public static int Actualizar(detalle_compra obj) {
        String sql = "UPDATE detalle_compras SET fecha_compra=?,costo=?,usuario=? WHERE id=?";
        Object val[] = {obj.getId()};
        return db.transac(sql, val);
    }

    public static int Estado(detalle_compra obj) {
        String sql = "UPDATE detalle_compras SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }
    public static int Ingreso_almacen(detalle_compra obj) {
        String sql = "UPDATE detalle_compras SET fecha_ingreso=?,estado=? WHERE id=?";
        Object val[] = {
            util.utilidad.fecha(),
            obj.getEstado(),
            obj.getId()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(detalle_compra obj) {
        String sql = "SELECT * FROM detalle_compras WHERE id=?";
        Object val[] = {obj.getId()};
        return Detalle_compra(obj, db.consulta(sql, val));
    }

    public static ArrayList<detalle_compra> Ver_todo() {
        String sql = "SELECT * FROM detalle_compras";
        return Detalle_compras(db.consulta(sql, null));

    }

    public static ArrayList<detalle_compra> Ver_x_estado(String est) {
        String sql = "SELECT * FROM compra WHERE estado=?";
        Object val[] = {est};
        return Detalle_compras(db.consulta(sql, val));
    }

    public static ArrayList<detalle_compra> lista_detalle_x_orden(String est) {
        String sql = "SELECT * FROM detalle_compras WHERE cod_compra=?";
        Object val[] = {est};
        return Detalle_compras(db.consulta(sql, val));
    }
}
