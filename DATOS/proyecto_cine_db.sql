
drop table director;
drop table suspenso;
drop table accion;
drop table independiente;

-- crear tablas

create table director(
    id_director number generated always as identity
                            start with 1
                            increment by 1
                            minvalue 1
                            maxvalue 9999,
    nombre varchar2(150) not null,
    appaterno varchar2(150) not null,
    fecha_nacimiento Date not null,
    nacionalidad varchar2(100) not null,
    constraint pk_director primary key (id_director)
);



create table suspenso(
    id_pelicula number generated always as identity
                            start with 1
                            increment by 1
                            minvalue 1
                            maxvalue 9999,
    id_director number not null,
    tipo_peli varchar2(25) not null,
    titulo varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    cant_muerte integer,
    cant_grito integer
);

create table accion(
    id_pelicula number generated always as identity
                            start with 1
                            increment by 1
                            minvalue 1
                            maxvalue 9999,
    id_director number not null,
    tipo_peli varchar2(25) not null,
    titulo varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    cant_explosion integer,
    tiene_cgi varchar2(1)
);

create table independiente(
    id_pelicula number generated always as identity
                            start with 1
                            increment by 1
                            minvalue 1
                            maxvalue 9999,
    id_director number not null,
    tipo_peli varchar2(25) not null,
    titulo varchar2(200) not null,
    fecha_lanzamiento Date not null,
    duracion integer not null,
    rating number(2) not null,
    presupuesto integer,
    cant_reparto integer
);

alter table accion add constraint director_fk 
foreign key (id_director) references director(id_director);

alter table suspenso add constraint director_fk_sus
foreign key (id_director) references director(id_director);

alter table independiente add constraint director_fk_ind
foreign key (id_director) references director(id_director);