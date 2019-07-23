package com.backendtuscuentas.services;

import java.util.ArrayList;
import java.util.List;

import com.backendtuscuentas.entitys.LogActividade;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);

	public long totalUsuarios();
	
	public List<Menu> listarFuncionalidadesPorUsuario(Long id);
	
	public ArrayList<Alerta>listarAlertasPorIdUsuario(Long idUsuario);
	
}
