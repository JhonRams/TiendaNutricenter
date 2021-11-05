/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;

/**
 *
 * @author JR
 */
@WebServlet(name = "cliente_nuevo", urlPatterns = {"/cliente_nuevo"})
public class cliente_nuevo extends HttpServlet {

    DateFormat dateFormatQSL = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("documento") != null && request.getParameter("correo") != null) {
                Calendar hoy = Calendar.getInstance();
                Date hoydia = hoy.getTime();
                cliente objCliente = new cliente();
                objCliente.setDocumento(request.getParameter("documento"));
                objCliente.setTipo_doc(request.getParameter("tipo_doc"));
                objCliente.setPassword(request.getParameter("password"));
                objCliente.setCorreo(request.getParameter("correo"));
                objCliente.setNombre(request.getParameter("nombre"));
                objCliente.setApellido(request.getParameter("apellido"));
                objCliente.setFoto("images/clientes/cliente.jpg");
                objCliente.setFecha_nac(request.getParameter("fech_nac"));
                objCliente.setFecha_reg(dateFormatQSL.format(hoydia));
                objCliente.setTelefono(request.getParameter("telefono"));
                objCliente.setDireccion(request.getParameter("direccion"));
                objCliente.setGenero(request.getParameter("genero"));
                objCliente.setEstado("s");
                if ( objCliente.Insertar()>=0) {
                    response.sendRedirect(request.getParameter("url"));
                    out.print("Se inserto");
                }else{
                   out.print("<script>history.go(-1)</script>");
                }
            }
        } catch (Exception e) {
            out.print("<script>history.go(-1)</script>");
        }        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
