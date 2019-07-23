package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tarea_predeterminada database table.
 * 
 */
@Data
@Entity
@Table(name="tarea_predeterminada")
public class TareaPredeterminada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tapr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taprId;

	@Column(name="tapr_calendariotributario")
	private Long taprCalendariotributario;

	@Column(name="tapr_cod")
	private Long taprCod;

	@Column(name="tapr_comentarobligatorio")
	private Long taprComentarobligatorio;

	@Column(name="tapr_descripcion")
	private String taprDescripcion;

	@Column(name="tapr_diahabilsiguiente")
	private Long taprDiahabilsiguiente;

	@Column(name="tapr_distrital")
	private Long taprDistrital;

	@Column(name="tapr_editable")
	private Long taprEditable;

	@Column(name="tapr_estado")
	private Long taprEstado;

	@Column(name="tapr_fecharegistro")
	private Timestamp taprFecharegistro;

	@Column(name="tapr_impuesto")
	private Long taprImpuesto;

	@Column(name="tapr_nacional")
	private Long taprNacional;

	@Column(name="tapr_nombre")
	private String taprNombre;

	@Column(name="tapr_nueva")
	private Long taprNueva;

	@Column(name="tapr_pidegerente")
	private String taprPidegerente;

	@Column(name="tapr_recurrente")
	private Long taprRecurrente;

	@Column(name="tapr_registradopor")
	private String taprRegistradopor;

	@Column(name="tire_id")
	private Long tireId;

	//bi-directional many-to-one association to TareaEmpresa
	@JsonIgnore
	@OneToMany(mappedBy="tareaPredeterminada", fetch = FetchType.LAZY)
	private List<TareaEmpresa> tareaEmpresas;

	//bi-directional many-to-one association to CalendarioFecha
	@ManyToOne
	@JoinColumn(name="cafe_id")
	private CalendarioFecha calendarioFecha;

	//bi-directional many-to-one association to EsquemaTarea
	@ManyToOne
	@JoinColumn(name="esta_id")
	private EsquemaTarea esquemaTarea;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="proc_id")
	private Proceso proceso;

	//bi-directional many-to-one association to TareapreActividadpre
	@JsonIgnore
	@OneToMany(mappedBy="tareaPredeterminada")
	private List<TareapreActividadpre> tareapreActividadpres;

	//bi-directional many-to-one association to TipoEmpresaTarea
	@JsonIgnore
	@OneToMany(mappedBy="tareaPredeterminada")
	private List<TipoEmpresaTarea> tipoEmpresaTareas;

	public TareaPredeterminada() {
	}


}