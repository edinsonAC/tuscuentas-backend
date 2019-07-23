package com.backendtuscuentas.entitys.util;

import java.io.Serializable;

import lombok.Data;
@Data
public class Alerta implements Serializable {
	private String ejecucion;
	private Long id;
	private String tiloId;
	private String nombre;
	private String usuario;
	private String dias;

	public Alerta(String ejecucion, Long id, String tiloId, String nombre, String usuario,
			String dias) {
		super();
		this.ejecucion = ejecucion;
		this.id = id;
		this.tiloId = tiloId;
		this.nombre = nombre;
		this.usuario = usuario;
		this.dias = dias;
	}

}
