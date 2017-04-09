/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  silvina
 * Created: Mar 27, 2017
 */

CREATE TABLE `BDTP`.`materiasAlumnos`(
id SMALLINT NOT NULL AUTO_INCREMENT,
legajo INT,
codigoMateria INT,
estadoMateria VARCHAR(100),
PRIMARY KEY (id),
INDEX `fk_MateriaAlumno_2_idx` (`codigoMateria` ASC),
CONSTRAINT `fk_MateriaAlumno_1`
  FOREIGN KEY (`legajo`)
  REFERENCES `BDTP`.`Alumno` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
CONSTRAINT `fk_MateriaAlumno_2`
  FOREIGN KEY (`codigoMateria`)
  REFERENCES `BDTP`.`Materia` (`codMateria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);


CREATE TABLE `BDTP`.`Mensaje`(
id SMALLINT NOT NULL AUTO_INCREMENT,
fecha DATE,
contenido VARCHAR(255),
usuarioRemitente INT,
usuarioDestinatario INT,
PRIMARY KEY (id),
INDEX `fk_Mensajes_1_idx` (`usuarioRemitente` ASC),
INDEX `fk_Mensajes_2_idx` (`usuarioDestinatario` ASC),
CONSTRAINT `fk_Mensajes_1`
  FOREIGN KEY (`usuarioRemitente`)
  REFERENCES `BDTP`.`Usuario` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
CONSTRAINT `fk_Mensajes_2`
  FOREIGN KEY (`usuarioDestinatario`)
  REFERENCES `BDTP`.`Usuario` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);


insert into Perfil (`descripcion`,`estado`) values ('usuario1',1);
insert into Perfil (`descripcion`,`estado`) values ('usuario2',1);


insert into `Permiso` (`codPerfil`,`accion`) values (3,'alta1');
insert into `Permiso` (`codPerfil`,`accion`) values (3,'baja1');
insert into `Permiso` (`codPerfil`,`accion`) values (4,'alta2');
insert into `Permiso` (`codPerfil`,`accion`) values (4,'alta2');
insert into `Permiso` (`codPerfil`,`accion`) values (4,'update2');



insert into `Modulo` (`codPermiso`,`descripcion`) values (16, 'funcion1:Incorporar alumno a plan');
insert into `Modulo` (`codPermiso`,`descripcion`) values (16, 'funcion5:Incorporar alumno a carrera');
insert into `Modulo` (`codPermiso`,`descripcion`) values (16, 'funcion2:agregar coordinador');

insert into `Modulo` (`codPermiso`,`descripcion`) values (18, 'funcion3:consultar planes');

insert into `Modulo` (`codPermiso`,`descripcion`) values (20, 'funcion4: actualizar estado de materia');



insert into `Carrera` (`nombre`, `canNivel`) values ('ISI', 5);
insert into `Carrera` (`nombre`, `canNivel`) values ('Civil', 5);



insert into `Materia`  (`codMateria`,`nombreMateria`, `modalidad`, `codCarrera`) values (033, 'Arquitectura de Computadoras', 0, 1);

insert into `Materia`  (`codMateria`,`nombreMateria`, `modalidad`, `codCarrera`) values (034, 'Analisis de Sistemas', 0, 1);

insert into `Materia`  (`codMateria`,`nombreMateria`, `modalidad`, `codCarrera`) values (035, 'SySL', 1, 1);

insert into `Materia`  (`codMateria`,`nombreMateria`, `modalidad`, `codCarrera`) values (041, 'Planeamiento', 0, 2);

