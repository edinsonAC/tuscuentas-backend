package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the comentarios_tarea database table.
 * 
 */
@Data
@Entity
@Table(name="comentarios_tarea")
public class ComentariosTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cota_id")
	private Long cotaId;

	@Column(name="acte_id")
	private Long acteId;

	@Column(name="comentarios_tareacol")
	private String comentariosTareacol;

	@Column(name="cota_comentario")
	private String cotaComentario;

	@Column(name="cota_fecharegistro")
	private Timestamp cotaFecharegistro;

	@Column(name="cota_registradopor")
	private String cotaRegistradopor;

	@Column(name="cota_userinvited")
	private Long cotaUserinvited;

	@Column(name="tico_id")
	private Long ticoId;

	@Column(name="usua_id")
	private Long usuaId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	//bi-directional many-to-one association to DocumentosComentario
	@OneToMany(mappedBy="comentariosTarea")
	private List<DocumentosComentario> documentosComentarios;

	public ComentariosTarea() {
	}


}