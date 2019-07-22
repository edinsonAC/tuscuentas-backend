package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the parametros_siigo database table.
 * 
 */
@Entity
@Table(name="parametros_siigo")
@NamedQuery(name="ParametrosSiigo.findAll", query="SELECT p FROM ParametrosSiigo p")
public class ParametrosSiigo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pasi_id")
	private int pasiId;

	@Column(name="pasi_descripcion")
	private String pasiDescripcion;

	@Column(name="pasi_fecharegistro")
	private Timestamp pasiFecharegistro;

	@Column(name="pasi_registradopor")
	private String pasiRegistradopor;

	//bi-directional many-to-one association to ParametrosAlertaEmpresa
	@OneToMany(mappedBy="parametrosSiigo")
	private List<ParametrosAlertaEmpresa> parametrosAlertaEmpresas;

	//bi-directional many-to-one association to AlertaTemprana
	@ManyToOne
	@JoinColumn(name="alte_id")
	private AlertaTemprana alertaTemprana;

	public ParametrosSiigo() {
	}

	public int getPasiId() {
		return this.pasiId;
	}

	public void setPasiId(int pasiId) {
		this.pasiId = pasiId;
	}

	public String getPasiDescripcion() {
		return this.pasiDescripcion;
	}

	public void setPasiDescripcion(String pasiDescripcion) {
		this.pasiDescripcion = pasiDescripcion;
	}

	public Timestamp getPasiFecharegistro() {
		return this.pasiFecharegistro;
	}

	public void setPasiFecharegistro(Timestamp pasiFecharegistro) {
		this.pasiFecharegistro = pasiFecharegistro;
	}

	public String getPasiRegistradopor() {
		return this.pasiRegistradopor;
	}

	public void setPasiRegistradopor(String pasiRegistradopor) {
		this.pasiRegistradopor = pasiRegistradopor;
	}

	public List<ParametrosAlertaEmpresa> getParametrosAlertaEmpresas() {
		return this.parametrosAlertaEmpresas;
	}

	public void setParametrosAlertaEmpresas(List<ParametrosAlertaEmpresa> parametrosAlertaEmpresas) {
		this.parametrosAlertaEmpresas = parametrosAlertaEmpresas;
	}

	public ParametrosAlertaEmpresa addParametrosAlertaEmpresa(ParametrosAlertaEmpresa parametrosAlertaEmpresa) {
		getParametrosAlertaEmpresas().add(parametrosAlertaEmpresa);
		parametrosAlertaEmpresa.setParametrosSiigo(this);

		return parametrosAlertaEmpresa;
	}

	public ParametrosAlertaEmpresa removeParametrosAlertaEmpresa(ParametrosAlertaEmpresa parametrosAlertaEmpresa) {
		getParametrosAlertaEmpresas().remove(parametrosAlertaEmpresa);
		parametrosAlertaEmpresa.setParametrosSiigo(null);

		return parametrosAlertaEmpresa;
	}

	public AlertaTemprana getAlertaTemprana() {
		return this.alertaTemprana;
	}

	public void setAlertaTemprana(AlertaTemprana alertaTemprana) {
		this.alertaTemprana = alertaTemprana;
	}

}