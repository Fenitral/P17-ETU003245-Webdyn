create database db_s2_etu003245;
use db_s2_etu003245;

create table login (
    idLogin int primary key auto_increment,
    nom varchar(50) not null,
    mdp varchar(50)
);

insert into login (nom,mdp) values ('nom','nom');

create table prevision(
    idPrevision int primary key auto_increment,
    libelle varchar(100),
    montant int
);

create table depense(
    idDepense int primary key auto_increment,
    montant int,
    idPrevision int,
    foreign key (idPrevision) references prevision(idPrevision)
);

insert into prevision (libelle,montant) values ('frais',100000);

select * from login;
select * from prevision;
select * from depense;

drop database db_s2_etu003245;