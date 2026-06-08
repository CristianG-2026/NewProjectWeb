package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.Categoria;
public interface CategoriaDao extends JpaRepository<Categoria, Long> {}
