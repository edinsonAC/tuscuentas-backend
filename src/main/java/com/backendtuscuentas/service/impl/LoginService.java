package com.backendtuscuentas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backendtuscuentas.dao.UsuarioDAO;
import com.backendtuscuentas.entitys.TipoUsuario;
import com.backendtuscuentas.entitys.Usuario;

@Service
public class LoginService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private UsuarioDAO usuarioDao;

	//el metodo se encarga de buscar el usuario ya validar su ingreso
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByEmail(email);
		boolean enabled = false;

		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario  '" + email + "' en el sistema");
			throw new UsernameNotFoundException(
					"Error en el login: no existe el usuario  '" + email + "' en el sistema");
		}

		if (usuario.getUsuaEstado() == 1) {
			enabled = true;
		}
		List<TipoUsuario> roles = new ArrayList<>();
		roles.add(usuario.getTipoUsuario());
		//se agregan los roles que posee el usuario

		List<GrantedAuthority> authorities = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getTiusDescripcion()))
				.peek(authority -> logger.info("Role : " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		//todo el metodo se hace con el fin de retornar un objeto de la clase user 
		return new User(usuario.getUsuaCorreo(), usuario.getUsuaPassword(), enabled, true, true, true, authorities);
	}

}
