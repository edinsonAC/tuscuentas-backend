package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the documentos_empresa database table.
 * 
 */
@Entity
@Table(name="documentos_empresa")
@NamedQuery(name="DocumentosEmpresa.findAll", query="SELECT d FROM DocumentosEmpresa d")
public class DocumentosEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="doem_id")
	private int doemId;

	@Column(name="doem_camaracomercio")
	private byte doemCamaracomercio;

	@Column(name="doem_fecharegistro")
	private Timestamp doemFecharegistro;

	@Column(name="doem_nombredocumento")
	private String doemNombredocumento;

	@Column(name="doem_registradopor")
	private String doemRegistradopor;

	//bi-directional many-to-one association to ContadorJuridico
	@ManyToOne
	@JoinColumn(name="coju_id")
	private ContadorJuridico contadorJuridico;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public DocumentosEmpresa() {
	}

	public int getDoemId() {
		return this.doemId;
	}

	public void setDoemId(int doemId) {
		this.doemId = doemId;
	}

	public byte getDoemCamaracomercio() {
		return this.doemCamaracomercio;
	}

	public void setDoemCamaracomercio(byte doemCamaracomercio) {
		this.doemCamaracomercio = doemCamaracomercio;
	}

	public Timestamp getDoemFecharegistro() {
		return this.doemFecharegistro;
	}

	public void setDoemFecharegistro(Timestamp doemFecharegistro) {
		this.doemFecharegistro = doemFecharegistro;
	}

	public String getDoemNombredocumento() {
		return this.doemNombredocumento;
	}

	public void setDoemNombredocumento(String doemNombredocumento) {
		this.doemNombredocumento = doemNombredocumento;
	}

	public String getDoemRegistradopor() {
		return this.doemRegistradopor;
	}

	public void setDoemRegistradopor(String doemRegistradopor) {
		this.doemRegistradopor = doemRegistradopor;
	}

	public ContadorJuridico getContadorJuridico() {
		return this.contadorJuridico;
	}

	public void setContadorJuridico(ContadorJuridico contadorJuridico) {
		this.contadorJuridico = contadorJuridico;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}