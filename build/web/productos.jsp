
<%@page import="modelo.DAO._producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.categoria"%>
<%@ include file='head.jsp' %>
<aside class="filtros pad1">
    <form class="text-center">
        <input type="text" placeholder="Buscar">
        <p></p>
        <button type="submit"> Buscar</button>
    </form>

    <ul>
        <li>Categoria</li>
            <%
                categoria obcat = new categoria();
                for (categoria elem : obcat.Ver_x_estado()) {
                    out.print(" <ul><a href=?categoria=" + elem.getId() + ">" + elem.getNombre() + "</a></ul>");
                }
            %>
    </ul>
    <ul>
        <li>Marca</li>
            <%    ;
                for (String marca : _producto.lista_Marcas()) {
                    out.print(" <ul><a href=?marca=" + marca + ">" + marca + "</a></ul>");
                }
            %>

    </ul>

    <ul>
        <li>Preferencia</li>
<!--        <ul><a href="">Mas vendido</a></ul>
        <ul><a href="">Ofertas</a></ul>
        <ul><a href="">ategoria 3</a></ul>
        <ul><a href="">ategoria 4</a></ul>-->
    </ul>
</aside><article class="articulos">
    <section id="business" class="portfolio ">
        <div class="container">
            <div class="head_title text-center">
                <h3>Adquiera Nuestros productos a los mejores precios</h3>
            </div>

            <div class="row">
                <div class="portfolio-wrapper text-center lista-articulo">
                    <%
                        producto objPro = new producto();
                        ArrayList<producto> produc = null;
                        if (request.getParameter("categoria") != null) {
                            objPro.setCategoria(Integer.parseInt(request.getParameter("categoria")));
                            produc = objPro.Ver_x_categoria();

                        } else if (request.getParameter("marca") != null) {
                            objPro.setMarca(request.getParameter("marca"));
                            produc = objPro.Ver_x_marca();

                        } else {
                            produc = objPro.Ver_x_estado();
                        }
                        if (produc != null) {
                            for (producto elemen : produc) {
                    %>
                    <div class="articulo">
                        <img src="<%=elemen.getFoto()%>">
                        <div>
                            <h4><a href="?producto=<%=elemen.getCodigo()%>" ><%=elemen.getNombre()%></a></h4>
                            <h3>
                                <input type="hidden" value="<%=elemen.getCodigo()%>">
                                <input type="hidden" value="<%=elemen.getNombre()%>">
                                <input type="hidden" value="<%=elemen.getPrecio()%>">
                                <input type="hidden" value="1">
                                <input type="hidden" value="producto">
                                S/<%=elemen.getPrecio()%>
                                <button class="fa fa-cart-plus agreagar-pro" onclick="agregar_carrito(this)"></button></h3>
                            <p><%=elemen.getDetalle()%></p>
                        </div>
                    </div>  
                    <%
                            }
                        }
                    %>

                </div>
            </div>

            <!-- Example row of columns -->

        </div> <!-- /container -->       
    </section>

</article>
<%
    if (request.getParameter("producto") != null) {
        producto vepr = new producto(request.getParameter("producto"));
        if (vepr.Ver_x_id() > 0) {
%>                
<section class="full-tvn-1 " id="vtn-prod" >
    <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
    <div class="ver_pro">
        <div class="bg-2">
            <div class="text-center">
                <img src="<%=vepr.getFoto()%>">
            </div><div class="">

                <h4><%=vepr.getNombre()%></h4>
                <h3>Precio: S/<%=vepr.getPrecio()%></h3>
                <h3>Disponible: <%=vepr.getStock() + " " + vepr.getMedida()%></h3>
                <div>
                    <input type="hidden" value="<%=vepr.getCodigo()%>">
                    <input type="hidden" value="<%=vepr.getNombre()%>">
                    <input type="hidden" value="<%=vepr.getPrecio()%>">
                    <input type="number" min="0" max="<%=vepr.getStock()%>" value="1">
                    <input type="hidden" value="producto">
                    <br>
                    <button type="button" class="btn btn-default fa fa-cart-plus" onclick="agregar_carrito(this);cerrar_vt_id('vtn-prod')"> _AGREGAR</button>
                </div>



            </div>
            <div class="descripcion">
                <h4>Marca:  <%=vepr.getMarca()%></h4>
                <h4>Detalles del producto</h4>
                <%=vepr.getDetalle()%>
            </div>
        </div>
    </div>
</section>
<% }
    }%>
<%@ include file='footer.jsp' %>