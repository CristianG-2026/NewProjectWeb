package idat.pe.app_notificacion_service.controller;

import idat.pe.app_notificacion_service.dto.NotificacionDtoResponse;
import idat.pe.app_notificacion_service.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<NotificacionDtoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.listarPorCliente(clienteId));
    }

    @PutMapping("/{id}/leido")
    public ResponseEntity<NotificacionDtoResponse> marcarLeido(@PathVariable Long id) {
        return ResponseEntity.ok(service.marcarLeido(id));
    }
}
