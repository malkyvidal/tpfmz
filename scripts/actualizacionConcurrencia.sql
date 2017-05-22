

ALTER TABLE `BDTP`.`Perfil`  ADD COLUMN `version` INT NOT NULL AFTER `codPerfil`;
ALTER TABLE `BDTP`.`Materia`  ADD COLUMN `version` INT DEFAULT 0;

Alter table `BDTP`.`Carrera`
add version int not null after codigoCarrera;

Alter table `BDTP`.`Plan`
add version int not null after fechaFin;

Alter table `BDTP`.`MateriasAlumnos`
add version int not null after estadoMateria;
