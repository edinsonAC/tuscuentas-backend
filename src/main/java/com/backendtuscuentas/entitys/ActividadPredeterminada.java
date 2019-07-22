package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the actividad_predeterminada database table.
 * 
 */
@Data
@Entity
@Table(name="actividad_predeterminada")
public class ActividadPredeterminada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acpr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acprId;

	@Column(name="acpr_descripcion")
	private String acprDescripcion;

	@Column(name="acpr_fecharegistro")
	private Timestamp acprFecharegistro;

	@Column(name="acpr_orden")
	private String acprOrden;

	@Column(name="acpr_registradopor")
	private String acprRegistradopor;

	//bi-directional many-to-one association to TareapreActividadpre
	@OneToMany(mappedBy="actividadPredeterminada")
	private List<TareapreActividadpre> tareapreActividadpres;

	public ActividadPredeterminada() {
	}

}