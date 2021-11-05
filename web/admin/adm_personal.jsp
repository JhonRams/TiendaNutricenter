<%-- 
    Document   : adm_personal
    Created on : 08/12/2020, 05:36:19 PM
    Author     : JR
--%>

<%@ include file='head.jsp' %>
<div class="content">
    <div class="animated fadeIn">
        <div class="row">

            <div class="col-lg-8">
                <div class="card">
                    <div class="card-header">
                        <button type="button" class="btn btn-success" onclick="mostrar_vt('vtn-personal-nuevo')"> Nuevo </button>
                        <strong class="card-title"> Usuarios de Sistema</strong>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>

                                    <th scope="col">Documento</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Perfil</th>
                                    <th scope="row"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td><a href="">45786545</a></td>
                                    <td>Pedro gonza</td>
                                    <td>9754812</td>
                                    <td>Administrador</td>
                                    <th scope="row"><a href=""><i class="fa fa-edit"></i></a></th>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-header">
                        <button type="button" class="btn btn-success" onclick="mostrar_vt('vtn-perfil-nuevo')">Nuevo</button>
                        <strong class="card-title"> Perfiles de Usuario</strong>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>

                                    <th scope="col">Perfil</th>
                                    <th scope="col">Estado</th>
                                    <th scope="row"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td>Administrador</td>
                                    <td><i class="fa fa-check"></i></td>
                                    <th scope="row"><a href=""><i class="fa fa-edit"></i></a></th>
                                </tr>
                                <tr>

                                    <td>Administrador</td>
                                    <td><i class="fa fa-times"></i></td>
                                    <th scope="row"><a href=""><i class="fa fa-edit"></i></a></th>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


        </div>
    </div><!-- .animated -->
</div>
<div class="full-vt" id="vtn-personal-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <div class="card-body card-block">
            <form action="#" method="post" enctype="multipart/form-data" class="form-horizontal">
                <h4>Ingrese datos del nuevo Personal</h4>
                <br>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">Documento</label></div>
                    <div class="col-12 col-md-9 row form-group">
                        <div class="col-5">
                            <select name="tipo_doc" id="select"  class="form-control">
                                <option value="0">Please select</option>
                                <option value="1">Option #1</option>
                                <option value="2">Option #2</option>
                                <option value="3">Option #3</option>
                            </select>
                        </div>
                        <div class="col-6"><input type="text" placeholder="" name="documento" class="form-control"></div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nombres</label></div>
                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="nombre" placeholder="" class="form-control" required=""></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label for="email-input" class=" form-control-label">Apellidos</label></div>
                    <div class="col-12 col-md-9"><input type="text" id="email-input" name="apellido" placeholder="" class="form-control" required=""></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label for="password-input" class=" form-control-label"></label></div>
                    <div class="col-12 col-md-9">
                        <div class="row">
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Correo</label>
                                <input type="email" id="email-input" name="correo" placeholder="" class="form-control" required="">
                            </div>
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Password</label>
                                <input type="password" id="email-input" name="password" placeholder="" class="form-control" required="">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"></div>
                    <div class="col-12 col-md-9">
                        <div class="row">
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Fecha de Nacimiento</label>
                                <input type="date" id="email-input" name="fech_nac" placeholder="" class="form-control" required="">
                            </div>
                            <div class="col-6">
                                <label for="cc-exp" class="control-label mb-1">Teléfono</label>
                                <input type="tex" id="email-input" name="telefono" placeholder="" class="form-control" required="">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"></div>
                    <div class="col-12 col-md-9 row form-group">
                        <div class="col-6">
                            Género
                            <div class="">
                                <input type="radio" name="genero" value="M" class="">Hombre
                                <input type="radio"  name="genero" value="F" class="">Mujer
                            </div>
                        </div>
                        <div class="col-5">
                            Cargo
                            <select name="tipo_doc" id="select"  class="form-control">
                                <option value="1">Please select</option>
                                <option value="2">Option #1</option>
                                <option value="3">Option #2</option>
                                <option value="4">Option #3</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label for="email-input" class=" form-control-label">Dirección</label></div>
                    <div class="col-12 col-md-9"><input type="text" id="email-input" name="direccion" placeholder="" class="form-control" required=""></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label for="file-input" class=" form-control-label">Foto</label></div>
                    <div class="col-12 col-md-9"><input type="file" id="file-input" name="foto" class="form-control-file"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"></label></div>
                    <div class="col-12 col-md-9">
                        <button type="submit" class="btn btn-success">REGISTRAR</button>
                        <button type="reset" class="btn btn-secondary">CANCELAR</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
