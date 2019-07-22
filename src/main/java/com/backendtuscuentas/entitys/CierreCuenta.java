package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cierre_cuentas database table.
 * 
 */
@Entity
@Table(name="cierre_cuentas")
@NamedQuery(name="CierreCuenta.findAll", query="SELECT c FROM CierreCuenta c")
public class CierreCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cicu_id")
	private int cicuId;

	@Column(name="cicu_anio")
	private String cicuAnio;

	@Column(name="cicu_codcuenta")
	private String cicuCodcuenta;

	@Column(name="cicu_fecharegistro")
	private Timestamp cicuFecharegistro;

	@Column(name="cicu_mes")
	private String cicuMes;

	@Column(name="cicu_nitempresa")
	private String cicuNitempresa;

	@Column(name="cicu_nivelpresentacion")
	private String cicuNivelpresentacion;

	@Column(name="cicu_registradopor")
	private String cicuRegistradopor;

	@Column(name="cicu_valorcerrado")
	private String cicuValorcerrado;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public CierreCuenta() {
	}

	public int getCicuId() {
		return this.cicuId;
	}

	public void setCicuId(int cicuId) {
		this.cicuId = cicuId;
	}

	public String getCicuAnio() {
		return this.cicuAnio;
	}

	public void setCicuAnio(String cicuAnio) {
		this.cicuAnio = cicuAnio;
	}

	public String getCicuCodcuenta() {
		return this.cicuCodcuenta;
	}

	public void setCicuCodcuenta(String cicuCodcuenta) {
		this.cicuCodcuenta = cicuCodcuenta;
	}

	public Timestamp getCicuFecharegistro() {
		return this.cicuFecharegistro;
	}

	public void setCicuFecharegistro(Timestamp cicuFecharegistro) {
		this.cicuFecharegistro = cicuFecharegistro;
	}

	public String getCicuMes() {
		return this.cicuMes;
	}

	public void setCicuMes(String cicuMes) {
		this.cicuMes = cicuMes;
	}

	public String getCicuNitempresa() {
		return this.cicuNitempresa;
	}

	public void setCicuNitempresa(String cicuNitempresa) {
		this.cicuNitempresa = cicuNitempresa;
	}

	public String getCicuNivelpresentacion() {
		return this.cicuNivelpresentacion;
	}

	public void setCicuNivelpresentacion(String cicuNivelpresentacion) {
		this.cicuNivelpresentacion = cicuNivelpresentacion;
	}

	public String getCicuRegistradopor() {
		return this.cicuRegistradopor;
	}

	public void setCicuRegistradopor(String cicuRegistradopor) {
		this.cicuRegistradopor = cicuRegistradopor;
	}

	public String getCicuValorcerrado() {
		return this.cicuValorcerrado;
	}

	public void setCicuValorcerrado(String cicuValorcerrado) {
		this.cicuValorcerrado = cicuValorcerrado;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}