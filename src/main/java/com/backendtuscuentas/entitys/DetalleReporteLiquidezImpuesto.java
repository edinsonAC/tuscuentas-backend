package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_reporte_liquidez_impuesto database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_liquidez_impuesto")
@NamedQuery(name="DetalleReporteLiquidezImpuesto.findAll", query="SELECT d FROM DetalleReporteLiquidezImpuesto d")
public class DetalleReporteLiquidezImpuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="drli_id")
	private int drliId;

	@Column(name="drli_codcuentacontable")
	private String drliCodcuentacontable;

	@Column(name="drli_fecharegistro")
	private Timestamp drliFecharegistro;

	@Column(name="drli_movimientocredito")
	private String drliMovimientocredito;

	@Column(name="drli_movimientodebito")
	private String drliMovimientodebito;

	@Column(name="drli_nombrecuentacontable")
	private String drliNombrecuentacontable;

	@Column(name="drli_registradopor")
	private String drliRegistradopor;

	@Column(name="drli_saldofinal")
	private String drliSaldofinal;

	@Column(name="drli_saldoinicial")
	private String drliSaldoinicial;

	//bi-directional many-to-one association to MaestroReporteLiquidezImpuesto
	@ManyToOne
	@JoinColumn(name="mrli_id")
	private MaestroReporteLiquidezImpuesto maestroReporteLiquidezImpuesto;

	public DetalleReporteLiquidezImpuesto() {
	}

	public int getDrliId() {
		return this.drliId;
	}

	public void setDrliId(int drliId) {
		this.drliId = drliId;
	}

	public String getDrliCodcuentacontable() {
		return this.drliCodcuentacontable;
	}

	public void setDrliCodcuentacontable(String drliCodcuentacontable) {
		this.drliCodcuentacontable = drliCodcuentacontable;
	}

	public Timestamp getDrliFecharegistro() {
		return this.drliFecharegistro;
	}

	public void setDrliFecharegistro(Timestamp drliFecharegistro) {
		this.drliFecharegistro = drliFecharegistro;
	}

	public String getDrliMovimientocredito() {
		return this.drliMovimientocredito;
	}

	public void setDrliMovimientocredito(String drliMovimientocredito) {
		this.drliMovimientocredito = drliMovimientocredito;
	}

	public String getDrliMovimientodebito() {
		return this.drliMovimientodebito;
	}

	public void setDrliMovimientodebito(String drliMovimientodebito) {
		this.drliMovimientodebito = drliMovimientodebito;
	}

	public String getDrliNombrecuentacontable() {
		return this.drliNombrecuentacontable;
	}

	public void setDrliNombrecuentacontable(String drliNombrecuentacontable) {
		this.drliNombrecuentacontable = drliNombrecuentacontable;
	}

	public String getDrliRegistradopor() {
		return this.drliRegistradopor;
	}

	public void setDrliRegistradopor(String drliRegistradopor) {
		this.drliRegistradopor = drliRegistradopor;
	}

	public String getDrliSaldofinal() {
		return this.drliSaldofinal;
	}

	public void setDrliSaldofinal(String drliSaldofinal) {
		this.drliSaldofinal = drliSaldofinal;
	}

	public String getDrliSaldoinicial() {
		return this.drliSaldoinicial;
	}

	public void setDrliSaldoinicial(String drliSaldoinicial) {
		this.drliSaldoinicial = drliSaldoinicial;
	}

	public MaestroReporteLiquidezImpuesto getMaestroReporteLiquidezImpuesto() {
		return this.maestroReporteLiquidezImpuesto;
	}

	public void setMaestroReporteLiquidezImpuesto(MaestroReporteLiquidezImpuesto maestroReporteLiquidezImpuesto) {
		this.maestroReporteLiquidezImpuesto = maestroReporteLiquidezImpuesto;
	}

}