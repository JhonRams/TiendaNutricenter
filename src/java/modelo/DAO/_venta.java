/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.cliente;
import modelo.delivery;
import modelo.distrito;
import modelo.personal;

import modelo.venta;

/**
 *
 * @author JR
 */
public class _venta {

    private static conexion db = new conexion();

    private static int Venta(venta obj, ResultSet rs) {
        try {
            rs.next();
            obj.setId(rs.getString(1));
                obj.setFecha_venta(rs.getString(2));
                obj.setFecha_pedido(rs.getString(3));
                obj.setSubtotal(rs.getFloat(4));
                obj.setDescuento(rs.getFloat(5));
                obj.setIGV(rs.getFloat(6));
                obj.setTotal(rs.getFloat(7));
                obj.setCliente(rs.getString(8));
                if (rs.getString(8)!=null) {
                cliente objcli = new cliente(rs.getString(8));
                objcli.Ver_x_id();
                obj.setObjCliente(objcli);
                }
                obj.setDelivery(rs.getString(9));
                if (rs.getString(9)!=null) {
                delivery objdely = new delivery(rs.getInt(9));
                objdely.Ver_x_id();
                obj.setObjdelivery(objdely);
                }
                obj.setEstado(rs.getString(10));
                obj.setVendedor(rs.getString(11));
                if (rs.getString(11)!=null) {
                    personal objperso = new personal(rs.getString(11));
                    objperso.Ver_x_id();
                    obj.setObjPersonal(objperso);
                }
                obj.setNumero_pago(rs.getString(12));
                obj.setDireccion(rs.getString(13));
                obj.setDistrito(rs.getString(14));
                if(rs.getString(14)!=null){
                    distrito objdist=new distrito(rs.getString(14));
                    objdist.Ver_x_id();
                    obj.setObjDistrito(objdist);
                }
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<venta> Ventas(ResultSet rs) {
        ArrayList<venta> list = new ArrayList<>();
        try {
            while (rs.next()) {
                venta obj = new venta();
                obj.setId(rs.getString(1));
                obj.setFecha_venta(rs.getString(2));
                obj.setFecha_pedido(rs.getString(3));
                obj.setSubtotal(rs.getFloat(4));
                obj.setDescuento(rs.getFloat(5));
                obj.setIGV(rs.getFloat(6));
                obj.setTotal(rs.getFloat(7));
                obj.setCliente(rs.getString(8));
                if (rs.getString(8)!=null) {
                cliente objcli = new cliente(rs.getString(8));
                objcli.Ver_x_id();
                obj.setObjCliente(objcli);
                }
                obj.setDelivery(rs.getString(9));
                if (rs.getString(9)!=null) {
                delivery objdely = new delivery(rs.getInt(9));
                objdely.Ver_x_id();
                obj.setObjdelivery(objdely);
                }
                obj.setEstado(rs.getString(10));
                obj.setVendedor(rs.getString(11));
                if (rs.getString(11)!=null) {
                    personal objperso = new personal(rs.getString(11));
                    objperso.Ver_x_id();
                    obj.setObjPersonal(objperso);
                }
                obj.setNumero_pago(rs.getString(12));
                obj.setDireccion(rs.getString(13));
                obj.setDistrito(rs.getString(14));
                if(rs.getString(14)!=null){
                    distrito objdist=new distrito(rs.getString(14));
                    objdist.Ver_x_id();
                    obj.setObjDistrito(objdist);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int ultimo() {
        try {
            String sql = "SELECT MAX(id)FROM ventas";
            ResultSet rs = db.consulta(sql, null);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int Online(venta obj) {
        String sql = "INSERT INTO ventas (fecha_pedido, subtotal, descuento, IGV, total, cliente, delivery, estado, numero_pago, direccion, distrito) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Object val[] = {
            obj.getFecha_pedido(),
            obj.getSubtotal(),
            obj.getDescuento(),
            obj.getIGV(),
            obj.getTotal(),
            obj.getCliente(),
            obj.getDelivery(),
            obj.getEstado(),
            obj.getNumero_pago(),
            obj.getDireccion(),
            obj.getDistrito()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(venta obj) {
        String sql = "SELECT * FROM ventas WHERE id=?";
        Object val[] = {
            obj.getId()
        };
        return Venta(obj, db.consulta(sql, val));
    }

    public static ArrayList<venta> Ver_x_estado(String es) {
        String sql = "SELECT * FROM ventas WHERE estado=?";
        Object val[] = {es};
        return Ventas(db.consulta(sql, val));
    }
    public static ArrayList<venta> Ver_x_estado_delivery(String es,int del) {
        String sql = "SELECT * FROM ventas WHERE estado=? AND delivery=?";
        Object val[] = {es,del};
        return Ventas(db.consulta(sql, val));
    }
    public static int Vender(Object[] val){
        String sql="UPDATE ventas SET vendedor=?,estado=? WHERE id=?";
         return db.transac(sql, val);
    }
    public static int Entregar(Object[] val){
        String sql="UPDATE ventas SET fecha_venta=?,estado=? WHERE id=?";
         return db.transac(sql, val);
    }

    //INSERT INTO `dbbioseguridad`.`ventas` (`id`, `fecha_venta`, `fecha_pedido`, `subtotal`, `descuento`, `IGV`, `total`, `cliente`, `delivery`, `estado`, `vendedor`, `numero_pago`, `direccion`, `distrito`) VALUES (NULL, '2020-12-13 00:00:00', '2020-12-14 00:00:00', '164', '0', '36.0', '200.0', '564645', '1', 'pedido', '788885', '456546', 'calle los incas 456', '2');
}
