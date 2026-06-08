package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnvioDao extends JpaRepository<Envio, Long> {
    List<Envio> findByVentaId(Long ventaId);
}
