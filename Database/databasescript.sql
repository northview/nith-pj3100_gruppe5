SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `nattogdagprosjekt` DEFAULT CHARACTER SET utf8 ;
USE `nattogdagprosjekt` ;

-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`avisrute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`avisrute` (
  `avisrutenummer` INT(6) NOT NULL,
  PRIMARY KEY (`avisrutenummer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`distribusjonspunkt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`distribusjonspunkt` (
  `distribusjonspunkt_id` INT(11) NOT NULL AUTO_INCREMENT,
  `adresse` VARCHAR(255) NULL DEFAULT NULL,
  `postnummer` INT(4) NULL DEFAULT NULL,
  `bynavn` VARCHAR(50) NULL DEFAULT NULL,
  `latitude` DECIMAL(10,8) NULL DEFAULT NULL,
  `longitude` DECIMAL(10,8) NULL DEFAULT NULL,
  `navn` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`distribusjonspunkt_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1417
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`avisrutestopp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`avisrutestopp` (
  `avisrutestopp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `avisrutenummer` INT(6) NULL DEFAULT NULL,
  `stoppnummer` SMALLINT(4) NULL DEFAULT NULL,
  `distribusjonspunkt_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`avisrutestopp_id`),
  INDEX `avisrutenummer` (`avisrutenummer` ASC),
  INDEX `distribusjonspunkt_id` (`distribusjonspunkt_id` ASC),
  CONSTRAINT `avisrutestopp_ibfk_1`
    FOREIGN KEY (`avisrutenummer`)
    REFERENCES `nattogdagprosjekt`.`avisrute` (`avisrutenummer`),
  CONSTRAINT `avisrutestopp_ibfk_2`
    FOREIGN KEY (`distribusjonspunkt_id`)
    REFERENCES `nattogdagprosjekt`.`distribusjonspunkt` (`distribusjonspunkt_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`rolle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`rolle` (
  `rolle` VARCHAR(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`rolle`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`bruker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`bruker` (
  `bruker_id` INT(11) NOT NULL AUTO_INCREMENT,
  `brukernavn` VARCHAR(50) NOT NULL,
  `passord` VARCHAR(255) NOT NULL,
  `navn` VARCHAR(50) NULL DEFAULT NULL,
  `telefonnummer` INT(10) NULL DEFAULT NULL,
  `rolle` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`bruker_id`),
  INDEX `rolle` (`rolle` ASC),
  CONSTRAINT `bruker_ibfk_1`
    FOREIGN KEY (`rolle`)
    REFERENCES `nattogdagprosjekt`.`rolle` (`rolle`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`bruker_avisrute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`bruker_avisrute` (
  `avisrutenummer` INT(6) NOT NULL DEFAULT '0',
  `bruker_id` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`avisrutenummer`, `bruker_id`),
  INDEX `bruker_id` (`bruker_id` ASC),
  CONSTRAINT `bruker_avisrute_ibfk_1`
    FOREIGN KEY (`avisrutenummer`)
    REFERENCES `nattogdagprosjekt`.`avisrute` (`avisrutenummer`),
  CONSTRAINT `bruker_avisrute_ibfk_2`
    FOREIGN KEY (`bruker_id`)
    REFERENCES `nattogdagprosjekt`.`bruker` (`bruker_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nattogdagprosjekt`.`distribusjon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nattogdagprosjekt`.`distribusjon` (
  `distribusjon_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nummer` VARCHAR(50) NULL DEFAULT NULL,
  `distribusjonspunkt_id` INT(11) NOT NULL,
  `antall_gjenvaerende` INT(5) NULL DEFAULT NULL,
  `antall_pafyllt` INT(5) NULL DEFAULT NULL,
  `antall_distribuert` INT(5) NULL DEFAULT NULL,
  `tidspunkt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bruker_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`distribusjon_id`),
  INDEX `distribusjonspunkt_id` (`distribusjonspunkt_id` ASC),
  INDEX `bruker_id` (`bruker_id` ASC),
  CONSTRAINT `distribusjon_ibfk_1`
    FOREIGN KEY (`distribusjonspunkt_id`)
    REFERENCES `nattogdagprosjekt`.`distribusjonspunkt` (`distribusjonspunkt_id`),
  CONSTRAINT `distribusjon_ibfk_2`
    FOREIGN KEY (`bruker_id`)
    REFERENCES `nattogdagprosjekt`.`bruker` (`bruker_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
