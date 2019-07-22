package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cargoporcargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargoporcargo.findAll", query="SELECT c FROM Cargoporcargo c")
public class Cargoporcargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cpc_id")
	private int cpcId;

	//bi-directional many-to-one association to CargoEmpresa
	@ManyToOne
	@JoinColumn(name="cpc_principal")
	private CargoEmpresa cargoEmpresa1;

	//bi-directional many-to-one association to CargoEmpresa
	@ManyToOne
	@JoinColumn(name="cpc_segundario")
	private CargoEmpresa cargoEmpresa2;

	public Cargoporcargo() {
	}

	public int getCpcId() {
		return this.cpcId;
	}

	public void setCpcId(int cpcId) {
		this.cpcId = cpcId;
	}

	public CargoEmpresa getCargoEmpresa1() {
		return this.cargoEmpresa1;
	}

	public void setCargoEmpresa1(CargoEmpresa cargoEmpresa1) {
		this.cargoEmpresa1 = cargoEmpresa1;
	}

	public CargoEmpresa getCargoEmpresa2() {
		return this.cargoEmpresa2;
	}

	public void setCargoEmpresa2(CargoEmpresa cargoEmpresa2) {
		this.cargoEmpresa2 = cargoEmpresa2;
	}

}