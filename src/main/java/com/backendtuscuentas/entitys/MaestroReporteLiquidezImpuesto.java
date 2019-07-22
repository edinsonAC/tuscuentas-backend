package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the maestro_reporte_liquidez_impuesto database table.
 * 
 */
@Entity
@Table(name="maestro_reporte_liquidez_impuesto")
@NamedQuery(name="MaestroReporteLiquidezImpuesto.findAll", query="SELECT m FROM MaestroReporteLiquidezImpuesto m")
public class MaestroReporteLiquidezImpuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mrli_id")
	private int mrliId;

	@Column(name="mrli_bancohasta")
	private String mrliBancohasta;

	@Column(name="mrli_bancoporcentaje")
	private String mrliBancoporcentaje;

	@Column(name="mrli_bancosdesde")
	private String mrliBancosdesde;

	@Column(name="mrli_cajadesde")
	private String mrliCajadesde;

	@Column(name="mrli_cajahasta")
	private String mrliCajahasta;

	@Column(name="mrli_cajaporcentaje")
	private String mrliCajaporcentaje;

	@Column(name="mrli_carteradesde")
	private String mrliCarteradesde;

	@Column(name="mrli_carterahasta")
	private String mrliCarterahasta;

	@Column(name="mrli_carteraporcentaje")
	private String mrliCarteraporcentaje;

	@Column(name="mrli_fecharegistro")
	private Timestamp mrliFecharegistro;

	@Column(name="mrli_fiduciasdesde")
	private String mrliFiduciasdesde;

	@Column(name="mrli_fiduciashasta")
	private String mrliFiduciashasta;

	@Column(name="mrli_fiduciasporcentaje")
	private String mrliFiduciasporcentaje;

	@Column(name="mrli_registradopor")
	private String mrliRegistradopor;

	//bi-directional many-to-one association to DetalleReporteLiquidezImpuesto
	@OneToMany(mappedBy="maestroReporteLiquidezImpuesto")
	private List<DetalleReporteLiquidezImpuesto> detalleReporteLiquidezImpuestos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public MaestroReporteLiquidezImpuesto() {
	}

	public int getMrliId() {
		return this.mrliId;
	}

	public void setMrliId(int mrliId) {
		this.mrliId = mrliId;
	}

	public String getMrliBancohasta() {
		return this.mrliBancohasta;
	}

	public void setMrliBancohasta(String mrliBancohasta) {
		this.mrliBancohasta = mrliBancohasta;
	}

	public String getMrliBancoporcentaje() {
		return this.mrliBancoporcentaje;
	}

	public void setMrliBancoporcentaje(String mrliBancoporcentaje) {
		this.mrliBancoporcentaje = mrliBancoporcentaje;
	}

	public String getMrliBancosdesde() {
		return this.mrliBancosdesde;
	}

	public void setMrliBancosdesde(String mrliBancosdesde) {
		this.mrliBancosdesde = mrliBancosdesde;
	}

	public String getMrliCajadesde() {
		return this.mrliCajadesde;
	}

	public void setMrliCajadesde(String mrliCajadesde) {
		this.mrliCajadesde = mrliCajadesde;
	}

	public String getMrliCajahasta() {
		return this.mrliCajahasta;
	}

	public void setMrliCajahasta(String mrliCajahasta) {
		this.mrliCajahasta = mrliCajahasta;
	}

	public String getMrliCajaporcentaje() {
		return this.mrliCajaporcentaje;
	}

	public void setMrliCajaporcentaje(String mrliCajaporcentaje) {
		this.mrliCajaporcentaje = mrliCajaporcentaje;
	}

	public String getMrliCarteradesde() {
		return this.mrliCarteradesde;
	}

	public void setMrliCarteradesde(String mrliCarteradesde) {
		this.mrliCarteradesde = mrliCarteradesde;
	}

	public String getMrliCarterahasta() {
		return this.mrliCarterahasta;
	}

	public void setMrliCarterahasta(String mrliCarterahasta) {
		this.mrliCarterahasta = mrliCarterahasta;
	}

	public String getMrliCarteraporcentaje() {
		return this.mrliCarteraporcentaje;
	}

	public void setMrliCarteraporcentaje(String mrliCarteraporcentaje) {
		this.mrliCarteraporcentaje = mrliCarteraporcentaje;
	}

	public Timestamp getMrliFecharegistro() {
		return this.mrliFecharegistro;
	}

	public void setMrliFecharegistro(Timestamp mrliFecharegistro) {
		this.mrliFecharegistro = mrliFecharegistro;
	}

	public String getMrliFiduciasdesde() {
		return this.mrliFiduciasdesde;
	}

	public void setMrliFiduciasdesde(String mrliFiduciasdesde) {
		this.mrliFiduciasdesde = mrliFiduciasdesde;
	}

	public String getMrliFiduciashasta() {
		return this.mrliFiduciashasta;
	}

	public void setMrliFiduciashasta(String mrliFiduciashasta) {
		this.mrliFiduciashasta = mrliFiduciashasta;
	}

	public String getMrliFiduciasporcentaje() {
		return this.mrliFiduciasporcentaje;
	}

	public void setMrliFiduciasporcentaje(String mrliFiduciasporcentaje) {
		this.mrliFiduciasporcentaje = mrliFiduciasporcentaje;
	}

	public String getMrliRegistradopor() {
		return this.mrliRegistradopor;
	}

	public void setMrliRegistradopor(String mrliRegistradopor) {
		this.mrliRegistradopor = mrliRegistradopor;
	}

	public List<DetalleReporteLiquidezImpuesto> getDetalleReporteLiquidezImpuestos() {
		return this.detalleReporteLiquidezImpuestos;
	}

	public void setDetalleReporteLiquidezImpuestos(List<DetalleReporteLiquidezImpuesto> detalleReporteLiquidezImpuestos) {
		this.detalleReporteLiquidezImpuestos = detalleReporteLiquidezImpuestos;
	}

	public DetalleReporteLiquidezImpuesto addDetalleReporteLiquidezImpuesto(DetalleReporteLiquidezImpuesto detalleReporteLiquidezImpuesto) {
		getDetalleReporteLiquidezImpuestos().add(detalleReporteLiquidezImpuesto);
		detalleReporteLiquidezImpuesto.setMaestroReporteLiquidezImpuesto(this);

		return detalleReporteLiquidezImpuesto;
	}

	public DetalleReporteLiquidezImpuesto removeDetalleReporteLiquidezImpuesto(DetalleReporteLiquidezImpuesto detalleReporteLiquidezImpuesto) {
		getDetalleReporteLiquidezImpuestos().remove(detalleReporteLiquidezImpuesto);
		detalleReporteLiquidezImpuesto.setMaestroReporteLiquidezImpuesto(null);

		return detalleReporteLiquidezImpuesto;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}