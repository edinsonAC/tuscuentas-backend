package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the menu_ppal database table.
 * 
 */
@Entity
@Table(name="menu_ppal")
@NamedQuery(name="MenuPpal.findAll", query="SELECT m FROM MenuPpal m")
public class MenuPpal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mepp_id")
	private int meppId;

	@Column(name="mepp_fecharegistro")
	private Timestamp meppFecharegistro;

	@Column(name="mepp_registradopor")
	private String meppRegistradopor;

	@Column(name="mepp_titulo")
	private String meppTitulo;

	public MenuPpal() {
	}

	public int getMeppId() {
		return this.meppId;
	}

	public void setMeppId(int meppId) {
		this.meppId = meppId;
	}

	public Timestamp getMeppFecharegistro() {
		return this.meppFecharegistro;
	}

	public void setMeppFecharegistro(Timestamp meppFecharegistro) {
		this.meppFecharegistro = meppFecharegistro;
	}

	public String getMeppRegistradopor() {
		return this.meppRegistradopor;
	}

	public void setMeppRegistradopor(String meppRegistradopor) {
		this.meppRegistradopor = meppRegistradopor;
	}

	public String getMeppTitulo() {
		return this.meppTitulo;
	}

	public void setMeppTitulo(String meppTitulo) {
		this.meppTitulo = meppTitulo;
	}

}