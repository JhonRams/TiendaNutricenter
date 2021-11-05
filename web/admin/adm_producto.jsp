<%@page import="modelo.DAO._producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.categoria"%>
<%@page import="modelo.DAO._categoria"%>
<%@ include file='head.jsp'%>
<div class="content">
    <!--  AQUI AGREGO LOS FILTROS -->


    <!-- FILTROSSSS -->
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header">
                    <h4>Administra Productos, Categiria y Proveedores</h4>
                </div>
                <div class="card-body">

                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item"><a class="nav-link active show"
                                                id="pills-home-tab" data-toggle="pill" href="#pills-home"
                                                role="tab" aria-controls="pills-home" aria-selected="true">PRODUCTOS</a>
                        </li>
                        <li class="nav-item"><a class="nav-link"
                                                id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
                                                role="tab" aria-controls="pills-profile" aria-selected="false">CATEGORIAS</a>
                        </li>

                    </ul>
                    <div class="tab-content" id="pills-tabContent">
                        <div class="tab-pane fade active show" id="pills-home"
                             role="tabpanel" aria-labelledby="pills-home-tab">
                            <h3>
                                <button class="btn btn-secondary" onclick="mostrar_vt('producto-nuevo')">Nuevo</button>
                                PRODUCTOS
                            </h3>
                            <div class="row">

                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <div>
                                                <h4>Categoria</h4>
                                                <%                categoria obcat = new categoria();
                                                    for (categoria elem : obcat.Ver_x_estado()) {
                                                        out.print(" /<a href=?categoria=" + elem.getId() + ">" + elem.getNombre() + "</a>");
                                                    }
                                                %>
                                            </div>
                                            <div>
                                                <h4>Marca</h4>


                                                <%                for (String marca : _producto.lista_Marcas()) {
                                                        out.print(" /<a href=?marca=" + marca + ">" + marca + "</a>");
                                                    }
                                                %>
                                            </div>


                                        </div>
                                        <div class="table-stats order-table ov-h">
                                            <table class="table ">
                                                <thead>
                                                    <tr>
                                                        <th class="serial">#</th>
                                                        <th class="avatar">IMAGEN</th>
                                                        <th>MARCA</th>
                                                        <th>NOMBRE</th>
                                                        <th>STOCK</th>
                                                        <th>COSTO</th>
                                                        <th>PRECIO</th>

                                                        <th>ESTADO</th>
                                                        <th>accion</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <!-- AQUI MODIFICO GAAAAAA -->
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
                                                    <tr>
                                                        <td class="serial"><%=elemen.getCodigo()%></td>
                                                        <td class="avatar">
                                                            <div class="round-img">
                                                                <a href="#"><img class="rounded-circle" style="height: 4em"
                                                                                 src="<%=elemen.getFoto()%>" alt=""></a>
                                                            </div>
                                                        </td>
                                                        <td><span class="name"><%=elemen.getMarca()%></span></td>
                                                        <td><span class="product"><%=elemen.getNombre()%></span></td>
                                                        <td><span class="count"><%=elemen.getStock()%></span></td>

                                                        <td><span class="name">S/<%=elemen.getCosto()%></span></td>
                                                        <td><span class="name">S/<%=elemen.getPrecio()%></span></td>

                                                        <%
                                                            if (elemen.getEstado().equalsIgnoreCase("S")) {
                                                                out.print("<td><i class='color-gray fa fa-flag'></i></td>");
                                                            } else {
                                                                out.print("<td><i class='color-red fa fa-flag'></i></td>");
                                                            }
                                                        %>

                                                        <td><a
                                                                href="../ControllerProductoAdmin?accion=Eliminar&id=<%=elemen.getCodigo()%>"><i
                                                                    class="fa fa-trash fa-2x" ></i></a> <a
                                                                href="../ControllerProductoAdmin?accion=Editar&id=<%=elemen.getCodigo()%>"> <i
                                                                    class="fa fa-edit fa-2x"></i></a></td>
                                                    </tr>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                    <!-- AQUI MODIFICO GAAAAAA -->

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-stats -->
                                    </div>
                                </div>






                            </div>
                        </div>
                        <div class="tab-pane fade" id="pills-profile" role="tabpanel"
                             aria-labelledby="pills-profile-tab">
                            <h3>
                                <button class="btn btn-secondary">Nueva Categoria</button>
                                CATEGORIAS
                            </h3>

                            <div class="animated fadeIn">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card">
                                            <div class="card-header">
                                                <strong class="card-title">LISTA DE CATEGORIAS</strong>
                                            </div>
                                            <div class="card-body">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">N°</th>
                                                            <th scope="col">Categoria</th>
                                                            <th scope="col">Descripcion</th>
                                                            <th scope="col">Estado</th>
                                                            <th scope="col"></th>
                                                            <th scope="col"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            for (categoria elem : _categoria.Ver_todo()) {
                                                        %>
                                                        <tr>
                                                            <th scope="row"><%=elem.getId()%></th>
                                                            <td><%=elem.getNombre()%></td>
                                                            <td><%=elem.getDescripcion()%></td>
                                                            <%
                                                                if (elem.getEstado().equalsIgnoreCase("S")) {
                                                                    out.print("<td><i class='color-gray fa fa-flag'></i></td>");
                                                                } else {
                                                                    out.print("<td><i class='color-red fa fa-flag'></i></td>");
                                                                }
                                                            %>

                                                            <td><a href="?categoria=<%=elem.getId()%>" class=" fa fa-edit "></a></td>
                                                            <td><a href="?categoria=<%=elem.getId()%>" class="fa fa-trash-o "></a></td>
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
                            </div>
                        </div>

                    </div>






                </div>
            </div>
        </div>
        <!-- /# column -->

    </div>
    <!-- /# column -->
</div>

<div class="full-vt" id="producto-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default"
            onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <div class="card-body card-block">
            <form action="./ControllerProductoAdmin" method="GET"
                  enctype="multipart/form-data" class="form-horizontal">
                <h4>INGRESE DATOS DEL NUEVO PRODUCTO</h4>
                <br>
                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="text-input" class=" form-control-label">NOMBRE</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="text" id="text-input" name="nombre"
                               placeholder="" class="form-control"
                               >
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3"><label for="password-input" class=" form-control-label"></label></div>
                    <div class="col-12 col-md-9">
                        <div class="row">
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Costo</label>
                                <input type="number" id="email-input" name="costo" placeholder="" class="form-control" required="">
                            </div>
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Precio</label>
                                <input type="number" id="email-input" name="precio" placeholder="" class="form-control" required="">

                            </div>
                        </div>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">DETALLE</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="text" id="text-input" name="detalle"
                               placeholder="" class="form-control"
                               >
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">MARCA</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="text" id="text-input" name="marca"
                               placeholder="" class="form-control"
                               >
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="file-input" class=" form-control-label">IMAGEN</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="url" id="file-input" name="foto"
                               class="form-control-file">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">MEDIDA</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <select id="cars" name="medida" class="form-control">
                            <option value="unidad">unidad</option>
                            <option value="caja">caja</option>
                            <option value="pakete">pakete</option>
                        </select>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label class=" form-control-label">STOCK</label>
                    </div>
                    <div class="col-12 col-md-9 row form-group">
                        <div class="col-6">
                            <input type="text" placeholder="" name="stock"
                                   class="form-control" >
                        </div>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">FECHA DE INGRESO</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="date" id="text-input" name="fecha_ingreso"
                               placeholder="" class="form-control" autocomplete=""
                               >
                    </div>
                </div>



                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">CATEGORIA</label>
                    </div>
                    <div class="col-12 col-md-9">

                        <select id="cars" name="categoria" class="form-control">
                            <%
                                for (categoria elem : _categoria.Ver_todo()) {
                                    out.print("<option value='" + elem.getId() + "'>" + elem.getNombre() + "</option>");
                                }
                            %>

                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                            <option value="vw">VW</option>
                            <option value="audi" selected>Audi</option>
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3">
                        <label for="email-input" class=" form-control-label">ESTADO</label>
                    </div>
                    <div class="col-12 col-md-9">
                        <input type="checkbox" name="estado" value="s" checked>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col col-md-3"></div>
                    <div class="col-12 col-md-9">
                        <button type="submit" class="btn btn-success" name="accion"
                                value="Actualizar">GUARDAR</button>
                        <button type="reset" class="btn btn-secondary" name="accion"
                                value="Cancelar">CANCELAR</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>                                      


<%@ include file='footer.jsp'%>