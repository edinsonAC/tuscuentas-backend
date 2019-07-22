package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tareapre_actividadpre database table.
 * 
 */
@Entity
@Table(name="tareapre_actividadpre")
@NamedQuery(name="TareapreActividadpre.findAll", query="SELECT t FROM TareapreActividadpre t")
public class TareapreActividadpre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tpap_id")
	private int tpapId;

	@Column(name="tire_id")
	private int tireId;

	@Column(name="tpap_diashabiles")
	private String tpapDiashabiles;

	@Column(name="tpap_diasprorroga")
	private String tpapDiasprorroga;

	@Column(name="tpap_estado")
	private byte tpapEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="tpap_fechainicial")
	private Date tpapFechainicial;

	@Column(name="tpap_fecharegistro")
	private String tpapFecharegistro;

	@Column(name="tpap_registradopor")
	private Timestamp tpapRegistradopor;

	//bi-directional many-to-one association to Checklist
	@OneToMany(mappedBy="tareapreActividadpre")
	private List<Checklist> checklists;

	//bi-directional many-to-one association to Documentacion
	@OneToMany(mappedBy="tareapreActividadpre")
	private List<Documentacion> documentacions;

	//bi-directional many-to-one association to ActividadPredeterminada
	@ManyToOne
	@JoinColumn(name="acpr_id")
	private ActividadPredeterminada actividadPredeterminada;

	//bi-directional many-to-one association to CargoEmpresa
	@ManyToOne
	@JoinColumn(name="caem_id")
	private CargoEmpresa cargoEmpresa;

	//bi-directional many-to-one association to TareaPredeterminada
	@ManyToOne
	@JoinColumn(name="tapr_id")
	private TareaPredeterminada tareaPredeterminada;

	public TareapreActividadpre() {
	}

	public int getTpapId() {
		return this.tpapId;
	}

	public void setTpapId(int tpapId) {
		this.tpapId = tpapId;
	}

	public int getTireId() {
		return this.tireId;
	}

	public void setTireId(int tireId) {
		this.tireId = tireId;
	}

	public String getTpapDiashabiles() {
		return this.tpapDiashabiles;
	}

	public void setTpapDiashabiles(String tpapDiashabiles) {
		this.tpapDiashabiles = tpapDiashabiles;
	}

	public String getTpapDiasprorroga() {
		return this.tpapDiasprorroga;
	}

	public void setTpapDiasprorroga(String tpapDiasprorroga) {
		this.tpapDiasprorroga = tpapDiasprorroga;
	}

	public byte getTpapEstado() {
		return this.tpapEstado;
	}

	public void setTpapEstado(byte tpapEstado) {
		this.tpapEstado = tpapEstado;
	}

	public Date getTpapFechainicial() {
		return this.tpapFechainicial;
	}

	public void setTpapFechainicial(Date tpapFechainicial) {
		this.tpapFechainicial = tpapFechainicial;
	}

	public String getTpapFecharegistro() {
		return this.tpapFecharegistro;
	}

	public void setTpapFecharegistro(String tpapFecharegistro) {
		this.tpapFecharegistro = tpapFecharegistro;
	}

	public Timestamp getTpapRegistradopor() {
		return this.tpapRegistradopor;
	}

	public void setTpapRegistradopor(Timestamp tpapRegistradopor) {
		this.tpapRegistradopor = tpapRegistradopor;
	}

	public List<Checklist> getChecklists() {
		return this.checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}

	public Checklist addChecklist(Checklist checklist) {
		getChecklists().add(checklist);
		checklist.setTareapreActividadpre(this);

		return checklist;
	}

	public Checklist removeChecklist(Checklist checklist) {
		getChecklists().remove(checklist);
		checklist.setTareapreActividadpre(null);

		return checklist;
	}

	public List<Documentacion> getDocumentacions() {
		return this.documentacions;
	}

	public void setDocumentacions(List<Documentacion> documentacions) {
		this.documentacions = documentacions;
	}

	public Documentacion addDocumentacion(Documentacion documentacion) {
		getDocumentacions().add(documentacion);
		documentacion.setTareapreActividadpre(this);

		return documentacion;
	}

	public Documentacion removeDocumentacion(Documentacion documentacion) {
		getDocumentacions().remove(documentacion);
		documentacion.setTareapreActividadpre(null);

		return documentacion;
	}

	public ActividadPredeterminada getActividadPredeterminada() {
		return this.actividadPredeterminada;
	}

	public void setActividadPredeterminada(ActividadPredeterminada actividadPredeterminada) {
		this.actividadPredeterminada = actividadPredeterminada;
	}

	public CargoEmpresa getCargoEmpresa() {
		return this.cargoEmpresa;
	}

	public void setCargoEmpresa(CargoEmpresa cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}

	public TareaPredeterminada getTareaPredeterminada() {
		return this.tareaPredeterminada;
	}

	public void setTareaPredeterminada(TareaPredeterminada tareaPredeterminada) {
		this.tareaPredeterminada = tareaPredeterminada;
	}

}