package idat.pe.app_pedido_service.service;

import idat.pe.app_pedido_service.dao.PedidoDao;
import idat.pe.app_pedido_service.dao.PedidoDetalleDao;
import idat.pe.app_pedido_service.dto.*;
import idat.pe.app_pedido_service.model.Pedido;
import idat.pe.app_pedido_service.model.PedidoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Autowired
    private PedidoDetalleDao detalleDao;

    private PedidoDetalleDtoResponse convertirDetalle(PedidoDetalle d) {
        PedidoDetalleDtoResponse dto = new PedidoDetalleDtoResponse();
        dto.setIdPedidoDetalle(d.getIdPedidoDetalle());
        dto.setProductoVarianteId(d.getProductoVarianteId());
        dto.setCantidad(d.getCantidad());
        dto.setPrecioUnitario(d.getPrecioUnitario());
        return dto;
    }

    private PedidoDtoResponse convertirPedido(Pedido p) {
        PedidoDtoResponse dto = new PedidoDtoResponse();
        dto.setIdPedido(p.getIdPedido());
        dto.setClienteId(p.getClienteId());
        dto.setDireccion(p.getDireccion());
        dto.setEstado(p.getEstado());
        dto.setFechaEntrega(p.getFechaEntrega());
        dto.setCreatedAt(p.getCreatedAt());
        List<PedidoDetalle> detalles = detalleDao.findByPedido_IdPedido(p.getIdPedido());
        dto.setDetalles(detalles.stream().map(this::convertirDetalle).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public List<PedidoDtoResponse> listarPorCliente(Long clienteId) {
        return pedidoDao.findByClienteId(clienteId).stream().map(this::convertirPedido).collect(Collectors.toList());
    }

    @Override
    public PedidoDtoResponse obtenerPorId(Long id) {
        Pedido p = pedidoDao.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));
        return convertirPedido(p);
    }

    @Override
    public PedidoDtoResponse crear(Long clienteId, PedidoDtoRequest request) {
        Pedido p = new Pedido();
        p.setClienteId(clienteId);
        p.setDireccion(request.getDireccion());
        p.setEstado(1);
        p = pedidoDao.save(p);

        for (PedidoDetalleDtoRequest detReq : request.getDetalles()) {
            PedidoDetalle d = new PedidoDetalle();
            d.setPedido(p);
            d.setProductoVarianteId(detReq.getProductoVarianteId());
            d.setCantidad(detReq.getCantidad());
            d.setPrecioUnitario(detReq.getPrecioUnitario());
            detalleDao.save(d);
        }

        return convertirPedido(p);
    }

    @Override
    public PedidoDtoResponse actualizarEstado(Long id, Integer estado) {
        Pedido p = pedidoDao.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));
        p.setEstado(estado);
        return convertirPedido(pedidoDao.save(p));
    }
}
