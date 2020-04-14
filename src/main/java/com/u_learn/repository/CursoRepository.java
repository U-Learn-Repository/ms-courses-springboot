package com.u_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.u_learn.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	Curso findByIdCurso(Integer idCurso);
	Curso  findByCategoria(String categoria);
	Curso  findByNombre(String nombre);	

	@Query("select a from Curso a")
	List<Curso> listarCursos();
}
