package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_reporte_cartera_vencida database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_cartera_vencida")
@NamedQuery(name="DetalleReporteCarteraVencida.findAll", query="SELECT d FROM DetalleReporteCarteraVencida d")
public class DetalleReporteCarteraVencida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="drcv_id")
	private int drcvId;

	@Column(name="drcv_deudaporcobrar")
	private String drcvDeudaporcobrar;

	@Column(name="drcv_diasmora")
	private String drcvDiasmora;

	@Column(name="drcv_fecharegistro")
	private Timestamp drcvFecharegistro;

	@Column(name="drcv_identificacion")
	private String drcvIdentificacion;

	@Column(name="drcv_nombrecliente")
	private String drcvNombrecliente;

	@Column(name="drcv_registradopor")
	private String drcvRegistradopor;

	@Column(name="drcv_saldocartera")
	private String drcvSaldocartera;

	@Column(name="drcv_suc")
	private String drcvSuc;

	@Column(name="drcv_valoranticipos")
	private String drcvValoranticipos;

	@Column(name="drcv_valorporvencer")
	private String drcvValorporvencer;

	@Column(name="drcv_valorvencido")
	private String drcvValorvencido;

	//bi-directional many-to-one association to MaestroReporteCarteraVencida
	@ManyToOne
	@JoinColumn(name="mrcv_id")
	private MaestroReporteCarteraVencida maestroReporteCarteraVencida;

	public DetalleReporteCarteraVencida() {
	}

	public int getDrcvId() {
		return this.drcvId;
	}

	public void setDrcvId(int drcvId) {
		this.drcvId = drcvId;
	}

	public String getDrcvDeudaporcobrar() {
		return this.drcvDeudaporcobrar;
	}

	public void setDrcvDeudaporcobrar(String drcvDeudaporcobrar) {
		this.drcvDeudaporcobrar = drcvDeudaporcobrar;
	}

	public String getDrcvDiasmora() {
		return this.drcvDiasmora;
	}

	public void setDrcvDiasmora(String drcvDiasmora) {
		this.drcvDiasmora = drcvDiasmora;
	}

	public Timestamp getDrcvFecharegistro() {
		return this.drcvFecharegistro;
	}

	public void setDrcvFecharegistro(Timestamp drcvFecharegistro) {
		this.drcvFecharegistro = drcvFecharegistro;
	}

	public String getDrcvIdentificacion() {
		return this.drcvIdentificacion;
	}

	public void setDrcvIdentificacion(String drcvIdentificacion) {
		this.drcvIdentificacion = drcvIdentificacion;
	}

	public String getDrcvNombrecliente() {
		return this.drcvNombrecliente;
	}

	public void setDrcvNombrecliente(String drcvNombrecliente) {
		this.drcvNombrecliente = drcvNombrecliente;
	}

	public String getDrcvRegistradopor() {
		return this.drcvRegistradopor;
	}

	public void setDrcvRegistradopor(String drcvRegistradopor) {
		this.drcvRegistradopor = drcvRegistradopor;
	}

	public String getDrcvSaldocartera() {
		return this.drcvSaldocartera;
	}

	public void setDrcvSaldocartera(String drcvSaldocartera) {
		this.drcvSaldocartera = drcvSaldocartera;
	}

	public String getDrcvSuc() {
		return this.drcvSuc;
	}

	public void setDrcvSuc(String drcvSuc) {
		this.drcvSuc = drcvSuc;
	}

	public String getDrcvValoranticipos() {
		return this.drcvValoranticipos;
	}

	public void setDrcvValoranticipos(String drcvValoranticipos) {
		this.drcvValoranticipos = drcvValoranticipos;
	}

	public String getDrcvValorporvencer() {
		return this.drcvValorporvencer;
	}

	public void setDrcvValorporvencer(String drcvValorporvencer) {
		this.drcvValorporvencer = drcvValorporvencer;
	}

	public String getDrcvValorvencido() {
		return this.drcvValorvencido;
	}

	public void setDrcvValorvencido(String drcvValorvencido) {
		this.drcvValorvencido = drcvValorvencido;
	}

	public MaestroReporteCarteraVencida getMaestroReporteCarteraVencida() {
		return this.maestroReporteCarteraVencida;
	}

	public void setMaestroReporteCarteraVencida(MaestroReporteCarteraVencida maestroReporteCarteraVencida) {
		this.maestroReporteCarteraVencida = maestroReporteCarteraVencida;
	}

}