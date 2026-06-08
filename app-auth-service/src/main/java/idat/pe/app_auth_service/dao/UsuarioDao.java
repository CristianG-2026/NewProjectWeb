package idat.pe.app_auth_service.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.app_auth_service.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
