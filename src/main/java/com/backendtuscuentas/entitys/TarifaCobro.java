package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tarifa_cobro database table.
 * 
 */
@Entity
@Table(name="tarifa_cobro")
@NamedQuery(name="TarifaCobro.findAll", query="SELECT t FROM TarifaCobro t")
public class TarifaCobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="taco_id")
	private int tacoId;

	@Column(name="taco_fecharegistro")
	private Timestamp tacoFecharegistro;

	@Column(name="taco_registradopor")
	private String tacoRegistradopor;

	@Column(name="taco_valor")
	private String tacoValor;

	public TarifaCobro() {
	}

	public int getTacoId() {
		return this.tacoId;
	}

	public void setTacoId(int tacoId) {
		this.tacoId = tacoId;
	}

	public Timestamp getTacoFecharegistro() {
		return this.tacoFecharegistro;
	}

	public void setTacoFecharegistro(Timestamp tacoFecharegistro) {
		this.tacoFecharegistro = tacoFecharegistro;
	}

	public String getTacoRegistradopor() {
		return this.tacoRegistradopor;
	}

	public void setTacoRegistradopor(String tacoRegistradopor) {
		this.tacoRegistradopor = tacoRegistradopor;
	}

	public String getTacoValor() {
		return this.tacoValor;
	}

	public void setTacoValor(String tacoValor) {
		this.tacoValor = tacoValor;
	}

}