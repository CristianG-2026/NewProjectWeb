package idat.pe.app_venta_service.service;

import idat.pe.app_venta_service.dao.MetodoPagoDao;
import idat.pe.app_venta_service.dao.PagoDao;
import idat.pe.app_venta_service.dao.VentaDao;
import idat.pe.app_venta_service.dto.PagoDtoRequest;
import idat.pe.app_venta_service.dto.PagoDtoResponse;
import idat.pe.app_venta_service.model.MetodoPago;
import idat.pe.app_venta_service.model.Pago;
import idat.pe.app_venta_service.model.Venta;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoDao pagoDao;
    private final VentaDao ventaDao;
    private final MetodoPagoDao metodoPagoDao;

    public PagoServiceImpl(PagoDao pagoDao, VentaDao ventaDao, MetodoPagoDao metodoPagoDao) {
        this.pagoDao = pagoDao;
        this.ventaDao = ventaDao;
        this.metodoPagoDao = metodoPagoDao;
    }

    private PagoDtoResponse mapToDto(Pago pago) {
        PagoDtoResponse dto = new PagoDtoResponse();
        dto.setIdPago(pago.getIdPago());
        dto.setVentaId(pago.getVenta().getIdVenta());
        dto.setMetodoPagoId(pago.getMetodoPago().getIdMetodoPago());
        dto.setMetodoPagoNombre(pago.getMetodoPago().getNombre());
        dto.setMonto(pago.getMonto());
        dto.setFecha(pago.getFecha());
        dto.setEstado(pago.getEstado());
        dto.setTransaccionExterna(pago.getTransaccionExterna());
        return dto;
    }

    @Override
    public List<PagoDtoResponse> listarPorVenta(Long ventaId) {
        return pagoDao.findByVenta_IdVenta(ventaId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PagoDtoResponse crear(Long ventaId, PagoDtoRequest request) {
        Venta venta = ventaDao.findById(ventaId).orElseThrow(() -> new RuntimeException("Venta no encontrada: " + ventaId));
        MetodoPago metodoPago = metodoPagoDao.findById(request.getMetodoPagoId())
                .orElseThrow(() -> new RuntimeException("Metodo de pago no encontrado: " + request.getMetodoPagoId()));

        Pago pago = new Pago();
        pago.setVenta(venta);
        pago.setMetodoPago(metodoPago);
        pago.setMonto(request.getMonto());
        pago.setEstado(1);
        pago.setTransaccionExterna(request.getTransaccionExterna());
        try {
            if (request.getFecha() != null) {
                pago.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(request.getFecha()));
            }
        } catch (Exception e) {
            pago.setFecha(new java.util.Date());
        }
        pago = pagoDao.save(pago);
        return mapToDto(pago);
    }
}
