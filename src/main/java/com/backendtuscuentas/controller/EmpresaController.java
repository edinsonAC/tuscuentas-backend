package com.backendtuscuentas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendtuscuentas.entitys.util.ListadoEmpresa;
import com.backendtuscuentas.services.IContadorService;
import com.backendtuscuentas.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IContadorService contadorService;
	
	@GetMapping("/listarEmpresasBasicaUsuario/{id}")
	public ResponseEntity<ArrayList<ListadoEmpresa>> listarEmpresasPorUsuario(@PathVariable Long id) {
		return new ResponseEntity<ArrayList<ListadoEmpresa>>(this.usuarioService.listarEmpresasPorUsuario(id),
				HttpStatus.OK);
	}
	
	@GetMapping("/listarEmpresasBasicaContador/{id}")
	public ResponseEntity<ArrayList<ListadoEmpresa>> listarEmpresasPorContador(@PathVariable Long id) {
		return new ResponseEntity<ArrayList<ListadoEmpresa>>(this.contadorService.listarEmpresaBasicaPorContador(id),
				HttpStatus.OK);
	}
}
