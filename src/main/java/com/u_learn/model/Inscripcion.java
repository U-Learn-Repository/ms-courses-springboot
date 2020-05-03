package com.u_learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@IdClass(InscripcionIdentity.class)
public class Inscripcion {
    @Id
    private Integer idCurso;

    @Id
    private Integer idEstudiante;

    @Column(name = "calificacion")
    private String calificacion;

    @Override
    public String toString() {
        return "Inscripcion [idCurso=" + idCurso + ", idEstudiante=" + idEstudiante + ", calificacion=" + calificacion
                + "]";
    }    
}
