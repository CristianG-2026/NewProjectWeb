package idat.pe.app_catalogo_service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_catalogo_service.model.Descuento;
public interface DescuentoDao extends JpaRepository<Descuento, Long> {}
