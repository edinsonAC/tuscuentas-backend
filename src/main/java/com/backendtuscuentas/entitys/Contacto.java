package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cont_id")
	private int contId;

	@Column(name="cont_correo")
	private String contCorreo;

	@Column(name="cont_direccion")
	private String contDireccion;

	@Column(name="cont_documento")
	private String contDocumento;

	@Column(name="cont_facturaciontuscuentas")
	private byte contFacturaciontuscuentas;

	@Column(name="cont_fecharegistro")
	private Timestamp contFecharegistro;

	@Column(name="cont_otrosnombres")
	private String contOtrosnombres;

	@Column(name="cont_primerapellido")
	private String contPrimerapellido;

	@Column(name="cont_primernombre")
	private String contPrimernombre;

	@Column(name="cont_principal")
	private byte contPrincipal;

	@Column(name="cont_registradopor")
	private String contRegistradopor;

	@Column(name="cont_representante")
	private byte contRepresentante;

	@Column(name="cont_segundoapellido")
	private String contSegundoapellido;

	@Column(name="cont_telefono")
	private String contTelefono;

	@Column(name="muni_id")
	private int muniId;

	@Column(name="tido_id")
	private String tidoId;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	public Contacto() {
	}

	public int getContId() {
		return this.contId;
	}

	public void setContId(int contId) {
		this.contId = contId;
	}

	public String getContCorreo() {
		return this.contCorreo;
	}

	public void setContCorreo(String contCorreo) {
		this.contCorreo = contCorreo;
	}

	public String getContDireccion() {
		return this.contDireccion;
	}

	public void setContDireccion(String contDireccion) {
		this.contDireccion = contDireccion;
	}

	public String getContDocumento() {
		return this.contDocumento;
	}

	public void setContDocumento(String contDocumento) {
		this.contDocumento = contDocumento;
	}

	public byte getContFacturaciontuscuentas() {
		return this.contFacturaciontuscuentas;
	}

	public void setContFacturaciontuscuentas(byte contFacturaciontuscuentas) {
		this.contFacturaciontuscuentas = contFacturaciontuscuentas;
	}

	public Timestamp getContFecharegistro() {
		return this.contFecharegistro;
	}

	public void setContFecharegistro(Timestamp contFecharegistro) {
		this.contFecharegistro = contFecharegistro;
	}

	public String getContOtrosnombres() {
		return this.contOtrosnombres;
	}

	public void setContOtrosnombres(String contOtrosnombres) {
		this.contOtrosnombres = contOtrosnombres;
	}

	public String getContPrimerapellido() {
		return this.contPrimerapellido;
	}

	public void setContPrimerapellido(String contPrimerapellido) {
		this.contPrimerapellido = contPrimerapellido;
	}

	public String getContPrimernombre() {
		return this.contPrimernombre;
	}

	public void setContPrimernombre(String contPrimernombre) {
		this.contPrimernombre = contPrimernombre;
	}

	public byte getContPrincipal() {
		return this.contPrincipal;
	}

	public void setContPrincipal(byte contPrincipal) {
		this.contPrincipal = contPrincipal;
	}

	public String getContRegistradopor() {
		return this.contRegistradopor;
	}

	public void setContRegistradopor(String contRegistradopor) {
		this.contRegistradopor = contRegistradopor;
	}

	public byte getContRepresentante() {
		return this.contRepresentante;
	}

	public void setContRepresentante(byte contRepresentante) {
		this.contRepresentante = contRepresentante;
	}

	public String getContSegundoapellido() {
		return this.contSegundoapellido;
	}

	public void setContSegundoapellido(String contSegundoapellido) {
		this.contSegundoapellido = contSegundoapellido;
	}

	public String getContTelefono() {
		return this.contTelefono;
	}

	public void setContTelefono(String contTelefono) {
		this.contTelefono = contTelefono;
	}

	public int getMuniId() {
		return this.muniId;
	}

	public void setMuniId(int muniId) {
		this.muniId = muniId;
	}

	public String getTidoId() {
		return this.tidoId;
	}

	public void setTidoId(String tidoId) {
		this.tidoId = tidoId;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}