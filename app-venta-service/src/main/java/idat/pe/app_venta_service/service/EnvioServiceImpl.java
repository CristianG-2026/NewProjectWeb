package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dao.EnvioDao;
import idat.pe.app_venta_service.dto.EnvioDtoResponse;
import idat.pe.app_venta_service.model.Envio;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final EnvioDao envioDao;

    public EnvioServiceImpl(EnvioDao envioDao) {
        this.envioDao = envioDao;
    }

    private EnvioDtoResponse mapToDto(Envio envio) {
        EnvioDtoResponse dto = new EnvioDtoResponse();
        dto.setIdEnvio(envio.getIdEnvio());
        dto.setVentaId(envio.getVentaId());
        dto.setDireccion(envio.getDireccion());
        dto.setFechaEnvio(envio.getFechaEnvio());
        dto.setEstado(envio.getEstado());
        dto.setCreatedAt(envio.getCreatedAt());
        return dto;
    }

    @Override
    public List<EnvioDtoResponse> listarPorVenta(Long ventaId) {
        return envioDao.findByVentaId(ventaId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public EnvioDtoResponse crear(Long ventaId, String direccion) {
        Envio envio = new Envio();
        envio.setVentaId(ventaId);
        envio.setDireccion(direccion);
        envio.setFechaEnvio(new Date());
        envio.setEstado(1);
        envio = envioDao.save(envio);
        return mapToDto(envio);
    }

    @Override
    public EnvioDtoResponse actualizarEstado(Long id, Integer estado) {
        Envio envio = envioDao.findById(id).orElseThrow(() -> new RuntimeException("Envio no encontrado: " + id));
        envio.setEstado(estado);
        envio = envioDao.save(envio);
        return mapToDto(envio);
    }
}
