--create types
DROP TYPE IF EXISTS transaction_type;
CREATE TYPE transaction_type AS ENUM (
    'DEPOSIT',
    'WITHDRAWAL'
);

DROP TABLE IF EXISTS account_holder;
CREATE TABLE account_holder (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name varchar(64) NOT NULL,
    CONSTRAINT pk_account_holder PRIMARY KEY (id)
);
INSERT INTO account_holder (id, first_name, last_name)
    VALUES (1, 'Giri', 'Pottepalem');

DROP TABLE IF EXISTS addresses;
CREATE TABLE addresses (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    address1 varchar(255) NOT NULL,
    address2 varchar(255),
    city varchar(64) NOT NULL,
    state varchar(64) NOT NULL,
    zip varchar(16) NOT NULL,
    CONSTRAINT pk_addresses PRIMARY KEY (id)
);
INSERT INTO addresses (id, address1, address2, city, state, zip)
    VALUES (1, '85 Stillwater Rd', null, 'Canton', 'MA', '02021');

DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number varchar(255) NOT NULL,
    balance numeric NOT NULL,
    CONSTRAINT pk_accounts PRIMARY KEY (id)
);
INSERT INTO accounts (id, number, balance)
    VALUES (1, 'CHECKING-1', 1000.99);
