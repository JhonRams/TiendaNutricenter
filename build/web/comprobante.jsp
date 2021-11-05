<%-- 
    Document   : comprobante
    Created on : 04/12/2020, 04:06:59 PM
    Author     : JR
--%>

<%@page import="modelo.detalle_venta"%>
<%@page import="modelo.DAO._detalle_venta"%>
<%@page import="modelo.venta"%>
<%@ include file='head.jsp' %>
<%
    if (objf != null & request.getParameter("cod") != null) {
%>
<script>
    sessionStorage.setItem("carrito", null);
</script>
<div class="comprobante" id="comprobante">
    <div class="cuadrobox">
        <%
            venta objvent = new venta(request.getParameter("cod"));
            objvent.ver_x_id();

        %>
        <form id="comprovante">
            <div class="datos-empresa">
                <div><img src="images/logo.jpg" alt="" class="logo"/></div>
                <div>
                    <h6>Comprobante de pago</h6>
                    <h5>SUPLEMENTOS B.J. NUTRITION S.R.L</h5>
                </div>
                <div>
                    <div>N°-Pedido: <%=objvent.getId()%></div>
                    <div>Comprobante de pago: <%=objvent.getNumero_pago()%></div>
                    <div>Fecha: <%=objvent.getFecha_pedido()%></div>
                </div>

            </div>
            <div class="datos-cliente">
                <h5>A nombre de: <%=objf.getNombre() + " " + objf.getApellido()%> Dirección de entrega:            <%=objvent.getDireccion()%></h5>
            </div>
            <div class="datos-compra">
                <table class="table table-hover cuadrobox tabla-compras">
                    <thead class="">
                        <tr>
                            <th>Código</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                        </tr>
                    </thead>
                    <tbody class=" bg-2">
                        <%for (detalle_venta detalle : _detalle_venta.lista_detalle_x_venta(objvent.getId())) {
                                if (detalle.getObjProducto() != null) {


                        %>
                        <tr>
                            <td><%=detalle.getObjProducto().getCodigo()%></td>
                            <td><%=detalle.getObjProducto().getNombre()%></td>
                            <td><%=detalle.getPrecio()%></td>
                            <td><%=detalle.getCantidad()%></td>
                            <td><%=detalle.getSubtotal()%></td>

                        </tr>
                        <%
                        } else {
                        %>
                        <tr>
                            <td><%=detalle.getObjServicio().getId()%></td>
                            <td><%=detalle.getObjServicio().getNombre()%></td>
                            <td><%=detalle.getPrecio()%></td>
                            <td><%=detalle.getCantidad()%></td>
                            <td><%=detalle.getSubtotal()%></td>

                        </tr>
                        <%

                            } }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="total-compra pad2">
                <h5 class="text-right">Subtotal S/ <%=objvent.getSubtotal()%></h5>
                <h5 class="text-right">Descuento S/ <%=objvent.getDescuento()%></h5>
                <h4 class="text-right">Total: S/ <%=objvent.getTotal()%></h4>
            </div>
            <div class="fin-compra">

            </div>

        </form>
    </div>
</div>
<div class="text-center pad1">
    <button class="btn btn-default" onclick="imprimir_div('comprovante')">Imprimir</button>
    
</div>
<%
    }else {
        response.sendRedirect("index.jsp");
    }
%>

<%@ include file='footer.jsp' %>
