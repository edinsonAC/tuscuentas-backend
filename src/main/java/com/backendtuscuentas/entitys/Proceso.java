package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the proceso database table.
 * 
 */
@Data
@Entity
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="proc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long procId;

	@Column(name="proc_descripcion")
	private String procDescripcion;

	@Column(name="proc_fecharegistro")
	private Timestamp procFecharegistro;

	@Column(name="proc_impuesto")
	private byte procImpuesto;

	@Column(name="proc_registradopor")
	private String procRegistradopor;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area area;

	//bi-directional many-to-one association to ProcesoEmpresa
	@JsonIgnore
	@OneToMany(mappedBy="proceso")
	private List<ProcesoEmpresa> procesoEmpresas;

	//bi-directional many-to-one association to TareaPredeterminada
	@JsonIgnore
	@OneToMany(mappedBy="proceso")
	private List<TareaPredeterminada> tareaPredeterminadas;

	//bi-directional many-to-one association to TipoempresaProceso
	@JsonIgnore
	@OneToMany(mappedBy="proceso")
	private List<TipoempresaProceso> tipoempresaProcesos;

	public Proceso() {
	}

}