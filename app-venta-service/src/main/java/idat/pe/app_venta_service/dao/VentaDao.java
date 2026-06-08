package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaDao extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteId(Long clienteId);
}
