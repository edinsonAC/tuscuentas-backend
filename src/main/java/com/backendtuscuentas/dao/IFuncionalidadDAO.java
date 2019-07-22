package com.backendtuscuentas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.Funcionalidad;
import com.backendtuscuentas.entitys.Menu;

public interface IFuncionalidadDAO extends JpaRepository<Funcionalidad, Long> {

	String listarFuncionalidadesPorMenu = " SELECT DISTINCT usfu.usua_id,usfu.func_id,func.func_pagina,func.func_titulo,func.func_icono,func_fecharegistro,func_registradopor,func.menu_id \r\n"
			+ "FROM  usuario_funcionalidad usfu   \r\n"
			+ "INNER JOIN funcionalidad func ON func.func_id = usfu.func_id   \r\n"
			+ "INNER JOIN menu menu ON menu.menu_id = func.menu_id    \r\n"
			+ "WHERE usfu.usua_id = ?1 and menu.menu_id=?2 ORDER BY func_titulo ASC ";

	@Query(nativeQuery = true, value = listarFuncionalidadesPorMenu)
	public List<Funcionalidad> listarFuncionalidadesPorMenu(Long idUsuario, Long idMenu);

}
