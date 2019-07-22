package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the maestro_reporte_venta_cliente_cartera_vencida database table.
 * 
 */
@Entity
@Table(name="maestro_reporte_venta_cliente_cartera_vencida")
@NamedQuery(name="MaestroReporteVentaClienteCarteraVencida.findAll", query="SELECT m FROM MaestroReporteVentaClienteCarteraVencida m")
public class MaestroReporteVentaClienteCarteraVencida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mvcv_id")
	private int mvcvId;

	@Column(name="mvcv_fecharegistro")
	private Timestamp mvcvFecharegistro;

	@Column(name="mvcv_registradopor")
	private String mvcvRegistradopor;

	@Column(name="mvcv_valorvencido")
	private int mvcvValorvencido;

	//bi-directional many-to-one association to DetalleCruceVentaClientesCarteraVencida
	@OneToMany(mappedBy="maestroReporteVentaClienteCarteraVencida")
	private List<DetalleCruceVentaClientesCarteraVencida> detalleCruceVentaClientesCarteraVencidas;

	//bi-directional many-to-one association to DetalleReporteVentaClienteCarteraVencida
	@OneToMany(mappedBy="maestroReporteVentaClienteCarteraVencida")
	private List<DetalleReporteVentaClienteCarteraVencida> detalleReporteVentaClienteCarteraVencidas;

	//bi-directional many-to-one association to DetalleReporteVentaDia
	@OneToMany(mappedBy="maestroReporteVentaClienteCarteraVencida")
	private List<DetalleReporteVentaDia> detalleReporteVentaDias;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public MaestroReporteVentaClienteCarteraVencida() {
	}

	public int getMvcvId() {
		return this.mvcvId;
	}

	public void setMvcvId(int mvcvId) {
		this.mvcvId = mvcvId;
	}

	public Timestamp getMvcvFecharegistro() {
		return this.mvcvFecharegistro;
	}

	public void setMvcvFecharegistro(Timestamp mvcvFecharegistro) {
		this.mvcvFecharegistro = mvcvFecharegistro;
	}

	public String getMvcvRegistradopor() {
		return this.mvcvRegistradopor;
	}

	public void setMvcvRegistradopor(String mvcvRegistradopor) {
		this.mvcvRegistradopor = mvcvRegistradopor;
	}

	public int getMvcvValorvencido() {
		return this.mvcvValorvencido;
	}

	public void setMvcvValorvencido(int mvcvValorvencido) {
		this.mvcvValorvencido = mvcvValorvencido;
	}

	public List<DetalleCruceVentaClientesCarteraVencida> getDetalleCruceVentaClientesCarteraVencidas() {
		return this.detalleCruceVentaClientesCarteraVencidas;
	}

	public void setDetalleCruceVentaClientesCarteraVencidas(List<DetalleCruceVentaClientesCarteraVencida> detalleCruceVentaClientesCarteraVencidas) {
		this.detalleCruceVentaClientesCarteraVencidas = detalleCruceVentaClientesCarteraVencidas;
	}

	public DetalleCruceVentaClientesCarteraVencida addDetalleCruceVentaClientesCarteraVencida(DetalleCruceVentaClientesCarteraVencida detalleCruceVentaClientesCarteraVencida) {
		getDetalleCruceVentaClientesCarteraVencidas().add(detalleCruceVentaClientesCarteraVencida);
		detalleCruceVentaClientesCarteraVencida.setMaestroReporteVentaClienteCarteraVencida(this);

		return detalleCruceVentaClientesCarteraVencida;
	}

	public DetalleCruceVentaClientesCarteraVencida removeDetalleCruceVentaClientesCarteraVencida(DetalleCruceVentaClientesCarteraVencida detalleCruceVentaClientesCarteraVencida) {
		getDetalleCruceVentaClientesCarteraVencidas().remove(detalleCruceVentaClientesCarteraVencida);
		detalleCruceVentaClientesCarteraVencida.setMaestroReporteVentaClienteCarteraVencida(null);

		return detalleCruceVentaClientesCarteraVencida;
	}

	public List<DetalleReporteVentaClienteCarteraVencida> getDetalleReporteVentaClienteCarteraVencidas() {
		return this.detalleReporteVentaClienteCarteraVencidas;
	}

	public void setDetalleReporteVentaClienteCarteraVencidas(List<DetalleReporteVentaClienteCarteraVencida> detalleReporteVentaClienteCarteraVencidas) {
		this.detalleReporteVentaClienteCarteraVencidas = detalleReporteVentaClienteCarteraVencidas;
	}

	public DetalleReporteVentaClienteCarteraVencida addDetalleReporteVentaClienteCarteraVencida(DetalleReporteVentaClienteCarteraVencida detalleReporteVentaClienteCarteraVencida) {
		getDetalleReporteVentaClienteCarteraVencidas().add(detalleReporteVentaClienteCarteraVencida);
		detalleReporteVentaClienteCarteraVencida.setMaestroReporteVentaClienteCarteraVencida(this);

		return detalleReporteVentaClienteCarteraVencida;
	}

	public DetalleReporteVentaClienteCarteraVencida removeDetalleReporteVentaClienteCarteraVencida(DetalleReporteVentaClienteCarteraVencida detalleReporteVentaClienteCarteraVencida) {
		getDetalleReporteVentaClienteCarteraVencidas().remove(detalleReporteVentaClienteCarteraVencida);
		detalleReporteVentaClienteCarteraVencida.setMaestroReporteVentaClienteCarteraVencida(null);

		return detalleReporteVentaClienteCarteraVencida;
	}

	public List<DetalleReporteVentaDia> getDetalleReporteVentaDias() {
		return this.detalleReporteVentaDias;
	}

	public void setDetalleReporteVentaDias(List<DetalleReporteVentaDia> detalleReporteVentaDias) {
		this.detalleReporteVentaDias = detalleReporteVentaDias;
	}

	public DetalleReporteVentaDia addDetalleReporteVentaDia(DetalleReporteVentaDia detalleReporteVentaDia) {
		getDetalleReporteVentaDias().add(detalleReporteVentaDia);
		detalleReporteVentaDia.setMaestroReporteVentaClienteCarteraVencida(this);

		return detalleReporteVentaDia;
	}

	public DetalleReporteVentaDia removeDetalleReporteVentaDia(DetalleReporteVentaDia detalleReporteVentaDia) {
		getDetalleReporteVentaDias().remove(detalleReporteVentaDia);
		detalleReporteVentaDia.setMaestroReporteVentaClienteCarteraVencida(null);

		return detalleReporteVentaDia;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}