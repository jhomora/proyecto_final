create schema aplicacionLiniaTelefonica;
use aplicacionLiniaTelefonica;

CREATE TABLE `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(70) DEFAULT NULL,
  `nombre` varchar(70) DEFAULT NULL,
  `apellido` varchar(70) DEFAULT NULL,
  `telefono_fijo` varchar(70) DEFAULT NULL,
  `fecha_nacimiento` varchar(70) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `linea_telefonica` (
  `id` int auto_increment not null,
  `id_celular` varchar(50) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `precio_lin` double default NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key(`id_persona`) references personas(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `facturas` (
  `id_factura` int auto_increment NOT NULL,
  `num_lin_fac` varchar(50) NOT NULL,
  `fecha_emi_fac` varchar(50) DEFAULT NULL,
  `valor_fac` double DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  foreign key(`id_factura`) references linea_telefonica(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

select p.nombre, p.apellido, p.documento, f.num_lin_fac as numero_linea 
from (personas p join linea_telefonica l on p.celular = l.id_celular)join facturas f on f.num_lin_fac = l.id_celular;
where p.documento = "569345" and f.fecha_emi_fac = "1990-03-12";



create table telefonos(
 idTel int primary key auto_increment not null,
 numLinTel varchar(30) not null,
 estaTel varchar(1) not null,
 foreign key(numLinTel)references lineaTelefonica(idLin)
);


CREATE USER 'lineasT'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON * . * TO 'lineasT'@'localhost';