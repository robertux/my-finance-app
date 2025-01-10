package com.myfinance.model;

import javax.persistence.*;

@Entity
@Table(name = "Transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cuentaId", nullable = false)
    private Long cuentaId;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "tipo", nullable = false, length = 1)
    private String tipo;

    @Column(name = "fecha", nullable = false)
    private java.sql.Timestamp fecha;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "confirmacion")
    private Long confirmacion;

    @Column(name = "etiqueta")
    private String etiqueta;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public java.sql.Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Long confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}