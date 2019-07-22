package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tius_id")
	private Long tiusId;

	@Column(name="tius_descripcion")
	private String tiusDescripcion;

	@Column(name="tius_fecharegistro")
	private Timestamp tiusFecharegistro;

	@Column(name="tius_registradopor")
	private String tiusRegistradopor;

	//bi-directional many-to-one association to TipoUsuarioFuncionalidad
	@JsonIgnore
	@OneToMany(mappedBy="tipoUsuario", fetch = FetchType.LAZY)
	private List<TipoUsuarioFuncionalidad> tipoUsuarioFuncionalidads;

	//bi-directional many-to-one association to TipoUsuarioTipoLog
	@JsonIgnore
	@OneToMany(mappedBy="tipoUsuario", fetch = FetchType.LAZY)
	private List<TipoUsuarioTipoLog> tipoUsuarioTipoLogs;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="tipoUsuario", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public TipoUsuario() {
	}

}