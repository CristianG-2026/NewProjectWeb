package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagoDao extends JpaRepository<MetodoPago, Long> {
}
