/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.personal;
import modelo.privilegio;

/**
 *
 * @author JR
 */
public class _personal {

    private static conexion db = new conexion();

    private static int Personal(personal obj, ResultSet rs) {
        try {
            rs.next();
            obj.setDocumento(rs.getString(1));
            obj.setTipo_doc(rs.getString(2));
            obj.setPassword(rs.getString(3));
            obj.setCorreo(rs.getString(4));
            obj.setNombre(rs.getString(5));
            obj.setApellido(rs.getString(6));
            obj.setFecha_nac(rs.getString(7));
            obj.setTelefono(rs.getString(8));
            obj.setDireccion(rs.getString(9));
            obj.setFecha_reg(rs.getString(10));
            obj.setGenero(rs.getString(11));
            obj.setFoto(rs.getString(12));
            obj.setPivilegio(rs.getInt(13));
            privilegio objpri=new privilegio(rs.getInt(13));
            objpri.Ver_x_id();
            obj.setPerfil(objpri);
            obj.setEstado(rs.getString(14));
            
            return 1;

        } catch (SQLException ex) {
            return -1;
        }
    }

    private static ArrayList<personal> Personals(ResultSet rs) {
        ArrayList<personal> list = new ArrayList<personal>();
        try {
            while (rs.next()) {
                personal obj = new personal();

                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int Insertar(personal obj) {
        String sql = "INSERT INTO usuarios (documento,tipo_doc,password,correo,nombre,apellido,fech_na,telefono,direccion,fecha_ingreso,genero,foto, privilegio, estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return db.transac(sql, obj.Persona());
    }

    public static int Actualizar(personal obj) {
        String sql = "UPDATE usuarios SET documento=?,tipo_documento=?, nombre=?,apellido=?,foto=?,fech_nac=?,telefono=?,direccion=?,genero=? WHERE correo=?";
        return db.transac(sql, obj.Persona_U());
    }

    public static int Estado(personal obj) {
        String sql = "UPDATE usuarios SET estado=? WHERE id=?";
        Object val[] = {
            obj.getEstado(),
            obj.getDocumento()
        };
        return db.transac(sql, val);
    }

    public static int Ver_x_id(personal obj) {
        String sql = "SELECT * FROM usuarios WHERE documento=?";
        return Personal(obj, db.consulta(sql, obj.Persona_doc()));
    }

    public static ArrayList<personal> Ver_todo() {
        String sql = "SELECT * FROM usuarios";
        return Personals(db.consulta(sql, null));

    }

    public static ArrayList<personal> Ver_x_estado(personal obj) {
        String sql = "SELECT * FROM usuarios WHERE estado=?";

        return Personals(db.consulta(sql, obj.Persona_doc()));
    }

    public static boolean Session(personal obj) {
        try {
            String sql = "SELECT password,documento FROM usuarios WHERE correo=? AND estado=?";
            Object val[] = {obj.getCorreo(), "s"};
            ResultSet rs = db.consulta(sql, val);
            rs.next();
            if (rs.getRow() > 0) {
                if (rs.getString(1).equals(obj.getPassword())) {
                    obj.setDocumento(rs.getString(2));
                    Ver_x_id(obj);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            obj.setDireccion("Error ami esta muy mal" + ex.toString());
            return false;
        }
    }

}
