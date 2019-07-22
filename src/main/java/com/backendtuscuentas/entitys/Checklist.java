package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the checklist database table.
 * 
 */
@Entity
@NamedQuery(name="Checklist.findAll", query="SELECT c FROM Checklist c")
public class Checklist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chec_id")
	private int checId;

	@Column(name="chec_ayuda")
	private String checAyuda;

	@Column(name="chec_descripcion")
	private String checDescripcion;

	@Column(name="chec_estado")
	private byte checEstado;

	@Column(name="chec_fecharegistro")
	private Timestamp checFecharegistro;

	@Column(name="chec_orden")
	private String checOrden;

	@Column(name="chec_registradopor")
	private String checRegistradopor;

	//bi-directional many-to-one association to TareapreActividadpre
	@ManyToOne
	@JoinColumn(name="tpap_id")
	private TareapreActividadpre tareapreActividadpre;

	public Checklist() {
	}

	public int getChecId() {
		return this.checId;
	}

	public void setChecId(int checId) {
		this.checId = checId;
	}

	public String getChecAyuda() {
		return this.checAyuda;
	}

	public void setChecAyuda(String checAyuda) {
		this.checAyuda = checAyuda;
	}

	public String getChecDescripcion() {
		return this.checDescripcion;
	}

	public void setChecDescripcion(String checDescripcion) {
		this.checDescripcion = checDescripcion;
	}

	public byte getChecEstado() {
		return this.checEstado;
	}

	public void setChecEstado(byte checEstado) {
		this.checEstado = checEstado;
	}

	public Timestamp getChecFecharegistro() {
		return this.checFecharegistro;
	}

	public void setChecFecharegistro(Timestamp checFecharegistro) {
		this.checFecharegistro = checFecharegistro;
	}

	public String getChecOrden() {
		return this.checOrden;
	}

	public void setChecOrden(String checOrden) {
		this.checOrden = checOrden;
	}

	public String getChecRegistradopor() {
		return this.checRegistradopor;
	}

	public void setChecRegistradopor(String checRegistradopor) {
		this.checRegistradopor = checRegistradopor;
	}

	public TareapreActividadpre getTareapreActividadpre() {
		return this.tareapreActividadpre;
	}

	public void setTareapreActividadpre(TareapreActividadpre tareapreActividadpre) {
		this.tareapreActividadpre = tareapreActividadpre;
	}

}