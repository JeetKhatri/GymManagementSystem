-- MySQL dump 10.13  Distrib 5.5.24, for Win32 (x86)
--
-- Host: localhost    Database: fitnessplus
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `activityId` int(3) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(15) NOT NULL,
  PRIMARY KEY (`activityId`),
  UNIQUE KEY `activityName` (`activityName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (2,'Pranayam'),(1,'Yoga');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` int(3) NOT NULL AUTO_INCREMENT,
  `areaId` int(3) DEFAULT NULL,
  `cityId` int(3) DEFAULT NULL,
  `adminFirstName` varchar(15) NOT NULL,
  `adminLastName` varchar(15) NOT NULL,
  `adminEmail` varchar(50) NOT NULL,
  `adminGender` varchar(6) NOT NULL,
  `adminDOB` date NOT NULL,
  `adminAddress` varchar(255) NOT NULL,
  `adminPhoneNo` varchar(15) NOT NULL,
  `adminPassWord` varchar(25) NOT NULL,
  `adminIsActive` int(1) NOT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `adminEmail` (`adminEmail`),
  UNIQUE KEY `adminPhoneNo` (`adminPhoneNo`),
  KEY `areaId` (`areaId`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`),
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,1,1,'Jeet','Khatri','jeet@gmail.com','male','1995-10-30','Vasna','8469007271','root',1),(2,3,1,'Avnish','Thakkar','avnish@gmail.com','male','1995-10-14','Ghodasar','7817830246','root',1),(3,1,1,'Sharvil','Shah','sharvil@gmail.com','male','1996-08-28','Dharnidhar','9510363605','root',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `areaId` int(3) NOT NULL AUTO_INCREMENT,
  `areaName` varchar(50) DEFAULT NULL,
  `areaPincode` int(7) NOT NULL,
  `cityId` int(3) DEFAULT NULL,
  PRIMARY KEY (`areaId`),
  UNIQUE KEY `areaPincode` (`areaPincode`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `area_ibfk_1` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Vasna',380001,1),(2,'Nehrunagar',380003,1),(3,'Ghodasar',380050,1),(4,'Maninagr',380008,1),(5,'Varacha Road',395006,2),(6,'Kamrej',394180,2),(7,'Timba',394330,2),(8,'Rupan',394160,2),(9,'KareliBaug',390018,3),(10,'Mandva',391105,3),(11,'Nada',391210,3),(12,'Daroli',391130,3),(13,'Millpara',360001,4),(14,'Patanva',360430,4),(15,'Nani Bazar',363641,4),(16,'Jetpur',360370,4),(17,'Kalol',382721,5),(18,'Mansa',382845,5),(19,'Pethapur',382610,5),(20,'Zundal',382421,5);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `cityId` int(3) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(25) NOT NULL,
  PRIMARY KEY (`cityId`),
  UNIQUE KEY `cityName` (`cityName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Ahmedabad'),(5,'Gandhinagar'),(4,'Rajkot'),(2,'Surat'),(3,'Vadodra');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedbackId` int(3) NOT NULL AUTO_INCREMENT,
  `feedbackDateTime` datetime NOT NULL,
  `feedbackSubjectId` int(3) DEFAULT NULL,
  `name` varchar(15) NOT NULL,
  `emailId` varchar(30) NOT NULL,
  `feedbackContent` varchar(255) NOT NULL,
  PRIMARY KEY (`feedbackId`),
  KEY `feedbackSubjectId` (`feedbackSubjectId`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`feedbackSubjectId`) REFERENCES `feedbacksubject` (`feedbackSubjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'2015-11-03 05:15:38',4,'Sharvil Shah','sharvil@gmail.com','How can we contect you???\r\nReply sooon....'),(2,'2015-11-03 05:16:53',1,'Avnish','avnish@gmail.com','Can you improve tredmil..?\r\n\r\nContact Soonnn.....');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbacksubject`
--

DROP TABLE IF EXISTS `feedbacksubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedbacksubject` (
  `feedbackSubjectId` int(3) NOT NULL AUTO_INCREMENT,
  `feedbackSubjectName` varchar(30) NOT NULL,
  PRIMARY KEY (`feedbackSubjectId`),
  UNIQUE KEY `feedbackSubjectName` (`feedbackSubjectName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbacksubject`
--

LOCK TABLES `feedbacksubject` WRITE;
/*!40000 ALTER TABLE `feedbacksubject` DISABLE KEYS */;
INSERT INTO `feedbacksubject` VALUES (4,'Other...'),(2,'Problem...'),(1,'Question For Feature'),(3,'Suggetion');
/*!40000 ALTER TABLE `feedbacksubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gymdetails`
--

DROP TABLE IF EXISTS `gymdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gymdetails` (
  `gymId` int(3) NOT NULL AUTO_INCREMENT,
  `areaId` int(3) DEFAULT NULL,
  `cityId` int(3) DEFAULT NULL,
  `gymAddress` varchar(255) NOT NULL,
  `gymPhoneNo` varchar(15) NOT NULL,
  `gymPincode` int(7) NOT NULL,
  PRIMARY KEY (`gymId`),
  UNIQUE KEY `gymAddress` (`gymAddress`),
  UNIQUE KEY `gymPhoneNo` (`gymPhoneNo`),
  UNIQUE KEY `gymPincode` (`gymPincode`),
  KEY `areaId` (`areaId`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `gymdetails_ibfk_1` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`),
  CONSTRAINT `gymdetails_ibfk_2` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gymdetails`
--

LOCK TABLES `gymdetails` WRITE;
/*!40000 ALTER TABLE `gymdetails` DISABLE KEYS */;
INSERT INTO `gymdetails` VALUES (2,1,1,'2 , Prerna Darshan Flat\r\nNr R C Patel School\r\n','9510363605',380007),(3,3,1,'aA-22 Ashok Tenament \r\nOpp,Cadila Lab.\r\nHello','7817830246',380050);
/*!40000 ALTER TABLE `gymdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `memberId` int(3) NOT NULL AUTO_INCREMENT,
  `packageId` int(3) DEFAULT NULL,
  `areaId` int(3) DEFAULT NULL,
  `cityId` int(3) DEFAULT NULL,
  `memberFirstName` varchar(15) NOT NULL,
  `memberLastName` varchar(15) NOT NULL,
  `memberEmail` varchar(50) DEFAULT NULL,
  `memberGender` varchar(6) NOT NULL,
  `memberDOB` date NOT NULL,
  `memberAddress` varchar(255) DEFAULT NULL,
  `memberPhoneNo` varchar(15) NOT NULL,
  `memberPassWord` varchar(25) NOT NULL,
  `memberIsActive` int(1) NOT NULL,
  `memberTypeId` int(3) DEFAULT NULL,
  PRIMARY KEY (`memberId`),
  UNIQUE KEY `memberEmail` (`memberEmail`),
  KEY `packageId` (`packageId`),
  KEY `areaId` (`areaId`),
  KEY `cityId` (`cityId`),
  KEY `memberTypeId` (`memberTypeId`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`packageId`) REFERENCES `package` (`packageId`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`),
  CONSTRAINT `member_ibfk_3` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`),
  CONSTRAINT `member_ibfk_4` FOREIGN KEY (`memberTypeId`) REFERENCES `membertype` (`memberTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,1,1,1,'Sharvil','Shah','sharvil@gmail.com','male','2015-10-25','2 Prerna Darshan Flat\r\nNr R C Patel','9510363605','shavil!123',1,1),(2,9,10,3,'Harsh','Raval','hr@gmail.com','male','2015-10-02','2 Prerna Darshan Flat\r\nNr R C Patel','987654321','harsh',1,2);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberprogress`
--

DROP TABLE IF EXISTS `memberprogress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberprogress` (
  `progressId` int(3) NOT NULL AUTO_INCREMENT,
  `memberId` int(3) DEFAULT NULL,
  PRIMARY KEY (`progressId`),
  KEY `memberId` (`memberId`),
  CONSTRAINT `memberprogress_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `member` (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberprogress`
--

LOCK TABLES `memberprogress` WRITE;
/*!40000 ALTER TABLE `memberprogress` DISABLE KEYS */;
INSERT INTO `memberprogress` VALUES (1,1),(3,1),(6,1),(8,1),(2,2),(4,2),(5,2),(7,2),(9,2);
/*!40000 ALTER TABLE `memberprogress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberprogressdetails`
--

DROP TABLE IF EXISTS `memberprogressdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberprogressdetails` (
  `progressDetailId` int(3) NOT NULL AUTO_INCREMENT,
  `progressId` int(3) DEFAULT NULL,
  `height` double(10,2) NOT NULL,
  `weight` double(10,2) NOT NULL,
  `bmi` double(10,2) NOT NULL,
  `biceps` double(10,2) NOT NULL,
  `hips` double(10,2) NOT NULL,
  `thigh` double(10,2) NOT NULL,
  `neck` double(10,2) NOT NULL,
  `forearms` double(10,2) NOT NULL,
  `chest` double(10,2) NOT NULL,
  `calves` double(10,2) NOT NULL,
  `bodyfat` double(10,2) NOT NULL,
  `waist` double(10,2) NOT NULL,
  `progressDateTime` varchar(20) NOT NULL,
  PRIMARY KEY (`progressDetailId`),
  KEY `progressId` (`progressId`),
  CONSTRAINT `memberprogressdetails_ibfk_1` FOREIGN KEY (`progressId`) REFERENCES `memberprogress` (`progressId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberprogressdetails`
--

LOCK TABLES `memberprogressdetails` WRITE;
/*!40000 ALTER TABLE `memberprogressdetails` DISABLE KEYS */;
INSERT INTO `memberprogressdetails` VALUES (2,2,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,'2015-April'),(3,3,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,22.00,2.00,2.00,2.00,'2015-April'),(4,4,3.00,3.00,3.00,3.00,3.00,3.00,3.00,33.00,3.00,3.00,3.00,3.00,'2016-April'),(5,5,3.00,3.00,3.00,6.00,6.00,5.00,10.00,5.00,6.00,6.00,6.00,6.00,'2015-June'),(6,6,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,'2015-July'),(7,8,66.00,6.00,6.00,6.00,3.00,5.00,9.00,4.00,5.00,8.00,100.00,23.00,'2015-June'),(8,9,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,'2014-Jan');
/*!40000 ALTER TABLE `memberprogressdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberschedule`
--

DROP TABLE IF EXISTS `memberschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberschedule` (
  `memberScheduleId` int(3) NOT NULL AUTO_INCREMENT,
  `memberId` int(3) DEFAULT NULL,
  PRIMARY KEY (`memberScheduleId`),
  KEY `memberId` (`memberId`),
  CONSTRAINT `memberschedule_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `member` (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberschedule`
--

LOCK TABLES `memberschedule` WRITE;
/*!40000 ALTER TABLE `memberschedule` DISABLE KEYS */;
INSERT INTO `memberschedule` VALUES (2,1),(3,1),(4,1),(5,1),(1,2);
/*!40000 ALTER TABLE `memberschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberscheduledetails`
--

DROP TABLE IF EXISTS `memberscheduledetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberscheduledetails` (
  `memberScheduleDetailsId` int(3) NOT NULL AUTO_INCREMENT,
  `memberScheduleId` int(3) DEFAULT NULL,
  `memberActivityId` int(3) DEFAULT NULL,
  `memberStartTime` varchar(10) NOT NULL,
  `memberEndTime` varchar(10) NOT NULL,
  `memberDay` varchar(10) NOT NULL,
  PRIMARY KEY (`memberScheduleDetailsId`),
  UNIQUE KEY `memberDay` (`memberDay`),
  KEY `memberScheduleId` (`memberScheduleId`),
  KEY `memberActivityId` (`memberActivityId`),
  CONSTRAINT `memberscheduledetails_ibfk_1` FOREIGN KEY (`memberScheduleId`) REFERENCES `memberschedule` (`memberScheduleId`),
  CONSTRAINT `memberscheduledetails_ibfk_2` FOREIGN KEY (`memberActivityId`) REFERENCES `activity` (`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberscheduledetails`
--

LOCK TABLES `memberscheduledetails` WRITE;
/*!40000 ALTER TABLE `memberscheduledetails` DISABLE KEYS */;
INSERT INTO `memberscheduledetails` VALUES (1,1,1,'5','10','Sunday'),(2,2,2,'6','12','Tuesday'),(3,3,2,'1','2','XYZ'),(4,5,2,'1','5','WednesDay');
/*!40000 ALTER TABLE `memberscheduledetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membertype`
--

DROP TABLE IF EXISTS `membertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membertype` (
  `memberTypeId` int(3) NOT NULL AUTO_INCREMENT,
  `memberTypeName` varchar(10) NOT NULL,
  PRIMARY KEY (`memberTypeId`),
  UNIQUE KEY `memberTypeName` (`memberTypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membertype`
--

LOCK TABLES `membertype` WRITE;
/*!40000 ALTER TABLE `membertype` DISABLE KEYS */;
INSERT INTO `membertype` VALUES (2,'Group'),(1,'Personnal');
/*!40000 ALTER TABLE `membertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package` (
  `packageId` int(3) NOT NULL AUTO_INCREMENT,
  `packageName` varchar(15) NOT NULL,
  PRIMARY KEY (`packageId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (1,'Silver'),(3,'Silver'),(4,'Silver'),(5,'Silver'),(6,'Golden'),(7,'Platinum'),(8,'Golden'),(9,'Golden'),(10,'Platinum'),(11,'Platinum'),(12,'Platinum'),(13,'abc'),(14,'Diamond'),(15,'Diamond');
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packagedetails`
--

DROP TABLE IF EXISTS `packagedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packagedetails` (
  `packageDetailsId` int(3) NOT NULL AUTO_INCREMENT,
  `packageDurationId` int(3) DEFAULT NULL,
  `packageRate` int(5) NOT NULL,
  `packageId` int(3) DEFAULT NULL,
  PRIMARY KEY (`packageDetailsId`),
  KEY `packageId` (`packageId`),
  KEY `packageDurationId` (`packageDurationId`),
  CONSTRAINT `packagedetails_ibfk_1` FOREIGN KEY (`packageId`) REFERENCES `package` (`packageId`),
  CONSTRAINT `packagedetails_ibfk_2` FOREIGN KEY (`packageDurationId`) REFERENCES `packageduration` (`packageDurationId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packagedetails`
--

LOCK TABLES `packagedetails` WRITE;
/*!40000 ALTER TABLE `packagedetails` DISABLE KEYS */;
INSERT INTO `packagedetails` VALUES (1,1,1000,1),(3,2,1500,3),(4,4,2000,4),(5,3,2500,5),(6,2,2000,6),(7,1,1500,7),(8,4,2000,8),(9,3,2200,9),(10,2,2000,10),(11,4,2500,11),(12,3,3000,12),(13,2,1550,NULL),(14,3,5000,NULL),(15,1,1500,15);
/*!40000 ALTER TABLE `packagedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packageduration`
--

DROP TABLE IF EXISTS `packageduration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packageduration` (
  `packageDurationId` int(3) NOT NULL AUTO_INCREMENT,
  `packageDurationTime` varchar(15) NOT NULL,
  PRIMARY KEY (`packageDurationId`),
  UNIQUE KEY `packageDurationTime` (`packageDurationTime`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packageduration`
--

LOCK TABLES `packageduration` WRITE;
/*!40000 ALTER TABLE `packageduration` DISABLE KEYS */;
INSERT INTO `packageduration` VALUES (3,'12 Month'),(1,'3 Month'),(2,'6 Month'),(4,'9 Month');
/*!40000 ALTER TABLE `packageduration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer` (
  `trainerId` int(3) NOT NULL AUTO_INCREMENT,
  `areaId` int(3) DEFAULT NULL,
  `cityId` int(3) DEFAULT NULL,
  `trainerFirstName` varchar(15) NOT NULL,
  `trainerLastName` varchar(15) NOT NULL,
  `trainerEmail` varchar(50) DEFAULT NULL,
  `trainerGender` varchar(6) NOT NULL,
  `trainerDOB` date NOT NULL,
  `trainerAddress` varchar(255) DEFAULT NULL,
  `trainerPhoneNo` varchar(15) NOT NULL,
  `trainerPassWord` varchar(25) NOT NULL,
  `trainerIsActive` int(1) NOT NULL,
  `trainerExperience` varchar(20) NOT NULL,
  PRIMARY KEY (`trainerId`),
  UNIQUE KEY `trainerEmail` (`trainerEmail`),
  KEY `areaId` (`areaId`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `trainer_ibfk_1` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`),
  CONSTRAINT `trainer_ibfk_2` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (1,1,1,'Sharvil','Shah','sharvil@gmail.com','Female','2015-11-11','2, Prerna Darshan Flat\r\nNr R C Patel school','9510363605','sharvil!123',1,'5');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainerschedule`
--

DROP TABLE IF EXISTS `trainerschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainerschedule` (
  `trainerScheduleId` int(3) NOT NULL AUTO_INCREMENT,
  `trainerId` int(3) DEFAULT NULL,
  PRIMARY KEY (`trainerScheduleId`),
  KEY `trainerId` (`trainerId`),
  CONSTRAINT `trainerschedule_ibfk_1` FOREIGN KEY (`trainerId`) REFERENCES `trainer` (`trainerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainerschedule`
--

LOCK TABLES `trainerschedule` WRITE;
/*!40000 ALTER TABLE `trainerschedule` DISABLE KEYS */;
INSERT INTO `trainerschedule` VALUES (1,1);
/*!40000 ALTER TABLE `trainerschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainerscheduledetails`
--

DROP TABLE IF EXISTS `trainerscheduledetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainerscheduledetails` (
  `trainerScheduleDetailsId` int(3) NOT NULL AUTO_INCREMENT,
  `trainerScheduleId` int(3) DEFAULT NULL,
  `trainerActivityId` int(3) DEFAULT NULL,
  `trainerStartTime` varchar(10) NOT NULL,
  `trainerEndTime` varchar(10) NOT NULL,
  `trainerDay` varchar(10) NOT NULL,
  PRIMARY KEY (`trainerScheduleDetailsId`),
  UNIQUE KEY `trainerDay` (`trainerDay`),
  KEY `trainerScheduleId` (`trainerScheduleId`),
  KEY `trainerActivityId` (`trainerActivityId`),
  CONSTRAINT `trainerscheduledetails_ibfk_1` FOREIGN KEY (`trainerScheduleId`) REFERENCES `trainerschedule` (`trainerScheduleId`),
  CONSTRAINT `trainerscheduledetails_ibfk_2` FOREIGN KEY (`trainerActivityId`) REFERENCES `activity` (`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainerscheduledetails`
--

LOCK TABLES `trainerscheduledetails` WRITE;
/*!40000 ALTER TABLE `trainerscheduledetails` DISABLE KEYS */;
INSERT INTO `trainerscheduledetails` VALUES (1,1,1,'1','2','TuesDay');
/*!40000 ALTER TABLE `trainerscheduledetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinquiry`
--

DROP TABLE IF EXISTS `userinquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinquiry` (
  `inquiryId` int(3) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phoneNo` varchar(15) NOT NULL,
  `inquiryMassage` varchar(255) NOT NULL,
  `isAttendedBy` int(3) DEFAULT NULL,
  `inquiryDate` datetime NOT NULL,
  PRIMARY KEY (`inquiryId`),
  KEY `isAttendedBy` (`isAttendedBy`),
  CONSTRAINT `userinquiry_ibfk_1` FOREIGN KEY (`isAttendedBy`) REFERENCES `admin` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinquiry`
--

LOCK TABLES `userinquiry` WRITE;
/*!40000 ALTER TABLE `userinquiry` DISABLE KEYS */;
/*!40000 ALTER TABLE `userinquiry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-07 14:17:28
