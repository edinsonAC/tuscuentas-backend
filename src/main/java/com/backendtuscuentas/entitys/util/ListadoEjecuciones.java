package com.backendtuscuentas.entitys.util;

import java.io.Serializable;

import lombok.Data;

@Data
public class ListadoEjecuciones implements Serializable {

	private Long IdEjecucion;
	private String fechaInicial;
	private String fechaFinal;
	private String tarea;
	private String paso;
	private String usuario;
	private Long leido;
	private Long dias;
	private String empresa;

	public ListadoEjecuciones(Long idEjecucion, String fechaInicial, String fechaFinal, String tarea, String paso,
			String usuario, Long leido, Long dias, String empresa) {
		super();
		IdEjecucion = idEjecucion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.tarea = tarea;
		this.paso = paso;
		this.usuario = usuario;
		this.leido = leido;
		this.dias = dias;
		this.empresa = empresa;
	}

}
