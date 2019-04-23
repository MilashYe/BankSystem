CREATE DATABASE  IF NOT EXISTS `bankdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bankdb`;
-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: bankdb
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id_ac` int(11) NOT NULL AUTO_INCREMENT,
  `ac_money` int(11) NOT NULL,
  `closed` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_ac`),
  UNIQUE KEY `id_ac_UNIQUE` (`id_ac`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,151900,0),(69,823290,1),(71,39510,0),(77,100000,1),(78,0,1),(79,0,0),(80,13,0),(83,0,0),(84,0,0),(85,0,0),(86,13555578,0),(87,12300,0),(91,99999900,1),(98,222200,0),(99,0,1),(100,0,0),(101,0,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_has_user`
--

DROP TABLE IF EXISTS `account_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_has_user` (
  `account_id_ac` int(11) NOT NULL,
  `user_u_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id_ac`,`user_u_id`),
  KEY `fk_account_has_user_user1_idx` (`user_u_id`),
  KEY `fk_account_has_user_account1_idx` (`account_id_ac`),
  CONSTRAINT `fk_account_has_user_account1` FOREIGN KEY (`account_id_ac`) REFERENCES `account` (`id_ac`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_has_user_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_has_user`
--

LOCK TABLES `account_has_user` WRITE;
/*!40000 ALTER TABLE `account_has_user` DISABLE KEYS */;
INSERT INTO `account_has_user` VALUES (1,1),(69,1),(71,1),(80,1),(1,2),(69,2),(71,2),(77,2),(78,2),(100,2),(101,2),(79,3),(80,3),(69,4),(91,4),(98,4),(99,4),(100,4);
/*!40000 ALTER TABLE `account_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit` (
  `id_cr` int(11) NOT NULL AUTO_INCREMENT,
  `id_ac` int(11) NOT NULL,
  `cred_money` int(11) NOT NULL,
  `cred_percent` int(11) NOT NULL,
  `cred_type` varchar(45) NOT NULL,
  `term_close` int(11) NOT NULL,
  `approved` tinyint(1) NOT NULL,
  `rejected` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_cr`),
  UNIQUE KEY `id_cr_UNIQUE` (`id_cr`),
  KEY `fk_credits_account1_idx` (`id_ac`),
  CONSTRAINT `fk_credits_account1` FOREIGN KEY (`id_ac`) REFERENCES `account` (`id_ac`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--

LOCK TABLES `credit` WRITE;
/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
INSERT INTO `credit` VALUES (16,1,5500000,12,'hypothec',240,0,1),(17,1,66600,4,'credit_card',12,0,1),(18,1,666600,12,'hypothec',240,1,0),(19,71,123400,4,'credit_card',12,1,0),(20,78,66600,4,'credit_card',12,1,0),(21,1,123400,4,'credit_card',12,0,0),(22,91,666600,4,'credit_card',12,0,1),(23,98,12300,4,'credit_card',12,0,0);
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposit` (
  `id_dep` int(11) NOT NULL AUTO_INCREMENT,
  `id_ac` int(11) NOT NULL,
  `dep_money` int(11) NOT NULL,
  `dep_percent` int(11) NOT NULL,
  `dep_type` varchar(45) NOT NULL,
  `received_money` int(11) DEFAULT NULL,
  `start_date` varchar(45) NOT NULL,
  `end_time` int(11) NOT NULL,
  PRIMARY KEY (`id_dep`),
  UNIQUE KEY `id_dep_UNIQUE` (`id_dep`),
  KEY `fk_deposits_account1_idx` (`id_ac`),
  CONSTRAINT `fk_deposits_account1` FOREIGN KEY (`id_ac`) REFERENCES `account` (`id_ac`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit`
--

LOCK TABLES `deposit` WRITE;
/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
INSERT INTO `deposit` VALUES (2,78,123400,14,'standart',0,'2019-04-22 12:37:36',1),(3,1,23400,42,'standart',0,'2019-04-22 12:39:53',1),(5,91,666600,16,'junior',0,'2019-04-22 03:11:41',12),(6,98,234500,45,'standart',0,'2019-04-22 03:18:09',1),(8,98,666600,31,'standart',0,'2019-04-22 03:20:23',1);
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id_time` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `account_id_ac` int(11) NOT NULL,
  `mess` varchar(500) DEFAULT '',
  PRIMARY KEY (`id_time`),
  KEY `fk_time_account1_idx` (`account_id_ac`),
  CONSTRAINT `fk_time_account1` FOREIGN KEY (`account_id_ac`) REFERENCES `account` (`id_ac`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=295 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (214,'2019-04-17 22:09:03',78,'Credit 20 was created'),(215,'2019-04-17 22:12:31',85,'Account 85 was created'),(216,'2019-04-17 22:13:38',78,'Credit 20 was approved'),(217,'2019-04-18 08:44:52',69,'Money(10) were sent to 71 account'),(218,'2019-04-18 08:44:52',71,'Money(10) were get from 69 account'),(219,'2019-04-18 08:44:52',69,'Account money were updated, balance is 8109'),(220,'2019-04-18 08:44:52',71,'Account money were updated, balance is 395'),(221,'2019-04-18 08:45:21',1,'Money(123) were sent to 69 account'),(222,'2019-04-18 08:45:21',69,'Money(123) were get from 1 account'),(223,'2019-04-18 08:45:21',1,'Account money were updated, balance is 1542'),(224,'2019-04-18 08:45:21',69,'Account money were updated, balance is 8232'),(225,'2019-04-18 08:52:28',1,'Credit 16 was approved'),(228,'2019-04-20 22:00:05',1,'Account money were updated, balance is 1542'),(229,'2019-04-20 22:00:06',69,'Account money were updated, balance is 8232'),(230,'2019-04-20 22:00:07',71,'Account money were updated, balance is 395'),(231,'2019-04-20 22:00:07',85,'Account money were updated, balance is 0'),(232,'2019-04-20 22:00:07',86,'Account 86 was created'),(233,'2019-04-20 22:00:22',87,'Account 87 was created'),(234,'2019-04-21 18:44:09',86,'Deposit 1 was created'),(235,'2019-04-21 19:10:51',86,'Money(123) were sent to 12345679 bill'),(236,'2019-04-21 19:10:51',86,'Account money were updated, balance is 123333'),(237,'2019-04-21 19:11:58',86,'Money(123) were sent to 87 account'),(238,'2019-04-21 19:11:58',87,'Money(123) were get from 86 account'),(239,'2019-04-21 19:11:58',86,'Account money were updated, balance is 123210'),(240,'2019-04-21 19:11:58',87,'Account money were updated, balance is 123'),(241,'2019-04-21 19:26:02',87,'Account money were updated, balance is 123'),(242,'2019-04-21 19:43:26',87,'Account money were updated, balance is 123'),(243,'2019-04-21 19:43:45',87,'Account money were updated, balance is 123'),(244,'2019-04-22 12:02:05',1,'Credit 18 was approved'),(245,'2019-04-22 12:04:30',1,'Credit 16 was rejected'),(250,'2019-04-22 12:14:55',86,'Account money were updated, balance is 135555'),(251,'2019-04-22 12:14:55',86,'Deposit 1 was deleted'),(253,'2019-04-22 12:30:35',77,'Account money were updated, balance is 1000'),(254,'2019-04-22 12:30:37',78,'Account money were updated, balance is 0'),(256,'2019-04-22 12:37:36',78,'Deposit 2 was created'),(257,'2019-04-22 12:39:53',1,'Deposit 3 was created'),(258,'2019-04-22 12:40:49',1,'Credit 21 was created'),(259,'2019-04-22 14:49:45',91,'Account 91 was created'),(263,'2019-04-22 14:58:25',91,'Deposit 4 was created'),(264,'2019-04-22 14:58:37',91,'Account money were updated, balance is 999999'),(265,'2019-04-22 14:58:37',91,'Deposit 4 was deleted'),(273,'2019-04-22 15:09:28',91,'Credit 22 was created'),(274,'2019-04-22 15:10:16',91,'Credit 22 was approved'),(275,'2019-04-22 15:10:59',91,'Credit 22 was rejected'),(276,'2019-04-22 15:11:41',91,'Deposit 5 was created'),(277,'2019-04-22 15:12:20',91,'Account money were updated, balance is 999999'),(278,'2019-04-22 15:12:28',69,'Account money were updated, balance is 8232'),(279,'2019-04-22 15:12:31',98,'Account 98 was created'),(280,'2019-04-22 15:13:20',99,'Account 99 was created'),(281,'2019-04-22 15:13:43',99,'Account money were updated, balance is 0'),(282,'2019-04-22 15:16:05',100,'Account 100 was created'),(283,'2019-04-22 15:18:09',98,'Deposit 6 was created'),(284,'2019-04-22 15:18:17',98,'Deposit 7 was created'),(285,'2019-04-22 15:20:23',98,'Deposit 8 was created'),(286,'2019-04-22 15:20:31',98,'Account money were updated, balance is 2345'),(287,'2019-04-22 15:20:31',98,'Deposit 7 was deleted'),(288,'2019-04-22 15:22:04',98,'Credit 23 was created'),(289,'2019-04-22 15:22:21',98,'Money(123) were sent to 1234 bill'),(290,'2019-04-22 15:22:21',98,'Account money were updated, balance is 2222'),(291,'2019-04-22 17:14:51',1,'Money(23) were sent to 1231 bill'),(292,'2019-04-22 17:14:51',1,'Account money were updated, balance is 1519'),(293,'2019-04-22 18:22:23',101,'Account 101 was created'),(294,'2019-04-22 18:22:25',101,'Account money were updated, balance is 0');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `login` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `pwdhash` varchar(150) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `id_u_UNIQUE` (`login`),
  UNIQUE KEY `user_u_id_uindex` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin','$2a$10$qUnlHIUmR6yQjJ1V8AE/U.GDDssVPOmfxaCXwkZy8QIOkPiF.on96','Yevhenii','Milash','+380678865467',1),('user1','user','$2a$04$qz.QTlPE8cpFBUNi2pC3peiunDki/YDMJbbyggt231b/ssJsswcZi','Genya','Totoro','+380466616364',2),('ololoev','user','$2a$04$BaKqXGZQpxM7mm0wbs1xZO3foLLYGvgDumrzcLekXmqsu6mvTO8J2','Vasya','Petrov','+380999911784',3),('gg','user','$2a$04$jiBrzftUh9bN6ZurjFdQ1uulh3RtnIZH9Q76HmyIUscIcWVypMA4S','Bohdan','Milashevskyi','+380681122334',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 17:29:49
