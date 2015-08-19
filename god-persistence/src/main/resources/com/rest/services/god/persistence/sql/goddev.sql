# Host: localhost  (Version: 5.5.45)
# Date: 2015-08-19 18:10:27
# Generator: MySQL-Front 5.3  (Build 4.224)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bitacora"
#

DROP TABLE IF EXISTS `bitacora`;
CREATE TABLE `bitacora` (
  `ID_BITACORA` int(15) NOT NULL,
  `ID_USUARIO` int(15) NOT NULL,
  `ID_CORO` int(15) NOT NULL,
  `FECHA_CONSULTA` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
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
  `FECHA_ACT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `DESCRIPCION` text,
  `NUM_CORO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_CORO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ALMACENAMIENTO DE COROS';

#
# Data for table "coro"
#

INSERT INTO `coro` VALUES (1,'SÓLO A DIOS LA GLORIA','LETRA: Rubén Hernández Dísz, 2001 MUSICA: Ohed Valencia L., 2001','2015-08-12 22:15:43','1. Es el Dios de los ejércitos \nen quien yo confiaré, \ny con címbalos de gozo \nal Señor ensalzaré; \nél despide los relámpagos, \nmas nunca temeré, \nél es mi protector.\n<br><br>\n<center>CORO</center>\n<br><br>\n¡Gloria, gloria, aleluya! \n¡Gloria, gloria, aleluya! \n¡Gloria, gloria, aleluya \na nuestro Salvador!\n<br><br>\n2. Con ejército no gana \nsus victorias el Señor, \nni con fuerza lucha \nen contra de Satán, \nel tentador; la potencia del Espíritu, \nha dicho el Dios de amor, \nes la que vencerá.\n<br><br>\n3. En Belén de Palestina \nel Señor Jesús nació, \ny después de treinta años \nen la cruenta cruz murió; \npero vive para siempre, \npues la tumba ya venció; \nsu nombre alabaré.\n<br><br>\n4. El Señor de los señores\nya muy pronto volverá,\ny a su pueblo con gran gozo\na las nubes llevará;\ny por siempre moraremos\ntodos en la eternidad\ncon nuestro Salvador.','1'),(2,'A DIOS SEA LA GLORIA','LETRA Y MÚSICA: AndrséCrouch, trad. Publicaciones el Faro.','2015-08-11 13:15:43','1. ¿Cómo agradecer \nlo que hizo el Señor por mí? \nQue, sin merecer, \nderramó su sangre carmesí; \nun coro de un millón de ángeles \nno expresará mi gratitud, \npues lo que soy \ny un día anhelo ser, \nlo debo todo a él.\n<br><br>\n<center>CORO</center>\n<br><br>\nA Dios sea la gloria,\na Dios sea la gloria,\na Dios sea la gloria\npor lo que hizo por mí.\n\nCon su sangre me ha salvado,\nsu poder me ha sanado,\na Dios sea la gloria\npor lo que hizo por mí.\n<br><br>\n2. Quiero vivir una vida \nque sea agradable sólo a él, \ny si ganare alguna fama, \ntoda al Calvario la llevaré.\n<br><br>\n<center>Coro para la segunda estrofa</center> \n<br>\nCon su sangre me ha salvado \nsu poder me ha sanado, \na Dios sea la gloria \npor lo que hizo por mí.\n','2'),(3,'ERES DIGNO','LETRA Y MÚSICA: Pauline M. Lus, arr. Obed Valencia L. 2001','2015-08-11 13:15:43','Eres digno, eres digno, \neres digno, Señor, \nde alabanza, honra y gloria, \ngloria y todo poder. \n<br><br>\nPues todas las cosas \npor ti fueron hechas \ny existen por tu voluntad; \ntodo has creado para tu gloria; \neres digno, Señor.\n','3'),(4,'DIGNO ES EL CORDERO QUE MURIÓ','LETRA: Basado en Ap. 5:12 Adapt. Don Wyrtzoes tead. MUSICA: Don Wyrtzen','2015-08-11 13:15:43','Digno es el Cordero que murió,\ndigno es el Cordero que murió,\ndigno es el Cordero que murió \nde recibir fuerza, riqueza, \nsaber y poder, honra y gloria y bendición.\n<br><br>\nDigno es el Cordero, \ndigno es el Cordero, \ndigno es el Cordero que murió; \ndigno es el Cordero.','4'),(5,'¡GLORIA, GLORIA, ALELUYA!','LETRA: Julia Ward Howe, trad. y adapt.\r\nRoberto C. Savage\r\nMUSICA: Melodía americana, a. Mx\r\n','2015-08-10 23:15:32','1. Es el Dios de los ejércitos \nen quien yo confiaré, \ny con címbalos de gozo \nal Señor ensalzaré; \nél despide los relámpagos, \nmas nunca temeré, \nél es mi protector.\n<br><br>\n<center>CORO</center>\n<br>\n¡Gloria, gloria, aleluya! \n¡Gloria, gloria, aleluya! \n¡Gloria, gloria, aleluya \na nuestro Salvador!\n<br><br>\n2. Con ejército no gana \nsus victorias el Señor, \nni con fuerza lucha \nen contra de Satán, \nel tentador; la potencia del Espíritu, \nha dicho el Dios de amor, \nes la que vencerá.\n<br><br>\n3. En Belén de Palestina \nel Señor Jesús nació, \ny después de treinta años \nen la cruenta cruz murió; \npero vive para siempre, \npues la tumba ya venció; \nsu nombre alabaré.\n<br><br>\n4. El Señor de los señores\nya muy pronto volverá,\ny a su pueblo con gran gozo\na las nubes llevará;\ny por siempre moraremos\ntodos en la eternidad\ncon nuestro Salvador.','5'),(6,'A TI CANTAMOS LA GLORIA, SEÑOR','LETRA Y MÚSICA: Brus del Monte, arr, Obed Valencia','2014-08-10 23:15:32','1. A ti cantamos la gloria, Señor, \r\npor tu bondad y por tu grande amor.\r\nEres tú digno de todo honor;\r\nfuente de vida, he aquí el clamor.\r\n<br><br>\r\n<center>CORO</center>\r\n<br><br>\r\nOh, Rey del cielo, gran Salvador, \r\na ti te damos nuestro loor. \r\nSer supremo, Dios sin igual, \r\ncon humildad te alabamos, Señor.\r\n<br><br>\r\n2. Al Salvador quien murió en la cruz,\r\na quien con sacrificio nos dio la luz,\r\na quien con sangre preciosa de amor,\r\na Jesucristo, he aquí el clamor.\r\n<br><br>\r\n3. Cantan las aves tu gloria, Señor; \r\nbrillan las flores, expresando loor, \r\ny los que en deuda están a tu amor, \r\ncantan con gratitud ahora, Señor.','6'),(7,'GLORIA AL NOMBRE DE CRISTO','LETRA Y MÚSICA: Roy HicksJr.','2014-08-10 23:15:34','Gloria al nombre de Cristo,\r\ngloria al nombre de Cristo,\r\nes mi Dios, es mi fuerza,\r\nes mi libertador en quién confiaré. \r\nGloria al nombre de Cristo.','7'),(8,'EN MI VIDA GLORIA TE DOY','LETRA Y MÚSICA: Bob Kilpatrick','2014-08-10 23:15:34','1. En mi vida gloria te doy, \r\ngloria te doy,\r\nen mi vida \r\ngloria te doy, Señor.\r\n<br><br>\r\n2. En mi canto...\r\n<br>\r\n3. En tu iglesia...\r\n<br>\r\n4. En tu mundo...','8'),(9,'SANTA BIBLIA','P. Castro','2014-08-10 23:15:34','Santa Biblia, para mí eres un tesoro aquí;\r\nTú contienes con verdad la divina voluntad;\r\nTu me dices lo que soy, de quien vine y a quien voy.\r\n<br><br>\r\nTú reprendes mi dudar; tú me exhortas sin cesar;\r\nEres faro que a mi pie va guiando por la fe\r\nA las fuentes del amor del bendito Salvador.\r\n<br><br>\r\nEres infalible voz del Espíritu de Dios\r\nQue vigor al alma da cuando en aflicción está;\r\nTú me enseñas a triunfar de la muerte y el pecar.\r\n<br><br>\r\nPor tu santa letra sé que con Cristo reinaré;\r\nYo que tan indigno soy, por tu luz al cielo voy;\r\n¡Santa Biblia!, para mí eres un tesoro aquí.','9'),(10,'TU PALABRA ES MI CÁNTICO','LETRA: Basada en los símbolos bíblicos de la palabra de Dios, Felipe Blyckerj.','2015-08-12 22:15:43','1. Tu palabra es mi cántico, \r\nesperanza y gozo da; \r\nes espada, arma divinal \r\ny escudo contra el mal.\r\n<br><br>\r\n<center>CORO</center>\r\n<br><br>\r\nPor la santa Biblia te alabo, \r\nPadre amante, mi Señor. \r\nTe adoro Cristo, Rey eterno; \r\ngracias, oh Consolador.\r\n<br><br>\r\n2. Tu palabra es mi lámpara,\r\nluz divina y guía fiel;\r\nmás deseable que oro y plata es, \r\ny más dulce que la miel.\r\n<br><br>\r\n3. Tu palabra es mi gran mentor, \r\nes semilla, eterno don; \r\nquiero siempre en ella meditar, \r\nhallo allí la salvación.\r\n<br><br>\r\n4. Tu palabra trae libertad, \r\nme consuela en aflicción; \r\ncual martillo y espejo es, \r\nfuego en el corazón.\r\n<br><br>\r\n5. Tu palabra es mi agua y pan,\r\nlimpia el ser y fuerza da; \r\nleche y carne encuentro yo allí \r\nque a mi alma sostendrá.\r\n','10');

#
# Structure for table "usuario"
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(15) NOT NULL,
  `NOMBRE` varchar(200) NOT NULL,
  `SEXO` char(1) NOT NULL,
  `FECHA_ALTA` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ULT_CONEXION` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `NOTIFICACIONES` varchar(2) NOT NULL DEFAULT '',
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL DEFAULT '',
  `NACIMIENTO` date DEFAULT NULL,
  `ACTIVIDAD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABLA DE USUARIOS';

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'GUSTAVO ULISES TREJO ARMENTA','M','2015-08-19 13:48:28','2015-08-19 13:49:44','SI','gustavo.trejo@novutek.com','vLtJFzHPf1c=','1984-10-13','INGENIERO'),(2,'GUSTAVO ULISES','M','2015-08-19 18:09:23','2015-08-19 18:09:23','NO','gtrejo.armenta1@gmail.com','vLtJFzHPf1c=','1987-07-31','ESTUDIANTE');
