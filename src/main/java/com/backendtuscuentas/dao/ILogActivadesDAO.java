package com.backendtuscuentas.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendtuscuentas.entitys.LogActividade;

public interface ILogActivadesDAO extends JpaRepository<LogActividade, Long> {

	@Query(nativeQuery = true, value = "SELECT ejta.ejta_id,loac.load_id,loac.tilo_id,if(tapr.tapr_descripcion is null,dein.dein_nombretarea,tapr.tapr_nombre) as nombreTarea, \r\n" + 
			" CONCAT_WS(' ', usua.usua_primernombre, usua.usua_primerapellido) as responsable,ejta.ejta_dias\r\n" + 
			" FROM log_actividades loac\r\n" + 
			" LEFT JOIN ejecucion_tarea ejta ON ejta.ejta_id = loac.ejta_id\r\n" + 
			" LEFT JOIN descripcion_indicador dein on dein.ejta_id = ejta.ejta_id\r\n" + 
			" LEFT JOIN usuario usua ON ejta.usua_id = usua.usua_id\r\n" + 
			" LEFT JOIN tarea_empresa taem ON taem.taem_id = ejta.taem_id\r\n" + 
			" LEFT JOIN empresa empr ON empr.empr_id = taem.empr_id\r\n" + 
			" LEFT JOIN tarea_predeterminada tapr ON tapr.tapr_id = taem.tapr_id\r\n" + 
			" WHERE empr.empr_estado <> 0 and \r\n" + 
			" IF(ejta.ejta_id = null,loac.usua_iddevuelve = ?1 and loac_listado = 0 AND ejta.ejta_habil = '1' ,loac.usua_iddevuelve = ?2 and loac_listado = 0 AND ejta.ejta_habil = '1') AND (tilo_id = ?3 )\r\n" + 
			" group by ejta.ejta_id,loac.load_id,dein.dein_nombretarea  ORDER BY loac.load_fecharegistro ASC") 
	public ArrayList<Object[]> listarAlertasPorIdUsuario(long idUsuario,long idUsuario2, long tipolog); 
}
