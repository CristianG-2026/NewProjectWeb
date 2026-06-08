package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaDetalleDao extends JpaRepository<VentaDetalle, Long> {
    List<VentaDetalle> findByVenta_IdVenta(Long ventaId);
}
