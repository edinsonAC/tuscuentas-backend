package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;


/**
 * The persistent class for the checklist database table.
 * 
 */
@Data
@Entity
public class Checklist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chec_id")
	private Long checId;

	@Column(name="chec_ayuda")
	private String checAyuda;

	@Column(name="chec_descripcion")
	private String checDescripcion;

	@Column(name="chec_estado")
	private byte checEstado;

	@Column(name="chec_fecharegistro")
	private Timestamp checFecharegistro;

	@Column(name="chec_orden")
	private String checOrden;

	@Column(name="chec_registradopor")
	private String checRegistradopor;

	//bi-directional many-to-one association to TareapreActividadpre
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tpap_id")
	private TareapreActividadpre tareapreActividadpre;

	public Checklist() {
	}

}