<div class="full-vt" id="vtn-perfil-nuevo">
    <button class="boton-cerrar fa fa-times btn btn-default" onclick="cerrarr_vt(this)"></button>
    <div class="admin-editor">
        <h4>Crear un nuevo perfil</h4>
        <br>
        <form>
            <div class="row form-group">
                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Perfil</label></div>
                <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="" class="form-control" required=""></div>
            </div>
            <div class="row form-group alert alert-info ">
                <div class="col col-md-10"><label class=" form-control-label">Privilegios</label></div>
                <div class="col col-md-2">
                    <input type="checkbox" name="permiso" value="1" class="form-control"/>
                </div>
            </div>
            <div class="row form-group alert alert-info ">
                <div class="col col-md-10"><label class=" form-control-label">Privilegios</label></div>
                <div class="col col-md-2">
                    <input type="checkbox" name="permiso" value="1" class="form-control"/>
                </div>
            </div>
            <div class="row form-group alert alert-info ">
                <div class="col col-md-10"><label class=" form-control-label">Privilegios</label></div>
                <div class="col col-md-2">
                    <input type="checkbox" name="permiso" value="1" class="form-control"/>
                </div>
            </div>
            <div class="row form-group">
                <div class="col col-md-3"></label></div>
                <div class="col-12 col-md-9">
                    <button type="submit" class="btn btn-success">REGISTRAR</button>
                    <button type="reset" class="btn btn-secondary">CANCELAR</button>
                </div>
            </div>
        </form>
    </div>
</div>
<% if (request.getParameter("id") != null) {
        personal obj = new personal(request.getParameter("id"));
        if (obj.Ver_x_id() > 0) {
%>
<div class="full-tvn-1">
    <div class="admin-editor"

         <section class="card">
            <div class="text-right">
                <a href="adm_personal.jsp">CERRAR</a>
            </div>
            <div class="twt-feed bg-1">
                <div class="corner-ribon black-ribon">
                    
                </div>
                <div class="fa wtt-mark"></div>

                <div class="media">
                    <a>
                        <img class="align-self-center rounded-circle mr-3" style="width:100px; height:100px;" alt="" src="images/admin.jpg">
                    </a>
                    <div class="media-body">
                        <h2 class="text-white display-6">Jim Doe</h2>
                        <p class="text-light">Project Manager</p>
                    </div>
                </div>



            </div>
            <div class="weather-category twt-category">
                <ul>
                    <li class="active">
                        <h5>750</h5>
                        Tweets
                    </li>
                    <li>
                        <h5>865</h5>
                        Following
                    </li>
                    <li>
                        <h5>3645</h5>
                        Followers
                    </li>
                </ul>
            </div>
            <div class="twt-write col-sm-12">
                <textarea placeholder="Write your Tweet and Enter" rows="1" class="form-control t-text-area"></textarea>
            </div>
            <footer class="twt-footer">
                <a href="#"><i class="fa fa-camera"></i></a>
                <a href="#"><i class="fa fa-map-marker"></i></a>
                New Castle, UK
                <span class="pull-right">
                    32
                </span>
            </footer>
        </section>
    </div>
</div>
<% }
    }%>


<% if (request.getParameter("editar") != null) {
        personal obj = new personal(request.getParameter("editar"));
        if (obj.Ver_x_id() > 0) {
%>


<% }
    }%>


<%@ include file='footer.jsp' %>

