

CREATE TABLE IF NOT EXISTS "curso"(
    "id_curso" SERIAL       NOT NULL,
  PRIMARY KEY ("id_curso"),
    "nombre" character varying(500) NOT NULL,
    "categoria" character varying(100) NOT NULL,
    "duracion" character varying(100) NOT NULL,
    "nombre_profesor" character varying(100) NOT NULL,
);


