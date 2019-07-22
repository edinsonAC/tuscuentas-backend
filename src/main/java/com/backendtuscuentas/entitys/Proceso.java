package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the proceso database table.
 * 
 */
@Entity
@NamedQuery(name="Proceso.findAll", query="SELECT p FROM Proceso p")
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="proc_id")
	private int procId;

	@Column(name="proc_descripcion")
	private String procDescripcion;

	@Column(name="proc_fecharegistro")
	private Timestamp procFecharegistro;

	@Column(name="proc_impuesto")
	private byte procImpuesto;

	@Column(name="proc_registradopor")
	private String procRegistradopor;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area area;

	//bi-directional many-to-one association to ProcesoEmpresa
	@OneToMany(mappedBy="proceso")
	private List<ProcesoEmpresa> procesoEmpresas;

	//bi-directional many-to-one association to TareaPredeterminada
	@OneToMany(mappedBy="proceso")
	private List<TareaPredeterminada> tareaPredeterminadas;

	//bi-directional many-to-one association to TipoempresaProceso
	@OneToMany(mappedBy="proceso")
	private List<TipoempresaProceso> tipoempresaProcesos;

	public Proceso() {
	}

	public int getProcId() {
		return this.procId;
	}

	public void setProcId(int procId) {
		this.procId = procId;
	}

	public String getProcDescripcion() {
		return this.procDescripcion;
	}

	public void setProcDescripcion(String procDescripcion) {
		this.procDescripcion = procDescripcion;
	}

	public Timestamp getProcFecharegistro() {
		return this.procFecharegistro;
	}

	public void setProcFecharegistro(Timestamp procFecharegistro) {
		this.procFecharegistro = procFecharegistro;
	}

	public byte getProcImpuesto() {
		return this.procImpuesto;
	}

	public void setProcImpuesto(byte procImpuesto) {
		this.procImpuesto = procImpuesto;
	}

	public String getProcRegistradopor() {
		return this.procRegistradopor;
	}

	public void setProcRegistradopor(String procRegistradopor) {
		this.procRegistradopor = procRegistradopor;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<ProcesoEmpresa> getProcesoEmpresas() {
		return this.procesoEmpresas;
	}

	public void setProcesoEmpresas(List<ProcesoEmpresa> procesoEmpresas) {
		this.procesoEmpresas = procesoEmpresas;
	}

	public ProcesoEmpresa addProcesoEmpresa(ProcesoEmpresa procesoEmpresa) {
		getProcesoEmpresas().add(procesoEmpresa);
		procesoEmpresa.setProceso(this);

		return procesoEmpresa;
	}

	public ProcesoEmpresa removeProcesoEmpresa(ProcesoEmpresa procesoEmpresa) {
		getProcesoEmpresas().remove(procesoEmpresa);
		procesoEmpresa.setProceso(null);

		return procesoEmpresa;
	}

	public List<TareaPredeterminada> getTareaPredeterminadas() {
		return this.tareaPredeterminadas;
	}

	public void setTareaPredeterminadas(List<TareaPredeterminada> tareaPredeterminadas) {
		this.tareaPredeterminadas = tareaPredeterminadas;
	}

	public TareaPredeterminada addTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		getTareaPredeterminadas().add(tareaPredeterminada);
		tareaPredeterminada.setProceso(this);

		return tareaPredeterminada;
	}

	public TareaPredeterminada removeTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		getTareaPredeterminadas().remove(tareaPredeterminada);
		tareaPredeterminada.setProceso(null);

		return tareaPredeterminada;
	}

	public List<TipoempresaProceso> getTipoempresaProcesos() {
		return this.tipoempresaProcesos;
	}

	public void setTipoempresaProcesos(List<TipoempresaProceso> tipoempresaProcesos) {
		this.tipoempresaProcesos = tipoempresaProcesos;
	}

	public TipoempresaProceso addTipoempresaProceso(TipoempresaProceso tipoempresaProceso) {
		getTipoempresaProcesos().add(tipoempresaProceso);
		tipoempresaProceso.setProceso(this);

		return tipoempresaProceso;
	}

	public TipoempresaProceso removeTipoempresaProceso(TipoempresaProceso tipoempresaProceso) {
		getTipoempresaProcesos().remove(tipoempresaProceso);
		tipoempresaProceso.setProceso(null);

		return tipoempresaProceso;
	}

}