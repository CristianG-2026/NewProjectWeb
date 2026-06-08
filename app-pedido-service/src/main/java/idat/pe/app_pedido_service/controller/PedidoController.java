package idat.pe.app_pedido_service.controller;

import idat.pe.app_pedido_service.dto.PedidoDtoRequest;
import idat.pe.app_pedido_service.dto.PedidoDtoResponse;
import idat.pe.app_pedido_service.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoDtoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.listarPorCliente(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDtoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<PedidoDtoResponse> crear(@PathVariable Long clienteId, @RequestBody PedidoDtoRequest request) {
        return new ResponseEntity<>(service.crear(clienteId, request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/estado")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PedidoDtoResponse> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(service.actualizarEstado(id, body.get("estado")));
    }
}
