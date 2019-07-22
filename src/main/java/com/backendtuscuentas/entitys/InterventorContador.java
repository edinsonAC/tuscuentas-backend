package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the interventor_contador database table.
 * 
 */
@Entity
@Table(name="interventor_contador")
public class InterventorContador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inco_id")
	private Long incoId;

	@Column(name="inco_fecharegistro")
	private Timestamp incoFecharegistro;

	@Column(name="inco_registradopor")
	private String incoRegistradopor;

	//bi-directional many-to-one association to ContadorJuridico
	@ManyToOne
	@JoinColumn(name="coju_id")
	private ContadorJuridico contadorJuridico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public InterventorContador() {
	}

	public Long getIncoId() {
		return this.incoId;
	}

	public void setIncoId(Long incoId) {
		this.incoId = incoId;
	}

	public Timestamp getIncoFecharegistro() {
		return this.incoFecharegistro;
	}

	public void setIncoFecharegistro(Timestamp incoFecharegistro) {
		this.incoFecharegistro = incoFecharegistro;
	}

	public String getIncoRegistradopor() {
		return this.incoRegistradopor;
	}

	public void setIncoRegistradopor(String incoRegistradopor) {
		this.incoRegistradopor = incoRegistradopor;
	}

	public ContadorJuridico getContadorJuridico() {
		return this.contadorJuridico;
	}

	public void setContadorJuridico(ContadorJuridico contadorJuridico) {
		this.contadorJuridico = contadorJuridico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}