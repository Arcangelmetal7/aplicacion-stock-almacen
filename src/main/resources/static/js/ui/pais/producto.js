escuelita.ui.producto = (function () {

    var $bodyTablaProducto = $("#bodyTablaProducto");
    var $spanIdProductoEncontrado = $("#idProductoEncontrado");
    var $divMensajeNoEncontrado = $("#mensajeNoEncontrado");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    function buscar(idProducto) {
        escuelita.service.producto.buscarPorId(idProducto)
                .done(mostrar)
                .fail(mostrarMensajeNoEncontrado);
    }

    function mostrar(producto) {
        $bodyTablaProducto.html("<tr><td>" + producto.id + "</td><td>" + producto.nombre + "</td></tr>");
        $spanIdProductoEncontrado.text(producto.id);
    }

    function bindearEventosABotones() {
        $("#botonBuscarProductoPorId").on("click", function () {
            $("#mensajeNoEncontrado").addClass("hide");
            var idProductoABuscar = $("#idProductoABuscar").val();
            buscar(idProductoABuscar);
        });
    }

    function mostrarMensajeNoEncontrado() {
        $bodyTablaProducto.text("");
        $spanIdProductoEncontrado.text("");
        $divMensajeNoEncontrado.removeClass("hide");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.producto.inicializar();
});