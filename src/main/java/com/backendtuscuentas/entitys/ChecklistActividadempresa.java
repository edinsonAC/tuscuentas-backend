package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;


/**
 * The persistent class for the checklist_actividadempresa database table.
 * 
 */
@Data
@Entity
@Table(name="checklist_actividadempresa")
public class ChecklistActividadempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clac_id")
	private Long clacId;

	@Column(name="acte_id")
	private Long acteId;

	@Column(name="clac_ayuda")
	private String clacAyuda;

	@Column(name="clac_descripcion")
	private String clacDescripcion;

	@Column(name="clac_estado")
	private byte clacEstado;

	@Column(name="clac_fecharegistro")
	private Timestamp clacFecharegistro;

	@Column(name="clac_orden")
	private String clacOrden;

	@Column(name="clac_registradopor")
	private String clacRegistradopor;

	//bi-directional many-to-one association to EjecucionTarea
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	public ChecklistActividadempresa() {
	}


}