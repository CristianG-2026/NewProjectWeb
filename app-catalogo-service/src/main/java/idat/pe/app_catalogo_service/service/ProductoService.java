package idat.pe.app_catalogo_service.service;

import java.util.List;
import idat.pe.app_catalogo_service.dto.ProductoDtoRequest;
import idat.pe.app_catalogo_service.dto.ProductoDtoResponse;

public interface ProductoService {
    List<ProductoDtoResponse> listar();
    List<ProductoDtoResponse> listarPorCategoria(Long categoriaId);
    ProductoDtoResponse obtenerPorId(Long id);
    ProductoDtoResponse crear(ProductoDtoRequest request);
    ProductoDtoResponse actualizar(Long id, ProductoDtoRequest request);
    void eliminar(Long id);
}
