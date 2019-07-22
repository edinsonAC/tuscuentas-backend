package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the representante_legal database table.
 * 
 */
@Entity
@Table(name="representante_legal")
@NamedQuery(name="RepresentanteLegal.findAll", query="SELECT r FROM RepresentanteLegal r")
public class RepresentanteLegal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rele_id")
	private int releId;

	@Column(name="coju_id")
	private int cojuId;

	@Column(name="empr_id")
	private int emprId;

	@Column(name="muni_id")
	private int muniId;

	@Column(name="rele_celular")
	private String releCelular;

	@Column(name="rele_correo")
	private String releCorreo;

	@Column(name="rele_direccion")
	private String releDireccion;

	@Column(name="rele_documento")
	private String releDocumento;

	@Column(name="rele_dv")
	private String releDv;

	@Column(name="rele_empresa")
	private byte releEmpresa;

	@Column(name="rele_fecharegistro")
	private Timestamp releFecharegistro;

	@Column(name="rele_otrosnombres")
	private String releOtrosnombres;

	@Column(name="rele_primerapellido")
	private String relePrimerapellido;

	@Column(name="rele_primernombre")
	private String relePrimernombre;

	@Column(name="rele_registradopor")
	private String releRegistradopor;

	@Column(name="rele_segundoapellido")
	private String releSegundoapellido;

	@Column(name="rele_telefono")
	private String releTelefono;

	@Column(name="tido_id")
	private int tidoId;

	public RepresentanteLegal() {
	}

	public int getReleId() {
		return this.releId;
	}

	public void setReleId(int releId) {
		this.releId = releId;
	}

	public int getCojuId() {
		return this.cojuId;
	}

	public void setCojuId(int cojuId) {
		this.cojuId = cojuId;
	}

	public int getEmprId() {
		return this.emprId;
	}

	public void setEmprId(int emprId) {
		this.emprId = emprId;
	}

	public int getMuniId() {
		return this.muniId;
	}

	public void setMuniId(int muniId) {
		this.muniId = muniId;
	}

	public String getReleCelular() {
		return this.releCelular;
	}

	public void setReleCelular(String releCelular) {
		this.releCelular = releCelular;
	}

	public String getReleCorreo() {
		return this.releCorreo;
	}

	public void setReleCorreo(String releCorreo) {
		this.releCorreo = releCorreo;
	}

	public String getReleDireccion() {
		return this.releDireccion;
	}

	public void setReleDireccion(String releDireccion) {
		this.releDireccion = releDireccion;
	}

	public String getReleDocumento() {
		return this.releDocumento;
	}

	public void setReleDocumento(String releDocumento) {
		this.releDocumento = releDocumento;
	}

	public String getReleDv() {
		return this.releDv;
	}

	public void setReleDv(String releDv) {
		this.releDv = releDv;
	}

	public byte getReleEmpresa() {
		return this.releEmpresa;
	}

	public void setReleEmpresa(byte releEmpresa) {
		this.releEmpresa = releEmpresa;
	}

	public Timestamp getReleFecharegistro() {
		return this.releFecharegistro;
	}

	public void setReleFecharegistro(Timestamp releFecharegistro) {
		this.releFecharegistro = releFecharegistro;
	}

	public String getReleOtrosnombres() {
		return this.releOtrosnombres;
	}

	public void setReleOtrosnombres(String releOtrosnombres) {
		this.releOtrosnombres = releOtrosnombres;
	}

	public String getRelePrimerapellido() {
		return this.relePrimerapellido;
	}

	public void setRelePrimerapellido(String relePrimerapellido) {
		this.relePrimerapellido = relePrimerapellido;
	}

	public String getRelePrimernombre() {
		return this.relePrimernombre;
	}

	public void setRelePrimernombre(String relePrimernombre) {
		this.relePrimernombre = relePrimernombre;
	}

	public String getReleRegistradopor() {
		return this.releRegistradopor;
	}

	public void setReleRegistradopor(String releRegistradopor) {
		this.releRegistradopor = releRegistradopor;
	}

	public String getReleSegundoapellido() {
		return this.releSegundoapellido;
	}

	public void setReleSegundoapellido(String releSegundoapellido) {
		this.releSegundoapellido = releSegundoapellido;
	}

	public String getReleTelefono() {
		return this.releTelefono;
	}

	public void setReleTelefono(String releTelefono) {
		this.releTelefono = releTelefono;
	}

	public int getTidoId() {
		return this.tidoId;
	}

	public void setTidoId(int tidoId) {
		this.tidoId = tidoId;
	}

}