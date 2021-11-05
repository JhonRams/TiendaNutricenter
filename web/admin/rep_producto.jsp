
<%@page import="modelo.DAO._detalle_venta"%>
<%@page import="modelo.detalle_venta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.DAO._venta"%>
<%@page import="modelo.venta"%>
<%@page import="modelo.compra"%>
<%@page import="modelo.DAO._compra"%>
<%@ include file='head.jsp' %>
<section class="content">
    <div class="animated fadeIn">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                        <form action="" method="POST">
                            <input type="date" name="fecha_ini">
                            <input type="date" name="fecha_fin">
                            <button class="btn btn-info">Consultar</button>
                        </form>
                        <strong class="card-title">Reporte Productos</strong>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="row">N°</th>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Subtotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    ArrayList<detalle_venta> lista=new ArrayList<>();
                                     lista=_detalle_venta.lista_detalle_producto();
                                    for (detalle_venta elem : lista) {
                                        

                                %>
                                 <tr>
                                    <th scope="row"><%=elem.getId()%></th>
                                    <td><%=elem.getObjProducto().getNombre() %></td>
                                    <td><%=elem.getPrecio() %></td>
                                    <td><%=elem.getCantidad() %></td>
                                    <td><%=elem.getSubtotal() %></td>
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


<%@ include file='footer.jsp' %>