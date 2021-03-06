/*
SQLyog Ultimate v11.13 (32 bit)
MySQL - 5.6.20 : Database - easyspringmvc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easyspringmvc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easyspringmvc`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ACCOUNT` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_VALIDATED` int(1) DEFAULT NULL,
  `USER_TYPE` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `NAME` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ICON` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TELEPHONE` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `REGISTE_TIME` datetime DEFAULT NULL,
  `SESSION_ID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `LAST_LOGIN_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=174 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`ID`,`ACCOUNT`,`PASSWORD`,`EMAIL`,`EMAIL_VALIDATED`,`USER_TYPE`,`NAME`,`ICON`,`TELEPHONE`,`REGISTE_TIME`,`SESSION_ID`,`LAST_LOGIN_TIME`) values (1,'admin','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
