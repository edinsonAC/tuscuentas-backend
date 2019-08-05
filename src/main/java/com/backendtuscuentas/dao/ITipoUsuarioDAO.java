package com.backendtuscuentas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.TipoUsuario;

public interface ITipoUsuarioDAO extends JpaRepository<TipoUsuario, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM tipo_usuario WHERE tius_id NOT IN (1,3,8) ")
	List<TipoUsuario>listarTipoUsuarioContador();
}
