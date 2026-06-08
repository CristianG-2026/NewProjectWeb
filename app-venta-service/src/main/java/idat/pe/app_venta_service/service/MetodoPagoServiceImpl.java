package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dao.MetodoPagoDao;
import idat.pe.app_venta_service.dto.MetodoPagoDtoResponse;
import idat.pe.app_venta_service.model.MetodoPago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoDao metodoPagoDao;

    public MetodoPagoServiceImpl(MetodoPagoDao metodoPagoDao) {
        this.metodoPagoDao = metodoPagoDao;
    }

    private MetodoPagoDtoResponse mapToDto(MetodoPago mp) {
        MetodoPagoDtoResponse dto = new MetodoPagoDtoResponse();
        dto.setIdMetodoPago(mp.getIdMetodoPago());
        dto.setNombre(mp.getNombre());
        dto.setEstado(mp.getEstado());
        dto.setCreatedAt(mp.getCreatedAt());
        return dto;
    }

    @Override
    public List<MetodoPagoDtoResponse> listarTodos() {
        return metodoPagoDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
