package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tipo_empresa_tareas database table.
 * 
 */
@Entity
@Table(name="tipo_empresa_tareas")
@NamedQuery(name="TipoEmpresaTarea.findAll", query="SELECT t FROM TipoEmpresaTarea t")
public class TipoEmpresaTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tiet_id")
	private int tietId;

	@Column(name="tiet_fecharegistro")
	private Timestamp tietFecharegistro;

	@Column(name="tiet_registradopor")
	private String tietRegistradopor;

	//bi-directional many-to-one association to TareaPredeterminada
	@ManyToOne
	@JoinColumn(name="tapr_id")
	private TareaPredeterminada tareaPredeterminada;

	//bi-directional many-to-one association to TipoEmpresa
	@ManyToOne
	@JoinColumn(name="tiem_id")
	private TipoEmpresa tipoEmpresa;

	public TipoEmpresaTarea() {
	}

	public int getTietId() {
		return this.tietId;
	}

	public void setTietId(int tietId) {
		this.tietId = tietId;
	}

	public Timestamp getTietFecharegistro() {
		return this.tietFecharegistro;
	}

	public void setTietFecharegistro(Timestamp tietFecharegistro) {
		this.tietFecharegistro = tietFecharegistro;
	}

	public String getTietRegistradopor() {
		return this.tietRegistradopor;
	}

	public void setTietRegistradopor(String tietRegistradopor) {
		this.tietRegistradopor = tietRegistradopor;
	}

	public TareaPredeterminada getTareaPredeterminada() {
		return this.tareaPredeterminada;
	}

	public void setTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		this.tareaPredeterminada = tareaPredeterminada;
	}

	public TipoEmpresa getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}