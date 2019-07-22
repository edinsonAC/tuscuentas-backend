package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "menu_id")
	private Long menuId;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "menu_fecharegistro")
	private Timestamp menuFecharegistro;

	@Column(name = "menu_icono")
	private String menuIcono;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "menu_registradopor")
	private String menuRegistradopor;

	@Column(name = "menu_titulo")
	private String menuTitulo;

	@Column(name = "mepp_id")
	private int meppId;

	// bi-directional many-to-one association to Funcionalidad
	@OneToMany(mappedBy = "menu")
	private List<Funcionalidad> funcionalidads;

	public Menu() {
	}

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Timestamp getMenuFecharegistro() {
		return this.menuFecharegistro;
	}

	public void setMenuFecharegistro(Timestamp menuFecharegistro) {
		this.menuFecharegistro = menuFecharegistro;
	}

	public String getMenuIcono() {
		return this.menuIcono;
	}

	public void setMenuIcono(String menuIcono) {
		this.menuIcono = menuIcono;
	}

	public String getMenuRegistradopor() {
		return this.menuRegistradopor;
	}

	public void setMenuRegistradopor(String menuRegistradopor) {
		this.menuRegistradopor = menuRegistradopor;
	}

	public String getMenuTitulo() {
		return this.menuTitulo;
	}

	public void setMenuTitulo(String menuTitulo) {
		this.menuTitulo = menuTitulo;
	}

	public int getMeppId() {
		return this.meppId;
	}

	public void setMeppId(int meppId) {
		this.meppId = meppId;
	}

	public List<Funcionalidad> getFuncionalidads() {
		return this.funcionalidads;
	}

	public void setFuncionalidads(List<Funcionalidad> funcionalidads) {
		this.funcionalidads = funcionalidads;
	}

	public Funcionalidad addFuncionalidad(Funcionalidad funcionalidad) {
		getFuncionalidads().add(funcionalidad);
		funcionalidad.setMenu(this);

		return funcionalidad;
	}

	public Funcionalidad removeFuncionalidad(Funcionalidad funcionalidad) {
		getFuncionalidads().remove(funcionalidad);
		funcionalidad.setMenu(null);

		return funcionalidad;
	}

}