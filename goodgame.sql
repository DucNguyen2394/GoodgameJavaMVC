
create table role(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
    createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table user(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    userName VARCHAR(255) NOT NULL,
    fullName varchar(255) not null,
    age INT not null,
    address VARCHAR(255),
    email varchar(255),
    password varchar(255) not null,
    status int not null,
    roleId BIGINT NOT NULL,
    createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

ALTER TABLE user
ADD CONSTRAINT fk_user_role FOREIGN KEY (roleId) REFERENCES role(id);

create table game(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    name varchar(255) not null,
    title varchar(150),
    content text(255),
    description varchar(255),
    thumbnail varchar(255),
    platformId BIGINT NOT NULL,
    categoryId BIGINT NOT NULL,
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
    userId BIGINT NOT NULL,
	createAt timestamp,
    createBy varchar(255),
    modifiedAt timestamp,
    modifiedBy varchar(255)
)

create table orderDetail(
	id BIGINT auto_increment NOT NULL PRIMARY KEY,
    gameId BIGINT NOT NULL,
    orderId BIGINT NOT NULL
)
select * from game

select * from orderDetail

ALTER TABLE game
ADD CONSTRAINT fk_platform FOREIGN KEY (platformId) REFERENCES platform(id);

ALTER TABLE game
ADD CONSTRAINT fk_category FOREIGN KEY (categoryId) REFERENCES category(id);

ALTER TABLE orders
ADD CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES user(id);

ALTER TABLE orderDetail ADD CONSTRAINT fk_orders FOREIGN KEY(orderId) REFERENCES orders(id);

ALTER TABLE orderDetail ADD CONSTRAINT fk_game FOREIGN KEY(gameId) REFERENCES game(id);