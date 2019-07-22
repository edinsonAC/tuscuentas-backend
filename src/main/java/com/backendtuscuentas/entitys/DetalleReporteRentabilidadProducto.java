package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_reporte_rentabilidad_producto database table.
 * 
 */
@Entity
@Table(name="detalle_reporte_rentabilidad_producto")
@NamedQuery(name="DetalleReporteRentabilidadProducto.findAll", query="SELECT d FROM DetalleReporteRentabilidadProducto d")
public class DetalleReporteRentabilidadProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="drrp_id")
	private int drrpId;

	@Column(name="drrp_cantidadvendida")
	private String drrpCantidadvendida;

	@Column(name="drrp_codproducto")
	private String drrpCodproducto;

	@Column(name="drrp_costostotales")
	private int drrpCostostotales;

	@Column(name="drrp_grupoinventario")
	private String drrpGrupoinventario;

	@Column(name="drrp_nombreproducto")
	private String drrpNombreproducto;

	@Column(name="drrp_referenciafabrica")
	private String drrpReferenciafabrica;

	@Column(name="drrp_rentabilidadporcentaje")
	private int drrpRentabilidadporcentaje;

	@Column(name="drrp_utilidadpeso")
	private int drrpUtilidadpeso;

	@Column(name="drrp_utilidadprocentaje")
	private int drrpUtilidadprocentaje;

	@Column(name="drrp_ventasbrutastotales")
	private double drrpVentasbrutastotales;

	//bi-directional many-to-one association to MaestroReporteRentabilidadProducto
	@ManyToOne
	@JoinColumn(name="mrrp_id")
	private MaestroReporteRentabilidadProducto maestroReporteRentabilidadProducto;

	public DetalleReporteRentabilidadProducto() {
	}

	public int getDrrpId() {
		return this.drrpId;
	}

	public void setDrrpId(int drrpId) {
		this.drrpId = drrpId;
	}

	public String getDrrpCantidadvendida() {
		return this.drrpCantidadvendida;
	}

	public void setDrrpCantidadvendida(String drrpCantidadvendida) {
		this.drrpCantidadvendida = drrpCantidadvendida;
	}

	public String getDrrpCodproducto() {
		return this.drrpCodproducto;
	}

	public void setDrrpCodproducto(String drrpCodproducto) {
		this.drrpCodproducto = drrpCodproducto;
	}

	public int getDrrpCostostotales() {
		return this.drrpCostostotales;
	}

	public void setDrrpCostostotales(int drrpCostostotales) {
		this.drrpCostostotales = drrpCostostotales;
	}

	public String getDrrpGrupoinventario() {
		return this.drrpGrupoinventario;
	}

	public void setDrrpGrupoinventario(String drrpGrupoinventario) {
		this.drrpGrupoinventario = drrpGrupoinventario;
	}

	public String getDrrpNombreproducto() {
		return this.drrpNombreproducto;
	}

	public void setDrrpNombreproducto(String drrpNombreproducto) {
		this.drrpNombreproducto = drrpNombreproducto;
	}

	public String getDrrpReferenciafabrica() {
		return this.drrpReferenciafabrica;
	}

	public void setDrrpReferenciafabrica(String drrpReferenciafabrica) {
		this.drrpReferenciafabrica = drrpReferenciafabrica;
	}

	public int getDrrpRentabilidadporcentaje() {
		return this.drrpRentabilidadporcentaje;
	}

	public void setDrrpRentabilidadporcentaje(int drrpRentabilidadporcentaje) {
		this.drrpRentabilidadporcentaje = drrpRentabilidadporcentaje;
	}

	public int getDrrpUtilidadpeso() {
		return this.drrpUtilidadpeso;
	}

	public void setDrrpUtilidadpeso(int drrpUtilidadpeso) {
		this.drrpUtilidadpeso = drrpUtilidadpeso;
	}

	public int getDrrpUtilidadprocentaje() {
		return this.drrpUtilidadprocentaje;
	}

	public void setDrrpUtilidadprocentaje(int drrpUtilidadprocentaje) {
		this.drrpUtilidadprocentaje = drrpUtilidadprocentaje;
	}

	public double getDrrpVentasbrutastotales() {
		return this.drrpVentasbrutastotales;
	}

	public void setDrrpVentasbrutastotales(double drrpVentasbrutastotales) {
		this.drrpVentasbrutastotales = drrpVentasbrutastotales;
	}

	public MaestroReporteRentabilidadProducto getMaestroReporteRentabilidadProducto() {
		return this.maestroReporteRentabilidadProducto;
	}

	public void setMaestroReporteRentabilidadProducto(MaestroReporteRentabilidadProducto maestroReporteRentabilidadProducto) {
		this.maestroReporteRentabilidadProducto = maestroReporteRentabilidadProducto;
	}

}