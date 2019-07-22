package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the banco database table.
 * 
 */
@Data
@Entity
@Table(name="municipio")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="banc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bancId;

	@Column(name="banc_fecharegistro")
	private Timestamp bancFecharegistro;

	@Column(name="banc_nombre")
	private String bancNombre;

	@Column(name="banc_registradopor")
	private String bancRegistradopor;

	//bi-directional many-to-one association to ContadorJuridico
	@OneToMany(mappedBy="banco")
	private List<ContadorJuridico> contadorJuridicos;

	public Banco() {
	}

}