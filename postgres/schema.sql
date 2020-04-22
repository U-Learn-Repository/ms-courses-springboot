ALTER  USER postgres  WITH PASSWORD 'root';
create DATABASE u_learn;
\c u_learn

CREATE TABLE IF NOT EXISTS "curso"(
    "id_curso" SERIAL       NOT NULL,
    "nombre" character varying(500) NOT NULL,
    "categoria" character varying(100) NOT NULL,
    "duracion" character varying(100) NOT NULL,
    "id_profesor" integer NOT NULL,
	PRIMARY KEY ("id_curso")
);

