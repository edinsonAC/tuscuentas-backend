package com.backendtuscuentas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendtuscuentas.dao.IContadorJuridicoDAO;
import com.backendtuscuentas.dao.IEjecucionTareaDAO;
import com.backendtuscuentas.entitys.util.Totales;
import com.backendtuscuentas.services.IContadorService;

@Service
public class ContadorServiceImpl implements IContadorService {

	@Autowired
	IContadorJuridicoDAO contadorDao;

	@Autowired
	IEjecucionTareaDAO ejecucionDao;

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
			totalTareas.setProximas(0);
		}

		return totalTareas;
	}

}
