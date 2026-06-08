package idat.pe.app_cliente_service.service;

import idat.pe.app_cliente_service.dto.ClienteDtoRequest;
import idat.pe.app_cliente_service.dto.ClienteDtoResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteDtoResponse> listarTodos();
    ClienteDtoResponse obtenerPorId(Long id);
    ClienteDtoResponse crear(ClienteDtoRequest request);
    ClienteDtoResponse actualizar(Long id, ClienteDtoRequest request);
    void eliminar(Long id);
}
