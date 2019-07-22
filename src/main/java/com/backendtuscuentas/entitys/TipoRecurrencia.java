package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_recurrencia database table.
 * 
 */
@Entity
@Table(name="tipo_recurrencia")
@NamedQuery(name="TipoRecurrencia.findAll", query="SELECT t FROM TipoRecurrencia t")
public class TipoRecurrencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tire_id")
	private int tireId;

	@Column(name="tire_descripcion")
	private String tireDescripcion;

	@Column(name="tire_fecharegistro")
	private Timestamp tireFecharegistro;

	@Column(name="tire_registradopor")
	private String tireRegistradopor;

	//bi-directional many-to-one association to TareaEmpresa
	@OneToMany(mappedBy="tipoRecurrencia")
	private List<TareaEmpresa> tareaEmpresas;

	public TipoRecurrencia() {
	}

	public int getTireId() {
		return this.tireId;
	}

	public void setTireId(int tireId) {
		this.tireId = tireId;
	}

	public String getTireDescripcion() {
		return this.tireDescripcion;
	}

	public void setTireDescripcion(String tireDescripcion) {
		this.tireDescripcion = tireDescripcion;
	}

	public Timestamp getTireFecharegistro() {
		return this.tireFecharegistro;
	}

	public void setTireFecharegistro(Timestamp tireFecharegistro) {
		this.tireFecharegistro = tireFecharegistro;
	}

	public String getTireRegistradopor() {
		return this.tireRegistradopor;
	}

	public void setTireRegistradopor(String tireRegistradopor) {
		this.tireRegistradopor = tireRegistradopor;
	}

	public List<TareaEmpresa> getTareaEmpresas() {
		return this.tareaEmpresas;
	}

	public void setTareaEmpresas(List<TareaEmpresa> tareaEmpresas) {
		this.tareaEmpresas = tareaEmpresas;
	}

	public TareaEmpresa addTareaEmpresa(TareaEmpresa tareaEmpresa) {
		getTareaEmpresas().add(tareaEmpresa);
		tareaEmpresa.setTipoRecurrencia(this);

		return tareaEmpresa;
	}

	public TareaEmpresa removeTareaEmpresa(TareaEmpresa tareaEmpresa) {
		getTareaEmpresas().remove(tareaEmpresa);
		tareaEmpresa.setTipoRecurrencia(null);

		return tareaEmpresa;
	}

}