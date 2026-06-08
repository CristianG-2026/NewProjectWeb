package idat.pe.app_carrito_service.service;

import idat.pe.app_carrito_service.dao.CarritoDao;
import idat.pe.app_carrito_service.dao.CarritoDetalleDao;
import idat.pe.app_carrito_service.dto.CarritoDetalleDtoRequest;
import idat.pe.app_carrito_service.dto.CarritoDetalleDtoResponse;
import idat.pe.app_carrito_service.dto.CarritoDtoResponse;
import idat.pe.app_carrito_service.model.Carrito;
import idat.pe.app_carrito_service.model.CarritoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoDao carritoDao;

    @Autowired
    private CarritoDetalleDao detalleDao;

    private CarritoDetalleDtoResponse convertirDetalle(CarritoDetalle d) {
        CarritoDetalleDtoResponse dto = new CarritoDetalleDtoResponse();
        dto.setIdCarritoDetalle(d.getIdCarritoDetalle());
        dto.setProductoVarianteId(d.getProductoVarianteId());
        dto.setCantidad(d.getCantidad());
        return dto;
    }

    private CarritoDtoResponse convertirCarrito(Carrito c) {
        CarritoDtoResponse dto = new CarritoDtoResponse();
        dto.setIdCarrito(c.getIdCarrito());
        dto.setClienteId(c.getClienteId());
        dto.setCreatedAt(c.getCreatedAt());
        List<CarritoDetalle> detalles = detalleDao.findByCarrito_IdCarrito(c.getIdCarrito());
        dto.setDetalles(detalles.stream().map(this::convertirDetalle).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public CarritoDtoResponse obtenerPorCliente(Long clienteId) {
        Carrito carrito = carritoDao.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado para cliente: " + clienteId));
        return convertirCarrito(carrito);
    }

    @Override
    public CarritoDtoResponse agregarProducto(Long clienteId, CarritoDetalleDtoRequest request) {
        Carrito carrito = carritoDao.findByClienteId(clienteId).orElseGet(() -> {
            Carrito nuevo = new Carrito();
            nuevo.setClienteId(clienteId);
            return carritoDao.save(nuevo);
        });

        CarritoDetalle detalle = new CarritoDetalle();
        detalle.setCarrito(carrito);
        detalle.setProductoVarianteId(request.getProductoVarianteId());
        detalle.setCantidad(request.getCantidad());
        detalleDao.save(detalle);

        return convertirCarrito(carrito);
    }

    @Override
    public void eliminarDetalle(Long detalleId) {
        detalleDao.deleteById(detalleId);
    }
}
