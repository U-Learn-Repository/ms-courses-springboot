package com.u_learn.controllers;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.u_learn.POJO.CursoPOJO;
import com.u_learn.model.Curso;
import com.u_learn.service.CursoService;

@CrossOrigin
@RestController
public class CursoController {
	private CursoService cursoService;

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@PostMapping(value = { "curso/registro" })
	public ResponseEntity registroCurso(@RequestBody CursoPOJO cursoPOJO) {
		Curso existingCur = cursoService.findByNombre(cursoPOJO.getNombre().toUpperCase());
		if (existingCur != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Curso newCurc = new Curso();
		newCurc.setNombre(cursoPOJO.getNombre().toUpperCase());
		newCurc.setCategoria(cursoPOJO.getCategoria().toUpperCase());
		newCurc.setDuracion(cursoPOJO.getDuracion());
		newCurc.setNombreProfesor(cursoPOJO.getNombreProfesor().toUpperCase());
		cursoService.save(newCurc);
		return new ResponseEntity(HttpStatus.CREATED); 
		
	}
	
	
	@GetMapping( value = {"curso/consulta"})
	public ResponseEntity consultaCurso() {

		List<Curso> cursos = cursoService.listarCurso();
		return new ResponseEntity<List<Curso>>(cursos , HttpStatus.ACCEPTED);
	}	
	
	@GetMapping( value = {"curso/consultaid"})
	public ResponseEntity getCurso(@RequestParam Integer cursoid) {
		
		return new ResponseEntity<>(cursoService.findCursoById(cursoid)  , HttpStatus.ACCEPTED);

	}
	
	@PostMapping( value = {"curso/consultacategoria"})
	public ResponseEntity consultaTipoBicicleta(@RequestBody CursoPOJO cursoPOJO) {
		List<Curso> existingCurso = cursoService.findByCategoria(cursoPOJO.getCategoria().toUpperCase());
		if (existingCurso == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<Curso>>(existingCurso , HttpStatus.ACCEPTED);
	}
	@PostMapping( value = {"curso/update"})
	public ResponseEntity updateCurso(@RequestBody CursoPOJO cursoPOJO) {
		Curso existingCurso = cursoService.findCursoById(cursoPOJO.getIdCurso());
		if (existingCurso == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	    // crush the variables of the object found
		existingCurso.setNombre(cursoPOJO.getNombre().toUpperCase());
		existingCurso.setCategoria(cursoPOJO.getCategoria().toUpperCase());
		existingCurso.setDuracion(cursoPOJO.getDuracion());
		existingCurso.setNombreProfesor(cursoPOJO.getNombreProfesor().toUpperCase());
		cursoService.save(existingCurso);return new ResponseEntity(HttpStatus.CREATED);
	}
	@Transactional 
	@DeleteMapping( value = {"curso/eliminarcurso"})
	public ResponseEntity deleteCursoId(@RequestParam Integer cursoid) {
		Curso existingCurso = cursoService.findCursoById(cursoid);
		if (existingCurso == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		cursoService.deleteCurso(cursoid);
		return new ResponseEntity<>(existingCurso.getNombre()+ " eliminado." , HttpStatus.ACCEPTED);
	}
	
}
