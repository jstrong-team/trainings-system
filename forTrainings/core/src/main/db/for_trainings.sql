CREATE DATABASE  IF NOT EXISTS `for_trainings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `for_trainings`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: for_trainings
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=676 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'anton','784742a66a3a0c271feced5b149ff8db','Grigoriev Anton','toxa.z@mail.ru',NULL),(2,'masha','c3cc6e312d2bad42cf535aac3a259abd','Grakova Maria','mariagracova96@gmail.com',NULL),(3,'stas','c211c9e7e7689217c0cb99aafe30f3d7','Petrovich Stanislav','staspetrovichbsu@gmail.com',NULL),(4,'kolya','ec3da25081aa81b637fe6faa3debe26e','Lebedev Nikolay','nickylebedev@gmail.com',NULL),(5,'dima','0f5b25cd58319cde0e6e33715b66db4c','Nedelko Dmitriy',NULL,NULL),(6,'maks','051f7661ee7c287be66ee572768ec8f5','Skavysh Maksim',NULL,NULL),(7,'admin','21232f297a57a5a743894a0e4a801fc3','Vasilenko Janna','toxa.z@mail.ru',NULL),(8,'anton','ad9e11ec2d2a34f4c29caa301eb3a06c','Nikiforenko Anton',NULL,NULL),(9,'kostya','81922bb5975b271921aea035bb39626d','Volchkov Konstantin',NULL,NULL),(10,'lesha','f67df4dfbbf865db31b1b6abbd6ceb87','Zapolskiy Aleksey',NULL,NULL),(11,'dasha','e99fc70a6ce263ef79c408d90476a6f1','Rovdo Darya',NULL,NULL),(12,'nadya','fe88a9844b952d9761c452e68139786b','Ivanyukovich Nadezhda',NULL,NULL),(13,'misha','84e33d34422398ed4933dd0f8868d3eb','Kukuev Mihail',NULL,NULL),(14,'ivan','b8cce9b45064f1bf82c4724ec2a0ca88','Palaznik Ivan',NULL,NULL),(15,'kolya','5e399f2ec329784df6d1015c79d2097c','Cherepkin Nikolay',NULL,NULL),(16,'ivan','69665d771ffe152be4608ac1df1f60bc','Poyda Ivan',NULL,NULL),(17,'vika','47d20d4a971f24d77ab97ad9d3ebc2be','Hlystun Viktoriya',NULL,NULL),(18,'klim','c8463d0639afa2bd23a5597818e9d0f1','Shuplenkov Klim',NULL,NULL),(19,'artem','13a22a4ad71d82018313acf1c85d344e','Yudovin Artem',NULL,NULL),(20,'anna','585779d62c67474a86e32e4e483717d1','Aneychik Anna',NULL,NULL),(21,'anton','cab30242c57005a5b3c11bb2824dc54e','Dosov Anton',NULL,NULL),(22,'dasha','0f8e62d9ae788cfb940341238b431623','Busel Darya',NULL,NULL),(23,'mlada','a4a013d37b02159480726317b456a8da','Ignatovich Mlada',NULL,NULL),(24,'viktor','b96393093fff43b3e8abe68016a8527c','Romashko Viktor',NULL,NULL),(25,'lesha','4a4f9945e37d7799509883985615e3af','Hvorostovskiy Aleksey',NULL,NULL),(26,'anton','d389ef1ae5074383a727261ffaf6bb54','Belyy Anton',NULL,NULL),(27,'gena','cdc93091c32dbf68ee186258638fb03f','Trubach Gennadiy',NULL,NULL),(28,'yana','2565f0e9d0416f2ab1e32f2f18c9572a','Yaroshevich Yana',NULL,NULL),(29,'svyat','3d305fad3885a17ce3e934f619821d60','Schavrovskiy Svyatoslav',NULL,NULL),(30,'ivan','387be6215df7610aa835dd875ae860c3','Zhamoydin Ivan',NULL,NULL),(31,'aleksandr','dd01eb45e3cd4085fecc213caa1d1958','Pshenichnik Aleksandr',NULL,NULL),(32,'konstantin','2866c320a60e6852feb055cd7f657c30','Marmalyukov Konstantin',NULL,NULL),(33,'pavel','5cc391fedb13d796e925da4d17dc710b','Shapovalov Pavel',NULL,NULL),(34,'sergey','b77119ed2372929d47788953db9a4748','Nalivko Sergey',NULL,NULL),(35,'vyacheslav','ffab4554791718ecd4e12ffe1cc9f85c','Brezhnev Vyacheslav',NULL,NULL),(36,'dmitriy','41dcdc1fd3a765644f8081ae349b3071','Skrashchuk Dmitriy',NULL,NULL),(37,'oleg','4d4a558fbec8dd2ef8a872b2bfdcc42b','Babashko Oleg',NULL,NULL),(38,'ilya','c9f5e2998b6490e2bf0a8f369a4ea629','Buzyuk Ilya',NULL,NULL),(39,'aleksey','f90cce048060852e00912c866e830647','Kirilchik Aleksey',NULL,NULL),(40,'inna','becc7c963c9b296d0512302cdb123cd5','Starodubceva Inna',NULL,NULL),(41,'valeriy','10fed361baa188f75060a6469868aa8e','Sushkevich Valeriy',NULL,NULL),(42,'aleksey','dab4a6fbf94c3edf210bc7f5bcee6d0c','Chumakov Aleksey',NULL,NULL),(43,'sergey','43cdda53fd868a090a57c1c2106d3692','Koval Sergey',NULL,NULL),(44,'aleksey','39acb0471d5675582b66fe7c4219dcf5','Trofimov Aleksey',NULL,NULL),(45,'admin','0cc175b9c0f1b6a831c399e269772661','admin',NULL,NULL),(46,'user','ee11cbb19052e40b07aac0ca060c23ee','user',NULL,NULL),(666,'aef','awf','System',NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_feedback`
--

DROP TABLE IF EXISTS `employee_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `understand` tinyint(4) DEFAULT NULL,
  `interested` tinyint(4) DEFAULT NULL,
  `continueWithThisTrainer` tinyint(4) DEFAULT NULL,
  `smthNew` tinyint(4) DEFAULT NULL,
  `recommend` tinyint(4) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `other` text,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_employee_feedback_idx` (`employee_id`),
  KEY `fk_training_employee_feedback_idx` (`training_id`),
  CONSTRAINT `fk_employee_employee_feedback` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_training_employee_feedback` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_feedback`
