package idat.pe.app_pedido_service.service;

import idat.pe.app_pedido_service.dto.PedidoDtoRequest;
import idat.pe.app_pedido_service.dto.PedidoDtoResponse;

import java.util.List;

public interface PedidoService {
    List<PedidoDtoResponse> listarPorCliente(Long clienteId);
    PedidoDtoResponse obtenerPorId(Long id);
    PedidoDtoResponse crear(Long clienteId, PedidoDtoRequest request);
    PedidoDtoResponse actualizarEstado(Long id, Integer estado);
}
