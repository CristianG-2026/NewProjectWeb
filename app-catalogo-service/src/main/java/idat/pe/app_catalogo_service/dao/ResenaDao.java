package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.Resena;
import java.util.List;
public interface ResenaDao extends JpaRepository<Resena, Long> {
    List<Resena> findByProducto_Id(Long productoId);
}
