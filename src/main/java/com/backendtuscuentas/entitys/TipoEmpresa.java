package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_empresa database table.
 * 
 */
@Entity
@Table(name="tipo_empresa")
@NamedQuery(name="TipoEmpresa.findAll", query="SELECT t FROM TipoEmpresa t")
public class TipoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tiem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tiemId;

	@Column(name="tiem_descripcion")
	private String tiemDescripcion;

	@Column(name="tiem_fecharegistro")
	private Timestamp tiemFecharegistro;

	@Column(name="tiem_registradopor")
	private String tiemRegistradopor;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="tipoEmpresa")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to TipoEmpresaTarea
	@OneToMany(mappedBy="tipoEmpresa")
	private List<TipoEmpresaTarea> tipoEmpresaTareas;

	//bi-directional many-to-one association to TipoempresaProceso
	@OneToMany(mappedBy="tipoEmpresa")
	private List<TipoempresaProceso> tipoempresaProcesos;

	public TipoEmpresa() {
	}

}