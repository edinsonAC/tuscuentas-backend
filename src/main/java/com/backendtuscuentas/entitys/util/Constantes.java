package com.backendtuscuentas.entitys.util;

public class Constantes {

	public static final boolean ENVIO_MENSAJE = false;
	public static final String RESPONSE_MENSAJE_REJECTED = "REJECTED";
	public static final String RESPONSE_MENSAJE_ENVIADO = "PENDING";
	public static final String USUARIO_ACTIVO = "1";
	public static final String ACTIVIDAD_EJECUCION = "1";
	public static final String ACTIVIDAD_REVISION = "2";
	public static final String ACTIVIDAD_APROBACION = "3";
	public static final String ACTIVIDAD_RECEPCION = "4";
	public static final String ESTADO_ACTIVO_EJECUCION = "1";
	public static final String ESTADO_ACTIVO_TAREA_EMPRESA = "1";
	public static final String CALENDARIO_TRIBUTARIO_TRUE = "1";
	public static final String TAREA_GERENTE = "1";
	public static final String TAREA_NO_GERENTE = "0";
	public static final String TAREA_IMPUESTO = "1";
	public static final String TAREA_NO_IMPUESTO = "0";
	public static final String RECURRENCIA_DIARIA = "1";
	public static final String RECURRENCIA_MENSUAL = "2";
	public static final String RECURRENCIA_ANUAL = "3";
	public static final String RECURRENCIA_QUINCENAL = "4";
	public static final String RECURRENCIA_DECADAL = "5";
	public static final String RECURRENCIA_SEMANAL = "6";
	public static final String TAREA_ESTADO_NEUTRA = "0";
	public static final String TAREA_ESTADO_ABIERTA = "1";
	public static final String TAREA_ESTADO_ATRASADA = "2";
	public static final String TAREA_ESTADO_CERRADA = "3";
	public static final String PRORROGA_ESTADO_NEUTRA = "0";
	public static final String PRORROGA_ESTADO_ACTIVO = "1";
	public static final String PRORROGA_ESTADO_RECHAZADA = "2";
	public static final String PRORROGA_ESTADO_PENDIENTE = "3";
	public static final String PRORROGA_ESTADO_RECHAZADA_PENDIENTE = "4";
	public static final String TAREA_EMPRESA_ACTIVA = "1";
	public static final String LOG_ESTADO_ASIGNAR = "1";
	public static final String LOG_ESTADO_DEVUELTA = "2";
	public static final String LOG_ESTADO_ATRASADA = "3";
	public static final String LOG_PEDIR_PRORROGA = "6";
	public static final String LOG_COMENTARIO_NUEVO = "11";
	public static final String LOG_OBSERVAR = "9";
	public static final String LOG_CAMBIO_ESTADO = "10";
	public static final String LOG_TAREA_NUEVA = "14";
	public static final String LOG_COMPLETAR_INFORMACION = "15";
	public static final String LOG_CONTRATO_NUEVO = "12";
	public static final String LOG_REPORTE_SIIGO = "18";
	public static final String LOG_ERROR_LOGUEO_SIIGO = "19";
	public static final String LOG_CAMBIO_ROL = "20";
	public static final String LOG_REABRIR_TAREA = "21";
	public static final String ALERTA_CARTERA_VENCIDA = "1";
	public static final String ALERTA_VENTA_CARTERA_VENCIDA = "2";

	public static final String ALERTA_MARGEN_RENTABILIDAD_INVENTARIO = "3";

	public static final String ALERTA_VARIACION_INGRESOS = "4";

	public static final String ALERTA_VARIACION_COSTOS = "5";

	public static final String ALERTA_VARIACION_GASTOS = "6";

	public static final String ALERTA_LIQUIDEZ_PAGO_IMPUESTOS = "7";

	public static final String LOG_ESTADO_ESCALADA_INTERVENTOR = "4";

	public static final String LOG_ESTADO_ESCALADA_SUPERVISOR = "5";

	public static final String LOG_ESTADO_CARGUE_FINALIZADO = "8";

	public static final String OBSERVACION_EJECUCION_ATRASADA = "La actividad cambio de estado : ATRASADA.";

	public static final String OBSERVACION_EJECUCION_ABIERTA = "La actividad cambio de estado : ABIERTA.";

	public static final String OBSERVACION_EJECUCION_DEVUELTA = "La actividad cambio de estado : DEVUELTO";

	public static final String OBSERVACION_EJECUCION_ESCALADA_INTERVENTOR = "La actividad le fue escalada : ATRASADA.";

	public static final String OBSERVACION_EJECUCION_ESCALADA_SUPERVISOR = "La actividad le fue escalada : ATRASADA.";

	public static final String TAREAS_EMPRESA_INICIADA = "1";

	public static final String TAREAS_EMPRESA_INICIADA_INACTIVAR = "2";

	public static final String TAREAS_EMPRESA_SIN_INICIAR = "0";

	public static final String OBSERVACION_CARGUE_TAREAS_FINALIZO_EXITO = "El cargue de tareas finalizó con exito";

	public static final String OBSERVACION_CARGUE_TAREAS_FINALIZO_ERROR = "El cargue de tareas finalizó con errores,intentelo mas tarde";

	public static final String ID_ADMINTUSCUENTAS = "1";

	public static final String ID_ADMIEMPRESA = "2";

	public static final String ID_CONTADOR = "3";

	public static final String ID_INTERVENTOR = "4";

	public static final String ID_SUPERVISOR = "5";

	public static final String ID_ESTANDAR = "6";

	public static final String ID_GERENTE = "7";

	public static final String ID_VENDEDOR = "8";

	public static final String ID_TAREAGENERICA = "1";

	public static final String ID_TAREA_ALERTA_TEMPRANA = "2";

	public static final long ID_CARGO_CONTADOR = 12;

	public static final String OBSERVAR = "1";

	public static final String ASIGNAR = "2";

	public static final String COMENTAR = "3";

	public static final String DEVOLVER = "4";

	public static final String CONTRATO = "5";

	public static final String CONTRATO_FIRMADO = "8";

	public static final String CAMBIAR_ESTADO_EMPRESA = "6";

	public static final String TAREA = "14";

	public static final String ERROR_LOGUEO_SIIGO = "9";

	public static final String PEDIR_PRORROGA = "10";

	public static final String PROCESO_PEDIR_CONTADOR = "93";

	public static final String PROCESO_IMPLEMENTACION_SIIGO = "94";

	public static final String PROCESO_REIMPLEMENTACION_SIIGO = "95";

	public static final String AREA_IMPOSITIVOS = "13";

	public static final String LOG_PASO_PRODUCCION = "13";

	public static final String LOG_CONTRATO_FIRMADO = "16";

	public static final String AMBIENTE_PRODUCCION = "produccion";

	public static final String AMBIENTE_PRUEBA = "prueba";

	public static final String ESTADO_LOG_LEIDO = "1";

	public static final String ESTADO_LOG_NO_LEIDO = "0";

	public static final String PROCESO_NO_IMPUESTO = "0";

	public static final String PROCESO_IMPUESTO = "1";

	public static final String TAREA_ABIERTA_CORREO = "7";

	public static final String LOG_PARA_SEGUIMIENTO = "17";

	public static final String PRIMER_PASO = "EJECUCIÓN";

	public static final String SEGUNDO_PASO = "REVISIÓN";

	public static final String TERCERO_PASO = "APROBACIÓN";

	public static final String CUARTO_PASO = "RECEPCIÓN";

	public static final String CALENDARIO_CUANDO_APLIQUE = "31";

	public static final String NOTICIA_PRINCIPAL = "noticia1.png";

}
