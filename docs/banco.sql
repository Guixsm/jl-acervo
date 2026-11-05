CREATE DATABASE IF NOT EXISTS jlacervo
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE jlacervo;

CREATE TABLE IF NOT EXISTS livro (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    titulo         VARCHAR(255),
    autor          VARCHAR(255),
    ano_publicacao INT          NOT NULL,
    genero         VARCHAR(255),
    PRIMARY KEY (id)
);