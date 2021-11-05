
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.delivery"%>
<%@page import="modelo.DAO._delivery"%>
<%@page import="modelo.DAO._detalle_venta"%>
<%@page import="modelo.detalle_venta"%>
<%@page import="util.utilidad"%>
<%@page import="util.utilidad"%>
<%@page import="modelo.venta"%>
<%@page import="modelo.DAO._venta"%>
<%@ include file='head.jsp' %>

<section class="content">
    <div class="animated fadeIn">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                        <strong class="card-title">Lista de Pedidos en Linia</strong>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">N°</th>
                                    <th scope="col">Depósito</th>
                                    <th scope="col">Monto</th>
                                    <th scope="col">Fecha Entrega</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Distrito</th>
                                    <th scope="col">Provincia</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<venta> lista=new ArrayList<>();
                                    if( SI[2] &&SI[4]){
                                        lista=_venta.Ver_x_estado("vendido");
                 
                                    }else{
                                        delivery objdeli=new delivery();
                                        objdeli.setUsuario(obPersonal.getDocumento());
                                        objdeli.Ver_x_personal();
                                      lista=_venta.Ver_x_estado_delivery("vendido",objdeli.getId());  
                                    }

                                    for (venta elem : lista) {
                                %>
                                <tr>
                                    <th scope="row"><%=elem.getId()%></th>
                                    <td><%=elem.getNumero_pago()%></td>
                                    <td><%=elem.getTotal()%></td>
                                    <td><%=elem.getFecha_venta()%></td>
                                    <td><%=elem.getObjCliente().getNombre()%></td>
                                    <td><%=elem.getObjDistrito().getNombre()%></td>
                                    <td><%=elem.getObjDistrito().getObjProvincia().getNombre() %></td>
                                    <td><a href="?pedido=<%=elem.getId()%>" class="btn btn-primary">Detalle Venta</a></td>
                                </tr>
                                <%
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- .animated -->
</section>
<%
    if (request.getParameter("pedido") != null) {
%>
<section class="full-tvn-1 " id="vtn-personal-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <%
            venta objventa = new venta(request.getParameter("pedido"));
            objventa.ver_x_id();
        %>
        <div class="pad1">
            <div>Cliente: <%=objventa.getObjCliente().getNombre()%> <%=objventa.getObjCliente().getApellido()%></div>
            <div>Direción: <%=objventa.getDireccion()%> -<%=objventa.getObjDistrito().getNombre()%>-<%=objventa.getObjDistrito().getObjProvincia().getNombre()%></div>
            <div>Entregado:  <%=objventa.getFecha_venta() %> / <%=objventa.getObjdelivery().getObjPersonal().getNombre() %></div>
        </div>
        <div class="card-body">
            <table class="table table-striped img-tabla">
                <thead>
                    <tr>
                        <th scope="col">Foto</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (detalle_venta detalleve : _detalle_venta.lista_detalle_x_venta(request.getParameter("pedido"))) {

                            if (detalleve.getProducto() != null) {
                    %>
                    <tr>
                        <td><img src="<%=detalleve.getObjProducto().getFoto()%>"></td>
                        <td><%=detalleve.getObjProducto().getNombre()%></td>
                        <td><%=detalleve.getPrecio()%></td>
                        <td><%=detalleve.getCantidad()%></td>
                        <td><%=detalleve.getSubtotal()%></td>
                    </tr>
                    <% } else {%>
                    <tr>
                        <td><img src="<%=detalleve.getObjServicio().getFoto()%>"></td>
                        <td><%=detalleve.getObjServicio().getNombre()%></td>
                        <td><%=detalleve.getPrecio()%></td>
                        <td><%=detalleve.getCantidad()%></td>
                        <td><%=detalleve.getSubtotal()%></td>
                    </tr>
                    <% }
                        }%>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Subtotal:<br> Descuento:<br> TOTAL: </td>
                        <td><%=objventa.getSubtotal()%><br><%=objventa.getDescuento()%><br><%=objventa.getTotal()%></td>
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</section>

<%    }
%>

<%@ include file='footer.jsp' %>