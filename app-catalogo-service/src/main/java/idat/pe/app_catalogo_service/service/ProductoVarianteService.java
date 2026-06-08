package idat.pe.app_catalogo_service.service;

import java.util.List;
import idat.pe.app_catalogo_service.dto.ProductoVarianteDtoRequest;
import idat.pe.app_catalogo_service.dto.ProductoVarianteDtoResponse;

public interface ProductoVarianteService {
    List<ProductoVarianteDtoResponse> listarPorProducto(Long productoId);
    ProductoVarianteDtoResponse obtenerPorId(Long id);
    ProductoVarianteDtoResponse crear(Long productoId, ProductoVarianteDtoRequest request);
    ProductoVarianteDtoResponse actualizar(Long id, ProductoVarianteDtoRequest request);
    void eliminar(Long id);
}
