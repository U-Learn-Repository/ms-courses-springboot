package com.u_learn.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscripcionIdentity implements Serializable {
    private Integer idCurso;

    private Integer idEstudiante;
}
