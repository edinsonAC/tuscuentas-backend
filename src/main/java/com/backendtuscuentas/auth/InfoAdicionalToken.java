package com.backendtuscuentas.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.services.IUsuario;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	//agregando mas informacion al token
	
	@Autowired
	private IUsuario usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Usuario usuario = usuarioService.findByUsername(authentication.getName());

		Map<String, Object> info = new HashMap<>();
		info.put("id", usuario.getUsuaId());
		info.put("tipo_usuario", usuario.getTipoUsuario().getTiusId());
		info.put("img_perfil", usuario.getUsuaImgperfil());
		info.put("primer_nombre", usuario.getUsuaPrimernombre());
		info.put("primer_apellido", usuario.getUsuaPrimerapellido());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
