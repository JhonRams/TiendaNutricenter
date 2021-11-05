<%-- 
    Document   : pagar
    Created on : 04/12/2020, 03:37:10 PM
    Author     : JR
--%>

<%@ include file='head.jsp' %>
<div class="pago_visa">
    <form action="comprobante.jsp" id="formid">
          <input name="ncompra"type="hidden" value="445">
        <div><h3>Monto: S/725.00</h3></div>
        <div class="form-group">
           Número de targeta <input type="text" class="form-control" name="numerotarj" placeholder="000000000000" required="">
        </div>

        <div class="form-group">
           Fecha de vencimiento <input type="date" class="form-control" name="fecha_ven" placeholder="00/00/00" required="">
        </div>
        <div class="form-group">
            Código de verificación <input type="text" class="form-control" name="cod" placeholder="---" required="">
        </div>
        <div class="center-content">
            <input type="submit" value="Pagar" class="btn btn-default">
        </div>
        <a href="carrito.jsp">Cancelar</a>
    </form>
</div>

<%@ include file='footer.jsp' %>
