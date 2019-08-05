package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendtuscuentas.entitys.TipoDocumento;

public interface ITipoDocumentoDAO extends JpaRepository<TipoDocumento, Long> {

}
