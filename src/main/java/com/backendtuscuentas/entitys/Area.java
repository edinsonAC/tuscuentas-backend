package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the areas database table.
 * 
 */
@Data
@Entity
@Table(name="areas")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="area_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long areaId;

	@Column(name="area_descripcion")
	private String areaDescripcion;

	@Column(name="area_fecharegistro")
	private Timestamp areaFecharegistro;

	@Column(name="area_registradopor")
	private String areaRegistradopor;

	//bi-directional many-to-one association to Proceso
	@JsonIgnore
	@OneToMany(mappedBy="area")
	private List<Proceso> procesos;

	public Area() {
	}

}