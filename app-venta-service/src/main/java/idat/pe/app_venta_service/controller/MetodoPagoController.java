package idat.pe.app_venta_service.controller;

import idat.pe.app_venta_service.dto.MetodoPagoDtoResponse;
import idat.pe.app_venta_service.service.MetodoPagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public ResponseEntity<List<MetodoPagoDtoResponse>> listarTodos() {
        return ResponseEntity.ok(metodoPagoService.listarTodos());
    }
}
