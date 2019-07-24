package com.backendtuscuentas.entitys.util;

import lombok.Data;

@Data
public class ListadoEmpresa {

	private Long idEmpresa;
	private String nombreEmpresa;

	public ListadoEmpresa(Long idEmpresa, String nombreEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
	}

}
