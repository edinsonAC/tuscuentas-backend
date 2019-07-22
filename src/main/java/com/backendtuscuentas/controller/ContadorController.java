package com.backendtuscuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendtuscuentas.entitys.util.Totales;
import com.backendtuscuentas.services.IContadorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/contador")
public class ContadorController {

	@Autowired
	private IContadorService contadorService;

	@GetMapping("/totales/{idUsuario}/{idEmpresa}")
	public ResponseEntity<Totales> totalesAdmin(@PathVariable long idUsuario, @PathVariable long idEmpresa) {
		return new ResponseEntity<Totales>(this.contadorService.calcularTotalesTareas(idUsuario, idEmpresa),
				HttpStatus.OK);
	}

}
