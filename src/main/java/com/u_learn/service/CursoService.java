package com.u_learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.u_learn.model.Curso;
import com.u_learn.repository.CursoRepository;

@Service
public class CursoService {
	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public void save(Curso curso) {
		cursoRepository.save(curso);
	}
	
	public Curso findCursoById(Integer idCurso) {
		return cursoRepository.findByIdCurso(idCurso);
	}
	
	public Curso findByCategoria(String categoria) {
		return cursoRepository.findByCategoria(categoria);
	}
	public Curso findByNombre(String nombre) {
		return cursoRepository.findByNombre(nombre);
	}
	
	public List<Curso> listarCurso(){
		return cursoRepository.listarCursos();
	}
}
