package idat.pe.app_notificacion_service.service;

import idat.pe.app_notificacion_service.dao.NotificacionDao;
import idat.pe.app_notificacion_service.dto.NotificacionDtoResponse;
import idat.pe.app_notificacion_service.model.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionDao dao;

    private NotificacionDtoResponse convertir(Notificacion n) {
        NotificacionDtoResponse dto = new NotificacionDtoResponse();
        dto.setIdNotificacion(n.getIdNotificacion());
        dto.setClienteId(n.getClienteId());
        dto.setMensaje(n.getMensaje());
        dto.setTipo(n.getTipo());
        dto.setLeido(n.getLeido());
        dto.setCreatedAt(n.getCreatedAt());
        return dto;
    }

    @Override
    public List<NotificacionDtoResponse> listarPorCliente(Long clienteId) {
        return dao.findByClienteId(clienteId).stream().map(this::convertir).collect(Collectors.toList());
    }

    @Override
    public NotificacionDtoResponse marcarLeido(Long id) {
        Notificacion n = dao.findById(id).orElseThrow(() -> new RuntimeException("Notificacion no encontrada: " + id));
        n.setLeido(1);
        return convertir(dao.save(n));
    }
}
