drop database if exists colegio;
create database colegio;
use colegio;

create table cursos(
    id int auto_increment primary key,
    titulo varchar(20) not null,
    profesor varchar(20) not null,
    dia enum("Lunes","Martes","Miercoles","Jueves","Viernes") not null,
    turno enum("Mañana","Tarde","Noche") not null
);

create table alumnos(
    id int auto_increment primary key,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    edad int not null,
    idCurso int not null
);

alter table alumnos
add constraint FK_alumnos_cursos
foreign key (idCurso)
references cursos(id);

insert into cursos (titulo,profesor,dia,turno) 
    values ("PHP Inicial","Gomez","Martes","Tarde");

insert into alumnos (nombre,apellido,edad,idCurso)
    values ("Juan","Perez",33,1);

select * from cursos;
select * from alumnos;
