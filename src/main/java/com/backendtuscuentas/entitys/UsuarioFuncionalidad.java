package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the usuario_funcionalidad database table.
 * 
 */
@Entity
@Table(name="usuario_funcionalidad")
@NamedQuery(name="UsuarioFuncionalidad.findAll", query="SELECT u FROM UsuarioFuncionalidad u")
public class UsuarioFuncionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usfu_id")
	private int usfuId;

	@Column(name="usfu_fecharegistro")
	private Timestamp usfuFecharegistro;

	@Column(name="usfu_registradopor")
	private String usfuRegistradopor;

	//bi-directional many-to-one association to Funcionalidad
	@ManyToOne
	@JoinColumn(name="func_id")
	private Funcionalidad funcionalidad;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public UsuarioFuncionalidad() {
	}

	public int getUsfuId() {
		return this.usfuId;
	}

	public void setUsfuId(int usfuId) {
		this.usfuId = usfuId;
	}

	public Timestamp getUsfuFecharegistro() {
		return this.usfuFecharegistro;
	}

	public void setUsfuFecharegistro(Timestamp usfuFecharegistro) {
		this.usfuFecharegistro = usfuFecharegistro;
	}

	public String getUsfuRegistradopor() {
		return this.usfuRegistradopor;
	}

	public void setUsfuRegistradopor(String usfuRegistradopor) {
		this.usfuRegistradopor = usfuRegistradopor;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}