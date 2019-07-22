package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descuento_empresa database table.
 * 
 */
@Entity
@Table(name="descuento_empresa")
@NamedQuery(name="DescuentoEmpresa.findAll", query="SELECT d FROM DescuentoEmpresa d")
public class DescuentoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="deem_id")
	private int deemId;

	@Column(name="deem_contador")
	private byte deemContador;

	@Column(name="deem_fechafin")
	private String deemFechafin;

	@Column(name="deem_fechaini")
	private String deemFechaini;

	@Column(name="deem_fecharegistro")
	private Timestamp deemFecharegistro;

	@Column(name="deem_porcentaje")
	private int deemPorcentaje;

	@Column(name="deem_registradopor")
	private String deemRegistradopor;

	@Column(name="empr_id")
	private int emprId;

	public DescuentoEmpresa() {
	}

	public int getDeemId() {
		return this.deemId;
	}

	public void setDeemId(int deemId) {
		this.deemId = deemId;
	}

	public byte getDeemContador() {
		return this.deemContador;
	}

	public void setDeemContador(byte deemContador) {
		this.deemContador = deemContador;
	}

	public String getDeemFechafin() {
		return this.deemFechafin;
	}

	public void setDeemFechafin(String deemFechafin) {
		this.deemFechafin = deemFechafin;
	}

	public String getDeemFechaini() {
		return this.deemFechaini;
	}

	public void setDeemFechaini(String deemFechaini) {
		this.deemFechaini = deemFechaini;
	}

	public Timestamp getDeemFecharegistro() {
		return this.deemFecharegistro;
	}

	public void setDeemFecharegistro(Timestamp deemFecharegistro) {
		this.deemFecharegistro = deemFecharegistro;
	}

	public int getDeemPorcentaje() {
		return this.deemPorcentaje;
	}

	public void setDeemPorcentaje(int deemPorcentaje) {
		this.deemPorcentaje = deemPorcentaje;
	}

	public String getDeemRegistradopor() {
		return this.deemRegistradopor;
	}

	public void setDeemRegistradopor(String deemRegistradopor) {
		this.deemRegistradopor = deemRegistradopor;
	}

	public int getEmprId() {
		return this.emprId;
	}

	public void setEmprId(int emprId) {
		this.emprId = emprId;
	}

}