package idat.pe.app_cliente_service.service;

import idat.pe.app_cliente_service.dao.ClienteDao;
import idat.pe.app_cliente_service.dto.ClienteDtoRequest;
import idat.pe.app_cliente_service.dto.ClienteDtoResponse;
import idat.pe.app_cliente_service.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao dao;

    private ClienteDtoResponse convertir(Cliente c) {
        ClienteDtoResponse dto = new ClienteDtoResponse();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setTelefono(c.getTelefono());
        dto.setEmail(c.getEmail());
        dto.setDireccion(c.getDireccion());
        dto.setEstado(c.getEstado());
        dto.setUsuarioId(c.getUsuarioId());
        dto.setCreatedAt(c.getCreatedAt());
        return dto;
    }

    @Override
    public List<ClienteDtoResponse> listarTodos() {
        return dao.findAll().stream().map(this::convertir).collect(Collectors.toList());
    }

    @Override
    public ClienteDtoResponse obtenerPorId(Long id) {
        Cliente c = dao.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        return convertir(c);
    }

    @Override
    public ClienteDtoResponse crear(ClienteDtoRequest request) {
        Cliente c = new Cliente();
        c.setNombre(request.getNombre());
        c.setTelefono(request.getTelefono());
        c.setEmail(request.getEmail());
        c.setDireccion(request.getDireccion());
        c.setUsuarioId(request.getUsuarioId());
        c.setEstado(1);
        return convertir(dao.save(c));
    }

    @Override
    public ClienteDtoResponse actualizar(Long id, ClienteDtoRequest request) {
        Cliente c = dao.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        c.setNombre(request.getNombre());
        c.setTelefono(request.getTelefono());
        c.setEmail(request.getEmail());
        c.setDireccion(request.getDireccion());
        c.setUsuarioId(request.getUsuarioId());
        return convertir(dao.save(c));
    }

    @Override
    public void eliminar(Long id) {
        Cliente c = dao.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        c.setEstado(0);
        dao.save(c);
    }
}
