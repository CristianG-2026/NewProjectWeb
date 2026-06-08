package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.ProductoVariante;
import java.util.List;
public interface ProductoVarianteDao extends JpaRepository<ProductoVariante, Long> {
    List<ProductoVariante> findByProducto_Id(Long productoId);
}
