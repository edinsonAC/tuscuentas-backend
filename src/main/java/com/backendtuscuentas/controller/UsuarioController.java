package com.backendtuscuentas.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backendtuscuentas.entitys.LogActividade;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping(value = "/listarUsuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		ArrayList<Usuario> us = (ArrayList<Usuario>) usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/buscarUsuario/{id}")
	public ResponseEntity<Usuario> buscarJugadorPorId(@PathVariable Long id) {
		return new ResponseEntity<Usuario>(this.usuarioService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		Usuario usuario = usuarioService.findById(id);

		if (!archivo.isEmpty()) {
//			String nombreArchivo = archivo.getOriginalFilename();
			String nombreArchivo = "perfil" + id + ".png";

			// se busca y elimina la foto anterior, porque ocurre problemas al reemplazar la
			// imagen con el mismo nombre
			String nombreAnterior = usuario.getUsuaImgperfil();

			System.out.println("---------->>> " + usuario.getUsuaImgperfil());

			if (nombreAnterior != null && nombreAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get("C:\\JavaCode\\archivosTuscuentas\\imagenesperfil")
						.resolve(nombreAnterior).toAbsolutePath();

				File archivoFotoAnterior = rutaFotoAnterior.toFile();

				if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}

			}

			Path rutaArchivo = Paths.get("C:\\JavaCode\\archivosTuscuentas\\imagenesperfil").resolve(nombreArchivo)
					.toAbsolutePath();

			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			usuario.setUsuaImgperfil(nombreArchivo);

			usuarioService.save(usuario);

			response.put("usuario", usuario);
			response.put("mensaje", "has subido correctamente la imagen");

		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/upload/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

		Path rutaArchivo = Paths.get("C:\\JavaCode\\archivosTuscuentas\\imagenesperfil").resolve(nombreFoto)
				.toAbsolutePath();
		log.info(rutaArchivo.toString());
		Resource recurso = null;

		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se puto cargar la imagen");

		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		return new ResponseEntity<Resource>(recurso, HttpStatus.OK);
	}

	@GetMapping("/listarMenu/{id}")
	public ResponseEntity<List<Menu>> listarFuncionalidadesPorUsuario(@PathVariable Long id) {
		return new ResponseEntity<List<Menu>>(this.usuarioService.listarFuncionalidadesPorUsuario(id), HttpStatus.OK);
	}

	@GetMapping("/listarAlertas/{id}")
	public ResponseEntity<ArrayList<Alerta>> listarAlertasPorIdUsuario(@PathVariable Long id) {
		return new ResponseEntity<ArrayList<Alerta>>(this.usuarioService.listarAlertasPorIdUsuario(id),
				HttpStatus.OK);
	}
}
