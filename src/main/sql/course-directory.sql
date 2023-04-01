CREATE DATABASE  IF NOT EXISTS `Course_directory`;
USE `Course_directory`;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `course`
--

INSERT INTO `course` VALUES 
	(1,'Advanced Java','Andrews','Spanish'),
	(2,'Core Java','Baumgarten','Irish'),
	(3,'Spring MVC','Gupta','English'),
	(4,'Sping Boot','Petrov','English');

