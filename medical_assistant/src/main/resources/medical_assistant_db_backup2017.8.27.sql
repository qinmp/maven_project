/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.17-log : Database - medical_assistant_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medical_assistant_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `medical_assistant_db`;

/*Table structure for table `t_abnormalskin` */

DROP TABLE IF EXISTS `t_abnormalskin`;

CREATE TABLE `t_abnormalskin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `abnormalSkin` tinyint(4) NOT NULL COMMENT '//皮肤异常；0.面部 1.颈部，腋下；2.会阴部；3.头皮；4.手足部；5.四肢躯干(湿疹，过敏，其他_)',
  `limbsTrunk` tinyint(4) DEFAULT NULL COMMENT '//四肢躯干；0.湿疹；1.过敏；2.其他；',
  `other_problem` varchar(50) DEFAULT NULL COMMENT '//其他四肢问题；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_abnormalskin` */

insert  into `t_abnormalskin`(`id`,`serial_no`,`abnormalSkin`,`limbsTrunk`,`other_problem`,`create_time`) values (1,'xxxx',1,2,'other problem','2017-06-12 21:57:05'),(2,'20170625223-6',1,0,NULL,'2017-06-25 17:19:46');

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '//主键id',
  `account` varchar(100) NOT NULL COMMENT '//用户帐号，邮箱或者手机号',
  `name` varchar(30) NOT NULL COMMENT '//用户名',
  `password` varchar(60) NOT NULL COMMENT '//密码',
  `tel` varchar(30) NOT NULL COMMENT '//电话',
  `email` varchar(30) DEFAULT NULL COMMENT '//邮箱',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//注册时间',
  `is_delete` int(4) NOT NULL DEFAULT '0' COMMENT '//是否逻辑删除1：是，0：否，默认为0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_account` */

insert  into `t_account`(`id`,`account`,`name`,`password`,`tel`,`email`,`creat_time`,`is_delete`) values (6,'qinmp@qq.com','qinmp@qq.com','11112222','18684048891',NULL,'2017-05-14 11:15:28',0),(7,'xxx@qq.com','xxx@qq.com','111111','18684048891',NULL,'2017-05-14 11:43:52',0),(8,'fadada','fadada','123456','18684048891',NULL,'2017-05-23 21:10:44',0),(9,'aaa@qq.com','aaa@qq.com','123456','18684048891',NULL,'2017-05-24 22:25:29',0),(10,'OO','OO','18818212341','18818212341',NULL,'2017-05-31 20:16:33',0),(11,'666@qq.com','xiaoming','1111qqqq','666@qq.com','666@qq.com','2017-08-06 09:31:15',0),(12,'xxx@dfdfd.cllmm','xiaoming','1111qqqq','xxx@dfdfd.cllmm','xxx@dfdfd.cllmm','2017-08-06 09:33:54',0),(13,'hello@qq.com','hello','1111qqqq','hello@qq.com','hello@qq.com','2017-08-27 18:05:23',0);

/*Table structure for table `t_affective_symptoms` */

DROP TABLE IF EXISTS `t_affective_symptoms`;

CREATE TABLE `t_affective_symptoms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//情感症状',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_affective_symptoms` */

insert  into `t_affective_symptoms`(`id`,`serial_no`,`name`,`create_time`) values (1,'20170823274-6','情感症状','2017-08-23 22:20:27'),(3,'20170827278-13','情感症状','2017-08-27 18:07:27');

/*Table structure for table `t_allergic_history` */

DROP TABLE IF EXISTS `t_allergic_history`;

CREATE TABLE `t_allergic_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `allergic_type` int(20) NOT NULL COMMENT '//是否有过敏1表示有，0表示没有',
  `allergic_medicine_name` varchar(300) DEFAULT NULL COMMENT '//过敏药物名称,以逗号分割',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_allergic_history` */

/*Table structure for table `t_astriction` */

DROP TABLE IF EXISTS `t_astriction`;

CREATE TABLE `t_astriction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `continue_time_is_more_than_half_year` tinyint(4) NOT NULL COMMENT '//持续时间是否超过半年 1.超过半年；0.未超过半年；',
  `is_more_than_three_time` tinyint(4) DEFAULT NULL COMMENT '//每天排便次数是否超过三次，1.达到或者超过 2.不满三次；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_astriction` */

insert  into `t_astriction`(`id`,`serial_no`,`continue_time_is_more_than_half_year`,`is_more_than_three_time`,`create_time`) values (1,'20170625223-6',2,2,'2017-06-25 17:07:07');

