<%-- 
    Document   : head
    Created on : 23/11/2020, 06:03:19 PM
    Author     : JR
--%>
<%@page import="modelo.personal"%>

<%
    if (request.getParameter("cerrar") != null) {
        session.setAttribute("usuario", null);
        
    }
%>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<%
    boolean SI[] = null;
    personal obPersonal = (personal) session.getAttribute("usuario");
    if (obPersonal != null) {
        SI = obPersonal.getPerfil().Permisos();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Panel </title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="../images/favicon.png">
        <link rel="shortcut icon" href="../images/favicon.png">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="css/cs-skin-elastic.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
        <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet" />
        <link href="../css/estilos.css" rel="stylesheet" type="text/css"/>

        <style>
            #weatherWidget .currentDesc {
                color: #ffffff!important;
            }
            .traffic-chart {
                min-height: 335px;
            }
            #flotPie1  {
                height: 150px;
            }
            #flotPie1 td {
                padding:3px;
            }
            #flotPie1 table {
                top: 20px!important;
                right: -10px!important;
            }
            .chart-container {
                display: table;
                min-width: 270px ;
                text-align: left;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            #flotLine5  {
                height: 105px;
            }

            #flotBarChart {
                height: 150px;
            }
            #cellPaiChart{
                height: 160px;
            }

        </style>
    </head>

    <body>
        <!-- Left Panel -->
        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">
                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class=" active text-center text-uppercase "><h5><%=obPersonal.getPerfil().getNombre()%></h5></li>
                        <li class="active">
                            <%if (SI[0]) { %>
                            <a href="index.jsp"><i class="menu-icon fa fa-laptop"></i>Resumen</a>
                            <% }%>
                            <%if (SI[1]) { %>
                            <a href="index.jsp"><i class="menu-icon fa fa-laptop"></i>Ventas</a>
                            <% }%>
                        </li>
                        <%if (SI[2]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cube"></i>ADMINISTRAR</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-tag"></i><a href="adm_producto.jsp">Productos</a></li>

                                <li><i class="fa fa-user"></i><a href="adm_personal.jsp">Personal</a></li>

                                <li><i class="fa fa-users "></i><a href="adm_cliente.jsp">clientes</a></li>

                            </ul>
                        </li>
                        <% }%>
                        <%if (SI[3]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-shopping-cart"></i>COMPRAS</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-send"></i><a href="com_orden.jsp">Orden</a></li>

                                <li><i class="fa fa-save"></i><a href="com_realizadas.jsp">Realizadas</a></li>

                            </ul>
                        </li>
                        <% }%>
                        <%if (SI[4]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-money"></i>VENTAS</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-tags"></i><a href="ven_producto.jsp">Productos</a></li>


                                <li><i class="fa fa-cubes"></i><a href="ven_pedido.jsp">Pedidos</a></li>

                            </ul>
                        </li>
                        <% }%>
                        <%if (SI[5]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-truck"></i>DELIVERY</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-send"></i><a href="del_pendiente.jsp">Pendientes</a></li>

                                <li><i class="fa fa-save"></i><a href="del_realizadas.jsp">Realizados</a></li>

                            </ul>
                        </li>
                        <% }%>
                        <%if (SI[6]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>REPORTES</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-cubes"></i><a href="rep_general.jsp">General</a></li>

                                <li><i class="fa fa-tags"></i><a href="rep_producto.jsp">Productos</a></li>

                              

                                <li><i class="fa fa-user"></i><a href="rep_personal.jsp">Personal</a></li>

                            </ul>
                        </li>
                        <% }%>
                        <%if (SI[7]) { %>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cog"></i>CONFIGURAR</a>
                            <ul class="sub-menu children dropdown-menu">

                                <li><i class="fa fa-hdd-o"></i><a href="conf_sistema.jsp">Sistema</a></li>

                            </ul>
                        </li>
                        <% }%>

                    </ul>

                </div><!-- /.navbar-collapse -->
            </nav>
        </aside>
        <!-- /#left-panel -->
        <!-- Right Panel -->
        <div id="right-panel" class="right-panel">
            <!-- Header-->
            <header id="header" class="header">
                <div class="top-left">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="./"><img src="../images/logo.jpg" alt="Logo" class="logopn"></a>
                        <a class="navbar-brand hidden" href="./"><img src="../images/logo.jpg" alt="Logo" class="logopn"></a>
                        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
                <div class="top-right">
                    <div class="header-menu">
                        <div class="header-left">
                            <button class="search-trigger"><i class="fa fa-search"></i></button>
                            <div class="form-inline">
                                <form class="search-form">
                                    <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                    <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                                </form>
                            </div>

                            <div class="dropdown for-notification">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="count bg-danger">1</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="notification">
                                    <p class="red">Tiene 1 Notificaciones</p>
                                    <a class="dropdown-item media" href="#">
                                        <i class="fa fa-check"></i>
                                        <p>Entrega Cumplida</p>
                                    </a>

                                </div>
                            </div>

                            <div class="dropdown for-message">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-envelope"></i>
                                    <span class="count bg-primary">2</span>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="message">
                                    <p class="red">Tienes 2 correos</p>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/1.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Jonathan Smith</span>
                                            <span class="time float-right">Hace 1 min</span>
                                            <p>Hola</p>
                                        </div>
                                    </a>
                                    <a class="dropdown-item media" href="#">
                                        <span class="photo media-left"><img alt="avatar" src="images/avatar/2.jpg"></span>
                                        <div class="message media-body">
                                            <span class="name float-left">Jack Sanders</span>
                                            <span class="time float-right">hace 5 min</span>
                                            <p>Costo servicio</p>
                                        </div>
                                    </a>

                                </div>
                            </div>
                        </div>

                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="user-avatar rounded-circle" src="<%=obPersonal.getFoto()%>" alt="User Avatar">
                            </a>

                            <div class="user-menu dropdown-menu">
                                <a class="nav-link"><%=obPersonal.getNombre()%></a>
                                <a class="nav-link" href="#"><i class="fa fa- user"></i>Mi perfil</a>

                                <a class="nav-link" href="#"><i class="fa fa- user"></i>Notificaciones <span class="count">13</span></a>

                                <a class="nav-link" href="#"><i class="fa fa -cog"></i>Configuración</a>

                                <a class="nav-link" href="?cerrar=si"><i class="fa fa-power -off"></i>Cerrar Sesión</a>
                            </div>
                        </div>

                    </div>
                </div>
            </header>

            <%
                }
            %>