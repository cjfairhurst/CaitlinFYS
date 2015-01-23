-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fys
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fys
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fys` DEFAULT CHARACTER SET utf8 ;
USE `fys` ;

-- -----------------------------------------------------
-- Table `fys`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fys`.`client` (
  `client_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `telephone_number` VARCHAR(45) NULL DEFAULT NULL,
  `street_address` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `shipping_street_address` VARCHAR(45) NULL DEFAULT NULL,
  `shipping_zipcode` VARCHAR(45) NULL DEFAULT NULL,
  `shipping_city` VARCHAR(45) NULL DEFAULT NULL,
  `shipping_country` VARCHAR(45) NULL DEFAULT NULL,
  `date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fys`.`baggage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fys`.`baggage` (
  `baggage_dbnumber` INT(11) NOT NULL AUTO_INCREMENT,
  `baggage_id` INT(11) NULL DEFAULT NULL,
  `flight_number` VARCHAR(45) NULL DEFAULT NULL,
  `brand` VARCHAR(45) NULL DEFAULT NULL,
  `color` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `owner` INT(11) NULL DEFAULT NULL,
  `case_status` VARCHAR(45) NULL DEFAULT NULL,
  `date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`baggage_dbnumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fys`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fys`.`employee` (
  `employee_id` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `telephone_number` VARCHAR(45) NULL DEFAULT NULL,
  `function` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  `date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fys`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fys`.`log` (
  `username` VARCHAR(45) NOT NULL,
  `page` VARCHAR(45) NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`, `date`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;