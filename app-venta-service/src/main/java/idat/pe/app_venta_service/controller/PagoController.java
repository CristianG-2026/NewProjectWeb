package idat.pe.app_venta_service.controller;

import idat.pe.app_venta_service.dto.PagoDtoRequest;
import idat.pe.app_venta_service.dto.PagoDtoResponse;
import idat.pe.app_venta_service.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<PagoDtoResponse>> listarPorVenta(@PathVariable Long ventaId) {
        return ResponseEntity.ok(pagoService.listarPorVenta(ventaId));
    }

    @PostMapping("/venta/{ventaId}")
    public ResponseEntity<PagoDtoResponse> crear(@PathVariable Long ventaId, @RequestBody PagoDtoRequest request) {
        return ResponseEntity.ok(pagoService.crear(ventaId, request));
    }
}
