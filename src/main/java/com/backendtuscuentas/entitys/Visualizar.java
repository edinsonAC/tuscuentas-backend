package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the visualizar database table.
 * 
 */
@Entity
@NamedQuery(name="Visualizar.findAll", query="SELECT v FROM Visualizar v")
public class Visualizar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="visu_id")
	private int visuId;

	@Column(name="acte_id")
	private int acteId;

	@Column(name="visu_fecharegistro")
	private Timestamp visuFecharegistro;

	@Column(name="visu_permisos")
	private int visuPermisos;

	@Column(name="visu_registradopor")
	private String visuRegistradopor;

	@Column(name="visu_usuarioresponsable")
	private int visuUsuarioresponsable;

	//bi-directional many-to-one association to TareaEmpresa
	@ManyToOne
	@JoinColumn(name="taem_id")
	private TareaEmpresa tareaEmpresa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	//bi-directional many-to-one association to EjecucionTarea
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	public Visualizar() {
	}

	public int getVisuId() {
		return this.visuId;
	}

	public void setVisuId(int visuId) {
		this.visuId = visuId;
	}

	public int getActeId() {
		return this.acteId;
	}

	public void setActeId(int acteId) {
		this.acteId = acteId;
	}

	public Timestamp getVisuFecharegistro() {
		return this.visuFecharegistro;
	}

	public void setVisuFecharegistro(Timestamp visuFecharegistro) {
		this.visuFecharegistro = visuFecharegistro;
	}

	public int getVisuPermisos() {
		return this.visuPermisos;
	}

	public void setVisuPermisos(int visuPermisos) {
		this.visuPermisos = visuPermisos;
	}

	public String getVisuRegistradopor() {
		return this.visuRegistradopor;
	}

	public void setVisuRegistradopor(String visuRegistradopor) {
		this.visuRegistradopor = visuRegistradopor;
	}

	public int getVisuUsuarioresponsable() {
		return this.visuUsuarioresponsable;
	}

	public void setVisuUsuarioresponsable(int visuUsuarioresponsable) {
		this.visuUsuarioresponsable = visuUsuarioresponsable;
	}

	public TareaEmpresa getTareaEmpresa() {
		return this.tareaEmpresa;
	}

	public void setTareaEmpresa(TareaEmpresa tareaEmpresa) {
		this.tareaEmpresa = tareaEmpresa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EjecucionTarea getEjecucionTarea() {
		return this.ejecucionTarea;
	}

	public void setEjecucionTarea(EjecucionTarea ejecucionTarea) {
		this.ejecucionTarea = ejecucionTarea;
	}

}