package idat.pe.app_auth_service.dto;
public class UsuarioRegistroDtoRequest {
    private String usuario;
    private String password;
    private Long rolId;
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }
}
