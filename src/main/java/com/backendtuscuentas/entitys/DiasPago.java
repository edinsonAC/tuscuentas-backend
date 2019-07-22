package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dias_pago database table.
 * 
 */
@Entity
@Table(name="dias_pago")
@NamedQuery(name="DiasPago.findAll", query="SELECT d FROM DiasPago d")
public class DiasPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dipa_id")
	private int dipaId;

	@Column(name="dipa_dia")
	private String dipaDia;

	@Column(name="dipa_fecharegistro")
	private Timestamp dipaFecharegistro;

	@Column(name="dipa_registradopor")
	private String dipaRegistradopor;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	//bi-directional many-to-one association to PagoNomina
	@ManyToOne
	@JoinColumn(name="pano_id")
	private PagoNomina pagoNomina;

	public DiasPago() {
	}

	public int getDipaId() {
		return this.dipaId;
	}

	public void setDipaId(int dipaId) {
		this.dipaId = dipaId;
	}

	public String getDipaDia() {
		return this.dipaDia;
	}

	public void setDipaDia(String dipaDia) {
		this.dipaDia = dipaDia;
	}

	public Timestamp getDipaFecharegistro() {
		return this.dipaFecharegistro;
	}

	public void setDipaFecharegistro(Timestamp dipaFecharegistro) {
		this.dipaFecharegistro = dipaFecharegistro;
	}

	public String getDipaRegistradopor() {
		return this.dipaRegistradopor;
	}

	public void setDipaRegistradopor(String dipaRegistradopor) {
		this.dipaRegistradopor = dipaRegistradopor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public PagoNomina getPagoNomina() {
		return this.pagoNomina;
	}

	public void setPagoNomina(PagoNomina pagoNomina) {
		this.pagoNomina = pagoNomina;
	}

}