CREATE DATABASE `Bank` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Bank`;

CREATE TABLE `Person`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `surname` VARCHAR(30) NOT NULL,
    `name` VARCHAR(15), 
    `passwordNumber` VARCHAR(30), 
    PRIMARY KEY(`id`));

CREATE TABLE `BankAccount`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `bankAccountNumber` INT(10) NOT NULL,
    `person` INT(10),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`person`) REFERENCES `Person` (`id`));

CREATE TABLE `Account`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(25) NOT NULL,
    `bankAccount` INT(10), 
    `passwordHash` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`bankAccount`) REFERENCES `BankAccount` (`id`));

CREATE TABLE `BankCard`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `cardNumber` VARCHAR(25) NOT NULL,
    `bankAccount` INT(10), 
    `blocked` BOOLEAN,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`bankAccount`) REFERENCES `BankAccount` (`id`));

CREATE TABLE `Transaction`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `bankCard` INT(10), 
    `transactionDate` DATE, 
    `amount` INT(30),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`bankCard`) REFERENCES `BankCard` (`id`));