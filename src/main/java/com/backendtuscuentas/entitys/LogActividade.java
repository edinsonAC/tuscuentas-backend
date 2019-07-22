package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

/**
 * The persistent class for the log_actividades database table.
 * 
 */
@Entity
@Table(name = "log_actividades")
public class LogActividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "load_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loadId;

	@Column(name = "acte_id")
	private Long acteId;

	@Column(name = "alte_id")
	private Long alteId;

	@Column(name = "cota_id")
	private Long cotaId;

	@Column(name = "cotu_id")
	private Long cotuId;

	@Column(name = "empr_id")
	private Long emprId;

	@Column(name = "loac_listado")
	private byte loacListado;

	@Column(name = "load_fecharegistro")
	private Timestamp loadFecharegistro;

	@Column(name = "load_observacion")
	private String loadObservacion;

	@Column(name = "load_registradopor")
	private String loadRegistradopor;

	// bi-directional many-to-one association to EjecucionTarea
	@ManyToOne
	@JoinColumn(name = "ejta_id")
	private EjecucionTarea ejecucionTarea;

	// bi-directional many-to-one association to TipoLog
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tilo_id")
	private TipoLog tipoLog;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usua_iddevolvieron")
	private Usuario usuario1;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usua_iddevuelve")
	private Usuario usuario2;

	public LogActividade() {
	}

	public Long getLoadId() {
		return this.loadId;
	}

	public void setLoadId(Long loadId) {
		this.loadId = loadId;
	}

	public Long getActeId() {
		return this.acteId;
	}

	public void setActeId(Long acteId) {
		this.acteId = acteId;
	}

	public Long getAlteId() {
		return this.alteId;
	}

	public void setAlteId(Long alteId) {
		this.alteId = alteId;
	}

	public Long getCotaId() {
		return this.cotaId;
	}

	public void setCotaId(Long cotaId) {
		this.cotaId = cotaId;
	}

	public Long getCotuId() {
		return this.cotuId;
	}

	public void setCotuId(Long cotuId) {
		this.cotuId = cotuId;
	}

	public Long getEmprId() {
		return this.emprId;
	}

	public void setEmprId(Long emprId) {
		this.emprId = emprId;
	}

	public byte getLoacListado() {
		return this.loacListado;
	}

	public void setLoacListado(byte loacListado) {
		this.loacListado = loacListado;
	}

	public Timestamp getLoadFecharegistro() {
		return this.loadFecharegistro;
	}

	public void setLoadFecharegistro(Timestamp loadFecharegistro) {
		this.loadFecharegistro = loadFecharegistro;
	}

	public String getLoadObservacion() {
		return this.loadObservacion;
	}

	public void setLoadObservacion(String loadObservacion) {
		this.loadObservacion = loadObservacion;
	}

	public String getLoadRegistradopor() {
		return this.loadRegistradopor;
	}

	public void setLoadRegistradopor(String loadRegistradopor) {
		this.loadRegistradopor = loadRegistradopor;
	}

	public EjecucionTarea getEjecucionTarea() {
		return this.ejecucionTarea;
	}

	public void setEjecucionTarea(EjecucionTarea ejecucionTarea) {
		this.ejecucionTarea = ejecucionTarea;
	}

	public TipoLog getTipoLog() {
		return this.tipoLog;
	}

	public void setTipoLog(TipoLog tipoLog) {
		this.tipoLog = tipoLog;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}