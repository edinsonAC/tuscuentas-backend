package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the documentacion database table.
 * 
 */
@Entity
@NamedQuery(name="Documentacion.findAll", query="SELECT d FROM Documentacion d")
public class Documentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="docu_id")
	private int docuId;

	@Column(name="docu_descripcion")
	private String docuDescripcion;

	@Column(name="docu_fecharegistro")
	private Timestamp docuFecharegistro;

	@Column(name="docu_registradopor")
	private String docuRegistradopor;

	//bi-directional many-to-one association to TareapreActividadpre
	@ManyToOne
	@JoinColumn(name="tpap_id")
	private TareapreActividadpre tareapreActividadpre;

	public Documentacion() {
	}

	public int getDocuId() {
		return this.docuId;
	}

	public void setDocuId(int docuId) {
		this.docuId = docuId;
	}

	public String getDocuDescripcion() {
		return this.docuDescripcion;
	}

	public void setDocuDescripcion(String docuDescripcion) {
		this.docuDescripcion = docuDescripcion;
	}

	public Timestamp getDocuFecharegistro() {
		return this.docuFecharegistro;
	}

	public void setDocuFecharegistro(Timestamp docuFecharegistro) {
		this.docuFecharegistro = docuFecharegistro;
	}

	public String getDocuRegistradopor() {
		return this.docuRegistradopor;
	}

	public void setDocuRegistradopor(String docuRegistradopor) {
		this.docuRegistradopor = docuRegistradopor;
	}

	public TareapreActividadpre getTareapreActividadpre() {
		return this.tareapreActividadpre;
	}

	public void setTareapreActividadpre(TareapreActividadpre tareapreActividadpre) {
		this.tareapreActividadpre = tareapreActividadpre;
	}

}