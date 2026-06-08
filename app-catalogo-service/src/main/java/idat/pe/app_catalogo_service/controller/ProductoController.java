package idat.pe.app_catalogo_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import idat.pe.app_catalogo_service.dto.ProductoDtoRequest;
import idat.pe.app_catalogo_service.dto.ProductoDtoResponse;
import idat.pe.app_catalogo_service.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired private ProductoService service;

    @GetMapping
    public ResponseEntity<List<ProductoDtoResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductoDtoResponse>> listarPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(service.listarPorCategoria(categoriaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDtoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoDtoResponse> crear(@RequestBody ProductoDtoRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoDtoResponse> actualizar(@PathVariable Long id, @RequestBody ProductoDtoRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
