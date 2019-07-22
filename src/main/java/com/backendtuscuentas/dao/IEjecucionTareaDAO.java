package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.EjecucionTarea;

public interface IEjecucionTareaDAO extends JpaRepository<EjecucionTarea, Long> {

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) total from \r\n"
			+ "   ejecucion_tarea ejta INNER JOIN tarea_empresa taem on taem.taem_id = ejta.taem_id \r\n"
			+ "   INNER JOIN empresa empr on empr.empr_id = taem.empr_id  INNER JOIN ( \r\n"
			+ "     select distinct empr.empr_id  from  empresa empr \r\n"
			+ "       left join contador_empresa coem on coem.empr_id = empr.empr_id \r\n"
			+ "       left join usuario usua on usua.usua_id = coem.usua_id \r\n"
			+ "       left join usuario jefe on jefe.coju_id = empr.coju_id  where \r\n"
			+ "       empr.empr_estado <> 0  and ( usua.usua_id = ?1 \r\n"
			+ "         and coem.caem_id = 12 )  or ( jefe.usua_id = ?2  and jefe.coju_ppal = 1) \r\n"
			+ "   ) empr_jefe on empr_jefe.empr_id = taem.empr_id where \r\n"
			+ "   empr.empr_estado <> 0  and ejta.ejta_estado = ?3  and ejta_habil = '1' ")
	public long calcularTareasAbiertasAndAtrasadasDelMesParaContador(long idUsuario, long idus, long estado);

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) total\r\n"
			+ " from  ejecucion_tarea ejta \r\n"
			+ "   INNER JOIN tarea_empresa taem on taem.taem_id = ejta.taem_id \r\n"
			+ "   INNER JOIN empresa empr on empr.empr_id = taem.empr_id INNER JOIN ( \r\n"
			+ "     select distinct empr.empr_id  from  empresa empr \r\n"
			+ "       left join contador_empresa coem on coem.empr_id = empr.empr_id \r\n"
			+ "       left join usuario usua on usua.usua_id = coem.usua_id \r\n"
			+ "       left join usuario jefe on jefe.coju_id = empr.coju_id  where \r\n"
			+ "       empr.empr_estado <> 0 and (usua.usua_id = ?1 and coem.caem_id = 12 )  or ( \r\n"
			+ "         jefe.usua_id = ?2  and jefe.coju_ppal = 1 ) \r\n"
			+ "   ) empr_jefe on empr_jefe.empr_id = taem.empr_id where \r\n"
			+ "   empr.empr_estado <> 0 and ejta.ejta_estado = ?3  and ejta_habil = '1'\r\n"
			+ "   and taem.empr_id = ?4 ")
	public long calcularTareasAbiertasAndAtrasadasDelMesEmpresaParaContador(long idUsuario, long idus, long estado,
			long idEmpresa);

	@Query(nativeQuery = true, value = "SELECT DISTINCT COUNT(ejta.ejta_id) AS total \r\n"
			+ "FROM ejecucion_tarea ejta INNER JOIN visualizar visu ON visu.ejta_id = ejta.ejta_id \r\n"
			+ "INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ "INNER JOIN empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ "WHERE empr.empr_estado <> 0 and  (visu.usua_id = ?1 and ejta_habil='1')")
	public long calcularTareasObservadasPorContador(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT COUNT(ejta.ejta_id) AS total \r\n"
			+ "FROM ejecucion_tarea ejta INNER JOIN visualizar visu ON visu.ejta_id = ejta.ejta_id \r\n"
			+ "INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ "INNER JOIN empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ "WHERE empr.empr_estado <> 0 and (visu.usua_id = ?1  AND empr.empr_id =?2 and ejta_habil='1' ) ")
	public long calcularTareasObservadasPorContadorPorEmpresa(long idUsuario, long idEmpresa);

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) AS total FROM ejecucion_tarea ejta  \r\n"
			+ " INNER JOIN tarea_empresa taem ON taem.taem_id = ejta.taem_id \r\n"
			+ " INNER JOIN empresa empr ON empr.empr_id = taem.empr_id \r\n"
			+ " WHERE  ejta.ejta_estado=?1 AND taem.empr_id IN(SELECT DISTINCT empr.empr_id  \r\n"
			+ " FROM empresa empr LEFT join contador_empresa coem ON coem.empr_id = empr.empr_id  \r\n"
			+ " LEFT join usuario usua ON usua.usua_id = coem.usua_id  \r\n"
			+ " LEFT join usuario jefe ON jefe.coju_id = empr.coju_id    \r\n"
			+ " WHERE (usua.usua_id= ?2 AND coem.caem_id=12) OR (jefe.usua_id= ?3 AND jefe.coju_ppal=1)) AND \r\n"
			+ " (ejta_fechafinalizada BETWEEN  DATE(CONCAT_WS('-', YEAR(CURDATE()), MONTH(CURDATE()), '1')) AND NOW())  \r\n"
			+ "  AND  ejta_habil='1' ") 
	public long calcularTareasCerradasPorContador(long estadoCerrada, long idUsuario, long idUsuario2);

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) AS total FROM ejecucion_tarea ejta  \r\n"
			+ " INNER JOIN tarea_empresa taem ON taem.taem_id = ejta.taem_id \r\n"
			+ " INNER JOIN empresa empr ON empr.empr_id = taem.empr_id \r\n"
			+ " WHERE  ejta.ejta_estado=?1 AND taem.empr_id IN(SELECT DISTINCT empr.empr_id  \r\n"
			+ " FROM empresa empr LEFT join contador_empresa coem ON coem.empr_id = empr.empr_id  \r\n"
			+ " LEFT join usuario usua ON usua.usua_id = coem.usua_id  \r\n"
			+ " LEFT join usuario jefe ON jefe.coju_id = empr.coju_id    \r\n"
			+ "where   (usua.usua_id=?2 and coem.caem_id=12) or (jefe.usua_id=?2 and jefe.coju_ppal=1)) AND \r\n"
			+ " (ejta_fechafinalizada BETWEEN DATE(CONCAT_WS('-', YEAR(CURDATE()), MONTH(CURDATE()), '1')) AND NOW())\r\n"
			+ "  and ejta_habil='1' AND taem.empr_id = ?3")
	public long calcularTareasCerradasPorContadorPorEmpresa(long estadoCerrada, long idUsuario, long idEmpresa);

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) AS total FROM ejecucion_tarea ejta  \r\n"
			+ " INNER JOIN tarea_empresa taem ON taem.taem_id = ejta.taem_id \r\n"
			+ " INNER JOIN empresa empr ON empr.empr_id = taem.empr_id \r\n"
			+ " WHERE  ejta.ejta_estado=?1 AND taem.empr_id IN(SELECT DISTINCT empr.empr_id  \r\n"
			+ " FROM empresa emprs LEFT join contador_empresa coem ON coem.empr_id = empr.empr_id  \r\n"
			+ " LEFT join usuario usua ON usua.usua_id = coem.usua_id  \r\n"
			+ " LEFT join usuario jefe ON jefe.coju_id = empr.coju_id    \r\n"
			+ " WHERE (usua.usua_id=2 AND coem.caem_id=12) OR (jefe.usua_id=?2 AND jefe.coju_ppal=1)) AND \r\n"
			+ " (ejta_fechafinalizada BETWEEN  DATE(CONCAT_WS('-', YEAR(CURDATE()), MONTH(CURDATE()), '1')) AND NOW())  \r\n"
			+ "  AND  ejta_habil='1' ")
	public long calcularTareasPendintesPorContador(long estadoCerrada, long idUsuario);

}
