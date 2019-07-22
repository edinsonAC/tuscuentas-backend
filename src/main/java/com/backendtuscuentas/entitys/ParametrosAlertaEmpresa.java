package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the parametros_alerta_empresa database table.
 * 
 */
@Entity
@Table(name="parametros_alerta_empresa")
@NamedQuery(name="ParametrosAlertaEmpresa.findAll", query="SELECT p FROM ParametrosAlertaEmpresa p")
public class ParametrosAlertaEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="paem_id")
	private int paemId;

	@Column(name="paem_fecharegistro")
	private Timestamp paemFecharegistro;

	@Column(name="paem_registradopor")
	private String paemRegistradopor;

	@Column(name="paem_valor")
	private String paemValor;

	//bi-directional many-to-one association to AlertaTempranaEmpresa
	@ManyToOne
	@JoinColumn(name="atem_id")
	private AlertaTempranaEmpresa alertaTempranaEmpresa;

	//bi-directional many-to-one association to ParametrosSiigo
	@ManyToOne
	@JoinColumn(name="pasi_id")
	private ParametrosSiigo parametrosSiigo;

	public ParametrosAlertaEmpresa() {
	}

	public int getPaemId() {
		return this.paemId;
	}

	public void setPaemId(int paemId) {
		this.paemId = paemId;
	}

	public Timestamp getPaemFecharegistro() {
		return this.paemFecharegistro;
	}

	public void setPaemFecharegistro(Timestamp paemFecharegistro) {
		this.paemFecharegistro = paemFecharegistro;
	}

	public String getPaemRegistradopor() {
		return this.paemRegistradopor;
	}

	public void setPaemRegistradopor(String paemRegistradopor) {
		this.paemRegistradopor = paemRegistradopor;
	}

	public String getPaemValor() {
		return this.paemValor;
	}

	public void setPaemValor(String paemValor) {
		this.paemValor = paemValor;
	}

	public AlertaTempranaEmpresa getAlertaTempranaEmpresa() {
		return this.alertaTempranaEmpresa;
	}

	public void setAlertaTempranaEmpresa(AlertaTempranaEmpresa alertaTempranaEmpresa) {
		this.alertaTempranaEmpresa = alertaTempranaEmpresa;
	}

	public ParametrosSiigo getParametrosSiigo() {
		return this.parametrosSiigo;
	}

	public void setParametrosSiigo(ParametrosSiigo parametrosSiigo) {
		this.parametrosSiigo = parametrosSiigo;
	}

}