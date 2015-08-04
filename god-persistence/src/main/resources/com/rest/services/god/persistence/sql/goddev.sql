# Host: localhost  (Version: 5.5.45)
# Date: 2015-08-03 19:31:02
# Generator: MySQL-Front 5.3  (Build 4.224)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bitacora"
#

CREATE DATABASE `goddev` /*!40100 DEFAULT CHARACTER SET utf8 */;
DROP TABLE IF EXISTS `bitacora`;
CREATE TABLE `bitacora` (
  `ID_BITACORA` int(15) NOT NULL,
  `ID_USUARIO` int(15) NOT NULL,
  `ID_CORO` int(15) NOT NULL,
  `FECHA_CONSULTA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_BITACORA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='REGISTRO DE BITACORA';

#
# Data for table "bitacora"
#

INSERT INTO `bitacora` VALUES (1,1,1,'2015-07-16 07:08:17');

#
# Structure for table "coro"
#

DROP TABLE IF EXISTS `coro`;
CREATE TABLE `coro` (
  `ID_CORO` int(15) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `AUTOR` varchar(100) NOT NULL,
  `FECHA_ACT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DESCRIPCION` text NOT NULL,
  PRIMARY KEY (`ID_CORO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ALMACENAMIENTO DE COROS';

#
# Data for table "coro"
#

INSERT INTO `coro` VALUES (1,'SOLO A DIOS LA GLORIA','FELIPE LOPEZ','2015-07-09 03:11:09','\r\n\r\nLarge object data types store data ranging in size from zero bytes to 2 gigabytes.\r\n\r\nThe three large object data types have the following definitions:\r\n\r\nCharacter Large OBjects (CLOBs) — A character string made up of single-byte characters with an associated code page. This data type is appropriate for storing text-oriented information where the amount of information can grow beyond the limits of a regular VARCHAR data type (upper limit of 32K bytes). Code page conversion of the information is supported.\r\n\r\nDouble-Byte Character Large OBjects (DBCLOBs) — A character string made up of double-byte characters with an associated code page. This data type is appropriate for storing text-oriented information where double-byte character sets are used. Again, code page conversion of the information is supported.\r\n\r\nBinary Large OBjects (BLOBs) — A binary string made up of bytes with no associated code page. This data type can store binary data larger than VARBINARY (32K limit). This data type is good for storing image, voice, graphical, and other types of business or application-specific data.\r\n');

#
# Structure for table "producto"
#

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `ID_PRODUCTO` int(1) NOT NULL DEFAULT '0',
  `DESCRIPCION` varchar(100) NOT NULL,
  `PRECIO` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "producto"
#

INSERT INTO `producto` VALUES (1,'CELULAR XPERIA T200',5345),(2,'CAFE ANDATI',15),(3,'AGUA EPURA',10),(4,'GATORADE DE NARANJA',14),(5,'IPHONE 4',5000),(6,'PRODUCTO NUEVO 2015',1234),(7,'PRODUCTO NUEVO 2015',1234),(8,'PRODUCTO NUEVO 2015',1234),(9,'PRODUCTO NUEVO 2015',1234),(10,'PRODUCTO NUEVO 2015',1234),(11,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:34:36 EDT 2015',1234),(12,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:38:45 EDT 2015',1234),(13,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:38:59 EDT 2015',1234),(14,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:39:01 EDT 2015',1234),(15,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:07 EDT 2015',1234),(16,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:20 EDT 2015',1234),(17,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:20 EDT 2015',1234),(18,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:22 EDT 2015',1234),(19,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:23 EDT 2015',1234),(20,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 17:40:25 EDT 2015',1234),(21,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 18:20:19 EDT 2015',1234),(22,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 18:20:53 EDT 2015',1234),(23,'PRODUCTO NUEVO CON FECHA: Thu Jul 23 18:21:22 EDT 2015',1234),(24,'PRODUCTO NUEVO CON FECHA: Fri Jul 24 00:25:45 EDT 2015',1234),(25,'PRODUCTO NUEVO CON FECHA: Fri Jul 24 00:26:07 EDT 2015',1234),(26,'PRODUCTO NUEVO CON FECHA: Fri Jul 24 00:39:11 EDT 2015',1234),(27,'PRODUCTO NUEVO CON FECHA: Fri Jul 24 00:39:20 EDT 2015',1234),(28,'PRODUCTO NUEVO CON FECHA: Fri Jul 24 00:39:23 EDT 2015',1234),(29,'PRODUCTO NUEVO CON FECHA: Mon Aug 03 11:19:45 CDT 2015',1234);

#
# Structure for table "usuario"
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(15) NOT NULL,
  `NOMBRE` varchar(200) NOT NULL,
  `SEXO` char(1) NOT NULL,
  `FECHA_ALTA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ULT_CONEXION` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `NOTIFICACIONES` varchar(2) NOT NULL DEFAULT '',
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABLA DE USUARIOS';

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'GUSTAVO U. TREJO A.','M','2015-06-30 23:00:00','2015-07-15 02:19:14','SI','gtrejo.armenta@gmail.com','rendola'),(2,'PRISCILA MALDONADO RALON','F','2015-06-30 23:00:00','2015-07-24 03:07:05','SI','prisci0304@gmail.com','03042015');
