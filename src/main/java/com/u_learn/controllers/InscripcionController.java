package com.u_learn.controllers;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.u_learn.POJO.InscripcionPOJO;
import com.u_learn.model.Inscripcion;
import com.u_learn.model.InscripcionIdentity;
import com.u_learn.service.InscripcionService;

@CrossOrigin
@RestController
@RequestMapping("cursos/informacion")
public class InscripcionController {
    private InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @Transactional
    @PostMapping()
    public ResponseEntity registroCurso(@RequestBody InscripcionPOJO pojo) {
        Inscripcion inscripcion = inscripcionService.findInscripcion(pojo.getIdCurso(), pojo.getIdEstudiante());

        if (inscripcion != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        inscripcion = new Inscripcion();
        InscripcionIdentity identity = new InscripcionIdentity();
        inscripcion.setIdEstudiante(pojo.getIdEstudiante());
        inscripcion.setIdCurso(pojo.getIdCurso());
        inscripcion.setCalificacion("");
        inscripcionService.save(inscripcion);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity consultaCurso(@RequestParam Integer idCurso, @RequestParam Integer idEstudiante) {
        List<Inscripcion> inscripcionList;
        if (idCurso instanceof Integer && idEstudiante instanceof Integer) {
            inscripcionList = Arrays.asList(inscripcionService.findInscripcion(idCurso, idEstudiante));
        } else if (idCurso instanceof Integer) {
            inscripcionList = inscripcionService.findInscripcionByCurso(idCurso);
        } else if (idEstudiante instanceof Integer) {
            inscripcionList = inscripcionService.findInscripcionByEstudiante(idEstudiante);
        } else {
            inscripcionList = inscripcionService.listarInscripciones();
        }
        return new ResponseEntity<List<Inscripcion>>(inscripcionList, HttpStatus.ACCEPTED);
    }

    @Transactional
    @PutMapping()
    public ResponseEntity getCurso(@RequestBody InscripcionPOJO pojo) {
        Inscripcion inscripcion = inscripcionService.findInscripcion(pojo.getIdCurso(), pojo.getIdEstudiante());
        if (inscripcion != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        inscripcion.setCalificacion(pojo.getCalificacion());
        inscripcionService.save(inscripcion);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @Transactional
    @DeleteMapping()
    public ResponseEntity consultaTipoBicicleta(@RequestBody InscripcionPOJO pojo) {
        Inscripcion inscripcion = inscripcionService.findInscripcion(pojo.getIdCurso(), pojo.getIdEstudiante());
        if (inscripcion != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        inscripcionService.deleteInscripcion(pojo.getIdCurso(), pojo.getIdEstudiante());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
