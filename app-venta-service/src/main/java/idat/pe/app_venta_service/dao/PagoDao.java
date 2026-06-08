package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoDao extends JpaRepository<Pago, Long> {
    List<Pago> findByVenta_IdVenta(Long ventaId);
}
