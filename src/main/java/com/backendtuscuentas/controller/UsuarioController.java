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

import com.backendtuscuentas.entitys.Departamento;
import com.backendtuscuentas.entitys.LogActividade;
import com.backendtuscuentas.entitys.Menu;
import com.backendtuscuentas.entitys.Municipio;
import com.backendtuscuentas.entitys.TipoDocumento;
import com.backendtuscuentas.entitys.TipoUsuario;
import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.entitys.util.ListadoEjecuciones;
import com.backendtuscuentas.entitys.util.ListadoEmpresa;
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
			// si es la primera vez no se elimina nada
			if (!nombreAnterior.equals("profile.png")) {
				if (nombreAnterior != null && nombreAnterior.length() > 0) {
					Path rutaFotoAnterior = Paths.get("C:\\JavaCode\\archivosTuscuentas\\imagenesperfil")
							.resolve(nombreAnterior).toAbsolutePath();

					File archivoFotoAnterior = rutaFotoAnterior.toFile();

					if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
						archivoFotoAnterior.delete();
					}

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

		if (nombreFoto.equals("profile.png")) {
			nombreFoto = "perfil.png";
		}

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
			throw new RuntimeException("Error no se pudo cargar la imagen");

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
		return new ResponseEntity<ArrayList<Alerta>>(this.usuarioService.listarAlertasPorIdUsuario(id), HttpStatus.OK);
	}

	@GetMapping("/listarAbiertas/{id}/{idEmpresa}")
	public ResponseEntity<ArrayList<ListadoEjecuciones>> listarEjecucionesAbiertas(@PathVariable Long id,
			@PathVariable Long idEmpresa) {
		return new ResponseEntity<ArrayList<ListadoEjecuciones>>(
				this.usuarioService.listarEjecucionesAbiertas(id, idEmpresa), HttpStatus.OK);
	}

	@GetMapping("/listarAtrasadas/{id}/{idEmpresa}")
	public ResponseEntity<ArrayList<ListadoEjecuciones>> listarEjecucionesAtrasadas(@PathVariable Long id,
			@PathVariable Long idEmpresa) {
		return new ResponseEntity<ArrayList<ListadoEjecuciones>>(
				this.usuarioService.listarEjecucionesAtrasadas(id, idEmpresa), HttpStatus.OK);
	}

	@GetMapping("/listarObservadas/{id}/{idEmpresa}")
	public ResponseEntity<ArrayList<ListadoEjecuciones>> listarEjecucionesObservadas(@PathVariable Long id,
			@PathVariable Long idEmpresa) {
		return new ResponseEntity<ArrayList<ListadoEjecuciones>>(
				this.usuarioService.listarEjecucionesObservadas(id, idEmpresa), HttpStatus.OK);
	}

	@GetMapping("/listarCerradas/{id}/{idEmpresa}")
	public ResponseEntity<ArrayList<ListadoEjecuciones>> listarEjecucionesCerradas(@PathVariable Long id,
			@PathVariable Long idEmpresa) {
		return new ResponseEntity<ArrayList<ListadoEjecuciones>>(
				this.usuarioService.listarEjecucionesCerradas(id, idEmpresa), HttpStatus.OK);
	}

	@GetMapping("/listarProximas/{id}/{idEmpresa}")
	public ResponseEntity<ArrayList<ListadoEjecuciones>> listarEjecucionesProximas(@PathVariable Long id,
			@PathVariable Long idEmpresa) {
		return new ResponseEntity<ArrayList<ListadoEjecuciones>>(
				this.usuarioService.listarEjecucionesProximas(id, idEmpresa), HttpStatus.OK);
	}

	@GetMapping(value = "/listarTipoDocumento")
	public ResponseEntity<List<TipoDocumento>> listarTipoDocumento() {
		List<TipoDocumento> us = (List<TipoDocumento>) usuarioService.listarTipoDocumento();
		return new ResponseEntity<List<TipoDocumento>>(usuarioService.listarTipoDocumento(), HttpStatus.OK);
	}

	@GetMapping(value = "/listarTipoUsuario/{tipo}")
	public ResponseEntity<List<TipoUsuario>> listarTipoUsuario(@PathVariable Long tipo) {
		List<TipoUsuario> us = (List<TipoUsuario>) usuarioService.listarTipoUsuario(tipo);
		return new ResponseEntity<List<TipoUsuario>>(usuarioService.listarTipoUsuario(tipo), HttpStatus.OK);
	}

	@GetMapping(value = "/listarMunicipios/{idDepartamento}")
	public ResponseEntity<List<Municipio>> listarMunicipiosPorDepartamento(@PathVariable Long idDepartamento) {
		List<Municipio> us = (List<Municipio>) usuarioService.listarMunicipioPorDepartamento(idDepartamento);
		return new ResponseEntity<List<Municipio>>(usuarioService.listarMunicipioPorDepartamento(idDepartamento),
				HttpStatus.OK);
	}

	@GetMapping(value = "/listarDepartamentos")
	public ResponseEntity<List<Departamento>> listarDepartamentos() {
		List<Departamento> us = (List<Departamento>) usuarioService.listarDepartamentos();
		return new ResponseEntity<List<Departamento>>(usuarioService.listarDepartamentos(), HttpStatus.OK);
	}
}
