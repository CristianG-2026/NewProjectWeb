package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dto.EnvioDtoResponse;

import java.util.List;

public interface EnvioService {
    List<EnvioDtoResponse> listarPorVenta(Long ventaId);
    EnvioDtoResponse crear(Long ventaId, String direccion);
    EnvioDtoResponse actualizarEstado(Long id, Integer estado);
}
