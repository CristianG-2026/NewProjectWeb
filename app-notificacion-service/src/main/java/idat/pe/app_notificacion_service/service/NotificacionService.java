package idat.pe.app_notificacion_service.service;

import idat.pe.app_notificacion_service.dto.NotificacionDtoResponse;

import java.util.List;

public interface NotificacionService {
    List<NotificacionDtoResponse> listarPorCliente(Long clienteId);
    NotificacionDtoResponse marcarLeido(Long id);
}
