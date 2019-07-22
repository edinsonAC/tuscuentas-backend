package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cargo_empresa database table.
 * 
 */
@Entity
@Table(name="cargo_empresa")
@NamedQuery(name="CargoEmpresa.findAll", query="SELECT c FROM CargoEmpresa c")
public class CargoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="caem_id")
	private int caemId;

	@Column(name="caem_descripcion")
	private String caemDescripcion;

	@Column(name="caem_fecharegistro")
	private Timestamp caemFecharegistro;

	@Column(name="caem_registradopor")
	private String caemRegistradopor;

	//bi-directional many-to-one association to Cargoporcargo
	@OneToMany(mappedBy="cargoEmpresa1")
	private List<Cargoporcargo> cargoporcargos1;

	//bi-directional many-to-one association to Cargoporcargo
	@OneToMany(mappedBy="cargoEmpresa2")
	private List<Cargoporcargo> cargoporcargos2;

	//bi-directional many-to-one association to EjecucionTarea
	@OneToMany(mappedBy="cargoEmpresa")
	private List<EjecucionTarea> ejecucionTareas;

	//bi-directional many-to-one association to TareapreActividadpre
	@OneToMany(mappedBy="cargoEmpresa")
	private List<TareapreActividadpre> tareapreActividadpres;

	public CargoEmpresa() {
	}

	public int getCaemId() {
		return this.caemId;
	}

	public void setCaemId(int caemId) {
		this.caemId = caemId;
	}

	public String getCaemDescripcion() {
		return this.caemDescripcion;
	}

	public void setCaemDescripcion(String caemDescripcion) {
		this.caemDescripcion = caemDescripcion;
	}

	public Timestamp getCaemFecharegistro() {
		return this.caemFecharegistro;
	}

	public void setCaemFecharegistro(Timestamp caemFecharegistro) {
		this.caemFecharegistro = caemFecharegistro;
	}

	public String getCaemRegistradopor() {
		return this.caemRegistradopor;
	}

	public void setCaemRegistradopor(String caemRegistradopor) {
		this.caemRegistradopor = caemRegistradopor;
	}

	public List<Cargoporcargo> getCargoporcargos1() {
		return this.cargoporcargos1;
	}

	public void setCargoporcargos1(List<Cargoporcargo> cargoporcargos1) {
		this.cargoporcargos1 = cargoporcargos1;
	}

	public Cargoporcargo addCargoporcargos1(Cargoporcargo cargoporcargos1) {
		getCargoporcargos1().add(cargoporcargos1);
		cargoporcargos1.setCargoEmpresa1(this);

		return cargoporcargos1;
	}

	public Cargoporcargo removeCargoporcargos1(Cargoporcargo cargoporcargos1) {
		getCargoporcargos1().remove(cargoporcargos1);
		cargoporcargos1.setCargoEmpresa1(null);

		return cargoporcargos1;
	}

	public List<Cargoporcargo> getCargoporcargos2() {
		return this.cargoporcargos2;
	}

	public void setCargoporcargos2(List<Cargoporcargo> cargoporcargos2) {
		this.cargoporcargos2 = cargoporcargos2;
	}

	public Cargoporcargo addCargoporcargos2(Cargoporcargo cargoporcargos2) {
		getCargoporcargos2().add(cargoporcargos2);
		cargoporcargos2.setCargoEmpresa2(this);

		return cargoporcargos2;
	}

	public Cargoporcargo removeCargoporcargos2(Cargoporcargo cargoporcargos2) {
		getCargoporcargos2().remove(cargoporcargos2);
		cargoporcargos2.setCargoEmpresa2(null);

		return cargoporcargos2;
	}

	public List<EjecucionTarea> getEjecucionTareas() {
		return this.ejecucionTareas;
	}

	public void setEjecucionTareas(List<EjecucionTarea> ejecucionTareas) {
		this.ejecucionTareas = ejecucionTareas;
	}

	public EjecucionTarea addEjecucionTarea(EjecucionTarea ejecucionTarea) {
		getEjecucionTareas().add(ejecucionTarea);
		ejecucionTarea.setCargoEmpresa(this);

		return ejecucionTarea;
	}

	public EjecucionTarea removeEjecucionTarea(EjecucionTarea ejecucionTarea) {
		getEjecucionTareas().remove(ejecucionTarea);
		ejecucionTarea.setCargoEmpresa(null);

		return ejecucionTarea;
	}

	public List<TareapreActividadpre> getTareapreActividadpres() {
		return this.tareapreActividadpres;
	}

	public void setTareapreActividadpres(List<TareapreActividadpre> tareapreActividadpres) {
		this.tareapreActividadpres = tareapreActividadpres;
	}

	public TareapreActividadpre addTareapreActividadpre(TareapreActividadpre tareapreActividadpre) {
		getTareapreActividadpres().add(tareapreActividadpre);
		tareapreActividadpre.setCargoEmpresa(this);

		return tareapreActividadpre;
	}

	public TareapreActividadpre removeTareapreActividadpre(TareapreActividadpre tareapreActividadpre) {
		getTareapreActividadpres().remove(tareapreActividadpre);
		tareapreActividadpre.setCargoEmpresa(null);

		return tareapreActividadpre;
	}

}