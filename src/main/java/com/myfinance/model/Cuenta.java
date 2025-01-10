public class Cuenta {
    private Long id;
    private Integer numero;
    private Character estado;
    private BigDecimal saldo;
    private Long usuarioId;

    public Cuenta() {
    }

    public Cuenta(Long id, Integer numero, Character estado, BigDecimal saldo, Long usuarioId) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.saldo = saldo;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}