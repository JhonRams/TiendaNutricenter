<%-- 
    Document   : recupera_cuenta
    Created on : 06/12/2020, 09:45:54 PM
    Author     : JR
--%>
<%@ include file='head.jsp' %>

<section id="contact" class="contact sections">
    <div class="container">
        <div class="row">
            <div class="main_contact whitebackground">

                <div class="contact_content">
                     <div class="col-md-6">
                        <div class="single_left_contact">
                            <div class="head_title text-center">
                                <h4>Recuperar Cuenta</h4>
                                <p>Ingrese correo con quien se registró. Le enviareamos un mensaje para que recupere su cuenta
                                </p>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="single_left_contact">
                            <form action="#" id="formid">
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" placeholder="ejemplo@email.com" required="">
                                </div>
                                <div class="center-content">
                                    <input type="submit" value="Enviar" class="btn btn-default">
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
