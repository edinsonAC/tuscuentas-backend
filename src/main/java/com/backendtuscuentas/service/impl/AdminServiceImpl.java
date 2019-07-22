package com.backendtuscuentas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendtuscuentas.dao.IContadorJuridicoDAO;
import com.backendtuscuentas.dao.IEmpresaDAO;
import com.backendtuscuentas.dao.UsuarioDAO;
import com.backendtuscuentas.entitys.util.Totales;
import com.backendtuscuentas.services.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	UsuarioDAO usuarioDao;

	@Autowired
	IEmpresaDAO empresaDao;

	@Autowired
	IContadorJuridicoDAO contadorDao;

	@Override
	public Totales totalesAdmin() {
		Totales total = new Totales();

		total.setEmpresas(empresaDao.totalEmpresas());
		total.setContadores(contadorDao.totalContadores());
		total.setUsuarios(usuarioDao.totalUsuarios());

		return total;
	}

}
