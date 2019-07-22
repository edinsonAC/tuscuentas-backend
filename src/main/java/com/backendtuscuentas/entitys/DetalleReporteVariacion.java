package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_reporte_variacion database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_variacion")
@NamedQuery(name="DetalleReporteVariacion.findAll", query="SELECT d FROM DetalleReporteVariacion d")
public class DetalleReporteVariacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="drva_id")
	private int drvaId;

	@Column(name="drva_cuentasparametrizadas")
	private String drvaCuentasparametrizadas;

	@Column(name="drva_nivelpresentacion")
	private String drvaNivelpresentacion;

	@Column(name="drva_periodoactual")
	private String drvaPeriodoactual;

	@Column(name="drva_periodoanterior")
	private String drvaPeriodoanterior;

	@Column(name="drva_registradopor")
	private String drvaRegistradopor;

	@Column(name="drva_tipovariacion")
	private String drvaTipovariacion;

	@Column(name="drva_totalperiodoactual")
	private String drvaTotalperiodoactual;

	@Column(name="drva_totalperiodoanterior")
	private String drvaTotalperiodoanterior;

	@Column(name="drva_variacionfinal")
	private String drvaVariacionfinal;

	private Timestamp drvafecharegistro;

	@Column(name="empr_id")
	private int emprId;

	public DetalleReporteVariacion() {
	}

	public int getDrvaId() {
		return this.drvaId;
	}

	public void setDrvaId(int drvaId) {
		this.drvaId = drvaId;
	}

	public String getDrvaCuentasparametrizadas() {
		return this.drvaCuentasparametrizadas;
	}

	public void setDrvaCuentasparametrizadas(String drvaCuentasparametrizadas) {
		this.drvaCuentasparametrizadas = drvaCuentasparametrizadas;
	}

	public String getDrvaNivelpresentacion() {
		return this.drvaNivelpresentacion;
	}

	public void setDrvaNivelpresentacion(String drvaNivelpresentacion) {
		this.drvaNivelpresentacion = drvaNivelpresentacion;
	}

	public String getDrvaPeriodoactual() {
		return this.drvaPeriodoactual;
	}

	public void setDrvaPeriodoactual(String drvaPeriodoactual) {
		this.drvaPeriodoactual = drvaPeriodoactual;
	}

	public String getDrvaPeriodoanterior() {
		return this.drvaPeriodoanterior;
	}

	public void setDrvaPeriodoanterior(String drvaPeriodoanterior) {
		this.drvaPeriodoanterior = drvaPeriodoanterior;
	}

	public String getDrvaRegistradopor() {
		return this.drvaRegistradopor;
	}

	public void setDrvaRegistradopor(String drvaRegistradopor) {
		this.drvaRegistradopor = drvaRegistradopor;
	}

	public String getDrvaTipovariacion() {
		return this.drvaTipovariacion;
	}

	public void setDrvaTipovariacion(String drvaTipovariacion) {
		this.drvaTipovariacion = drvaTipovariacion;
	}

	public String getDrvaTotalperiodoactual() {
		return this.drvaTotalperiodoactual;
	}

	public void setDrvaTotalperiodoactual(String drvaTotalperiodoactual) {
		this.drvaTotalperiodoactual = drvaTotalperiodoactual;
	}

	public String getDrvaTotalperiodoanterior() {
		return this.drvaTotalperiodoanterior;
	}

	public void setDrvaTotalperiodoanterior(String drvaTotalperiodoanterior) {
		this.drvaTotalperiodoanterior = drvaTotalperiodoanterior;
	}

	public String getDrvaVariacionfinal() {
		return this.drvaVariacionfinal;
	}

	public void setDrvaVariacionfinal(String drvaVariacionfinal) {
		this.drvaVariacionfinal = drvaVariacionfinal;
	}

	public Timestamp getDrvafecharegistro() {
		return this.drvafecharegistro;
	}

	public void setDrvafecharegistro(Timestamp drvafecharegistro) {
		this.drvafecharegistro = drvafecharegistro;
	}

	public int getEmprId() {
		return this.emprId;
	}

	public void setEmprId(int emprId) {
		this.emprId = emprId;
	}

}