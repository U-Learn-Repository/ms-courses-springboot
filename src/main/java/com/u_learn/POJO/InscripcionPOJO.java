package com.u_learn.POJO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InscripcionPOJO {
    private Integer idCurso;
    private Integer idEstudiante;
    private String calificacion;

    @Override
    public String toString() {
        return "InscripcionPOJO [idCurso=" + idCurso + ", idEstudiante=" + idEstudiante + ", calificacion="
                + calificacion + "]";
    }

}
