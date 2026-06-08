package idat.pe.app_venta_service.dao;

import idat.pe.app_venta_service.model.WishlistProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistProductoDao extends JpaRepository<WishlistProducto, Long> {
    List<WishlistProducto> findByWishlist_IdWishlist(Long wishlistId);
}
