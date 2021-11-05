/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO._compra;
import modelo.compra;
import modelo.detalle_compra;
import modelo.personal;

/**
 *
 * @author JR
 */
@WebServlet(name = "usuario_ordena", urlPatterns = {"/usuario_ordena"})
public class usuario_ordena extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        try {
            if (sesion.getAttribute("usuario") != null) {
                personal objper=(personal) sesion.getAttribute("usuario");
                if (request.getParameter("com_cod") != null) {
                    String cod[]= request.getParameterValues("com_cod");
                    String costo[]= request.getParameterValues("com_costo");
                    String cantidad[]= request.getParameterValues("com_cantidad");
                    compra objcomp=new compra();
                    objcomp.setFecha_orden(util.utilidad.fecha());
                    objcomp.setUsuario(objper.getDocumento());
                    objcomp.setEstado("proceso");
                    double total=0.0;
                    for (int i = 0; i < cod.length; i++) {
                        total+=(Double.parseDouble(costo[i])*Integer.parseInt(cantidad[i]));
 
                    }
                    objcomp.setCosto(total);
                    objcomp.Insertar();
                    String ultimo=_compra.ultimoIn();
                    for (int i = 0; i < cod.length; i++) {
                        detalle_compra objdetalcom=new detalle_compra();
                        objdetalcom.setIdorden(ultimo);
                        objdetalcom.setIdProducto(cod[i]);
                        objdetalcom.setCosto(Double.parseDouble(costo[i]));
                        objdetalcom.setCantidad(Integer.parseInt(cantidad[i]));
                        double subt=(Double.parseDouble(costo[i])*Integer.parseInt(cantidad[i]));
                        objdetalcom.setSubtotal(subt);
                        objdetalcom.setEstado("orden");
                        objdetalcom.Insertar();
                    }
                    response.sendRedirect("admin/com_orden.jsp");
                    
                    
                }else{
                     out.print("<script>history.go(-1)</script>");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            out.print("error"+e);
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
