package com.backendtuscuentas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendtuscuentas.dao.IEmpresaDAO;
import com.backendtuscuentas.services.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	IEmpresaDAO empresaDao;
	
	@Override
	public long totalEmpresas() {
		// TODO Auto-generated method stub
		return empresaDao.totalEmpresas();
	}

}
