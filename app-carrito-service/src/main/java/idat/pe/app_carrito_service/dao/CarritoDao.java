package idat.pe.app_carrito_service.dao;

import idat.pe.app_carrito_service.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoDao extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByClienteId(Long clienteId);
}
