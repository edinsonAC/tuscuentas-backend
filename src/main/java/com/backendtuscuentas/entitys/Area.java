package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the areas database table.
 * 
 */
@Entity
@Table(name="areas")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="area_id")
	private int areaId;

	@Column(name="area_descripcion")
	private String areaDescripcion;

	@Column(name="area_fecharegistro")
	private Timestamp areaFecharegistro;

	@Column(name="area_registradopor")
	private String areaRegistradopor;

	//bi-directional many-to-one association to Proceso
	@OneToMany(mappedBy="area")
	private List<Proceso> procesos;

	public Area() {
	}

	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaDescripcion() {
		return this.areaDescripcion;
	}

	public void setAreaDescripcion(String areaDescripcion) {
		this.areaDescripcion = areaDescripcion;
	}

	public Timestamp getAreaFecharegistro() {
		return this.areaFecharegistro;
	}

	public void setAreaFecharegistro(Timestamp areaFecharegistro) {
		this.areaFecharegistro = areaFecharegistro;
	}

	public String getAreaRegistradopor() {
		return this.areaRegistradopor;
	}

	public void setAreaRegistradopor(String areaRegistradopor) {
		this.areaRegistradopor = areaRegistradopor;
	}

	public List<Proceso> getProcesos() {
		return this.procesos;
	}

	public void setProcesos(List<Proceso> procesos) {
		this.procesos = procesos;
	}

	public Proceso addProceso(Proceso proceso) {
		getProcesos().add(proceso);
		proceso.setArea(this);

		return proceso;
	}

	public Proceso removeProceso(Proceso proceso) {
		getProcesos().remove(proceso);
		proceso.setArea(null);

		return proceso;
	}

}