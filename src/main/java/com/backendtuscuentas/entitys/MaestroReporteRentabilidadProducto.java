package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the maestro_reporte_rentabilidad_producto database table.
 * 
 */
@Entity
@Table(name="maestro_reporte_rentabilidad_producto")
@NamedQuery(name="MaestroReporteRentabilidadProducto.findAll", query="SELECT m FROM MaestroReporteRentabilidadProducto m")
public class MaestroReporteRentabilidadProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mrrp_id")
	private int mrrpId;

	@Column(name="empr_id")
	private int emprId;

	@Column(name="mrrp_fecharegistro")
	private Timestamp mrrpFecharegistro;

	@Column(name="mrrp_registradopor")
	private String mrrpRegistradopor;

	@Column(name="mrrp_rentabilidadminima")
	private int mrrpRentabilidadminima;

	@Column(name="mrrp_valorminimo")
	private int mrrpValorminimo;

	//bi-directional many-to-one association to DetalleReporteRentabilidadProducto
	@OneToMany(mappedBy="maestroReporteRentabilidadProducto")
	private List<DetalleReporteRentabilidadProducto> detalleReporteRentabilidadProductos;

	public MaestroReporteRentabilidadProducto() {
	}

	public int getMrrpId() {
		return this.mrrpId;
	}

	public void setMrrpId(int mrrpId) {
		this.mrrpId = mrrpId;
	}

	public int getEmprId() {
		return this.emprId;
	}

	public void setEmprId(int emprId) {
		this.emprId = emprId;
	}

	public Timestamp getMrrpFecharegistro() {
		return this.mrrpFecharegistro;
	}

	public void setMrrpFecharegistro(Timestamp mrrpFecharegistro) {
		this.mrrpFecharegistro = mrrpFecharegistro;
	}

	public String getMrrpRegistradopor() {
		return this.mrrpRegistradopor;
	}

	public void setMrrpRegistradopor(String mrrpRegistradopor) {
		this.mrrpRegistradopor = mrrpRegistradopor;
	}

	public int getMrrpRentabilidadminima() {
		return this.mrrpRentabilidadminima;
	}

	public void setMrrpRentabilidadminima(int mrrpRentabilidadminima) {
		this.mrrpRentabilidadminima = mrrpRentabilidadminima;
	}

	public int getMrrpValorminimo() {
		return this.mrrpValorminimo;
	}

	public void setMrrpValorminimo(int mrrpValorminimo) {
		this.mrrpValorminimo = mrrpValorminimo;
	}

	public List<DetalleReporteRentabilidadProducto> getDetalleReporteRentabilidadProductos() {
		return this.detalleReporteRentabilidadProductos;
	}

	public void setDetalleReporteRentabilidadProductos(List<DetalleReporteRentabilidadProducto> detalleReporteRentabilidadProductos) {
		this.detalleReporteRentabilidadProductos = detalleReporteRentabilidadProductos;
	}

	public DetalleReporteRentabilidadProducto addDetalleReporteRentabilidadProducto(DetalleReporteRentabilidadProducto detalleReporteRentabilidadProducto) {
		getDetalleReporteRentabilidadProductos().add(detalleReporteRentabilidadProducto);
		detalleReporteRentabilidadProducto.setMaestroReporteRentabilidadProducto(this);

		return detalleReporteRentabilidadProducto;
	}

	public DetalleReporteRentabilidadProducto removeDetalleReporteRentabilidadProducto(DetalleReporteRentabilidadProducto detalleReporteRentabilidadProducto) {
		getDetalleReporteRentabilidadProductos().remove(detalleReporteRentabilidadProducto);
		detalleReporteRentabilidadProducto.setMaestroReporteRentabilidadProducto(null);

		return detalleReporteRentabilidadProducto;
	}

}