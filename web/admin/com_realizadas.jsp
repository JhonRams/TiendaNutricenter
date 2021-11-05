<%@page import="modelo.DAO._detalle_compra"%>
<%@page import="modelo.detalle_compra"%>
<%@page import="modelo.compra"%>
<%@page import="modelo.DAO._compra"%>

<%@page import="util.utilidad"%>
<%@page import="util.utilidad"%>
<%@ include file='head.jsp' %>
<section class="content">
    <div class="animated fadeIn">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                       <strong class="card-title">Mis Compras</strong>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="row">N°</th>
                                    <th scope="col">Fecha Orden</th>
                                    <th scope="col">Monto</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                                    for (compra elem : _compra.Ver_x_estado("completado")) {
                                %>
                                <tr>
                                    <td scope="row"><%=elem.getId()%></td>
                                    <td><%=elem.getFecha_orden()%></td>
                                    <td><%=elem.getCosto()%></td>
                                    <td><%=elem.getObjPersonal().getNombre()%></td>
                                    <td><a href="?almacen=<%=elem.getId()%>" class="btn btn-info">Ver compra</a></td>
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
    if (request.getParameter("almacen") != null) {
%>
<section class="full-tvn-1 " id="vtn-personal-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <%
            compra objcompra = new compra(request.getParameter("almacen"));
            objcompra.Ver_x_id();
        %>
        <div class="pad1">
            <div><strong>Usuario:</strong> <%=objcompra.getObjPersonal().getNombre()%> <%=objcompra.getObjPersonal().getApellido()%></div>
            <div><strong>Fecha Orden de compra:</strong> <%=objcompra.getFecha_orden()%></div>
        </div>
        <div class="card-body">
            <table class="table table-striped img-tabla">
                <thead>
                    <tr>
                        <th scope="row">N°</th>
                        <th scope="col">Proveedor</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Subtotal</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (detalle_compra objdet_com : _detalle_compra.lista_detalle_x_orden(request.getParameter("almacen"))) {
                    %>
                    <tr>
                        <td><%=objdet_com.getId()%></td>
                        <td><%=objdet_com.getObjProducto().getObjProveedor().getNombre()%></td>
                        <td><img src="<%=objdet_com.getObjProducto().getFoto()%>"></td>
                        <td><%=objdet_com.getObjProducto().getNombre()%></td>
                        <td><%=objdet_com.getCosto()%></td>
                        <td><%=objdet_com.getCantidad()%></td>
                        <td><%=objdet_com.getSubtotal()%></td>
                       

                    <% }
                    %>
                    <tr>
                        
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>TOTAL: </td>
                        <td><%=objcompra.getCosto()%></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</section>

<%    }
%>

<%@ include file='footer.jsp' %>