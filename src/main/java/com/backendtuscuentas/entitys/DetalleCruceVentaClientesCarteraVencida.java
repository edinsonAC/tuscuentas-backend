package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_cruce_venta_clientes_cartera_vencida database table.
 * 
 */
@Entity
@Table(name="detalle_cruce_venta_clientes_cartera_vencida")
@NamedQuery(name="DetalleCruceVentaClientesCarteraVencida.findAll", query="SELECT d FROM DetalleCruceVentaClientesCarteraVencida d")
public class DetalleCruceVentaClientesCarteraVencida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dcvc_id")
	private int dcvcId;

	@Column(name="dcvc_diasmora")
	private String dcvcDiasmora;

	@Column(name="dcvc_fecharegistro")
	private Timestamp dcvcFecharegistro;

	@Column(name="dcvc_identificacion")
	private String dcvcIdentificacion;

	@Column(name="dcvc_nombrecliente")
	private String dcvcNombrecliente;

	@Column(name="dcvc_registradopor")
	private String dcvcRegistradopor;

	@Column(name="dcvc_total")
	private String dcvcTotal;

	@Column(name="dcvc_valorbruto")
	private String dcvcValorbruto;

	@Column(name="dcvc_valorvencido")
	private String dcvcValorvencido;

	//bi-directional many-to-one association to MaestroReporteVentaClienteCarteraVencida
	@ManyToOne
	@JoinColumn(name="mvcv_id")
	private MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida;

	public DetalleCruceVentaClientesCarteraVencida() {
	}

	public int getDcvcId() {
		return this.dcvcId;
	}

	public void setDcvcId(int dcvcId) {
		this.dcvcId = dcvcId;
	}

	public String getDcvcDiasmora() {
		return this.dcvcDiasmora;
	}

	public void setDcvcDiasmora(String dcvcDiasmora) {
		this.dcvcDiasmora = dcvcDiasmora;
	}

	public Timestamp getDcvcFecharegistro() {
		return this.dcvcFecharegistro;
	}

	public void setDcvcFecharegistro(Timestamp dcvcFecharegistro) {
		this.dcvcFecharegistro = dcvcFecharegistro;
	}

	public String getDcvcIdentificacion() {
		return this.dcvcIdentificacion;
	}

	public void setDcvcIdentificacion(String dcvcIdentificacion) {
		this.dcvcIdentificacion = dcvcIdentificacion;
	}

	public String getDcvcNombrecliente() {
		return this.dcvcNombrecliente;
	}

	public void setDcvcNombrecliente(String dcvcNombrecliente) {
		this.dcvcNombrecliente = dcvcNombrecliente;
	}

	public String getDcvcRegistradopor() {
		return this.dcvcRegistradopor;
	}

	public void setDcvcRegistradopor(String dcvcRegistradopor) {
		this.dcvcRegistradopor = dcvcRegistradopor;
	}

	public String getDcvcTotal() {
		return this.dcvcTotal;
	}

	public void setDcvcTotal(String dcvcTotal) {
		this.dcvcTotal = dcvcTotal;
	}

	public String getDcvcValorbruto() {
		return this.dcvcValorbruto;
	}

	public void setDcvcValorbruto(String dcvcValorbruto) {
		this.dcvcValorbruto = dcvcValorbruto;
	}

	public String getDcvcValorvencido() {
		return this.dcvcValorvencido;
	}

	public void setDcvcValorvencido(String dcvcValorvencido) {
		this.dcvcValorvencido = dcvcValorvencido;
	}

	public MaestroReporteVentaClienteCarteraVencida getMaestroReporteVentaClienteCarteraVencida() {
		return this.maestroReporteVentaClienteCarteraVencida;
	}

	public void setMaestroReporteVentaClienteCarteraVencida(MaestroReporteVentaClienteCarteraVencida maestroReporteVentaClienteCarteraVencida) {
		this.maestroReporteVentaClienteCarteraVencida = maestroReporteVentaClienteCarteraVencida;
	}

}