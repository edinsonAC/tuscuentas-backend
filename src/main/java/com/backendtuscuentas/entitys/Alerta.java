package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;


/**
 * The persistent class for the alertas database table.
 * 
 */
@Data
@Entity
@Table(name="alertas")
public class Alerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="aler_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alerId;

	@Column(name="aler_fecharegistro")
	private Timestamp alerFecharegistro;

	@Column(name="aler_registradopor")
	private String alerRegistradopor;

	//bi-directional many-to-one association to TipoAlerta
	@ManyToOne
	@JoinColumn(name="tial_id")
	private TipoAlerta tipoAlerta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public Alerta() {
	}

}