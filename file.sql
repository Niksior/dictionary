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
	clientLogin TEXT NOT NULL,
	loanExpirationDate DATE NOT NULL,
	isReturned BOOL NOT NULL,
	tax REAL NOT NULL,
	isTaxPayed BOOL NOT NULL
);

DROP TABLE users;

CREATE TABLE users(
	login TEXT NOT NULL PRIMARY KEY,
	password TEXT NOT NULL,
	isAdmin BOOLEAN DEFAULT false,
	firstname TEXT NOT NULL,
	surname TEXT NOT NULL,
	PESEL TEXT NOT NULL,
	registerDate TIMESTAMP
);