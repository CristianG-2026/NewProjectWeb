package idat.pe.app_auth_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import idat.pe.app_auth_service.dao.UsuarioDao;
import idat.pe.app_auth_service.model.Usuario;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UsuarioDao dao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usu = dao.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        return UserDetailsImpl.build(usu);
    }
}
