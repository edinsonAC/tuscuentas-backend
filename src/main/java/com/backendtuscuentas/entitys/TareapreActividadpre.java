package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the tareapre_actividadpre database table.
 * 
 */
@Data
@Entity
@Table(name = "tareapre_actividadpre")
public class TareapreActividadpre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tpap_id")
	private Long tpapId;

	@Column(name = "tire_id")
	private Long tireId;

	@Column(name = "tpap_diashabiles")
	private String tpapDiashabiles;

	@Column(name = "tpap_diasprorroga")
	private String tpapDiasprorroga;

	@Column(name = "tpap_estado")
	private byte tpapEstado;

	@Temporal(TemporalType.DATE)
	@Column(name = "tpap_fechainicial")
	private Date tpapFechainicial;

	@Column(name = "tpap_fecharegistro")
	private String tpapFecharegistro;

	@Column(name = "tpap_registradopor")
	private Timestamp tpapRegistradopor;

	// bi-directional many-to-one association to Checklist
	@OneToMany(mappedBy = "tareapreActividadpre")
	private List<Checklist> checklists;

	// bi-directional many-to-one association to Documentacion
	@OneToMany(mappedBy = "tareapreActividadpre")
	private List<Documentacion> documentacions;

	// bi-directional many-to-one association to ActividadPredeterminada
	@ManyToOne
	@JoinColumn(name = "acpr_id")
	private ActividadPredeterminada actividadPredeterminada;

	// bi-directional many-to-one association to CargoEmpresa
	@ManyToOne
	@JoinColumn(name = "caem_id")
	private CargoEmpresa cargoEmpresa;

	// bi-directional many-to-one association to TareaPredeterminada
	@ManyToOne
	@JoinColumn(name = "tapr_id")
	private TareaPredeterminada tareaPredeterminada;

	public TareapreActividadpre() {
	}

}