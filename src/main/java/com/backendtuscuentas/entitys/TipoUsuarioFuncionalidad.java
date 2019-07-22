package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tipo_usuario_funcionalidad database table.
 * 
 */
@Entity
@Table(name="tipo_usuario_funcionalidad")
public class TipoUsuarioFuncionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tiuf_id")
	private int tiufId;

	@Column(name="rofu_fecharegistro")
	private Timestamp rofuFecharegistro;

	@Column(name="rofu_registradopor")
	private String rofuRegistradopor;

	//bi-directional many-to-one association to Funcionalidad
	@ManyToOne
	@JoinColumn(name="func_id")
	private Funcionalidad funcionalidad;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="tius_id")
	private TipoUsuario tipoUsuario;

	public TipoUsuarioFuncionalidad() {
	}

	public int getTiufId() {
		return this.tiufId;
	}

	public void setTiufId(int tiufId) {
		this.tiufId = tiufId;
	}

	public Timestamp getRofuFecharegistro() {
		return this.rofuFecharegistro;
	}

	public void setRofuFecharegistro(Timestamp rofuFecharegistro) {
		this.rofuFecharegistro = rofuFecharegistro;
	}

	public String getRofuRegistradopor() {
		return this.rofuRegistradopor;
	}

	public void setRofuRegistradopor(String rofuRegistradopor) {
		this.rofuRegistradopor = rofuRegistradopor;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}