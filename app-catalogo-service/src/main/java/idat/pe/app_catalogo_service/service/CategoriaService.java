package idat.pe.app_catalogo_service.service;

import java.util.List;
import idat.pe.app_catalogo_service.dto.CategoriaDtoRequest;
import idat.pe.app_catalogo_service.dto.CategoriaDtoResponse;

public interface CategoriaService {
    List<CategoriaDtoResponse> listar();
    CategoriaDtoResponse obtenerPorId(Long id);
    CategoriaDtoResponse crear(CategoriaDtoRequest request);
    CategoriaDtoResponse actualizar(Long id, CategoriaDtoRequest request);
    void eliminar(Long id);
}
