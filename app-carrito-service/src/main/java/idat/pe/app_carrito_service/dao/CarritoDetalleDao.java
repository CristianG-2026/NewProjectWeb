package idat.pe.app_carrito_service.dao;

import idat.pe.app_carrito_service.model.CarritoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoDetalleDao extends JpaRepository<CarritoDetalle, Long> {
    List<CarritoDetalle> findByCarrito_IdCarrito(Long carritoId);
}
