package idat.pe.app_venta_service.dto;

import java.util.Date;
import java.util.List;

public class WishlistDtoResponse {

    private Long idWishlist;
    private Long clienteId;
    private String clienteNombre;
    private String nombre;
    private List<String> productos;
    private Date createdAt;

    public Long getIdWishlist() { return idWishlist; }
    public void setIdWishlist(Long idWishlist) { this.idWishlist = idWishlist; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<String> getProductos() { return productos; }
    public void setProductos(List<String> productos) { this.productos = productos; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
