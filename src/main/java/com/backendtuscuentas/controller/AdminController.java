package com.backendtuscuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendtuscuentas.entitys.Usuario;
import com.backendtuscuentas.entitys.util.Totales;
import com.backendtuscuentas.services.IAdminService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@GetMapping("/totales")
	public ResponseEntity<Totales> totalesAdmin() {
		return new ResponseEntity<Totales>(this.adminService.totalesAdmin(), HttpStatus.OK);
	}
	
}
