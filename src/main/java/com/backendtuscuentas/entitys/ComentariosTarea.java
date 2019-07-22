package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the comentarios_tarea database table.
 * 
 */
@Entity
@Table(name="comentarios_tarea")
@NamedQuery(name="ComentariosTarea.findAll", query="SELECT c FROM ComentariosTarea c")
public class ComentariosTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cota_id")
	private int cotaId;

	@Column(name="acte_id")
	private int acteId;

	@Column(name="comentarios_tareacol")
	private String comentariosTareacol;

	@Column(name="cota_comentario")
	private String cotaComentario;

	@Column(name="cota_fecharegistro")
	private Timestamp cotaFecharegistro;

	@Column(name="cota_registradopor")
	private String cotaRegistradopor;

	@Column(name="cota_userinvited")
	private int cotaUserinvited;

	@Column(name="tico_id")
	private int ticoId;

	@Column(name="usua_id")
	private int usuaId;

	//bi-directional many-to-one association to EjecucionTarea
	@ManyToOne
	@JoinColumn(name="ejta_id")
	private EjecucionTarea ejecucionTarea;

	//bi-directional many-to-one association to DocumentosComentario
	@OneToMany(mappedBy="comentariosTarea")
	private List<DocumentosComentario> documentosComentarios;

	public ComentariosTarea() {
	}

	public int getCotaId() {
		return this.cotaId;
	}

	public void setCotaId(int cotaId) {
		this.cotaId = cotaId;
	}

	public int getActeId() {
		return this.acteId;
	}

	public void setActeId(int acteId) {
		this.acteId = acteId;
	}

	public String getComentariosTareacol() {
		return this.comentariosTareacol;
	}

	public void setComentariosTareacol(String comentariosTareacol) {
		this.comentariosTareacol = comentariosTareacol;
	}

	public String getCotaComentario() {
		return this.cotaComentario;
	}

	public void setCotaComentario(String cotaComentario) {
		this.cotaComentario = cotaComentario;
	}

	public Timestamp getCotaFecharegistro() {
		return this.cotaFecharegistro;
	}

	public void setCotaFecharegistro(Timestamp cotaFecharegistro) {
		this.cotaFecharegistro = cotaFecharegistro;
	}

	public String getCotaRegistradopor() {
		return this.cotaRegistradopor;
	}

	public void setCotaRegistradopor(String cotaRegistradopor) {
		this.cotaRegistradopor = cotaRegistradopor;
	}

	public int getCotaUserinvited() {
		return this.cotaUserinvited;
	}

	public void setCotaUserinvited(int cotaUserinvited) {
		this.cotaUserinvited = cotaUserinvited;
	}

	public int getTicoId() {
		return this.ticoId;
	}

	public void setTicoId(int ticoId) {
		this.ticoId = ticoId;
	}

	public int getUsuaId() {
		return this.usuaId;
	}

	public void setUsuaId(int usuaId) {
		this.usuaId = usuaId;
	}

	public EjecucionTarea getEjecucionTarea() {
		return this.ejecucionTarea;
	}

	public void setEjecucionTarea(EjecucionTarea ejecucionTarea) {
		this.ejecucionTarea = ejecucionTarea;
	}

	public List<DocumentosComentario> getDocumentosComentarios() {
		return this.documentosComentarios;
	}

	public void setDocumentosComentarios(List<DocumentosComentario> documentosComentarios) {
		this.documentosComentarios = documentosComentarios;
	}

	public DocumentosComentario addDocumentosComentario(DocumentosComentario documentosComentario) {
		getDocumentosComentarios().add(documentosComentario);
		documentosComentario.setComentariosTarea(this);

		return documentosComentario;
	}

	public DocumentosComentario removeDocumentosComentario(DocumentosComentario documentosComentario) {
		getDocumentosComentarios().remove(documentosComentario);
		documentosComentario.setComentariosTarea(null);

		return documentosComentario;
	}

}