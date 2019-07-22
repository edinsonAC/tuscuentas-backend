package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the calendario_tributario database table.
 * 
 */
@Entity
@Table(name="calendario_tributario")
@NamedQuery(name="CalendarioTributario.findAll", query="SELECT c FROM CalendarioTributario c")
public class CalendarioTributario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="catr_id")
	private int catrId;

	@Column(name="catr_diasantes")
	private String catrDiasantes;

	@Column(name="catr_estado")
	private byte catrEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="catr_fecha")
	private Date catrFecha;

	@Column(name="catr_fechalanzar")
	private String catrFechalanzar;

	@Column(name="catr_fecharegistro")
	private Timestamp catrFecharegistro;

	@Column(name="catr_nacional")
	private String catrNacional;

	@Column(name="catr_registradopor")
	private String catrRegistradopor;

	@Column(name="catr_ultimodigitonit")
	private String catrUltimodigitonit;

	@Column(name="muni_id")
	private int muniId;

	@Column(name="tapr_id")
	private int taprId;

	public CalendarioTributario() {
	}

	public int getCatrId() {
		return this.catrId;
	}

	public void setCatrId(int catrId) {
		this.catrId = catrId;
	}

	public String getCatrDiasantes() {
		return this.catrDiasantes;
	}

	public void setCatrDiasantes(String catrDiasantes) {
		this.catrDiasantes = catrDiasantes;
	}

	public byte getCatrEstado() {
		return this.catrEstado;
	}

	public void setCatrEstado(byte catrEstado) {
		this.catrEstado = catrEstado;
	}

	public Date getCatrFecha() {
		return this.catrFecha;
	}

	public void setCatrFecha(Date catrFecha) {
		this.catrFecha = catrFecha;
	}

	public String getCatrFechalanzar() {
		return this.catrFechalanzar;
	}

	public void setCatrFechalanzar(String catrFechalanzar) {
		this.catrFechalanzar = catrFechalanzar;
	}

	public Timestamp getCatrFecharegistro() {
		return this.catrFecharegistro;
	}

	public void setCatrFecharegistro(Timestamp catrFecharegistro) {
		this.catrFecharegistro = catrFecharegistro;
	}

	public String getCatrNacional() {
		return this.catrNacional;
	}

	public void setCatrNacional(String catrNacional) {
		this.catrNacional = catrNacional;
	}

	public String getCatrRegistradopor() {
		return this.catrRegistradopor;
	}

	public void setCatrRegistradopor(String catrRegistradopor) {
		this.catrRegistradopor = catrRegistradopor;
	}

	public String getCatrUltimodigitonit() {
		return this.catrUltimodigitonit;
	}

	public void setCatrUltimodigitonit(String catrUltimodigitonit) {
		this.catrUltimodigitonit = catrUltimodigitonit;
	}

	public int getMuniId() {
		return this.muniId;
	}

	public void setMuniId(int muniId) {
		this.muniId = muniId;
	}

	public int getTaprId() {
		return this.taprId;
	}

	public void setTaprId(int taprId) {
		this.taprId = taprId;
	}

}