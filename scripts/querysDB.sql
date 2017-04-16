
CREATE DATABASE BDTP;
CREATE USER 'usrapp'@'localhost' IDENTIFIED BY 'usrapp';
GRANT CREATE, DROP, ALTER, INSERT, UPDATE, SELECT, DELETE,
INDEX ON BDTP.* TO 'usrapp'@'localhost';
USE BDTP;
CREATE TABLE `BDTP`.`Usuario` (
  `legajo` INT NULL AUTO_INCREMENT,
  `contrasenia` VARCHAR(45) NULL,
  `codPerfil` INT NULL,
  PRIMARY KEY (`legajo`));
  
  CREATE TABLE `BDTP`.`AdminAlumnado` (
  `legajo` INT NULL,
  `fechaAlta` DATETIME NULL,
  `fechaBaja` DATETIME NULL,
  PRIMARY KEY (`legajo`),
  CONSTRAINT `fk_AdminAlumnado_1`
    FOREIGN KEY (`legajo`)
    REFERENCES `BDTP`.`Usuario` (`legajo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `BDTP`.`Coordinador` (
  `legajo` INT NOT NULL,
  `nroResolucion` INT NULL,
  `especialidad` VARCHAR(45) NULL,
  `plan` VARCHAR(45) NULL,
  `fechaAlta` DATETIME NULL,
  `fechaBaja` DATETIME NULL,
  PRIMARY KEY (`legajo`),
  CONSTRAINT `fk_Coordinador_usuario`
    FOREIGN KEY (`legajo`)
    REFERENCES `BDTP`.`Usuario` (`legajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);SELECT `Coordinador`.`legajo`,
    `Coordinador`.`nroResolucion`,
    `Coordinador`.`especialidad`,
    `Coordinador`.`plan`,
    `Coordinador`.`fechaAlta`,
    `Coordinador`.`fechaBaja`
FROM `BDTP`.`Coordinador`;
ALTER TABLE `BDTP`.`Coordinador`  MODIFY nroResolucion VARCHAR(20);

###(deSilvina)alterar tabla Coordinador para poner plan como int y establecer relacion con Plan :

alter table `BDTP`.`Coordinador`  Modify plan INT;

ALTER TABLE `BDTP`.`Coordinador` 
ADD CONSTRAINT `fk_Coordinador_plan`
  FOREIGN KEY (`plan`)
  REFERENCES `BDTP`.`Plan` (`identificador`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


CREATE TABLE `BDTP`.`Alumno` (
  `legajo` INT NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `egresado` CHAR(1) NULL,
  PRIMARY KEY (`legajo`),
  CONSTRAINT `fk_Alumno_usuario`
    FOREIGN KEY (`legajo`)
    REFERENCES `BDTP`.`Usuario` (`legajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `BDTP`.`Carrera` (
  `codigoCarrera` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `canNivel` TINYINT(1) NULL,
  PRIMARY KEY (`codigoCarrera`));


CREATE TABLE `BDTP`.`Materia` (
  `codMateria` INT NOT NULL,
  `nombreMateria` VARCHAR(45) NULL,
  `modalidad` TINYINT(1) NULL,
  `codCarrera` INT NULL,
  PRIMARY KEY (`codMateria`),
  INDEX `fk_Materia_1_idx` (`codCarrera` ASC),
  CONSTRAINT `fk_Materia_1`
    FOREIGN KEY (`codCarrera`)
    REFERENCES `BDTP`.`Carrera` (`codigoCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
###(deSilvina)alterar tabla Materia para poner codMateria como int auto_increment hacer :

ALTER TABLE MateriasAlumnos 
DROP FOREIGN KEY fk_MateriaAlumno_2;

alter table `BDTP`.`Materia`  Modify codMateria INT auto_increment ;

ALTER TABLE `bdtp`.`MateriasAlumnos
ADD CONSTRAINT `fk_MateriaAlumno_2`
  FOREIGN KEY (`codigoMateria`)
  REFERENCES `bdtp`.`Materia` (`codMateria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

###

    
 /* Agrego la parte de Plan, Materias y estados - Franco - */   

CREATE TABLE `BDTP`.`Plan` (
identificador VARCHAR(50),
nombre VARCHAR(50),
nroResolucion SMALLINT,
descripcion VARCHAR(255),
fechaIni DATE,
fechaFin DATE,
PRIMARY KEY (identificador)  
);

CREATE TABLE `BDTP`.`materiasAlumnos`(
id SMALLINT NOT NULL AUTO_INCREMENT,
legajo INT,
codigoMateria INT,
estadoMateria VARCHAR(100),
PRIMARY KEY (id)
 );
 
ALTER TABLE `bdtp`.`materiasalumnos` 
ADD INDEX `fk_MateriaAlumno_2_idx` (`codigoMateria` ASC);
ALTER TABLE `bdtp`.`materiasalumnos` 
ADD CONSTRAINT `fk_MateriaAlumno_1`
  FOREIGN KEY (`legajo`)
  REFERENCES `bdtp`.`alumno` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_MateriaAlumno_2`
  FOREIGN KEY (`codigoMateria`)
  REFERENCES `bdtp`.`materia` (`codMateria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


CREATE TABLE `BDTP`.`Mensaje`(
id SMALLINT NOT NULL AUTO_INCREMENT,
fecha DATE,
contenido VARCHAR(255),
usuarioRemitente INT,
usuarioDestinatario INT,
PRIMARY KEY (id)
);

ALTER TABLE `bdtp`.`mensaje` 
ADD INDEX `fk_Mensajes_1_idx` (`usuarioRemitente` ASC),
ADD INDEX `fk_Mensajes_2_idx` (`usuarioDestinatario` ASC);
ALTER TABLE `bdtp`.`mensaje` 
ADD CONSTRAINT `fk_Mensajes_1`
  FOREIGN KEY (`usuarioRemitente`)
  REFERENCES `bdtp`.`usuario` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Mensajes_2`
  FOREIGN KEY (`usuarioDestinatario`)
  REFERENCES `bdtp`.`usuario` (`legajo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;




CREATE TABLE `BDTP`.`Modulo`(
`codModulo`INT NOT NULL AUTO_INCREMENT,
`codPermiso` INT NULL,
`descripcion` VARCHAR(255) NULL,
PRIMARY KEY (codModulo),
INDEX `fk_Modulo_1_idx` (`codPermiso` ASC),
  CONSTRAINT `fk_Modulo_1`
    FOREIGN KEY (`codPermiso`)
    REFERENCES `BDTP`.`Permiso` (`codPermiso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    CREATE TABLE `BDTP`.`Permiso` (
    `codPermiso` INT NOT NULL AUTO_INCREMENT,
    `codPerfil` INT NULL,
    `accion` VARCHAR(50) NULL,
    PRIMARY KEY (`codPermiso`),
    INDEX `fk_Permiso_1_idx` (`codPerfil` ASC),
    CONSTRAINT `fk_Permiso_1`
        FOREIGN KEY (`codPerfil`)
        REFERENCES `BDTP`.`Perfil` (`codPerfil`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

CREATE TABLE `BDTP`.`Perfil` (
     `codPerfil` INT NOT NULL AUTO_INCREMENT,
     `descripcion` VARCHAR(255) NULL,
     `estado` TINYINT(1) NULL,
   PRIMARY KEY (codPerfil)  
);
    
ALTER TABLE `BDTP`.`Alumno` 
ADD COLUMN `plan` VARCHAR(45) NULL AFTER `egresado`,
ADD INDEX `fk_Alumno_plan_idx` (`plan` ASC);
ALTER TABLE `BDTP`.`Alumno` 
ADD CONSTRAINT `fk_Alumno_plan`
  FOREIGN KEY (`plan`)
  REFERENCES `BDTP`.`Plan` (`identificador`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



INSERT INTO `Plan` VALUES ('plan1','plan 1',0,'plan data','2014-05-10','2018-02-01');
INSERT INTO `Usuario` VALUES (1,'pass',1),(2,'pass',1);
INSERT INTO `Alumno` VALUES (1,'46546','pe@hmail.con','s','plan1');


/*Modificaciones a las tablas*/

ALTER TABLE `BDTP`.`Plan`  MODIFY nroresolucion VARCHAR(20);

ALTER TABLE `bdtp`.`alumno` 
DROP FOREIGN KEY `fk_Alumno_plan`;
ALTER TABLE `bdtp`.`alumno` 
DROP INDEX `fk_Alumno_plan_idx` ;


alter table	`BDTP`.`Plan`  Modify identificador INT auto_increment ;
alter table `BDTP`.`Alumno` modify plan int; 


ALTER TABLE `bdtp`.`Alumno` 
ADD INDEX `fk_Alumno_plan_idx` (`plan` ASC);
ALTER TABLE `bdtp`.`Alumno` 
ADD CONSTRAINT `fk_Alumno_plan`
  FOREIGN KEY (`plan`)
  REFERENCES `bdtp`.`Plan` (`identificador`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

