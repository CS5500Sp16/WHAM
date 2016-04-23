-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: ec2-52-87-159-69.compute-1.amazonaws.com    Database: whamDB
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

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
-- Table structure for table `EVENT`
--
DROP TABLE IF EXISTS `EVENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `is_official` tinyint(1) NOT NULL,
  `phone` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(60) CHARACTER SET utf8 NOT NULL,
  `address` varchar(100) NOT NULL,
  `latitude` double(10,6) NOT NULL,
  `longitude` double(10,6) NOT NULL,
  `create_datetime` datetime NOT NULL,
  `last_update_datetime` datetime NOT NULL,
  `org_name` varchar(128) NOT NULL,
  `org_desc` varchar(1024) NOT NULL,
  `file_path` varchar(256) DEFAULT NULL,
  `start_date_and_time` datetime NOT NULL,
  `end_date_and_time` datetime NOT NULL,
  `event_type` int(11) NOT NULL,
  `event_topic` int(11) NOT NULL,
  `event_subtopic` int(11) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=698 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT`
--

LOCK TABLES `EVENT` WRITE;
/*!40000 ALTER TABLE `EVENT` DISABLE KEYS */;
INSERT INTO `EVENT` VALUES (1,'Shruti Test 1','Shruti Test 1 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, , Boston, MA, 02115',42.341183,-71.091281,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU Student',NULL,'2016-04-06 21:12:00','2016-04-06 21:12:00',0,0,0),(2,'Shruti Test 2','Shruti Test 2 Desc',1,'8579991520','patankar.sh@husky.neu.edu','39 Colborne Rd, , Boston, MA, 02115',42.343521,-71.146691,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU Student',NULL,'2016-04-06 21:12:00','2016-04-06 21:12:00',0,0,0),(3,'Shruti Test 3','Shruti Test 3 Desc',1,'8579991520','patankar.sh@husky.neu.edu','1423 Commonwealth Ave, , Boston, MA, 02115',42.349215,-71.139437,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU Student',NULL,'2016-04-06 21:12:00','2016-04-06 21:12:00',0,0,0),(4,'Shruti Test 4','Shruti Test 4 Desc',0,'','patankar.sh@husky.neu.edu','1429 Commonwealth Avenue, , Boston, MA, 02115',42.349123,-71.139977,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU',NULL,'2016-04-06 21:18:00','2016-04-06 21:18:00',0,0,0),(5,'Shruti Test 5','Shruti Test 5 Desc',1,'','patankar.sh@husky.neu.edu','1212 Commonwealth Avenue, , Boston, MA, 02135',42.350217,-71.130306,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU Student',NULL,'2016-04-07 21:18:00','2016-04-07 21:18:00',0,0,0),(6,'Shruti Test 6','Shruti Test 6 Desc',1,'','patankar.sh@husky.neu.edu','19 egremont road, , Brighton, MA, 02135',42.341099,-71.143746,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','NEU',NULL,'2016-04-07 21:18:00','2016-04-07 21:18:00',0,0,0),(7,'Shruti Test 7','Shruti Test 7 Desc',0,'8579991520','patankar.sh@husky.neu.edu','1100 Commonwealth Ave, , Boston, MA, 02135',42.351819,-71.124383,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','Shruti',NULL,'2016-04-06 21:23:00','2016-04-06 21:23:00',0,0,0),(8,'Shruti Test 8','Shruti Test 8 Desc',0,'','patankar.sh@husky.neu.edu','1234 Commonwealth Ave, , Boston, MA, 02115',42.350029,-71.131179,'2016-04-06 19:17:57','2016-04-06 19:17:57','Shruti','Shruti NEU',NULL,'2016-04-07 21:23:00','2016-04-07 21:23:00',0,0,0),(9,'Shruti Test 10','Shruti Test 10 test',0,'','patankar.sh@husky.neu.edu','1010 Commonwealth Avenue, , Boston, MA, 02134',42.351955,-71.123420,'2016-04-06 21:40:25','2016-04-06 21:40:25','Shruti','Shruti NEU',NULL,'2016-04-06 21:40:00','2016-04-06 21:40:00',0,0,0),(10,'Shruti Test 11','Shruti Test 11 Desc',0,'','patankar.sh@husky.neu.edu','1010 Commonwealth Avenue, , Boston, MA, 02134',42.351955,-71.123420,'2016-04-06 21:40:25','2016-04-06 21:40:25','Shruti','Shruti NEU',NULL,'2016-04-06 21:42:00','2016-04-06 21:42:00',0,0,0),(11,'Shruti Test 12','Shruti Test 12 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, , Boston, MA, 02115',42.341183,-71.091281,'2016-04-06 21:40:25','2016-04-06 21:40:25','Shruti','Shruti NEU',NULL,'2016-04-06 21:43:00','2016-04-06 21:43:00',0,0,0),(12,'HOli','VVV',1,'8572779999','sn@husky.neu.edu','1163 BOYLSTON STREET, , BOSTON, Massachusetts, 02215',42.347036,-71.093398,'2016-04-06 00:41:38','2016-04-06 00:41:38','Vijet','Vijet','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Vijet_1459903298283_holi.jpeg','2016-04-06 23:48:00','2016-05-05 00:00:00',0,0,0),(21,'Shruti Test 11','Shruti Test 11 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street Unit 4, , Boston, MA, 02115',42.341183,-71.091281,'2016-04-07 12:22:39','2016-04-07 12:22:39','Shruti','NEU',NULL,'2016-04-07 12:23:00','2016-04-07 12:23:00',0,0,0),(22,'Shruti Test 13','Shruti Test 13 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street Unit 4, , Boston, MA, 02115',42.341183,-71.091281,'2016-04-07 12:22:39','2016-04-07 12:22:39','Shruti Patankar','NEU Student',NULL,'2016-04-07 12:27:00','2016-04-07 12:27:00',0,0,0),(23,'Shruti Test dev Final','Shruti Test dev Final ',1,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street Unit 4, , Boston, MA, 02115',42.341183,-71.091281,'2016-04-07 12:22:39','2016-04-07 12:22:39','Shruti','NEU Student',NULL,'2016-04-07 12:33:00','2016-04-07 12:33:00',0,0,0),(76,'testing','testing',0,'1234567890','v@husky.neu.edu','northeastern University, , boston, Massachusetts, 02215',42.374996,-71.064797,'2016-04-07 13:00:04','2016-04-07 13:00:04','Vijet','Vijet',NULL,'2016-04-07 13:00:00','2016-05-07 13:00:00',0,0,0),(97,'ABC','VVV',1,'8572779999','sn@husky.neu.edu','xyz, , BOSTON, Massachusetts, 02215',42.347618,-71.100288,'2016-04-07 13:16:55','2016-04-07 13:16:55','Vijet','Vijet','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Vijet_1460035015189_','2016-04-07 13:19:00','2016-04-19 00:00:00',0,0,0),(98,'Shruti Test 21','Shruti Test 21 Desc',1,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, Unit 4, Boston, MA, 02115',42.341183,-71.091281,'2016-04-07 13:16:55','2016-04-07 13:16:55','Shruti','NEU Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460035015189_','2016-04-07 12:54:00','2016-04-08 00:00:00',0,0,0),(199,'Shruti test address','desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, Unit 4, Boston, MA, 02115',42.341183,-71.091281,'2016-04-07 17:01:08','2016-04-07 17:01:08','Shruti','NEU Student',NULL,'2016-04-21 16:59:00','2016-04-22 16:59:00',0,0,0),(200,'fghjkl','fghjkl;',1,'1234567890','dfghjk@husky.neu.edu','1163, Boylston Street, Apt. 21, Boston, Massachusetts, 02215',42.347036,-71.093398,'2016-04-07 13:16:55','2016-04-07 13:16:55','dfghjkl','fghjk','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/dfghjkl_1460035015189_Day_3_of_Day_8_Learn_Online_Acoustic_Guitar_Lessons_in_8_Days.mp4','2016-04-07 17:03:00','2016-04-06 00:00:00',0,0,0),(277,'Shruti Server Test 1','Shruti Server Test 1 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, Unit 4, Boston, MA, 02115',42.341183,-71.091281,'2016-04-08 02:24:51','2016-04-08 02:24:51','Shruti','NEU Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460082291883_','2016-04-07 23:18:00','2016-04-07 23:18:00',0,0,0),(278,'Shruti Server Test 2','Shruti Server Test 2 Desc',1,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, Unit 4, Boston, MA, 02115',42.341183,-71.091281,'2016-04-08 02:24:51','2016-04-08 02:24:51','Shruti Patankar','NEU Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti Patankar_1460082291883_','2016-04-08 23:18:00','2016-04-09 23:18:00',0,0,0),(279,'Shruti Server Test 3','Shruti Server Test 3 Desc',1,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway Street, Unit 4, Boston, MA, 02115',42.341183,-71.091281,'2016-04-08 02:24:51','2016-04-08 02:24:51','Shruti','NEU Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460082291883_dance.png','2016-04-09 23:18:00','2016-04-10 23:18:00',0,0,0),(280,'RigorousTesting','Testing',0,'','v@husky.neu.edu','Fenway Park, , Boston, Massachusetts, 02215',42.348919,-71.095506,'2016-04-08 02:24:51','2016-04-08 02:24:51','Vijwe','Vij','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Vijwe_1460082291883_','2016-04-07 23:25:00','2016-04-28 23:25:00',0,0,0),(321,'Shruti Test Event 2','Desc',0,'','patankar.sh@husky.neu.edu','440 Huntington Ave, Boston, MA',42.338538,-71.092295,'2016-04-08 16:12:58','2016-04-08 16:12:58','Shruti','Shruti NEU',NULL,'2016-04-08 16:16:00','2016-04-08 16:16:00',1,1,0),(322,'Shruti Test Event 2','Shruti Test Event 2',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-08 16:12:58','2016-04-08 16:12:58','Shruti','NEU Student',NULL,'2016-04-20 16:16:00','2016-04-27 16:16:00',1,5,0),(323,'Shruti Test Event 2','Desc',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-08 16:12:58','2016-04-08 16:12:58','Shruti','NEU Student',NULL,'2016-04-08 16:19:00','2016-04-08 16:19:00',1,1,371),(324,'Shruti Test Event 2','Desc',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-08 16:12:58','2016-04-08 16:12:58','Shruti','NEU Student',NULL,'2016-04-08 16:22:00','2016-04-08 16:22:00',6,8,431),(341,'Shruti Server Test 11','Shruti Server Test 11 Desc',0,'8579991520','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-09 19:21:30','2016-04-09 19:21:30','Shruti','Shruti NEU','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460229690733_','2016-04-09 20:01:00','2016-04-09 20:01:00',8,4,398),(342,'Shruti Test Event 12','Shruti Test Event 12 Desc',1,'','patankar.sh@husky.neu.edu','440 Huntington Ave, Boston, MA',42.338538,-71.092295,'2016-04-09 19:21:30','2016-04-09 19:21:30','Shruti','Shruti NEU','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460229690733_dance.png','2016-04-28 20:01:00','2016-04-29 20:01:00',1,1,394),(343,'Shruti Test Event 13','Shruti Test Event 13 Desc',0,'','patankar.sh@husky.neu.edu','Dockser Hall, 65 Forsyth St, Boston, MA 02115, USA',42.338676,-71.090611,'2016-04-09 19:21:30','2016-04-09 19:21:30','Shruti','Shruti NEU','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Shruti_1460229690733_','2016-04-27 20:01:00','2016-04-29 20:01:00',1,5,408),(344,'MSD EXAM','MSD EXAM',1,'8572779594','dummy@husky.neu.edu','1163 Boylston St, Boston, MA 02215, USA',42.347036,-71.093398,'2016-04-09 19:21:30','2016-04-09 19:21:30','VIJET','Vijet','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/VIJET_1460229690733_','2016-04-11 21:57:00','2016-04-13 04:57:00',2,6,417),(345,'TEsting final ','etsting',1,'8572779594','badigannavar.v@husky.neu.edu','1163 Boylston St #21, Boston, MA 02215, USA',42.347036,-71.093398,'2016-04-11 22:16:53','2016-04-11 22:16:53','One tow ','three',NULL,'2016-04-11 22:17:00','2016-04-29 22:17:00',1,1,371),(418,'VIJET','VIJET',1,'','a@husky.neu.edu','West Village Residence Complex H, 440 Huntington Ave, Boston, MA 02115, USA',42.338538,-71.092295,'2016-04-15 01:56:29','2016-04-15 01:56:29','VIJET','VJET',NULL,'2016-04-15 01:56:00','2016-05-06 01:56:00',1,1,371),(427,'AA','AA',1,'','a@husky.neu.edu','1163 Boylston St, Boston, MA 02215, USA',42.347036,-71.093398,'2016-04-16 18:09:56','2016-04-16 18:09:56','s','s',NULL,'2016-04-16 18:10:00','2016-05-05 18:10:00',1,1,371),(428,'AA','AA',0,'','b@husky.neu.edu','1163 Boylston St, Boston, MA 02215, USA',42.347036,-71.093398,'2016-04-16 18:13:42','2016-04-16 18:13:42','A','A',NULL,'2016-04-16 18:13:00','2016-05-05 18:13:00',1,1,371),(501,'Care Of Magical Creatures Seminar','Fantastic Beasts and Where to find them?',1,'','hagrid@husky.neu.edu','84 Hemenway St, Boston, MA 02115, USA',42.344158,-71.089851,'2016-04-18 15:55:50','2016-04-18 15:55:50','Hagrid','Professor at Hogwarts',NULL,'2016-04-18 13:53:00','2016-05-18 15:53:00',17,1,372),(502,'Music Bash','NEU Music Bash',1,'1234567890','badigannavar.v@husky.neu.edu','West Village Residence Complex H, 440 Huntington Ave, Boston, MA 02115, USA',42.338538,-71.092295,'2016-04-18 15:55:50','2016-04-18 15:55:50','Sanskruti','Sanskuti',NULL,'2016-04-18 14:06:00','2016-05-07 14:06:00',13,14,484),(503,'HOli','Testing',1,'','j.v@husky.neu.edu','Boston, MA 02215, USA',42.347618,-71.100288,'2016-04-18 15:55:50','2016-04-18 15:55:50','NEU','NEU',NULL,'2016-04-18 14:12:00','2016-04-29 14:12:00',13,14,480),(512,'Games','Dummy',1,'8573008187','harshshukla81@gmail.com','420 Huntington Ave, Boston, MA',42.339006,-71.091359,'2016-04-18 18:18:31','2016-04-18 18:18:31','Harsh','Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Harsh_1461003511265_shiv in mountain05.jpg','2016-04-18 14:21:00','2016-04-18 14:21:00',10,12,458),(513,'Games','Games',0,'','shukla.h@husky.neu.edu','420 Huntington Ave, Boston, MA',42.339006,-71.091359,'2016-04-18 18:18:31','2016-04-18 18:18:31','Harsh','Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Harsh_1461003511265_shiv in mountain05.jpg','2016-04-19 14:25:00','2016-04-20 14:25:00',10,12,458),(514,'Test','Games',1,'','shukla.h@husky.neu.edu','420 Huntington Ave, Boston, MA',42.339006,-71.091359,'2016-04-18 18:18:31','2016-04-18 18:18:31','Vaibhav','Student',NULL,'2016-04-19 14:45:00','2016-04-20 14:42:00',10,12,458),(515,'game','test',0,'8573008187','shukla.h@husky.neu.edu','420 Huntington Ave, Boston, MA',42.339006,-71.091359,'2016-04-18 18:18:31','2016-04-18 18:18:31','Harsh','student',NULL,'2016-04-19 14:49:00','2016-04-20 14:49:00',10,12,458),(516,'Games','Test',0,'','shukla.h@husky.neu.edu','75 St Alphonsus St, Boston, MA 02120, USA',42.334311,-71.100762,'2016-04-18 18:18:31','2016-04-18 18:18:31','Harsh','Test',NULL,'2016-04-20 16:49:00','2016-04-21 16:49:00',10,12,458),(517,'ClassTest','Test',0,NULL,'aswin@abc.net','abc',42.330000,-71.100000,'2016-04-18 18:18:31','2016-04-18 18:18:31','Aswin','Aswin',NULL,'2016-04-18 18:18:31','2016-04-18 18:18:31',0,0,371),(526,'final event','final event',1,'6179924222','v@husky.neu.edu','360 Huntington Ave, Boston, MA 02115, USA',42.339348,-71.088173,'2016-04-18 22:38:47','2016-04-18 22:38:47','Final','Final',NULL,'2016-04-18 18:47:00','2016-05-06 18:47:00',1,1,371),(544,'Tea Party','A get together',0,'','gupta.surb@husky.neu.edu','360 Huntington Ave, Boston, MA 02115, USA',42.339348,-71.088173,'2016-04-18 22:38:47','2016-04-18 22:38:47','Surbhi Gupta','Student','http://ec2-52-87-159-69.compute-1.amazonaws.com:8080/WHAM/user_images/Surbhi Gupta_1461019127361_2.PNG','2016-04-19 04:28:00','2016-04-19 04:28:00',8,9,436),(569,'MSD Presentation Demo','MSD Demo Details',0,'','patankar.sh@husky.neu.edu','173 Hemenway St, Boston, MA 02115, USA',42.340636,-71.091379,'2016-04-19 17:55:57','2016-04-19 17:55:57','Shruti','NEU Student',NULL,'2016-04-19 14:01:00','2016-04-19 16:01:00',4,18,514),(570,'MSD demo','demo description',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-19 17:55:57','2016-04-19 17:55:57','shruti','neu student',NULL,'2016-04-19 15:58:00','2016-04-19 16:58:00',4,5,413),(571,'MSD demo','demo desc',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-19 17:55:57','2016-04-19 17:55:57','Shruti','neu student',NULL,'2016-04-19 16:43:00','2016-04-19 17:43:00',1,1,371),(625,'Test Event ','Test Event Desc',0,'','patankar.sh@husky.neu.edu','175 Hemenway St, Boston, MA 02115, USA',42.341183,-71.091281,'2016-04-19 22:59:36','2016-04-19 22:59:36','Shruti','Student NEU',NULL,'2016-04-19 18:59:00','2016-04-19 19:59:00',1,1,371),(626,'demo test','demo test desc',0,'','patankar.sh@husky.neu.edu','173 Hemenway St, Boston, MA 02115, USA',42.340636,-71.091379,'2016-04-19 22:59:36','2016-04-19 22:59:36','Shruti','Shruti student',NULL,'2016-04-19 19:01:00','2016-04-19 20:01:00',1,1,371),(627,'Test Event ','Test Event Desc',0,'','patankar.sh@husky.neu.edu','173 Hemenway St, Boston, MA 02115, USA',42.340636,-71.091379,'2016-04-19 22:59:36','2016-04-19 22:59:36','Shruti','Shruti student',NULL,'2016-04-21 19:06:00','2016-04-22 19:06:00',1,1,371),(628,'Test Event final','Test Event Desc',0,'','patankar.sh@husky.neu.edu','173 Hemenway St, Boston, MA 02115, USA',42.340636,-71.091379,'2016-04-19 22:59:36','2016-04-19 22:59:36','Shruti','Shruti student',NULL,'2016-04-22 19:07:00','2016-04-23 19:07:00',1,1,371),(629,'demo event','demo desc',0,'','patankar.sh@husky.neu.edu','171 Hemenway St, Boston, MA 02115, USA',42.341309,-71.091202,'2016-04-19 22:59:36','2016-04-19 22:59:36','shruti','neu student',NULL,'2016-04-21 19:57:00','2016-04-22 19:57:00',1,1,371);
/*!40000 ALTER TABLE `EVENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_SUB_TOPIC_MASTER`
--

DROP TABLE IF EXISTS `EVENT_SUB_TOPIC_MASTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_SUB_TOPIC_MASTER` (
  `event_sub_topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_sub_topic` varchar(64) NOT NULL,
  `event_topic_id` int(11) NOT NULL,
  PRIMARY KEY (`event_sub_topic_id`),
  KEY `event_topic_id_idx` (`event_topic_id`),
  CONSTRAINT `event_topic_id` FOREIGN KEY (`event_topic_id`) REFERENCES `EVENT_TOPIC_MASTER` (`event_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=556 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_SUB_TOPIC_MASTER`
--

LOCK TABLES `EVENT_SUB_TOPIC_MASTER` WRITE;
/*!40000 ALTER TABLE `EVENT_SUB_TOPIC_MASTER` DISABLE KEYS */;
INSERT INTO `EVENT_SUB_TOPIC_MASTER` VALUES (371,'Class',1),(372,'Lecture',1),(373,'Meeting',1),(374,'Open Mic',1),(375,'Panel Discussion',1),(376,'PHD defence',1),(377,'Rally',1),(378,'Air',2),(379,'Auto',2),(380,'Boat',2),(381,'Motorcycle/ATV',2),(382,'Other',2),(383,'Career',3),(384,'Design',3),(385,'Educators',3),(386,'Environment And Sustainability',3),(387,'Finance',3),(388,'Media',3),(389,'Non Profit And NGOs',3),(390,'Other',3),(391,'Real Estate',3),(392,'Sales And Marketing',3),(393,'Startups And Small Business',3),(394,'Animal Welfare',4),(395,'Disaster Relief',4),(396,'Education',4),(397,'Environment',4),(398,'Fundraising',4),(399,'Healthcare',4),(400,'Human Rights',4),(401,'International Aid',4),(402,'Other',4),(403,'Poverty',4),(404,'City/Town',5),(405,'County',5),(406,'Heritage',5),(407,'LGBT',5),(408,'Language',5),(409,'Medieval',5),(410,'Nationality',5),(411,'Other',5),(412,'Renaissance',5),(413,'State',5),(414,'Alumni',6),(415,'Baby',6),(416,'Children And Youth ',6),(417,'Education',6),(418,'Other',6),(419,'Parenting',6),(420,'Parents Association',6),(421,'Reunion',6),(422,'Accessories',7),(423,'Beauty',7),(424,'Bridal',7),(425,'Fashion',7),(426,'Other',7),(427,'Adult',8),(428,'Anime',8),(429,'Comedy',8),(430,'Comics',8),(431,'Film',8),(432,'Gaming',8),(433,'Other',8),(434,'TV',8),(435,'Beer',9),(436,'Food',9),(437,'Other',9),(438,'Spirits',9),(439,'Wine',9),(440,'County/Municipal Government ',10),(441,'Democratic Party',10),(442,'Federal Government',10),(443,'Non-partisan',10),(444,'Other',10),(445,'Other Party',10),(446,'Republican Party',10),(447,'State Government',10),(448,'Medical',11),(449,'Mental health',11),(450,'Other',11),(451,'Personal health',11),(452,'Spa',11),(453,'Yoga',11),(454,'Adult',12),(455,'Anime/Comics',12),(456,'Books',12),(457,'DIY',12),(458,'Drawing And Painting',12),(459,'Gaming',12),(460,'Knitting',12),(461,'Other',12),(462,'Photography',12),(463,'Dating',13),(464,'Home And Garden',13),(465,'Other',13),(466,'Pets And Animals',13),(467,'Alternative',14),(468,'Blues And Jazz',14),(469,'Classical',14),(470,'Country',14),(471,'Cultural',14),(472,'EDM / Electronic',14),(473,'Folk',14),(474,'Hip Hop / Rap',14),(475,'Indie',14),(476,'Latin',14),(477,'Metal',14),(478,'Opera',14),(479,'Other',14),(480,'Pop',14),(481,'RAndB',14),(482,'Reggae',14),(483,'Religious/Spiritual',14),(484,'Rock',14),(485,'Top 40',14),(486,'Ballet',16),(487,'Comedy',16),(488,'Craft',16),(489,'Dance',16),(490,'Fine Art',16),(491,'Literary Arts',16),(492,'Musical',16),(493,'Opera',16),(494,'Orchestra',16),(495,'Other',16),(496,'Theatre',16),(497,'Buddhism',17),(498,'Christianity',17),(499,'Eastern Religion',17),(500,'Hinduism',17),(501,'Islam',17),(502,'Judaism',17),(503,'Mormonism',17),(504,'Mysticism and Occult',17),(505,'New Age',17),(506,'Other',17),(507,'Sikhism',17),(508,'Biotech',18),(509,'High Tech',18),(510,'Medicine',18),(511,'Mobile',18),(512,'Other',18),(513,'Robotics',18),(514,'Science',18),(515,'Social Media',18),(516,'Channukah',19),(517,'Christmas',19),(518,'Diwali',19),(519,'Easter',19),(520,'Fall events',19),(521,'Halloween/Haunt',19),(522,'Independence Day',19),(523,'New Years Eve',19),(524,'Other',19),(525,'St Patricks Day',19),(526,'Thanksgiving',19),(527,'Atheletics',20),(528,'Basketball',20),(529,'Cricket',20),(530,'Cycling',20),(531,'Exercise',20),(532,'Fighting And Martial Arts',20),(533,'Football',20),(534,'Golf',20),(535,'Hockey',20),(536,'Motorsports',20),(537,'Mountain Biking',20),(538,'Obstacles',20),(539,'Other',20),(540,'Rugby',20),(541,'Running',20),(542,'Snow Sports',20),(543,'Soccer',20),(544,'Swimming And Water Sports',20),(545,'Tennis',20),(546,'Volleyball',20),(547,'Walking',20),(548,'Yoga',20),(549,'Canoeing',21),(550,'Climbing',21),(551,'Hiking',21),(552,'Kayaking',21),(553,'Other',21),(554,'Rafting',21),(555,'Travel',21);
/*!40000 ALTER TABLE `EVENT_SUB_TOPIC_MASTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_TOPIC_MASTER`
--

DROP TABLE IF EXISTS `EVENT_TOPIC_MASTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_TOPIC_MASTER` (
  `event_topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_topic` varchar(45) NOT NULL,
  PRIMARY KEY (`event_topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_TOPIC_MASTER`
--

LOCK TABLES `EVENT_TOPIC_MASTER` WRITE;
/*!40000 ALTER TABLE `EVENT_TOPIC_MASTER` DISABLE KEYS */;
INSERT INTO `EVENT_TOPIC_MASTER` VALUES (1,'Academic Events'),(2,'Auto, Boat And Air'),(3,'Business And Professional'),(4,'Charity And Causes'),(5,'Community And Culture'),(6,'Family And Education'),(7,'Fashion And Beauty'),(8,'Film, Media And Entertainment'),(9,'Food And Drink'),(10,'Government And Politics'),(11,'Health And Wellness'),(12,'Hobbies And Special Interest'),(13,'Home And Lifestyle'),(14,'Music'),(15,'Other'),(16,'Performing And Visual Arts'),(17,'Religion And Spirituality'),(18,'Science And Technology'),(19,'Seasonal And Holiday'),(20,'Sports And Fitness'),(21,'Travel And Outdoor');
/*!40000 ALTER TABLE `EVENT_TOPIC_MASTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_TYPE_MASTER`
--

DROP TABLE IF EXISTS `EVENT_TYPE_MASTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_TYPE_MASTER` (
  `event_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_type` varchar(45) NOT NULL,
  PRIMARY KEY (`event_type_id`),
  UNIQUE KEY `event_type_UNIQUE` (`event_type`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_TYPE_MASTER`
--

LOCK TABLES `EVENT_TYPE_MASTER` WRITE;
/*!40000 ALTER TABLE `EVENT_TYPE_MASTER` DISABLE KEYS */;
INSERT INTO `EVENT_TYPE_MASTER` VALUES (1,'Appearance or Signing'),(2,'Attraction'),(3,'Camp, Trip, or Retreat'),(4,'Class, Training, or Workshop '),(5,'Concert or Performance'),(6,'Conference'),(7,'Convention'),(8,'Dinner or Gala '),(9,'Festival or Fair'),(10,'Game or Competition'),(11,'Meeting or Networking Event'),(12,'Other'),(13,'Party or Social Gathering'),(14,'Race or Endurance Event'),(15,'Rally'),(16,'Screening '),(17,'Seminar or Talk'),(18,'Tour'),(19,'Tournament'),(20,'Tradeshow, Consumer Show, or Expo');
/*!40000 ALTER TABLE `EVENT_TYPE_MASTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`)
) ENGINE=InnoDB AUTO_INCREMENT=710 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (2,'anshika',NULL,'','anshika@husky.neu.edu','1234567890','anshika123'),(3,'aswin',NULL,'','aswin@husky.neu.edu','1234567890','aswin123'),(4,'ryan',NULL,'','ryan@husky.neu.edu','1234567890','ryan123'),(5,'surbhi',NULL,'','surbhi@husky.neu.edu','1234567890','surbhi123'),(6,'shruti',NULL,'','shruti@husky.neu.edu','1234567890','shruti123'),(7,'harsh',NULL,'','harsh@husky.neu.edu','1234567890','harsh123'),(8,'emaxi',NULL,'','emaxi@husky.neu.edu','1234567890','emaxi123'),(9,'jue',NULL,'','jue@husky.neu.edu','1234567890','jue123'),(10,'mavez',NULL,'','mavez@husky.neu.edu','1234567890','mavez123'),(11,'vaibhav',NULL,'','vaibhav@husky.neu.edu','1234567890','vaibhav123'),(12,'vijet',NULL,'','vijet@husky.neu.edu','1234567890','vijet123'),(13,'dummy',NULL,'','dummy@husky.neu.edu','123456789',NULL),(14,'disha',NULL,'','disha@husky.neu.edu','123456789','disha123'),(15,'neha',NULL,'','neha@husky.neu.edu','123456789','neha123'),(71,'VIJET','GG','GG','v@gmail.com','1234567890','4786f3282f04de5b5c7317c490c6d922'),(123,'Harsh','','Shukla','shukla.h@husky.neu.edu','8573008187','5ebe2294ecd0e0f08eab7690d2a6ee69'),(129,'','','','','','d41d8cd98f00b204e9800998ecf8427e'),(135,'xz','','Shukla','harshshukla81@gmail.com','8573008187','5ebe2294ecd0e0f08eab7690d2a6ee69'),(136,'Disha','','Soni','soni.disha21@gmail.com','1211212121','7815696ecbf1c96e6894b779456d330e'),(142,'Disha','','Soni','soni.di@gmail.com','1212121212','7815696ecbf1c96e6894b779456d330e'),(143,'neha','neha','neha','neha@gmail.com','1234567890','262f5bdd0af9098e7443ab1f8e435290'),(156,'Harsh','','Shukla','harshshukla524@gmail.com','8570000000','5ebe2294ecd0e0f08eab7690d2a6ee69'),(168,'AJT','kjkhjkjh','TAJ','ajt@gmail.com','7868755','0d994ce7643ee4baeae4ce3ce4ac1224'),(169,'kjklj','lkjklj','kljklj','anshika@test.com','897879','0d994ce7643ee4baeae4ce3ce4ac1224'),(170,'jkkjh','jkkjh','khkh','kjhkh@kjhkhj','kjhkhk','0e3e0fee239d849b82b5db788ddcb8e3'),(171,'jhkhkh','ghjgj','jhkhkjh','kjhkhk@jgjgk.ckjhkhj','kjhk','4e90bf5c6e89b179005004f6ef56fda1'),(172,'mbmb','jjkhjkh','kjhkjh','nvjhjg@gghhg.com','65765675','363b122c528f54df4a0446b6bab05515'),(206,'he','','','he@gmail.com','','d41d8cd98f00b204e9800998ecf8427e'),(213,'he1','','he','he1@gmail.com','','2510c39011c5be704182423e3a695e91'),(214,'user1','','user1','user1@gmail.com','','24c9e15e52afc47c225b757e7bee1f9d'),(226,'World','','','h@gmail.com','','2510c39011c5be704182423e3a695e91'),(227,'Shruti Sanjay','','Patankar','patankar.sh@husky.neu.edu','','5ebe2294ecd0e0f08eab7690d2a6ee69'),(239,'Shruti Sanjay','','Patankar','shrutipatankar8@gmail.com','','5ebe2294ecd0e0f08eab7690d2a6ee69'),(247,'Disha','','Soni','disha@gmail.com','7878878777','3331e8d1992e9dceb8f3ce8c69d8c2fb'),(267,'Harsh','','Shukla','hrsh.shuklaa@gmail.com','8573008187','5ebe2294ecd0e0f08eab7690d2a6ee69'),(275,'AnshikaTesting','','JainTesting','anshika1@test.com','675675675','098f6bcd4621d373cade4e832627b4f6'),(276,'AswinTest',NULL,'AswinTest','abc@123.com','1234567891','neu'),(288,'finaltest','t','t','final@gmail.com','1221222222','2a1585a864d9e67627c6ae04c807a2c5'),(289,'Anshika','','','anshika@g.com','','46b5e59b2fd342bf8fee10c561958725'),(293,'Anshika','','jain','anshika@h.com','5464567657','730b1d2ffece9a1c748a54cd0bb0e363'),(294,'','jkhkh','kjhkhj','kjhjkh','kjhkjh','e358efa489f58062f10dd7316b65649e'),(318,'Anshika','','Jain','test@t.com','67575','098f6bcd4621d373cade4e832627b4f6'),(319,'Anshika','','Jain','test@top.com','67575','569ef72642be0fadd711d6a468d68ee1'),(323,'Surbhi','','Gupta','gupta.surb@husky.neu.edu','5712960000','5ebe2294ecd0e0f08eab7690d2a6ee69'),(434,'demo','','','demo@husky.neu.edu','','ab56b4d92b40713acc5af89985d4b786');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_PREFERENCES`
--

DROP TABLE IF EXISTS `USER_PREFERENCES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_PREFERENCES` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `event_pref_type` varchar(32) NOT NULL DEFAULT '',
  `event_pref_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`event_pref_type`,`event_pref_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `USER` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_PREFERENCES`
--

LOCK TABLES `USER_PREFERENCES` WRITE;
/*!40000 ALTER TABLE `USER_PREFERENCES` DISABLE KEYS */;
INSERT INTO `USER_PREFERENCES` VALUES (2,'0',1),(2,'1',1),(2,'2',371),(3,'0',1),(3,'1',1),(9,'0',2),(13,'1',1),(13,'1',2),(13,'1',3),(13,'1',9),(13,'1',16),(13,'2',5),(13,'2',429),(13,'2',430),(13,'2',431),(123,'0',10),(123,'1',12),(123,'2',458),(143,'0',13),(143,'2',480),(226,'0',3),(227,'1',11),(247,'0',6),(247,'0',11),(247,'1',2),(267,'0',10),(267,'2',458),(276,'2',371),(288,'2',371),(323,'1',9);
/*!40000 ALTER TABLE `USER_PREFERENCES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-22 20:54:21
