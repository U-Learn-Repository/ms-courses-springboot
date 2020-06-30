
ALTER  USER postgres  WITH PASSWORD 'root';
CREATE TABLE IF NOT EXISTS curso(
    id_curso SERIAL       NOT NULL,
    nombre character varying(500) NOT NULL,
    categoria character varying(100) NOT NULL,
    duracion character varying(100) NOT NULL,
    id_profesor integer NOT NULL,
    calificacion character varying(100),
	PRIMARY KEY (id_curso)
);
CREATE TABLE IF NOT EXISTS inscripcion(
	id_inscripcion SERIAL       NOT NULL,
	id_curso integer       NOT NULL,
	id_estudiante integer       NOT NULL,
    calificacion character varying(500) NOT NULL,
	PRIMARY KEY (id_inscripcion)
);




