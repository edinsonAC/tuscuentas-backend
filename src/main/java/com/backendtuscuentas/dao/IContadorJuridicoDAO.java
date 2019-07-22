package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.ContadorJuridico;

public interface IContadorJuridicoDAO extends JpaRepository<ContadorJuridico, Long>{

	@Query(nativeQuery = true, value = "SELECT COUNT(c.coju_id) AS contadores FROM contador_juridico c")
	public long totalContadores();
	
	
}