/*Table structure for table `t_basic_info` */

DROP TABLE IF EXISTS `t_basic_info`;

CREATE TABLE `t_basic_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '//主键',
  `serial_no` varchar(32) NOT NULL COMMENT '//序列编号',
  `name` varchar(32) NOT NULL COMMENT '//用户姓名',
  `real_birth_day` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//真实生日',
  `age` varchar(11) NOT NULL COMMENT '//年龄',
  `sex` int(4) NOT NULL COMMENT '//性别0：男，1：女',
  `native_place` varchar(100) NOT NULL COMMENT '//籍贯',
  `present_residence` varchar(100) NOT NULL COMMENT '//现居住地',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//更新时间',
  `account_id` bigint(20) NOT NULL COMMENT '//用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `t_basic_info` */

insert  into `t_basic_info`(`id`,`serial_no`,`name`,`real_birth_day`,`age`,`sex`,`native_place`,`present_residence`,`create_time`,`update_time`,`account_id`) values (1,'20170521172','qinmp','2017-05-04 00:00:00','2.5周',0,'上海市-上海市-徐汇区','湖北省-十堰市-丹江口市','2017-05-21 22:00:24','2017-05-21 22:00:22',0),(2,'20170521173','hello','2017-05-12 00:00:00','1.4周',0,'天津市-天津市-南开区','山东省-青岛市-四方区','2017-05-21 22:09:11','2017-05-21 22:09:11',0),(3,'20170523176','hahaah','2017-05-03 00:00:00','2.9周',1,'重庆市-重庆市-九龙坡区','天津市-天津市-河西区','2017-05-23 20:50:44','2017-05-23 20:50:45',0),(4,'20170523177','helloxl','2017-05-11 00:00:00','1.8周',1,'北京市-北京市-石景山区','天津市-天津市-塘沽区','2017-05-23 21:08:10','2017-05-23 21:08:10',6),(5,'20170524182','aaa@qq.com','2017-05-01 00:00:00','3.4周',0,'天津市-天津市-河北区','河南省-洛阳市-洛龙区','2017-05-24 22:27:09','2017-05-24 22:27:10',9),(6,'20170525185','xxxx','2017-05-12 00:00:00','2.0周',0,'北京市-北京市-西城区','辽宁省-铁岭市-调兵山市','2017-05-25 23:51:54','2017-05-25 23:51:55',6),(7,'20170526193','qinmp','2017-05-11 00:00:00','2.2周',0,'上海市-上海市-普陀区','黑龙江省-鹤岗市-东山区','2017-05-26 23:02:50','2017-05-26 23:02:50',6),(8,'20170531197','xxxxxx','2017-05-11 00:00:00','3.0周',0,'黑龙江省-七台河市-新兴区','天津市-天津市-河西区','2017-05-31 23:37:08','2017-05-31 23:37:08',6),(9,'20170601198','xxxxx','2017-05-03 00:00:00','4.2周',0,'天津市-天津市-河东区','福建省-三明市-雪峰镇','2017-06-01 21:03:10','2017-06-01 21:03:10',6),(14,'20170602203','hello','2017-03-09 00:00:00','2.9月',1,'新疆-自治区直辖县级行政单位-石河子市','吉林省-吉林市-丰满区','2017-06-02 21:38:39','2017-06-02 21:38:39',6),(15,'20170623221','qinmp','2017-06-02 00:00:00','3.1周',0,'天津市-天津市-南开区','天津市-天津市-南开区','2017-06-23 23:22:57','2017-06-23 23:22:57',6),(16,'20170624222','覃茂平','1990-06-23 00:00:00','27.0年',0,'海南省-省直辖行政单位-儋州市','广东省-深圳市-宝安区','2017-06-24 08:28:16','2017-06-24 08:28:17',6),(17,'20170625223','qinmp','2017-06-01 00:00:00','3.4周',0,'北京市-北京市-崇文区','重庆市-重庆市-南岸区','2017-06-25 09:30:47','2017-06-25 09:30:48',6),(18,'20170626226','hello','2017-06-02 00:00:00','3.5周',0,'上海市-上海市-闸北区','河北省-承德市-滦平镇','2017-06-26 23:10:31','2017-06-26 23:10:31',6),(19,'20170630229','覃茂平','2017-06-01 00:00:00','4.2周',0,'重庆市-重庆市-北碚区','上海市-上海市-普陀区','2017-06-30 21:23:29','2017-06-30 21:23:30',6),(20,'20170702230','qinmp@qq.com','2017-01-04 00:00:00','6.0月',0,'天津市-天津市-宝坻区','山东省-日照市-洪凝镇','2017-07-02 15:51:33','2017-07-02 15:51:33',6),(21,'20170709231','qinmp','1990-06-22 00:00:00','27.1年',0,'河北省-廊坊市-淑阳镇','安徽省-马鞍山市-姑孰镇','2017-07-09 11:57:45','2017-07-09 11:57:46',6),(22,'20170801247','xxxxx','2017-03-01 00:00:00','5.1月',0,'天津市-天津市-红桥区','重庆市-重庆市-万盛区','2017-08-01 20:37:08','2017-08-01 20:37:09',6),(23,'20170804251','OO','1994-12-20 00:00:00','22.6年',1,'海南省-省直辖行政单位-儋州市','上海市-上海市-徐汇区','2017-08-04 22:04:45','2017-08-04 22:04:45',10),(25,'20170806265','嗡嗡嗡','2017-02-04 00:00:00','6.1月',1,'天津市-天津市-红桥区','内蒙古-乌海市-乌达区','2017-08-06 21:31:20','2017-08-06 21:31:21',6),(26,'20170823274','wwwwww','2017-08-04 00:00:00','2.8周',0,'天津市-天津市-塘沽区','辽宁省-抚顺市-望花区','2017-08-23 20:51:33','2017-08-23 20:51:33',6),(27,'20170824275','嘿嘿嘿','2017-08-01 00:00:00','3.4周',1,'上海市-上海市-静安区','重庆市-重庆市-北碚区','2017-08-24 23:27:40','2017-08-24 23:27:40',6),(29,'20170827277','wwwww','2003-08-01 00:00:00','14.1年',1,'北京市-北京市-崇文区','吉林省-白城市-大安市','2017-08-27 10:44:11','2017-08-27 10:44:12',6),(30,'20170827278','bababa','2000-08-03 00:00:00','17.1年',1,'内蒙古-赤峰市-巴林左旗','江苏省-淮安市-盱城镇','2017-08-27 18:06:26','2017-08-27 18:06:26',13);

/*Table structure for table `t_bellyache` */

DROP TABLE IF EXISTS `t_bellyache`;

CREATE TABLE `t_bellyache` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `pain_id` bigint(20) NOT NULL COMMENT '//关联疼痛表，疼痛id',
  `bellyache_continue_time` varchar(32) NOT NULL COMMENT '//腹痛持续时间',
  `continuous_or_indirectness_type` tinyint(4) NOT NULL COMMENT '//持续性还是间接性 0.持续性，1.间接性',
  `relationship_with_eat_type` tinyint(4) DEFAULT NULL COMMENT '//持续性时与进食关系如何；0.腹痛进食后发生，1.腹痛进食后减轻，2.腹痛与进食无关',
  `pain_nature_type` tinyint(4) NOT NULL COMMENT '//疼痛性质类型 0.痉挛性疼痛，1.可以忍受的疼痛',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_bellyache` */

