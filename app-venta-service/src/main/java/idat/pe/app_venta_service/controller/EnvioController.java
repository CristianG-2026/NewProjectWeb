package idat.pe.app_venta_service.controller;

import idat.pe.app_venta_service.dto.EnvioDtoResponse;
import idat.pe.app_venta_service.service.EnvioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<EnvioDtoResponse>> listarPorVenta(@PathVariable Long ventaId) {
        return ResponseEntity.ok(envioService.listarPorVenta(ventaId));
    }

    @PostMapping("/venta/{ventaId}")
    public ResponseEntity<EnvioDtoResponse> crear(@PathVariable Long ventaId, @RequestBody String direccion) {
        return ResponseEntity.ok(envioService.crear(ventaId, direccion));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<EnvioDtoResponse> actualizarEstado(@PathVariable Long id, @RequestBody Integer estado) {
        return ResponseEntity.ok(envioService.actualizarEstado(id, estado));
    }
}
