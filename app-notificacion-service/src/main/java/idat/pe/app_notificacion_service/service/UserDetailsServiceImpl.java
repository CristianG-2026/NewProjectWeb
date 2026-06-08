package idat.pe.app_notificacion_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String role = "ROLE_USER";
        if (username.contains("admin")) {
            role = "ROLE_ADMIN";
        }
        return UserDetailsImpl.build(username, role);
    }
}
