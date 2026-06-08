package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dto.VentaDtoResponse;

import java.util.List;

public interface VentaService {
    List<VentaDtoResponse> listarTodos();
    List<VentaDtoResponse> listarPorCliente(Long clienteId);
    VentaDtoResponse obtenerPorId(Long id);
    VentaDtoResponse crear(Long clienteId, Long usuarioId, Long pedidoId);
    VentaDtoResponse actualizarEstado(Long id, Integer estado);
}
