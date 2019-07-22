package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the otros_pagos database table.
 * 
 */
@Entity
@Table(name="otros_pagos")
@NamedQuery(name="OtrosPago.findAll", query="SELECT o FROM OtrosPago o")
public class OtrosPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="otpa_id")
	private int otpaId;

	@Column(name="otpa_descripcion")
	private String otpaDescripcion;

	@Column(name="otpa_fecharegistro")
	private Timestamp otpaFecharegistro;

	@Column(name="otpa_porcentajecontador")
	private String otpaPorcentajecontador;

	@Column(name="otpa_registradopor")
	private String otpaRegistradopor;

	@Column(name="otpa_valorpagado")
	private String otpaValorpagado;

	//bi-directional many-to-one association to ContratoTuscuenta
	@ManyToOne
	@JoinColumn(name="cotu_id")
	private ContratoTuscuenta contratoTuscuenta;

	public OtrosPago() {
	}

	public int getOtpaId() {
		return this.otpaId;
	}

	public void setOtpaId(int otpaId) {
		this.otpaId = otpaId;
	}

	public String getOtpaDescripcion() {
		return this.otpaDescripcion;
	}

	public void setOtpaDescripcion(String otpaDescripcion) {
		this.otpaDescripcion = otpaDescripcion;
	}

	public Timestamp getOtpaFecharegistro() {
		return this.otpaFecharegistro;
	}

	public void setOtpaFecharegistro(Timestamp otpaFecharegistro) {
		this.otpaFecharegistro = otpaFecharegistro;
	}

	public String getOtpaPorcentajecontador() {
		return this.otpaPorcentajecontador;
	}

	public void setOtpaPorcentajecontador(String otpaPorcentajecontador) {
		this.otpaPorcentajecontador = otpaPorcentajecontador;
	}

	public String getOtpaRegistradopor() {
		return this.otpaRegistradopor;
	}

	public void setOtpaRegistradopor(String otpaRegistradopor) {
		this.otpaRegistradopor = otpaRegistradopor;
	}

	public String getOtpaValorpagado() {
		return this.otpaValorpagado;
	}

	public void setOtpaValorpagado(String otpaValorpagado) {
		this.otpaValorpagado = otpaValorpagado;
	}

	public ContratoTuscuenta getContratoTuscuenta() {
		return this.contratoTuscuenta;
	}

	public void setContratoTuscuenta(ContratoTuscuenta contratoTuscuenta) {
		this.contratoTuscuenta = contratoTuscuenta;
	}

}