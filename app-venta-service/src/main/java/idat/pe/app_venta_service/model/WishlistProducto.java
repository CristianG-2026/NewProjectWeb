package idat.pe.app_venta_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist_producto")
public class WishlistProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDWISHLIST_PRODUCTO")
    private Long idWishlistProducto;

    @ManyToOne
    @JoinColumn(name = "WISHLIST_ID")
    private Wishlist wishlist;

    @Column(name = "PRODUCTO_VARIANTE_ID")
    private Long productoVarianteId;

    public Long getIdWishlistProducto() { return idWishlistProducto; }
    public void setIdWishlistProducto(Long idWishlistProducto) { this.idWishlistProducto = idWishlistProducto; }
    public Wishlist getWishlist() { return wishlist; }
    public void setWishlist(Wishlist wishlist) { this.wishlist = wishlist; }
    public Long getProductoVarianteId() { return productoVarianteId; }
    public void setProductoVarianteId(Long productoVarianteId) { this.productoVarianteId = productoVarianteId; }
}
