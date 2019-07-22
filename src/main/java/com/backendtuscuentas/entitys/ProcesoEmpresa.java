package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the proceso_empresa database table.
 * 
 */
@Entity
@Table(name="proceso_empresa")
@NamedQuery(name="ProcesoEmpresa.findAll", query="SELECT p FROM ProcesoEmpresa p")
public class ProcesoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prem_id")
	private int premId;

	@Column(name="prem_estado")
	private int premEstado;

	@Column(name="prem_fecharegistro")
	private Timestamp premFecharegistro;

	@Column(name="prem_registradopor")
	private String premRegistradopor;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="proc_id")
	private Proceso proceso;

	public ProcesoEmpresa() {
	}

	public int getPremId() {
		return this.premId;
	}

	public void setPremId(int premId) {
		this.premId = premId;
	}

	public int getPremEstado() {
		return this.premEstado;
	}

	public void setPremEstado(int premEstado) {
		this.premEstado = premEstado;
	}

	public Timestamp getPremFecharegistro() {
		return this.premFecharegistro;
	}

	public void setPremFecharegistro(Timestamp premFecharegistro) {
		this.premFecharegistro = premFecharegistro;
	}

	public String getPremRegistradopor() {
		return this.premRegistradopor;
	}

	public void setPremRegistradopor(String premRegistradopor) {
		this.premRegistradopor = premRegistradopor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}