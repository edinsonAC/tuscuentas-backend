package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ejecucion_proxima database table.
 * 
 */
@Entity
@Table(name="ejecucion_proxima")
@NamedQuery(name="EjecucionProxima.findAll", query="SELECT e FROM EjecucionProxima e")
public class EjecucionProxima implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ejpr_id")
	private int ejprId;

	@Column(name="ejpr_fechainicial")
	private String ejprFechainicial;

	@Column(name="ejta_codejecucion")
	private int ejtaCodejecucion;

	//bi-directional many-to-one association to CalendarioFecha
	@ManyToOne
	@JoinColumn(name="cafe_id")
	private CalendarioFecha calendarioFecha;

	//bi-directional many-to-one association to TareaEmpresa
	@ManyToOne
	@JoinColumn(name="taem_id")
	private TareaEmpresa tareaEmpresa;

	public EjecucionProxima() {
	}

	public int getEjprId() {
		return this.ejprId;
	}

	public void setEjprId(int ejprId) {
		this.ejprId = ejprId;
	}

	public String getEjprFechainicial() {
		return this.ejprFechainicial;
	}

	public void setEjprFechainicial(String ejprFechainicial) {
		this.ejprFechainicial = ejprFechainicial;
	}

	public int getEjtaCodejecucion() {
		return this.ejtaCodejecucion;
	}

	public void setEjtaCodejecucion(int ejtaCodejecucion) {
		this.ejtaCodejecucion = ejtaCodejecucion;
	}

	public CalendarioFecha getCalendarioFecha() {
		return this.calendarioFecha;
	}

	public void setCalendarioFecha(CalendarioFecha calendarioFecha) {
		this.calendarioFecha = calendarioFecha;
	}

	public TareaEmpresa getTareaEmpresa() {
		return this.tareaEmpresa;
	}

	public void setTareaEmpresa(TareaEmpresa tareaEmpresa) {
		this.tareaEmpresa = tareaEmpresa;
	}

}