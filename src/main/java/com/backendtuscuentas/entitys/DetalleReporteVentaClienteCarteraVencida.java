package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_reporte_venta_cliente_cartera_vencida database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_venta_cliente_cartera_vencida")
@NamedQuery(name="DetalleReporteVentaClienteCarteraVencida.findAll", query="SELECT d FROM DetalleReporteVentaClienteCarteraVencida d")
public class DetalleReporteVentaClienteCarteraVencida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dvcv_id")
	private int dvcvId;

	@Column(name="dvcv_deudaporcobrar")
	private String dvcvDeudaporcobrar;

	@Column(name="dvcv_diasmora")
	private String dvcvDiasmora;

	@Column(name="dvcv_fecharegistro")
	private Timestamp dvcvFecharegistro;

	@Column(name="dvcv_identificacion")
	private String dvcvIdentificacion;

	@Column(name="dvcv_nombrecliente")
	private String dvcvNombrecliente;

	@Column(name="dvcv_registradopor")
	private String dvcvRegistradopor;

	@Column(name="dvcv_saldocartera")
	private String dvcvSaldocartera;

	@Column(name="dvcv_suc")
	private String dvcvSuc;

	@Column(name="dvcv_valoranticipos")
	private String dvcvValoranticipos;

	@Column(name="dvcv_valorporvencer")
	private String dvcvValorporvencer;

	@Column(name="dvcv_valorvencido")
	private String dvcvValorvencido;

	//bi-directional many-to-one association to MaestroReporteVentaClienteCarteraVencida
	@ManyToOne
	@JoinColumn(name="mvcv_id")
	private MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida;

	public DetalleReporteVentaClienteCarteraVencida() {
	}

	public int getDvcvId() {
		return this.dvcvId;
	}

	public void setDvcvId(int dvcvId) {
		this.dvcvId = dvcvId;
	}

	public String getDvcvDeudaporcobrar() {
		return this.dvcvDeudaporcobrar;
	}

	public void setDvcvDeudaporcobrar(String dvcvDeudaporcobrar) {
		this.dvcvDeudaporcobrar = dvcvDeudaporcobrar;
	}

	public String getDvcvDiasmora() {
		return this.dvcvDiasmora;
	}

	public void setDvcvDiasmora(String dvcvDiasmora) {
		this.dvcvDiasmora = dvcvDiasmora;
	}

	public Timestamp getDvcvFecharegistro() {
		return this.dvcvFecharegistro;
	}

	public void setDvcvFecharegistro(Timestamp dvcvFecharegistro) {
		this.dvcvFecharegistro = dvcvFecharegistro;
	}

	public String getDvcvIdentificacion() {
		return this.dvcvIdentificacion;
	}

	public void setDvcvIdentificacion(String dvcvIdentificacion) {
		this.dvcvIdentificacion = dvcvIdentificacion;
	}

	public String getDvcvNombrecliente() {
		return this.dvcvNombrecliente;
	}

	public void setDvcvNombrecliente(String dvcvNombrecliente) {
		this.dvcvNombrecliente = dvcvNombrecliente;
	}

	public String getDvcvRegistradopor() {
		return this.dvcvRegistradopor;
	}

	public void setDvcvRegistradopor(String dvcvRegistradopor) {
		this.dvcvRegistradopor = dvcvRegistradopor;
	}

	public String getDvcvSaldocartera() {
		return this.dvcvSaldocartera;
	}

	public void setDvcvSaldocartera(String dvcvSaldocartera) {
		this.dvcvSaldocartera = dvcvSaldocartera;
	}

	public String getDvcvSuc() {
		return this.dvcvSuc;
	}

	public void setDvcvSuc(String dvcvSuc) {
		this.dvcvSuc = dvcvSuc;
	}

	public String getDvcvValoranticipos() {
		return this.dvcvValoranticipos;
	}

	public void setDvcvValoranticipos(String dvcvValoranticipos) {
		this.dvcvValoranticipos = dvcvValoranticipos;
	}

	public String getDvcvValorporvencer() {
		return this.dvcvValorporvencer;
	}

	public void setDvcvValorporvencer(String dvcvValorporvencer) {
		this.dvcvValorporvencer = dvcvValorporvencer;
	}

	public String getDvcvValorvencido() {
		return this.dvcvValorvencido;
	}

	public void setDvcvValorvencido(String dvcvValorvencido) {
		this.dvcvValorvencido = dvcvValorvencido;
	}

	public MaestroReporteVentaClienteCarteraVencida getMaestroReporteVentaClienteCarteraVencida() {
		return this.maestroReporteVentaClienteCarteraVencida;
	}

	public void setMaestroReporteVentaClienteCarteraVencida(MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida) {
		this.maestroReporteVentaClienteCarteraVencida = maestroReporteVentaClienteCarteraVencida;
	}

}