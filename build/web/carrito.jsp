
<%@page import="modelo.producto"%>
<%@page import="modelo.servicio"%>
<%@page import="modelo.DAO._delivery"%>
<%@page import="modelo.delivery"%>
<%@page import="modelo.departamento"%>
<%@page import="modelo.DAO._departamento"%>
<%@ include file='head.jsp' %>
<section class="portfolio sections pad1">
    <script>
        var des=0;
        var desc="0%"
    </script>
    <%
        if (objf != null) {
            out.print("<script>  des= " + objf.getDescuento() + ""
                    + "  ;desc=des+'%'</script>");    
        }
    %>

    <div class="carrito">
        <div>
            <table class="table table-hover cuadrobox tabla-compras">
                <thead class="bg-1">
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody class=" bg-2">
                <script>
                    function aleatorio() {
                        var numeropago = Math.floor(Math.random() * (9999 - 1000)) + 1000;
                        return numeropago;
                    }
                    if (!sessionStorage.getItem("numeropago")) {
                        sessionStorage.setItem("numeropago", aleatorio());
                    }

                    var numerodepago = sessionStorage.getItem("numeropago");
                    var monto = 0.0;
                    var milista = "";
                    function listar_carrito() {
                        var datosCarrito = sessionStorage.getItem("carrito");
                        var datos = JSON.parse(datosCarrito);
                        var total = datos.length;

                        for (var i = 0; i < total; i++) {
                            var subt = datos[i].precio * datos[i].cantidad;
                            var dt = "<tr><td><a href=?" + datos[i].tipo + "=" + datos[i].codigo + ">" + datos[i].nombre + "</a></td><td>" + datos[i].precio + "</td><td>" + datos[i].cantidad + "</td><td>" + subt + "</td><td><i class='fa fa-trash-o' onclick=quitar_pro('" + i + "')></i></td></tr>";
                            document.write(dt);
                            monto += subt;
                            milista += datos[i].tipo + "_" + datos[i].codigo + "_" + datos[i].cantidad + "/";
                        }
                    }
                    function monto_total() {
                        document.write(monto);
                    }
                   function monto_desc(){
                       var mnt=des*0.01;
                       var nuvmn=monto*mnt;
                       document.write(monto-nuvmn);
                   }

                    listar_carrito();
                </script>
                </tbody>
            </table>

        </div><div>
            <div class=" cuadrobox  pad1">
                <h5>Subtotal: S/<script> monto_total()</script></h5>
                <h5>Descuento:<script>document.write(desc);</script></h5>
                <h5>TOTAL: S/<script> monto_desc()</script></h5>
                Delivery: 
                <form class="f-pago text-left" method="POST" action="compra_producto_servicio">
                    <input type="hidden" name="lista-compra" id="lista-compra" required="">
                    <input type="hidden" name="numero-compra" id="numero-compra" required="">
                    <script>
                        document.getElementById('lista-compra').value = milista;
                        document.getElementById('numero-compra').value = numerodepago;
                    </script>
                    Departamento:
                    <select  onchange="traer_provincias(this)" class="" required="">
                        <option value="0"></option>
                        <%
                            for (departamento elem : _departamento.Ver_x_estado()) {
                                out.print("<option value=" + elem.getId() + ">" + elem.getNombre() + "</option>");
                            }
                        %>
                    </select>
                    Provincia:
                    <select  id="provincias" onchange="traer_distritos(this)" class="" required="">
                    </select>
                    Distrito:
                    <select name="distrito" id="distritos" class="" required="">
                    </select>
                    Direccion de envio
                    <input type="text" name="direccion" value="<%
                        if (objf != null) {
                            out.print(objf.getDireccion());
                        }
                           %>" required="">
                    Seleccione un horario de entrega
                    <select name="delivery" required="">
                        <%
                            for (delivery elem : _delivery.Ver_x_estado()) {
                                out.print("<option value=" + elem.getId() + ">" + elem.horario() + "</option>");

                            }
                        %>
                    </select>

                    <div class="full-vt " id="tarjeta">
                        <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
                        <div class="ver_pro bg-2">
                            <div class="">
                                <div><h3>Monto: S/<script> monto_desc()</script></h3></div>
                                <div class="form-group">
                                    N�mero de targeta <input type="text" class="form-control"  placeholder="000000000000" required="">
                                </div>

                                <div class="form-group">
                                    Fecha de vencimiento <input type="date" class="form-control"  placeholder="00/00/00" required="">
                                </div>
                                <div class="form-group">
                                    C�digo de verificaci�n <input type="text" class="form-control" placeholder="---" required="">
                                </div>
                                <div class="center-content">
                                    <button type="submit"  class=" btn-primary">Pagar</button>
                                    <button type="reset" class=" btn-secondary"> Cancelar</button>
                                </div>


                            </div>
                        </div>

                    </div>
                </form>

                <%
                    if (objf != null) {
                %>

                <button class="btn btn-default" onclick="mostrar_vt('tarjeta')">Comprar</button>
                <%
                } else {
                %>
                <p>Para Concretar la compra inicia sessi�n o cree una cuenta</p>
                <a href="crear_cuenta.jsp">Crear Cuenta</a>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</section>
<section class="full-vt" id="ver_pro">
    <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
    <div class="ver_pro">
        <div class="bg-2">
            <div class="text-center">
                <img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.bricotex.pro%2Ftienda%2F7160-thickbox_default%2Fmascarilla-quirurgica.jpg&f=1&nofb=1">
            </div><div class="">
                <h4>Mascarrilla de piel de rtrtrtr</h4>
                <h3>S/45.00 </h3>
                <h3>5 cajas</h3>
                <form class="for-agregar-pro" action="agregar_producto">
                    <input type="number" min="0" max="5" value="1">
                    <br>
                    <button type="submit" class="fa fa-cart-plus agreagar-pro"></button>
                </form>
            </div>
            <div class="descripcion">
                <p>Visually explore your data through a free-form drag-and-drop canvas, a broad range of modern data visualizations, and an easy-to-use report authoring experience.</p>
                <p>Visually explore your data through a free-form drag-and-drop canvas, a broad range of modern data visualizations, and an easy-to-use report authoring experience.</p>
                <p>Visually explore your data through a free-form drag-and-drop canvas, a broad range of modern data visualizations, and an easy-to-use report authoring experience.</p>
                <p>Visually explore your data through a free-form drag-and-drop canvas, a broad range of modern data visualizations, and an easy-to-use report authoring experience.</p>

            </div>
        </div>
    </div>
</section>
<section class="full-vt" id="ver_ser">
    <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
    <div class="ver_ser">
        <div class="bg-2 pad1">
            <h2 class="">Servicio de desinfecci�n de veh�culos </h2>
            <h2> Costo: S/120.00 </h2>
            <img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.motoringresearch.com%2Fwp-content%2Fuploads%2F2020%2F04%2FHow-to-sanitise-your-car.jpg&f=1&nofb=1">
            <div class="descripcion">
                <div class="pad1"><p><span style="color: #333333;"><strong>Realizamos la desinfecci�n de dos formas seg�n el lugar al que se tenga que aplicar, desinfecci�n mediante pulverizaci�n / nebulizaci�n o desinfecci�n mediante ozono.</strong></span></p>
                    <p><span style="color: #333333;">La desinfecci�n de las superficies es una de las medidas que han adoptado las autoridades sanitarias para combatir la propagaci�n del coronavirus en Espa�a.</span></p>
                    <p><span style="color: #333333;">El Covid-19 puede resistir varias horas en las superficies de pl�stico y acero. Por ello, el Ministerio de Sanidad ha recalcado la importancia de limpiar todos los espacios con desinfectantes, para evitar el avance del n�mero de contagiados de coronavirus.</span></p>
                    <p><span style="color: #333333;">Es especialmente importante que el protocolo de limpieza se respete al m�ximo en los hospitales, los centros de salud y todos los espacios que han sido habilitados para la atenci�n de los positivos.</span></p>
                    <p><span style="color: #333333;">Es m�s, la orden se extiende m�s all� y, por ejemplo, el Ayuntamiento de Madrid y la Subdirecci�n General de Sanidad Ambiental y Salud laboral han regulado la limpieza viaria de los espacios urbanos, sobre todo de aquellos que se encuentran cerca de los espacios sanitarios.</span></p>
                    <p><span style="color: #333333;">A la hora de abordar la limpieza y la desinfecci�n por nuestra parte, debemos tener en consideraci�n los principios de buenas pr�cticas recogidas en la <strong>norma UNE 16636:2015</strong>. ?Servicios de gesti�n de plagas, requisitos y competencias? , y poner a disposici�n de la autoridad sanitaria todos los documentos, protocolos de actuaci�n y registros que se derivan del cumplimiento de la norma y del Real Decreto 830/2010, de 25 de junio, por el que se establece la normativa reguladora de la capacitaci�n para realizar tratamientos con biocidas.</span></p>
                    <p><strong><span style="color: #333333;">El Plan de actuaci�n de limpieza y desinfecci�n que aportamos, consta de:</span></strong></p>
                    <ul>
                        <li><span style="color: #333333;">Diagn�stico de situaci�n que ir� acompa�ada de una inspecci�n y una evaluaci�n de la situaci�n y de riesgos.</span></li>
                        <li><span style="color: #333333;">Programa de actuaci�n que contendr� las pautas de limpieza, desinfectante a utilizar, m�todo de aplicaci�n, protecci�n de los elementos susceptibles de verse afectados (enchufes, ordenadores personales, otros equipos inform�ticos, etc.).</span></li>
                        <li><span style="color: #333333;">Gesti�n adecuada de los residuos generados La aplicaci�n de estos desinfectantes obliga a hacerlo cuando el espacio a desinfectar est� sin personas y, posteriormente, a mantener el plazo de seguridad que recoge la autorizaci�n de cada desinfectante.</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
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
