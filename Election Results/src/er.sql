SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ER` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ER` ;

-- -----------------------------------------------------
-- Table `ER`.`States`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`States` (
    `sid` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(150) NOT NULL,
    `isUnionTerritory` TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (`sid`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC),
    UNIQUE INDEX `sid_UNIQUE` (`sid` ASC)
)  ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `ER`.`District`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`District` (
    `did` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(150) NOT NULL,
    `sid` INT NOT NULL,
    PRIMARY KEY (`did`),
    UNIQUE INDEX `did_UNIQUE` (`did` ASC),
    INDEX `fk_District_States_idx` (`sid` ASC),
    CONSTRAINT `fk_District_States` FOREIGN KEY (`sid`)
        REFERENCES `ER`.`States` (`sid`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `ER`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`Group` (
    `gid` INT NOT NULL,
    `name` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`gid`),
    UNIQUE INDEX `gid_UNIQUE` (`gid` ASC)
)  ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `ER`.`Party`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`Party` (
    `pid` INT NOT NULL,
    `name` VARCHAR(150) NULL,
    `gid` INT NOT NULL,
    PRIMARY KEY (`pid`),
    INDEX `fk_Party_Group1_idx` (`gid` ASC),
    CONSTRAINT `fk_Party_Group1` FOREIGN KEY (`gid`)
        REFERENCES `ER`.`Group` (`gid`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `ER`.`Constituency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`Constituency` (
    `cid` INT NOT NULL AUTO_INCREMENT,
    `cname` VARCHAR(200) NOT NULL,
    `resultType` INT NOT NULL,
    `did` INT NOT NULL,
    `sid` INT NOT NULL,
    PRIMARY KEY (`cid`),
    INDEX `fk_Constituency_District1_idx` (`did` ASC),
    INDEX `fk_Constituency_States1_idx` (`sid` ASC),
    CONSTRAINT `fk_Constituency_District1` FOREIGN KEY (`did`)
        REFERENCES `ER`.`District` (`did`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_Constituency_States1` FOREIGN KEY (`sid`)
        REFERENCES `ER`.`States` (`sid`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `ER`.`Candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ER`.`Candidate` (
    `canId` INT NOT NULL,
    `canName` VARCHAR(200) NOT NULL,
    `votes` INT NOT NULL DEFAULT 0,
    `cid` INT NOT NULL,
    `pid` INT NOT NULL,
    PRIMARY KEY (`canId`),
    INDEX `fk_Candidate_Constituency2_idx` (`cid` ASC),
    INDEX `fk_Candidate_Party1_idx` (`pid` ASC),
    CONSTRAINT `fk_Candidate_Constituency2` FOREIGN KEY (`cid`)
        REFERENCES `ER`.`Constituency` (`cid`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_Candidate_Party1` FOREIGN KEY (`pid`)
        REFERENCES `ER`.`Party` (`pid`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB;

USE `ER` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
