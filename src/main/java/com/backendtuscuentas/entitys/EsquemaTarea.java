package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the esquema_tarea database table.
 * 
 */
@Data
@Entity
@Table(name = "esquema_tarea")
public class EsquemaTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "esta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estaId;

	@Column(name = "esta_descripcion")
	private String estaDescripcion;

	@Column(name = "esta_fecharegistro")
	private Timestamp estaFecharegistro;

	@Column(name = "esta_registradopor")
	private String estaRegistradopor;

	// bi-directional many-to-one association to TareaPredeterminada
	@JsonIgnore
	@OneToMany(mappedBy = "esquemaTarea")
	private List<TareaPredeterminada> tareaPredeterminadas;

	public EsquemaTarea() {
	}

}