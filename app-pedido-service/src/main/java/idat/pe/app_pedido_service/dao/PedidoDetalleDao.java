package idat.pe.app_pedido_service.dao;

import idat.pe.app_pedido_service.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoDetalleDao extends JpaRepository<PedidoDetalle, Long> {
    List<PedidoDetalle> findByPedido_IdPedido(Long pedidoId);
}
