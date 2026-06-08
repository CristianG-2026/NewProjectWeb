package idat.pe.app_auth_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_auth_service.model.RolPermiso;

public interface RolPermisoDao extends JpaRepository<RolPermiso, Long> {
}
