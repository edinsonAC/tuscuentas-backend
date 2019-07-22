package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usua_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuaId;

	@Column(name = "caem_id")
	private Long caemId;

	@Column(name = "coju_id")
	private Long cojuId;

	@Column(name = "coju_nuevo")
	private String cojuNuevo;

	@Column(name = "coju_ppal")
	private byte cojuPpal;

	@Column(name = "empr_id")
	private Long emprId;

	@JsonIgnore
	@Column(name = "muni_id")
	private Long muniId;

	@Column(name = "tido_id")
	private int tidoId;

	@Column(name = "usua_celular")
	private String usuaCelular;

	@Column(name = "usua_correo")
	private String usuaCorreo;

	@Column(name = "usua_direccion")
	private String usuaDireccion;

	@Column(name = "usua_documento")
	private String usuaDocumento;

	@Column(name = "usua_dv")
	private String usuaDv;

	@Column(name = "usua_eficacia")
	private String usuaEficacia;

	@Column(name = "usua_estado")
	private byte usuaEstado;

	@Column(name = "usua_fecharegistro")
	private Timestamp usuaFecharegistro;

	@Column(name = "usua_grupo")
	private String usuaGrupo;

	@Column(name = "usua_imgperfil")
	private String usuaImgperfil;

	@Column(name = "usua_numtarjeta")
	private String usuaNumtarjeta;

	@Column(name = "usua_otrosnombres")
	private String usuaOtrosnombres;

	@Column(name = "usua_password")
	private String usuaPassword;

	@Column(name = "usua_passwordlearning")
	private String usuaPasswordlearning;

	@Column(name = "usua_primerapellido")
	private String usuaPrimerapellido;

	@Column(name = "usua_primernombre")
	private String usuaPrimernombre;

	@Column(name = "usua_registradopor")
	private String usuaRegistradopor;

	@Column(name = "usua_segundoapellido")
	private String usuaSegundoapellido;

	@Column(name = "usua_telefono")
	private String usuaTelefono;

	@Column(name = "usua_token")
	private String usuaToken;

	@Column(name = "usua_token_app")
	private String usuaTokenApp;

	@Column(name = "usua_usuario")
	private String usuaUsuario;

	// bi-directional many-to-one association to AlertaUsuario

	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<AlertaUsuario> alertaUsuarios;

	// bi-directional many-to-one association to Alerta
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Alerta> alertas;

	// bi-directional many-to-one association to ContadorEmpresa
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<ContadorEmpresa> contadorEmpresas;

	// bi-directional many-to-one association to Empresa
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Empresa> empresas;

	// bi-directional many-to-one association to InterventorContador
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<InterventorContador> interventorContadors;

	// bi-directional many-to-one association to LogActividade
	@JsonIgnore
	@OneToMany(mappedBy = "usuario1", fetch = FetchType.LAZY)
	private List<LogActividade> logActividades1;

	// bi-directional many-to-one association to LogActividade
	@JsonIgnore
	@OneToMany(mappedBy = "usuario2", fetch = FetchType.LAZY)
	private List<LogActividade> logActividades2;

	// bi-directional many-to-one association to PagoContador
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<PagoContador> pagoContadors;

	// bi-directional many-to-one association to SupervisorInterventor
	@JsonIgnore
	@OneToMany(mappedBy = "usuario1", fetch = FetchType.LAZY)
	private List<SupervisorInterventor> supervisorInterventors1;

	// bi-directional many-to-one association to SupervisorInterventor
	@JsonIgnore
	@OneToMany(mappedBy = "usuario2", fetch = FetchType.LAZY)
	private List<SupervisorInterventor> supervisorInterventors2;

	// bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tius_id")
	private TipoUsuario tipoUsuario;

	// bi-directional many-to-one association to UsuarioFuncionalidad
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<UsuarioFuncionalidad> usuarioFuncionalidads;

	// bi-directional many-to-one association to Visualizar
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Visualizar> visualizars;

}