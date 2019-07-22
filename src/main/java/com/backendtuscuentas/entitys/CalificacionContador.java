package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calificacion_contador database table.
 * 
 */
@Entity
@Table(name="calificacion_contador")
@NamedQuery(name="CalificacionContador.findAll", query="SELECT c FROM CalificacionContador c")
public class CalificacionContador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="caco_id")
	private int cacoId;

	@Column(name="caco_calificacion")
	private String cacoCalificacion;

	@Column(name="caco_cantidad")
	private String cacoCantidad;

	@Column(name="caco_fecharegistro")
	private Timestamp cacoFecharegistro;

	@Column(name="caco_registradopor")
	private String cacoRegistradopor;

	@Column(name="coju_id")
	private String cojuId;

	public CalificacionContador() {
	}

	public int getCacoId() {
		return this.cacoId;
	}

	public void setCacoId(int cacoId) {
		this.cacoId = cacoId;
	}

	public String getCacoCalificacion() {
		return this.cacoCalificacion;
	}

	public void setCacoCalificacion(String cacoCalificacion) {
		this.cacoCalificacion = cacoCalificacion;
	}

	public String getCacoCantidad() {
		return this.cacoCantidad;
	}

	public void setCacoCantidad(String cacoCantidad) {
		this.cacoCantidad = cacoCantidad;
	}

	public Timestamp getCacoFecharegistro() {
		return this.cacoFecharegistro;
	}

	public void setCacoFecharegistro(Timestamp cacoFecharegistro) {
		this.cacoFecharegistro = cacoFecharegistro;
	}

	public String getCacoRegistradopor() {
		return this.cacoRegistradopor;
	}

	public void setCacoRegistradopor(String cacoRegistradopor) {
		this.cacoRegistradopor = cacoRegistradopor;
	}

	public String getCojuId() {
		return this.cojuId;
	}

	public void setCojuId(String cojuId) {
		this.cojuId = cojuId;
	}

}