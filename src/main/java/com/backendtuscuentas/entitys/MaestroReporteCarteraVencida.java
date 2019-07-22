package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the maestro_reporte_cartera_vencida database table.
 * 
 */
@Entity
@Table(name="maestro_reporte_cartera_vencida")
@NamedQuery(name="MaestroReporteCarteraVencida.findAll", query="SELECT m FROM MaestroReporteCarteraVencida m")
public class MaestroReporteCarteraVencida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mrcv_id")
	private int mrcvId;

	@Column(name="mrcv_edadcartera")
	private int mrcvEdadcartera;

	@Column(name="mrcv_fecharegistro")
	private Timestamp mrcvFecharegistro;

	@Column(name="mrcv_registradopor")
	private String mrcvRegistradopor;

	@Column(name="mrcv_valorvencido")
	private int mrcvValorvencido;

	//bi-directional many-to-one association to DetalleReporteCarteraVencida
	@OneToMany(mappedBy="maestroReporteCarteraVencida")
	private List<DetalleReporteCarteraVencida> detalleReporteCarteraVencidas;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public MaestroReporteCarteraVencida() {
	}

	public int getMrcvId() {
		return this.mrcvId;
	}

	public void setMrcvId(int mrcvId) {
		this.mrcvId = mrcvId;
	}

	public int getMrcvEdadcartera() {
		return this.mrcvEdadcartera;
	}

	public void setMrcvEdadcartera(int mrcvEdadcartera) {
		this.mrcvEdadcartera = mrcvEdadcartera;
	}

	public Timestamp getMrcvFecharegistro() {
		return this.mrcvFecharegistro;
	}

	public void setMrcvFecharegistro(Timestamp mrcvFecharegistro) {
		this.mrcvFecharegistro = mrcvFecharegistro;
	}

	public String getMrcvRegistradopor() {
		return this.mrcvRegistradopor;
	}

	public void setMrcvRegistradopor(String mrcvRegistradopor) {
		this.mrcvRegistradopor = mrcvRegistradopor;
	}

	public int getMrcvValorvencido() {
		return this.mrcvValorvencido;
	}

	public void setMrcvValorvencido(int mrcvValorvencido) {
		this.mrcvValorvencido = mrcvValorvencido;
	}

	public List<DetalleReporteCarteraVencida> getDetalleReporteCarteraVencidas() {
		return this.detalleReporteCarteraVencidas;
	}

	public void setDetalleReporteCarteraVencidas(List<DetalleReporteCarteraVencida> detalleReporteCarteraVencidas) {
		this.detalleReporteCarteraVencidas = detalleReporteCarteraVencidas;
	}

	public DetalleReporteCarteraVencida addDetalleReporteCarteraVencida(DetalleReporteCarteraVencida detalleReporteCarteraVencida) {
		getDetalleReporteCarteraVencidas().add(detalleReporteCarteraVencida);
		detalleReporteCarteraVencida.setMaestroReporteCarteraVencida(this);

		return detalleReporteCarteraVencida;
	}

	public DetalleReporteCarteraVencida removeDetalleReporteCarteraVencida(DetalleReporteCarteraVencida detalleReporteCarteraVencida) {
		getDetalleReporteCarteraVencidas().remove(detalleReporteCarteraVencida);
		detalleReporteCarteraVencida.setMaestroReporteCarteraVencida(null);

		return detalleReporteCarteraVencida;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}