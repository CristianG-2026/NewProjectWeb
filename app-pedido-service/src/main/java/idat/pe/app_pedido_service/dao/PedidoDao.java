package idat.pe.app_pedido_service.dao;

import idat.pe.app_pedido_service.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
}
