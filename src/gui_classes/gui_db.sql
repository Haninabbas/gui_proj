-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema project_gui
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project_gui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project_gui` DEFAULT CHARACTER SET utf8 ;
USE `project_gui` ;

-- -----------------------------------------------------
-- Table `project_gui`.`Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Services` (
  `Service_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Service_name` VARCHAR(45) NULL,
  PRIMARY KEY (`Service_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `project_gui`.`Client_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Client_info` (
  `Clinet_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Clinet_FirstName` VARCHAR(45) NULL,
  `Client_LastName` VARCHAR(45) NULL,
  `Client_Email` VARCHAR(45) NULL,
  `Client_pass` VARCHAR(45) NULL,
  `Client_phonenum` VARCHAR(45) NULL,
  `Client_gender` VARCHAR(45) NULL,
  `Location` VARCHAR(45) NULL,
  `C_image` LONGBLOB NULL,
  PRIMARY KEY (`Clinet_id`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `project_gui`.`Employee_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Employee_info` (
  `Employee_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Employee_FirstName` VARCHAR(45) NULL,
  `Employee_LastName` VARCHAR(45) NULL,
  `Employee_Email` VARCHAR(45) NULL,
  `Employee_pass` VARCHAR(45) NULL,
  `Employee_phonenum` VARCHAR(45) NULL,
  `Employee_gender` VARCHAR(45) NULL,
  `Employee_Birthdate` DATETIME NULL,
  `Location` VARCHAR(45) NULL,
  `Services_Service_id` INT UNSIGNED NOT NULL,
  `E_image` LONGBLOB NULL,

  PRIMARY KEY (`Employee_id`, `Services_Service_id`),
  CONSTRAINT `fk_Employee_info_Services1`
    FOREIGN KEY (`Services_Service_id`)
    REFERENCES `project_gui`.`Services` (`Service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Employee_info_Services1_idx` ON `project_gui`.`Employee_info` (`Services_Service_id` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `project_gui`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Admin` (
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NULL,
  PRIMARY KEY (`UserName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project_gui`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Booking` (
  `Booking_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `TimeSpent` DATETIME NULL,
  `Client_info_Clinet_id` INT UNSIGNED NOT NULL,
  `Services_Service_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Booking_id`, `Client_info_Clinet_id`, `Services_Service_id`),
  CONSTRAINT `fk_Booking_Client_info`
    FOREIGN KEY (`Client_info_Clinet_id`)
    REFERENCES `project_gui`.`Client_info` (`Clinet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Services1`
    FOREIGN KEY (`Services_Service_id`)
    REFERENCES `project_gui`.`Services` (`Service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Booking_Client_info_idx` ON `project_gui`.`Booking` (`Client_info_Clinet_id` ASC) VISIBLE;

CREATE INDEX `fk_Booking_Services1_idx` ON `project_gui`.`Booking` (`Services_Service_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`Payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Payment` (
  `Payment_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Admin_UserName` VARCHAR(45) NOT NULL,
  `Booking_Booking_id` INT UNSIGNED NOT NULL,
  `Booking_Client_info_Clinet_id` INT UNSIGNED NOT NULL,
  `Booking_Services_Service_id` INT UNSIGNED NOT NULL,
  `Employee_info_Employee_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Payment_id`, `Admin_UserName`, `Booking_Booking_id`, `Booking_Client_info_Clinet_id`, `Booking_Services_Service_id`, `Employee_info_Employee_id`),
  CONSTRAINT `fk_Payment_Admin1`
    FOREIGN KEY (`Admin_UserName`)
    REFERENCES `project_gui`.`Admin` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Booking1`
    FOREIGN KEY (`Booking_Booking_id` , `Booking_Client_info_Clinet_id` , `Booking_Services_Service_id`)
    REFERENCES `project_gui`.`Booking` (`Booking_id` , `Client_info_Clinet_id` , `Services_Service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Employee_info1`
    FOREIGN KEY (`Employee_info_Employee_id`)
    REFERENCES `project_gui`.`Employee_info` (`Employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Payment_Admin1_idx` ON `project_gui`.`Payment` (`Admin_UserName` ASC) VISIBLE;

CREATE INDEX `fk_Payment_Booking1_idx` ON `project_gui`.`Payment` (`Booking_Booking_id` ASC, `Booking_Client_info_Clinet_id` ASC, `Booking_Services_Service_id` ASC) VISIBLE;

CREATE INDEX `fk_Payment_Employee_info1_idx` ON `project_gui`.`Payment` (`Employee_info_Employee_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Rating` (
  `Rating_id` INT NOT NULL,
  `rating` VARCHAR(45) NULL,
  `Client_info_Clinet_id` INT UNSIGNED NOT NULL,
  `Services_Service_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Rating_id`, `Client_info_Clinet_id`, `Services_Service_id`),
  CONSTRAINT `fk_Rating_Client_info1`
    FOREIGN KEY (`Client_info_Clinet_id`)
    REFERENCES `project_gui`.`Client_info` (`Clinet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rating_Services1`
    FOREIGN KEY (`Services_Service_id`)
    REFERENCES `project_gui`.`Services` (`Service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Rating_Client_info1_idx` ON `project_gui`.`Rating` (`Client_info_Clinet_id` ASC) VISIBLE;

CREATE INDEX `fk_Rating_Services1_idx` ON `project_gui`.`Rating` (`Services_Service_id` ASC) VISIBLE;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


ALTER TABLE employee_info MODIFY Employee_Birthdate Date  ;

DELIMITER $$
create procedure addEmployee_info(in Employee_FirstName varchar(45),in Employee_LastName varchar(45),
Employee_Email VARCHAR(45),Employee_pass VARCHAR(45),
Employee_phonenum VARCHAR(45),Employee_gender VARCHAR(45),Employee_Birthdate DATETIME,Location VARCHAR(45),in Services_Service_id Int,E_image LONGBLOB)
begin
insert into Employee_info(Employee_FirstName,Employee_LastName,Employee_Email,Employee_pass,Employee_phonenum,Employee_gender,Employee_Birthdate,Location,Services_Service_id,E_image)
values(Employee_FirstName,Employee_LastName,Employee_Email,Employee_pass,Employee_phonenum,Employee_gender,Employee_Birthdate,Location,Services_Service_id,E_image);
end $$
DELIMITER ;
DELIMITER $$
 create procedure add_service(in Service_id int,in Service_name varchar(45))
 begin
 insert into Services (Service_id,Service_name)
 values(Service_id,Service_name);
 end $$
 DELIMITER ;



DELIMITER $$
create procedure addClient_info(in Clinet_FirstName varchar(45),in client_LastName varchar(45),
Client_Email VARCHAR(45),Client_pass VARCHAR(45),
Client_phonenum VARCHAR(45),Client_gender VARCHAR(45),Location VARCHAR(45),C_image LONGBLOB)
begin
insert into Client_info(Clinet_FirstName,client_LastName,Client_Email,client_pass,Client_phonenum,Client_gender,Location,C_image)
values(Clinet_FirstName,client_LastName,Client_Email,client_pass,Client_phonenum,Client_gender,Location,C_image);
end $$
DELIMITER ;



  DELIMITER $$
  create procedure add_admin(in UserName varchar(45),in Password varchar(45))
  begin
  insert into Admin (UserName,Password)
  values(UserName,Password);
  end $$
  DELIMITER ;



ALTER TABLE Client_info RENAME COLUMN Clinet_id TO Client_id;

 DELIMITER $$
 create procedure delete_client(in client_id int)
 begin
 delete from Client_info where Clinet_id=client_id;
 delete from Booking where Booking.Client_info_Clinet_id=client_id;
 delete from rating where rating.Client_info_Clinet_id=client_id;
 end $$
 DELIMITER ;
 drop procedure delete_client;
 call  delete_client(1);

DELIMITER $$
CREATE PROCEDURE updateCFname
(in cid int,
in fname varchar(45))
begin
update Client_info
set
Client_FirstName=fname
where Client_info.Client_id=cid;
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE updateCLname
(in cid int,
in cname varchar(45))
begin
update Client_info
set
Client_LastName=cname
where Client_info.Client_id=cid;
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE update_email
(in cid int,
in email varchar(45))
begin
update Client_info
set
Client_Email=email
where Client_info.Client_id=cid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_gender
(in cid int,
in gender varchar(45))
begin
update Client_info
set
Client_gender=gender
where Client_info.Client_id=cid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_location
(in cid int,
in location varchar(45))
begin
update Client_info
set
Location=location
where Client_info.Client_id=cid;
end $$
DELIMITER ;


 DELIMITER $$
CREATE PROCEDURE update_phonenum
(in cid int,
in num varchar(45))
begin
update Client_info
set
Client_phonenum=num
where Client_info.Client_id=cid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatePass
(in cid int,
in pass varchar(45))
begin
update Client_info
set
Client_pass=pass
where Client_info.Client_id=cid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_image
(in cid int,
in image blob)
begin
update Client_info
set
C_image=image
where Client_info.Client_id=cid;
end $$
DELIMITER ;





 DELIMITER $$
 create procedure delete_employee(in employee_id int)
 begin
 delete from Employee_info where Employee_info.Employee_id=employee_id;
end $$
DELIMITER ;
call delete_employee(1);


DELIMITER $$
CREATE PROCEDURE update_eimage
(in eid int,
in image blob)
begin
update Employee_info
set
E_image=image
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE updateEFname
(in eid int,
in fname varchar(45))
begin
update Employee_info
set
Employee_FirstName=fname
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateELname
(in eid int,
in lname varchar(45))
begin
update Employee_info
set
Employee_LastName=lname
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatephonenum
(in eid int,
in num varchar(45))
begin
update Employee_info
set
Employee_phonenum=num
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_birthdate
(in eid int,
in birthdate date)
begin
update Employee_info
set
Employee_Birthdate=birthdate
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_Elocation
(in eid int,
in location varchar(45))
begin
update Employee_info
set
Location=location
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_Egender
(in eid int,
in gender varchar(45))
begin
update Employee_info
set
Employee_gender=gender
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_Epass
(in eid int,
in pass varchar(45))
begin
update Employee_info
set
Employee_pass=pass
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_EEmail
(in eid int,
in Email varchar(45))
begin
update Employee_info
set
Employee_Email=Email
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_service
(in eid int,
in service_id varchar(45))
begin
update Employee_info
set
Services_Service_id=service_id
where Employee_info.Employee_id=eid;
end $$
DELIMITER ;

call add_admin("admin","admin");


call addClient_info("safaa","diab","safaa.diab@gmail.com","1234","71-147258","female","baalback",null);

call addEmployee_info("hanin","abbas","hanin.abbas@gmail.com","123456","03-123456","female","1991-12-12","hamra street",1,'null');
call addEmployee_info("ali","abbas","ali.abbas@gmail.com","123456","03-147523","male","1992-12-12","hamra street",2,load_file('D:\logo-png-clipart-17.jpg'));

 call add_service(1,"BabySitter_service");
 call add_service(2,"PrivateTutor_service");

delete from   Employee_info where Employee_id=1;

drop table services_has_employee_info;


select*from Services;
select*from Booking;
select*from Employee_info;
select *from Client_info;
select*from Payment;
select*from Rating;
select*from Admin;

SHOW GRANTS FOR 'admin'@'localhost';
 select user(), current_user();