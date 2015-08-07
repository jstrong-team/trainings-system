CREATE DATABASE  IF NOT EXISTS `for_trainings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `for_trainings`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: for_trainings
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_notice`
--

LOCK TABLES `employee_notice` WRITE;
/*!40000 ALTER TABLE `employee_notice` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet`
--

LOCK TABLES `meet` WRITE;
/*!40000 ALTER TABLE `meet` DISABLE KEYS */;
INSERT INTO `meet` VALUES (1,1,'2015-07-14 13:30:00'),(2,1,'2015-07-18 13:30:00'),(3,1,'2015-07-22 13:30:00'),(4,1,'2015-07-22 13:30:00'),(5,2,'2015-07-27 10:00:00'),(6,3,'2015-08-14 11:30:00'),(7,3,'2015-08-19 11:30:00'),(8,3,'2015-08-24 12:00:00'),(9,3,'2015-08-29 12:30:00'),(10,4,'2015-08-15 09:00:00'),(11,4,'2015-08-19 10:00:00'),(12,4,'2015-08-23 10:00:00'),(13,5,'2015-08-15 12:00:00'),(14,5,'2015-08-17 13:00:00'),(15,5,'2015-08-19 12:00:00'),(16,5,'2015-08-22 11:30:00'),(17,5,'2015-08-25 12:00:00'),(18,6,'2015-09-01 07:30:00'),(19,6,'2015-09-08 07:30:00'),(20,6,'2015-09-15 07:30:00'),(21,6,'2015-09-22 09:00:00'),(22,6,'2015-09-29 09:00:00'),(23,6,'2015-10-05 08:00:00'),(24,7,'2015-09-01 10:00:00'),(25,7,'2015-09-08 10:00:00'),(26,7,'2015-09-15 10:00:00'),(27,8,'2015-09-02 15:00:00'),(28,8,'2015-09-05 15:00:00'),(29,8,'2015-09-10 15:00:00'),(30,8,'2015-09-13 15:00:00'),(31,8,'2015-09-18 15:00:00'),(32,8,'2015-09-21 15:00:00'),(33,8,'2015-09-26 15:00:00'),(34,8,'2015-09-29 15:00:00'),(35,8,'2015-10-03 15:00:00'),(36,8,'2015-10-06 15:00:00'),(37,8,'2015-10-11 15:00:00'),(38,8,'2015-10-14 15:00:00'),(39,8,'2015-10-19 15:00:00'),(40,8,'2015-10-22 15:00:00'),(41,8,'2015-10-27 15:00:00'),(42,8,'2015-10-30 15:00:00'),(43,8,'2015-10-05 15:00:00'),(44,8,'2015-10-08 15:00:00'),(45,8,'2015-10-13 15:00:00'),(46,8,'2015-10-16 15:00:00'),(47,8,'2015-10-21 15:00:00'),(48,9,'2015-09-03 10:00:00'),(49,9,'2015-09-06 10:00:00'),(50,9,'2015-09-11 10:00:00'),(51,9,'2015-09-14 10:00:00'),(52,9,'2015-09-19 10:00:00'),(53,9,'2015-09-22 10:00:00'),(54,9,'2015-09-27 10:00:00'),(55,9,'2015-09-30 10:00:00'),(56,9,'2015-10-05 10:00:00'),(57,9,'2015-10-08 10:00:00'),(58,9,'2015-10-10 10:00:00'),(59,10,'2015-09-04 13:00:00'),(60,10,'2015-09-11 13:00:00'),(61,10,'2015-09-18 13:00:00'),(62,10,'2015-09-25 13:00:00'),(63,10,'2015-10-02 13:00:00'),(64,10,'2015-10-09 13:00:00'),(65,10,'2015-10-16 13:00:00'),(66,10,'2015-10-23 13:00:00'),(67,10,'2015-10-30 13:00:00'),(68,10,'2015-11-07 13:00:00'),(69,10,'2015-11-14 13:00:00'),(70,11,'2015-08-16 09:00:00'),(71,11,'2015-08-19 09:00:00'),(72,11,'2015-08-22 09:00:00'),(73,11,'2015-08-25 09:00:00'),(74,11,'2015-08-28 09:00:00'),(75,11,'2015-08-30 09:00:00'),(76,12,'2015-09-05 11:30:00'),(77,12,'2015-09-07 11:30:00'),(78,12,'2015-09-09 11:30:00'),(79,12,'2015-09-11 11:30:00'),(80,12,'2015-09-13 11:30:00'),(81,13,'2015-08-15 09:00:00'),(82,13,'2015-08-16 09:00:00'),(83,13,'2015-08-17 09:00:00'),(84,14,'2015-08-20 16:00:00');
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
-- Temporary view structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `new_view` AS SELECT 
 1 AS `id`,
 1 AS `training_id`,
 1 AS `name`,
 1 AS `annotation`,
 1 AS `date`*/;
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
  PRIMARY KEY (`id`),
  KEY `fk_training_notice_idx` (`training_id`),
  CONSTRAINT `fk_training_notice` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `report`
--

