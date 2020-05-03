package com.u_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.u_learn.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	Curso findByIdCurso(Integer idCurso);
	List<Curso>  findByCategoria(String categoria);
	Curso  findByNombre(String nombre);	

	@Query("select a from Curso a")
	List<Curso> listarCursos();
	
	@Modifying
	@Query("delete from Curso b where b.idCurso=:idCurso")
	void deleteCurso(@Param("idCurso") Integer idCurso);
}
