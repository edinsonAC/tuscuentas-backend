package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the alerta_usuario database table.
 * 
 */
@Data
@Entity
@Table(name="alerta_usuario")
public class AlertaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alus_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alusId;

	@Column(name="alus_correo")
	private String alusCorreo;

	@Column(name="alus_plataforma")
	private String alusPlataforma;

	//bi-directional many-to-one association to TipoLog
	@ManyToOne
	@JoinColumn(name="tilo_id")
	private TipoLog tipoLog;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usua_id")
	private Usuario usuario;

	public AlertaUsuario() {
	}

}