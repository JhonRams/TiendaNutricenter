/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO._venta;
import modelo.cliente;
import modelo.detalle_venta;
import modelo.venta;

/**
 *
 * @author JR
 */
@WebServlet(name = "compra_producto_servicio", urlPatterns = {"/compra_producto_servicio"})
public class compra_producto_servicio extends HttpServlet {

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
            cliente objCliente = (cliente) sesion.getAttribute("cliente");
            if (request.getParameter("lista-compra") != null && request.getParameter("numero-compra") != null && request.getParameter("distrito") != null && objCliente.getDocumento() != null) {
                String datos = request.getParameter("lista-compra");
                String lista_compra[] = datos.split("/");
                ArrayList<detalle_venta> objlistadetalle = new ArrayList<>();
                float total = 0;
                for (int i = 0; i < lista_compra.length; i++) {
                    String datos_compra[] = lista_compra[i].split("_");
                    detalle_venta objdeta = new detalle_venta();

                    if (datos_compra[0].equals("producto")) {
                        objdeta.setServicio(null);
                        objdeta.setProducto(datos_compra[1]);
                        objdeta.setCantidad(Integer.parseInt(datos_compra[2]));
                        objdeta.costo_producto();
                       

                    } else if (datos_compra[0].equals("servicio")) {
                        objdeta.setProducto(null);
                        objdeta.setServicio(datos_compra[1]);
                        objdeta.setCantidad(Integer.parseInt(datos_compra[2]));
                        objdeta.costo_servicio();
                        
                    }
                    total += objdeta.getSubtotal();
                    objlistadetalle.add(objdeta);
                }
                venta objVenta=new venta();
                double descuento=objCliente.getDescuento()*0.01;
                double mntnv=total-(descuento*total);
                objVenta.setDescuento((float) (descuento*total));
                objVenta.setCliente(objCliente.getDocumento());
                objVenta.setEstado("pedido");
                objVenta.setNumero_pago(request.getParameter("numero-compra"));
                objVenta.setDireccion(request.getParameter("direccion"));
                objVenta.setDelivery(request.getParameter("delivery"));
                objVenta.setDistrito(request.getParameter("distrito"));
                objVenta.setSubtotal(total);
                objVenta.setTotal((float) mntnv);
                objVenta.setFecha_pedido(util.utilidad.fecha_hora());
                String idv="-1";
                if(objVenta.Online()>=0){
                   idv =_venta.ultimo()+"";
                    for (detalle_venta object : objlistadetalle) {
                        object.setVenta(idv);
                        object.Insertar();
                       
                    }
                }
                
                response.sendRedirect("comprobante.jsp?cod="+idv);
                
            }else{
                out.print("<script>history.go(-1)</script>");
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
