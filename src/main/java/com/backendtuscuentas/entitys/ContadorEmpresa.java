package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the contador_empresa database table.
 * 
 */
@Entity
@Table(name="contador_empresa")
@NamedQuery(name="ContadorEmpresa.findAll", query="SELECT c FROM ContadorEmpresa c")
public class ContadorEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coem_id")
	private int coemId;

	@Column(name="caem_id")
	private int caemId;

	@Column(name="coem_estado")
	private byte coemEstado;

	@Column(name="coem_fecharegistro")
	private Timestamp coemFecharegistro;

	@Column(name="coem_registradopor")
	private String coemRegistradopor;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public ContadorEmpresa() {
	}

	public int getCoemId() {
		return this.coemId;
	}

	public void setCoemId(int coemId) {
		this.coemId = coemId;
	}

	public int getCaemId() {
		return this.caemId;
	}

	public void setCaemId(int caemId) {
		this.caemId = caemId;
	}

	public byte getCoemEstado() {
		return this.coemEstado;
	}

	public void setCoemEstado(byte coemEstado) {
		this.coemEstado = coemEstado;
	}

	public Timestamp getCoemFecharegistro() {
		return this.coemFecharegistro;
	}

	public void setCoemFecharegistro(Timestamp coemFecharegistro) {
		this.coemFecharegistro = coemFecharegistro;
	}

	public String getCoemRegistradopor() {
		return this.coemRegistradopor;
	}

	public void setCoemRegistradopor(String coemRegistradopor) {
		this.coemRegistradopor = coemRegistradopor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}