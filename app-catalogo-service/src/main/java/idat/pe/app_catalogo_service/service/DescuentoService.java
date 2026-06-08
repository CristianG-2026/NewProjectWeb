package idat.pe.app_catalogo_service.service;

import java.util.List;
import idat.pe.app_catalogo_service.dto.DescuentoDtoRequest;
import idat.pe.app_catalogo_service.dto.DescuentoDtoResponse;

public interface DescuentoService {
    List<DescuentoDtoResponse> listar();
    DescuentoDtoResponse obtenerPorId(Long id);
    DescuentoDtoResponse crear(DescuentoDtoRequest request);
    DescuentoDtoResponse actualizar(Long id, DescuentoDtoRequest request);
    void eliminar(Long id);
}
