package com.backendtuscuentas.services;

import com.backendtuscuentas.entitys.Usuario;

public interface IUsuario {

	public Usuario findByUsername(String username);
	
}
