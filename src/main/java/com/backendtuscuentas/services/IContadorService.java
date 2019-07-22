package com.backendtuscuentas.services;

import com.backendtuscuentas.entitys.util.Totales;

public interface IContadorService {

	public long totalContadores();

	public Totales calcularTotalesTareas(long idUsuario, long idEmpresa);
}
