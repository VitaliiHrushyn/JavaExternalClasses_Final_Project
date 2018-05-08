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
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `role` ENUM('CUSTOMER', 'MANAGER', 'WORKMAN') NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `repair_agency`.`testimonials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`testimonials` (
  `testimonial_id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(245) NULL,
  `create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`testimonial_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `repair_agency`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`applications` (
  `application_id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('NEW', 'RECEIVED', 'REJECTED', 'APPROVED', 'EXECUTING', 'DONE', 'FINISHED') NOT NULL,
  `description` VARCHAR(245) NOT NULL,
  `manager_comment` VARCHAR(245) NULL,
  `price` BIGINT NULL,
  `customer_id` INT NOT NULL,
  `workman_id` INT NULL,
  `testimonial_id` INT NULL,
  `create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`application_id`),
  UNIQUE INDEX `applicationid_UNIQUE` (`application_id` ASC),
  INDEX `fkcustomer_idx` (`customer_id` ASC),
  INDEX `fkworkman_idx` (`workman_id` ASC),
  INDEX `fktes_idx` (`testimonial_id` ASC),
  CONSTRAINT `fkcustomer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `repair_agency`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fkworkman`
    FOREIGN KEY (`workman_id`)
    REFERENCES `repair_agency`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fktes`
    FOREIGN KEY (`testimonial_id`)
    REFERENCES `repair_agency`.`testimonials` (`testimonial_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `repair_agency`.`changes_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repair_agency`.`changes_history` (
  `record_id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(145) NULL,
  `user_id` INT NOT NULL,
  `application_id` INT NOT NULL,
  `create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`record_id`),
  UNIQUE INDEX `record_id_UNIQUE` (`record_id` ASC),
  INDEX `fkuser_idx` (`user_id` ASC),
  INDEX `fkapp_idx` (`application_id` ASC),
  CONSTRAINT `fkuser`
    FOREIGN KEY (`user_id`)
    REFERENCES `repair_agency`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fkapp`
    FOREIGN KEY (`application_id`)
    REFERENCES `repair_agency`.`applications` (`application_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
