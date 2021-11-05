/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.DAO._delivery;

/**
 *
 * @author JR
 */
public class delivery {

    private int id;
    private String dias;
    private String hora_inicio;
    private String hora_fin;
    private String estado;
    private String usuario;
    private personal objPersonal;

    public delivery() {
    }

    public delivery(int id) {
        this.id = id;
    }

    public delivery(String dias, String hora_inicio, String hora_fin, String estado, String usuario, personal objPersonal) {
        this.dias = dias;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.estado = estado;
        this.usuario = usuario;
        this.objPersonal = objPersonal;
    }

    public Object[] DELIVERY() {
        Object datos[] = {
            this.dias,
            this.hora_inicio,
            this.hora_fin,
            this.estado,
            this.usuario,};
        return datos;
    }

    public Object[] ID() {
        Object datos[] = {
            this.id};
        return datos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public personal getObjPersonal() {
        return objPersonal;
    }

    public void setObjPersonal(personal objPersonal) {
        this.objPersonal = objPersonal;
    }

    public int Insertar() {
        return _delivery.Insertar(this);
    }

    public int Actualizar() {
        return _delivery.Actualizar(this);
    }

    public int Estado() {
        if (this.estado == "1") {
            this.estado = "0";
        } else {
            this.estado = "1";
        }
        return _delivery.Estado(this);
    }

    public int Ver_x_id() {
        return _delivery.Ver_x_id(this);
    }
    public int Ver_x_personal() {
        return _delivery.Ver_x_personal(this);
    }

    public ArrayList<delivery> Ver_todo() {
        return _delivery.Ver_todo();
    }

    public ArrayList<delivery> Ver_x_estado() {
        return _delivery.Ver_x_estado();

    }

    public String horario() {
        return this.dias();
    }

    private String dias() {
        String horario = "";
        String dia[] = this.dias.split("/");
        for (int i = 0; i < dia.length; i++) {
            if (dia[i].equals("1")) {
                horario += dia_sem(i) + ",";
            }
        }
        return horario+" de "+this.hora_inicio+" a "+hora_fin+" horas";
    }

    private String dia_sem(int a) {
        switch (a) {
            case 0:
                return "Domingo";
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
        }
        return "";
    }
}