/*Table structure for table `t_birth_history` */

DROP TABLE IF EXISTS `t_birth_history`;

CREATE TABLE `t_birth_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `how_many_times_pregnant` int(20) NOT NULL COMMENT '//怀孕过几次；',
  `how_many_times_delivered` int(20) NOT NULL COMMENT '//分娩过几次',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_birth_history` */

/*Table structure for table `t_blood_transfusion` */

DROP TABLE IF EXISTS `t_blood_transfusion`;

CREATE TABLE `t_blood_transfusion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `blood_transfusion_type` int(20) NOT NULL COMMENT '//是否有过输血史1.有 0.没有',
  `blood_transfusion_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//输血时间',
  `operation_name` varchar(32) DEFAULT NULL COMMENT '//手术名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_blood_transfusion` */

/*Table structure for table `t_consciousness_disorder` */

DROP TABLE IF EXISTS `t_consciousness_disorder`;

CREATE TABLE `t_consciousness_disorder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//意识障碍',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_consciousness_disorder` */

insert  into `t_consciousness_disorder`(`id`,`serial_no`,`name`,`create_time`) values (1,'20170823274-6','意识障碍','2017-08-23 22:20:27'),(3,'20170827278-13','意识障碍','2017-08-27 18:07:27');

/*Table structure for table `t_cough` */

DROP TABLE IF EXISTS `t_cough`;

CREATE TABLE `t_cough` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `cough_start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//咳嗽开始时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//记录创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_cough` */

