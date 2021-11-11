

CREATE TABLE students (id serial,lastname varchar(100),firstname varchar(100),city varchar(100),gpa numeric(6,2));

INSERT INTO students (lastname, firstname, city, gpa) VALUES
('Altai','Kerimov','Almaty',3.00),
('Dastan','Tleygaziev','Almaty',4.00),
('Zhangali','Amanbek','Almaty',6.00),
('Miras','Orysbay','Moscow',7.00),
('Igor','Hope','Almaty',3.00),
('Love','Filly','Astana',2.00),
('Abai','Mametov','Almaty',1.00);



CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users
VALUES
('ADMIN', '{noop}123', true),
('CUSTOMER', '{noop}123', true);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('ADMIN', 'ROLE_ADMIN'),
('CUSTOMER', 'ROLE_USER');