package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the contrato_tuscuentas database table.
 * 
 */
@Entity
@Table(name="contrato_tuscuentas")
@NamedQuery(name="ContratoTuscuenta.findAll", query="SELECT c FROM ContratoTuscuenta c")
public class ContratoTuscuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cotu_id")
	private int cotuId;

	@Column(name="coju_id")
	private int cojuId;

	@Column(name="cotu_activo")
	private byte cotuActivo;

	@Column(name="cotu_documento")
	private String cotuDocumento;

	@Column(name="cotu_fechafinal")
	private String cotuFechafinal;

	@Column(name="cotu_fechainicio")
	private String cotuFechainicio;

	@Column(name="cotu_fecharegistro")
	private Timestamp cotuFecharegistro;

	@Column(name="cotu_firmacontador")
	private byte cotuFirmacontador;

	@Column(name="cotu_firmaempresa")
	private byte cotuFirmaempresa;

	@Column(name="cotu_porcentajecontador")
	private String cotuPorcentajecontador;

	@Column(name="cotu_registradopor")
	private String cotuRegistradopor;

	@Column(name="cotu_tipocontrato")
	private byte cotuTipocontrato;

	@Column(name="cotu_valorfijomensual")
	private String cotuValorfijomensual;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	//bi-directional many-to-one association to OtrosPago
	@OneToMany(mappedBy="contratoTuscuenta")
	private List<OtrosPago> otrosPagos;

	public ContratoTuscuenta() {
	}

	public int getCotuId() {
		return this.cotuId;
	}

	public void setCotuId(int cotuId) {
		this.cotuId = cotuId;
	}

	public int getCojuId() {
		return this.cojuId;
	}

	public void setCojuId(int cojuId) {
		this.cojuId = cojuId;
	}

	public byte getCotuActivo() {
		return this.cotuActivo;
	}

	public void setCotuActivo(byte cotuActivo) {
		this.cotuActivo = cotuActivo;
	}

	public String getCotuDocumento() {
		return this.cotuDocumento;
	}

	public void setCotuDocumento(String cotuDocumento) {
		this.cotuDocumento = cotuDocumento;
	}

	public String getCotuFechafinal() {
		return this.cotuFechafinal;
	}

	public void setCotuFechafinal(String cotuFechafinal) {
		this.cotuFechafinal = cotuFechafinal;
	}

	public String getCotuFechainicio() {
		return this.cotuFechainicio;
	}

	public void setCotuFechainicio(String cotuFechainicio) {
		this.cotuFechainicio = cotuFechainicio;
	}

	public Timestamp getCotuFecharegistro() {
		return this.cotuFecharegistro;
	}

	public void setCotuFecharegistro(Timestamp cotuFecharegistro) {
		this.cotuFecharegistro = cotuFecharegistro;
	}

	public byte getCotuFirmacontador() {
		return this.cotuFirmacontador;
	}

	public void setCotuFirmacontador(byte cotuFirmacontador) {
		this.cotuFirmacontador = cotuFirmacontador;
	}

	public byte getCotuFirmaempresa() {
		return this.cotuFirmaempresa;
	}

	public void setCotuFirmaempresa(byte cotuFirmaempresa) {
		this.cotuFirmaempresa = cotuFirmaempresa;
	}

	public String getCotuPorcentajecontador() {
		return this.cotuPorcentajecontador;
	}

	public void setCotuPorcentajecontador(String cotuPorcentajecontador) {
		this.cotuPorcentajecontador = cotuPorcentajecontador;
	}

	public String getCotuRegistradopor() {
		return this.cotuRegistradopor;
	}

	public void setCotuRegistradopor(String cotuRegistradopor) {
		this.cotuRegistradopor = cotuRegistradopor;
	}

	public byte getCotuTipocontrato() {
		return this.cotuTipocontrato;
	}

	public void setCotuTipocontrato(byte cotuTipocontrato) {
		this.cotuTipocontrato = cotuTipocontrato;
	}

	public String getCotuValorfijomensual() {
		return this.cotuValorfijomensual;
	}

	public void setCotuValorfijomensual(String cotuValorfijomensual) {
		this.cotuValorfijomensual = cotuValorfijomensual;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<OtrosPago> getOtrosPagos() {
		return this.otrosPagos;
	}

	public void setOtrosPagos(List<OtrosPago> otrosPagos) {
		this.otrosPagos = otrosPagos;
	}

	public OtrosPago addOtrosPago(OtrosPago otrosPago) {
		getOtrosPagos().add(otrosPago);
		otrosPago.setContratoTuscuenta(this);

		return otrosPago;
	}

	public OtrosPago removeOtrosPago(OtrosPago otrosPago) {
		getOtrosPagos().remove(otrosPago);
		otrosPago.setContratoTuscuenta(null);

		return otrosPago;
	}

}