insert  into `t_cough`(`id`,`serial_no`,`cough_start_time`,`create_time`) values (1,'20170625223-6','2017-06-08 00:00:00','2017-06-25 16:44:22'),(2,'20170626226-6','2017-06-02 00:00:00','2017-06-26 23:11:39'),(3,'20170628227-6','2017-06-01 00:00:00','2017-06-28 22:45:18'),(5,'20170827278-13','2017-08-03 00:00:00','2017-08-27 18:07:27');

/*Table structure for table `t_diarrhea` */

DROP TABLE IF EXISTS `t_diarrhea`;

CREATE TABLE `t_diarrhea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `diarrhea_type` tinyint(4) NOT NULL COMMENT '//腹泻类型',
  `diarrhea_continus_time` int(10) DEFAULT NULL COMMENT '//腹泻持续时间(天)',
  `diarrhea_start_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//腹泻开始时间',
  `each_day_time` int(10) DEFAULT NULL COMMENT '//每天次数',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//记录创建日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_diarrhea` */

insert  into `t_diarrhea`(`id`,`serial_no`,`diarrhea_type`,`diarrhea_continus_time`,`diarrhea_start_time`,`each_day_time`,`create_time`) values (1,'20170625223-6',1,23,'2017-06-02 00:00:00',NULL,'2017-06-25 17:00:27');

/*Table structure for table `t_dizzy` */

DROP TABLE IF EXISTS `t_dizzy`;

CREATE TABLE `t_dizzy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `dizzy` tinyint(4) NOT NULL COMMENT '//头晕 0.晕车或者晕船;1.晕厥；2.眩晕；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_dizzy` */

insert  into `t_dizzy`(`id`,`serial_no`,`dizzy`,`create_time`) values (1,'20170625223-6',3,'2017-06-25 17:18:56'),(2,'20170823274-6',1,'2017-08-23 22:20:27');

/*Table structure for table `t_dyspnea` */

DROP TABLE IF EXISTS `t_dyspnea`;

CREATE TABLE `t_dyspnea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//呼吸困难',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dyspnea` */

/*Table structure for table `t_edema` */

DROP TABLE IF EXISTS `t_edema`;

CREATE TABLE `t_edema` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//水肿',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_edema` */

insert  into `t_edema`(`id`,`serial_no`,`name`,`create_time`) values (1,'20170823274-6','水肿','2017-08-23 22:20:27');

/*Table structure for table `t_expectoration` */

DROP TABLE IF EXISTS `t_expectoration`;

CREATE TABLE `t_expectoration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL COMMENT '//序列号',
  `expectoration_color` tinyint(4) NOT NULL COMMENT '//咳痰颜色',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//记录创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_expectoration` */

insert  into `t_expectoration`(`id`,`serial_no`,`expectoration_color`,`create_time`) values (1,'20170625223-6',2,'2017-06-25 16:50:10'),(2,'20170626226-6',2,'2017-06-26 23:11:39'),(3,'20170628227-6',2,'2017-06-28 22:45:18'),(4,'20170824275-6',2,'2017-08-24 23:28:45');

/*Table structure for table `t_family_history` */

DROP TABLE IF EXISTS `t_family_history`;

CREATE TABLE `t_family_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `a_similar_disease` int(20) NOT NULL COMMENT '//1.有类似疾病；2.没有类似疾病；',
  `similar_disease_name` varchar(300) DEFAULT NULL COMMENT '//类似疾病名称',
  `hereditary_disease` int(20) NOT NULL COMMENT '//1.有遗传性疾病；2.没有遗传性疾病；',
  `hereditary_disease_name` varchar(300) DEFAULT NULL COMMENT '//遗传性疾病名称；',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_family_history` */

/*Table structure for table `t_fat` */

DROP TABLE IF EXISTS `t_fat`;

CREATE TABLE `t_fat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `now_weight` double NOT NULL COMMENT '//当前体重',
  `height` double NOT NULL COMMENT '//身高',
  `BMI` double NOT NULL COMMENT '//体质量指数BMI',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_fat` */

insert  into `t_fat`(`id`,`serial_no`,`now_weight`,`height`,`BMI`,`create_time`) values (1,'20170625223-6',67,1.6,26.17,'2017-06-25 17:15:32'),(2,'20170824275-6',56,1.7,19.38,'2017-08-24 23:28:46');

/*Table structure for table `t_fever` */

DROP TABLE IF EXISTS `t_fever`;

