CREATE DATABASE mapita;

\c mapita;

CREATE TABLE usuario(
idusuario SERIAL NOT NULL,
nombre TEXT NOT NULL,
correo TEXT NOT NULL,
contrasenia TEXT NOT NULL,
fecha DATE NOT NULL,
PRIMARY KEY (idusuario));

CREATE TABLE marcador(
idmarcador SERIAL NOT NULL,
descripcion TEXT NOT NULL,
longitud DOUBLE PRECISION NOT NULL,
latitud DOUBLE PRECISION NOT NULL,
usuarioid INT NOT NULL,
CONSTRAINT fk_marcador FOREIGN KEY (usuarioid) REFERENCES usuario (idusuario)
);

