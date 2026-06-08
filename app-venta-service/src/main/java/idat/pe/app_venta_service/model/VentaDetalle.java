package idat.pe.app_venta_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venta_detalle")
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENTA_DETALLE")
    private Long idVentaDetalle;

    @ManyToOne
    @JoinColumn(name = "VENTA_ID")
    private Venta venta;

    @Column(name = "PRODUCTO_VARIANTE_ID")
    private Long productoVarianteId;

    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO")
    private BigDecimal precioUnitario;

    public Long getIdVentaDetalle() { return idVentaDetalle; }
    public void setIdVentaDetalle(Long idVentaDetalle) { this.idVentaDetalle = idVentaDetalle; }
    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }
    public Long getProductoVarianteId() { return productoVarianteId; }
    public void setProductoVarianteId(Long productoVarianteId) { this.productoVarianteId = productoVarianteId; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
}
