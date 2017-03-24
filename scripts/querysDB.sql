
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
id SMALLINT NOT NULL AUTO_INCREMENT,
legajo INT,
codigoMateria INT,
modalidad SMALLINT,
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

    

CREATE TABLE `BDTP`.`estadosMateria`(
identificador SMALLINT,
id SMALLINT NOT NULL AUTO_INCREMENT,
estado VARCHAR(25),
fecha DATE,
PRIMARY KEY (id)
);

ALTER TABLE `bdtp`.`estadosmateria` 
ADD INDEX `fk_estadosMateria_1_idx` (`identificador` ASC);
ALTER TABLE `bdtp`.`estadosmateria` 
ADD CONSTRAINT `fk_estadosMateria_1`
  FOREIGN KEY (`identificador`)
  REFERENCES `bdtp`.`materiasalumnos` (`id`)
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
    
