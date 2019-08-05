package com.backendtuscuentas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendtuscuentas.dao.ICheckListDao;
import com.backendtuscuentas.dao.IEjecucionTareaDAO;
import com.backendtuscuentas.entitys.Checklist;
import com.backendtuscuentas.entitys.ChecklistActividadempresa;
import com.backendtuscuentas.entitys.EjecucionTarea;
import com.backendtuscuentas.entitys.util.Alerta;
import com.backendtuscuentas.entitys.util.Paso;
import com.backendtuscuentas.services.IEjecucionTareaService;

@Service
public class EjcucionTareaServiceImpl implements IEjecucionTareaService {

	@Autowired
	private IEjecucionTareaDAO ejecucionTareaDao;

	@Autowired
	private ICheckListDao checklistDao;

	@Override
	public EjecucionTarea verEjecucionTarea(long id) {
		EjecucionTarea ejecucion = ejecucionTareaDao.findById(id).orElse(null);
		List<Checklist> checks = null;
		ArrayList<Object[]> objetos = new ArrayList<Object[]>();
		ArrayList<Paso> pasos = new ArrayList<>();
		if (ejecucion != null) {
			if (ejecucion.getChecklistActividadempresas() != null
					&& !ejecucion.getChecklistActividadempresas().isEmpty()) {
				checks = new ArrayList<>();
				for (ChecklistActividadempresa check : ejecucion.getChecklistActividadempresas()) {
					checks.add(checklistDao.findById(check.getClacId()).orElse(null));

				}
				ejecucion.setChecklist(checks);

				objetos = ejecucionTareaDao.listarPasosPorEjecucion(id, id);

				if (objetos != null) {
					for (Object[] object : objetos) {
						pasos.add(new Paso(new Long((Integer) object[0]), (String) object[1].toString(),
								(String) object[2], (String) object[3], (String) object[4]));
					}

					ejecucion.setPasos(pasos);
				}

			}

		}

		return ejecucionTareaDao.findById(id).orElse(null);
	}

}
