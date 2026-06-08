package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dao.WishlistDao;
import idat.pe.app_venta_service.dao.WishlistProductoDao;
import idat.pe.app_venta_service.dto.WishlistDtoResponse;
import idat.pe.app_venta_service.model.Wishlist;
import idat.pe.app_venta_service.model.WishlistProducto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistDao wishlistDao;
    private final WishlistProductoDao wishlistProductoDao;

    public WishlistServiceImpl(WishlistDao wishlistDao, WishlistProductoDao wishlistProductoDao) {
        this.wishlistDao = wishlistDao;
        this.wishlistProductoDao = wishlistProductoDao;
    }

    private WishlistDtoResponse mapToDto(Wishlist wishlist) {
        WishlistDtoResponse dto = new WishlistDtoResponse();
        dto.setIdWishlist(wishlist.getIdWishlist());
        dto.setClienteId(wishlist.getClienteId());
        dto.setNombre(wishlist.getNombre());
        dto.setCreatedAt(wishlist.getCreatedAt());
        List<String> productos = wishlistProductoDao.findByWishlist_IdWishlist(wishlist.getIdWishlist())
                .stream().map(wp -> String.valueOf(wp.getProductoVarianteId())).collect(Collectors.toList());
        dto.setProductos(productos);
        return dto;
    }

    @Override
    public List<WishlistDtoResponse> listarPorCliente(Long clienteId) {
        return wishlistDao.findByClienteId(clienteId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public WishlistDtoResponse crear(Long clienteId, String nombre) {
        Wishlist wishlist = new Wishlist();
        wishlist.setClienteId(clienteId);
        wishlist.setNombre(nombre);
        wishlist = wishlistDao.save(wishlist);
        return mapToDto(wishlist);
    }

    @Override
    public void agregarProducto(Long wishlistId, Long productoVarianteId) {
        Wishlist wishlist = wishlistDao.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist no encontrada: " + wishlistId));
        WishlistProducto wp = new WishlistProducto();
        wp.setWishlist(wishlist);
        wp.setProductoVarianteId(productoVarianteId);
        wishlistProductoDao.save(wp);
    }

    @Override
    public void eliminarProducto(Long detalleId) {
        wishlistProductoDao.deleteById(detalleId);
    }
}
