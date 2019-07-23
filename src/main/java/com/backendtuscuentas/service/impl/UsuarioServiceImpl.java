package com.backendtuscuentas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backendtuscuentas.dao.IFuncionalidadDAO;
import com.backendtuscuentas.dao.ILogActivadesDAO;
import com.backendtuscuentas.dao.IMenuDAO;
import com.backendtuscuentas.dao.UsuarioDAO;
import com.backendtuscuentas.entitys.LogActividade;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.services.IUsuario;
import com.backendtuscuentas.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService, IUsuario {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Autowired
	private IMenuDAO menuDao;

	@Autowired
	private ILogActivadesDAO logDao;

	@Autowired
	private IFuncionalidadDAO funcionalidadDao;

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByEmail(username);
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	public long totalUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.totalUsuarios();
	}

	@Override
	public List<Menu> listarFuncionalidadesPorUsuario(Long id) {
		List<Menu> menus = menuDao.listarMenusPorUsuario(id, id);
		System.out.println(
				"---------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
		if (menus != null) {
			for (Menu menu : menus) {
				menu.setFuncionalidads(funcionalidadDao.listarFuncionalidadesPorMenu(id, menu.getMenuId()));
			}
		}

		return menus;
	}

	@Override
	public ArrayList<Alerta> listarAlertasPorIdUsuario(Long idUsuario) {
		ArrayList<Object[]> objetos = new ArrayList<Object[]>();
		ArrayList<Alerta> alertas = new ArrayList<>();
		objetos = logDao.listarAlertasPorIdUsuario(idUsuario, idUsuario, 3);
		
		if (objetos != null) {
			for (Object[] object : objetos) {
				alertas.add(new Alerta((String) object[0].toString() ,new Long((Integer) object[1]), (String) object[2].toString(),
						(String) object[3], (String) object[4], (String) object[5]));
			}
		}

		return alertas;
	}

}
