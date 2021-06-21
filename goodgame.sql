Create database goodgame;

create table user(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    userName VARCHAR(255) NOT NULL,
    fullName varchar(255) not null,
    age INT not null,
    address VARCHAR(255),
    email varchar(255),
    password varchar(255) not null,
    createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table game(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    name varchar(255) not null,
    title varchar(150),
    content text(255),
    description varchar(255),
    thumbnail varchar(255),
    createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table platform(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    name varchar(255) not null,
	createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table category(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    name varchar(255) not null,
	createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table orders(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
	createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table orderDetail(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
	CONSTRAINT order_id FOREIGN KEY (id) REFERENCES orders(id),
	CONSTRAINT game_id FOREIGN KEY (id) REFERENCES game(id)
)
select * from game

ALTER TABLE game
ADD CONSTRAINT fk_platform FOREIGN KEY (id) REFERENCES platform(id);

ALTER TABLE game
ADD CONSTRAINT fk_category FOREIGN KEY (id) REFERENCES category(id);

ALTER TABLE orders
ADD CONSTRAINT fk_user FOREIGN KEY (id) REFERENCES user(id);



