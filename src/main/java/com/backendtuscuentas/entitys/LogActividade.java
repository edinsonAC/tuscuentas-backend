package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.sql.Timestamp;

/**
 * The persistent class for the log_actividades database table.
 * 
 */
@Data
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
	private Long loacListado;

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


}