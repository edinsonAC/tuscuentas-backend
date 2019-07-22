package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the actividad_tareaempresa database table.
 * 
 */
@Data
@Entity
@Table(name="actividad_tareaempresa")
public class ActividadTareaempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acteId;

	@Column(name="acte_descripcion")
	private String acteDescripcion;

	@Column(name="acte_diashabiles")
	private String acteDiashabiles;

	@Column(name="acte_diasprorroga")
	private String acteDiasprorroga;

	@Column(name="acte_estado")
	private String acteEstado;

	@Column(name="acte_estadoprorroga")
	private byte acteEstadoprorroga;

	@Temporal(TemporalType.DATE)
	@Column(name="acte_fechafinal")
	private Date acteFechafinal;

	@Temporal(TemporalType.DATE)
	@Column(name="acte_fechafinalizada")
	private Date acteFechafinalizada;

	@Temporal(TemporalType.DATE)
	@Column(name="acte_fechainicial")
	private Date acteFechainicial;

	@Column(name="acte_fecharegistro")
	private Timestamp acteFecharegistro;

	@Column(name="acte_orden")
	private String acteOrden;

	@Column(name="acte_recurrente")
	private byte acteRecurrente;

	@Column(name="acte_registradopor")
	private String acteRegistradopor;

	@Column(name="taem_id")
	private int taemId;

	@Column(name="tire_id")
	private int tireId;

	@Column(name="usua_id")
	private int usuaId;

	public ActividadTareaempresa() {
	}

}