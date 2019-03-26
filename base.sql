DROP DATABASE IF EXISTS spig;
CREATE DATABASE spig;

\c spig;

CREATE TABLE informador(
    correo TEXT NOT NULL,
    nombre TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    PRIMARY KEY (correo)
);

CREATE TABLE tema(
    idtema SERIAL NOT NULL,
    nombre TEXT NOT NULL,
    informador TEXT NOT NULL,
    PRIMARY KEY (idtema),
    CONSTRAINT fk_informador_tema FOREIGN KEY (informador) REFERENCES informador(correo)
);

CREATE TABLE marcador(
    idmarcador SERIAL NOT NULL,
    descripcion TEXT NOT NULL,
    datos_extra TEXT,
    longitud DOUBLE PRECISION NOT NULL,
    latitud DOUBLE PRECISION NOT NULL,
    tema INTEGER NOT NULL,
    PRIMARY KEY (idmarcador),
    CONSTRAINT fk_tema_marcador FOREIGN KEY (tema) REFERENCES tema (idtema)
);

CREATE TABLE comentarista(
    idcomentarista SERIAL NOT NULL,
    nombre TEXT NOT NULL,
    correo TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    PRIMARY KEY (idcomentarista)
);

CREATE TABLE comentario(
    idcomentario SERIAL NOT NULL,
    contenido TEXT NOT NULL,
    calificacion DOUBLE PRECISION NOT NULL,
    comentarista INTEGER NOT NULL,
    marcador INTEGER NOT NULL,
    PRIMARY KEY (idcomentario),
    CONSTRAINT fk_comentarista_comentario FOREIGN KEY (comentarista) REFERENCES comentarista (idcomentarista),
    CONSTRAINT fk_marcador_comentario FOREIGN KEY (marcador) REFERENCES marcador (idmarcador)
);

CREATE TABLE califica(
    marcador INTEGER NOT NULL,
    comentario INTEGER NOT NULL,
    PRIMARY KEY (marcador,comentario),
    CONSTRAINT fk_comentario_califica FOREIGN KEY (comentario) REFERENCES comentario (idcomentario),
    CONSTRAINT fk_marcador_califica FOREIGN KEY (marcador) REFERENCES marcador (idmarcador)
);
