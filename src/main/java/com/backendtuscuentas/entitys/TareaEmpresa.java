package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tarea_empresa database table.
 * 
 */
@Data
@Entity
@Table(name="tarea_empresa")
public class TareaEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="taem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taemId;

	@Column(name="cafe_id")
	private Long cafeId;

	@Column(name="empr_id")
	private Long emprId;

	@Column(name="esta_id")
	private Long estaId;

	@Column(name="taem_comentarobligatorio")
	private byte taemComentarobligatorio;

	@Column(name="taem_diahabilsiguiente")
	private String taemDiahabilsiguiente;

	@Column(name="taem_estado")
	private byte taemEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="taem_fechafinal")
	private Date taemFechafinal;

	@Temporal(TemporalType.DATE)
	@Column(name="taem_fechainicial")
	private Date taemFechainicial;

	@Column(name="taem_fecharegistro")
	private Timestamp taemFecharegistro;

	@Column(name="taem_gerente")
	private String taemGerente;

	@Column(name="taem_idaprobacion")
	private String taem_idAprobacion;

	@Column(name="taem_idejecucion")
	private String taem_idEjecucion;

	@Column(name="taem_idrecepcion")
	private String taem_idRecepcion;

	@Column(name="taem_idrevision")
	private String taem_idRevision;

	@Column(name="taem_impuesto")
	private String taemImpuesto;

	@Column(name="taem_leido")
	private byte taemLeido;

	@Column(name="taem_pasoaprobacion_cargoempresa")
	private String taemPasoaprobacionCargoempresa;

	@Column(name="taem_pasoaprobacion_diashabiles")
	private String taemPasoaprobacionDiashabiles;

	@Column(name="taem_pasoaprobacion_diasprorroga")
	private String taemPasoaprobacionDiasprorroga;

	@Column(name="taem_pasoaprobacion_estado")
	private String taemPasoaprobacionEstado;

	@Column(name="taem_pasoejecucion_cargoempresa")
	private String taemPasoejecucionCargoempresa;

	@Column(name="taem_pasoejecucion_diashabiles")
	private String taemPasoejecucionDiashabiles;

	@Column(name="taem_pasoejecucion_diasprorroga")
	private String taemPasoejecucionDiasprorroga;

	@Column(name="taem_pasoejecucion_estado")
	private String taemPasoejecucionEstado;

	@Column(name="taem_pasorecepcion_cargoempresa")
	private String taemPasorecepcionCargoempresa;

	@Column(name="taem_pasorecepcion_diashabiles")
	private String taemPasorecepcionDiashabiles;

	@Column(name="taem_pasorecepcion_diasprorroga")
	private String taemPasorecepcionDiasprorroga;

	@Column(name="taem_pasorecepcion_estado")
	private String taemPasorecepcionEstado;

	@Column(name="taem_pasorevision_cargoempresa")
	private String taemPasorevisionCargoempresa;

	@Column(name="taem_pasorevision_diashabiles")
	private String taemPasorevisionDiashabiles;

	@Column(name="taem_pasorevision_diasprorroga")
	private String taemPasorevisionDiasprorroga;

	@Column(name="taem_pasorevision_estado")
	private String taemPasorevisionEstado;

	@Column(name="taem_recurrente")
	private byte taemRecurrente;

	@Column(name="taem_registradopor")
	private String taemRegistradopor;

	//bi-directional many-to-one association to EjecucionProxima
	@JsonIgnore
	@OneToMany(mappedBy="tareaEmpresa", fetch = FetchType.LAZY)
	private List<EjecucionProxima> ejecucionProximas;

	//bi-directional many-to-one association to TareaPredeterminada
	@ManyToOne
	@JoinColumn(name="tapr_id")
	private TareaPredeterminada tareaPredeterminada;

	//bi-directional many-to-one association to TipoRecurrencia
	@ManyToOne
	@JoinColumn(name="tire_id")
	private TipoRecurrencia tipoRecurrencia;

	//bi-directional many-to-one association to Visualizar
	@JsonIgnore
	@OneToMany(mappedBy="tareaEmpresa", fetch = FetchType.LAZY)
	private List<Visualizar> visualizars;

	public TareaEmpresa() {
	}


}