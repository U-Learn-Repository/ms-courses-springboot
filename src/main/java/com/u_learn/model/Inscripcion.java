package com.u_learn.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.IdClass;

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
}
