package com.project.HorasExtrasProject.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="marcaciones", schema = "CREDITENGINE")
public class tablaMarcaciones implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="FECHA_INICIO")
	private Date fechainicio;
	@Column(name="FECHA_FIN")
	private Date fechafin;
	@Column(name="USUARIO")
	private String user;
	@Column (name="ESTADO")
	private String estado;
}
