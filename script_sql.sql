-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pianobar
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varbinary(255) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `senha` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,_binary ':∂àV\◊Vz\ÓK^û˚|4p\Â','Davi Regis',_binary '!lê\ﬂ\Áı¨¨\Ê\À˝={='),(2,_binary '¡n¥\Ès,o\¬€ä§\⁄%2','Fulano da Silva',_binary 'ht\Ìo©cáùÛ\Ã-eC˝¡©');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_seq`
--

DROP TABLE IF EXISTS `login_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_seq`
--

LOCK TABLES `login_seq` WRITE;
/*!40000 ALTER TABLE `login_seq` DISABLE KEYS */;
INSERT INTO `login_seq` VALUES (1);
/*!40000 ALTER TABLE `login_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mesa` int NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (2,'111.111.111-11',NULL,'savana@gmail.com',1,'Savana',NULL),(3,'111.111.111-11',NULL,'savana@gmail.com',1,'Savana',NULL),(4,'050.733.729-80','2023-11-30','daviremzetti@gmail.com',1,'Davi',NULL),(5,'050.733.729-80','2023-11-30','daviremzetti@gmail.com',1,'Davi',NULL),(6,'050.733.729-80','2023-11-30','daviremzetti@gmail.com',2,'Davi',NULL),(7,'222.222.222-22','2023-11-30','jam@gmail.com',20,'Jamaica',NULL),(8,'333.333.333-33','2023-11-30','feliz@gmail.com',3,'Felizberto',NULL),(9,'222.670.880-45','2023-12-01','jem@gmail.com',18,'Jeremias',NULL),(10,'050.733.729-80','2023-12-03','daviremzetti@gmail.com',20,'Davi Barbi Remzetti Regis',NULL),(11,'054.660.190-11','2023-12-08','bela_flor@gmail.com',24,'Florisbela',NULL),(12,'997.082.760-06','2023-12-08','beca_taylor@gmail.com',22,'Rebeca Taylor',NULL),(13,'450.128.110-38','2023-12-09','betafernandes@gmail.com',16,'Adalberta Fernandes',NULL),(14,'222.670.880-45','2023-12-20','jem@gmail.com',16,'Jeremias',NULL),(15,'114.052.840-80','2023-12-20','elias@gmail.com',1,'Elias',NULL),(16,'718.984.670-05','2023-12-21','betafernandes@gmail.com',1,'Roberta Fernandes',NULL);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23  0:28:36
