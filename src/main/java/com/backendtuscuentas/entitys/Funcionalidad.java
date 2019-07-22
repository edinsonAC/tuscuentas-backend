package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the funcionalidad database table.
 * 
 */
@Entity
@Table(name="funcionalidad")
public class Funcionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="func_id")
	private Long funcId;

	@Column(name="func_fecharegistro")
	private Timestamp funcFecharegistro;

	@Column(name="func_icono")
	private String funcIcono;

	@Column(name="func_pagina")
	private String funcPagina;

	@Column(name="func_registradopor")
	private String funcRegistradopor;

	@Column(name="func_titulo")
	private String funcTitulo;

	//bi-directional many-to-one association to Menu
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;

	//bi-directional many-to-one association to TipoUsuarioFuncionalidad
	@JsonIgnore
	@OneToMany(mappedBy="funcionalidad")
	private List<TipoUsuarioFuncionalidad> tipoUsuarioFuncionalidads;

	//bi-directional many-to-one association to UsuarioFuncionalidad
	@JsonIgnore
	@OneToMany(mappedBy="funcionalidad")
	private List<UsuarioFuncionalidad> usuarioFuncionalidads;

	public Funcionalidad() {
	}

	public Long getFuncId() {
		return this.funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

	public Timestamp getFuncFecharegistro() {
		return this.funcFecharegistro;
	}

	public void setFuncFecharegistro(Timestamp funcFecharegistro) {
		this.funcFecharegistro = funcFecharegistro;
	}

	public String getFuncIcono() {
		return this.funcIcono;
	}

	public void setFuncIcono(String funcIcono) {
		this.funcIcono = funcIcono;
	}

	public String getFuncPagina() {
		return this.funcPagina;
	}

	public void setFuncPagina(String funcPagina) {
		this.funcPagina = funcPagina;
	}

	public String getFuncRegistradopor() {
		return this.funcRegistradopor;
	}

	public void setFuncRegistradopor(String funcRegistradopor) {
		this.funcRegistradopor = funcRegistradopor;
	}

	public String getFuncTitulo() {
		return this.funcTitulo;
	}

	public void setFuncTitulo(String funcTitulo) {
		this.funcTitulo = funcTitulo;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<TipoUsuarioFuncionalidad> getTipoUsuarioFuncionalidads() {
		return this.tipoUsuarioFuncionalidads;
	}

	public void setTipoUsuarioFuncionalidads(List<TipoUsuarioFuncionalidad> tipoUsuarioFuncionalidads) {
		this.tipoUsuarioFuncionalidads = tipoUsuarioFuncionalidads;
	}

	public TipoUsuarioFuncionalidad addTipoUsuarioFuncionalidad(TipoUsuarioFuncionalidad tipoUsuarioFuncionalidad) {
		getTipoUsuarioFuncionalidads().add(tipoUsuarioFuncionalidad);
		tipoUsuarioFuncionalidad.setFuncionalidad(this);

		return tipoUsuarioFuncionalidad;
	}

	public TipoUsuarioFuncionalidad removeTipoUsuarioFuncionalidad(TipoUsuarioFuncionalidad tipoUsuarioFuncionalidad) {
		getTipoUsuarioFuncionalidads().remove(tipoUsuarioFuncionalidad);
		tipoUsuarioFuncionalidad.setFuncionalidad(null);

		return tipoUsuarioFuncionalidad;
	}

	public List<UsuarioFuncionalidad> getUsuarioFuncionalidads() {
		return this.usuarioFuncionalidads;
	}

	public void setUsuarioFuncionalidads(List<UsuarioFuncionalidad> usuarioFuncionalidads) {
		this.usuarioFuncionalidads = usuarioFuncionalidads;
	}

	public UsuarioFuncionalidad addUsuarioFuncionalidad(UsuarioFuncionalidad usuarioFuncionalidad) {
		getUsuarioFuncionalidads().add(usuarioFuncionalidad);
		usuarioFuncionalidad.setFuncionalidad(this);

		return usuarioFuncionalidad;
	}

	public UsuarioFuncionalidad removeUsuarioFuncionalidad(UsuarioFuncionalidad usuarioFuncionalidad) {
		getUsuarioFuncionalidads().remove(usuarioFuncionalidad);
		usuarioFuncionalidad.setFuncionalidad(null);

		return usuarioFuncionalidad;
	}

}