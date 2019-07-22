package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tipoempresa_proceso database table.
 * 
 */
@Entity
@Table(name="tipoempresa_proceso")
@NamedQuery(name="TipoempresaProceso.findAll", query="SELECT t FROM TipoempresaProceso t")
public class TipoempresaProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="teta_id")
	private int tetaId;

	@Column(name="teta_fecharegistro")
	private Timestamp tetaFecharegistro;

	@Column(name="teta_registradopor")
	private String tetaRegistradopor;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="proc_id")
	private Proceso proceso;

	//bi-directional many-to-one association to TipoEmpresa
	@ManyToOne
	@JoinColumn(name="tiem_id")
	private TipoEmpresa tipoEmpresa;

	public TipoempresaProceso() {
	}

	public int getTetaId() {
		return this.tetaId;
	}

	public void setTetaId(int tetaId) {
		this.tetaId = tetaId;
	}

	public Timestamp getTetaFecharegistro() {
		return this.tetaFecharegistro;
	}

	public void setTetaFecharegistro(Timestamp tetaFecharegistro) {
		this.tetaFecharegistro = tetaFecharegistro;
	}

	public String getTetaRegistradopor() {
		return this.tetaRegistradopor;
	}

	public void setTetaRegistradopor(String tetaRegistradopor) {
		this.tetaRegistradopor = tetaRegistradopor;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public TipoEmpresa getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}