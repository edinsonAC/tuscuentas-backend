package com.backendtuscuentas.entitys.util;

import java.io.Serializable;

import lombok.Data;

@Data
public class Paso implements Serializable {

	private Long idPaso;
	private String paso;
	private String responsable;
	private String imgResponsable;
	private String fecha;

	public Paso(Long idPaso, String paso, String responsable, String imgResponsable, String fecha) {
		super();
		this.idPaso = idPaso;
		this.paso = paso;
		this.responsable = responsable;
		this.imgResponsable = imgResponsable;
		this.fecha = fecha;
	}

}