CREATE TABLE `t_fever` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '//主键id',
  `serial_no` varchar(32) NOT NULL COMMENT '//序列号',
  `highest_degree` double NOT NULL COMMENT '//最高体温',
  `lowest_degree` double NOT NULL COMMENT '//最低体温',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//记录创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_fever` */

insert  into `t_fever`(`id`,`serial_no`,`highest_degree`,`lowest_degree`,`create_time`) values (1,'201706252236',38.4,37.6,'2017-06-25 09:32:44'),(2,'20170626226-6',37.8,36,'2017-06-26 23:11:39'),(3,'20170628227-6',37.9,36.6,'2017-06-28 22:45:18');

/*Table structure for table `t_haematemesis` */

DROP TABLE IF EXISTS `t_haematemesis`;

CREATE TABLE `t_haematemesis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//呕血',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_haematemesis` */

/*Table structure for table `t_hematochezia` */

DROP TABLE IF EXISTS `t_hematochezia`;

CREATE TABLE `t_hematochezia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `hematochezia_color` tinyint(4) NOT NULL COMMENT '//便血颜色 0.暗红色  1.鲜红色；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_hematochezia` */

insert  into `t_hematochezia`(`id`,`serial_no`,`hematochezia_color`,`create_time`) values (1,'20170625223-6',2,'2017-06-25 17:14:11');

/*Table structure for table `t_hemoptysis` */

DROP TABLE IF EXISTS `t_hemoptysis`;

CREATE TABLE `t_hemoptysis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//咯血',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_hemoptysis` */

/*Table structure for table `t_infection_history` */

DROP TABLE IF EXISTS `t_infection_history`;

CREATE TABLE `t_infection_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `infection_type` int(20) DEFAULT NULL COMMENT '//传染病类型 1.乙肝病；2.结核病；',
  `hepatitis_B` int(20) NOT NULL COMMENT '//是否有乙肝病；1.有；0.没有',
  `tuberculosis` int(20) NOT NULL COMMENT '//是否有结核病；1.有；0.没有；',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_infection_history` */

/*Table structure for table `t_login_log` */

DROP TABLE IF EXISTS `t_login_log`;

CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_account` varchar(50) DEFAULT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `login_ip` varchar(50) DEFAULT NULL,
  `login_message` varchar(100) DEFAULT NULL COMMENT '登陆提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_login_log` */

/*Table structure for table `t_main_suit` */

DROP TABLE IF EXISTS `t_main_suit`;

CREATE TABLE `t_main_suit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '//主键id',
  `serial_no` varchar(32) NOT NULL COMMENT '//基本信息编号',
  `main_suit_content` varchar(32) NOT NULL COMMENT '//主诉内容',
  `main_suit_value` int(11) NOT NULL COMMENT '//主诉枚举值',
  `attack_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//发病时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//更新时间',
  `account_id` bigint(20) NOT NULL COMMENT '//账户id',
  PRIMARY KEY (`id`),
  FULLTEXT KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `t_main_suit` */

