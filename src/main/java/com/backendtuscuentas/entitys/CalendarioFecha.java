package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calendario_fechas database table.
 * 
 */
@Data
@Entity
@Table(name="calendario_fechas")
public class CalendarioFecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cafe_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cafeId;

	@Column(name="cafe_descripcion")
	private String cafeDescripcion;

	@Column(name="cafe_fecharegistro")
	private Timestamp cafeFecharegistro;

	@Column(name="cafe_registradopor")
	private String cafeRegistradopor;

	//bi-directional many-to-one association to EjecucionProxima
	@JsonIgnore
	@OneToMany(mappedBy="calendarioFecha")
	private List<EjecucionProxima> ejecucionProximas;

	//bi-directional many-to-one association to TareaPredeterminada
	@JsonIgnore
	@OneToMany(mappedBy="calendarioFecha")
	private List<TareaPredeterminada> tareaPredeterminadas;

	public CalendarioFecha() {
	}


}