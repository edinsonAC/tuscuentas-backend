package com.backendtuscuentas.dao;

import java.util.ArrayList;

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

	@Query(nativeQuery = true, value = "SELECT COUNT(ejta.ejta_id) total\r\n" + " from  ejecucion_tarea ejta \r\n"
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

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre ) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias\r\n" + "FROM ejecucion_tarea ejta \r\n"
			+ "LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ "INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ "INNER JOIN tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ "LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id \r\n"
			+ "INNER JOIN empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ "WHERE empr.empr_estado <> 0 and ejta.usua_id =?1 AND\r\n"
			+ " if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is NULL)\r\n"
			+ " AND ejta.ejta_estado = 1  AND ejta_habil = '1'")
	public ArrayList<Object[]> listarEjecucionesAbiertasPorUsuario(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre ) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias\r\n" + "FROM ejecucion_tarea ejta \r\n"
			+ "LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ "INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ "INNER JOIN tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ "LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id \r\n"
			+ "INNER JOIN empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ "WHERE empr.empr_estado <> 0 AND  empr.empr_id=?1 AND ejta.usua_id =?2 AND \r\n"
			+ " if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null ) \r\n"
			+ " AND ejta.ejta_estado = 1 AND ejta_habil = '1'")
	public ArrayList<Object[]> listarEjecucionesAbiertasPorUsuarioAndEmpresa(long idEmpresa, long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id, ejta.taem_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "  if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "  ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ " from ejecucion_tarea ejta  inner join tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " inner join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " left JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id \r\n"
			+ " inner join empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id \r\n"
			+ "  WHERE empr.empr_estado <> 0 AND ejta.usua_id =?1 AND ejta.ejta_estado = 2 \r\n"
			+ "  AND if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null )\r\n"
			+ "  AND ejta_habil = '1'  order by ejta.ejta_fechafinal desc")
	public ArrayList<Object[]> listarEjecucionesAtrasadasPorUsuario(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id, ejta.taem_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "  if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "  ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ " from ejecucion_tarea ejta  inner join tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " inner join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " left JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id \r\n"
			+ " inner join empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id \r\n"
			+ " WHERE empr.empr_estado <> 0 AND ejta.usua_id =?1 AND ejta.ejta_estado = 2 \r\n"
			+ " AND if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado IS NULL) \r\n"
			+ " AND empr.empr_id=?2 AND ejta_habil = '1' ORDER BY ejta.ejta_fechafinal DESC")
	public ArrayList<Object[]> listarEjecucionesAtrasadasPorUsuarioAndEmpresa(long idUsuario, long idEmpresa);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido ) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ " FROM ejecucion_tarea ejta INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " INNER JOIN tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " INNER JOIN empresa empr on empr.empr_id = taem.empr_id\r\n"
			+ "WHERE  ejta.usua_id = ?1 and if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is NULL ) \r\n"
			+ "and ejta.ejta_estado = '3' AND ejta.ejta_habil = '1'  \r\n"
			+ "and (ejta.ejta_fechafinalizada BETWEEN  DATE(CONCAT_WS('-', YEAR(CURDATE()), MONTH(CURDATE()), '1')) AND NOW())\r\n"
			+ "ORDER BY ejta.ejta_fechafinalizada  DESC")
	public ArrayList<Object[]> listarEjecucionesCerradasPorUsuario(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion,CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido ) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ " FROM ejecucion_tarea ejta INNER JOIN tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " INNER JOIN tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " INNER JOIN empresa empr on empr.empr_id = taem.empr_id\r\n"
			+ "WHERE empr.empr_id = ?1 AND ejta.usua_id = ?1 and if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null ) and ejta.ejta_estado = '3' AND ejta.ejta_habil = '1' and (ejta.ejta_fechafinalizada BETWEEN  DATE(CONCAT_WS('-', YEAR(CURDATE()), MONTH(CURDATE()), '1')) AND NOW())  ORDER BY ejta.ejta_fechafinalizada  DESC")
	public ArrayList<Object[]> listarEjecucionesCerradasPorUsuarioAndEmpresa(long idEmpresa, long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre)as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion, CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido ) as nombre, \r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ "FROM ejecucion_tarea ejta \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " inner join visualizar visu ON visu.ejta_id = ejta.ejta_id\r\n"
			+ " inner join usuario usua ON usua.usua_id = ejta.usua_id\r\n"
			+ " inner join tarea_empresa taem on ejta.taem_id = taem.taem_id\r\n"
			+ " inner join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " left JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " inner join empresa empr on empr.empr_id = taem.empr_id\r\n"
			+ "  WHERE  empr.empr_estado <> 0 and visu.usua_id = ?1 AND if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null)\r\n"
			+ "  AND ejta.ejta_habil = '1' ORDER BY ejta.ejta_fechafinal DESC")
	public ArrayList<Object[]> listarEjecucionesObservadasPorUsuario(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre)as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion, CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido ) as nombre \r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias\r\n"
			+ "FROM ejecucion_tarea ejta \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " inner join visualizar visu ON visu.ejta_id = ejta.ejta_id\r\n"
			+ " inner join usuario usua ON usua.usua_id = ejta.usua_id\r\n"
			+ " inner join tarea_empresa taem on ejta.taem_id = taem.taem_id\r\n"
			+ " inner join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " left JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " inner join empresa empr on empr.empr_id = taem.empr_id\r\n"
			+ "  WHERE empr.empr_estado <> 0 and empr.empr_id=?1 and visu.usua_id = ?2\r\n"
			+ " AND if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null ) \r\n"
			+ " AND ejta.ejta_habil = '1' ORDER BY ejta.ejta_fechafinal DESC")
	public ArrayList<Object[]> listarEjecucionesObservadasPorUsuarioAndEmpresa(long idEmpresa, long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion, CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias,\r\n"
			+ "(SELECT ant_ejta.ejta_estado FROM ejecucion_tarea ant_ejta\r\n"
			+ " WHERE  ant_ejta.taem_id = ejta.taem_id AND ejta.ejta_orden > ant_ejta.ejta_orden\r\n"
			+ " AND ant_ejta.ejta_codejecucion = ejta.ejta_codejecucion AND ant_ejta.ejta_habil = '1' \r\n"
			+ " ORDER BY ant_ejta.ejta_orden DESC LIMIT 1 ) AS anterior  from ejecucion_tarea ejta \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " INNER join tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " INNER join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " INNER join empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ " WHERE empr.empr_estado <> 0 and   ejta.usua_id = ?1 and \r\n"
			+ " if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado is null ) \r\n"
			+ " and ejta.ejta_estado = '0' AND ejta.ejta_habil = '1' AND \r\n"
			+ " ((ejta_fechainicial BETWEEN  NOW() and DATE_SUB(NOW(), INTERVAL -30 DAY)) OR \r\n"
			+ " (ejta_fechainicial BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW())) ORDER BY ejta.ejta_fechafinal  DESC")
	public ArrayList<Object[]> listarEjecucionesPendientesPorUsuario(long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT ejta.ejta_id,ejta.ejta_fechainicial,ejta.ejta_fechafinal,\r\n"
			+ "if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea,\r\n"
			+ "ejta.ejta_descripcion, CONCAT_WS(' ',empr_nombre, empr_primernombre, emp_primerapellido) as nombre,\r\n"
			+ "ejta_leido,ejta.ejta_dias,if(ejta.ejta_fechafinal >= now(),0,1) as estadoDias,\r\n"
			+ "(SELECT ant_ejta.ejta_estado FROM ejecucion_tarea ant_ejta\r\n"
			+ " WHERE  ant_ejta.taem_id = ejta.taem_id AND ejta.ejta_orden > ant_ejta.ejta_orden\r\n"
			+ " AND ant_ejta.ejta_codejecucion = ejta.ejta_codejecucion AND ant_ejta.ejta_habil = '1' \r\n"
			+ " ORDER BY ant_ejta.ejta_orden DESC LIMIT 1 ) AS anterior  from ejecucion_tarea ejta \r\n"
			+ " LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n"
			+ " INNER join tarea_empresa taem on ejta.taem_id = taem.taem_id \r\n"
			+ " INNER join tarea_predeterminada tapr on tapr.tapr_id = taem.tapr_id \r\n"
			+ " LEFT JOIN proceso_empresa pr_empr ON pr_empr.empr_id = taem.empr_id\r\n"
			+ " INNER join empresa empr on empr.empr_id = taem.empr_id \r\n"
			+ " WHERE empr.empr_estado <> 0 and  empr.empr_id = ?1 AND ejta.usua_id = ?2 AND \r\n"
			+ "if(pr_empr.prem_estado is not null, pr_empr.prem_estado = '1',pr_empr.prem_estado IS NULL) \r\n"
			+ "and ejta.ejta_estado = '0' AND ejta.ejta_habil = '1'  AND \r\n"
			+ "((ejta_fechainicial BETWEEN NOW() and DATE_SUB(NOW(), INTERVAL -30 DAY)) OR \r\n"
			+ "(ejta_fechainicial BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW())) ORDER BY ejta.ejta_fechafinal  DESC")
	public ArrayList<Object[]> listarEjecucionesPendientesPorUsuarioAndEmpresa(long idEmpresa, long idUsuario);

	@Query(nativeQuery = true, value = "SELECT DISTINCT  ejta.ejta_id,ejta.ejta_descripcion,CONCAT_WS(' ', usua.usua_primernombre ,  usua.usua_primerapellido) AS nombre,\r\n"
			+ "DATE_FORMAT(ejta.ejta_fechafinalizada, '%Y/%m/%d  %H:%i:%s') as fechaFinalizada, \r\n"
			+ " usua.usua_imgperfil FROM ejecucion_tarea ejta\r\n"
			+ " INNER JOIN usuario usua ON ejta.usua_id = usua.usua_id\r\n"
			+ " INNER JOIN actividad_predeterminada acpr ON acpr.acpr_id = ejta.acpr_id\r\n"
			+ " WHERE ejta_codejecucion = (SELECT ejta_codejecucion  FROM ejecucion_tarea WHERE ejta_id= ?1)\r\n"
			+ " AND taem_id = (SELECT taem_id  FROM ejecucion_tarea WHERE ejta_id= ?2)")
	public ArrayList<Object[]> listarPasosPorEjecucion(long idEjecucion, long idEjecucion2);

}
