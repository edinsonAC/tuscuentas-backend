package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Data
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emprId;

	@Column(name="emp_primerapellido")
	private String empPrimerapellido;

	@Column(name="empr_calificacion")
	private String emprCalificacion;

	@Column(name="empr_calificacioncontador")
	private String emprCalificacioncontador;

	@Column(name="empr_cargueinicial")
	private byte emprCargueinicial;

	@Column(name="empr_celular")
	private String emprCelular;

	@Column(name="empr_contrato")
	private byte emprContrato;

	@Column(name="empr_correo")
	private String emprCorreo;

	@Column(name="empr_direccion")
	private String emprDireccion;

	@Column(name="empr_documento")
	private String emprDocumento;

	@Column(name="empr_domingo")
	private byte emprDomingo;

	@Column(name="empr_dv")
	private String emprDv;

	@Column(name="empr_estado")
	private byte emprEstado;

	@Column(name="empr_estadoanterior")
	private int emprEstadoanterior;

	@Column(name="empr_estadoregistro")
	private String emprEstadoregistro;

	@Column(name="empr_fechafacturacion")
	private String emprFechafacturacion;

	@Column(name="empr_fechafinal")
	private String emprFechafinal;

	@Column(name="empr_fechainicial")
	private String emprFechainicial;

	@Column(name="empr_fecharegistro")
	private Timestamp emprFecharegistro;

	@Column(name="empr_festivos")
	private byte emprFestivos;

	@Column(name="empr_implementacion")
	private byte emprImplementacion;

	@Column(name="empr_implementadosiigo")
	private byte emprImplementadosiigo;

	@Column(name="empr_logo")
	private String emprLogo;

	@Column(name="empr_nit")
	private String emprNit;

	@Column(name="empr_nombre")
	private String emprNombre;

	@Column(name="empr_nombrecomercial")
	private String emprNombrecomercial;

	@Column(name="empr_numcontrato")
	private String emprNumcontrato;

	@Column(name="empr_otrosnombres")
	private String emprOtrosnombres;

	private String empr_passwordSiigo;

	@Column(name="empr_personajuridica")
	private byte emprPersonajuridica;

	@Column(name="empr_personanatural")
	private byte emprPersonanatural;

	@Column(name="empr_primernombre")
	private String emprPrimernombre;

	@Column(name="empr_registradopor")
	private String emprRegistradopor;

	@Column(name="empr_sabado")
	private byte emprSabado;

	@Column(name="empr_segundoapellido")
	private String emprSegundoapellido;

	@Column(name="empr_telefono")
	private String emprTelefono;

	private String empr_userSiigo;

	@Column(name="empr_valorcontador")
	private String emprValorcontador;

	@Column(name="muni_id")
	private String muniId;

	@Column(name="rele_id")
	private int releId;

	//bi-directional many-to-one association to AlertaTempranaEmpresa
	@OneToMany(mappedBy="empresa")
	private List<AlertaTempranaEmpresa> alertaTempranaEmpresas;

	//bi-directional many-to-one association to CierreCuenta
	@OneToMany(mappedBy="empresa")
	private List<CierreCuenta> cierreCuentas;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="empresa")
	private List<Contacto> contactos;

	//bi-directional many-to-one association to ContadorEmpresa
	@OneToMany(mappedBy="empresa")
	private List<ContadorEmpresa> contadorEmpresas;

	//bi-directional many-to-one association to ContratoTuscuenta
	@OneToMany(mappedBy="empresa")
	private List<ContratoTuscuenta> contratoTuscuentas;

	//bi-directional many-to-one association to DiasPago
	@OneToMany(mappedBy="empresa")
	private List<DiasPago> diasPagos;

	//bi-directional many-to-one association to DocumentosEmpresa
	@OneToMany(mappedBy="empresa")
	private List<DocumentosEmpresa> documentosEmpresas;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tido_id")
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to ContadorJuridico
	@ManyToOne
	@JoinColumn(name="coju_id")
	private ContadorJuridico contadorJuridico;

	//bi-directional many-to-one association to TipoRegimen
	@ManyToOne
	@JoinColumn(name="tire_id")
	private TipoRegimen tipoRegimen;

	//bi-directional many-to-one association to TipoEmpresa
	@ManyToOne
	@JoinColumn(name="tiem_id")
	private TipoEmpresa tipoEmpresa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="vend_id")
	private Usuario usuario;

	//bi-directional many-to-one association to MaestroReporteCarteraVencida
	@OneToMany(mappedBy="empresa")
	private List<MaestroReporteCarteraVencida> maestroReporteCarteraVencidas;

	//bi-directional many-to-one association to MaestroReporteLiquidezImpuesto
	@OneToMany(mappedBy="empresa")
	private List<MaestroReporteLiquidezImpuesto> maestroReporteLiquidezImpuestos;

	//bi-directional many-to-one association to MaestroReporteVentaClienteCarteraVencida
	@OneToMany(mappedBy="empresa")
	private List<MaestroReporteVentaClienteCarteraVencida> maestroReporteVentaClienteCarteraVencidas;

	//bi-directional many-to-one association to ProcesoEmpresa
	@OneToMany(mappedBy="empresa")
	private List<ProcesoEmpresa> procesoEmpresas;

	public Empresa() {
	}


}