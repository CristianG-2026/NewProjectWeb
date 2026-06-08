package idat.pe.app_notificacion_service.dao;

import idat.pe.app_notificacion_service.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionDao extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByClienteId(Long clienteId);
}
