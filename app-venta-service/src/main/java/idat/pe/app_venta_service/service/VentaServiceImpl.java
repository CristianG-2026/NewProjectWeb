package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dao.VentaDao;
import idat.pe.app_venta_service.dao.VentaDetalleDao;
import idat.pe.app_venta_service.dto.VentaDtoResponse;
import idat.pe.app_venta_service.model.Venta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaDao ventaDao;
    private final VentaDetalleDao ventaDetalleDao;

    public VentaServiceImpl(VentaDao ventaDao, VentaDetalleDao ventaDetalleDao) {
        this.ventaDao = ventaDao;
        this.ventaDetalleDao = ventaDetalleDao;
    }

    private VentaDtoResponse mapToDto(Venta venta) {
        VentaDtoResponse dto = new VentaDtoResponse();
        dto.setIdVenta(venta.getIdVenta());
        dto.setClienteId(venta.getClienteId());
        dto.setUsuarioId(venta.getUsuarioId());
        dto.setPedidoId(venta.getPedidoId());
        dto.setCodigo(venta.getCodigo());
        dto.setPrecioTotal(venta.getPrecioTotal());
        dto.setEstado(venta.getEstado());
        dto.setCreatedAt(venta.getCreatedAt());
        return dto;
    }

    @Override
    public List<VentaDtoResponse> listarTodos() {
        return ventaDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<VentaDtoResponse> listarPorCliente(Long clienteId) {
        return ventaDao.findByClienteId(clienteId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public VentaDtoResponse obtenerPorId(Long id) {
        Venta venta = ventaDao.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada: " + id));
        return mapToDto(venta);
    }

    @Override
    public VentaDtoResponse crear(Long clienteId, Long usuarioId, Long pedidoId) {
        Venta venta = new Venta();
        venta.setClienteId(clienteId);
        venta.setUsuarioId(usuarioId);
        venta.setPedidoId(pedidoId);
        venta.setCodigo("V-" + UUID.randomUUID().toString().substring(0, 8) + "-" + System.currentTimeMillis());
        venta.setPrecioTotal(BigDecimal.ZERO);
        venta.setEstado(1);
        venta = ventaDao.save(venta);
        return mapToDto(venta);
    }

    @Override
    public VentaDtoResponse actualizarEstado(Long id, Integer estado) {
        Venta venta = ventaDao.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada: " + id));
        venta.setEstado(estado);
        venta = ventaDao.save(venta);
        return mapToDto(venta);
    }
}
