package com.backendtuscuentas.entitys.util;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Totales {

	private long id;
	private String nombre;
	private long usuarios;
	private long empresas;
	private long contadores;
	private long atrasadas;
	private long abiertas;
	private long observadas;
	private long proximas;
	private long cerradas;
	private long neutras;
	
}
