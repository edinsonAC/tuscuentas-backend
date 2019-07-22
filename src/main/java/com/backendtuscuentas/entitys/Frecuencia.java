package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the frecuencia database table.
 * 
 */
@Data
@Entity
@Table(name="frecuencia")
public class Frecuencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="frec_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long frecId;

	@Column(name="frec_descripcion")
	private String frecDescripcion;

	@Column(name="frec_dias")
	private int frecDias;

	@Column(name="frec_fecharegistro")
	private Timestamp frecFecharegistro;

	@Column(name="frec_registradopor")
	private String frecRegistradopor;

	//bi-directional many-to-one association to AlertaTempranaEmpresa
	@OneToMany(mappedBy="frecuencia")
	private List<AlertaTempranaEmpresa> alertaTempranaEmpresas;

	public Frecuencia() {
	}

}