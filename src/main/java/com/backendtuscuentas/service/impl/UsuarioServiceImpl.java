package com.backendtuscuentas.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backendtuscuentas.dao.IEjecucionTareaDAO;
import com.backendtuscuentas.dao.IEmpresaDAO;
import com.backendtuscuentas.dao.IFuncionalidadDAO;
import com.backendtuscuentas.dao.ILogActivadesDAO;
import com.backendtuscuentas.dao.IMenuDAO;
import com.backendtuscuentas.dao.UsuarioDAO;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.entitys.util.Constantes;
import com.backendtuscuentas.entitys.util.ListadoEjecuciones;
import com.backendtuscuentas.entitys.util.ListadoEmpresa;
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

	@Autowired
	private IEjecucionTareaDAO ejecucionTareaDao;

	@Autowired
	private IEmpresaDAO empresaDao;

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByEmail(username);
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public long totalUsuarios() {
		return usuarioDao.totalUsuarios();
	}

	@Override
	public List<Menu> listarFuncionalidadesPorUsuario(Long id) {
		List<Menu> menus = menuDao.listarMenusPorUsuario(id, id);
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
				alertas.add(new Alerta((String) object[0].toString(), new Long((Integer) object[1]),
						(String) object[2].toString(), (String) object[3], (String) object[4], (String) object[5]));
			}
		}

		return alertas;
	}

	@Override
	public ArrayList<ListadoEjecuciones> listarEjecucionesAbiertas(Long idUsuario, Long idEmpresa) {
		ArrayList<Object[]> ejecuciones = new ArrayList<>();
		ArrayList<ListadoEjecuciones> tareasAbiertas = new ArrayList<>();

		if (idEmpresa == 0) {
			ejecuciones = ejecucionTareaDao.listarEjecucionesAbiertasPorUsuario(idUsuario);
		} else {
			ejecuciones = ejecucionTareaDao.listarEjecucionesAbiertasPorUsuarioAndEmpresa(idEmpresa, idUsuario);
		}

		if (ejecuciones != null) {
			for (Object[] object : ejecuciones) {
//				System.out.println("for -> "+ object[0]);
//				System.out.println("for -> "+ object[1]);
//				System.out.println("for -> "+ object[2]);
//				System.out.println("for -> "+ object[3]);
//				System.out.println("for -> "+ object[4]);
//				System.out.println("for -> "+ object[5]);
//				System.out.println("for -> "+ object[6]);
//				System.out.println("for -> "+ object[7]);
				tareasAbiertas.add(new ListadoEjecuciones(new Long((Integer) object[0]), (String) object[1],
						(String) object[2].toString(), (String) object[3], (String) object[4], "",
						new Long((Byte) object[6]), new Long((String) object[7]), (String) object[5]));
			}
		}

		return tareasAbiertas;
	}

	@Override
	public ArrayList<ListadoEjecuciones> listarEjecucionesProximas(Long idUsuario, Long idEmpresa) {
		ArrayList<Object[]> ejecuciones = new ArrayList<>();
		ArrayList<ListadoEjecuciones> tareasAbiertas = new ArrayList<>();

		if (idEmpresa == 0) {
			ejecuciones = ejecucionTareaDao.listarEjecucionesPendientesPorUsuario(idUsuario);
		} else {
			ejecuciones = ejecucionTareaDao.listarEjecucionesPendientesPorUsuarioAndEmpresa(idEmpresa, idUsuario);
		}

		if (ejecuciones != null) {
			for (Object[] object : ejecuciones) {
				if (object[9] == null || object[9].equals("3")) {
					tareasAbiertas.add(new ListadoEjecuciones(new Long((Integer) object[0]), (String) object[1],
							(String) object[2].toString(), (String) object[3], (String) object[4], "",
							new Long((Byte) object[6]), new Long((String) object[7]), (String) object[5]));
				}

			}
		}

		return tareasAbiertas;
	}

	@Override
	public ArrayList<ListadoEmpresa> listarEmpresasPorUsuario(Long id) {

		ArrayList<Object[]> emp = new ArrayList<>();
		ArrayList<ListadoEmpresa> empresas = new ArrayList<>();

		emp = empresaDao.listarEmpresasPorUsuario(id, Constantes.ID_CARGO_CONTADOR);

		if (emp != null) {
			for (Object[] object : emp) {
				empresas.add(new ListadoEmpresa(new Long((Integer) object[0]), (String) object[1]));

			}
		}
		return empresas;
	}

	@Override
	public ArrayList<ListadoEjecuciones> listarEjecucionesAtrasadas(Long idUsuario, Long idEmpresa) {
		ArrayList<Object[]> ejecuciones = new ArrayList<>();
		ArrayList<ListadoEjecuciones> tareasAtrasadas = new ArrayList<>();

		if (idEmpresa == 0) {
			ejecuciones = ejecucionTareaDao.listarEjecucionesAtrasadasPorUsuario(idUsuario);
		} else {
			ejecuciones = ejecucionTareaDao.listarEjecucionesAtrasadasPorUsuarioAndEmpresa(idEmpresa, idUsuario);
		}

		if (ejecuciones != null) {
			for (Object[] object : ejecuciones) {
//				System.out.println("for -> "+ object[0]);
//				System.out.println("for -> "+ object[1]);
//				System.out.println("for -> "+ object[2]);
//				System.out.println("for -> "+ object[3]);
//				System.out.println("for -> "+ object[4]);
//				System.out.println("for -> "+ object[5]);
//				System.out.println("for -> "+ object[6]);
//				System.out.println("for -> "+ object[7]);
				tareasAtrasadas.add(new ListadoEjecuciones(new Long((Integer) object[0]), (String) object[1],
						(String) object[2].toString(), (String) object[3], (String) object[4], "",
						new Long((Byte) object[6]), new Long((String) object[7]), (String) object[5]));
			}
		}

		return tareasAtrasadas;
	}

	@Override
	public ArrayList<ListadoEjecuciones> listarEjecucionesObservadas(Long idUsuario, Long idEmpresa) {
		ArrayList<Object[]> ejecuciones = new ArrayList<>();
		ArrayList<ListadoEjecuciones> tareasObservadas = new ArrayList<>();

		if (idEmpresa == 0) {
			ejecuciones = ejecucionTareaDao.listarEjecucionesObservadasPorUsuario(idUsuario);
		} else {
			ejecuciones = ejecucionTareaDao.listarEjecucionesObservadasPorUsuarioAndEmpresa(idEmpresa, idUsuario);
		}

		if (ejecuciones != null) {
			for (Object[] object : ejecuciones) {
//				System.out.println("for -> "+ object[0]);
//				System.out.println("for -> "+ object[1]);
//				System.out.println("for -> "+ object[2]);
//				System.out.println("for -> "+ object[3]);
//				System.out.println("for -> "+ object[4]);
//				System.out.println("for -> "+ object[5]);
//				System.out.println("for -> "+ object[6]);
//				System.out.println("for -> "+ object[7]);
				tareasObservadas.add(new ListadoEjecuciones(new Long((Integer) object[0]), (String) object[1],
						(String) object[2].toString(), (String) object[3], (String) object[4], "",
						new Long((Byte) object[6]), new Long((String) object[7]), (String) object[5]));
			}
		}

		return tareasObservadas;
	}

	@Override
	public ArrayList<ListadoEjecuciones> listarEjecucionesCerradas(Long idUsuario, Long idEmpresa) {
		ArrayList<Object[]> ejecuciones = new ArrayList<>();
		ArrayList<ListadoEjecuciones> tareasCerradas = new ArrayList<>();

		if (idEmpresa == 0) {
			ejecuciones = ejecucionTareaDao.listarEjecucionesCerradasPorUsuario(idUsuario);
		} else {
			ejecuciones = ejecucionTareaDao.listarEjecucionesCerradasPorUsuarioAndEmpresa(idEmpresa, idUsuario);
		}

		if (ejecuciones != null) {
			for (Object[] object : ejecuciones) {
//				System.out.println("for -> "+ object[0]);
//				System.out.println("for -> "+ object[1]);
//				System.out.println("for -> "+ object[2]);
//				System.out.println("for -> "+ object[3]);
//				System.out.println("for -> "+ object[4]);
//				System.out.println("for -> "+ object[5]);
//				System.out.println("for -> "+ object[6]);
//				System.out.println("for -> "+ object[7]);
				tareasCerradas.add(new ListadoEjecuciones(new Long((Integer) object[0]), (String) object[1],
						(String) object[2].toString(), (String) object[3], (String) object[4], "",
						new Long((Byte) object[6]), new Long((String) object[7]), (String) object[5]));
			}
		}

		return tareasCerradas;
	}

}
