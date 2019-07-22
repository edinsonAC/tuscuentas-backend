package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pago_contador database table.
 * 
 */
@Entity
@Table(name="pago_contador")
@NamedQuery(name="PagoContador.findAll", query="SELECT p FROM PagoContador p")
public class PagoContador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="paco_id")
	private int pacoId;

	@Column(name="paco_descripcion")
	private String pacoDescripcion;

	@Column(name="paco_fecharegistro")
	private Timestamp pacoFecharegistro;

	@Column(name="paco_registradopor")
	private String pacoRegistradopor;

	@Column(name="paco_totalpagado")
	private String pacoTotalpagado;

	//bi-directional many-to-one association to ContadorJuridico
	@ManyToOne
	@JoinColumn(name="coju_id")
	private ContadorJuridico contadorJuridico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public PagoContador() {
	}

	public int getPacoId() {
		return this.pacoId;
	}

	public void setPacoId(int pacoId) {
		this.pacoId = pacoId;
	}

	public String getPacoDescripcion() {
		return this.pacoDescripcion;
	}

	public void setPacoDescripcion(String pacoDescripcion) {
		this.pacoDescripcion = pacoDescripcion;
	}

	public Timestamp getPacoFecharegistro() {
		return this.pacoFecharegistro;
	}

	public void setPacoFecharegistro(Timestamp pacoFecharegistro) {
		this.pacoFecharegistro = pacoFecharegistro;
	}

	public String getPacoRegistradopor() {
		return this.pacoRegistradopor;
	}

	public void setPacoRegistradopor(String pacoRegistradopor) {
		this.pacoRegistradopor = pacoRegistradopor;
	}

	public String getPacoTotalpagado() {
		return this.pacoTotalpagado;
	}

	public void setPacoTotalpagado(String pacoTotalpagado) {
		this.pacoTotalpagado = pacoTotalpagado;
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