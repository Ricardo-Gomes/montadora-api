--create schema montadora

create table montadora.chasi(
	id bigserial not null primary key,
	codigo numeric not null,
	marca varchar(50) not null,
	preco numeric not null
);

create table montadora.cor(
	id bigserial not null primary key,
	descricao varchar(150) not null,
	tipo varchar(150) not null
);

create table montadora.motor(
	id bigserial not null primary key,
	codigo numeric not null,
	marca varchar(50) not null,
	preco numeric not null
);

create table montadora.pneus(
	id bigserial not null primary key,
	aro numeric not null,
	preco numeric not null
);

