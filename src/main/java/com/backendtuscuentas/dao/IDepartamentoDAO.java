package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendtuscuentas.entitys.Departamento;

public interface IDepartamentoDAO extends JpaRepository<Departamento, Long>{

}
