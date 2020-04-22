package com.u_learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {
	@Id
	@SequenceGenerator(name = "CURSO_CURSOID_GENERATOR", sequenceName = "public.curso_id_curso_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_CURSOID_GENERATOR")
	@Column(name = "id_curso")
	private Integer idCurso;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "duracion")
	private String duracion;
	@Column(name = "id_profesor")
	private Integer idProfesor;
}
