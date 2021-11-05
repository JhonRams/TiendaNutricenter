/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.DAO._configurar;
import modelo.DAO._venta;

/**
 *
 * @author JR
 */
public class venta {

    private String id;
    private String fecha_venta;
    private String fecha_pedido;
    private float subtotal;
    private float descuento;
    private float IGV;
    private float total;
    private String cliente;
    private String delivery;
    private String estado;
    private String vendedor;
    private String numero_pago;
    private String direccion;
    private String distrito;
    private cliente objCliente;
    private delivery objdelivery;
    private personal objPersonal;
    private distrito objDistrito;

    public venta() {
    }

    public venta(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIGV() {
        return IGV;
    }

    public void setIGV(float IGV) {
        this.IGV = IGV;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNumero_pago() {
        return numero_pago;
    }

    public void setNumero_pago(String numero_pago) {
        this.numero_pago = numero_pago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(cliente objCliente) {
        this.objCliente = objCliente;
    }

    public delivery getObjdelivery() {
        return objdelivery;
    }

    public void setObjdelivery(delivery objdelivery) {
        this.objdelivery = objdelivery;
    }

    public personal getObjPersonal() {
        return objPersonal;
    }

    public void setObjPersonal(personal objPersonal) {
        this.objPersonal = objPersonal;
    }

    public distrito getObjDistrito() {
        return objDistrito;
    }

    public void setObjDistrito(distrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    public Object[] ID() {
        Object idv[] = {
            this.id
        };
        return idv;
    }

    public Object[] VENTA() {
        Object vent[] = {
            this.fecha_venta,
            this.fecha_pedido,
            this.subtotal,
            this.descuento,
            this.IGV,
            this.total,
            this.cliente,
            this.delivery,
            this.estado,
            this.vendedor,
            this.numero_pago,
            this.direccion,
            this.distrito
        };
        return vent;
    }

    public void calcular() {
        double igv = _configurar.IGV() * 0.01;
        this.IGV = (float) (this.total * igv);
    }
    public int Online() {
        calcular();
        return _venta.Online(this);
    }

    public int ver_x_id() {
        return _venta.Ver_x_id(this);
    }

}
