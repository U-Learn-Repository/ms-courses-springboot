package com.u_learn.POJO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CursoPOJO {
	private Integer idCurso;
	private String nombre;
	private String categoria;
	private String duracion;
	private Integer idProfesor;
	private String calificacion;
}
