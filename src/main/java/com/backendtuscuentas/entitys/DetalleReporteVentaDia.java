package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_reporte_venta_dia database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_venta_dia")
@NamedQuery(name="DetalleReporteVentaDia.findAll", query="SELECT d FROM DetalleReporteVentaDia d")
public class DetalleReporteVentaDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="drvd_id")
	private int drvdId;

	@Column(name="drvd_descuento")
	private String drvdDescuento;

	@Column(name="drvd_fecharegistro")
	private Timestamp drvdFecharegistro;

	@Column(name="drvd_identificacion")
	private String drvdIdentificacion;

	@Column(name="drvd_impuestocargo")
	private String drvdImpuestocargo;

	@Column(name="drvd_impuestoretencion")
	private String drvdImpuestoretencion;

	@Column(name="drvd_nombrecliente")
	private String drvdNombrecliente;

	@Column(name="drvd_numerocomprobantes")
	private String drvdNumerocomprobantes;

	@Column(name="drvd_registradopor")
	private String drvdRegistradopor;

	@Column(name="drvd_subtotal")
	private String drvdSubtotal;

	@Column(name="drvd_suc")
	private String drvdSuc;

	@Column(name="drvd_total")
	private String drvdTotal;

	@Column(name="drvd_valorbruto")
	private String drvdValorbruto;

	//bi-directional many-to-one association to MaestroReporteVentaClienteCarteraVencida
	@ManyToOne
	@JoinColumn(name="mvcv_id")
	private MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida;

	public DetalleReporteVentaDia() {
	}

	public int getDrvdId() {
		return this.drvdId;
	}

	public void setDrvdId(int drvdId) {
		this.drvdId = drvdId;
	}

	public String getDrvdDescuento() {
		return this.drvdDescuento;
	}

	public void setDrvdDescuento(String drvdDescuento) {
		this.drvdDescuento = drvdDescuento;
	}

	public Timestamp getDrvdFecharegistro() {
		return this.drvdFecharegistro;
	}

	public void setDrvdFecharegistro(Timestamp drvdFecharegistro) {
		this.drvdFecharegistro = drvdFecharegistro;
	}

	public String getDrvdIdentificacion() {
		return this.drvdIdentificacion;
	}

	public void setDrvdIdentificacion(String drvdIdentificacion) {
		this.drvdIdentificacion = drvdIdentificacion;
	}

	public String getDrvdImpuestocargo() {
		return this.drvdImpuestocargo;
	}

	public void setDrvdImpuestocargo(String drvdImpuestocargo) {
		this.drvdImpuestocargo = drvdImpuestocargo;
	}

	public String getDrvdImpuestoretencion() {
		return this.drvdImpuestoretencion;
	}

	public void setDrvdImpuestoretencion(String drvdImpuestoretencion) {
		this.drvdImpuestoretencion = drvdImpuestoretencion;
	}

	public String getDrvdNombrecliente() {
		return this.drvdNombrecliente;
	}

	public void setDrvdNombrecliente(String drvdNombrecliente) {
		this.drvdNombrecliente = drvdNombrecliente;
	}

	public String getDrvdNumerocomprobantes() {
		return this.drvdNumerocomprobantes;
	}

	public void setDrvdNumerocomprobantes(String drvdNumerocomprobantes) {
		this.drvdNumerocomprobantes = drvdNumerocomprobantes;
	}

	public String getDrvdRegistradopor() {
		return this.drvdRegistradopor;
	}

	public void setDrvdRegistradopor(String drvdRegistradopor) {
		this.drvdRegistradopor = drvdRegistradopor;
	}

	public String getDrvdSubtotal() {
		return this.drvdSubtotal;
	}

	public void setDrvdSubtotal(String drvdSubtotal) {
		this.drvdSubtotal = drvdSubtotal;
	}

	public String getDrvdSuc() {
		return this.drvdSuc;
	}

	public void setDrvdSuc(String drvdSuc) {
		this.drvdSuc = drvdSuc;
	}

	public String getDrvdTotal() {
		return this.drvdTotal;
	}

	public void setDrvdTotal(String drvdTotal) {
		this.drvdTotal = drvdTotal;
	}

	public String getDrvdValorbruto() {
		return this.drvdValorbruto;
	}

	public void setDrvdValorbruto(String drvdValorbruto) {
		this.drvdValorbruto = drvdValorbruto;
	}

	public MaestroReporteVentaClienteCarteraVencida getMaestroReporteVentaClienteCarteraVencida() {
		return this.maestroReporteVentaClienteCarteraVencida;
	}

	public void setMaestroReporteVentaClienteCarteraVencida(MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida) {
		this.maestroReporteVentaClienteCarteraVencida = maestroReporteVentaClienteCarteraVencida;
	}

}