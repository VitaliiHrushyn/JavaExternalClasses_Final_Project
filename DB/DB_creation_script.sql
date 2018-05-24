-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema repair_agency
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema repair_agency
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `repair_agency` DEFAULT CHARACTER SET utf8 ;
USE `repair_agency` ;

-- -----------------------------------------------------
-- Table `repair_agency`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` ENUM('CUSTOMER', 'MANAGER', 'WORKMAN') NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 90
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `repair_agency`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`applications` (
  `application_id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` ENUM('NEW', 'RECEIVED', 'REJECTED', 'APPROVED', 'EXECUTING', 'DONE', 'FINISHED') NOT NULL,
  `description` VARCHAR(245) NOT NULL,
  `manager_comment` VARCHAR(245) NULL DEFAULT NULL,
  `price` DECIMAL(10,2) NULL DEFAULT NULL,
  `customer_id` INT(11) NULL DEFAULT NULL,
  `workman_id` INT(11) NULL DEFAULT NULL,
  `testimonial_id` INT(11) NULL DEFAULT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version_id` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`application_id`),
  UNIQUE INDEX `applicationid_UNIQUE` (`application_id` ASC),
  INDEX `fkcustomer_idx` (`customer_id` ASC),
  INDEX `fkworkman_idx` (`workman_id` ASC),
  INDEX `fktesim_idx` (`testimonial_id` ASC),
  INDEX `fktestimonial_idx` (`testimonial_id` ASC),
  INDEX `fktes_idx` (`testimonial_id` ASC),
  CONSTRAINT `fkcustomer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `repair_agency`.`users` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fkworkman`
    FOREIGN KEY (`workman_id`)
    REFERENCES `repair_agency`.`users` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 98
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `repair_agency`.`testimonials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`testimonials` (
  `testimonial_id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(245) NULL DEFAULT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`testimonial_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 44
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
