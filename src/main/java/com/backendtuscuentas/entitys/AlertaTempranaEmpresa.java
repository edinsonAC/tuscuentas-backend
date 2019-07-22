package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the alerta_temprana_empresa database table.
 * 
 */
@Data
@Entity
@Table(name="alerta_temprana_empresa")
public class AlertaTempranaEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="atem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long atemId;

	@Column(name="atem_fecharegistro")
	private Timestamp atemFecharegistro;

	@Column(name="atem_nivelpresentacion")
	private String atemNivelpresentacion;

	@Column(name="atem_registradopor")
	private String atemRegistradopor;

	@Column(name="atem_sologerente")
	private String atemSologerente;

	//bi-directional many-to-one association to AlertaTemprana
	@ManyToOne
	@JoinColumn(name="alte_id")
	private AlertaTemprana alertaTemprana;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;

	//bi-directional many-to-one association to Frecuencia
	@ManyToOne
	@JoinColumn(name="frec_id")
	private Frecuencia frecuencia;

	//bi-directional many-to-one association to ParametrosAlertaEmpresa
	@OneToMany(mappedBy="alertaTempranaEmpresa")
	private List<ParametrosAlertaEmpresa> parametrosAlertaEmpresas;

	public AlertaTempranaEmpresa() {
	}

}