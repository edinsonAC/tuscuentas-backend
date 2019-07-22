package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the alerta_temprana database table.
 * 
 */
@Data
@Entity
@Table(name="alerta_temprana")
public class AlertaTemprana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alteId;

	@Column(name="alte_codigo")
	private String alteCodigo;

	@Column(name="alte_descripcion")
	private String alteDescripcion;

	@Column(name="alte_estado")
	private byte alteEstado;

	@Column(name="alte_fecharegistro")
	private Timestamp alteFecharegistro;

	@Column(name="alte_registradopor")
	private String alteRegistradopor;

	@Column(name="alte_url")
	private String alteUrl;

	//bi-directional many-to-one association to AlertaTempranaEmpresa
	@OneToMany(mappedBy="alertaTemprana")
	private List<AlertaTempranaEmpresa> alertaTempranaEmpresas;

	//bi-directional many-to-one association to ParametrosSiigo
	@OneToMany(mappedBy="alertaTemprana")
	private List<ParametrosSiigo> parametrosSiigos;

	public AlertaTemprana() {
	}

}