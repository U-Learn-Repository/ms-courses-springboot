package com.u_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.u_learn.model.Inscripcion;
import com.u_learn.model.InscripcionIdentity;
import com.u_learn.repository.InscripcionRepository;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public void save(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> findInscripcionByCurso(Integer idCurso) {
        return inscripcionRepository.findByIdCurso(idCurso);
    }

    public List<Inscripcion> findInscripcionByEstudiante(Integer idEstudiante) {
        return inscripcionRepository.findByIdEstudiante(idEstudiante);
    }

    public Inscripcion findInscripcion(Integer idCurso, Integer idEstudiante) {
        InscripcionIdentity id = new InscripcionIdentity();
        id.setIdCurso(idCurso);
        id.setIdEstudiante(idEstudiante);
        Optional<Inscripcion> inscription = inscripcionRepository.findById(id);
        if (!inscription.isPresent()) {
            return null;
        }
        return inscription.get();
    }

    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.listarInscripciones();
    }

    public void updateInscripcion(Integer idCurso, Integer idEstudiante, String calificacion) {
        inscripcionRepository.updateInscripcion(idCurso, idEstudiante, calificacion);
    }
    
    public void deleteInscripcion(Integer idCurso, Integer idEstudiante) {
        inscripcionRepository.deleteInscripcion(idCurso, idEstudiante);
    }
}
