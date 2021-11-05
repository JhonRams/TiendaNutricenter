/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author JR
 */
public class persona {

    private String documento;
    private String tipo_doc;
    private String correo;
    private String password;
    private String nombre;
    private String apellido;
    private String foto;
    private String fecha_nac;
    private String fecha_reg;
    private String telefono;
    private String direccion;
    private String genero;
    private String estado;

    public persona() {
    }

    public persona(String documento) {
        this.documento = documento;
    }

    public persona(String documento, String tipo_doc, String correo, String password, String nombre, String apellido, String foto, String fecha_nac, String fecha_reg, String telefono, String direccion, String genero, String estado) {
        this.documento = documento;
        this.tipo_doc = tipo_doc;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.fecha_nac = fecha_nac;
        this.fecha_reg = fecha_reg;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.estado = estado;
    }

    public Object[] Persona() {
        Object datos[] = {this.documento,
            this.tipo_doc,
            this.password,
            this.correo,
            this.nombre,
            this.apellido,
            this.foto,
            this.fecha_nac,
            this.fecha_reg,
            this.telefono,
            this.direccion,
            this.genero,
            this.estado,};
        return datos;
    }

    public Object[] Persona_U() {
        Object datos[] = {
            this.documento,
            this.tipo_doc,
            this.nombre,
            this.apellido,
            this.foto,
            this.fecha_nac,
            this.telefono,
            this.direccion,
            this.genero,
            this.correo};
        return datos;
    }

    public Object[] Persona_doc() {
        Object datos[] = {this.documento};
        return datos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
