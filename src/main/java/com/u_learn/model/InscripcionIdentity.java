package com.u_learn.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class InscripcionIdentity {
    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;
}
