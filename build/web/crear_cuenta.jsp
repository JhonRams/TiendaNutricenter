<%-- 
    Document   : crear_cuenta
    Created on : 06/12/2020, 09:41:23 PM
    Author     : JR
--%>

<%@ include file='head.jsp' %>

<section id="contact" class="contact ">
    <div class="container">
        <div class="row">
            <div class="main_contact whitebackground">

                <div class="contact_content">
                    <div class="cuadrobox comprobante">
                        <div class="single_left_contact">
                            <h4>Ingrese sus datos</h4>
                            <form action="cliente_nuevo" id="formid" method="POST">
                                <input name="url" type="hidden" value="" id="url">
                                <script>

                                    document.getElementById('url').value = window.location.pathname;
                                </script>
                                <div class="form-group">
                                    <select name="tipo_doc" class="">
                                        <option value="DNI">Persona Natural DNI </option>
                                        <option value="RUC">Empresa RUC </option>
                                        <option value="CARNET">Carnet </option>
                                        <option value="OTROS">Otros</option>
                                    </select>
                                    N�:<input type="text" name="documento">
                                </div>  
                                <div class="form-group">
                                    <input type="text" class="form-control" name="nombre" placeholder="Nombre" required="">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="apellido" placeholder="Apellido o Nombre empresa" required="">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" name="correo" placeholder="Correo" required="">
                                </div>

                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Contrase�a" required="">
                                </div>

                                <div class="form-group">
                                    Fecha de nacimineto: <input type="date" class="" name="fech_nac" placeholder="00/00/00" required=""> 
                                    Tel�fono: <input type="text" class="" name="telefono" placeholder="Telefono" required="">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="direccion" placeholder="Direcci�n" required="">
                                </div>
                                <div class="form-group">
                                    G�nero:  <input type="radio" class="" value="M" name="genero">Hombre
                                    <input type="radio" class="" value="F" name="genero">Mujer 
                                    <input type="radio" class="" value="O" name="genero"> Otro
                                </div>
                                <div class="center-content">
                                    <input type="submit" value="Registrarme" class="btn btn-default">
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section><!-- End of Contact Section -->

<%@ include file='footer.jsp' %>

