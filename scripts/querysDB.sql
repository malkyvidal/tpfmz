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
legajo INT,
codigo VARCHAR(25),
modalidad SMALLINT,
PRIMARY KEY (legajo,codigo)
);

CREATE TABLE `BDTP`.`estadosMateria`(
identificador VARCHAR(50),
legajo INT,
codigo VARCHAR(25),
id SMALLINT NOT NULL AUTO_INCREMENT,
estado VARCHAR(25),
fecha DATE,
PRIMARY KEY (id)
);

INSERT INTO `Carrera` VALUES (1,'Ingenieria Industrial',NULL);
INSERT INTO `Materia` VALUES (0,'Algebra Lineal',0,1);




