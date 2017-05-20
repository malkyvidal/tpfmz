Alter table `bdtp`.`materia`
add version int not null after codcarrera;

Alter table `bdtp`.`carrera`
add version int not null after codcarrera;

Alter table `bdtp`.`plan`
add version int not null after fechaFin;

Alter table `bdtp`.`materiasalumnos`
add version int not null after estadoMateria;
