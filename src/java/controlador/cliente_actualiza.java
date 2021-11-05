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
import modelo.cliente;

/**
 *
 * @author JR
 */
@WebServlet(name = "cliente_actualiza", urlPatterns = {"/cliente_actualiza"})
public class cliente_actualiza extends HttpServlet {

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
        try{
            cliente objcli=(cliente) sesion.getAttribute("cliente");
            if (request.getParameter("nombre") != null && request.getParameter("documento") != null) {
                cliente objCliente = new cliente();
                objCliente.setCorreo(objcli.getCorreo());
                objCliente.setDocumento(request.getParameter("documento"));
                objCliente.setTipo_doc(request.getParameter("tipo_doc"));
                objCliente.setNombre(request.getParameter("nombre"));
                objCliente.setApellido(request.getParameter("apellido"));
                objCliente.setFoto("images/clientes/cliente.jpg");
                objCliente.setFecha_nac(request.getParameter("fech_nac"));
                objCliente.setTelefono(request.getParameter("telefono"));
                objCliente.setDireccion(request.getParameter("direccion"));
                objCliente.setGenero(request.getParameter("genero"));
                if ( objCliente.Actualizar()>0) {
                    objCliente.Ver_x_id();
                    sesion.setAttribute("cliente", objCliente);
                    response.sendRedirect("perfil.jsp");
                    
                }else{
                   out.print("<script>alert('Error en datos no se ctualizo');history.go(-1)</script>");
                }
            }else{
                out.print("Error servlet in");
            }
        }catch(Exception e){
             out.print("Error servlet"+e);
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
