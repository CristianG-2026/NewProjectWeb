package idat.pe.app_catalogo_service.service;

import java.util.List;
import idat.pe.app_catalogo_service.dto.ResenaDtoRequest;
import idat.pe.app_catalogo_service.dto.ResenaDtoResponse;

public interface ResenaService {
    List<ResenaDtoResponse> listarPorProducto(Long productoId);
    ResenaDtoResponse crear(Long productoId, Long clienteId, ResenaDtoRequest request);
}
