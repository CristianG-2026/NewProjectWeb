package idat.pe.app_carrito_service.controller;

import idat.pe.app_carrito_service.dto.CarritoDetalleDtoRequest;
import idat.pe.app_carrito_service.dto.CarritoDtoResponse;
import idat.pe.app_carrito_service.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService service;

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<CarritoDtoResponse> obtenerPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.obtenerPorCliente(clienteId));
    }

    @PostMapping("/cliente/{clienteId}/agregar")
    public ResponseEntity<CarritoDtoResponse> agregarProducto(@PathVariable Long clienteId,
                                                               @RequestBody CarritoDetalleDtoRequest request) {
        return new ResponseEntity<>(service.agregarProducto(clienteId, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/detalle/{detalleId}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long detalleId) {
        service.eliminarDetalle(detalleId);
        return ResponseEntity.noContent().build();
    }
}