insert  into `t_main_suit`(`id`,`serial_no`,`main_suit_content`,`main_suit_value`,`attack_time`,`create_time`,`update_time`,`account_id`) values (1,'20170526193','-----咯血-----',17,'2017-05-11 00:00:00','2017-05-26 23:09:48','2017-05-26 23:09:49',0),(2,'20170531197','-----咳痰-----',3,'2017-05-11 00:00:00','2017-05-31 23:38:40','2017-05-31 23:38:41',0),(3,'20170601198','-----疼痛-----',15,'2017-02-03 00:00:00','2017-06-01 22:56:52','2017-06-01 22:56:53',0),(10,'20170602203','-----便秘-----',6,'2017-05-26 00:00:00','2017-06-02 21:39:07','2017-06-02 21:39:07',6),(11,'20170623221','-----咳嗽-----',2,'2017-02-02 00:00:00','2017-06-23 23:23:15','2017-06-23 23:23:15',6),(12,'20170624222','-----咳嗽-----',2,'2017-06-01 00:00:00','2017-06-24 08:28:37','2017-06-24 08:28:38',6),(13,'20170624222','-----咳痰-----',3,'2017-06-02 00:00:00','2017-06-24 08:28:37','2017-06-24 08:28:38',6),(15,'20170625223','-----咳嗽-----',2,'2017-06-08 00:00:00','2017-06-25 09:32:05','2017-06-25 09:32:06',6),(16,'20170626226','-----呕吐-----',4,'2017-06-01 00:00:00','2017-06-26 23:10:54','2017-06-26 23:10:54',6),(17,'20170626226','-----咳痰-----',3,'2017-06-02 00:00:00','2017-06-26 23:10:54','2017-06-26 23:10:54',6),(19,'20170630229','-----头晕-----',10,'2017-06-01 00:00:00','2017-06-30 23:10:00','2017-06-30 23:10:01',6),(20,'20170702230','-----便血-----',7,'2017-01-04 00:00:00','2017-07-02 15:51:48','2017-07-02 15:51:49',6),(21,'20170709231','-----少尿-----',12,'2017-07-01 00:00:00','2017-07-09 11:58:02','2017-07-09 11:58:02',6),(22,'20170801247','-----便秘-----',6,'2017-07-21 00:00:00','2017-08-01 20:37:31','2017-08-01 20:37:31',6),(23,'20170804251','-----以上都不是-----',24,'2017-08-04 00:00:00','2017-08-04 22:06:41','2017-08-04 22:06:41',10),(24,'20170804251','-----腹泻-----',5,'2017-08-04 00:00:00','2017-08-04 22:06:41','2017-08-04 22:06:41',10),(26,'20170806265','-----咳痰-----',3,'2017-08-02 00:00:00','2017-08-06 21:40:26','2017-08-06 21:40:26',6),(27,'20170823274','-----少尿-----',12,'2017-08-04 00:00:00','2017-08-23 22:19:23','2017-08-23 22:19:24',6),(28,'20170823274','-----腹泻-----',5,'2017-08-05 00:00:00','2017-08-23 22:19:23','2017-08-23 22:19:24',6),(29,'20170824275','-----呕吐-----',4,'2017-08-02 00:00:00','2017-08-24 23:27:56','2017-08-24 23:27:57',6),(31,'20170827277','-----腹泻-----',5,'2017-08-03 00:00:00','2017-08-27 10:51:47','2017-08-27 10:51:47',6),(32,'20170827278','-----腹泻-----',5,'2017-08-03 00:00:00','2017-08-27 18:07:01','2017-08-27 18:07:02',13);

/*Table structure for table `t_marasmus` */

DROP TABLE IF EXISTS `t_marasmus`;

CREATE TABLE `t_marasmus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `now_weight` double NOT NULL COMMENT '//当前体重',
  `height` double NOT NULL COMMENT '//身高',
  `BMI` double NOT NULL COMMENT '//体质量指数BMI',
  `weight_down_wthin_half_year` double NOT NULL COMMENT '//半年内体重减轻',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_marasmus` */

insert  into `t_marasmus`(`id`,`serial_no`,`now_weight`,`height`,`BMI`,`weight_down_wthin_half_year`,`create_time`) values (1,'20170625223-6',66,1.7,22.84,5,'2017-06-25 17:16:44');

/*Table structure for table `t_marry_history` */

DROP TABLE IF EXISTS `t_marry_history`;

CREATE TABLE `t_marry_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `marry_type` int(20) NOT NULL COMMENT '//1.已婚；3.未婚；',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_marry_history` */

/*Table structure for table `t_medical_history_review` */

DROP TABLE IF EXISTS `t_medical_history_review`;

CREATE TABLE `t_medical_history_review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `not_yet_been_cured` int(20) NOT NULL COMMENT '//有无尚未治愈的疾病；1.有；0.没有',
  `happend_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//有尚未治愈的疾病，发生时间；',
  `illness_name` varchar(32) DEFAULT NULL COMMENT '//疾病名称，以逗号分割；',
  `drugs_taken` int(20) NOT NULL COMMENT '//有无正在服用的药物；1.有；0.没有',
  `drugs_taken_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//正在服用药物开始时间；',
  `drugs_name` varchar(32) DEFAULT NULL COMMENT '//药物名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_medical_history_review` */

/*Table structure for table `t_menstrual_history` */

DROP TABLE IF EXISTS `t_menstrual_history`;

CREATE TABLE `t_menstrual_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_menstrual_period` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//上次来月经日期',
  `first_menstrual_age` int(20) NOT NULL COMMENT '//第一次月经年龄;1-30岁',
  `how_many_day_menstrual` int(20) NOT NULL COMMENT '//月经多少天;1-30天',
  `two_menstrual_intervals` int(20) NOT NULL COMMENT '//两次月经间隔(1-30天)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_menstrual_history` */

insert  into `t_menstrual_history`(`id`,`serial_no`,`create_time`,`last_menstrual_period`,`first_menstrual_age`,`how_many_day_menstrual`,`two_menstrual_intervals`) values (1,'20170827277-6','2017-08-27 10:52:13','2006-08-03 00:00:00',14,3,12),(2,'20170827278-13','2017-08-27 18:08:15','2005-08-06 00:00:00',12,3,14);

