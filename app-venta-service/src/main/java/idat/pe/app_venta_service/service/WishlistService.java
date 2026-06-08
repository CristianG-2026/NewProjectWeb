package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dto.WishlistDtoResponse;

import java.util.List;

public interface WishlistService {
    List<WishlistDtoResponse> listarPorCliente(Long clienteId);
    WishlistDtoResponse crear(Long clienteId, String nombre);
    void agregarProducto(Long wishlistId, Long productoVarianteId);
    void eliminarProducto(Long detalleId);
}
