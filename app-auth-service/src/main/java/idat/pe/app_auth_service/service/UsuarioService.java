package idat.pe.app_auth_service.service;

import idat.pe.app_auth_service.dto.UsuarioDtoResponse;
import idat.pe.app_auth_service.dto.UsuarioRegistroDtoRequest;

public interface UsuarioService {
    UsuarioDtoResponse registrar(UsuarioRegistroDtoRequest request);
}
