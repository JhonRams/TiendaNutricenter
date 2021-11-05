<%-- 
    Document   : index
    Created on : 21/11/2020, 10:58:38 AM
    Author     : JR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- /#header -->
<!-- Content -->
<%@ include file='head.jsp' %>
<div class="content">
    <!-- Animated -->
    <div class="animated fadeIn">
        <!-- Widgets  -->
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-five">
                            <div class="stat-icon dib flat-color-1">
                                <i class="pe-7s-cash"></i>
                            </div>
                            <div class="stat-content">
                                <div class="text-left dib">
                                    <div class="stat-text">S/<span class="count">235.50</span></div>
                                    <div class="stat-heading">Ventas</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-five">
                            <div class="stat-icon dib flat-color-2">
                                <i class="pe-7s-cart"></i>
                            </div>
                            <div class="stat-content">
                                <div class="text-left dib">
                                    <div class="stat-text"><span class="count">3435</span></div>
                                    <div class="stat-heading">Productos</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-five">
                            <div class="stat-icon dib flat-color-3">
                                <i class="pe-7s-browser"></i>
                            </div>
                            <div class="stat-content">
                                <div class="text-left dib">
                                    <div class="stat-text"><span class="count">349</span></div>
                                    <div class="stat-heading">Servicios</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-five">
                            <div class="stat-icon dib flat-color-4">
                                <i class="pe-7s-users"></i>
                            </div>
                            <div class="stat-content">
                                <div class="text-left dib">
                                    <div class="stat-text"><span class="count">2986</span></div>
                                    <div class="stat-heading">Clientes</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Widgets -->
        <!--  Traffic  -->
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="box-title">Trafico web </h4>
                    </div>
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="card-body">
                                <!-- <canvas id="TrafficChart"></canvas>   -->
                                <div id="traffic-chart" class="traffic-chart"><svg xmlns:ct="http://gionkunz.github.com/chartist-js/ct" width="100%" height="100%" class="ct-chart-line" style="width: 100%; height: 100%;"><g class="ct-grids"><line x1="50" x2="50" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line x1="129.66666259765626" x2="129.66666259765626" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line x1="209.3333251953125" x2="209.3333251953125" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line x1="288.9999877929688" x2="288.9999877929688" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line x1="368.666650390625" x2="368.666650390625" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line x1="448.33331298828125" x2="448.33331298828125" y1="15" y2="300" class="ct-grid ct-horizontal"></line><line y1="300" y2="300" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="259.2857142857143" y2="259.2857142857143" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="218.57142857142856" y2="218.57142857142856" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="177.85714285714286" y2="177.85714285714286" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="137.14285714285714" y2="137.14285714285714" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="96.42857142857142" y2="96.42857142857142" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="55.71428571428572" y2="55.71428571428572" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line><line y1="15" y2="15" x1="50" x2="448.33331298828125" class="ct-grid ct-vertical"></line></g><g><g class="ct-series ct-series-a"><path d="M50,300L50,300C76.556,251.143,103.111,200.89,129.667,153.429C156.222,105.967,182.778,15,209.333,15C235.889,15,262.444,83.901,289,96.429C315.556,108.956,342.111,106.526,368.667,120.857C395.222,135.189,421.778,240.286,448.333,300L448.333,300Z" class="ct-area"></path></g><g class="ct-series ct-series-b"><path d="M50,300L50,300C76.556,210.429,103.111,31.286,129.667,31.286C156.222,31.286,182.778,177.857,209.333,177.857C235.889,177.857,262.444,137.143,289,137.143C315.556,137.143,342.111,157.603,368.667,177.857C395.222,198.111,421.778,257.657,448.333,297.557L448.333,300Z" class="ct-area"></path></g><g class="ct-series ct-series-c"><path d="M50,300L50,300C76.556,259.286,103.111,215.663,129.667,177.857C156.222,140.051,182.778,72,209.333,72C235.889,72,262.444,177.857,289,177.857C315.556,177.857,342.111,55.714,368.667,55.714C395.222,55.714,421.778,191.429,448.333,259.286L448.333,300Z" class="ct-area"></path></g></g><g class="ct-labels"><foreignObject style="overflow: visible;" x="50" y="305" width="79.66666259765626" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 80px; height: 20px;">Jan</span></foreignObject><foreignObject style="overflow: visible;" x="129.66666259765626" y="305" width="79.66666259765626" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 80px; height: 20px;">Feb</span></foreignObject><foreignObject style="overflow: visible;" x="209.3333251953125" y="305" width="79.66666259765626" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 80px; height: 20px;">Mar</span></foreignObject><foreignObject style="overflow: visible;" x="288.9999877929688" y="305" width="79.66666259765626" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 80px; height: 20px;">Apr</span></foreignObject><foreignObject style="overflow: visible;" x="368.666650390625" y="305" width="79.66666259765623" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 80px; height: 20px;">May</span></foreignObject><foreignObject style="overflow: visible;" x="448.33331298828125" y="305" width="30" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 30px; height: 20px;">Jun</span></foreignObject><foreignObject style="overflow: visible;" y="259.2857142857143" x="10" height="40.714285714285715" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">0</span></foreignObject><foreignObject style="overflow: visible;" y="218.57142857142856" x="10" height="40.714285714285715" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">5000</span></foreignObject><foreignObject style="overflow: visible;" y="177.85714285714283" x="10" height="40.71428571428571" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">10000</span></foreignObject><foreignObject style="overflow: visible;" y="137.14285714285714" x="10" height="40.71428571428572" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">15000</span></foreignObject><foreignObject style="overflow: visible;" y="96.42857142857142" x="10" height="40.71428571428572" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">20000</span></foreignObject><foreignObject style="overflow: visible;" y="55.71428571428572" x="10" height="40.714285714285694" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">25000</span></foreignObject><foreignObject style="overflow: visible;" y="15" x="10" height="40.71428571428572" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 41px; width: 30px;">30000</span></foreignObject><foreignObject style="overflow: visible;" y="-15" x="10" height="30" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 30px; width: 30px;">35000</span></foreignObject></g></svg></div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card-body">
                                <div class="progress-box progress-1">
                                    <h4 class="por-title">Visitas</h4>
                                    <div class="por-txt">96,930 Usuarios (40%)</div>
                                    <div class="progress mb-2" style="height: 5px;">
                                        <div class="progress-bar bg-flat-color-1" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                                <div class="progress-box progress-2">
                                    <h4 class="por-title">Visita productos</h4>
                                    <div class="por-txt">3,220 Usuarios (24%)</div>
                                    <div class="progress mb-2" style="height: 5px;">
                                        <div class="progress-bar bg-flat-color-2" role="progressbar" style="width: 24%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                                <div class="progress-box progress-2">
                                    <h4 class="por-title">Visita servicios</h4>
                                    <div class="por-txt">29,658 Usuarios (60%)</div>
                                    <div class="progress mb-2" style="height: 5px;">
                                        <div class="progress-bar bg-flat-color-3" role="progressbar" style="width: 60%;" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                                <div class="progress-box progress-2">
                                    <h4 class="por-title">Registros</h4>
                                    <div class="por-txt">99,658 Usuarios (90%)</div>
                                    <div class="progress mb-2" style="height: 5px;">
                                        <div class="progress-bar bg-flat-color-4" role="progressbar" style="width: 90%;" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div> <!-- /.card-body -->
                        </div>
                    </div> <!-- /.row -->
                    <div class="card-body"></div>
                </div>
            </div><!-- /# column -->
        </div>
        <!--  /Traffic -->
        <div class="clearfix"></div>
        <!-- Orders -->
        <div class="orders">
            <div class="row">
                <div class="col-xl-8">
                    <div class="card">


                    </div> <!-- /.card -->
                </div>  <!-- /.col-lg-8 -->

                <!-- /.col-md-4 -->
            </div>
        </div>
        <!-- /.orders -->
        <!-- To Do and Live Chat -->

        <!-- /To Do and Live Chat -->
        <!-- Calender Chart Weather  -->

        <!-- /Calender Chart Weather -->
        <!-- Modal - Calendar - Add New Event -->
        <div class="modal fade none-border" id="event-modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title"><strong>Add New Event</strong></h4>
                    </div>
                    <div class="modal-body"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-success save-event waves-effect waves-light">Create event</button>
                        <button type="button" class="btn btn-danger delete-event waves-effect waves-light" data-dismiss="modal">Delete</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#event-modal -->
        <!-- Modal - Calendar - Add Category -->
        <div class="modal fade none-border" id="add-category">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title"><strong>Add a category </strong></h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="row">
                                <div class="col-md-6">
                                    <label class="control-label">Category Name</label>
                                    <input class="form-control form-white" placeholder="Enter name" type="text" name="category-name">
                                </div>
                                <div class="col-md-6">
                                    <label class="control-label">Choose Category Color</label>
                                    <select class="form-control form-white" data-placeholder="Choose a color..." name="category-color">
                                        <option value="success">Success</option>
                                        <option value="danger">Danger</option>
                                        <option value="info">Info</option>
                                        <option value="pink">Pink</option>
                                        <option value="primary">Primary</option>
                                        <option value="warning">Warning</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-danger waves-effect waves-light save-category" data-dismiss="modal">Save</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#add-category -->
    </div>
    <!-- .animated -->
</div>
<!-- /.content -->
<%@ include file='footer.jsp' %>