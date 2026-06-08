package idat.pe.app_venta_service.dto;

import java.math.BigDecimal;

public class PagoDtoRequest {

    private Long metodoPagoId;
    private BigDecimal monto;
    private String fecha;
    private String transaccionExterna;

    public Long getMetodoPagoId() { return metodoPagoId; }
    public void setMetodoPagoId(Long metodoPagoId) { this.metodoPagoId = metodoPagoId; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getTransaccionExterna() { return transaccionExterna; }
    public void setTransaccionExterna(String transaccionExterna) { this.transaccionExterna = transaccionExterna; }
}
