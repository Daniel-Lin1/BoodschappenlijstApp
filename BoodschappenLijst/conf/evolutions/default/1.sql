# --- !Ups
create table ingredient
(
	id bigint not null AUTO_INCREMENT
		primary key,
	name varchar(255) null,
	image varchar(255) null,
	measurement int null,
	volume int null
);
create table kitchenware
(
	id bigint not null AUTO_INCREMENT
		primary key,
	name varchar(255) null
);
create table user
(
	id bigint not null AUTO_INCREMENT
		primary key,
	email varchar(255) null,
	password varchar(255) null,
	recipeList tinyblob null,
	username varchar(255) null
);

# --- !Downs

drop table if exists ingredient;
drop table if exists `user`;
drop table if exists kitchenware;

