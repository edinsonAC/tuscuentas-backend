package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_usuario_tipo_log database table.
 * 
 */
@Entity
@Table(name="tipo_usuario_tipo_log")
@NamedQuery(name="TipoUsuarioTipoLog.findAll", query="SELECT t FROM TipoUsuarioTipoLog t")
public class TipoUsuarioTipoLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tutl_id")
	private int tutlId;

	//bi-directional many-to-one association to TipoLog
	@ManyToOne
	@JoinColumn(name="tilo_id")
	private TipoLog tipoLog;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="tius_id")
	private TipoUsuario tipoUsuario;

	public TipoUsuarioTipoLog() {
	}

	public int getTutlId() {
		return this.tutlId;
	}

	public void setTutlId(int tutlId) {
		this.tutlId = tutlId;
	}

	public TipoLog getTipoLog() {
		return this.tipoLog;
	}

	public void setTipoLog(TipoLog tipoLog) {
		this.tipoLog = tipoLog;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}