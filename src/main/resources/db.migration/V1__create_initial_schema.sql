CREATE SCHEMA IF NOT EXISTS `AURA_MS_CLIENTS`;

CREATE TABLE `AURA_MS_CLIENTS`.CLIENT (
                        ID BIGSERIAL PRIMARY KEY,
                        FIRST_NAME VARCHAR(255) NOT NULL,
                        LAST_NAME VARCHAR(255) NOT NULL,
                        CPF VARCHAR(11) NOT NULL UNIQUE,
                        BIRTH_DATE DATE NOT NULL
);

CREATE TABLE `AURA_MS_CLIENTS`.ADDRESS (
                         ID BIGSERIAL PRIMARY KEY,
                         STREET VARCHAR(100) NOT NULL,
                         NUMBER VARCHAR(10) NOT NULL,
                         ZIPCODE VARCHAR(20) NOT NULL,
                         NEIGHBORHOOD VARCHAR(50) NOT NULL,
                         CITY VARCHAR(50) NOT NULL,
                         STATE VARCHAR(50),
                         CLIENT_ID BIGINT NOT NULL,
                         FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)
);