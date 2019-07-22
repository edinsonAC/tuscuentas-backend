package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the checklist_actividadempresa database table.
 * 
 */
@Entity
@Table(name="checklist_actividadempresa")
public class ChecklistActividadempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clac_id")
	private Long clacId;

	@Column(name="acte_id")
	private int acteId;

	@Column(name="clac_ayuda")
	private String clacAyuda;

	@Column(name="clac_descripcion")
	private String clacDescripcion;

	@Column(name="clac_estado")
	private byte clacEstado;

	@Column(name="clac_fecharegistro")
	private Timestamp clacFecharegistro;

	@Column(name="clac_orden")
	private String clacOrden;

	@Column(name="clac_registradopor")
	private String clacRegistradopor;

	//bi-directional many-to-one association to EjecucionTarea
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	public ChecklistActividadempresa() {
	}

	public Long getClacId() {
		return this.clacId;
	}

	public void setClacId(Long clacId) {
		this.clacId = clacId;
	}

	public int getActeId() {
		return this.acteId;
	}

	public void setActeId(int acteId) {
		this.acteId = acteId;
	}

	public String getClacAyuda() {
		return this.clacAyuda;
	}

	public void setClacAyuda(String clacAyuda) {
		this.clacAyuda = clacAyuda;
	}

	public String getClacDescripcion() {
		return this.clacDescripcion;
	}

	public void setClacDescripcion(String clacDescripcion) {
		this.clacDescripcion = clacDescripcion;
	}

	public byte getClacEstado() {
		return this.clacEstado;
	}

	public void setClacEstado(byte clacEstado) {
		this.clacEstado = clacEstado;
	}

	public Timestamp getClacFecharegistro() {
		return this.clacFecharegistro;
	}

	public void setClacFecharegistro(Timestamp clacFecharegistro) {
		this.clacFecharegistro = clacFecharegistro;
	}

	public String getClacOrden() {
		return this.clacOrden;
	}

	public void setClacOrden(String clacOrden) {
		this.clacOrden = clacOrden;
	}

	public String getClacRegistradopor() {
		return this.clacRegistradopor;
	}

	public void setClacRegistradopor(String clacRegistradopor) {
		this.clacRegistradopor = clacRegistradopor;
	}

	public EjecucionTarea getEjecucionTarea() {
		return this.ejecucionTarea;
	}

	public void setEjecucionTarea(EjecucionTarea ejecucionTarea) {
		this.ejecucionTarea = ejecucionTarea;
	}

}