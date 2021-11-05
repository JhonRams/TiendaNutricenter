
<%@page import="modelo.servicio"%>
<%@ include file='head.jsp' %>

<section class="portfolio sections pad1">
    <div>
        <div class="servicios">
            <%
                servicio objser = new servicio();
                for (servicio ser : objser.Ver_x_estado()) {
            %>  
            <div>
                <div class="servicio">
                    <div>
                        <img src="<%=ser.getFoto()%>" alt="">
                    </div><div>
                        <h4><%=ser.getNombre()%></h4>
                        <p><%=ser.getDetalle()%></p>

                        <div class="features_buttom">
                            <a href="?servicio=<%=ser.getId()%>" class="btn btn-default" >ver más</a>
                        </div>
                    </div>
                </div>

            </div>


            <%
                }
            %>




        </div>
    </div>
</section>
<%
    if (request.getParameter("servicio") != null) {
        servicio obver = new servicio(request.getParameter("servicio"));
        if (obver.Ver_x_id() > 0) {
%>
<section class="full-tvn-1" id="vtn-serv">
    <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
    <div class="ver_ser pad1">
        <div class="bg-2 pad2">
            <h3 class=""><%=obver.getNombre()%></h3>
            <h3 class="wi_auto">Coto: S/<%=obver.getCosto()%> </h3>
            <div class="wi_auto flo-r">
                <input type="hidden" value="<%=obver.getId()%>">
                <input type="hidden" value="<%=obver.getNombre()%>">
                <input type="hidden" value="<%=obver.getCosto()%>">
                <input type="hidden" value="1">
                <input type="hidden" value="servicio">
                <button  class="btn btn-default " onclick="agregar_carrito(this);cerrar_vt_id('vtn-serv')">CONTRATAR</button>
            </div>
            <img src="<%=obver.getFoto()%>">
            <div class="descripcion">
                <div class="pad1">
                    <h3>Detalle del Servicio</h3>
                    <%=obver.getDetalle()%>
                </div>
            </div>
        </div>
    </div>
</section>
<%
        }
    }

%>           



<%@ include file='footer.jsp' %>
