-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema project_gui
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `project_gui` ;

-- -----------------------------------------------------
-- Schema project_gui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project_gui` DEFAULT CHARACTER SET utf8 ;
USE `project_gui` ;

-- -----------------------------------------------------
-- Table `project_gui`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Person` (
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `email` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `image` BLOB NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `project_gui`.`Person` (`username` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`Client` (
  `idclient` INT NOT NULL AUTO_INCREMENT,
  `servicetype` VARCHAR(45) NULL,
  `Person_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idclient`),
  CONSTRAINT `fk_Client_Person`
    FOREIGN KEY (`Person_username`)
    REFERENCES `project_gui`.`Person` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `project_gui`.`Client` (`idclient` ASC) VISIBLE;

CREATE INDEX `fk_Client_Person_idx` ON `project_gui`.`Client` (`Person_username` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`admin` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `Person_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadmin`),
  CONSTRAINT `fk_admin_Person1`
    FOREIGN KEY (`Person_username`)
    REFERENCES `project_gui`.`Person` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idadmin_UNIQUE` ON `project_gui`.`admin` (`idadmin` ASC) VISIBLE;

CREATE INDEX `fk_admin_Person1_idx` ON `project_gui`.`admin` (`Person_username` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`BabySitter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`BabySitter` (
  `idBabySitter` INT NOT NULL,
  `price_hour` DOUBLE NOT NULL,
  `Person_username` VARCHAR(45) NOT NULL,
  `admin_idadmin` INT NOT NULL,
  PRIMARY KEY (`idBabySitter`),
  CONSTRAINT `fk_BabySitter_Person1`
    FOREIGN KEY (`Person_username`)
    REFERENCES `project_gui`.`Person` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BabySitter_admin1`
    FOREIGN KEY (`admin_idadmin`)
    REFERENCES `project_gui`.`admin` (`idadmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_BabySitter_Person1_idx` ON `project_gui`.`BabySitter` (`Person_username` ASC) VISIBLE;

CREATE INDEX `fk_BabySitter_admin1_idx` ON `project_gui`.`BabySitter` (`admin_idadmin` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`sitter_payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`sitter_payment` (
  `idsitter_payment` INT NOT NULL AUTO_INCREMENT,
  `paid` INT NULL,
  `recieved_sitter` INT NULL,
  `recieved_admin` INT NULL,
  `Client_idclient` INT NOT NULL,
  `admin_idadmin` INT NOT NULL,
  `BabySitter_idBabySitter` INT NOT NULL,
  PRIMARY KEY (`idsitter_payment`),
  CONSTRAINT `fk_sitter_payment_Client1`
    FOREIGN KEY (`Client_idclient`)
    REFERENCES `project_gui`.`Client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sitter_payment_admin1`
    FOREIGN KEY (`admin_idadmin`)
    REFERENCES `project_gui`.`admin` (`idadmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sitter_payment_BabySitter1`
    FOREIGN KEY (`BabySitter_idBabySitter`)
    REFERENCES `project_gui`.`BabySitter` (`idBabySitter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_sitter_payment_Client1_idx` ON `project_gui`.`sitter_payment` (`Client_idclient` ASC) VISIBLE;

CREATE INDEX `fk_sitter_payment_admin1_idx` ON `project_gui`.`sitter_payment` (`admin_idadmin` ASC) VISIBLE;

CREATE INDEX `fk_sitter_payment_BabySitter1_idx` ON `project_gui`.`sitter_payment` (`BabySitter_idBabySitter` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`SitterBooking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`SitterBooking` (
  `idSitterBooking` INT NOT NULL AUTO_INCREMENT,
  `Request` TINYINT NULL,
  `date` DATE NULL,
  `Client_idclient` INT NOT NULL,
  `BabySitter_idBabySitter` INT NOT NULL,
  `sitter_payment_idsitter_payment` INT NOT NULL,
  PRIMARY KEY (`idSitterBooking`),
  CONSTRAINT `fk_SitterBooking_Client1`
    FOREIGN KEY (`Client_idclient`)
    REFERENCES `project_gui`.`Client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SitterBooking_BabySitter1`
    FOREIGN KEY (`BabySitter_idBabySitter`)
    REFERENCES `project_gui`.`BabySitter` (`idBabySitter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SitterBooking_sitter_payment1`
    FOREIGN KEY (`sitter_payment_idsitter_payment`)
    REFERENCES `project_gui`.`sitter_payment` (`idsitter_payment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idSitterBooking_UNIQUE` ON `project_gui`.`SitterBooking` (`idSitterBooking` ASC) VISIBLE;

CREATE INDEX `fk_SitterBooking_Client1_idx` ON `project_gui`.`SitterBooking` (`Client_idclient` ASC) VISIBLE;

CREATE INDEX `fk_SitterBooking_BabySitter1_idx` ON `project_gui`.`SitterBooking` (`BabySitter_idBabySitter` ASC) VISIBLE;

CREATE INDEX `fk_SitterBooking_sitter_payment1_idx` ON `project_gui`.`SitterBooking` (`sitter_payment_idsitter_payment` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `project_gui`.`SitterRating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_gui`.`SitterRating` (
  `idSitterRating` INT NOT NULL AUTO_INCREMENT,
  `stars` VARCHAR(45) NULL,
  `comment` MEDIUMTEXT NULL,
  `Client_idclient` INT NOT NULL,
  `BabySitter_idBabySitter` INT NOT NULL,
  PRIMARY KEY (`idSitterRating`),
  CONSTRAINT `fk_SitterRating_Client1`
    FOREIGN KEY (`Client_idclient`)
    REFERENCES `project_gui`.`Client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SitterRating_BabySitter1`
    FOREIGN KEY (`BabySitter_idBabySitter`)
    REFERENCES `project_gui`.`BabySitter` (`idBabySitter`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_SitterRating_Client1_idx` ON `project_gui`.`SitterRating` (`Client_idclient` ASC) VISIBLE;

CREATE INDEX `fk_SitterRating_BabySitter1_idx` ON `project_gui`.`SitterRating` (`BabySitter_idBabySitter` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-----------------------------------------------------


DELIMITER $$
create procedure addPerson(in username varchar(45),in name varchar(45),
in phone VARCHAR(45),in address VARCHAR(45),
in birthdate Date,in email VARCHAR(45),in gender varchar(45),in password VARCHAR(45),image BloB)
begin
insert into Person(username,name,phone,address,birthdate,email,gender,password,image)
values(username,name,phone,address,birthdate,email,gender,password,image);
end $$
DELIMITER ;

DELIMITER $$
create procedure addadmin(in Person_username varchar(45))
begin
insert into admin(Person_username)
values(Person_username);
end $$
DELIMITER ;

DELIMITER $$
create procedure addbabysitter(in price_hour Double,in Person_username varchar(45),in admin_idadmin int)
begin
insert into BabySitter(price_hour,Person_username,admin_idadmin)
values(price_hour,Person_username,admin_idadmin);
end $$
DELIMITER ;

DELIMITER $$
    create procedure addClient(in servicetype varchar(45),in Person_username varchar(45))
    begin
    insert into CLient(servicetype,Person_username)
    values(servicetype,Person_username);
    end$$
    DELIMITER ;

DELIMITER $$
create procedure addSitterRating(in Stars varchar(45),in comment MEDIUMTEXT, in Client_idclient int,in BabySitter_idBabySitter int)
begin
insert into SitterRating(Stars,comment,Client_idclient,BabySitter_idBabySitter)
values(Stars,comment,Client_idclient,BabySitter_idBabySitter);
end$$
DELIMITER ;

DELIMITER $$
create procedure addSitterBooking(in Request TINYINT,in date Date, in Client_idclient int,in BabySitter_idBabySitter int ,in sitter_payment_idsitter_payment int)
begin
insert into SitterBooking(Request,date,Client_idclient,BabySitter_idBabySitter,sitter_payment_idsitter_payment)
values(Request,date,Client_idclient,BabySitter_idBabySitter,sitter_payment_idsitter_payment);
end$$
DELIMITER ;


DELIMITER $$
create procedure addSitterpayment(in paid int,in recieved_sitter int,recieved_admin int, in Client_idclient int,in admin_idadmin int, in BabySitter_idBabySitter int)
begin
insert into sitter_payment(paid,recieved_sitter,recieved_admin,Client_idclient,admin_idadmin,BabySitter_idBabySitter)
values(paid,recieved_sitter,recieved_admin,Client_idclient,admin_idadmin,BabySitter_idBabySitter);
end$$
DELIMITER ;

DELIMITER $$
create trigger deleteclient before delete
on Client for each row
begin
delete from SitterBooking where SitterBooking.Client_idclient=old.id_client;
delete from SitterRating where SitterRating.Client_idclient=old.id_client;
delete from sitter_payment where sitter_payment.Client_idclient=old.id_client;
end $$
DELIMITER ;

DELIMITER $$
create trigger deletebabysitter_payment before delete
on sitter_payment for each row
begin
delete from SitterBooking where SitterBooking.sitter_payment_idsitter_payment=old.idsitter_payment;
end $$
DELIMITER ;

DELIMITER $$
create trigger delete_babysitter before delete
on BabySitter for each row
begin
delete from SitterBooking where SitterBooking.BabySitter_idBabySitter=old.idBabySitter;
end $$
DELIMITER ;

DELIMITER $$
create trigger delete_rating before delete
on BabySitter for each row
begin
delete from SitterRating where SitterRating.BabySitter_idBabySitter=old.idBabySitter;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatename
(in Username varchar(45),
in pname varchar(45))
begin
update Person
set
name=pname
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateemail
(in Username varchar(45),
in Email varchar(45))
begin
update Person
set
email=Email
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updategender
(in Username varchar(45),
in gender varchar(45))
begin
update Person
set
gender=gender
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatepass
(in Username varchar(45),
in pass varchar(45))
begin
update Person
set
password=pass
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateBirthdate
(in Username varchar(45),
in date date)
begin
update Person
set
birthdate=date
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateaddress
(in Username varchar(45),
in addr varchar(45))
begin
update Person
set
address=addr
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatenum
(in Username varchar(45),
in num varchar(45))
begin
update Person
set
phone=num
where Person.username=Username;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateimage
(in Username varchar(45),
in img Blob)
begin
update Person
set
image=img
where Person.username=Username;
end $$
DELIMITER ;
drop procedure updateimage;

DELIMITER $$
CREATE PROCEDURE updatecomments
(in id int,
in com mediumtext)
begin
update SitterRating
set
comment=com
where SitterRating.idSitterRating=id;
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE updatestars
(in id int,
in star mediumtext)
begin
update SitterRating
set
stars=star
where SitterRating.idSitterRating=id;
end $$
DELIMITER ;

drop procedure updatestars

DELIMITER $$
create procedure updatehours
(in id int,
in price_hour double)
begin
update BabySitter
set
price_hour=price_hour
where BabySitter.idBabySitter=id;
end $$
DELIMITER ;


DELIMITER $$
create procedure updatedate
(in id int,
in date date)
begin
update SitterBooking
set
date=date
where SitterBooking.idSitterBooking=id;
end $$
DELIMITER ;
















