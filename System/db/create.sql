CREATE DATABASE IF NOT EXISTS FlightSupportSystem;

USE FlightSupportSystem;


CREATE TABLE Client (
	idClient INT UNSIGNED NOT NULL AUTO_INCREMENT,
	login VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(20) NOT NULL,
	patronymic VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	address VARCHAR(100),
	phone_number VARCHAR(15),
	email VARCHAR(50),
	PRIMARY KEY (idClient)
);

CREATE TABLE Airline (
	idAirline INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (idAirline)
);

CREATE TABLE Airport (
	idAirport INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	phone_number VARCHAR(15) NOT NULL,
	PRIMARY KEY (idAirport)
);

CREATE TABLE Flight (
	idFlight INT UNSIGNED NOT NULL AUTO_INCREMENT,
	number VARCHAR(15) NOT NULL,
	airline INT UNSIGNED NOT NULL REFERENCES Airline,
	dptr_airport INT UNSIGNED NOT NULL REFERENCES Airport,
	arr_airport INT UNSIGNED NOT NULL REFERENCES Airport,
	length INT UNSIGNED NOT NULL,
	PRIMARY KEY (idFlight)
);

CREATE TABLE ParticularFlight (
	idParticularFlight INT UNSIGNED NOT NULL AUTO_INCREMENT,
	flight INT UNSIGNED NOT NULL REFERENCES Flight,
	dptr_time TIMESTAMP NOT NULL,
	arr_time TIMESTAMP NOT NULL,
	PRIMARY KEY (idParticularFlight)
);

CREATE TABLE Bonus (
	idBonus INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	airline INT UNSIGNED NOT NULL REFERENCES Airline,
	client INT UNSIGNED NOT NULL REFERENCES Client,
	points BIGINT UNSIGNED DEFAULT 0 NOT NULL,
	PRIMARY KEY (idBonus)
);

CREATE TABLE ServiceClass (
	idServiceClass INT UNSIGNED NOT NULL AUTO_INCREMENT,
	particular_flight INT UNSIGNED NOT NULL REFERENCES ParticularFlight,
	name VARCHAR(20) NOT NULL,
	bonus_coeff FLOAT UNSIGNED NOT NULL,
	cost FLOAT UNSIGNED NOT NULL,
	PRIMARY KEY (idServiceClass)
);

CREATE TABLE Seat (
	idSeat INT UNSIGNED NOT NULL AUTO_INCREMENT,
	class INT UNSIGNED NOT NULL REFERENCES ServiceClass,
	row SMALLINT UNSIGNED NOT NULL, 
	symb VARCHAR(1) NOT NULL,
	status TINYINT DEFAULT 0 NOT NULL,
	owner INT UNSIGNED REFERENCES Client,
	PRIMARY KEY (idSeat)
);