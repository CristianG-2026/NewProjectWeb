package idat.pe.app_auth_service.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_auth_service.model.Rol;

public interface RolDao extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}
