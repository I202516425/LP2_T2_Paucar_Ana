package com.examenT2.lp2_t2_paucar_ana.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_orden_compra")
@DynamicInsert // si estado es null, la BD aplica el DEFAULT 'P'
public class OrdenCompraPaucarAna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false)
	private ProveedorPaucarAna proveedor;

	@Column(name = "monto")
	private BigDecimal monto;

	@Column(name = "direccion_entrega")
	private String direccionEntrega;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;

	@Column(name = "estado")
	private String estado;

	// Descripción del estado: P, C o A
	public String getEstadoDescripcion() {
		if (estado == null)
			return "Pendiente";
		switch (estado) {
		case "P":
			return "Pendiente";
		case "C":
			return "Completado";
		case "A":
			return "Anulado";
		default:
			return "Desconocido";
		}
	}

	public Integer getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}

	public ProveedorPaucarAna getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorPaucarAna proveedor) {
		this.proveedor = proveedor;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "OrdenCompraPaucarAna [nroOrden=" + nroOrden + ", proveedor=" + proveedor + ", monto=" + monto
				+ ", direccionEntrega=" + direccionEntrega + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado
				+ "]";
	}
}