-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: setgame
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardId` int(11) NOT NULL AUTO_INCREMENT,
  `ImageUrl` varchar(45) DEFAULT NULL,
  `Shape` varchar(45) DEFAULT NULL,
  `Shade` varchar(45) DEFAULT NULL,
  `Colour` varchar(45) DEFAULT NULL,
  `Number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CardId`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'cards/01.gif','squiggle','solid','red','one'),(2,'cards/02.gif','squiggle','solid','red','two'),(3,'cards/03.gif','squiggle','solid','red','three'),(4,'cards/04.gif','squiggle','solid','purple','one'),(5,'cards/05.gif','squiggle','solid','purple','two'),(6,'cards/06.gif','squiggle','solid','purple','three'),(7,'cards/07.gif','squiggle','solid','green','one'),(8,'cards/08.gif','squiggle','solid','green','two'),(9,'cards/09.gif','squiggle','solid','green','three'),(10,'cards/10.gif','diamond','solid','red','one'),(11,'cards/11.gif','diamond','solid','red','two'),(12,'cards/12.gif','diamond','solid','red','three'),(13,'cards/13.gif','diamond','solid','purple','one'),(14,'cards/14.gif','diamond','solid','purple','two'),(15,'cards/15.gif','diamond','solid','purple','three'),(17,'cards/16.gif','diamond','solid','green','one'),(18,'cards/17.gif','diamond','solid','green','two'),(19,'cards/18.gif','diamond','solid','green','three'),(20,'cards/19.gif','oval','solid','red','one'),(21,'cards/20.gif','oval','solid','red','two'),(22,'cards/21.gif','oval','solid','red','three'),(23,'cards/22.gif','oval','solid','purple','one'),(24,'cards/23.gif','oval','solid','purple','two'),(25,'cards/24.gif','oval','solid','purple','three'),(26,'cards/25.gif','oval','solid','green','one'),(27,'cards/26.gif','oval','solid','green','two'),(28,'cards/27.gif','oval','solid','green','three'),(29,'cards/28.gif','squiggle','striped','red','one'),(30,'cards/29.gif','squiggle','striped','red','two'),(31,'cards/30.gif','squiggle','striped','red','three'),(32,'cards/31.gif','squiggle','striped','purple','one'),(33,'cards/32.gif','squiggle','striped','purple','two'),(34,'cards/33.gif','squiggle','striped','purple','three'),(35,'cards/34.gif','squiggle','striped','green','one'),(36,'cards/35.gif','squiggle','striped','green','two'),(37,'cards/36.gif','squiggle','striped','green','three'),(38,'cards/37.gif','diamond','striped','red','one'),(39,'cards/38.gif','diamond','striped','red','two'),(40,'cards/39.gif','diamond','striped','red','three'),(41,'cards/40.gif','diamond','striped','purple','one'),(42,'cards/41.gif','diamond','striped','purple','two'),(43,'cards/42.gif','diamond','striped','purple','three'),(44,'cards/43.gif','diamond','striped','green','one'),(45,'cards/44.gif','diamond','striped','green','two'),(46,'cards/45.gif','diamond','striped','green','three'),(47,'cards/46.gif','oval','striped','red','one'),(48,'cards/47.gif','oval','striped','red','two'),(49,'cards/48.gif','oval','striped','red','three'),(50,'cards/49.gif','oval','striped','purple','one'),(51,'cards/50.gif','oval','striped','purple','two'),(52,'cards/51.gif','oval','striped','purple','three'),(53,'cards/52.gif','oval','striped','green','one'),(54,'cards/53.gif','oval','striped','green','two'),(55,'cards/54.gif','oval','striped','green','three'),(56,'cards/55.gif','squiggle','outlined','red','one'),(57,'cards/56.gif','squiggle','outlined','red','two'),(58,'cards/57.gif','squiggle','outlined','red','three'),(59,'cards/58.gif','squiggle','outlined','purple','one'),(60,'cards/59.gif','squiggle','outlined','purple','two'),(61,'cards/60.gif','squiggle','outlined','purple','three'),(62,'cards/61.gif','squiggle','outlined','green','one'),(63,'cards/62.gif','squiggle','outlined','green','two'),(64,'cards/63.gif','squiggle','outlined','green','three'),(65,'cards/64.gif','diamond','outlined','red','one'),(66,'cards/65.gif','diamond','outlined','red','two'),(67,'cards/66.gif','diamond','outlined','red','three'),(68,'cards/67.gif','diamond','outlined','purple','one'),(69,'cards/68.gif','diamond','outlined','purple','two'),(70,'cards/69.gif','diamond','outlined','purple','three'),(71,'cards/70.gif','diamond','outlined','green','one'),(72,'cards/71.gif','diamond','outlined','green','two'),(73,'cards/72.gif','diamond','outlined','green','three'),(101,'cards/73.gif','oval','outlined','red','one'),(102,'cards/74.gif','oval','outlined','red','two'),(103,'cards/75.gif','oval','outlined','red','three'),(104,'cards/76.gif','oval','outlined','purple','one'),(105,'cards/77.gif','oval','outlined','purple','two'),(106,'cards/78.gif','oval','outlined','purple','three'),(107,'cards/79.gif','oval','outlined','green','one'),(108,'cards/80.gif','oval','outlined','green','two'),(109,'cards/81.gif','oval','outlined','green','three');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-13  5:17:52
