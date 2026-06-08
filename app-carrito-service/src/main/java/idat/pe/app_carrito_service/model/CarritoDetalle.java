package idat.pe.app_carrito_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCARRITO_DETALLE")
    private Long idCarritoDetalle;

    @ManyToOne
    @JoinColumn(name = "CARRITO_ID")
    private Carrito carrito;

    @Column(name = "PRODUCTO_VARIANTE_ID")
    private Long productoVarianteId;

    private Integer cantidad;

    public Long getIdCarritoDetalle() { return idCarritoDetalle; }
    public void setIdCarritoDetalle(Long idCarritoDetalle) { this.idCarritoDetalle = idCarritoDetalle; }
    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }
    public Long getProductoVarianteId() { return productoVarianteId; }
    public void setProductoVarianteId(Long productoVarianteId) { this.productoVarianteId = productoVarianteId; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
