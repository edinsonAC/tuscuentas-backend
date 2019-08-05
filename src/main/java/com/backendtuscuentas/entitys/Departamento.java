package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Data
@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="depa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depaId;

	@Column(name="depa_codigo")
	private String depaCodigo;

	@Column(name="depa_fecharegistro")
	private Timestamp depaFecharegistro;

	@Column(name="depa_nombre")
	private String depaNombre;

	@Column(name="depa_registradopor")
	private String depaRegistradopor;
 
	public Departamento() {
	}

}