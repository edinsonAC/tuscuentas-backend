package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_recurrencia database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_recurrencia")
public class TipoRecurrencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tire_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tireId;

	@Column(name="tire_descripcion")
	private String tireDescripcion;

	@Column(name="tire_fecharegistro")
	private Timestamp tireFecharegistro;

	@Column(name="tire_registradopor")
	private String tireRegistradopor;

	public TipoRecurrencia() {
	}


}