DROP TABLE IF EXISTS empleados;


CREATE TABLE empleados (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(250) DEFAULT '',
  trabajo ENUM('INFORMATICA','PROGRAMAR','INFERMERIA','GESTORDATOS') DEFAULT 'PROGRAMAR',
  salario double,
  PRIMARY KEY (id)
);




insert into empleados (nombre, trabajo, salario)
values('Jose', 'INFORMATICA',1434);
insert into empleados (nombre, trabajo, salario)
values('Juan', 'PROGRAMAR',1722);
insert into empleados (nombre, trabajo, salario)
values('Pedro', 'INFORMATICA',1533);
insert into empleados (nombre, trabajo, salario)
values('Jordi', 'INFERMERIA',1234);
insert into empleados (nombre, trabajo, salario)
values('Jonatan', 'GESTORDATOS',1234);