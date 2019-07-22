package com.backendtuscuentas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Long> {

	String listarMenusPorUsuario = " SELECT DISTINCT mepp.mepp_id,usfu.usua_id,menu.menu_id,menu.menu_titulo,menu.menu_registradopor,menu.menu_icono,menu.menu_fecharegistro \r\n"
			+ " FROM  usuario_funcionalidad usfu  \r\n"
			+ " INNER JOIN funcionalidad func ON func.func_id = usfu.func_id  \r\n"
			+ " INNER JOIN menu menu ON menu.menu_id = func.menu_id  \r\n"
			+ " INNER JOIN menu_ppal mepp ON mepp.mepp_id = menu.mepp_id  \r\n"
			+ " WHERE usfu.usua_id = ?1 and mepp.mepp_id IN (\r\n" + " SELECT DISTINCT mepp.mepp_id \r\n"
			+ " FROM  usuario_funcionalidad usfu  \r\n"
			+ " INNER JOIN funcionalidad func ON func.func_id = usfu.func_id  \r\n"
			+ " INNER JOIN menu menu ON menu.menu_id = func.menu_id  \r\n"
			+ " INNER JOIN menu_ppal mepp ON menu.mepp_id = mepp.mepp_id \r\n" + " WHERE usfu.usua_id = ?2)";

	@Query(nativeQuery = true, value = listarMenusPorUsuario)
	public List<Menu> listarMenusPorUsuario(Long idUsuario, Long idUs);

}
