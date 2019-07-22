package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the supervisor_interventor database table.
 * 
 */
@Entity
@Table(name="supervisor_interventor")
@NamedQuery(name="SupervisorInterventor.findAll", query="SELECT s FROM SupervisorInterventor s")
public class SupervisorInterventor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="suin_id")
	private int suinId;

	@Column(name="suin_fecharegistro")
	private Timestamp suinFecharegistro;

	@Column(name="suin_registradopor")
	private String suinRegistradopor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_idsupervisor")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_idinterventor")
	private Usuario usuario2;

	public SupervisorInterventor() {
	}

	public int getSuinId() {
		return this.suinId;
	}

	public void setSuinId(int suinId) {
		this.suinId = suinId;
	}

	public Timestamp getSuinFecharegistro() {
		return this.suinFecharegistro;
	}

	public void setSuinFecharegistro(Timestamp suinFecharegistro) {
		this.suinFecharegistro = suinFecharegistro;
	}

	public String getSuinRegistradopor() {
		return this.suinRegistradopor;
	}

	public void setSuinRegistradopor(String suinRegistradopor) {
		this.suinRegistradopor = suinRegistradopor;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}