/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.detalle_venta;
import modelo.producto;
import modelo.servicio;
import modelo.venta;

/**
 *
 * @author JR
 */
public class _detalle_venta {

    private static conexion db = new conexion();

    private static int Detalle_venta(detalle_venta obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
            obj.setVenta(rs.getString(2));
            if (rs.getString(3) != null) {
                obj.setProducto(rs.getString(3));
                producto objPro = new producto(rs.getString(3));
                objPro.Ver_x_id();
                obj.setObjProducto(objPro);
            } else {
                obj.setServicio(rs.getString(5));
                servicio objservi = new servicio(rs.getString(5));
                objservi.Ver_x_id();
                obj.setObjServicio(objservi);
            }
            obj.setCantidad(rs.getInt(4));
            obj.setPrecio(rs.getFloat(6));
            obj.setSubtotal(rs.getFloat(7));
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<detalle_venta> Detalle_ventas(ResultSet rs) {
        ArrayList<detalle_venta> list = new ArrayList<>();
        try {
            while (rs.next()) {
                detalle_venta obj = new detalle_venta();
                obj.setId(rs.getString(1));
                obj.setVenta(rs.getString(2));
                venta objVent=new venta(rs.getString(2));
                objVent.ver_x_id();
                obj.setObjVenta(objVent);
                
                if (rs.getString(3) != null) {
                    obj.setProducto(rs.getString(3));
                    producto objPro = new producto(rs.getString(3));
                    objPro.Ver_x_id();
                    obj.setObjProducto(objPro);
                } else {
                    obj.setServicio(rs.getString(5));
                    servicio objservi = new servicio(rs.getString(5));
                    objservi.Ver_x_id();
                    obj.setObjServicio(objservi);
                }
                obj.setCantidad(rs.getInt(4));
                obj.setPrecio(rs.getFloat(6));
                obj.setSubtotal(rs.getFloat(7));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(detalle_venta obj) {
        String sql;
        Object val[] = new Object[5];
        val[0] = obj.getVenta();
        val[1] = obj.getCantidad();
        if (obj.getProducto() != null) {
            sql = "INSERT INTO detalle_ventas (venta,cantidad, producto,precio,subtotal) VALUES(?,?,?,?,?)";
            val[2] = obj.getProducto();
            Object cantdd[] = {obj.getCantidad(), obj.getProducto()};
            _producto.Actualiza_stock(cantdd);
        } else {
            sql = "INSERT INTO detalle_ventas (venta,cantidad,servicio,precio,subtotal) VALUES(?,?,?,?,?)";
            val[2] = obj.getServicio();
        }
        val[3] = obj.getPrecio();
        val[4] = obj.getSubtotal();
        return db.transac(sql, val);
    }

    public static ArrayList<detalle_venta> lista_detalle_x_venta(String id) {
        String sql = "SELECT * FROM detalle_ventas WHERE venta=?";
        Object val[] = {id};
        return Detalle_ventas(db.consulta(sql, val));
    }
    public static ArrayList<detalle_venta> lista_detalle_producto() {
        String sql = "SELECT * FROM detalle_ventas WHERE producto IS NOT NULL";
        return Detalle_ventas(db.consulta(sql, null));
    }
    public static ArrayList<detalle_venta> lista_detalle_producto_fecha() {
        String sql = "SELECT * FROM detalle_ventas WHERE producto IS NOT NULL AND SELECT fecha_venta FROM ventas ";
        return Detalle_ventas(db.consulta(sql, null));
    }
    //INSERT INTO `dbbioseguridad`.`detalle_ventas` (`id`, `venta`, `producto`, `cantidad`, `servicio`, `precio`, `subtotal`) VALUES (NULL, '1', '77854586', '10', NULL, '16', '160'), (NULL, '1', NULL, '1', '1', '200', '200');
}
