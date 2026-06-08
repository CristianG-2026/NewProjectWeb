package idat.pe.app_venta_service.controller;

import idat.pe.app_venta_service.dto.WishlistDtoResponse;
import idat.pe.app_venta_service.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<WishlistDtoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(wishlistService.listarPorCliente(clienteId));
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<WishlistDtoResponse> crear(@PathVariable Long clienteId, @RequestBody String nombre) {
        return ResponseEntity.ok(wishlistService.crear(clienteId, nombre));
    }

    @PostMapping("/{wishlistId}/producto/{prodVarId}")
    public ResponseEntity<Void> agregarProducto(@PathVariable Long wishlistId, @PathVariable Long prodVarId) {
        wishlistService.agregarProducto(wishlistId, prodVarId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/producto/{detalleId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long detalleId) {
        wishlistService.eliminarProducto(detalleId);
        return ResponseEntity.ok().build();
    }
}
