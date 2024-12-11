-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: planner
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `planner`
--

DROP TABLE IF EXISTS `planner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planner` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '식별자',
  `plans` text COMMENT '일정',
  `name` varchar(32) NOT NULL COMMENT '이름',
  `password` varchar(64) NOT NULL COMMENT '비밀번호',
  `date` datetime DEFAULT NULL COMMENT '작성일',
  `revision_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planner`
--

LOCK TABLES `planner` WRITE;
/*!40000 ALTER TABLE `planner` DISABLE KEYS */;
INSERT INTO `planner` VALUES (3,'두번째 일정','j2j','h3','2024-12-09 19:26:24','2024-12-09 19:26:24'),(4,'두번째 일정','j2j','hahaha','2024-12-09 20:06:29','2024-12-09 20:06:29'),(5,'모르겠다 일정','ㅜㅜ','유유유','2024-12-09 20:14:10','2024-12-09 20:14:10'),(6,'모르겠다 일정','ㅜㅜ','유유유','2024-12-09 20:18:57','2024-12-09 20:18:57'),(7,'모르겠다 일정','ㅜㅜ','유유유','2024-12-09 20:23:46','2024-12-09 20:23:46'),(8,'8번째','ㅜㅜ','유유유','2024-12-09 21:46:35','2024-12-09 21:46:35');
/*!40000 ALTER TABLE `planner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 16:29:03
