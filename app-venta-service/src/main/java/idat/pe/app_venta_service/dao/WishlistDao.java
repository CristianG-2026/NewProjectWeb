package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistDao extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByClienteId(Long clienteId);
}
