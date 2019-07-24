package com.backendtuscuentas.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Long> {

	@Query(nativeQuery = true, value = "SELECT COUNT(e.empr_id) AS empresas FROM empresa e")
	public long totalEmpresas();

	@Query(nativeQuery = true, value = "SELECT DISTINCT empr.empr_id,CONCAT_WS(' ',empr_nombre,empr_primernombre,emp_primerapellido) as nombreempresa\r\n"
			+ " FROM contador_empresa coem  LEFT JOIN empresa empr on empr.empr_id = coem.empr_id  \r\n"
			+ " LEFT JOIN usuario usua on usua.empr_id = coem.empr_id  \r\n"
			+ " WHERE ((coem.usua_id=?1 and empr.empr_estado <> 0) or (usua.usua_id=?2 and  usua.empr_id = coem.empr_id))")
	public ArrayList<Object[]> listarEmpresasPorUsuario(Long idUsuario, Long idUsuario2);

	@Query(nativeQuery = true, value = "SELECT DISTINCT empr.empr_id, CONCAT_WS(' ',empr_nombre,empr_primernombre,emp_primerapellido) as nombreempresa\r\n"
			+ " FROM empresa empr left join contador_empresa coem on coem.empr_id = empr.empr_id \r\n"
			+ " left join usuario usua on usua.empr_id = empr.empr_id   \r\n"
			+ " left join usuario jefe on jefe.coju_id = empr.coju_id   \r\n"
			+ " WHERE empr.empr_estado <> 0  AND ((coem.usua_id=?1 and coem.caem_id=?2) or (jefe.usua_id=?3 and jefe.coju_ppal= 1)) ORDER BY nombreempresa ASC")
	public ArrayList<Object[]> listarEmpresasPorContador(Long idUsuario, Long cargo,Long idUsuario2);

}
