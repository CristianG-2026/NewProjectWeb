package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dto.MetodoPagoDtoResponse;

import java.util.List;

public interface MetodoPagoService {
    List<MetodoPagoDtoResponse> listarTodos();
}
