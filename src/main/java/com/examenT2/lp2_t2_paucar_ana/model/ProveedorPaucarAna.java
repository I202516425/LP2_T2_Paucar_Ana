package com.examenT2.lp2_t2_paucar_ana.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_proveedor")
public class ProveedorPaucarAna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "ruc")
	private String ruc;

	@Column(name = "razon_social")
	private String razonSocial;

	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "pagina_web")
	private String paginaWeb;

	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private RubroPaucarAna rubro;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public RubroPaucarAna getRubro() {
		return rubro;
	}

	public void setRubro(RubroPaucarAna rubro) {
		this.rubro = rubro;
	}

	@Override
	public String toString() {
		return "ProveedorPaucarAna [idProveedor=" + idProveedor + ", ruc=" + ruc + ", razonSocial=" + razonSocial
				+ ", fechaRegistro=" + fechaRegistro + ", direccion=" + direccion + ", paginaWeb=" + paginaWeb
				+ ", rubro=" + rubro + "]";
	}
}