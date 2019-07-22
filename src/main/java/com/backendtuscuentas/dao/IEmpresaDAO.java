package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Long>{

	@Query(nativeQuery = true, value = "SELECT COUNT(e.empr_id) AS empresas FROM empresa e")
	public long totalEmpresas();
}
