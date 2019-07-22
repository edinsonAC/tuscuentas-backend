package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Data
@Entity
@Table(name="municipio")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="muni_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long muniId;

	@Column(name="muni_codigo")
	private String muniCodigo;

	@Column(name="muni_fecharegistro")
	private Timestamp muniFecharegistro;

	@Column(name="muni_nombre")
	private String muniNombre;

	@Column(name="muni_orden")
	private String muniOrden;

	@Column(name="muni_registradopor")
	private String muniRegistradopor;

	//bi-directional many-to-one association to ContadorJuridico
	@OneToMany(mappedBy="municipio")
	private List<ContadorJuridico> contadorJuridicos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="depa_id")
	private Departamento departamento;

	public Municipio() {
	}

}