DROP TABLE IF EXISTS `report`;
/*!50001 DROP VIEW IF EXISTS `report`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `report` AS SELECT 
 1 AS `id`,
 1 AS `subscribe_id`,
 1 AS `date`,
 1 AS `absent`,
 1 AS `reason`*/;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'010815122730-540119915',1,'050815102000278181481',NULL,NULL),(2,'token',2,NULL,NULL,NULL),(3,'token',3,'050815130324-2137917408',NULL,NULL),(4,'240715155508-2059738913',4,NULL,NULL,NULL),(5,'310715151646-2122411317',5,NULL,NULL,NULL),(6,'token',6,NULL,NULL,NULL),(7,'0308150926211296953224',7,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,39,'Web usability','Some latest practices for web usability','The aim of this course is to help delegates design better web sites by showing how the various user experience tools and techniques fit into real-world design and development processes. This web usability training course will give you hands-on practice in all the key areas of usability, from identifying your customers through to usability testing your web site with them.','All-levels Web developers',0,1,1,20,'222',1),(2,40,'Accident Prevention','Accident prevention basics','Accident prevention refers to the plans, preparations and actions taken to avoid or stop an accident before it happens. Accidents can be classified as unplanned and unexpected events giving increased risk of injury, ill health, death and loss of property, damage to environment or any combination of thereof. Accident prevention includes all measures taken in an effort to save lives, escape from injury, lessen the degrees of injury, reduce loss of properties, treatment and compensation costs, production and time loss, and morale loss of the concerned organization.','All employees',0,1,0,30,'243',1),(3,35,'Front End: JS','JavaScript course for medium-level developers','This course is designed to accommodate website designers who have some experience building web pages. Lessons familiarize students with the ins and outs of basic JavaScript and then move on to advanced tools for adding really useful interactivity to a Web site as quickly and easily as possible with the help of pre-written jQuery libraries.','Medium-level Front End developers',1,0,1,15,'225',0),(4,41,'DB: advanced course','Advanced DB lectures and practise','This course introduces advanced part of database systems, as well as the modeling, desgin and manipulation of relational databases. The students will gain the required knowledge to describe databases, their characteristics, functions, pros and cons.     Topics include data modeling, database design theory, data definition and manipulation languages, storage and indexing techniques, etc. The course will enable the students to create and manipulate databases on Oracle database management system. ','DB Designers',0,1,1,20,'242',0),(5,42,'Hibernate','Hibernate, a popular open-source object/relational mapping (ORM) tool','This course introduces Hibernate, a popular open-source object/relational mapping (ORM) tool that helps Java developers store and access persistent objects. Topics covered include Hibernate configuration, the Hibernate mapping file, inheritance, collections, associations, and the Hibernate Query Language (HQL).','Medium-level JAVA developers',0,1,1,28,'242',0),(6,43,'Spring','Spring Framework, the leading full-stack framework for Java EE applications','This course introduces the Spring Framework, the leading full-stack framework for Java EE applications. Topics covered include the Spring container, dependency injection, data validation, aspect-oriented programming, the JDBC Template, and the Hibernate Template. A Web application is also presented to illustrate the use of the Spring Web MVC framework.','Medium-level JAVA developers',0,1,1,24,'314',0),(7,39,'Automation testing','Automation testing for anyone','This course is designed for anyone who is either planning to automate or is already involved. No technical skills or experience are required; all technical concepts will be explained. The course is tool and application neutral, but the concepts and examples are better suited to UI testing than services or APIs.','QA Engineer',0,1,0,12,'212',1),(8,7,'JAVA','Introduction to Programming in Java','This course is an introduction to software engineering, using the Java programming language. It covers concepts useful to 6.005 Elements of Software Construction. Students will learn the fundamentals of Java. The focus is on developing high quality, working software that solves real problems.','Begginers in JAVA Development',1,0,1,20,'214',0),(9,42,'Python','A Gentle Introduction to Programming Using Python','This course will provide a gentle, yet intense, introduction to programming using Python for highly motivated students with little or no prior experience in programming. The course will focus on planning and organizing programs, as well as the grammar of the Python programming language. The course is designed to help prepare students for 6.01 Introduction to EECS I.','Begginers in Python Development',0,1,1,10,'335',0),(10,33,'Computer Engineering','Introduction to Computers and Engineering Problem Solving','This course presents the fundamentals of object-oriented software design and development, computational methods and sensing for engineering, and scientific and managerial applications. Topics include classes, inheritance, graphical user interfaces, numerical methods, streams, threads, sensors, and data structures.\n','Engineers',1,0,0,12,'333',0),(11,33,'MATLAB Programming','Introduction to MATLAB Programming','This course teaches MATLAB from a mathematical point of view, rather than a programming one. The idea is that by thinking about mathematical problems, students are prodded into learning MATLAB for the purpose of solving the problem at hand. Topics include variables, arrays, conditional statements, loops, functions, and plots.','All level developers',0,0,1,16,'210',0),(12,34,'C and C++','Introduction to C and C++','This course provides a fast-paced introduction to the C and C++ programming languages. You will learn the required background knowledge, including memory management, pointers, preprocessor macros, object-oriented programming, and how to find bugs when you inevitably use any of those incorrectly.','Begginers in C and C++',1,0,1,28,'228',0),(13,44,'Software Construction','Elements of Software Construction','This course introduces fundamental principles and techniques of software development. Students learn how to write software that is safe from bugs, easy to understand, and ready for change.','All developers',0,1,0,30,'316',0),(14,34,'Programming Competition','The Battlecode Programming Competition','The Battlecode Programming Competition is a unique challenge that combines battle strategy, software engineering, and artificial intelligence. Using Java, student teams program virtual robots to play Battlecode, a real-time strategy game. Optional lectures are provided on topics and programming practices relevant to the game, and students learn and improve their programming skills experientially. The course culminates in a live tournament.','All JAVA developers',1,1,1,20,'333',0);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `meet`.`id` AS `id`,`training`.`id` AS `training_id`,`training`.`name` AS `name`,`training`.`annotation` AS `annotation`,`meet`.`date` AS `date` from (`training` join `meet`) where ((`training`.`approve` = 1) and (`meet`.`training_id` = `training`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `report`
--

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

-- Dump completed on 2015-08-07 15:07:10