/*Table structure for table `t_micturition` */

DROP TABLE IF EXISTS `t_micturition`;

CREATE TABLE `t_micturition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `micturition_symptom` tinyint(4) NOT NULL COMMENT '//排尿相关症状 0.尿失禁 ；1.尿量困难',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_micturition` */

insert  into `t_micturition`(`id`,`serial_no`,`micturition_symptom`,`create_time`) values (1,'20170625223-6',2,'2017-06-25 17:53:22');

/*Table structure for table `t_not_all_above` */

DROP TABLE IF EXISTS `t_not_all_above`;

CREATE TABLE `t_not_all_above` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '//以上都不是；',
  `other_problem` varchar(32) DEFAULT NULL COMMENT '//其他问题',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_not_all_above` */

insert  into `t_not_all_above`(`id`,`serial_no`,`name`,`other_problem`,`create_time`) values (1,'20170709231-6','以上都不是','ffffffff','2017-07-09 12:14:44');

/*Table structure for table `t_oliguresis` */

DROP TABLE IF EXISTS `t_oliguresis`;

CREATE TABLE `t_oliguresis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `UPD_symptom` int(20) NOT NULL COMMENT '//尿量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_oliguresis` */

insert  into `t_oliguresis`(`id`,`serial_no`,`UPD_symptom`,`create_time`) values (1,'20170625223-6',54,'2017-06-25 17:37:04');

/*Table structure for table `t_operation_history` */

DROP TABLE IF EXISTS `t_operation_history`;

CREATE TABLE `t_operation_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `operation_type` int(20) NOT NULL COMMENT '//是否有过手术历史1 做过；0.没做过',
  `operation_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '//手术时间',
  `operation_name` varchar(300) DEFAULT NULL COMMENT '//手术名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_operation_history` */

/*Table structure for table `t_other_symptoms` */

DROP TABLE IF EXISTS `t_other_symptoms`;

CREATE TABLE `t_other_symptoms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `how_the_mind` int(20) NOT NULL COMMENT '//精神如何0.表示一般；1.表示差',
  `how_the_appetite` int(20) NOT NULL COMMENT '//食欲如何0.表示一般；1.表示差',
  `how_the_sleep` int(20) NOT NULL COMMENT '//睡眠如何0.表示一般；1.表示差',
  `least_half_year_weight_change_type` int(20) NOT NULL COMMENT '//最近半年体重变化如何0.表示无明显变化 1.表示变化较大',
  `least_half_year_weight_down` double DEFAULT NULL COMMENT '//半年内减轻多少千克',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_other_symptoms` */

insert  into `t_other_symptoms`(`id`,`serial_no`,`create_time`,`how_the_mind`,`how_the_appetite`,`how_the_sleep`,`least_half_year_weight_change_type`,`least_half_year_weight_down`) values (1,'20170801247','2017-08-01 20:43:18',1,1,2,1,NULL),(3,'20170806265-6','2017-08-06 21:05:48',1,1,1,1,NULL),(5,'20170827278-13','2017-08-27 18:07:40',1,1,1,1,NULL);

/*Table structure for table `t_other_upd_symptom` */

DROP TABLE IF EXISTS `t_other_upd_symptom`;

CREATE TABLE `t_other_upd_symptom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `UPD_symptom` tinyint(4) NOT NULL COMMENT '//尿量症状；0.尿频 尿急 尿痛；1.多尿 2.无尿',
  `diuresis_UPD` int(20) DEFAULT NULL COMMENT '//多尿尿量',
  `anuria_UPD` int(20) DEFAULT NULL COMMENT '//无尿尿量  都是以毫升为单位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_other_upd_symptom` */

insert  into `t_other_upd_symptom`(`id`,`serial_no`,`UPD_symptom`,`diuresis_UPD`,`anuria_UPD`,`create_time`) values (1,'20170625223-6',3,NULL,333,'2017-06-25 17:49:20');

/*Table structure for table `t_pain` */

DROP TABLE IF EXISTS `t_pain`;

