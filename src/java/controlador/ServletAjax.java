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
import modelo.DAO._distrito;
import modelo.DAO._producto;
import modelo.DAO._provincia;
import modelo.departamento;
import modelo.distrito;
import modelo.producto;
import modelo.provincia;

/**
 *
 * @author JR
 */
@WebServlet(name = "ServletAjax", urlPatterns = {"/ServletAjax"})
public class ServletAjax extends HttpServlet {

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
            String accion = request.getParameter("accion");
            switch (accion) {
                case "provincia":
                    out.print(lista_provincia(request.getParameter("depart")));
                    break;
                case "distrito":
                    out.print(lista_distrito(request.getParameter("distri")));
                    break;
                case "producto":
                    out.print(datos_producto(request.getParameter("idprod")));
                    break;
                default:
                    out.print("sin dato");
            }

        } catch (Exception e) {
        }

    }

    private String lista_provincia(String i) {
        String depart = "<option value=0>----</option>";

        for (provincia nom : _provincia.Ver_X_depart(i)) {
            depart +="<option value="+nom.getId()+">"+nom.getNombre() +"</opton>";
        }
            
        return depart;
    }
 
    private String lista_distrito(String i) {
        String depart = "<option value=0>-----</option>";
        for (distrito nom : _distrito.Ver_X_prov(i)) {
            depart +="<option value="+nom.getId()+">"+nom.getNombre() +"</opton>";
        }  
        return depart;
    }
       private String datos_producto(String i) {
        producto objprod=new producto(i);
        objprod.Ver_x_id();
        return "<div class=lista_compra><input type=hidden value="+objprod.getCodigo()+" name=com_cod><div>"+objprod.getObjProveedor().getNombre()+"</div><div><img src="+objprod.getFoto()+"></div><div>"+objprod.getNombre()+"</div><div><input class=\"form-control\" value="+objprod.getCosto()+" name=com_costo></div><div><input class=\"form-control\" name=com_cantidad></div></div>";

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
