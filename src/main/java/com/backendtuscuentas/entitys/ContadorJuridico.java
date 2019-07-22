package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the contador_juridico database table.
 * 
 */
@Data
@Entity
@Table(name="contador_juridico")
public class ContadorJuridico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coju_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cojuId;

	@Column(name="coju_calificacion")
	private String cojuCalificacion;

	@Column(name="coju_celular")
	private String cojuCelular;

	@Column(name="coju_contrato")
	private byte cojuContrato;

	@Column(name="coju_correo")
	private String cojuCorreo;

	@Column(name="coju_cuentabancaria")
	private String cojuCuentabancaria;

	@Column(name="coju_direccion")
	private String cojuDireccion;

	@Column(name="coju_documento")
	private String cojuDocumento;

	@Column(name="coju_dv")
	private String cojuDv;

	@Column(name="coju_empresa")
	private byte cojuEmpresa;

	@Column(name="coju_estado")
	private byte cojuEstado;

	@Column(name="coju_fechafinalizacion")
	private String cojuFechafinalizacion;

	@Column(name="coju_fecharegistro")
	private Timestamp cojuFecharegistro;

	@Column(name="coju_nit")
	private String cojuNit;

	@Column(name="coju_nombrecomercial")
	private String cojuNombrecomercial;

	@Column(name="coju_numerocontrato")
	private String cojuNumerocontrato;

	@Column(name="coju_numtarjeta")
	private String cojuNumtarjeta;

	@Column(name="coju_otrosnombres")
	private String cojuOtrosnombres;

	@Column(name="coju_primerapellido")
	private String cojuPrimerapellido;

	@Column(name="coju_primernombre")
	private String cojuPrimernombre;

	@Column(name="coju_razonsocial")
	private String cojuRazonsocial;

	@Column(name="coju_registradopor")
	private String cojuRegistradopor;

	@Column(name="coju_rut")
	private String cojuRut;

	@Column(name="coju_segundoapellido")
	private String cojuSegundoapellido;

	@Column(name="coju_telefono")
	private String cojuTelefono;

	@Column(name="coju_tipocuentabancaria")
	private byte cojuTipocuentabancaria;

	@Column(name="tico_id")
	private int ticoId;

	@Column(name="tire_id")
	private int tireId;

	@Column(name="vendedor_id")
	private int vendedorId;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="banc_id")
	private Banco banco;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="muni_id")
	private Municipio municipio;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tido_id")
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to DocumentosEmpresa
	@OneToMany(mappedBy="contadorJuridico")
	private List<DocumentosEmpresa> documentosEmpresas;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="contadorJuridico")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to InterventorContador
	@OneToMany(mappedBy="contadorJuridico")
	private List<InterventorContador> interventorContadors;

	//bi-directional many-to-one association to PagoContador
	@OneToMany(mappedBy="contadorJuridico")
	private List<PagoContador> pagoContadors;

	public ContadorJuridico() {
	}

}