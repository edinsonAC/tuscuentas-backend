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

import com.backendtuscuentas.entitys.EjecucionTarea;
import com.backendtuscuentas.services.IEjecucionTareaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/ejecucionTarea")
public class EjecucionTareaController {

	@Autowired
	private IEjecucionTareaService ejecucionservice;

	@GetMapping("/verEjecucion/{id}")
	public ResponseEntity<EjecucionTarea> verEjecucionTarea(@PathVariable Long id) {
		return new ResponseEntity<EjecucionTarea>(this.ejecucionservice.verEjecucionTarea(id),
				HttpStatus.OK);
	}

}
