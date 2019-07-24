package com.backendtuscuentas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backendtuscuentas.entitys.LogActividade;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.entitys.util.ListadoEjecuciones;
import com.backendtuscuentas.entitys.util.ListadoEmpresa;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);

	public long totalUsuarios();
	
	public List<Menu> listarFuncionalidadesPorUsuario(Long id);
	
	public ArrayList<Alerta>listarAlertasPorIdUsuario(Long idUsuario);
	
	public ArrayList<ListadoEjecuciones>listarEjecucionesAbiertas(Long idUsuario,Long idEmpresa);
	
	public ArrayList<ListadoEjecuciones> listarEjecucionesAtrasadas(Long idUsuario,Long idEmpresa);
	
	public ArrayList<ListadoEjecuciones> listarEjecucionesProximas(Long idUsuario,Long idEmpresa);
	
	public ArrayList<ListadoEjecuciones> listarEjecucionesObservadas(Long idUsuario,Long idEmpresa);
	
	public ArrayList<ListadoEjecuciones> listarEjecucionesCerradas(Long idUsuario,Long idEmpresa);
	
	public ArrayList<ListadoEmpresa> listarEmpresasPorUsuario(Long id);
	
}
