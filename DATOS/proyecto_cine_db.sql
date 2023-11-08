drop table director;
drop table suspenso;
drop table accion;
drop table independiente;

-- crear tablas

create table director(
    id_director number generated always as identity
                            start with 1
                            increment by 1,
    pnombre varchar2(150) not null,
    appaterno varchar2(150) not null,
    fecha_nacimiento Date not null,
    nacionalidad varchar2(100) not null,
    constraint pk_director primary key (id_director)
);


/*
create table suspenso(
    id_pelicula number primary key,
    id_director number not null,
    nombre varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    cant_muerte integer,
    cant_grito integer
);

create table accion(
    id_pelicula number primary key,
    id_director number not null,
    nombre varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    cant_explosion integer,
    tiene_cgi varchar2(1)
);

create table independiente(
    id_pelicula number primary key,
    id_director number not null,
    nombre varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    presupuesto integer,
    cant_reparto integer
);
*/

-- añadir claves foraneas
-- pendiente


