package idat.pe.app_carrito_service.service;

import idat.pe.app_carrito_service.dto.CarritoDetalleDtoRequest;
import idat.pe.app_carrito_service.dto.CarritoDtoResponse;

public interface CarritoService {
    CarritoDtoResponse obtenerPorCliente(Long clienteId);
    CarritoDtoResponse agregarProducto(Long clienteId, CarritoDetalleDtoRequest request);
    void eliminarDetalle(Long detalleId);
}
