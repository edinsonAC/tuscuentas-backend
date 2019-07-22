package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ejecucion_tarea database table.
 * 
 */
@Data
@Entity
@Table(name="ejecucion_tarea")
public class EjecucionTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ejta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ejtaId;

	@Column(name="acpr_id")
	private String acprId;

	@Column(name="acte_id")
	private String acteId;

	@Column(name="ejta_codejecucion")
	private String ejtaCodejecucion;

	@Column(name="ejta_descripcion")
	private String ejtaDescripcion;

	@Column(name="ejta_dias")
	private String ejtaDias;

	@Column(name="ejta_diashabiles")
	private String ejtaDiashabiles;

	@Column(name="ejta_diasprorroga")
	private String ejtaDiasprorroga;

	@Column(name="ejta_estado")
	private String ejtaEstado;

	@Column(name="ejta_estadoprorroga")
	private byte ejtaEstadoprorroga;

	@Column(name="ejta_fechafinal")
	private String ejtaFechafinal;

	@Column(name="ejta_fechafinalizada")
	private String ejtaFechafinalizada;

	@Column(name="ejta_fechainicial")
	private String ejtaFechainicial;

	@Column(name="ejta_fecharegistro")
	private Timestamp ejtaFecharegistro;

	@Column(name="ejta_habil")
	private byte ejtaHabil;

	@Column(name="ejta_leido")
	private byte ejtaLeido;

	@Column(name="ejta_orden")
	private String ejtaOrden;

	@Column(name="ejta_registradopor")
	private String ejtaRegistradopor;

	@ManyToOne
	@JoinColumn(name = "taem_id")
	private TareaEmpresa taemId;

	@ManyToOne
	@JoinColumn(name = "usua_id")
	private Usuario usuaId;

	//bi-directional many-to-one association to ChecklistActividadempresa
	@JsonIgnore
	@OneToMany(mappedBy="ejecucionTarea", fetch = FetchType.LAZY)
	private List<ChecklistActividadempresa> checklistActividadempresas;

	//bi-directional many-to-one association to ComentariosTarea
	@JsonIgnore
	@OneToMany(mappedBy="ejecucionTarea", fetch = FetchType.LAZY)
	private List<ComentariosTarea> comentariosTareas;

	//bi-directional many-to-one association to DescripcionIndicador
	@JsonIgnore
	@OneToMany(mappedBy="ejecucionTarea", fetch = FetchType.LAZY)
	private List<DescripcionIndicador> descripcionIndicadors;

	//bi-directional many-to-one association to CargoEmpresa
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="caem_id")
	private CargoEmpresa cargoEmpresa;

	//bi-directional many-to-one association to LogActividade
	@JsonIgnore
	@OneToMany(mappedBy="ejecucionTarea", fetch = FetchType.LAZY)
	private List<LogActividade> logActividades;

	//bi-directional many-to-one association to Visualizar
	@JsonIgnore
	@OneToMany(mappedBy="ejecucionTarea", fetch = FetchType.LAZY)
	private List<Visualizar> visualizars;

	public EjecucionTarea() {
	}

}