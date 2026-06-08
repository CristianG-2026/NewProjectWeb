package idat.pe.app_pedido_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPEDIDO_DETALLE")
    private Long idPedidoDetalle;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;

    @Column(name = "PRODUCTO_VARIANTE_ID")
    private Long productoVarianteId;

    private Integer cantidad;

    private BigDecimal precioUnitario;

    public Long getIdPedidoDetalle() { return idPedidoDetalle; }
    public void setIdPedidoDetalle(Long idPedidoDetalle) { this.idPedidoDetalle = idPedidoDetalle; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public Long getProductoVarianteId() { return productoVarianteId; }
    public void setProductoVarianteId(Long productoVarianteId) { this.productoVarianteId = productoVarianteId; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
}
