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


CREATE TABLE `BDTP`.`Alumno` (
  `legajo` INT NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `egresado` CHAR(1) NULL,
  `plan` INT NULL,
  PRIMARY KEY (`legajo`),
  INDEX `fk_Alumno_plan_idx` (`plan` ASC),
    CONSTRAINT `fk_Alumno_usuario`
    FOREIGN KEY (`legajo`)
    REFERENCES `BDTP`.`Usuario` (`legajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION),
CONSTRAINT `fk_Alumno_plan`
  FOREIGN KEY (`plan`)
  REFERENCES `BDTP`.`Plan` (`identificador`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


CREATE TABLE `BDTP`.`Plan` (
identificador INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50),
nroResolucion VARCHAR(20),
descripcion VARCHAR(255),
fechaIni DATE,
fechaFin DATE,
PRIMARY KEY (identificador)  
);






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



insert into `Materia`  (`nombreMateria`, `modalidad`, `codCarrera`) values ('Arquitectura de Computadoras', 2, 3);

insert into `Materia`  (`nombreMateria`, `modalidad`, `codCarrera`) values ('Analisis de Sistemas', 0, 3);

insert into `Materia`  (`nombreMateria`, `modalidad`, `codCarrera`) values ('SySL', 1, 3);

insert into `Materia`  (`nombreMateria`, `modalidad`, `codCarrera`) values ('Planeamiento', 0, 2);

insert into `Plan` (`nombre`, `nroResolucion`, `descripcion`) values ('Plan x','ca2011', 'plan volver a la universidad');

insert into `Plan` (`nombre`, `nroResolucion`, `descripcion`) values ('Plan y','ca2012', 'plan Egresar');

insert into `Alumno` (`legajo`, `telefono`,`email`) values (1,'16309999','gmail');
insert into `Alumno` (`legajo`, `telefono`,`email`) values (2,'0342246690','snabte@frsf.utn.edu.ar');
insert into `Alumno` (`legajo`, `telefono`,`email`) values (3,'0342642200','nLuz@frsf.utn.edu.ar');

INSERT INTO `Usuario` VALUES (4,'pass',4);
INSERT INTO `Usuario` VALUES (5,'pass',5);
insert into `Coordinador` (`legajo`, `nroResolucion`,`especialidad`, `plan`) values (4, 0094,'civil','volver');
insert into `Coordinador` (`legajo`, `nroResolucion`,`especialidad`, `plan`) values (5, 0093,'mecánica','egreesar');

