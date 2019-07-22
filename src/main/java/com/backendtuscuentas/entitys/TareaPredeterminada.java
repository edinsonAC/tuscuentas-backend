package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

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
	private byte taprCalendariotributario;

	@Column(name="tapr_cod")
	private int taprCod;

	@Column(name="tapr_comentarobligatorio")
	private byte taprComentarobligatorio;

	@Column(name="tapr_descripcion")
	private String taprDescripcion;

	@Column(name="tapr_diahabilsiguiente")
	private byte taprDiahabilsiguiente;

	@Column(name="tapr_distrital")
	private byte taprDistrital;

	@Column(name="tapr_editable")
	private byte taprEditable;

	@Column(name="tapr_estado")
	private byte taprEstado;

	@Column(name="tapr_fecharegistro")
	private Timestamp taprFecharegistro;

	@Column(name="tapr_impuesto")
	private byte taprImpuesto;

	@Column(name="tapr_nacional")
	private byte taprNacional;

	@Column(name="tapr_nombre")
	private String taprNombre;

	@Column(name="tapr_nueva")
	private byte taprNueva;

	@Column(name="tapr_pidegerente")
	private String taprPidegerente;

	@Column(name="tapr_recurrente")
	private byte taprRecurrente;

	@Column(name="tapr_registradopor")
	private String taprRegistradopor;

	@Column(name="tire_id")
	private int tireId;

	//bi-directional many-to-one association to TareaEmpresa
	@OneToMany(mappedBy="tareaPredeterminada")
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
	@OneToMany(mappedBy="tareaPredeterminada")
	private List<TareapreActividadpre> tareapreActividadpres;

	//bi-directional many-to-one association to TipoEmpresaTarea
	@OneToMany(mappedBy="tareaPredeterminada")
	private List<TipoEmpresaTarea> tipoEmpresaTareas;

	public TareaPredeterminada() {
	}


}