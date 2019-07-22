package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the documentos_comentario database table.
 * 
 */
@Entity
@Table(name="documentos_comentario")
@NamedQuery(name="DocumentosComentario.findAll", query="SELECT d FROM DocumentosComentario d")
public class DocumentosComentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="doco_id")
	private int docoId;

	@Column(name="doco_fecharegistro")
	private Timestamp docoFecharegistro;

	@Column(name="doco_nombredocumento")
	private String docoNombredocumento;

	@Column(name="doco_registradopor")
	private String docoRegistradopor;

	//bi-directional many-to-one association to ComentariosTarea
	@ManyToOne
	@JoinColumn(name="cota_id")
	private ComentariosTarea comentariosTarea;

	public DocumentosComentario() {
	}

	public int getDocoId() {
		return this.docoId;
	}

	public void setDocoId(int docoId) {
		this.docoId = docoId;
	}

	public Timestamp getDocoFecharegistro() {
		return this.docoFecharegistro;
	}

	public void setDocoFecharegistro(Timestamp docoFecharegistro) {
		this.docoFecharegistro = docoFecharegistro;
	}

	public String getDocoNombredocumento() {
		return this.docoNombredocumento;
	}

	public void setDocoNombredocumento(String docoNombredocumento) {
		this.docoNombredocumento = docoNombredocumento;
	}

	public String getDocoRegistradopor() {
		return this.docoRegistradopor;
	}

	public void setDocoRegistradopor(String docoRegistradopor) {
		this.docoRegistradopor = docoRegistradopor;
	}

	public ComentariosTarea getComentariosTarea() {
		return this.comentariosTarea;
	}

	public void setComentariosTarea(ComentariosTarea comentariosTarea) {
		this.comentariosTarea = comentariosTarea;
	}

}