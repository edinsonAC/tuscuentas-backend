package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;

/**
 * The persistent class for the documentos_comentario database table.
 * 
 */
@Data
@Entity
@Table(name = "documentos_comentario")
public class DocumentosComentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "doco_id")
	private Long docoId;

	@Column(name = "doco_fecharegistro")
	private Timestamp docoFecharegistro;

	@Column(name = "doco_nombredocumento")
	private String docoNombredocumento;

	@Column(name = "doco_registradopor")
	private String docoRegistradopor;

	// bi-directional many-to-one association to ComentariosTarea
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cota_id")
	private ComentariosTarea comentariosTarea;

	public DocumentosComentario() {
	}

}