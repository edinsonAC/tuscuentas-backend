package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="noti_id")
	private int notiId;

	@Column(name="noti_fechafinal")
	private String notiFechafinal;

	@Column(name="noti_fechainicial")
	private String notiFechainicial;

	@Column(name="noti_img")
	private String notiImg;

	@Column(name="noti_principal")
	private String notiPrincipal;

	public Noticia() {
	}

	public int getNotiId() {
		return this.notiId;
	}

	public void setNotiId(int notiId) {
		this.notiId = notiId;
	}

	public String getNotiFechafinal() {
		return this.notiFechafinal;
	}

	public void setNotiFechafinal(String notiFechafinal) {
		this.notiFechafinal = notiFechafinal;
	}

	public String getNotiFechainicial() {
		return this.notiFechainicial;
	}

	public void setNotiFechainicial(String notiFechainicial) {
		this.notiFechainicial = notiFechainicial;
	}

	public String getNotiImg() {
		return this.notiImg;
	}

	public void setNotiImg(String notiImg) {
		this.notiImg = notiImg;
	}

	public String getNotiPrincipal() {
		return this.notiPrincipal;
	}

	public void setNotiPrincipal(String notiPrincipal) {
		this.notiPrincipal = notiPrincipal;
	}

}