package idat.pe.app_auth_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import idat.pe.app_auth_service.dao.RolDao;
import idat.pe.app_auth_service.dao.UsuarioDao;
import idat.pe.app_auth_service.dto.UsuarioDtoResponse;
import idat.pe.app_auth_service.dto.UsuarioRegistroDtoRequest;
import idat.pe.app_auth_service.model.Rol;
import idat.pe.app_auth_service.model.Usuario;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired private UsuarioDao usuarioDao;
    @Autowired private RolDao rolDao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Override
    public UsuarioDtoResponse registrar(UsuarioRegistroDtoRequest request) {
        Rol rol = request.getRolId() != null ? rolDao.findById(request.getRolId()).orElse(null) : null;
        Usuario usu = new Usuario();
        usu.setUsuario(request.getUsuario());
        usu.setPassword(passwordEncoder.encode(request.getPassword()));
        usu.setRol(rol);
        usu.setEstado(1);
        usu = usuarioDao.save(usu);
        UsuarioDtoResponse dto = new UsuarioDtoResponse();
        dto.setId(usu.getId());
        dto.setUsuario(usu.getUsuario());
        dto.setRol(usu.getRol() != null ? usu.getRol().getNombre() : null);
        dto.setEstado(usu.getEstado());
        return dto;
    }
}
