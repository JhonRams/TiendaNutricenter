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
import modelo.categoria;
import modelo.cliente;
import modelo.producto;
import modelo.proveedor;

/**
 *
 * @author JR
 */
public class _producto {

    private static conexion db = new conexion();

    private static int Producto(producto obj, ResultSet rs) {
        try {
            rs.next();
            obj.setCodigo(rs.getString(1));
            obj.setNombre(rs.getString(2));
            obj.setCosto(rs.getFloat(3));
            obj.setPrecio(rs.getFloat(4));
            obj.setDetalle(rs.getString(5));
            obj.setMarca(rs.getString(6));
            obj.setFoto(rs.getString(7));
            obj.setMedida(rs.getString(8));
            obj.setStock(rs.getInt(9));
            obj.setFecha_ingreso(rs.getString(10));
            obj.setProveedor(rs.getString(11));
            proveedor objpro = new proveedor(rs.getString(11));
            objpro.Ver_x_id();
            obj.setObjProveedor(objpro);
            obj.setCategoria(rs.getInt(12));
            categoria objCate = new categoria(rs.getInt(12));
            objCate.Ver_x_id();
            obj.setObjCategoria(objCate);
            obj.setEstado(rs.getString(13));

            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<producto> Productos(ResultSet rs) {
        ArrayList<producto> list = new ArrayList<producto>();
        try {
            while (rs.next()) {
                producto obj = new producto();
                obj.setCodigo(rs.getString(1));
                obj.setNombre(rs.getString(2));
                obj.setCosto(rs.getFloat(3));
                obj.setPrecio(rs.getFloat(4));
                obj.setDetalle(rs.getString(5));
                obj.setMarca(rs.getString(6));
                obj.setFoto(rs.getString(7));
                obj.setMedida(rs.getString(8));
                obj.setStock(rs.getInt(9));
                obj.setFecha_ingreso(rs.getString(10));
                obj.setProveedor(rs.getString(11));
                proveedor objpro = new proveedor(rs.getString(11));
                objpro.Ver_x_id();
                obj.setObjProveedor(objpro);
                obj.setCategoria(rs.getInt(12));
                categoria objCate = new categoria(rs.getInt(12));
                objCate.Ver_x_id();
                obj.setObjCategoria(objCate);
                obj.setEstado(rs.getString(13));
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(producto obj) {
        String sql = "INSERT INTO productos (nombre,costo,precio,detalle,marca,foto,medida,stock,fecha_ingreso,proveedor,categoria,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return db.transac(sql, obj.PRODUCTO());
    }

    public static int Actualizar(producto obj) {
        String sql = "UPDATE productos SET nombre=?,costo=?,precio=?,detalle=?,marca=?,foto=?,medida=?,stock=?,fecha_ingreso=?,proveedor=?,categoria=? WHERE codigo=?";
        return db.transac(sql, obj.PRODUCTO_U());
    }

    public static int Estado(producto obj) {
        String sql = "UPDATE productos SET estado=? WHERE codigo=?";
        Object val[] = {
            obj.getEstado(),
            obj.getCodigo()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(producto obj) {
        String sql = "SELECT * FROM productos WHERE codigo=?";
        return Producto(obj, db.consulta(sql, obj.CODIGO()));
    }

    public static ArrayList<producto> Ver_todo() {
        String sql = "SELECT * FROM productos";
        return Productos(db.consulta(sql, null));

    }
    public static String[] lista_Marcas() {
         String marca="";
        try {
            String sql = "SELECT DISTINCT marca FROM productos ORDER BY marca";
            ResultSet rs=db.consulta(sql, null);
           
            while (rs.next()) {
                marca+=rs.getString(1)+"/";
            }
        } catch (SQLException ex) {
           
        }
        String marcas[]= marca.split("/");
       return marcas;
    }
    public static ArrayList<producto> Ver_x_marca(producto obj) {
        String sql = "SELECT * FROM productos WHERE marca=?";
        Object val[] = {obj.getMarca()};
        return Productos(db.consulta(sql, val));
    }
    public static ArrayList<producto> Ver_x_categoria(producto obj) {
        String sql = "SELECT * FROM productos WHERE categoria=?";
        Object val[] = {obj.getCategoria()};
        return Productos(db.consulta(sql, val));
    }

    public static ArrayList<producto> Ver_x_estado() {
        String sql = "SELECT * FROM productos WHERE estado='s'";

        return Productos(db.consulta(sql, null));
    }
    public static int Actualiza_stock(Object val[]){
        String sql = "UPDATE productos SET stock=stock-? WHERE codigo=?";
           return db.transac(sql, val);
    }
    public static int Actualiza_stock_y_precio(Object val[]){
        String sql = "UPDATE productos SET stock=stock+?,costo=? WHERE codigo=?";
           return db.transac(sql, val);
    }

}
