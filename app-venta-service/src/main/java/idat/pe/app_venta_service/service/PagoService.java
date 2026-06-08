package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dto.PagoDtoRequest;
import idat.pe.app_venta_service.dto.PagoDtoResponse;

import java.util.List;

public interface PagoService {
    List<PagoDtoResponse> listarPorVenta(Long ventaId);
    PagoDtoResponse crear(Long ventaId, PagoDtoRequest request);
}
