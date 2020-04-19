create DATABASE u_learn;
\c u_learn

CREATE TABLE IF NOT EXISTS "u_learn"."public"."curso"(
    "id_curso" SERIAL       NOT NULL,
    "nombre" character varying(500) NOT NULL,
    "categoria" character varying(100) NOT NULL,
    "duracion" character varying(100) NOT NULL,
    "nombre_profesor" character varying(100) NOT NULL,
    "calificacion" character varying(100),
	PRIMARY KEY ("id_curso"),
);


