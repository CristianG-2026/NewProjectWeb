package idat.pe.app_auth_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import idat.pe.app_auth_service.dto.JwtDtoResponse;
import idat.pe.app_auth_service.dto.LoginDtoRequest;
import idat.pe.app_auth_service.dto.UsuarioDtoResponse;
import idat.pe.app_auth_service.dto.UsuarioRegistroDtoRequest;
import idat.pe.app_auth_service.service.AutenticacionService;
import idat.pe.app_auth_service.service.UsuarioService;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired private AutenticacionService authServ;
    @Autowired private UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDtoRequest loginDto) {
        return ResponseEntity.ok(authServ.autenticar(loginDto));
    }
    @PostMapping("/register")
    public ResponseEntity<UsuarioDtoResponse> register(@RequestBody UsuarioRegistroDtoRequest request) {
        return ResponseEntity.ok(usuarioService.registrar(request));
    }
}
