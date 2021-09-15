drop
database if exists Katchau;

create
database Katchau;

use
Katchau;


create table Usuario
(
    codigo varchar(20)  not null,
    email  varchar(256) not null unique,
    senha  varchar(256) not null,
    adm    bit          not null,
    nome   varchar(256) not null,
    primary key (codigo)
);

create table Cliente
(
    cpf        varchar(20) not null,
    telefone   varchar(256),
    sexo       varchar(256),
    nascimento Date,
    foreign key (cpf) references Usuario (codigo)
);

create table Loja
(
    cnpj      varchar(20) not null,
    descricao varchar(256),
    foreign key (cnpj) references Usuario (codigo)
);

create table Carro
(
    id        bigint      not null auto_increment,
    cnpj      varchar(20) not null,
    placa     varchar(10),
    modelo    varchar(20),
    chassi    varchar(20),
    ano       integer,
    km        varchar(10),
    descricao text,
    valor     float,
    primary key (id),
    foreign key (cnpj) references Loja (cnpj) ON DELETE CASCADE
);

create table Proposta
(
    id       bigint      not null auto_increment,
    status   int         not null,
    data     date        not null,
    val      float,
    condPag  text,
    cnpj     varchar(20) not null,
    carro_id bigint      not null,
    primary key (id),
    foreign key (carro_id) references Carro (id),
    foreign key (cnpj) references Carro (cnpj) ON DELETE CASCADE
);

insert into Usuario(codigo, email, senha, nome, adm)
values ('000.000.000-00', 'ok@ok.com', 'ok', 'ok', 1);