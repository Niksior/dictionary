DROP TABLE clients;

CREATE TABLE clients(
	ID SERIAL PRIMARY KEY,
	firstname TEXT NOT NULL,
	surname TEXT NOT NULL,
	PESEL CHAR(11) NOT NULL,
	registerDate TIMESTAMP
);

DROP TABLE books;

CREATE TABLE books(
	ID SERIAL PRIMARY KEY,
	authorName TEXT NOT NULL,
	authorSurname TEXT NOT NULL,
	title TEXT NOT NULL,
	printYear int NOT NULL,
	isAway BOOLEAN DEFAULT false
);

DROP TABLE loans;

CREATE TABLE loans(
	loanID SERIAL PRIMARY KEY,
	loanDate TIMESTAMP,
	clientID INT NOT NULL,
	loanExpirationDate DATE NOT NULL,
	isReturned BOOL NOT NULL,
	tax REAL NOT NULL,
	isTaxPayed BOOL NOT NULL
);

DROP TABLE logins;

CREATE TABLE logins(
	login TEXT NOT NULL PRIMARY KEY,
	password TEXT NOT NULL
);