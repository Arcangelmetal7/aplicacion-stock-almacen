escuelita.service.producto = (function () {

    var urlService = "/api/producto/";

    function buscarPorId(idProducto) {
        var urlServiceBuscarPorId = urlService + idProducto;
        return $.get(urlServiceBuscarPorId);
    }

    return {
        buscarPorId: buscarPorId
    };

})();