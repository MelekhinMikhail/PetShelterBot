-- liquibase formatted sql

CREATE TABLE catShelter
(
    id           SERIAL primary key,
    name         VARCHAR(50) NOT NULL,
    age          INTEGER     NOT NULL,
    breed        VARCHAR(50) NOT NULL,
    sex          VARCHAR(1)  NOT NULL,
    isSterilized BOOLEAN     NOT NULL,
    owner_id SERIAL
);