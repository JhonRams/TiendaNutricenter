
<%@page import="modelo.DAO._producto"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.DAO._detalle_compra"%>
<%@page import="modelo.detalle_compra"%>
<%@page import="modelo.compra"%>
<%@page import="modelo.DAO._compra"%>
<%@page import="util.utilidad"%>
<%@page import="util.utilidad"%>
<%@ include file='head.jsp' %>
<%    if (request.getParameter("idcom") != null) {
        detalle_compra objdetalle = new detalle_compra(request.getParameter("idcom"));
        objdetalle.Ver_x_id();
        objdetalle.setEstado("almacen");
        _detalle_compra.Ingreso_almacen(objdetalle);
        Object val[]={objdetalle.getCantidad(),objdetalle.getCosto(),objdetalle.getIdProducto()};
        _producto.Actualiza_stock_y_precio(val);
    }

%>

<section class="content">
    <div class="animated fadeIn">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                        <button class="btn btn-primary" onclick="mostrar_vt('nuevo_orden')">Nuevo Orden de compra</button> <strong class="card-title">Mis Ordenes de compra</strong>
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
                                <%                                    for (compra elem : _compra.Ver_x_estado("proceso")) {
                                %>
                                <tr>
                                    <td scope="row"><%=elem.getId()%></td>
                                    <td><%=elem.getFecha_orden()%></td>
                                    <td><%=elem.getCosto()%></td>
                                    <td><%=elem.getObjPersonal().getNombre()%></td>
                                    <td><a href="?orden=<%=elem.getId()%>" class="btn btn-danger">Ver Orden</a></td>
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

<section class="full-vt" id="nuevo_orden">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <h4>Orden de compra</h4>
        <p>Seleccione producto a ordenar y agregue</p>
        <select  onchange="traer_producto(this)" class="form-control"  required="">
            <option value="0"></option>
            <%
                for (producto elem : _producto.Ver_x_estado()) {
                    if (elem.getStock() > 10) {
                        out.print("<option value=" + elem.getCodigo() + ">" + elem.getCodigo() + " -- " + elem.getNombre() + "</option>");
                    } else {
                        out.print("<option value=" + elem.getCodigo() + " class='bg-danger text-white'>" + elem.getCodigo() + " -- " + elem.getNombre() + "</option>");
                    }
                }
            %>
        </select>
        <div id="slc-producto">

        </div>

        <div class="text-right pad1">
            <button class="btn btn-info" onclick="agregar_compra()">AGREGAR</button>
        </div>
        <form action="../usuario_ordena" method="POST">
            <div id="lista-compra">
                
            </div>
            <div class="text-right pad1">
                <button type="submit" class="btn btn-danger">Ordenar Compra</button>
            </div>
        </form>
    </div>
</section>>                                   







<%
    if (request.getParameter("orden") != null) {
%>
<section class="full-tvn-1 " id="vtn-personal-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <%
            compra objcompra = new compra(request.getParameter("orden"));
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
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (detalle_compra objdet_com : _detalle_compra.lista_detalle_x_orden(request.getParameter("orden"))) {
                    %>
                    <tr>
                        <td><%=objdet_com.getId()%></td>
                        <td><%=objdet_com.getObjProducto().getObjProveedor().getNombre()%></td>
                        <td><img src="<%=objdet_com.getObjProducto().getFoto()%>"></td>
                        <td><%=objdet_com.getObjProducto().getNombre()%></td>
                        <td><%=objdet_com.getCosto()%></td>
                        <td><%=objdet_com.getCantidad()%></td>
                        <td><%=objdet_com.getSubtotal()%></td>
                        <%
                            if (objdet_com.getEstado().equals("orden")) {
                        %>
                        <td>
                            <a href="?orden=<%=objcompra.getId()%>&idcom=<%=objdet_com.getId()%>" class="btn btn-outline-danger">Ingresar</a>

                        </td>
                        <% } else {%>
                        <td><button class="btn btn-outline-secondary" disabled="">Ingresado</button></td>
                        <% } %>
                    </tr>  

                    <%
                        }
                    %>
                    <tr>
                        <td></td>
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
        <form method="POST" action="../usuario_compra" class="text-right pad2">
            <input type="hidden" value="<%=objcompra.getId()%>" name="idcompra">
            <button class="btn btn-success">Finalizar Orden</button>
        </form>
    </div>
</section>






<%    }
%>

<%@ include file='footer.jsp' %>
