package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.ProductoDescuento;
public interface ProductoDescuentoDao extends JpaRepository<ProductoDescuento, Long> {}
