package com.u_learn.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
public class Inscripcion {
    @EmbeddedId
    private InscripcionIdentity inscripcionIdentity;

    @Column(name = "calificacion")
    private String calificacion;
}
