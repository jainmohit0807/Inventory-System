/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`inventory` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inventory`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `CustomerId` varchar(6) default NULL,
  `CustomerName` varchar(25) default NULL,
  `Address` varchar(50) default NULL,
  `CNIC` varchar(15) default NULL,
  `PhoneNo` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`CustomerId`,`CustomerName`,`Address`,`CNIC`,`PhoneNo`) values ('581935','Vivek bansal','jaipur','safdSasaxs','7845120369'),('255479','Chetani','jaipur','142321','7412589630'),('854763','Shubham','Goa','4412554458','7412554458'),('683245','Mohit jain','Agra','4512369870','7412589630');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `InvoiceID` varchar(6) default NULL,
  `Date` varchar(20) default NULL,
  `CustomerName` varchar(25) default NULL,
  `ProductName` varchar(26) default NULL,
  `Quantity` varchar(8) default NULL,
  `UnitPrice` varchar(8) default NULL,
  `PaymentMode` varchar(25) default NULL,
  `Total` varchar(10) default NULL,
  `Remaining` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

insert  into `invoice`(`InvoiceID`,`Date`,`CustomerName`,`ProductName`,`Quantity`,`UnitPrice`,`PaymentMode`,`Total`,`Remaining`) values ('377632','30.05.2017','Shubham','Redmi 3s','2','7000','Netbanking','14000',0);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `Username` varchar(25) default NULL,
  `Password` varchar(25) default NULL,
  `Usertype` varchar(25) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`Username`,`Password`,`Usertype`) values ('MJ','abc123','Admin'),('A','abc123','Employee'),('MJ1','abc123','Admin');

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `PurchaseID` varchar(8) default NULL,
  `Date` varchar(15) default NULL,
  `SupplierName` varchar(50) default NULL,
  `ProductName` varchar(50) default NULL,
  `Quantity` varchar(8) default NULL,
  `UnitPrice` varchar(8) default NULL,
  `PaymentMode` varchar(15) default NULL,
  `Total` varchar(10) default NULL,
  `Remaining` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase` */

insert  into `purchase`(`PurchaseID`,`Date`,`SupplierName`,`ProductName`,`Quantity`,`UnitPrice`,`PaymentMode`,`Total`,`Remaining`) values ('147698','30.05.2017','Mayank','Redmi 3s','5','7000','Cash','35000',0);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `ProductID` varchar(6) default NULL,
  `ProductName` varchar(100) default NULL,
  `Detail` varchar(400) default NULL,
  `Price` varchar(8) default NULL,
  `Quantity` varchar(8) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stock` */

insert  into `stock`(`ProductID`,`ProductName`,`Detail`,`Price`,`Quantity`) values ('883821','Nokia 2626','Mobile phone','2000','0'),('612337','Redmi 3s','Mobile Phone','7000','3'),('472681','Samsung Note 3','Mobile phone','10000','0'),('914479','Moto E','Mobile Phone','5000','0'),('517722','Micromax Unite 3','Mobile phone','5800','0'),('888727','Surf Excel','Detergent','100','0'),('664146','Tide','Detergent','100','0');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `SupplierId` varchar(6) default NULL,
  `SupplierName` varchar(25) default NULL,
  `Address` varchar(50) default NULL,
  `CNIC` varchar(15) default NULL,
  `PhoneNo` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `supplier` */

insert  into `supplier`(`SupplierId`,`SupplierName`,`Address`,`CNIC`,`PhoneNo`) values ('894278','Mayank','Agra','1124569873','7412589630');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserId` varchar(6) default NULL,
  `Username` varchar(25) default NULL,
  `Usertype` varchar(15) default NULL,
  `Email` varchar(50) default NULL,
  `ContactNo` varchar(15) default NULL,
  `Address` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`UserId`,`Username`,`Usertype`,`Email`,`ContactNo`,`Address`) values ('375734','MJ','Employee','jainmohit0807@gmail.com','7073590355','Agra');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
