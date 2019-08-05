package com.backendtuscuentas.entitys;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Data
@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tido_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tidoId;

	@Column(name="tido_codigo")
	private String tidoCodigo;

	@Column(name="tido_descripcion")
	private String tidoDescripcion;

	@Column(name="tido_fecharegistro")
	private Timestamp tidoFecharegistro;

	@Column(name="tido_registradopor")
	private String tidoRegistradopor;

	public TipoDocumento() {
	}
}