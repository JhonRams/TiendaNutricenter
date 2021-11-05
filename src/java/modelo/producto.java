/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._producto;

/**
 *
 * @author JR
 */
public class producto {

    private String codigo;
    private String nombre;
    private float costo;
    private float precio;
    private String detalle;
    private String marca;
    private String foto;
    private String medida;
    private int Stock;
    private String fecha_ingreso;
    private String proveedor;
    private int categoria;
    private String estado;

    private categoria objCategoria;
    private proveedor objProveedor;

    public producto() {
    }

    public producto(String codigo) {
        this.codigo = codigo;
    }

    public producto(String codigo, String nombre, float costo, float precio, String detalle, String marca, String foto, String medida, int Stock, String fecha_ingreso, String proveedor, int categoria, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.precio = precio;
        this.detalle = detalle;
        this.marca = marca;
        this.foto = foto;
        this.medida = medida;
        this.Stock = Stock;
        this.fecha_ingreso = fecha_ingreso;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public categoria getObjCategoria() {
        return objCategoria;
    }

    public void setObjCategoria(categoria objPategoria) {
        this.objCategoria = objPategoria;
    }

    public proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    public Object[] PRODUCTO() {
        Object datos[] = {
            this.nombre,
            this.costo,
            this.precio,
            this.detalle,
            this.marca,
            this.foto,
            this.medida,
            this.Stock,
            this.fecha_ingreso,
            this.proveedor,
            this.categoria,
            this.estado,};
        return datos;
    }

    public Object[] CODIGO() {
      Object datos[] = {
            this.codigo  };
      return datos;
    }
    public Object[] PRODUCTO_U() {
        Object datos[] = {
            this.nombre,
            this.costo,
            this.precio,
            this.detalle,
            this.marca,
            this.foto,
            this.medida,
            this.Stock,
            this.fecha_ingreso,
            this.proveedor,
            this.categoria,
            this.codigo};
        return datos;
    }

    public int Insertar() {
        return _producto.Insertar(this);
    }

    public int Actualizar() {
        return _producto.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado = "0";
        } else {
            this.estado = "1";
        }
        return _producto.Estado(this);
    }

    public int Ver_x_id() {
        return _producto.Ver_x_id(this);
    }

    public ArrayList<producto> Ver_todo() {
        return _producto.Ver_todo();
    }

    public ArrayList<producto> Ver_x_marca() {
        return _producto.Ver_x_marca(this);

    }
    public ArrayList<producto> Ver_x_categoria() {
        return _producto.Ver_x_categoria(this);

    }
    public ArrayList<producto> Ver_x_estado() {
        return _producto.Ver_x_estado();

    }

}
