package com.backendtuscuentas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.Municipio;

public interface IMunicipioDAO extends JpaRepository<Municipio, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM municipio WHERE depa_id = ?1 ")
	List<Municipio> listarMunicipioPorDepartamento(long idDepartamento);
}
