package com.u_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.u_learn.model.Inscripcion;
import com.u_learn.model.InscripcionIdentity;

public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionIdentity> {
    List<Inscripcion> findByIdCurso(Integer idCurso);

    List<Inscripcion> findByIdEstudiante(Integer idEstudiante);

    @Query("select a from Inscripcion a")
    List<Inscripcion> listarInscripciones();

    @Modifying
    @Query("update Inscripcion b set b.calificacion=:calificacion where b.idCurso=:idCurso and b.idEstudiante=:idEstudiante")
    void updateInscripcion(@Param("idCurso") Integer idCurso, @Param("idEstudiante") Integer idEstudiante,
            @Param("calificacion") String calificacion);

    @Modifying
    @Query("delete from Inscripcion b where b.idCurso=:idCurso and b.idEstudiante=:idEstudiante")
    void deleteInscripcion(@Param("idCurso") Integer idCurso, @Param("idEstudiante") Integer idEstudiante);
}
