<%-- 
    Document   : perfil
    Created on : 07/12/2020, 04:30:20 PM
    Author     : JR
--%>

<%@ include file='head.jsp' %>
<%if (objf != null) {%>
<section id="contact" class="contact ">
    <div class="container">
        <div class="row">
            <div class="main_contact whitebackground">

                <div class="contact_content">
                    <div class="cuadrobox comprobante">
                        <div class="single_left_contact">
                            <h4>Ingrese sus datos</h4>
       
                            <form action="cliente_actualiza" id="formid" method="POST"  >
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
                                    N°:<input type="text" name="documento" value="<%=objf.getDocumento()%>">
                                    <img src="<%=objf.getFoto()%>" class="fotoperfil"><input type="file" name="foto" id="foto">
                                </div>  
                                <div class="form-group">
                                    <input type="text" class="form-control" name="nombre" placeholder="Nombre" required="" value="<%=objf.getNombre()%>">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="apellido" placeholder="Apellido o Nombre empresa" required="" value="<%=objf.getApellido()%>">
                                </div>
                                <div class="form-group">
                                    Fecha de nacimineto: <input type="date" class="" name="fech_nac" placeholder="00/00/00" required="" value="<%=objf.getFecha_nac()%>">
                                    Teléfono: <input type="text" class="" name="telefono" placeholder="Telefono" required="" value="<%=objf.getTelefono()%>">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="direccion" placeholder="Dirección" required="" value="<%=objf.getDireccion()%>">
                                </div>
                                <div class="form-group">
                                    Género:  <input type="radio" class="" value="M" name="genero">Hombre
                                    <input type="radio" class="" value="F" name="genero">Mujer 
                                    <input type="radio" class="" value="O" name="genero"> Otro
                                </div>
                                <div class="center-content">
                                    <input type="submit" value="Actualizar" class="btn btn-default">
                                    <input type="button" value="Cancelar" class="btn btn-default" onclick="history.go(-1)">
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section><!-- End of Contact Section -->
<%} else {
        out.print("<script>history.go(-1)</script>");
    }%>
<%@ include file='footer.jsp' %>
