CREATE DATABASE  IF NOT EXISTS `wplproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wplproject`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: wplproject
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `StreetAddress` varchar(255) DEFAULT NULL,
  `AptNo` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(2) DEFAULT NULL,
  `PostalCode` int(6) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `EmailID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AddressID`),
  KEY `EmalID_idx` (`EmailID`),
  CONSTRAINT `EmalID` FOREIGN KEY (`EmailID`) REFERENCES `user` (`EmailID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `ItemId` int(11) NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(255) DEFAULT NULL,
  `Image` blob,
  `Description` varchar(255) DEFAULT NULL,
  `Price` decimal(19,2) DEFAULT NULL,
  `Quantity` smallint(6) DEFAULT '0',
  PRIMARY KEY (`ItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registry`
--

DROP TABLE IF EXISTS `registry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registry` (
  `RegistryID` int(11) NOT NULL AUTO_INCREMENT,
  `RegistryName` varchar(255) NOT NULL,
  `EventDate` date NOT NULL,
  `Share` tinyint(1) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `url` varchar(45) NOT NULL,
  PRIMARY KEY (`RegistryID`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registry`
--

LOCK TABLES `registry` WRITE;
/*!40000 ALTER TABLE `registry` DISABLE KEYS */;
INSERT INTO `registry` VALUES (3,'asdasdgfcfgcg','2016-12-22',1,'gaurshivan@gmail.com','asdasd1');
/*!40000 ALTER TABLE `registry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registryitem`
--

DROP TABLE IF EXISTS `registryitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registryitem` (
  `url` varchar(255) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`url`,`ItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registryitem`
--

LOCK TABLES `registryitem` WRITE;
/*!40000 ALTER TABLE `registryitem` DISABLE KEYS */;
INSERT INTO `registryitem` VALUES ('registryUrl',1,200),('registryUrl',2,200);
/*!40000 ALTER TABLE `registryitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) NOT NULL,
  `EmailID` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `SecurityQuestion` varchar(255) NOT NULL,
  `SecurityAnswer` varchar(255) NOT NULL,
  PRIMARY KEY (`EmailID`),
  UNIQUE KEY `EmailID` (`EmailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Shivangi','Gaur','gaurshivan@gmail.com','Sherlock','what is birth place','Delhi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userregistry`
--

DROP TABLE IF EXISTS `userregistry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userregistry` (
  `EmailID` varchar(255) DEFAULT NULL,
  `RegistryID` int(11) DEFAULT NULL,
  KEY `FK_userregistry_EmailID` (`EmailID`),
  KEY `FK_userregistry_RegistryID` (`RegistryID`),
  CONSTRAINT `FK_userregistry_EmailID` FOREIGN KEY (`EmailID`) REFERENCES `user` (`EmailID`) ON DELETE NO ACTION,
  CONSTRAINT `FK_userregistry_RegistryID` FOREIGN KEY (`RegistryID`) REFERENCES `registry` (`RegistryID`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userregistry`
--

LOCK TABLES `userregistry` WRITE;
/*!40000 ALTER TABLE `userregistry` DISABLE KEYS */;
/*!40000 ALTER TABLE `userregistry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30  0:37:58
