-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: j10a302.p.ssafy.io    Database: aimaker
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `age`
--

DROP TABLE IF EXISTS `age`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `age` (
  `age` int NOT NULL,
  `age_id` int NOT NULL AUTO_INCREMENT,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`age_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `age`
--

LOCK TABLES `age` WRITE;
/*!40000 ALTER TABLE `age` DISABLE KEYS */;
INSERT INTO `age` VALUES (20,1,'20'),(25,2,'25'),(30,3,'30');
/*!40000 ALTER TABLE `age` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_type`
--

DROP TABLE IF EXISTS `animal_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_type` (
  `animal_type_id` int NOT NULL AUTO_INCREMENT,
  `choose_num` int DEFAULT '0',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(255) DEFAULT NULL,
  `typeurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`animal_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_type`
--

LOCK TABLES `animal_type` WRITE;
/*!40000 ALTER TABLE `animal_type` DISABLE KEYS */;
INSERT INTO `animal_type` VALUES (1,0,'2024-03-28 14:52:47','늑대상',NULL),(2,0,'2024-03-28 14:52:47','토끼상',NULL),(3,0,'2024-03-28 14:52:47','강아지상',NULL),(4,0,'2024-03-28 14:52:47','사슴상',NULL),(5,0,'2024-03-28 14:52:47','고양이상',NULL);
/*!40000 ALTER TABLE `animal_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `background`
--

DROP TABLE IF EXISTS `background`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `background` (
  `background_id` int NOT NULL AUTO_INCREMENT,
  `background` varchar(255) NOT NULL,
  `brightness` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`background_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `background`
--

LOCK TABLES `background` WRITE;
/*!40000 ALTER TABLE `background` DISABLE KEYS */;
INSERT INTO `background` VALUES (1,'눈 내리는 삿포로','낮','Sapporo in the snow at daytime'),(2,'눈 내리는 삿포로','밤','Sapporo in the snow at night'),(3,'벚꽃 내리는 석촌 호수','낮','Seokchon Lake with cherry blossoms at daytime'),(4,'벚꽃 내리는 석촌 호수','밤','Seokchon Lake with cherry blossoms at night'),(5,'눈부신 바닷가','낮','Beach at daytime'),(6,'눈부신 바닷가','밤','Beach at night'),(7,'단풍이 흐드러진 숲 속','낮','In a forest with autumn leaves at daytime'),(8,'단풍이 흐드러진 숲 속','밤','In a forest with autumn leaves at night'),(9,'길거리','낮','Street at daytime'),(10,'길거리','밤','Street at night'),(11,'놀이공원','낮','Amusement Park with dark tone'),(12,'놀이공원','밤','Amusement Part with pastel tone'),(13,'아쿠아리움','낮','bright aquarium'),(14,'아쿠아리움','밤','dark aquarium'),(15,'미술관','낮','Art gallery at daytime'),(16,'미술관','밤','Art gallery at night'),(17,'대나무 숲','낮','bright bamboo forest'),(18,'대나무 숲','밤','dark bamboo forest'),(19,'전화기 부스','낮','bright telephone booth'),(20,'전화기 부스','밤','dark telephone booth'),(21,'노을','낮','bright sunset'),(22,'노을','밤','dark sunset'),(23,'비 오는 날','낮','bright rainy day'),(24,'비 오는 날','밤','dark rainy day');
/*!40000 ALTER TABLE `background` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cloth_style`
--

DROP TABLE IF EXISTS `cloth_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cloth_style` (
  `cloth_style_id` int NOT NULL AUTO_INCREMENT,
  `cloth_style` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`cloth_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cloth_style`
--

LOCK TABLES `cloth_style` WRITE;
/*!40000 ALTER TABLE `cloth_style` DISABLE KEYS */;
INSERT INTO `cloth_style` VALUES (1,'블레이저 자켓','blazer + t-shirt'),(2,'청자켓','blue denim jacket + t-shirt'),(3,'가디건','cardigan + t-shirt'),(4,'항공점퍼','bomber jacket'),(5,'떡볶이 코트','duffel coat'),(6,'정장','suit'),(7,'야구','letterman jacket'),(8,'스웨터','sweater'),(9,'저지','track jacket'),(10,'랜덤','Random');
/*!40000 ALTER TABLE `cloth_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concept`
--

DROP TABLE IF EXISTS `concept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concept` (
  `concept_id` int NOT NULL AUTO_INCREMENT,
  `gender_id` int DEFAULT NULL,
  `concept` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`concept_id`),
  KEY `FK43i0u3l1nv3046oo07eyiwi7f` (`gender_id`),
  CONSTRAINT `FK43i0u3l1nv3046oo07eyiwi7f` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES (1,1,'발레리노','ballerina on the stage'),(2,2,'발레리나','ballerino on the stage'),(3,1,'하키선수','wearing a hockey jersey stands'),(4,2,'치어리더','wearing a cheer leaders costume'),(5,1,'락밴드','wearing like a rock star on the stage, wearing a guitar'),(6,2,'락밴드','wearing like a rock star on the stage, wearing a guitar'),(7,1,'복고풍','wearing a retro'),(8,2,'복고풍','wearing a retro'),(9,1,'아이돌','korean debut showcase and wearing like k-pop man idol'),(10,2,'아이돌','korean debut showcase and wearing fancy dress'),(11,1,'턱시도','wearing wedding suit'),(12,2,'웨딩드레스','wearing wedding dress'),(13,1,'모델','wearing like model in fastion show runway'),(14,2,'모델','wearing like model in fastion show runway'),(15,1,'연구원','wearing like researcher'),(16,2,'연구원','wearing like researcher');
/*!40000 ALTER TABLE `concept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eye_style`
--

DROP TABLE IF EXISTS `eye_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eye_style` (
  `eye_style_id` int NOT NULL AUTO_INCREMENT,
  `eye_style` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`eye_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eye_style`
--

LOCK TABLES `eye_style` WRITE;
/*!40000 ALTER TABLE `eye_style` DISABLE KEYS */;
INSERT INTO `eye_style` VALUES (1,'날카로운 눈','wolf eye + charmed face'),(2,'아몬드형 눈','almond +bright face'),(3,'청순한 눈','Ptosis + gentle face'),(4,'우수에 찬 눈','deer eye + lonely face'),(5,'비교적 올라간 눈매','foxy eye +seduced face');
/*!40000 ALTER TABLE `eye_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `face`
--

DROP TABLE IF EXISTS `face`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `face` (
  `face_id` int NOT NULL AUTO_INCREMENT,
  `face` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`face_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `face`
--

LOCK TABLES `face` WRITE;
/*!40000 ALTER TABLE `face` DISABLE KEYS */;
INSERT INTO `face` VALUES (1,'갸름한 얼굴','sharp jaw'),(2,'턱 있는 얼굴','square jaw'),(3,'둥근 얼굴','round');
/*!40000 ALTER TABLE `face` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `gender_id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'남성','male'),(2,'여성','female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hair_length`
--

DROP TABLE IF EXISTS `hair_length`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hair_length` (
  `hair_length_id` int NOT NULL AUTO_INCREMENT,
  `hair_length` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`hair_length_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hair_length`
--

LOCK TABLES `hair_length` WRITE;
/*!40000 ALTER TABLE `hair_length` DISABLE KEYS */;
INSERT INTO `hair_length` VALUES (1,'짧은','short'),(2,'중간','medium'),(3,'긴','long');
/*!40000 ALTER TABLE `hair_length` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hair_style`
--

DROP TABLE IF EXISTS `hair_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hair_style` (
  `gender_id` int DEFAULT NULL,
  `hair_style_id` int NOT NULL AUTO_INCREMENT,
  `hair_style` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`hair_style_id`),
  KEY `FKcqfdye7p3i9643jq5jmt2rp7e` (`gender_id`),
  CONSTRAINT `FKcqfdye7p3i9643jq5jmt2rp7e` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hair_style`
--

LOCK TABLES `hair_style` WRITE;
/*!40000 ALTER TABLE `hair_style` DISABLE KEYS */;
INSERT INTO `hair_style` VALUES (1,1,'말린 머리','drill hair'),(1,2,'뒤로 넘긴 머리','hair slicked back'),(1,3,'옆으로 넘긴 머리','hair slicked side'),(1,4,'앞머리 (뱅 스타일)','full bang'),(1,5,'랜덤','korean trend hair'),(2,6,'앞머리 (뱅 스타일)','bang'),(2,7,'보브 컷','bob hair'),(2,8,'똥머리','bun hair'),(2,9,'곱슬 머리','curly hair'),(2,10,'생머리','straight hair'),(2,11,'포니테일','ponytail hair'),(2,12,'긴 파마 머리','curl hair'),(2,13,'양갈래','pigtail'),(2,14,'올림 머리','updo hair'),(2,15,'웨이브 머리','wavy hair'),(2,16,'땋은 머리','Braided pigtails'),(2,17,'랜점','korean trend hair');
/*!40000 ALTER TABLE `hair_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ideal`
--

DROP TABLE IF EXISTS `ideal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ideal` (
  `created_at` date DEFAULT NULL,
  `ideal_id` bigint NOT NULL AUTO_INCREMENT,
  `ideal_rank` int DEFAULT NULL,
  `idelurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ideal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ideal`
--

LOCK TABLES `ideal` WRITE;
/*!40000 ALTER TABLE `ideal` DISABLE KEYS */;
INSERT INTO `ideal` VALUES ('2024-03-25',1,1,'https://user-images.githubusercontent.com/33855307/129752405-32d58181-4260-43ce-aa8d-2ece9164f964.jpeg');
/*!40000 ALTER TABLE `ideal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ideal_character`
--

DROP TABLE IF EXISTS `ideal_character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ideal_character` (
  `age_id` int DEFAULT NULL,
  `background_id` int DEFAULT NULL,
  `cloth_style_id` int DEFAULT NULL,
  `conept_id` int DEFAULT NULL,
  `eye_style_id` int DEFAULT NULL,
  `face_id` int DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `hair_length_id` int DEFAULT NULL,
  `hair_style_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `make_up_id` int DEFAULT NULL,
  `skin_color_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr1blqt9xekxs9360vu5josyem` (`age_id`),
  KEY `FK3sgrha89uxn49dnynuesh6arh` (`background_id`),
  KEY `FKkm8vm6nx88g6tfxn7x4edibix` (`cloth_style_id`),
  KEY `FKdml4bdtyb2h5j5yl4wb7h7ddv` (`conept_id`),
  KEY `FKl905us6vxfxjkdmn1uexlhkts` (`eye_style_id`),
  KEY `FK3oy7e61oseyrlsioia3j312ja` (`face_id`),
  KEY `FK5foeyotpyayf8kkmjf8y5s2n6` (`gender_id`),
  KEY `FKk3m03wkwhs0s0ye61q01smo84` (`hair_length_id`),
  KEY `FKd9ci882g8qbrak6jkn4fongd3` (`hair_style_id`),
  KEY `FK8mgaxctg8amnb1vsd3m5xxh9x` (`make_up_id`),
  KEY `FKq0274ddgs9vytrn1w60a4df6e` (`skin_color_id`),
  CONSTRAINT `FK3oy7e61oseyrlsioia3j312ja` FOREIGN KEY (`face_id`) REFERENCES `face` (`face_id`),
  CONSTRAINT `FK3sgrha89uxn49dnynuesh6arh` FOREIGN KEY (`background_id`) REFERENCES `background` (`background_id`),
  CONSTRAINT `FK5foeyotpyayf8kkmjf8y5s2n6` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`),
  CONSTRAINT `FK8mgaxctg8amnb1vsd3m5xxh9x` FOREIGN KEY (`make_up_id`) REFERENCES `make_up` (`make_up_id`),
  CONSTRAINT `FKd9ci882g8qbrak6jkn4fongd3` FOREIGN KEY (`hair_style_id`) REFERENCES `hair_style` (`hair_style_id`),
  CONSTRAINT `FKdml4bdtyb2h5j5yl4wb7h7ddv` FOREIGN KEY (`conept_id`) REFERENCES `concept` (`concept_id`),
  CONSTRAINT `FKk3m03wkwhs0s0ye61q01smo84` FOREIGN KEY (`hair_length_id`) REFERENCES `hair_length` (`hair_length_id`),
  CONSTRAINT `FKkm8vm6nx88g6tfxn7x4edibix` FOREIGN KEY (`cloth_style_id`) REFERENCES `cloth_style` (`cloth_style_id`),
  CONSTRAINT `FKl905us6vxfxjkdmn1uexlhkts` FOREIGN KEY (`eye_style_id`) REFERENCES `eye_style` (`eye_style_id`),
  CONSTRAINT `FKq0274ddgs9vytrn1w60a4df6e` FOREIGN KEY (`skin_color_id`) REFERENCES `skin_color` (`skin_color_id`),
  CONSTRAINT `FKr1blqt9xekxs9360vu5josyem` FOREIGN KEY (`age_id`) REFERENCES `age` (`age_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ideal_character`
--

LOCK TABLES `ideal_character` WRITE;
/*!40000 ALTER TABLE `ideal_character` DISABLE KEYS */;
/*!40000 ALTER TABLE `ideal_character` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `ideal_id` bigint NOT NULL AUTO_INCREMENT,
  `animal_type` varchar(255) DEFAULT NULL,
  `idealurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ideal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `make_up`
--

DROP TABLE IF EXISTS `make_up`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `make_up` (
  `make_up_id` int NOT NULL AUTO_INCREMENT,
  `make_up` varchar(255) NOT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`make_up_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `make_up`
--

LOCK TABLES `make_up` WRITE;
/*!40000 ALTER TABLE `make_up` DISABLE KEYS */;
INSERT INTO `make_up` VALUES (1,'스모키','smocky make up'),(2,'사랑스러운','pink make up '),(3,'도도한','brown make up');
/*!40000 ALTER TABLE `make_up` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skin_color`
--

DROP TABLE IF EXISTS `skin_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skin_color` (
  `skin_color_id` int NOT NULL AUTO_INCREMENT,
  `skin_color` varchar(255) DEFAULT NULL,
  `eng` varchar(255) NOT NULL,
  PRIMARY KEY (`skin_color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skin_color`
--

LOCK TABLES `skin_color` WRITE;
/*!40000 ALTER TABLE `skin_color` DISABLE KEYS */;
INSERT INTO `skin_color` VALUES (1,'상아색','#FFF7F3'),(2,'살구색','#FFF3ED'),(3,'태닝','#BA8459');
/*!40000 ALTER TABLE `skin_color` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 10:06:08