--

LOCK TABLES `employee_feedback` WRITE;
/*!40000 ALTER TABLE `employee_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_notice`
--

DROP TABLE IF EXISTS `employee_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `notice_id` int(11) NOT NULL,
  `complete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_employee_employee_notice_idx` (`employee_id`),
  KEY `fk_notice_employee_notice_idx` (`notice_id`),
  CONSTRAINT `fk_employee_employee_notice` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_notice_employee_notice` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_notice`
--

LOCK TABLES `employee_notice` WRITE;
/*!40000 ALTER TABLE `employee_notice` DISABLE KEYS */;
INSERT INTO `employee_notice` VALUES (77,1,56,0),(78,7,56,0),(79,45,56,0),(80,1,57,0),(81,1,58,0),(82,7,58,0),(83,45,58,0),(84,1,59,0),(85,7,59,0),(86,45,59,0),(87,7,60,0),(88,1,61,0),(89,7,61,0),(90,45,61,0),(91,4,62,0),(92,1,63,0),(93,7,63,0),(94,45,63,0),(95,3,64,0),(96,1,65,0),(97,7,65,0),(98,45,65,0),(99,3,66,0),(100,1,67,0),(101,7,67,0),(102,45,67,0),(103,3,68,0),(104,1,69,0),(105,7,69,0),(106,45,69,0),(107,5,70,0),(108,1,71,0),(109,7,71,0),(110,45,71,0),(111,5,72,0),(112,1,73,0),(113,7,73,0),(114,45,73,0),(115,5,74,0),(116,1,75,0),(117,7,75,0),(118,45,75,0),(119,4,76,0),(120,1,77,0),(121,7,77,0),(122,45,77,0),(123,4,78,0),(124,1,79,0),(125,7,79,0),(126,45,79,0),(127,4,80,0),(128,1,81,0),(129,7,81,0),(130,45,81,0),(131,6,82,0),(132,1,83,0),(133,7,83,0),(134,45,83,0),(135,6,84,0),(136,1,85,0),(137,7,85,0),(138,45,85,0),(139,6,86,0),(140,1,87,0),(141,7,87,0),(142,45,87,0),(143,6,88,0),(144,1,89,0),(145,7,89,0),(146,45,89,0),(147,3,90,0),(148,1,91,0),(149,7,91,0),(150,45,91,0),(151,2,92,0),(152,1,93,0),(153,7,93,0),(154,45,93,0),(155,8,94,0),(156,1,95,0),(157,7,95,0),(158,45,95,0),(159,9,96,0),(160,1,97,0),(161,7,97,0),(162,45,97,0),(163,10,98,0),(164,1,99,0),(165,7,99,0),(166,45,99,0),(167,11,100,0),(168,1,101,0),(169,7,101,0),(170,45,101,0),(171,13,102,0),(172,1,103,0),(173,7,103,0),(174,45,103,0),(175,14,104,0),(176,1,105,0),(177,7,105,0),(178,45,105,0),(179,16,106,0),(180,1,107,0),(181,7,107,0),(182,45,107,0),(183,17,108,0),(184,1,109,0),(185,7,109,0),(186,45,109,0),(187,20,110,0),(188,1,111,0),(189,7,111,0),(190,45,111,0),(191,21,112,0),(192,1,113,0),(193,7,113,0),(194,45,113,0),(195,22,114,0),(196,1,115,0),(197,7,115,0),(198,45,115,0),(199,24,116,0),(200,1,117,0),(201,7,117,0),(202,45,117,0);
/*!40000 ALTER TABLE `employee_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_role`
--

DROP TABLE IF EXISTS `employee_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_role` (
  `employee_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`,`role_id`),
  KEY `fk_role_employee_role_idx` (`role_id`),
  CONSTRAINT `fk_employee_employee_role` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_employee_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_role`
--

LOCK TABLES `employee_role` WRITE;
/*!40000 ALTER TABLE `employee_role` DISABLE KEYS */;
INSERT INTO `employee_role` VALUES (1,1),(7,1),(45,1),(8,2),(9,2),(10,2),(11,2),(12,2),(33,3),(34,3),(35,3),(39,3),(40,3),(41,3),(42,3),(43,3),(44,3);
/*!40000 ALTER TABLE `employee_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_tag`
--

DROP TABLE IF EXISTS `employee_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_tag` (
  `employee_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`,`tag_id`),
  KEY `fk_tag_employee_tag_idx` (`tag_id`),
  CONSTRAINT `fk_employee_employee_tag` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_employee_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_tag`
--

LOCK TABLES `employee_tag` WRITE;
/*!40000 ALTER TABLE `employee_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meet`
--

DROP TABLE IF EXISTS `meet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `training_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `training_id_idx` (`training_id`),
  CONSTRAINT `fk_training_meet` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet`
--

LOCK TABLES `meet` WRITE;
/*!40000 ALTER TABLE `meet` DISABLE KEYS */;
INSERT INTO `meet` VALUES (1,1,'2015-07-14 13:30:00'),(2,1,'2015-07-18 13:30:00'),(3,1,'2015-07-22 13:30:00'),(4,1,'2015-07-22 13:30:00'),(5,2,'2015-07-27 10:00:00'),(6,3,'2015-08-14 11:30:00'),(7,3,'2015-08-19 11:30:00'),(11,4,'2015-08-19 10:00:00'),(14,5,'2015-08-17 12:00:00'),(15,5,'2015-08-19 12:00:00'),(17,5,'2015-08-25 12:00:00'),(21,6,'2015-09-22 09:00:00'),(22,6,'2015-09-29 09:00:00'),(23,6,'2015-10-05 08:00:00'),(24,7,'2015-09-01 10:00:00'),(25,7,'2015-09-08 10:00:00'),(26,7,'2015-09-15 10:00:00'),(30,8,'2015-10-22 15:00:00'),(31,8,'2015-10-09 15:00:00'),(32,8,'2015-08-28 15:00:00'),(33,8,'2015-08-13 15:00:00'),(34,8,'2015-09-29 15:00:00'),(38,8,'2015-10-14 15:00:00'),(39,8,'2015-10-19 15:00:00'),(42,8,'2015-10-30 15:00:00'),(43,8,'2015-10-05 15:00:00'),(50,9,'2015-09-11 10:00:00'),(53,9,'2015-09-22 10:00:00'),(55,9,'2015-09-30 10:00:00'),(56,9,'2015-10-05 10:00:00'),(59,10,'2015-09-04 13:00:00'),(60,10,'2015-09-11 13:00:00'),(61,10,'2015-09-18 13:00:00'),(62,10,'2015-09-25 13:00:00'),(63,10,'2015-10-02 13:00:00'),(64,10,'2015-10-09 13:00:00'),(65,10,'2015-10-16 13:00:00'),(66,10,'2015-10-23 13:00:00'),(67,10,'2015-10-30 13:00:00'),(68,10,'2015-11-07 13:00:00'),(69,10,'2015-11-14 13:00:00'),(71,11,'2015-08-19 09:00:00'),(73,11,'2015-08-25 09:00:00'),(79,12,'2015-09-11 11:30:00'),(81,13,'2015-08-15 09:00:00'),(82,13,'2015-08-16 09:00:00'),(83,13,'2015-08-17 09:00:00'),(84,14,'2015-10-20 16:00:00'),(143,52,'2015-08-20 16:50:00');
/*!40000 ALTER TABLE `meet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meet_version`
--

DROP TABLE IF EXISTS `meet_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meet_version` (
  `old_version` int(11) NOT NULL,
  `new_version` int(11) NOT NULL,
  PRIMARY KEY (`old_version`,`new_version`),
  KEY `fk_meet(new)_meet_version_idx` (`new_version`),
  CONSTRAINT `fk_meet(new)_meet_version` FOREIGN KEY (`new_version`) REFERENCES `meet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_meet(old)_meet_version` FOREIGN KEY (`old_version`) REFERENCES `meet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet_version`
--

LOCK TABLES `meet_version` WRITE;
/*!40000 ALTER TABLE `meet_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `meet_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `new_view` (
  `id` tinyint NOT NULL,
  `training_id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `annotation` tinyint NOT NULL,
  `date` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `training_id` int(11) NOT NULL,
  `theme` text NOT NULL,
  `text` text NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sender_id` int(11) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `approve` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_training_notice_idx` (`training_id`),
  CONSTRAINT `fk_training_notice` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (56,52,'Approve create training','Need approve of the new training \"1\"','2015-08-07 16:15:08',7,'warning',NULL,1),(57,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Wait','2015-08-07 16:15:48',666,'success',NULL,0),(58,8,'Addition successfully completed','User Grigoriev Anton was added to the \"JAVA\" participants list with status Approve','2015-08-07 16:15:48',666,'success',NULL,0),(59,8,'Approve edit training','Need approve changes in training \"JAVA*\"','2015-08-07 16:16:32',7,'warning',1,0),(60,12,'Addition successfully completed','You was added to the \"C and C++\" participants list with status Wait','2015-08-10 06:40:35',666,'success',NULL,0),(61,12,'Addition successfully completed','User Vasilenko Janna was added to the \"C and C++\" participants list with status Approve','2015-08-10 06:40:35',666,'success',NULL,0),(62,5,'Addition successfully completed','You was added to the \"Hibernate\" participants list with status Wait','2015-08-10 06:41:23',666,'success',NULL,0),(63,5,'Addition successfully completed','User Lebedev Nikolay was added to the \"Hibernate\" participants list with status Approve','2015-08-10 06:41:23',666,'success',NULL,0),(64,12,'Addition successfully completed','You was added to the \"C and C++\" participants list with status Wait','2015-08-10 06:42:13',666,'success',NULL,0),(65,12,'Addition successfully completed','User Petrovich Stanislav was added to the \"C and C++\" participants list with status Approve','2015-08-10 06:42:13',666,'success',NULL,0),(66,12,'Deletion completed','You was deleted from the \"C and C++\" participants list','2015-08-10 06:44:50',666,'success',NULL,0),(67,12,'Deletion completed','User Petrovich Stanislav was deleted from the \"C and C++\" participants list','2015-08-10 06:44:50',666,'success',NULL,0),(68,12,'Addition successfully completed','You was added to the \"C and C++\" participants list with status Wait','2015-08-10 06:45:34',666,'success',NULL,0),(69,12,'Addition successfully completed','User Petrovich Stanislav was added to the \"C and C++\" participants list with status Approve','2015-08-10 06:45:34',666,'success',NULL,0),(70,3,'Addition successfully completed','You was added to the \"Front End: JS\" participants list with status Wait','2015-08-10 06:46:34',666,'success',NULL,0),(71,3,'Addition successfully completed','User Nedelko Dmitriy was added to the \"Front End: JS\" participants list with status Approve','2015-08-10 06:46:34',666,'success',NULL,0),(72,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Wait','2015-08-10 06:46:56',666,'success',NULL,0),(73,8,'Addition successfully completed','User Nedelko Dmitriy was added to the \"JAVA\" participants list with status Approve','2015-08-10 06:46:56',666,'success',NULL,0),(74,14,'Addition successfully completed','You was added to the \"Programming Competition\" participants list with status Wait','2015-08-10 06:47:12',666,'success',NULL,0),(75,14,'Addition successfully completed','User Nedelko Dmitriy was added to the \"Programming Competition\" participants list with status Approve','2015-08-10 06:47:12',666,'success',NULL,0),(76,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Wait','2015-08-10 06:47:41',666,'success',NULL,0),(77,8,'Addition successfully completed','User Lebedev Nikolay was added to the \"JAVA\" participants list with status Approve','2015-08-10 06:47:41',666,'success',NULL,0),(78,6,'Addition successfully completed','You was added to the \"Spring\" participants list with status Wait','2015-08-10 06:47:49',666,'success',NULL,0),(79,6,'Addition successfully completed','User Lebedev Nikolay was added to the \"Spring\" participants list with status Approve','2015-08-10 06:47:50',666,'success',NULL,0),(80,9,'Addition successfully completed','You was added to the \"Python\" participants list with status Wait','2015-08-10 06:47:56',666,'success',NULL,0),(81,9,'Addition successfully completed','User Lebedev Nikolay was added to the \"Python\" participants list with status Approve','2015-08-10 06:47:56',666,'success',NULL,0),(82,3,'Addition successfully completed','You was added to the \"Front End: JS\" participants list with status Wait','2015-08-10 06:48:37',666,'success',NULL,0),(83,3,'Addition successfully completed','User Skavysh Maksim was added to the \"Front End: JS\" participants list with status Approve','2015-08-10 06:48:37',666,'success',NULL,0),(84,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Wait','2015-08-10 06:48:50',666,'success',NULL,0),(85,8,'Addition successfully completed','User Skavysh Maksim was added to the \"JAVA\" participants list with status Approve','2015-08-10 06:48:50',666,'success',NULL,0),(86,12,'Addition successfully completed','You was added to the \"C and C++\" participants list with status Wait','2015-08-10 06:49:04',666,'success',NULL,0),(87,12,'Addition successfully completed','User Skavysh Maksim was added to the \"C and C++\" participants list with status Approve','2015-08-10 06:49:04',666,'success',NULL,0),(88,14,'Addition successfully completed','You was added to the \"Programming Competition\" participants list with status Wait','2015-08-10 06:49:16',666,'success',NULL,0),(89,14,'Addition successfully completed','User Skavysh Maksim was added to the \"Programming Competition\" participants list with status Approve','2015-08-10 06:49:16',666,'success',NULL,0),(90,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:18:07',666,'success',NULL,0),(91,8,'Addition successfully completed','User Petrovich Stanislav was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:18:07',666,'success',NULL,0),(92,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:19:06',666,'success',NULL,0),(93,8,'Addition successfully completed','User Grakova Maria was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:19:06',666,'success',NULL,0),(94,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:19:41',666,'success',NULL,0),(95,8,'Addition successfully completed','User Nikiforenko Anton was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:19:41',666,'success',NULL,0),(96,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:20:41',666,'success',NULL,0),(97,8,'Addition successfully completed','User Volchkov Konstantin was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:20:41',666,'success',NULL,0),(98,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:21:05',666,'success',NULL,0),(99,8,'Addition successfully completed','User Zapolskiy Aleksey was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:21:05',666,'success',NULL,0),(100,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:21:44',666,'success',NULL,0),(101,8,'Addition successfully completed','User Rovdo Darya was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:21:44',666,'success',NULL,0),(102,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:22:45',666,'success',NULL,0),(103,8,'Addition successfully completed','User Kukuev Mihail was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:22:45',666,'success',NULL,0),(104,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:23:11',666,'success',NULL,0),(105,8,'Addition successfully completed','User Palaznik Ivan was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:23:11',666,'success',NULL,0),(106,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:23:31',666,'success',NULL,0),(107,8,'Addition successfully completed','User Poyda Ivan was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:23:31',666,'success',NULL,0),(108,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:24:16',666,'success',NULL,0),(109,8,'Addition successfully completed','User Hlystun Viktoriya was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:24:16',666,'success',NULL,0),(110,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:24:46',666,'success',NULL,0),(111,8,'Addition successfully completed','User Aneychik Anna was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:24:46',666,'success',NULL,0),(112,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:25:05',666,'success',NULL,0),(113,8,'Addition successfully completed','User Dosov Anton was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:25:05',666,'success',NULL,0),(114,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:25:44',666,'success',NULL,0),(115,8,'Addition successfully completed','User Busel Darya was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:25:44',666,'success',NULL,0),(116,8,'Addition successfully completed','You was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:26:09',666,'success',NULL,0),(117,8,'Addition successfully completed','User Romashko Viktor was added to the \"JAVA\" participants list with status Approve','2015-08-11 04:26:09',666,'success',NULL,0);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant` (
  `subscribe_id` int(11) NOT NULL,
  `meet_id` int(11) NOT NULL,
  `absent` tinyint(4) DEFAULT '0',
  `reason` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_subscribe_participant_idx` (`subscribe_id`),
  CONSTRAINT `fk_subscribe_participant` FOREIGN KEY (`subscribe_id`) REFERENCES `subscribe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (20,27,NULL,NULL,1),(20,28,NULL,NULL,2),(20,29,NULL,NULL,3),(20,30,NULL,NULL,4),(20,31,NULL,NULL,5),(20,32,NULL,NULL,6),(20,33,NULL,NULL,7),(20,34,NULL,NULL,8),(20,35,NULL,NULL,9),(20,36,NULL,NULL,10),(20,37,NULL,NULL,11),(20,38,NULL,NULL,12),(20,39,NULL,NULL,13),(20,40,NULL,NULL,14),(20,41,NULL,NULL,15),(20,42,NULL,NULL,16),(20,43,NULL,NULL,17),(20,44,NULL,NULL,18),(20,45,NULL,NULL,19),(20,46,NULL,NULL,20),(20,47,NULL,NULL,21),(21,79,NULL,NULL,22),(22,14,NULL,NULL,23),(22,15,NULL,NULL,24),(22,17,NULL,NULL,25),(23,79,NULL,NULL,27),(24,6,NULL,NULL,28),(24,7,NULL,NULL,29),(25,27,NULL,NULL,30),(25,31,NULL,NULL,31),(25,32,NULL,NULL,32),(25,34,NULL,NULL,33),(25,38,NULL,NULL,34),(25,39,NULL,NULL,35),(25,42,NULL,NULL,36),(25,43,NULL,NULL,37),(26,84,NULL,NULL,38),(27,27,NULL,NULL,39),(27,31,NULL,NULL,40),(27,32,NULL,NULL,41),(27,34,NULL,NULL,42),(27,38,NULL,NULL,43),(27,39,NULL,NULL,44),(27,42,NULL,NULL,45),(27,43,NULL,NULL,46),(28,21,NULL,NULL,47),(28,22,NULL,NULL,48),(28,23,NULL,NULL,49),(29,50,NULL,NULL,50),(29,53,NULL,NULL,51),(29,55,NULL,NULL,52),(29,56,NULL,NULL,53),(30,6,NULL,NULL,54),(30,7,NULL,NULL,55),(31,27,NULL,NULL,56),(31,31,NULL,NULL,57),(31,32,NULL,NULL,58),(31,34,NULL,NULL,59),(31,38,NULL,NULL,60),(31,39,NULL,NULL,61),(31,42,NULL,NULL,62),(31,43,NULL,NULL,63),(32,79,NULL,NULL,64),(33,84,NULL,NULL,65),(34,30,NULL,NULL,66),(34,31,NULL,NULL,67),(34,32,NULL,NULL,68),(34,33,NULL,NULL,69),(34,34,NULL,NULL,70),(34,38,NULL,NULL,71),(34,39,NULL,NULL,72),(34,42,NULL,NULL,73),(34,43,NULL,NULL,74),(35,30,NULL,NULL,75),(35,31,NULL,NULL,76),(35,32,NULL,NULL,77),(35,33,NULL,NULL,78),(35,34,NULL,NULL,79),(35,38,NULL,NULL,80),(35,39,NULL,NULL,81),(35,42,NULL,NULL,82),(35,43,NULL,NULL,83),(36,30,NULL,NULL,84),(36,31,NULL,NULL,85),(36,32,NULL,NULL,86),(36,33,NULL,NULL,87),(36,34,NULL,NULL,88),(36,38,NULL,NULL,89),(36,39,NULL,NULL,90),(36,42,NULL,NULL,91),(36,43,NULL,NULL,92),(37,30,NULL,NULL,93),(37,31,NULL,NULL,94),(37,32,NULL,NULL,95),(37,33,NULL,NULL,96),(37,34,NULL,NULL,97),(37,38,NULL,NULL,98),(37,39,NULL,NULL,99),(37,42,NULL,NULL,100),(37,43,NULL,NULL,101),(38,30,NULL,NULL,102),(38,31,NULL,NULL,103),(38,32,NULL,NULL,104),(38,33,NULL,NULL,105),(38,34,NULL,NULL,106),(38,38,NULL,NULL,107),(38,39,NULL,NULL,108),(38,42,NULL,NULL,109),(38,43,NULL,NULL,110),(39,30,NULL,NULL,111),(39,31,NULL,NULL,112),(39,32,NULL,NULL,113),(39,33,NULL,NULL,114),(39,34,NULL,NULL,115),(39,38,NULL,NULL,116),(39,39,NULL,NULL,117),(39,42,NULL,NULL,118),(39,43,NULL,NULL,119),(40,30,NULL,NULL,120),(40,31,NULL,NULL,121),(40,32,NULL,NULL,122),(40,33,NULL,NULL,123),(40,34,NULL,NULL,124),(40,38,NULL,NULL,125),(40,39,NULL,NULL,126),(40,42,NULL,NULL,127),(40,43,NULL,NULL,128),(41,30,NULL,NULL,129),(41,31,NULL,NULL,130),(41,32,NULL,NULL,131),(41,33,NULL,NULL,132),(41,34,NULL,NULL,133),(41,38,NULL,NULL,134),(41,39,NULL,NULL,135),(41,42,NULL,NULL,136),(41,43,NULL,NULL,137),(42,30,NULL,NULL,138),(42,31,NULL,NULL,139),(42,32,NULL,NULL,140),(42,33,NULL,NULL,141),(42,34,NULL,NULL,142),(42,38,NULL,NULL,143),(42,39,NULL,NULL,144),(42,42,NULL,NULL,145),(42,43,NULL,NULL,146),(43,30,NULL,NULL,147),(43,31,NULL,NULL,148),(43,32,NULL,NULL,149),(43,33,NULL,NULL,150),(43,34,NULL,NULL,151),(43,38,NULL,NULL,152),(43,39,NULL,NULL,153),(43,42,NULL,NULL,154),(43,43,NULL,NULL,155),(44,30,NULL,NULL,156),(44,31,NULL,NULL,157),(44,32,NULL,NULL,158),(44,33,NULL,NULL,159),(44,34,NULL,NULL,160),(44,38,NULL,NULL,161),(44,39,NULL,NULL,162),(44,42,NULL,NULL,163),(44,43,NULL,NULL,164),(45,30,NULL,NULL,165),(45,31,NULL,NULL,166),(45,32,NULL,NULL,167),(45,33,NULL,NULL,168),(45,34,NULL,NULL,169),(45,38,NULL,NULL,170),(45,39,NULL,NULL,171),(45,42,NULL,NULL,172),(45,43,NULL,NULL,173),(46,30,NULL,NULL,174),(46,31,NULL,NULL,175),(46,32,NULL,NULL,176),(46,33,NULL,NULL,177),(46,34,NULL,NULL,178),(46,38,NULL,NULL,179),(46,39,NULL,NULL,180),(46,42,NULL,NULL,181),(46,43,NULL,NULL,182),(47,30,NULL,NULL,183),(47,31,NULL,NULL,184),(47,32,NULL,NULL,185),(47,33,NULL,NULL,186),(47,34,NULL,NULL,187),(47,38,NULL,NULL,188),(47,39,NULL,NULL,189),(47,42,NULL,NULL,190),(47,43,NULL,NULL,191);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `report`
--

DROP TABLE IF EXISTS `report`;
/*!50001 DROP VIEW IF EXISTS `report`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `report` (
  `id` tinyint NOT NULL,
  `subscribe_id` tinyint NOT NULL,
  `date` tinyint NOT NULL,
  `absent` tinyint NOT NULL,
  `reason` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'external'),(3,'trainer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `searchevent`
--

DROP TABLE IF EXISTS `searchevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `searchevent` (
  `id` int(11) NOT NULL,
  `annotation` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `training_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `searchevent`
--

LOCK TABLES `searchevent` WRITE;
/*!40000 ALTER TABLE `searchevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `searchevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribe`
--

DROP TABLE IF EXISTS `subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscribe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_employee_subscribe_idx` (`employee_id`),
  KEY `fk_training_subscribe_idx` (`training_id`),
  CONSTRAINT `fk_employee_subscribe` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_training_subscribe` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
INSERT INTO `subscribe` VALUES (20,1,8,'Approve','2015-08-07 16:15:48'),(21,7,12,'Approve','2015-08-10 06:40:35'),(22,4,5,'Approve','2015-08-10 06:41:22'),(23,3,12,'Approve','2015-08-10 06:45:34'),(24,5,3,'Approve','2015-08-10 06:46:34'),(25,5,8,'Approve','2015-08-10 06:46:56'),(26,5,14,'Approve','2015-08-10 06:47:12'),(27,4,8,'Approve','2015-08-10 06:47:41'),(28,4,6,'Approve','2015-08-10 06:47:49'),(29,4,9,'Approve','2015-08-10 06:47:56'),(30,6,3,'Approve','2015-08-10 06:48:37'),(31,6,8,'Approve','2015-08-10 06:48:50'),(32,6,12,'Approve','2015-08-10 06:49:04'),(33,6,14,'Approve','2015-08-10 06:49:16'),(34,3,8,'Approve','2015-08-11 04:18:07'),(35,2,8,'Approve','2015-08-11 04:19:06'),(36,8,8,'Approve','2015-08-11 04:19:41'),(37,9,8,'Approve','2015-08-11 04:20:41'),(38,10,8,'Approve','2015-08-11 04:21:05'),(39,11,8,'Approve','2015-08-11 04:21:44'),(40,13,8,'Approve','2015-08-11 04:22:45'),(41,14,8,'Approve','2015-08-11 04:23:11'),(42,16,8,'Approve','2015-08-11 04:23:31'),(43,17,8,'Approve','2015-08-11 04:24:16'),(44,20,8,'Approve','2015-08-11 04:24:46'),(45,21,8,'Approve','2015-08-11 04:25:05'),(46,22,8,'Approve','2015-08-11 04:25:44'),(47,24,8,'Approve','2015-08-11 04:26:09');
/*!40000 ALTER TABLE `subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT 'token',
  `employee_id` int(11) NOT NULL,
  `session` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_token_idx` (`employee_id`),
  CONSTRAINT `fk_employee_token` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'070815181543327011129',1,'070815181406-1308679184',NULL,NULL),(2,'1108150718591511696205',2,NULL,NULL,NULL),(3,'110815073438-1971466380',3,'050815130324-2137917408',NULL,NULL),(4,'10081509472895805583',4,NULL,NULL,NULL),(5,'100815094629-1892260263',5,NULL,NULL,NULL),(6,'100815094830-125895937',6,NULL,NULL,NULL),(7,'100815065432-956712087',7,'1008150939091306725946',NULL,NULL),(8,'110815071936-1689737803',8,NULL,NULL,NULL),(9,'110815072036-1836363180',9,NULL,NULL,NULL),(10,'11081507210137737069',10,NULL,NULL,NULL),(11,'110815072139-1882912082',11,NULL,NULL,NULL),(12,'token',12,NULL,NULL,NULL),(13,'token',13,'110815072240313905790',NULL,NULL),(14,'110815072306-471263929',14,NULL,NULL,NULL),(15,'token',15,NULL,NULL,NULL),(16,'110815072326497913581',16,NULL,NULL,NULL),(17,'110815072411-686441695',17,NULL,NULL,NULL),(18,'token',18,NULL,NULL,NULL),(19,'token',19,NULL,NULL,NULL),(20,'1108150724411377958174',20,NULL,NULL,NULL),(21,'1108150725011260982109',21,NULL,NULL,NULL),(22,'token',22,'1108150725401386868749',NULL,NULL),(23,'token',23,NULL,NULL,NULL),(24,'110815072604-1935294919',24,NULL,NULL,NULL),(25,'token',25,NULL,NULL,NULL),(26,'token',26,NULL,NULL,NULL),(27,'token',27,NULL,NULL,NULL),(28,'token',28,NULL,NULL,NULL),(29,'token',29,NULL,NULL,NULL),(30,'token',30,NULL,NULL,NULL),(31,'token',31,NULL,NULL,NULL),(32,'token',32,NULL,NULL,NULL),(33,'token',33,NULL,NULL,NULL),(34,'token',34,NULL,NULL,NULL),(35,'token',35,NULL,NULL,NULL),(36,'token',36,NULL,NULL,NULL),(37,'100815065416-812683562',37,NULL,NULL,NULL),(38,'token',38,NULL,NULL,NULL),(39,'token',39,NULL,NULL,NULL),(40,'token',40,NULL,NULL,NULL),(41,'token',41,NULL,NULL,NULL),(42,'token',42,NULL,NULL,NULL),(43,'token',43,NULL,NULL,NULL),(44,'token',44,NULL,NULL,NULL),(45,'token',45,NULL,NULL,NULL),(46,'token',46,NULL,NULL,NULL),(666,'token',666,NULL,NULL,NULL);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_feedback`
--

DROP TABLE IF EXISTS `trainer_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `feedbacker_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `presence` varchar(255) DEFAULT NULL,
  `attitude` varchar(255) DEFAULT NULL,
  `communication` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `interest` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `other` text,
  PRIMARY KEY (`id`),
  KEY `fk_employee_trainer_feedback_idx1` (`employee_id`),
  KEY `fk_training_trainer_feedback_idx` (`training_id`),
  KEY `fk_employee_trainer_feedback_idx` (`feedbacker_id`),
  CONSTRAINT `fk_employee_trainer_feedback` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_employee_trainer_feedback_` FOREIGN KEY (`feedbacker_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_training_trainer_feedback` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_feedback`
--

LOCK TABLES `trainer_feedback` WRITE;
/*!40000 ALTER TABLE `trainer_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trainer_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `annotation` varchar(120) NOT NULL,
  `description` text NOT NULL,
  `target` varchar(45) NOT NULL,
  `paid` tinyint(4) NOT NULL,
  `internal` tinyint(4) NOT NULL,
  `approve` tinyint(4) NOT NULL DEFAULT '0',
  `max_participants` int(11) NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `trainer_id_idx` (`trainer_id`),
  CONSTRAINT `fk_employee_training` FOREIGN KEY (`trainer_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,39,'Web usability','Some latest practices for web usability','The aim of this course is to help delegates design better web sites by showing how the various user experience tools and techniques fit into real-world design and development processes. This web usability training course will give you hands-on practice in all the key areas of usability, from identifying your customers through to usability testing your web site with them.','All-levels Web developers',0,1,1,20,'222',1),(2,40,'Accident Prevention','Accident prevention basics','Accident prevention refers to the plans, preparations and actions taken to avoid or stop an accident before it happens. Accidents can be classified as unplanned and unexpected events giving increased risk of injury, ill health, death and loss of property, damage to environment or any combination of thereof. Accident prevention includes all measures taken in an effort to save lives, escape from injury, lessen the degrees of injury, reduce loss of properties, treatment and compensation costs, production and time loss, and morale loss of the concerned organization.','All employees',0,1,0,30,'243',1),(3,35,'Front End: JS','JavaScript course for medium-level developers','This course is designed to accommodate website designers who have some experience building web pages. Lessons familiarize students with the ins and outs of basic JavaScript and then move on to advanced tools for adding really useful interactivity to a Web site as quickly and easily as possible with the help of pre-written jQuery libraries.','Medium-level Front End developers',1,0,1,15,'225',0),(4,41,'DB: advanced course','Advanced DB lectures and practise','This course introduces advanced part of database systems, as well as the modeling, desgin and manipulation of relational databases. The students will gain the required knowledge to describe databases, their characteristics, functions, pros and cons.     Topics include data modeling, database design theory, data definition and manipulation languages, storage and indexing techniques, etc. The course will enable the students to create and manipulate databases on Oracle database management system. ','DB Designers',0,1,1,20,'242',0),(5,42,'Hibernate','Hibernate, a popular open-source object/relational mapping (ORM) tool','This course introduces Hibernate, a popular open-source object/relational mapping (ORM) tool that helps Java developers store and access persistent objects. Topics covered include Hibernate configuration, the Hibernate mapping file, inheritance, collections, associations, and the Hibernate Query Language (HQL).','Medium-level JAVA developers',0,1,1,28,'242',0),(6,43,'Spring','Spring Framework, the leading full-stack framework for Java EE applications','This course introduces the Spring Framework, the leading full-stack framework for Java EE applications. Topics covered include the Spring container, dependency injection, data validation, aspect-oriented programming, the JDBC Template, and the Hibernate Template. A Web application is also presented to illustrate the use of the Spring Web MVC framework.','Medium-level JAVA developers',0,1,1,24,'314',0),(7,39,'Automation testing','Automation testing for anyone','This course is designed for anyone who is either planning to automate or is already involved. No technical skills or experience are required; all technical concepts will be explained. The course is tool and application neutral, but the concepts and examples are better suited to UI testing than services or APIs.','QA Engineer',0,1,0,12,'212',1),(8,7,'JAVA','Introduction to Programming in Java','This course is an introduction to software engineering, using the Java programming language. It covers concepts useful to 6.005 Elements of Software Construction. Students will learn the fundamentals of Java. The focus is on developing high quality, working software that solves real problems.','Begginers in JAVA Development',1,0,1,20,'214',0),(9,42,'Python','A Gentle Introduction to Programming Using Python','This course will provide a gentle, yet intense, introduction to programming using Python for highly motivated students with little or no prior experience in programming. The course will focus on planning and organizing programs, as well as the grammar of the Python programming language. The course is designed to help prepare students for 6.01 Introduction to EECS I.','Begginers in Python Development',0,1,1,10,'335',0),(10,33,'Computer Engineering','Introduction to Computers and Engineering Problem Solving','This course presents the fundamentals of object-oriented software design and development, computational methods and sensing for engineering, and scientific and managerial applications. Topics include classes, inheritance, graphical user interfaces, numerical methods, streams, threads, sensors, and data structures.\n','Engineers',1,0,0,12,'333',0),(11,33,'MATLAB Programming','Introduction to MATLAB Programming','This course teaches MATLAB from a mathematical point of view, rather than a programming one. The idea is that by thinking about mathematical problems, students are prodded into learning MATLAB for the purpose of solving the problem at hand. Topics include variables, arrays, conditional statements, loops, functions, and plots.','All level developers',0,0,1,16,'210',0),(12,34,'C and C++','Introduction to C and C++','This course provides a fast-paced introduction to the C and C++ programming languages. You will learn the required background knowledge, including memory management, pointers, preprocessor macros, object-oriented programming, and how to find bugs when you inevitably use any of those incorrectly.','Begginers in C and C++',1,0,1,28,'228',0),(13,44,'Software Construction','Elements of Software Construction','This course introduces fundamental principles and techniques of software development. Students learn how to write software that is safe from bugs, easy to understand, and ready for change.','All developers',0,1,0,30,'316',0),(14,34,'Programming Competition','The Battlecode Programming Competition','The Battlecode Programming Competition is a unique challenge that combines battle strategy, software engineering, and artificial intelligence. Using Java, student teams program virtual robots to play Battlecode, a real-time strategy game. Optional lectures are provided on topics and programming practices relevant to the game, and students learn and improve their programming skills experientially. The course culminates in a live tournament.','All JAVA developers',1,1,1,20,'333',0),(52,7,'1','1','1','1',1,1,0,1,'1',0);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_tag`
--

DROP TABLE IF EXISTS `training_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_tag` (
  `training_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`training_id`,`tag_id`),
  KEY `fk_tag_training_tag_idx` (`tag_id`),
  CONSTRAINT `fk_tag_training_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_training_training_tag` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_tag`
--

LOCK TABLES `training_tag` WRITE;
/*!40000 ALTER TABLE `training_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_version`
--

DROP TABLE IF EXISTS `training_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_version` (
  `old_version` int(11) NOT NULL,
  `new_version` int(11) NOT NULL,
  PRIMARY KEY (`old_version`,`new_version`),
  KEY `fk_training(new)_training_version_idx` (`new_version`),
  CONSTRAINT `fk_training(new)_training_version` FOREIGN KEY (`new_version`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_training(old)_training_version` FOREIGN KEY (`old_version`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_version`
--

LOCK TABLES `training_version` WRITE;
/*!40000 ALTER TABLE `training_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `old_id` int(11) NOT NULL,
  `json` text NOT NULL,
  `entity_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,NULL,8,'{\n  \"id\": 8,\n  \"name\": \"JAVA*\",\n  \"annotation\": \"Introduction to Programming in Java\",\n  \"description\": \"This course is an introduction to software engineering, using the Java programming language. It covers concepts useful to 6.005 Elements of Software Construction. Students will learn the fundamentals of Java. The focus is on developing high quality, working software that solves real problems.\",\n  \"target\": \"Begginers in JAVA Development\",\n  \"paid\": true,\n  \"max_participants\": 20,\n  \"place\": \"214\",\n  \"internal\": false,\n  \"approve\": true,\n  \"trainer_id\": 7,\n  \"date\": [\n    \"Sep 2, 2015 5:00:00 PM\",\n    \"Sep 5, 2015 5:00:00 PM\",\n    \"Sep 10, 2015 5:00:00 PM\",\n    \"Sep 13, 2015 5:00:00 PM\",\n    \"Sep 18, 2015 5:00:00 PM\",\n    \"Sep 21, 2015 5:00:00 PM\",\n    \"Sep 26, 2015 5:00:00 PM\",\n    \"Sep 29, 2015 5:00:00 PM\",\n    \"Oct 3, 2015 5:00:00 PM\",\n    \"Oct 6, 2015 5:00:00 PM\",\n    \"Oct 11, 2015 5:00:00 PM\",\n    \"Oct 14, 2015 5:00:00 PM\",\n    \"Oct 19, 2015 5:00:00 PM\",\n    \"Oct 22, 2015 5:00:00 PM\",\n    \"Oct 27, 2015 5:00:00 PM\",\n    \"Oct 30, 2015 5:00:00 PM\",\n    \"Oct 5, 2015 5:00:00 PM\",\n    \"Oct 8, 2015 5:00:00 PM\",\n    \"Oct 13, 2015 5:00:00 PM\",\n    \"Oct 16, 2015 5:00:00 PM\",\n    \"Oct 21, 2015 5:00:00 PM\"\n  ],\n  \"meets\": [\n    {\n      \"id\": 27\n    },\n    {\n      \"id\": 28\n    },\n    {\n      \"id\": 29\n    },\n    {\n      \"id\": 30\n    },\n    {\n      \"id\": 31\n    },\n    {\n      \"id\": 32\n    },\n    {\n      \"id\": 33\n    },\n    {\n      \"id\": 34\n    },\n    {\n      \"id\": 35\n    },\n    {\n      \"id\": 36\n    },\n    {\n      \"id\": 37\n    },\n    {\n      \"id\": 38\n    },\n    {\n      \"id\": 39\n    },\n    {\n      \"id\": 40\n    },\n    {\n      \"id\": 41\n    },\n    {\n      \"id\": 42\n    },\n    {\n      \"id\": 43\n    },\n    {\n      \"id\": 44\n    },\n    {\n      \"id\": 45\n    },\n    {\n      \"id\": 46\n    },\n    {\n      \"id\": 47\n    }\n  ],\n  \"isSubscribe\": false\n}','training'),(2,1,8,'{\n  \"date\": \"Sep 2, 2015 5:00:00 PM\",\n  \"id\": 27,\n  \"training_id\": 8\n}','meet'),(3,1,8,'{\n  \"date\": \"Sep 5, 2015 5:00:00 PM\",\n  \"id\": 28,\n  \"training_id\": 8\n}','meet'),(4,1,8,'{\n  \"date\": \"Sep 10, 2015 5:00:00 PM\",\n  \"id\": 29,\n  \"training_id\": 8\n}','meet'),(5,1,8,'{\n  \"date\": \"Sep 13, 2015 5:00:00 PM\",\n  \"id\": 30,\n  \"training_id\": 8\n}','meet'),(6,1,8,'{\n  \"date\": \"Sep 18, 2015 5:00:00 PM\",\n  \"id\": 31,\n  \"training_id\": 8\n}','meet'),(7,1,8,'{\n  \"date\": \"Sep 21, 2015 5:00:00 PM\",\n  \"id\": 32,\n  \"training_id\": 8\n}','meet'),(8,1,8,'{\n  \"date\": \"Sep 26, 2015 5:00:00 PM\",\n  \"id\": 33,\n  \"training_id\": 8\n}','meet'),(9,1,8,'{\n  \"date\": \"Sep 29, 2015 5:00:00 PM\",\n  \"id\": 34,\n  \"training_id\": 8\n}','meet'),(10,1,8,'{\n  \"date\": \"Oct 3, 2015 5:00:00 PM\",\n  \"id\": 35,\n  \"training_id\": 8\n}','meet'),(11,1,8,'{\n  \"date\": \"Oct 6, 2015 5:00:00 PM\",\n  \"id\": 36,\n  \"training_id\": 8\n}','meet'),(12,1,8,'{\n  \"date\": \"Oct 11, 2015 5:00:00 PM\",\n  \"id\": 37,\n  \"training_id\": 8\n}','meet'),(13,1,8,'{\n  \"date\": \"Oct 14, 2015 5:00:00 PM\",\n  \"id\": 38,\n  \"training_id\": 8\n}','meet'),(14,1,8,'{\n  \"date\": \"Oct 19, 2015 5:00:00 PM\",\n  \"id\": 39,\n  \"training_id\": 8\n}','meet'),(15,1,8,'{\n  \"date\": \"Oct 22, 2015 5:00:00 PM\",\n  \"id\": 40,\n  \"training_id\": 8\n}','meet'),(16,1,8,'{\n  \"date\": \"Oct 27, 2015 5:00:00 PM\",\n  \"id\": 41,\n  \"training_id\": 8\n}','meet'),(17,1,8,'{\n  \"date\": \"Oct 30, 2015 5:00:00 PM\",\n  \"id\": 42,\n  \"training_id\": 8\n}','meet'),(18,1,8,'{\n  \"date\": \"Oct 5, 2015 5:00:00 PM\",\n  \"id\": 43,\n  \"training_id\": 8\n}','meet'),(19,1,8,'{\n  \"date\": \"Oct 8, 2015 5:00:00 PM\",\n  \"id\": 44,\n  \"training_id\": 8\n}','meet'),(20,1,8,'{\n  \"date\": \"Oct 13, 2015 5:00:00 PM\",\n  \"id\": 45,\n  \"training_id\": 8\n}','meet'),(21,1,8,'{\n  \"date\": \"Oct 16, 2015 5:00:00 PM\",\n  \"id\": 46,\n  \"training_id\": 8\n}','meet'),(22,1,8,'{\n  \"date\": \"Oct 21, 2015 5:00:00 PM\",\n  \"id\": 47,\n  \"training_id\": 8\n}','meet');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP TABLE IF EXISTS `new_view`*/;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `meet`.`id` AS `id`,`training`.`id` AS `training_id`,`training`.`name` AS `name`,`training`.`annotation` AS `annotation`,`meet`.`date` AS `date` from (`training` join `meet`) where ((`training`.`approve` = 1) and (`training`.`is_delete` = 0) and (`meet`.`training_id` = `training`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `report`
--

/*!50001 DROP TABLE IF EXISTS `report`*/;
/*!50001 DROP VIEW IF EXISTS `report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `report` AS select `participant`.`id` AS `id`,`participant`.`subscribe_id` AS `subscribe_id`,`meet`.`date` AS `date`,`participant`.`absent` AS `absent`,`participant`.`reason` AS `reason` from (`participant` join `meet`) where (`participant`.`meet_id` = `meet`.`id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-11  8:06:17
