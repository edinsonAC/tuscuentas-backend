package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the dias database table.
 * 
 */
@Entity
@Table(name="dias")
@NamedQuery(name="Dia.findAll", query="SELECT d FROM Dia d")
public class Dia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dias_id")
	private int diasId;

	@Column(name="dias_diasemana")
	private int diasDiasemana;

	@Column(name="dias_fecharegistro")
	private Timestamp diasFecharegistro;

	@Temporal(TemporalType.DATE)
	@Column(name="dias_fechas")
	private Date diasFechas;

	@Column(name="dias_registradopor")
	private String diasRegistradopor;

	public Dia() {
	}

	public int getDiasId() {
		return this.diasId;
	}

	public void setDiasId(int diasId) {
		this.diasId = diasId;
	}

	public int getDiasDiasemana() {
		return this.diasDiasemana;
	}

	public void setDiasDiasemana(int diasDiasemana) {
		this.diasDiasemana = diasDiasemana;
	}

	public Timestamp getDiasFecharegistro() {
		return this.diasFecharegistro;
	}

	public void setDiasFecharegistro(Timestamp diasFecharegistro) {
		this.diasFecharegistro = diasFecharegistro;
	}

	public Date getDiasFechas() {
		return this.diasFechas;
	}

	public void setDiasFechas(Date diasFechas) {
		this.diasFechas = diasFechas;
	}

	public String getDiasRegistradopor() {
		return this.diasRegistradopor;
	}

	public void setDiasRegistradopor(String diasRegistradopor) {
		this.diasRegistradopor = diasRegistradopor;
	}

}