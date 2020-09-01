/*
SQLyog Community
MySQL - 10.4.8-MariaDB : Database - baza_njt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`baza_njt` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `baza_njt`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `autorID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  PRIMARY KEY (`autorID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `autor` */

insert  into `autor`(`autorID`,`ime`,`prezime`) values 
(1,'Alber','Kami'),
(2,'Jelena','Bacic Alimpic'),
(3,'Paulo','Koeljo'),
(4,'Ronda ','Bern'),
(5,'Lor','Manel'),
(6,'Frenk','Baum');

/*Table structure for table `autor_knjiga` */

DROP TABLE IF EXISTS `autor_knjiga`;

CREATE TABLE `autor_knjiga` (
  `knjigaID` int(11) NOT NULL,
  `autorID` int(11) NOT NULL,
  PRIMARY KEY (`knjigaID`,`autorID`),
  KEY `fk_autor` (`autorID`),
  CONSTRAINT `fk_autor` FOREIGN KEY (`autorID`) REFERENCES `autor` (`autorID`),
  CONSTRAINT `fk_knjiga` FOREIGN KEY (`knjigaID`) REFERENCES `knjiga` (`knjigaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `autor_knjiga` */

insert  into `autor_knjiga`(`knjigaID`,`autorID`) values 
(1,1),
(2,2),
(3,4),
(4,5),
(5,6);

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `knjigaID` int(11) NOT NULL AUTO_INCREMENT,
  `godina` int(11) NOT NULL,
  `jezik` varchar(255) NOT NULL,
  `naslov` varchar(255) NOT NULL,
  `opis` varchar(2000) NOT NULL,
  `slika` varchar(255) NOT NULL,
  `posetilacID` int(11) NOT NULL,
  PRIMARY KEY (`knjigaID`),
  KEY `posetilac_fk` (`posetilacID`),
  CONSTRAINT `posetilac_fk` FOREIGN KEY (`posetilacID`) REFERENCES `posetilac` (`posetilacID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `knjiga` */

insert  into `knjiga`(`knjigaID`,`godina`,`jezik`,`naslov`,`opis`,`slika`,`posetilacID`) values 
(1,1942,'srpski','Stranac','Prvi roman Albera Kamija koji je izdat 1942. smatra se jednim od najznaÄajnijih romana francuske knjiÅ¾evnosti XX vijeka. On sadrÅ¾i jedan od najboljih prikaza apsurda kojim se Kami bavio, a mnogi ga smatraju njegovim najboljim djelom. Glavni lik romana je Äinovnik Merso kome su javili da mu je umrla majka. On ne pokazuje nikakvo Å¾aljenje, niti bilo kakve druge emocije. Äak nije Å¾elio ni da je vidi prije nego Å¡to je sahrane, iako su ga viÅ¡e puta pitali Å¾eli li to. Kroz cijeli roman se proteÅ¾u opisi njegovog jednoliÄnog i dosadnog Å¾ivota. On se jednostavno prepustio pasivnosti i ravnoduÅ¡nosti i nema volju ni Å¾elju da to promijeni.\r\n\r\nVrijednost Kamijevog romana ogleda se u jednostavnosti stila, koji sa izuzetno upeÄatljivim izlaganjem odliÄno ocrtava lik izgubljenog Äovjeka. Ovo knjiÅ¾evno djelo sa originalnom filozofskom osnovom aktivno se ukljuÄuje u borbu savremenog Äovjeka za liÄne i druÅ¡tvene slobode. ','https://www.delfi.rs/_img/artikli/2017/04/stranac_vv.jpg',1),
(2,2020,'srpski','Neki Drugi Zivot','Bliznakinje Irene i Marta van der Linden bezbriÅ¾no provode detinjstvo i mladost u Å¾ivopisnom gradiÄu Harlemu, nadomak Amsterdama. Izgledom skoro identiÄne ali po karakteru nepomirljivo razliÄite, neraskidivo su vezane jedna za drugu.\r\n\r\nNjihov briÅ¾ni otac, cenjeni i imuÄni lekar Henrik van der Linden, meÄutim, krije tajnu koja preti da ugrozi porodiÄnu sreÄu. Ljudska zloba, strastvena Å¾elja za osvetom i mraÄna zavera iz korena Äe promeniti Å¾ivot dveju sestara. Jedna od njih izgubiÄe sve...','https://www.laguna.rs/_img/korice/4751/neki_drugi_zivot-jelena_bacic_alimpic_v.jpg',1),
(3,2006,'srpski','Tajna','Autorka Ronda Bern, sakupila je oko sebe neverovatnu grupu pisaca, filozofa, umetnika i drugih izuzetnih ljudi razliÄitih profesija koji su joj pomogli u nastanku ove knjige. Svi oni govore o Tajni koja je vekovima veÅ¡to Äuvana od strane privilegovane manjine. Po prvi put u istoriji sveta, neko je odluÄio i uspeo u nameri da Tajnu saopÅ¡ti Äitavom svetu i tako od njega stvori sreÄnije i bolje mesto za Å¾ivot svih nas.Mnogi veruju da posle objavljivanja Tajne, niÅ¡ta viÅ¡e neÄe biti isto, da Äe ona doneti preokret u naÄin razmiÅ¡ljanja svih nas koji je saznamo i primenimo i pomoÄi nam da sebi i svima koji nas okruÅ¾uju pruÅ¾imo nov i sreÄniji Å¾ivot.','https://dereta.rs/cached/dereta.rs/Images/Tajna-The-Secret-0000129202106136.jpg',1),
(4,2020,'srpski','Njeno ime je Elza','NeÅ¾na priÄa o dva glasa koja govore o sebi i Äute, noÅ¡ena vetrom Bretanje koji njiÅ¡e travu i vraÄa ih na obalu, briÅ¡uÄi uspomene zrncima peska.\r\n\r\nKada je jednog dana reÅ¡io da provede popodne na plaÅ¾i, Fransoa nije ni sanjao da Äe u podnoÅ¾ju stene pronaÄi mladu Å¾enu bez svesti. Umesto da pozove pomoÄ, donosi impulsivnu odluku, a da ni sam nije siguran zaÅ¡to: odveÅ¡Äe je kuÄi da bi se brinuo o njoj.\r\n\r\nFransoa je postao usamljenik koji izbegava sve Å¡to podseÄa na ljubav, kao da ne Å¾eli viÅ¡e da voli. Ipak, iza te maske krije se nesebiÄan, plemenit Äovek na Äija se Ävrsta ramena moÅ¾e osloniti, poput svetionika u tamnoj surovosti Å¾ivota. Kada se povreÄena devojka probudi, saznaÄe da se zove Elza, ali na svako drugo pitanje dobija nemi odgovor. Kao da je odluÄila da nestane, da bude nevidljiva, da napusti svoj Å¾ivot. Kako vreme prolazi, ove dve neobiÄne duÅ¡e poÄinju da se otkrivaju, da poveravaju jedno drugom svoje tajne. Ipak, prošlost nikada ne miruje¦ Ko je Elza i od čega beÅ¾i?','https://www.vulkani.rs/cached/www.vulkani.rs/Images/NJENO-IME-JE-ELZA0-1000x0-00007425136126.jpg',1),
(5,2020,'srpski','Carobnjak iz Oza','â U svakom sluÄaju â reÄe StraÅ¡ilo â ja Äu ipak traÅ¾iti mozak, a ne srce, jer budalast Äovek ne bi znao Å¡ta Äe sa srcem Äak i kad bi ga imao. â Ja Äu traÅ¾iti srce â odvrati Limeni DrvoseÄa â jer mozak Äoveka ne Äini sreÄnim, a sreÄa je najbolja stvar na svetu.\r\n\r\nKada straÅ¡an ciklon pogodi Kanzas i odnese njihovu kuÄicu, devojÄica Doroti i njen pas Toto obreÅ¡Äe se u Äarobnoj Zemlji Oz. Doroti viÅ¡e od svega Å¾eli da se vrati kuÄi, a u tome joj moÅ¾e pomoÄi jedino Veliki i StraÅ¡ni Oz, Äarobnjak koji Å¾ivi u Smaragdnom gradu. Na Äudesnom, uzbudljivom, ponekad i opasnom putovanju, Doroti i Toto Äe doÅ¾iveti mnoge avanture, a usput Äe steÄi neobiÄne prijatelje kojima Äe pomoÄi da ostvare svoje snove.\r\n\r\nJedno od najpopularnijih dela ameriÄke knjiÅ¾evnosti za decu, ova knjiga nas uÄi da su upornost, hrabrost, prijateljstvo i velikoduÅ¡nost vrednosti koje Äe nam pomoÄi da savladamo sve prepreke. One se nalaze u svakom od nas, samo treba da se dobro zagledamo u sebe da bismo ih pronaÅ¡li.\r\n\r\nâL. Frenk Baum je deci pokazao da se magija krije u svakodnevici, Äime je milione deÄaka i devojÄica nagnao da zavole Äitanje.â Salem Press ','https://www.delfi.rs/_img/artikli/2015/02/carobnjak_iz_oza_vv.jpg',1);

/*Table structure for table `posetilac` */

DROP TABLE IF EXISTS `posetilac`;

CREATE TABLE `posetilac` (
  `posetilacID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`posetilacID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `posetilac` */

insert  into `posetilac`(`posetilacID`,`ime`,`password`,`prezime`,`role`,`username`) values 
(1,'Jelena','sifra','Krasic',1,'jelena'),
(3,'Ivan','ica','Marojevic',2,'ica'),
(4,'Ana','ana','Bajceta',2,'ana');

/*Table structure for table `zanr` */

DROP TABLE IF EXISTS `zanr`;

CREATE TABLE `zanr` (
  `zanrID` int(11) NOT NULL AUTO_INCREMENT,
  `nazivZanra` varchar(255) NOT NULL,
  PRIMARY KEY (`zanrID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `zanr` */

insert  into `zanr`(`zanrID`,`nazivZanra`) values 
(1,'Klasicna knjizevnost'),
(2,'Drama'),
(3,'Ljubavni'),
(4,'Naucna fantastika'),
(5,'Popularna psihologija'),
(6,'Knjige za decu');

/*Table structure for table `zanr_knjiga` */

DROP TABLE IF EXISTS `zanr_knjiga`;

CREATE TABLE `zanr_knjiga` (
  `zanrID` int(11) NOT NULL,
  `knjigaID` int(11) NOT NULL,
  PRIMARY KEY (`zanrID`,`knjigaID`),
  KEY `fk_knjigaZanr` (`knjigaID`),
  CONSTRAINT `fk_knjigaZanr` FOREIGN KEY (`knjigaID`) REFERENCES `knjiga` (`knjigaID`),
  CONSTRAINT `fk_zanrKnjiga` FOREIGN KEY (`zanrID`) REFERENCES `zanr` (`zanrID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `zanr_knjiga` */

insert  into `zanr_knjiga`(`zanrID`,`knjigaID`) values 
(1,1),
(1,5),
(2,2),
(2,4),
(3,2),
(3,4),
(5,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
