package com.backendtuscuentas.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendtuscuentas.dao.IContadorJuridicoDAO;
import com.backendtuscuentas.dao.IEjecucionTareaDAO;
import com.backendtuscuentas.dao.IEmpresaDAO;
import com.backendtuscuentas.entitys.util.Constantes;
import com.backendtuscuentas.entitys.util.ListadoEmpresa;
import com.backendtuscuentas.entitys.util.Totales;
import com.backendtuscuentas.services.IContadorService;
import com.backendtuscuentas.services.IUsuarioService;

@Service
public class ContadorServiceImpl implements IContadorService {

	@Autowired
	IContadorJuridicoDAO contadorDao;

	@Autowired
	IEjecucionTareaDAO ejecucionDao;

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	IEmpresaDAO empresaDao;

	@Override
	public long totalContadores() {
		// TODO Auto-generated method stub
		return contadorDao.totalContadores();
	}

	@Override
	public Totales calcularTotalesTareas(long idUsuario, long idEmpresa) {
		Totales totalTareas = new Totales();
		if (idEmpresa == 0) {
			totalTareas.setAbiertas(
					ejecucionDao.calcularTareasAbiertasAndAtrasadasDelMesParaContador(idUsuario, idUsuario, 1));
			totalTareas.setAtrasadas(
					ejecucionDao.calcularTareasAbiertasAndAtrasadasDelMesParaContador(idUsuario, idUsuario, 2));
			totalTareas.setCerradas(ejecucionDao.calcularTareasCerradasPorContador(3, idUsuario, idUsuario));
			totalTareas.setObservadas(ejecucionDao.calcularTareasObservadasPorContador(idUsuario));
			totalTareas.setProximas(usuarioService.listarEjecucionesProximas(idUsuario, idEmpresa).size());

		} else {
			totalTareas.setAbiertas(ejecucionDao.calcularTareasAbiertasAndAtrasadasDelMesEmpresaParaContador(idUsuario,
					idUsuario, 1, idEmpresa));
			totalTareas.setAtrasadas(ejecucionDao.calcularTareasAbiertasAndAtrasadasDelMesEmpresaParaContador(idUsuario,
					idUsuario, 2, idEmpresa));
			totalTareas.setCerradas(ejecucionDao.calcularTareasCerradasPorContadorPorEmpresa(3, idUsuario, idEmpresa));
			totalTareas.setObservadas(ejecucionDao.calcularTareasObservadasPorContadorPorEmpresa(idUsuario, idEmpresa));
			totalTareas.setProximas(usuarioService.listarEjecucionesProximas(idUsuario, idEmpresa).size());

		}

		return totalTareas;
	}

	@Override
	public ArrayList<ListadoEmpresa> listarEmpresaBasicaPorContador(long id) {
		ArrayList<Object[]> emp = new ArrayList<>();
		ArrayList<ListadoEmpresa> empresas = new ArrayList<>();

		emp = empresaDao.listarEmpresasPorContador(id, Constantes.ID_CARGO_CONTADOR, id);

		if (emp != null) {
			for (Object[] object : emp) {
				empresas.add(new ListadoEmpresa(new Long((Integer) object[0]), (String) object[1]));
			}
		}
		return empresas;
	}

}
