package com.backendtuscuentas.services;

import java.util.ArrayList;

import com.backendtuscuentas.entitys.util.ListadoEmpresa;
import com.backendtuscuentas.entitys.util.Totales;

public interface IContadorService {

	public long totalContadores();

	public Totales calcularTotalesTareas(long idUsuario, long idEmpresa);
	
	public ArrayList<ListadoEmpresa> listarEmpresaBasicaPorContador(long id);
}
