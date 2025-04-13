CREATE TABLE CLIENT (
                        ID BIGSERIAL PRIMARY KEY,
                        FIRST_NAME VARCHAR(255) NOT NULL,
                        LAST_NAME VARCHAR(255) NOT NULL,
                        CPF VARCHAR(11) NOT NULL UNIQUE,
                        BIRTH_DATE DATE NOT NULL
);

CREATE TABLE ADDRESS (
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