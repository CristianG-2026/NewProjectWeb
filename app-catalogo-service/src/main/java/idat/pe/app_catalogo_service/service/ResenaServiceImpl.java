package idat.pe.app_catalogo_service.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import idat.pe.app_catalogo_service.dao.ProductoDao;
import idat.pe.app_catalogo_service.dao.ResenaDao;
import idat.pe.app_catalogo_service.dto.ResenaDtoRequest;
import idat.pe.app_catalogo_service.dto.ResenaDtoResponse;
import idat.pe.app_catalogo_service.model.Resena;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ResenaServiceImpl implements ResenaService {

    @Autowired private ResenaDao dao;
    @Autowired private ProductoDao productoDao;

    @Override
    public List<ResenaDtoResponse> listarPorProducto(Long productoId) {
        return dao.findByProducto_Id(productoId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ResenaDtoResponse crear(Long productoId, Long clienteId, ResenaDtoRequest request) {
        Resena r = new Resena();
        r.setProducto(productoDao.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado")));
        r.setClienteId(clienteId);
        r.setCalificacion(request.getCalificacion());
        r.setComentario(request.getComentario());
        return toDto(dao.save(r));
    }

    private ResenaDtoResponse toDto(Resena r) {
        ResenaDtoResponse dto = new ResenaDtoResponse();
        dto.setIdResena(r.getIdResena());
        dto.setProductoId(r.getProducto() != null ? r.getProducto().getId() : null);
        dto.setClienteId(r.getClienteId());
        dto.setClienteNombre("");
        dto.setCalificacion(r.getCalificacion());
        dto.setComentario(r.getComentario());
        dto.setCreatedAt(r.getCreatedAt());
        return dto;
    }
}
