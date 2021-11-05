function cerrar_vt_id(e) {
    document.getElementById(e).style.display = "none";
}
function cerrarr_vt(e) {
    e.parentNode.style.display = "none";
}
function mostrar_vt(e) {
    document.getElementById(e).style.display = "block";
}

function imprimir_div(elm) {
    var ventana = window.open('', 'PRINT', 'height=400,width=600');
    ventana.document.write('<html><head><title>Comprovante</title>');
    ventana.document.write('</head><body>');
    ventana.document.write(document.getElementById(elm).innerHTML);
    ventana.document.write('</body></html>');
    ventana.document.close();
    ventana.focus();
    ventana.print();
    ventana.close();
    return  true;
}
if (!sessionStorage.getItem("carrito")) {
    sessionStorage.setItem("carrito", "[]");
}
var datosCarrito = sessionStorage.getItem("carrito");

var datos = JSON.parse(datosCarrito);
function agregar_carrito(e) {
    var producto = e.parentNode.children;

    var codigo = producto[0].value;
    var nombre = producto[1].value;
    var precio = producto[2].value;
    var cantidad = producto[3].value;
    var tipo = producto[4].value;
    var carrito = {codigo: codigo, nombre: nombre, precio: precio, cantidad: cantidad, tipo: tipo};
    datos.push(carrito);
    var jsonproductos = JSON.stringify(datos);
    if (cantidad > 0) {

        sessionStorage.setItem("carrito", jsonproductos);
        document.getElementById("mi_car").innerHTML = catidad_carrito();
    }

}
function catidad_carrito() {
    var datosCarrito = sessionStorage.getItem("carrito");
    var datos = JSON.parse(datosCarrito);
    var total = datos.length;
    return  total;
}
function quitar_pro(i) {
    var datosCarrito = sessionStorage.getItem("carrito");
    var datos = JSON.parse(datosCarrito);
    datos.splice(i, 1);
    console.log(datos);
    var jsonproductos = JSON.stringify(datos);
    sessionStorage.setItem("carrito", jsonproductos);
    document.getElementById("mi_car").innerHTML = catidad_carrito();
    location.reload();
}
try {
    document.getElementById("mi_car").innerHTML = catidad_carrito();
} catch (e) {

}







function Ajax_get(d, dv) {
    try {
        if (d.length > 0) {
            var ajx = new XMLHttpRequest();
            ajx.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    dv.innerHTML = this.responseText;
                }
            };
            ajx.open("GET", "ServletAjax?" + d, true);
            ajx.send();
        }
    } catch (e) {

    }
}

function Ajax_get_admin(d, dv) {
    try {
        if (d.length > 0) {
            var ajx = new XMLHttpRequest();
            ajx.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    dv.innerHTML = this.responseText;
                }
            };
            ajx.open("GET", "../ServletAjax?" + d, true);
            ajx.send();
        }
    } catch (e) {

    }
}
function traer_provincias(e) {
    var dv = document.getElementById('provincias');
    var d = "accion=provincia&depart=" + e.value;
    Ajax_get(d, dv);
    console.log(dv);
}
function traer_distritos(e) {
    var dv = document.getElementById('distritos');
    var d = "accion=distrito&distri=" + e.value;
    Ajax_get(d, dv);
    console.log(dv);
}
function traer_producto(e) {
    var dv = document.getElementById('slc-producto');
    var d = "accion=producto&idprod=" + e.value;
    Ajax_get_admin(d, dv);
    console.log(dv);
}
function agregar_compra() {
    var slc_producto = document.getElementById("slc-producto").innerHTML;
    var elem = document.createElement("div");
    elem.innerHTML = slc_producto+'<i onclick=remover_elm(this) class="fa fa-trash-o font-3xl icode"></i>';
    var lista = document.getElementById("lista-compra");
    lista.appendChild(elem);
}

function remover_elm(e){
    var ele=e.parentNode;
    document.getElementById("lista-compra").removeChild(ele);
}