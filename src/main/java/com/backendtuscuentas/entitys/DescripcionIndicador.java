package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descripcion_indicador database table.
 * 
 */
@Entity
@Table(name="descripcion_indicador")
@NamedQuery(name="DescripcionIndicador.findAll", query="SELECT d FROM DescripcionIndicador d")
public class DescripcionIndicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dein_id")
	private int deinId;

	@Column(name="dein_descripcion")
	private String deinDescripcion;

	@Column(name="dein_nombretarea")
	private String deinNombretarea;

	@Column(name="ejta_fecharegistro")
	private Timestamp ejtaFecharegistro;

	@Column(name="ejta_registradopor")
	private String ejtaRegistradopor;

	//bi-directional many-to-one association to EjecucionTarea
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	public DescripcionIndicador() {
	}

	public int getDeinId() {
		return this.deinId;
	}

	public void setDeinId(int deinId) {
		this.deinId = deinId;
	}

	public String getDeinDescripcion() {
		return this.deinDescripcion;
	}

	public void setDeinDescripcion(String deinDescripcion) {
		this.deinDescripcion = deinDescripcion;
	}

	public String getDeinNombretarea() {
		return this.deinNombretarea;
	}

	public void setDeinNombretarea(String deinNombretarea) {
		this.deinNombretarea = deinNombretarea;
	}

	public Timestamp getEjtaFecharegistro() {
		return this.ejtaFecharegistro;
	}

	public void setEjtaFecharegistro(Timestamp ejtaFecharegistro) {
		this.ejtaFecharegistro = ejtaFecharegistro;
	}

	public String getEjtaRegistradopor() {
		return this.ejtaRegistradopor;
	}

	public void setEjtaRegistradopor(String ejtaRegistradopor) {
		this.ejtaRegistradopor = ejtaRegistradopor;
	}

	public EjecucionTarea getEjecucionTarea() {
		return this.ejecucionTarea;
	}

	public void setEjecucionTarea(EjecucionTarea ejecucionTarea) {
		this.ejecucionTarea = ejecucionTarea;
	}

}