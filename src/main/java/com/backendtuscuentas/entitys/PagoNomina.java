package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pago_nomina database table.
 * 
 */
@Entity
@Table(name="pago_nomina")
@NamedQuery(name="PagoNomina.findAll", query="SELECT p FROM PagoNomina p")
public class PagoNomina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pano_id")
	private int panoId;

	@Column(name="pano_descripcion")
	private String panoDescripcion;

	@Column(name="pano_fecharegistro")
	private Timestamp panoFecharegistro;

	@Column(name="pano_registradopor")
	private String panoRegistradopor;

	//bi-directional many-to-one association to DiasPago
	@OneToMany(mappedBy="pagoNomina")
	private List<DiasPago> diasPagos;

	public PagoNomina() {
	}

	public int getPanoId() {
		return this.panoId;
	}

	public void setPanoId(int panoId) {
		this.panoId = panoId;
	}

	public String getPanoDescripcion() {
		return this.panoDescripcion;
	}

	public void setPanoDescripcion(String panoDescripcion) {
		this.panoDescripcion = panoDescripcion;
	}

	public Timestamp getPanoFecharegistro() {
		return this.panoFecharegistro;
	}

	public void setPanoFecharegistro(Timestamp panoFecharegistro) {
		this.panoFecharegistro = panoFecharegistro;
	}

	public String getPanoRegistradopor() {
		return this.panoRegistradopor;
	}

	public void setPanoRegistradopor(String panoRegistradopor) {
		this.panoRegistradopor = panoRegistradopor;
	}

	public List<DiasPago> getDiasPagos() {
		return this.diasPagos;
	}

	public void setDiasPagos(List<DiasPago> diasPagos) {
		this.diasPagos = diasPagos;
	}

	public DiasPago addDiasPago(DiasPago diasPago) {
		getDiasPagos().add(diasPago);
		diasPago.setPagoNomina(this);

		return diasPago;
	}

	public DiasPago removeDiasPago(DiasPago diasPago) {
		getDiasPagos().remove(diasPago);
		diasPago.setPagoNomina(null);

		return diasPago;
	}

}