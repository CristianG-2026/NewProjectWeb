package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.Producto;
import java.util.List;
public interface ProductoDao extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria_CodCategoria(Long categoriaId);
}
