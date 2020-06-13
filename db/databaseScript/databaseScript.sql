-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema explorebulgaria
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `explorebulgaria` DEFAULT CHARACTER SET utf8 ;
USE `explorebulgaria`;

-- -----------------------------------------------------
-- Table `explorebulgaria`.`regions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `explorebulgaria`.`regions` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `region_name` VARCHAR(45) NOT NULL,
  `latitude` DECIMAL(10, 8) NOT NULL,
  `longitude` DECIMAL(11, 8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IdRegion_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `explorebulgaria`.`landmarks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `explorebulgaria`.`landmarks` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `landmark_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `picture` LONGTEXT NOT NULL,
  `latitude` DECIMAL(10, 8) NOT NULL,
  `longitude` DECIMAL(11, 8) NOT NULL,
  `work_time`VARCHAR(45) NOT NULL,
  `entrance_fee` VARCHAR(45) NOT NULL,
  `region_id` INT(10) NOT NULL,
  `is_visited` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IdLandmark_UNIQUE` (`id` ASC),
  CONSTRAINT `region_id`
	FOREIGN KEY (`region_id`)
	REFERENCES `explorebulgaria`.`regions`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
