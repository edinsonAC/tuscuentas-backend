package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_log database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_log")
public class TipoLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tilo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tiloId;

	@Column(name="tilo_copy")
	private String tiloCopy;

	@Column(name="tilo_descripcion")
	private String tiloDescripcion;

	@Column(name="tilo_estado")
	private String tiloEstado;

	@Column(name="tilo_fecharegistro")
	private Timestamp tiloFecharegistro;

	@Column(name="tilo_registradopor")
	private String tiloRegistradopor;

	@Column(name="tilo_titulo")
	private String tiloTitulo;

	//bi-directional many-to-one association to AlertaUsuario
	@OneToMany(mappedBy="tipoLog")
	private List<AlertaUsuario> alertaUsuarios;

	//bi-directional many-to-one association to LogActividade
	@OneToMany(mappedBy="tipoLog")
	private List<LogActividade> logActividades;

	//bi-directional many-to-one association to TipoUsuarioTipoLog
	@OneToMany(mappedBy="tipoLog")
	private List<TipoUsuarioTipoLog> tipoUsuarioTipoLogs;

	public TipoLog() {
	}

}