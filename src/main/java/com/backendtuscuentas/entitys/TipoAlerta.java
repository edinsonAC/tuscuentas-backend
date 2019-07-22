package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_alertas database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_alertas")
public class TipoAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tial_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tialId;

	@Column(name="tial_descripcion")
	private String tialDescripcion;

	@Column(name="tial_fecharegistro")
	private Timestamp tialFecharegistro;

	@Column(name="tial_registradopor")
	private String tialRegistradopor;

	//bi-directional many-to-one association to Alerta
	@OneToMany(mappedBy="tipoAlerta")
	private List<Alerta> alertas;

	public TipoAlerta() {
	}

}