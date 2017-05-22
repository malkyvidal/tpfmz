CREATE DATABASE  IF NOT EXISTS `BDTP` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `BDTP`;
-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: BDTP
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.15.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AdminAlumnado`
--

DROP TABLE IF EXISTS `AdminAlumnado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AdminAlumnado` (
  `legajo` int(11) NOT NULL DEFAULT '0',
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  PRIMARY KEY (`legajo`),
  CONSTRAINT `fk_AdminAlumnado_1` FOREIGN KEY (`legajo`) REFERENCES `Usuario` (`legajo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AdminAlumnado`
--

LOCK TABLES `AdminAlumnado` WRITE;
/*!40000 ALTER TABLE `AdminAlumnado` DISABLE KEYS */;
/*!40000 ALTER TABLE `AdminAlumnado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `legajo` int(11) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `egresado` char(1) DEFAULT NULL,
  `plan` int(11) DEFAULT NULL,
  PRIMARY KEY (`legajo`),
  KEY `fk_Alumno_plan_idx` (`plan`),
  CONSTRAINT `fk_Alumno_plan` FOREIGN KEY (`plan`) REFERENCES `Plan` (`identificador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_usuario` FOREIGN KEY (`legajo`) REFERENCES `Usuario` (`legajo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
INSERT INTO `Alumno` VALUES (3,'42336586','pep5e@gmail.com',NULL,1),(4,'4563322','pol@gmail.com',NULL,1);
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Carrera`
--

DROP TABLE IF EXISTS `Carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carrera` (
  `codigoCarrera` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `canNivel` tinyint(1) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`codigoCarrera`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carrera`
--

LOCK TABLES `Carrera` WRITE;
/*!40000 ALTER TABLE `Carrera` DISABLE KEYS */;
INSERT INTO `Carrera` VALUES (1,'Ingenieria Industrial2',0,1),(2,'ISI',5,0),(3,'Civil',5,0),(4,'Investigacion Operativa',1,0);
/*!40000 ALTER TABLE `Carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coordinador`
--

DROP TABLE IF EXISTS `Coordinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Coordinador` (
  `legajo` int(11) NOT NULL,
  `nroResolucion` varchar(20) DEFAULT NULL,
  `especialidad` varchar(45) DEFAULT NULL,
  `plan` int(11) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  PRIMARY KEY (`legajo`),
  KEY `fk_Coordinador_plan` (`plan`),
  CONSTRAINT `fk_Coordinador_plan` FOREIGN KEY (`plan`) REFERENCES `Plan` (`identificador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Coordinador_usuario` FOREIGN KEY (`legajo`) REFERENCES `Usuario` (`legajo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coordinador`
--

LOCK TABLES `Coordinador` WRITE;
/*!40000 ALTER TABLE `Coordinador` DISABLE KEYS */;
/*!40000 ALTER TABLE `Coordinador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Materia`
--

DROP TABLE IF EXISTS `Materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materia` (
  `codMateria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMateria` varchar(45) DEFAULT NULL,
  `modalidad` tinyint(1) DEFAULT NULL,
  `codCarrera` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`codMateria`),
  KEY `fk_Materia_1_idx` (`codCarrera`),
  CONSTRAINT `fk_Materia_1` FOREIGN KEY (`codCarrera`) REFERENCES `Carrera` (`codigoCarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Materia`
--

LOCK TABLES `Materia` WRITE;
/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
INSERT INTO `Materia` VALUES (1,'Algebra Lineal22',2,2,33),(33,'Arquitectura de Computadoras',0,1,0),(34,'Analisis de Sistemas',0,1,0),(35,'SySL',1,1,0),(41,'Planeamiento',0,2,0);
/*!40000 ALTER TABLE `Materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MateriasAlumnos`
--

DROP TABLE IF EXISTS `MateriasAlumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MateriasAlumnos` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `legajo` int(11) DEFAULT NULL,
  `codigoMateria` int(11) DEFAULT NULL,
  `estadoMateria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_MateriaAlumno_2_idx` (`codigoMateria`),
  KEY `fk_MateriaAlumno_1` (`legajo`),
  CONSTRAINT `fk_MateriaAlumno_1` FOREIGN KEY (`legajo`) REFERENCES `Alumno` (`legajo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MateriaAlumno_2` FOREIGN KEY (`codigoMateria`) REFERENCES `Materia` (`codMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MateriasAlumnos`
--

LOCK TABLES `MateriasAlumnos` WRITE;
/*!40000 ALTER TABLE `MateriasAlumnos` DISABLE KEYS */;
INSERT INTO `MateriasAlumnos` VALUES (1,3,33,'regular');
/*!40000 ALTER TABLE `MateriasAlumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mensaje`
--

DROP TABLE IF EXISTS `Mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mensaje` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `usuarioRemitente` int(11) DEFAULT NULL,
  `usuarioDestinatario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Mensajes_1_idx` (`usuarioRemitente`),
  KEY `fk_Mensajes_2_idx` (`usuarioDestinatario`),
  CONSTRAINT `fk_Mensajes_1` FOREIGN KEY (`usuarioRemitente`) REFERENCES `Usuario` (`legajo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mensajes_2` FOREIGN KEY (`usuarioDestinatario`) REFERENCES `Usuario` (`legajo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mensaje`
--

LOCK TABLES `Mensaje` WRITE;
/*!40000 ALTER TABLE `Mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Modulo`
--

DROP TABLE IF EXISTS `Modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Modulo` (
  `codModulo` int(11) NOT NULL AUTO_INCREMENT,
  `codPermiso` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codModulo`),
  KEY `fk_Modulo_1_idx` (`codPermiso`),
  CONSTRAINT `fk_Modulo_1` FOREIGN KEY (`codPermiso`) REFERENCES `Permiso` (`codPermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Modulo`
--

LOCK TABLES `Modulo` WRITE;
/*!40000 ALTER TABLE `Modulo` DISABLE KEYS */;
INSERT INTO `Modulo` VALUES (1,1,'funcion1:Incorporar alumno a plan1'),(2,1,'funcion5:Incorporar alumno a carrera'),(3,1,'funcion2:agregar coordinador'),(4,2,'funcion3:consultar planes'),(5,3,'funcion4: actualizar estado de materia');
/*!40000 ALTER TABLE `Modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfil`
--

DROP TABLE IF EXISTS `Perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfil` (
  `codPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`codPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfil`
--

LOCK TABLES `Perfil` WRITE;
/*!40000 ALTER TABLE `Perfil` DISABLE KEYS */;
INSERT INTO `Perfil` VALUES (1,1,'usuario1',1),(2,0,'usuario2',1);
/*!40000 ALTER TABLE `Perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Permiso`
--

DROP TABLE IF EXISTS `Permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Permiso` (
  `codPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `codPerfil` int(11) DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codPermiso`),
  KEY `fk_Permiso_1_idx` (`codPerfil`),
  CONSTRAINT `fk_Permiso_1` FOREIGN KEY (`codPerfil`) REFERENCES `Perfil` (`codPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Permiso`
--

LOCK TABLES `Permiso` WRITE;
/*!40000 ALTER TABLE `Permiso` DISABLE KEYS */;
INSERT INTO `Permiso` VALUES (1,1,'alta1'),(2,1,'baja1'),(3,2,'alta2'),(4,2,'alta2');
/*!40000 ALTER TABLE `Permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Plan`
--

DROP TABLE IF EXISTS `Plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Plan` (
  `identificador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `nroResolucion` varchar(20) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaIni` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`identificador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Plan`
--

LOCK TABLES `Plan` WRITE;
/*!40000 ALTER TABLE `Plan` DISABLE KEYS */;
INSERT INTO `Plan` VALUES (1,'plan 1','res23','plan de test','2010-05-01','2020-05-02');
/*!40000 ALTER TABLE `Plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `legajo` int(11) NOT NULL AUTO_INCREMENT,
  `contrasenia` varchar(45) DEFAULT NULL,
  `codPerfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'pass',0),(2,'pass',1),(3,'pass',2),(4,'pass',2);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22 18:56:56
