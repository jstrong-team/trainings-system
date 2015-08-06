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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','b59c67bf196a4758191e42f76670ceba','Anton Grigoriev','toxa.z@mail.ru',NULL),(2,'masha','c3cc6e312d2bad42cf535aac3a259abd','Maria Grakova','mariagracova96@gmail.com',NULL),(3,'stas','c211c9e7e7689217c0cb99aafe30f3d7','Stanislav Petrovich','staspetrovichbsu@gmail.com',NULL),(4,'kolya','ec3da25081aa81b637fe6faa3debe26e','Nikolay Lebedev','nickylebedev@gmail.com',NULL),(5,'dima','0f5b25cd58319cde0e6e33715b66db4c','Dmitriy Nedelko',NULL,NULL),(6,'maks','051f7661ee7c287be66ee572768ec8f5','Maksim Skavish',NULL,NULL),(7,'main','fad58de7366495db4650cfefac2fcd61','Vasilenko Janna','toxa.z@mail.ru',NULL),(8,'jesus','110d46fcd978c24f306cd7fa23464d73','Jesus Christ',NULL,NULL),(9,'king','b2086154f101464aab3328ba7e060deb','Stephen King',NULL,NULL),(10,'vlad','d701fde59d74f76803087b6632186caf','Vladislav Dracula',NULL,NULL),(14,'Antonchik45','a26b62213e03f792d2c7bf70b8072c9e','Antonchik',NULL,NULL),(15,'aeeg74','0b2960921793ae8e59846b48f69eacb2','aeeg',NULL,NULL),(18,'Nik16','7be744b0b93bfa37df7da119e4f74d65','Nik',NULL,NULL),(19,'Antonishe99','616bbac626e8ae74c750c217ead95a92','Antonishe',NULL,NULL),(20,'Antoha56','43c0e6a414dd6044a1c95c27f5d36db3','Antoha',NULL,NULL),(21,'AAA79','a17cc8162338ae0fa9bae84b804c57be','AAA',NULL,NULL),(22,'hdtkydt36','db5d8ebdd9f09e37525ab8213f01421b','hdtkydt',NULL,NULL),(23,'jyfkuyfuyflu78','5cc35cdef0b5e3fe4a19d6a1aac85a7c','jyfkuyfuyflu',NULL,NULL),(24,'ssdfgff83','40f56af4c31c6261a0ad925442449548','ssdfgff',NULL,NULL),(25,'aerbrb74','5ae282e9fe740dfffd05604067f89744','aerbrb',NULL,NULL),(26,'Antonina','7e82e8895a180d2ed02d90b3d56c3794','Antonina','toxa.z@mail.ru',NULL),(27,'Ant','ca9677c10eed26726aeee4108d339062','Ant','toxa.z@mail.ru',NULL);
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
INSERT INTO `employee_feedback` VALUES (1,1,1,'2015-07-28 16:27:02',1,1,1,1,1,1,'1',0,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=490 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_notice`
--

LOCK TABLES `employee_notice` WRITE;
/*!40000 ALTER TABLE `employee_notice` DISABLE KEYS */;
INSERT INTO `employee_notice` VALUES (1,7,1,1),(2,7,2,1),(3,7,3,1),(4,7,4,1),(5,7,5,1),(6,7,6,1),(7,7,7,1),(8,7,8,1),(9,7,9,1),(10,7,10,1),(11,7,11,1),(12,7,12,1),(13,7,13,1),(14,7,14,1),(15,7,15,1),(16,7,16,1),(17,7,17,1),(26,7,50,1),(47,1,53,0),(48,2,53,0),(49,3,53,0),(50,4,53,0),(51,5,53,0),(52,6,53,0),(53,7,53,1),(54,8,53,0),(55,9,53,0),(56,10,53,0),(57,1,54,0),(58,2,54,0),(59,3,54,0),(60,4,54,0),(61,5,54,0),(62,6,54,0),(63,7,54,1),(64,8,54,0),(65,9,54,0),(66,10,54,0),(67,1,55,0),(68,2,55,0),(69,3,55,0),(70,4,55,0),(71,5,55,0),(72,6,55,0),(73,7,55,1),(74,8,55,0),(75,9,55,0),(76,10,55,0),(120,1,60,0),(121,2,60,0),(122,3,60,0),(123,4,60,0),(124,5,60,0),(125,6,60,0),(126,7,60,1),(127,8,60,0),(128,9,60,0),(129,10,60,0),(130,14,60,0),(131,1,61,0),(132,2,61,0),(133,3,61,0),(134,4,61,0),(135,5,61,0),(136,6,61,0),(137,7,61,1),(138,8,61,0),(139,9,61,0),(140,10,61,0),(141,14,61,0),(142,15,61,0),(169,1,64,0),(170,2,64,0),(171,3,64,0),(172,4,64,0),(173,5,64,0),(174,6,64,0),(175,7,64,1),(176,8,64,0),(177,9,64,0),(178,10,64,0),(179,14,64,0),(180,15,64,0),(181,18,64,0),(182,1,65,0),(183,2,65,0),(184,3,65,0),(185,4,65,0),(186,5,65,0),(187,6,65,0),(188,7,65,1),(189,8,65,0),(190,9,65,0),(191,10,65,0),(192,14,65,0),(193,15,65,0),(194,18,65,0),(195,19,65,0),(196,1,66,0),(197,2,66,0),(198,3,66,0),(199,4,66,0),(200,5,66,0),(201,6,66,0),(202,7,66,1),(203,8,66,0),(204,9,66,0),(205,10,66,0),(206,14,66,0),(207,15,66,0),(208,18,66,0),(209,19,66,0),(210,1,67,0),(211,2,67,0),(212,3,67,0),(213,4,67,0),(214,5,67,0),(215,6,67,0),(216,7,67,1),(217,8,67,0),(218,9,67,0),(219,10,67,0),(220,14,67,0),(221,15,67,0),(222,18,67,0),(223,19,67,0),(224,1,68,0),(225,2,68,0),(226,3,68,0),(227,4,68,0),(228,5,68,0),(229,6,68,0),(230,7,68,1),(231,8,68,0),(232,9,68,0),(233,10,68,0),(234,14,68,0),(235,15,68,0),(236,18,68,0),(237,19,68,0),(238,1,69,0),(239,2,69,0),(240,3,69,0),(241,4,69,0),(242,5,69,0),(243,6,69,0),(244,7,69,1),(245,8,69,0),(246,9,69,0),(247,10,69,0),(248,14,69,0),(249,15,69,0),(250,18,69,0),(251,19,69,0),(252,1,70,0),(253,2,70,0),(254,3,70,0),(255,4,70,0),(256,5,70,0),(257,6,70,0),(258,7,70,1),(259,8,70,0),(260,9,70,0),(261,10,70,0),(262,14,70,0),(263,15,70,0),(264,18,70,0),(265,19,70,0),(266,1,71,0),(267,2,71,0),(268,3,71,0),(269,4,71,0),(270,5,71,0),(271,6,71,0),(272,7,71,1),(273,8,71,0),(274,9,71,0),(275,10,71,0),(276,14,71,0),(277,15,71,0),(278,18,71,0),(279,19,71,0),(280,1,72,0),(281,2,72,0),(282,3,72,0),(283,4,72,0),(284,5,72,0),(285,6,72,0),(286,7,72,1),(287,8,72,0),(288,9,72,0),(289,10,72,0),(290,14,72,0),(291,15,72,0),(292,18,72,0),(293,19,72,0),(294,1,73,0),(295,2,73,0),(296,3,73,0),(297,4,73,0),(298,5,73,0),(299,6,73,0),(300,7,73,1),(301,8,73,0),(302,9,73,0),(303,10,73,0),(304,14,73,0),(305,15,73,0),(306,18,73,0),(307,19,73,0),(308,1,74,0),(309,2,74,0),(310,3,74,0),(311,4,74,0),(312,5,74,0),(313,6,74,0),(314,7,74,1),(315,8,74,0),(316,9,74,0),(317,10,74,0),(318,14,74,0),(319,15,74,0),(320,18,74,0),(321,19,74,0),(322,1,75,0),(323,2,75,0),(324,3,75,0),(325,4,75,0),(326,5,75,0),(327,6,75,0),(328,7,75,1),(329,8,75,0),(330,9,75,0),(331,10,75,0),(332,14,75,0),(333,15,75,0),(334,18,75,0),(335,19,75,0),(336,20,75,0),(337,1,76,0),(338,2,76,0),(339,3,76,0),(340,4,76,0),(341,5,76,0),(342,6,76,0),(343,7,76,1),(344,8,76,0),(345,9,76,0),(346,10,76,0),(347,14,76,0),(348,15,76,0),(349,18,76,0),(350,19,76,0),(351,20,76,0),(352,21,76,0),(353,1,77,0),(354,2,77,0),(355,3,77,0),(356,4,77,0),(357,5,77,0),(358,6,77,0),(359,7,77,0),(360,8,77,0),(361,9,77,0),(362,10,77,0),(363,14,77,0),(364,15,77,0),(365,18,77,0),(366,19,77,0),(367,20,77,0),(368,21,77,0),(369,22,77,0),(370,1,78,0),(371,2,78,0),(372,3,78,0),(373,4,78,0),(374,5,78,0),(375,6,78,0),(376,7,78,0),(377,8,78,0),(378,9,78,0),(379,10,78,0),(380,14,78,0),(381,15,78,0),(382,18,78,0),(383,19,78,0),(384,20,78,0),(385,21,78,0),(386,22,78,0),(387,23,78,0),(388,1,79,0),(389,2,79,0),(390,3,79,0),(391,4,79,0),(392,5,79,0),(393,6,79,0),(394,7,79,0),(395,8,79,0),(396,9,79,0),(397,10,79,0),(398,14,79,0),(399,15,79,0),(400,18,79,0),(401,19,79,0),(402,20,79,0),(403,21,79,0),(404,22,79,0),(405,23,79,0),(406,24,79,0),(407,1,80,0),(408,2,80,0),(409,3,80,0),(410,4,80,0),(411,5,80,0),(412,6,80,0),(413,7,80,0),(414,8,80,0),(415,9,80,0),(416,10,80,0),(417,14,80,0),(418,15,80,0),(419,18,80,0),(420,19,80,0),(421,20,80,0),(422,21,80,0),(423,22,80,0),(424,23,80,0),(425,24,80,0),(426,25,80,0),(427,1,81,0),(428,2,81,0),(429,3,81,0),(430,4,81,0),(431,5,81,0),(432,6,81,0),(433,7,81,0),(434,8,81,0),(435,9,81,0),(436,10,81,0),(437,14,81,0),(438,15,81,0),(439,18,81,0),(440,19,81,0),(441,20,81,0),(442,21,81,0),(443,22,81,0),(444,23,81,0),(445,24,81,0),(446,25,81,0),(447,1,82,0),(448,2,82,0),(449,3,82,0),(450,4,82,0),(451,5,82,0),(452,6,82,0),(453,7,82,0),(454,8,82,0),(455,9,82,0),(456,10,82,0),(457,14,82,0),(458,15,82,0),(459,18,82,0),(460,19,82,0),(461,20,82,0),(462,21,82,0),(463,22,82,0),(464,23,82,0),(465,24,82,0),(466,25,82,0),(467,26,82,0),(468,1,83,0),(469,2,83,0),(470,3,83,0),(471,4,83,0),(472,5,83,0),(473,6,83,0),(474,7,83,0),(475,8,83,0),(476,9,83,0),(477,10,83,0),(478,14,83,0),(479,15,83,0),(480,18,83,0),(481,19,83,0),(482,20,83,0),(483,21,83,0),(484,22,83,0),(485,23,83,0),(486,24,83,0),(487,25,83,0),(488,26,83,0),(489,27,83,0);
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
INSERT INTO `employee_role` VALUES (1,1),(7,1),(8,2),(14,2),(15,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(2,3),(3,3),(4,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet`
--

LOCK TABLES `meet` WRITE;
/*!40000 ALTER TABLE `meet` DISABLE KEYS */;
INSERT INTO `meet` VALUES (1,1,'2015-07-02 09:00:00'),(2,1,'2015-07-07 10:00:00'),(3,1,'2015-07-09 09:00:00'),(4,1,'2015-07-14 09:00:00'),(5,1,'2015-07-15 09:00:00'),(6,1,'2015-07-21 09:00:00'),(7,1,'2015-07-23 09:00:00'),(8,1,'2015-07-28 12:00:00'),(9,1,'2015-07-30 09:00:00'),(10,1,'2015-08-04 09:00:00'),(11,1,'2015-08-06 09:00:00'),(12,1,'2015-08-11 09:00:00'),(13,1,'2015-08-13 11:00:00'),(14,1,'2015-08-18 09:00:00'),(15,1,'2015-08-20 09:00:00'),(16,1,'2015-08-25 09:00:00'),(17,1,'2015-08-27 09:00:00'),(18,2,'2015-07-08 12:00:00'),(19,3,'2015-09-01 03:00:00'),(20,4,'2015-06-04 09:00:00'),(21,5,'2015-09-07 09:00:00'),(27,14,'2015-07-01 03:10:00'),(28,14,'2015-07-30 11:30:00'),(70,30,'2015-07-31 11:30:00'),(71,31,'2015-09-30 07:30:00'),(72,33,'2015-08-01 06:00:00'),(73,33,'2015-08-02 06:00:00'),(74,33,'2015-08-09 06:00:00'),(75,33,'2015-08-16 06:00:00'),(76,33,'2015-08-23 06:00:00'),(77,33,'2015-08-30 06:00:00'),(78,33,'2015-09-06 06:00:00'),(79,33,'2015-09-13 06:00:00'),(80,33,'2015-09-20 06:00:00'),(81,33,'2015-09-27 06:00:00'),(82,33,'2015-08-03 06:00:00'),(83,33,'2015-08-10 06:00:00'),(84,33,'2015-08-17 06:00:00'),(85,33,'2015-08-24 06:00:00'),(86,33,'2015-08-31 06:00:00'),(87,33,'2015-09-07 06:00:00'),(88,33,'2015-09-14 06:00:00'),(89,33,'2015-09-21 06:00:00'),(90,33,'2015-09-28 06:00:00'),(91,33,'2015-08-04 06:00:00'),(92,33,'2015-08-11 06:00:00'),(93,33,'2015-08-18 06:00:00'),(94,33,'2015-08-25 06:00:00'),(95,33,'2015-09-01 06:00:00'),(96,33,'2015-09-08 06:00:00'),(97,33,'2015-09-15 06:00:00'),(98,33,'2015-09-22 06:00:00'),(99,33,'2015-09-29 06:00:00'),(100,33,'2015-08-05 06:00:00'),(101,33,'2015-08-12 06:00:00'),(102,33,'2015-08-19 06:00:00'),(103,33,'2015-08-26 06:00:00'),(104,33,'2015-09-02 06:00:00'),(105,33,'2015-09-09 06:00:00'),(106,33,'2015-09-16 06:00:00'),(107,33,'2015-09-23 06:00:00'),(108,33,'2015-08-06 06:00:00'),(109,33,'2015-08-13 06:00:00'),(110,33,'2015-08-20 06:00:00'),(111,33,'2015-08-27 06:00:00'),(112,33,'2015-09-03 06:00:00'),(113,33,'2015-09-10 06:00:00'),(114,33,'2015-09-17 06:00:00'),(115,33,'2015-09-24 06:00:00'),(116,33,'2015-08-07 06:00:00'),(117,33,'2015-08-14 06:00:00'),(118,33,'2015-08-21 06:00:00'),(119,33,'2015-08-28 06:00:00'),(120,33,'2015-09-04 06:00:00'),(121,33,'2015-09-11 06:00:00'),(122,33,'2015-09-18 06:00:00'),(123,33,'2015-09-25 06:00:00'),(124,33,'2015-08-08 06:00:00'),(125,33,'2015-08-15 06:00:00'),(126,33,'2015-08-22 06:00:00'),(127,33,'2015-08-29 06:00:00'),(128,33,'2015-09-05 06:00:00'),(129,33,'2015-09-12 06:00:00'),(130,33,'2015-09-19 06:00:00'),(131,33,'2015-09-26 06:00:00'),(132,33,'2015-09-30 06:05:00'),(133,34,'2015-08-01 17:12:00'),(134,45,'2015-08-20 11:50:00'),(135,45,'2015-08-20 11:50:00'),(136,45,'2015-08-20 11:50:00'),(137,46,'2015-08-01 14:53:00'),(140,49,'2015-08-28 11:45:00'),(141,50,'2015-08-22 15:50:00'),(142,51,'2015-08-28 15:30:00'),(147,56,'2015-08-27 11:30:00'),(148,57,'2015-08-13 07:30:00'),(151,60,'2015-08-19 11:50:00'),(152,61,'2015-08-06 07:30:00'),(153,62,'2015-08-14 11:30:00'),(154,63,'2015-08-20 07:50:00'),(155,64,'2015-08-20 11:50:00'),(156,65,'2015-08-28 07:50:00'),(157,66,'2015-08-21 12:50:00'),(158,67,'2015-08-20 11:30:00'),(159,68,'2015-08-28 07:30:00'),(160,69,'2015-08-28 11:45:00'),(161,70,'2015-08-21 11:30:00'),(162,71,'2015-08-28 07:30:00'),(163,72,'2015-08-28 07:45:00'),(164,73,'2015-08-21 12:50:00'),(165,74,'2015-08-28 07:25:00'),(166,75,'2015-08-14 07:30:00'),(167,76,'2015-08-28 11:30:00'),(168,77,'2015-08-28 07:30:00'),(169,78,'2015-08-28 07:30:00'),(170,79,'2015-08-19 11:30:00'),(171,80,'2015-08-28 11:55:00'),(172,81,'2015-08-28 11:50:00'),(173,82,'2015-08-20 07:50:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,1,'gvb','cbgcb','2015-07-31 07:30:58',2,'warning',NULL),(2,2,'fg','fgdfg','2015-07-31 07:30:58',3,'warning',NULL),(3,1,'sdg','sdg','2015-11-08 21:00:00',4,'info',NULL),(4,1,'ef','ef','2015-11-08 21:00:00',2,'info',NULL),(5,1,'sd','sdav','2015-11-08 21:00:00',2,'info',NULL),(6,1,'agf','afeafe','2015-11-08 21:00:00',2,'info',NULL),(7,1,'df','sadf','2015-11-08 21:00:00',3,'info',NULL),(8,1,'adff','asfafs','2015-11-08 21:00:00',5,'info',NULL),(9,1,'dsf','adf','2015-11-08 21:00:00',2,'info',NULL),(10,2,'saf','feewqf','2015-11-08 21:00:00',5,'info',NULL),(11,3,'srgwrhetah','zvsdgs','2015-11-08 21:00:00',6,'info',NULL),(12,3,'time transfer','meet time transfer from 12:00 to 13:00','2015-07-31 08:11:05',4,'warning',NULL),(13,2,'addition successfully completed','you was added to the Core Java training participants list','2015-07-31 08:15:18',5,'success',NULL),(14,14,'feedback','this was awesome training','2015-09-11 21:00:00',1,'info',NULL),(15,1,'addition successfully completed','you was added to the English training participants list','2015-07-31 08:15:18',1,'success',NULL),(16,2,'date transfer','meet date transfer from 2015-10-12 to 2015-10-13','2015-07-31 08:15:18',7,'warning',NULL),(17,3,'addition successfully completed','you was added to the Advanced Java training participants list','2015-10-11 21:00:00',7,'success',NULL),(50,34,'Meet is coming!','Meet of training Schedule test trainingwill be in3 hour','2015-08-01 14:12:00',1,'info',NULL),(53,49,'New training','There is the new training TEST EMAIL in system','2015-08-02 15:20:13',7,'info',NULL),(54,50,'New training','There is the new training rgeret in system','2015-08-02 15:22:15',7,'info',NULL),(55,51,'New training','There is the new training ergrg in system','2015-08-02 15:46:37',7,'info',NULL),(60,56,'New training','There is the new training Test test test in system','2015-08-05 08:58:40',14,'info',NULL),(61,57,'New training','There is the new training efewqfqef in system','2015-08-05 08:59:33',15,'info',NULL),(64,60,'New training','There is the new training TTT in system','2015-08-05 09:11:34',18,'info',NULL),(65,61,'New training','There is the new training Tets test in system','2015-08-05 09:13:26',19,'info',NULL),(66,62,'New training','There is the new training egeqgweg in system','2015-08-05 09:16:31',7,'info',NULL),(67,66,'New training','There is the new training wergwhg in system','2015-08-05 09:23:42',7,'info',NULL),(68,67,'New training','There is the new training sfdhswhrswhrrwh in system','2015-08-05 09:38:36',7,'info',NULL),(69,68,'New training','There is the new training rgWrhbwrHerh in system','2015-08-05 09:47:14',7,'info',NULL),(70,69,'New training','There is the new training sdhsrhg in system','2015-08-05 09:52:09',7,'info',NULL),(71,70,'New training','There is the new training email test in system','2015-08-05 09:56:07',7,'info',NULL),(72,71,'New training','There is the new training email test in system','2015-08-05 09:57:39',7,'info',NULL),(73,72,'New training','There is the new training sbgwesbWRBETRBrb in system','2015-08-05 09:58:25',7,'info',NULL),(74,73,'New training','There is the new training TEEEEEEEEEEES in system','2015-08-05 09:58:47',7,'info',NULL),(75,74,'New training','There is the new training zdvsadbs in system','2015-08-05 10:18:03',20,'info',NULL),(76,75,'New training','There is the new training wegwegwg in system','2015-08-05 10:19:08',21,'info',NULL),(77,76,'New training','There is the new training jyfludtckuydtckyd in system','2015-08-05 10:22:36',22,'info',NULL),(78,77,'New training','There is the new training ktdcujcdfut in system','2015-08-05 10:23:49',23,'info',NULL),(79,78,'New training','There is the new training kyfycdfkhtd in system','2015-08-05 10:25:01',24,'info',NULL),(80,79,'New training','There is the new training sgbsbg in system','2015-08-05 10:45:14',25,'info',NULL),(81,80,'New training','There is the new training segweg in system','2015-08-05 11:15:20',7,'info',NULL),(82,81,'New training','There is the new training wegweg in system','2015-08-05 11:15:51',26,'info',NULL),(83,82,'New training','There is the new training dfzSBF in system','2015-08-05 11:18:14',27,'info',NULL);
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
INSERT INTO `subscribe` VALUES (1,1,1,'Approve','2015-08-01 09:50:43'),(2,2,1,'Approve','2015-07-30 13:24:59'),(3,3,1,'Approve','2015-07-30 13:24:59'),(4,4,1,'Approve','2015-07-30 13:24:59'),(5,5,1,'Approve','2015-07-30 13:24:59'),(6,6,1,'Wait','2015-07-30 13:24:59'),(7,7,1,'Wait','2015-07-30 13:24:59'),(8,9,1,'Wait','2015-07-30 13:24:59'),(9,1,2,'Approve','2015-07-30 13:24:59'),(10,2,2,'Approve','2015-07-30 13:24:59'),(11,3,4,'Approve','2015-07-30 13:24:59'),(12,9,5,'Approve','2015-07-30 13:24:59'),(18,8,2,'Approve','2015-07-30 13:24:59'),(19,7,34,'Approve','2015-08-03 06:29:12');
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
INSERT INTO `token` VALUES (1,'010815122730-540119915',1,'050815102000278181481'),(2,'token',2,NULL),(3,'token',3,NULL),(4,'240715155508-2059738913',4,NULL),(5,'310715151646-2122411317',5,NULL),(6,'token',6,NULL),(7,'0308150926211296953224',7,'060815115657-2088702462'),(8,'2907151047191192705113',8,'050815112626-389596679'),(9,'240715155455295800428',9,NULL);
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
INSERT INTO `trainer_feedback` VALUES (1,2,8,1,'2015-08-05 08:24:34',NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,8,'English','Just English','Just do it','Everybody',0,0,1,12,'203',0),(2,4,'CORE JAVA ','Sun trainings is a best online center in Hyderabad. We are providing very best online training on CORE JAVA.','*  Very in depth course material with real time scenarios.\n*  We are providing class with highly qualified trainer.\n*  We will provide class and demo session at student flexible timings.\n*  In training case studies and real time scenarios covered.\n*  We will give 24*7 technical supports.\n*  Each topic coverage with real time solutions.\n*  We are providing normal track,weekend,fast track classes.\n*  We will give every recorded session for play later.\n*  We are giving placement support by multiple consultancies in INDIA, USA, Australia, UK etc.\n*  We are providing certification oriented trainings with 100% pass guarantee.\n*  We will give full support while attending the interviews and contact me any time after completion of the course.','Medium-level JAVA developers.',0,0,1,10,NULL,0),(3,4,'Advanced Java','Sun trainings is a best online center in Hyderabad. We are providing very best online training on Advanced Java.','*  Very in depth course material with real time scenarios.\n*  We are providing class with highly qualified trainer.\n*  We will provide class and demo session at student flexible timings.\n*  In training case studies and real time scenarios covered.\n*  We will give 24*7 technical supports.\n*  Each topic coverage with real time solutions.\n*  We are providing normal track,weekend,fast track classes.\n*  We will give every recorded session for play later.\n*  We are giving placement support by multiple consultancies in INDIA, USA, Australia, UK etc.\n*  We are providing certification oriented trainings with 100% pass guarantee.\n*  We will give full support while attending the interviews and contact me any time after completion of the course.','Hight-level JAVA developers.',0,0,0,7,NULL,0),(4,2,'ORACLE DBA ','Sun trainings is a best online center in Hyderabad. We are providing very best online training on ORACLE DBA.','Course Name : ORACLE DBA                                                                    24*7 Technical Support\nDuration         : 35 hours\nFaculty            : Realtime experience \n\n           Sun trainings is a best online center in Hyderabad. We are providing very best online training on ORACLE DBA.\n\nHighlights in our training:\n\n*  Very in depth course material with real time scenarios.\n*  We are providing class with highly qualified trainer.\n*  We will provide class and demo session at student flexible timings.\n*  In training case studies and real time scenarios covered.\n*  We will give 24*7 technical supports.\n*  Each topic coverage with real time solutions.\n*  We are providing normal track,weekend,fast track classes.\n*  We will give every recorded session for play later.\n*  We are giving placement support by multiple consultancies in INDIA, USA, Australia, UK etc.\n*  We are providing certification oriented trainings with 100% pass guarantee.\n*  We will give full support while attending the interviews and contact me any time after completion of the course.','Oracle users.',1,0,1,9,NULL,0),(5,3,'MongoDB ','Sun trainings is a best online center in Hyderabad. We are providing very best online training on MongoDB.','*  Very in depth course material with real time scenarios.\n*  We are providing class with highly qualified trainer.\n*  We will provide class and demo session at student flexible timings.\n*  In training case studies and real time scenarios covered.\n*  We will give 24*7 technical supports.\n*  Each topic coverage with real time solutions.\n*  We are providing normal track,weekend,fast track classes.\n*  We will give every recorded session for play later.\n*  We are giving placement support by multiple consultancies in INDIA, USA, Australia, UK etc.\n*  We are providing certification oriented trainings with 100% pass guarantee.\n*  We will give full support while attending the interviews and contact me any time after completion of the course.','DB developers.',0,0,1,10,NULL,0),(14,1,'Normal','Hahaton','Description','228',0,0,0,13,'333',0),(30,1,'test','asdasd','asdasdasd','sadasd',1,1,0,5,'asd',0),(31,1,'TEST TEST','sdgsg','wefwef','wefwef',1,1,0,5,'wefwef',0),(33,1,'TEST TEST TEST','dfef','hjh','iu',1,1,0,56,'kj',0),(34,1,'Schedule test training','test','test','test',0,0,1,1,'1',0),(45,1,'TESTINGG','sdvds','sdfsdf','sdfdsf',1,1,0,4,'sdfs',0),(46,1,'T','erg','wrgwgrw','wgrg',1,1,1,4,'rgwrg',0),(49,7,'TEST EMAIL','ergre','reg','erg',1,1,0,1,'reg',0),(50,7,'rgeret','ege','rec','ecrg',1,1,0,2,'ercgc',0),(51,7,'ergrg','erg','erg','erg',1,1,0,1,'reg',0),(56,14,'Test test test','sdbv','sdvsdv','dsvs',1,1,0,4,'sdv',0),(57,15,'efewqfqef','aegeg','wegweg','weg',1,1,0,4,'weg',0),(60,18,'TTT','ege','wegweg','weg',1,1,0,4,'ewgw',0),(61,19,'Tets test','egfweg','wegweg','wegweg',1,1,0,5,'eg',0),(62,7,'egeqgweg','wegweg','sdeg','wegweg',1,1,0,123,'wegewg',0),(63,7,'ewgwegwg','wegweg','ewgwegweg','wegweg',1,1,0,3,'wegweg',0),(64,7,'wefew','wefwef','ewfwef','ewfwef',1,1,0,4,'wefwef',0),(65,7,'efwef','ewfwef','wefwef','ewfwef',1,1,0,4,'wefwef',0),(66,7,'wergwhg','wegwhg','wegwegwe','wegweg',1,1,0,4,'wegwe',0),(67,7,'sfdhswhrswhrrwh','wehweh','ehewh','wehe',1,1,0,4,'ehhwe',0),(68,7,'rgWrhbwrHerh','aerhareh','aerhreh','earhrhea',1,1,0,5,'aerhrh',0),(69,7,'sdhsrhg','shsh','srhsrh','srhhrs',1,1,0,4,'srhhr',0),(70,7,'email test','egweg','wegweg','wegewg',1,1,0,5,'wegewg',0),(71,7,'email test','efweg','wegweg','wegweg',1,1,0,4,'wegweg',0),(72,7,'sbgwesbWRBETRBrb','argbareg','wrgRWE','rgWRG',1,1,0,5,'srgwrg',0),(73,7,'TEEEEEEEEEEES','SRBHWRHB','wARHH','Wrheh',1,1,0,4,'SEWH',0),(74,20,'zdvsadbs','sdbsdb','sdbsdb','sdbsdb',1,1,0,5,'sdbsdb',0),(75,21,'wegwegwg','wegwgweg','wegweg','wegweg',1,1,0,5,'wegweg',0),(76,22,'jyfludtckuydtckyd','tkhdkytdkyt','jgcdhgc',',jhv,jgc',1,1,0,4,'hktdkydt',0),(77,23,'ktdcujcdfut','j,hfjlycf','gfcmhgdc','jyfujyf',1,1,0,5,'htdkhtd',0),(78,24,'kyfycdfkhtd','dfff','ddfd','fff',1,1,0,5,'ffff',0),(79,25,'sgbsbg','rbwrb','aerbreb','erberb',1,1,0,4,'erbbr',0),(80,7,'segweg','segweg','wegwegweg','wegweg',1,1,0,5,'wegweg',0),(81,26,'wegweg','wegweg','wegweg','wegewg',1,1,0,7,'wegweg',0),(82,27,'dfzSBF','adfbafb','dfabdfb','fdabfdb',1,1,0,5,'dfbdfb',0);
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

-- Dump completed on 2015-08-06 12:28:46
