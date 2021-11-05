<%-- 
    Document   : head
    Created on : 09/11/2020, 07:12:02 PM
    Author     : JR
--%>

<%@page import="modelo.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Soft-Tect Free Landing Page</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="images/favicon.png">
        <link rel="shortcut icon" href="images/favicon.png">
        <!--Google fonts links-->
        <!--<link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">-->

        <link rel="stylesheet" href="css/bootstrap.min.css">


        <!--For Plugins external css-->
        <link rel="stylesheet" href="css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/estilos.css" />

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Sections -->
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img src="images/logo.jpg" alt="Logo" class="logo" /></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="index.jsp">Inicio</a></li>
                        <li><a href="empresa.jsp">Empresa</a></li>
                        <li><a href="productos.jsp">Productos</a></li>
                        <li><a href="carrito.jsp" class="contador-carrito"><i class="fa fa-cart-plus" > <label id="mi_car"></label> </i></a></li>
                        <li><a href="contacto.jsp">Contacto</a></li>


                        <%
                            cliente objf= (cliente) session.getAttribute("cliente");
                          
                            if (objf != null) {
                        %>
                        <li class="usuario"><a><img src="images/clientes/cliente.jpg" class="cliente_foto"><i class="fa fa-angle-double-down"></i></a>
                            <div class="perfil">
                                <%=objf.getNombre()%>
                                <a href="perfil.jsp">Editar perfil</a>
                                <a href="cliente_session?cerrar=si">Cerrar sesión</a>
                            </div>
                        </li>
                        <%
                        } else {
                        %>
                        <li class="login"><a href="#" onclick="mostrar_vt('vtn-log')">Login</a></li>
                            <%}%>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid --> 
        </nav>
        <div class="full-vt" id="vtn-log">
            <button class="boton-cerrar" onclick="cerrarr_vt(this)">Cerrar</button>
            <div class="login-cli">
                <form action="cliente_session" method="POST">
                    <input name="url" type="hidden" value="" id="url">
                    <script>
                        
                        document.getElementById('url').value=window.location.pathname;
                    </script>
                    <div class="form-group">
                        <input type="email" class="form-control" name="correo" placeholder="Ejemplo@web.com" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="" required="">
                    </div>
                    <div class="text-center">
                        <input type="submit" value="Login" class="btn btn-default">
                    </div>
                    <br>
                    <div>
                        <a href="crear_cuenta.jsp">crear cuenta</a>
                    </div>
                    <div>
                        <a href="recupera_cuenta.jsp">olvido contraseña</a>
                    </div>
                </form>
            </div>
        </div>