CREATE TABLE `t_pain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `pain_type` tinyint(4) NOT NULL COMMENT '疼痛类型；0.头疼 1.牙痛 2.腰背痛 3.关节痛  4.痛经 5.腹痛',
  `pain_start_time` timestamp NULL DEFAULT NULL COMMENT '腹痛开始时间',
  `pain_continuous_or_Intermittent` tinyint(4) DEFAULT NULL COMMENT '//腹痛是持续性还是间歇性；',
  `relationship_between_eating_and_eating` tinyint(4) DEFAULT NULL COMMENT '//间歇性与进食关系如何',
  `pain_property` tinyint(4) DEFAULT NULL COMMENT '//腹痛疼痛性质',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_pain` */

insert  into `t_pain`(`id`,`serial_no`,`pain_type`,`pain_start_time`,`pain_continuous_or_Intermittent`,`relationship_between_eating_and_eating`,`pain_property`,`create_time`) values (1,'20170625223-6',4,NULL,0,0,0,'2017-06-25 17:54:28'),(2,'20170823274-6',3,NULL,0,0,0,'2017-08-23 22:20:27'),(3,'20170824275-6',4,NULL,0,0,0,'2017-08-24 23:28:46');

/*Table structure for table `t_palpitation` */

DROP TABLE IF EXISTS `t_palpitation`;

CREATE TABLE `t_palpitation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//心悸',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_palpitation` */

insert  into `t_palpitation`(`id`,`serial_no`,`name`,`create_time`) values (1,'20170823274-6','心悸','2017-08-23 22:20:27');

/*Table structure for table `t_person_history` */

DROP TABLE IF EXISTS `t_person_history`;

CREATE TABLE `t_person_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `smoking_type` int(20) NOT NULL COMMENT '//1.从来不吸烟；2.现在已经戒烟；3.目前尚未戒烟；',
  `not_smoking_year` int(20) DEFAULT NULL COMMENT '//已经戒烟多少年',
  `has_smoking_year` int(20) DEFAULT NULL COMMENT '//曾经吸烟多少年',
  `how_many_cigarette_each_day` int(20) DEFAULT NULL COMMENT '//平均一天多少支',
  `drink_type` int(20) NOT NULL COMMENT '//1.从来不喝；2.现在已经戒酒；3.目前尚未戒酒；',
  `not_drink_year` int(20) DEFAULT NULL COMMENT '//已经戒酒多少年',
  `alcohol_type` int(20) DEFAULT NULL COMMENT '//1.啤酒；2.黄酒；3.白酒；',
  `has_drink_year` int(20) DEFAULT NULL COMMENT '//已经喝酒的年限；',
  `how_many_drink_each_day` int(20) DEFAULT NULL COMMENT '//平均一天多少两',
  `has_life_epidemic_area` int(20) NOT NULL COMMENT '//是否在疫区生活过；1.有；2.没有；',
  `epidemic_area_place` varchar(32) DEFAULT NULL COMMENT '//到过哪里生活',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_person_history` */

/*Table structure for table `t_self_description` */

DROP TABLE IF EXISTS `t_self_description`;

CREATE TABLE `t_self_description` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `description` text NOT NULL COMMENT '//自我描述内容',
  `name` varchar(32) NOT NULL COMMENT '//以上都不是，让我自己描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_self_description` */

/*Table structure for table `t_serialno` */

DROP TABLE IF EXISTS `t_serialno`;

CREATE TABLE `t_serialno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '//主键id',
  `serial_no` bigint(20) NOT NULL COMMENT '//序列号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_serialno` */

insert  into `t_serialno`(`id`,`serial_no`,`create_time`) values (1,279,'2017-05-20 20:49:18');

/*Table structure for table `t_tic_and_convulsion` */

DROP TABLE IF EXISTS `t_tic_and_convulsion`;

CREATE TABLE `t_tic_and_convulsion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '//抽搐与惊厥',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_tic_and_convulsion` */

insert  into `t_tic_and_convulsion`(`id`,`serial_no`,`name`,`create_time`) values (1,'20170823274-6','抽搐与惊厥','2017-08-23 22:20:27'),(2,'20170827278-13','抽搐与惊厥','2017-08-27 18:07:27');

/*Table structure for table `t_vomit` */

DROP TABLE IF EXISTS `t_vomit`;

CREATE TABLE `t_vomit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) NOT NULL,
  `vomit_type` tinyint(4) NOT NULL COMMENT '//呕吐类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '//记录创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialNo` (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_vomit` */

insert  into `t_vomit`(`id`,`serial_no`,`vomit_type`,`create_time`) values (1,'20170625223-6',2,'2017-06-25 16:53:57'),(2,'20170626226-6',2,'2017-06-26 23:11:39'),(3,'20170628227-6',1,'2017-06-28 22:45:18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
