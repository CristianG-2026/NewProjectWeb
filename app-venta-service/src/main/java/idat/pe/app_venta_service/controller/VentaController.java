package idat.pe.app_venta_service.controller;

import idat.pe.app_venta_service.dto.VentaDtoResponse;
import idat.pe.app_venta_service.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public ResponseEntity<List<VentaDtoResponse>> listarTodos() {
        return ResponseEntity.ok(ventaService.listarTodos());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<VentaDtoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(ventaService.listarPorCliente(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDtoResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerPorId(id));
    }

    @PostMapping("/cliente/{cid}/usuario/{uid}/pedido/{pid}")
    public ResponseEntity<VentaDtoResponse> crear(@PathVariable Long cid, @PathVariable Long uid, @PathVariable Long pid) {
        return ResponseEntity.ok(ventaService.crear(cid, uid, pid));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<VentaDtoResponse> actualizarEstado(@PathVariable Long id, @RequestBody Integer estado) {
        return ResponseEntity.ok(ventaService.actualizarEstado(id, estado));
    }
}
