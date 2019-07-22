package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the documentacion_actividadempresa database table.
 * 
 */
@Entity
@Table(name="documentacion_actividadempresa")
@NamedQuery(name="DocumentacionActividadempresa.findAll", query="SELECT d FROM DocumentacionActividadempresa d")
public class DocumentacionActividadempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="doae_id")
	private int doaeId;

	@Column(name="acte_id")
	private int acteId;

	@Column(name="doae_descripcion")
	private String doaeDescripcion;

	@Column(name="doae_estado")
	private byte doaeEstado;

	@Column(name="doae_fecharegistro")
	private Timestamp doaeFecharegistro;

	@Column(name="doae_registradopor")
	private String doaeRegistradopor;

	public DocumentacionActividadempresa() {
	}

	public int getDoaeId() {
		return this.doaeId;
	}

	public void setDoaeId(int doaeId) {
		this.doaeId = doaeId;
	}

	public int getActeId() {
		return this.acteId;
	}

	public void setActeId(int acteId) {
		this.acteId = acteId;
	}

	public String getDoaeDescripcion() {
		return this.doaeDescripcion;
	}

	public void setDoaeDescripcion(String doaeDescripcion) {
		this.doaeDescripcion = doaeDescripcion;
	}

	public byte getDoaeEstado() {
		return this.doaeEstado;
	}

	public void setDoaeEstado(byte doaeEstado) {
		this.doaeEstado = doaeEstado;
	}

	public Timestamp getDoaeFecharegistro() {
		return this.doaeFecharegistro;
	}

	public void setDoaeFecharegistro(Timestamp doaeFecharegistro) {
		this.doaeFecharegistro = doaeFecharegistro;
	}

	public String getDoaeRegistradopor() {
		return this.doaeRegistradopor;
	}

	public void setDoaeRegistradopor(String doaeRegistradopor) {
		this.doaeRegistradopor = doaeRegistradopor;
	}

}