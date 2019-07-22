package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendtuscuentas.entitys.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	
	@Query(nativeQuery = true, value = "SELECT COUNT(u.usua_id) AS usuarios FROM usuario u")
	public long totalUsuarios();
	
	//metodo para logueo de la plataforma
	@Query(nativeQuery = true, value = "SELECT * FROM usuario where usua_correo = ?1")
	public Usuario findByEmail(String email);

}
