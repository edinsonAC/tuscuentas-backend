package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calendario_fechas database table.
 * 
 */
@Entity
@Table(name="calendario_fechas")
@NamedQuery(name="CalendarioFecha.findAll", query="SELECT c FROM CalendarioFecha c")
public class CalendarioFecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cafe_id")
	private int cafeId;

	@Column(name="cafe_descripcion")
	private String cafeDescripcion;

	@Column(name="cafe_fecharegistro")
	private Timestamp cafeFecharegistro;

	@Column(name="cafe_registradopor")
	private String cafeRegistradopor;

	//bi-directional many-to-one association to EjecucionProxima
	@OneToMany(mappedBy="calendarioFecha")
	private List<EjecucionProxima> ejecucionProximas;

	//bi-directional many-to-one association to TareaPredeterminada
	@OneToMany(mappedBy="calendarioFecha")
	private List<TareaPredeterminada> tareaPredeterminadas;

	public CalendarioFecha() {
	}

	public int getCafeId() {
		return this.cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeDescripcion() {
		return this.cafeDescripcion;
	}

	public void setCafeDescripcion(String cafeDescripcion) {
		this.cafeDescripcion = cafeDescripcion;
	}

	public Timestamp getCafeFecharegistro() {
		return this.cafeFecharegistro;
	}

	public void setCafeFecharegistro(Timestamp cafeFecharegistro) {
		this.cafeFecharegistro = cafeFecharegistro;
	}

	public String getCafeRegistradopor() {
		return this.cafeRegistradopor;
	}

	public void setCafeRegistradopor(String cafeRegistradopor) {
		this.cafeRegistradopor = cafeRegistradopor;
	}

	public List<EjecucionProxima> getEjecucionProximas() {
		return this.ejecucionProximas;
	}

	public void setEjecucionProximas(List<EjecucionProxima> ejecucionProximas) {
		this.ejecucionProximas = ejecucionProximas;
	}

	public EjecucionProxima addEjecucionProxima(EjecucionProxima ejecucionProxima) {
		getEjecucionProximas().add(ejecucionProxima);
		ejecucionProxima.setCalendarioFecha(this);

		return ejecucionProxima;
	}

	public EjecucionProxima removeEjecucionProxima(EjecucionProxima ejecucionProxima) {
		getEjecucionProximas().remove(ejecucionProxima);
		ejecucionProxima.setCalendarioFecha(null);

		return ejecucionProxima;
	}

	public List<TareaPredeterminada> getTareaPredeterminadas() {
		return this.tareaPredeterminadas;
	}

	public void setTareaPredeterminadas(List<TareaPredeterminada> tareaPredeterminadas) {
		this.tareaPredeterminadas = tareaPredeterminadas;
	}

	public TareaPredeterminada addTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		getTareaPredeterminadas().add(tareaPredeterminada);
		tareaPredeterminada.setCalendarioFecha(this);

		return tareaPredeterminada;
	}

	public TareaPredeterminada removeTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		getTareaPredeterminadas().remove(tareaPredeterminada);
		tareaPredeterminada.setCalendarioFecha(null);

		return tareaPredeterminada;
	}

}