create database voiture_occasion;
\c voiture_occasion

-- SEQUENCE --
create sequence type_seq start 1;

-- TABLE --
create table utilisateur(
    iduser serial primary key,
    nom varchar(100),
    email varchar(100),
    mdp varchar(100),
    etat int
);

create table type(
    idtype serial primary key,
    nom varchar(200)
);

create table marque(
    idmarque serial primary key,
    nom varchar(200)
);

create table modele(
    idmodele serial primary key,
    nom varchar(200)
);

create table energie(
    idenergie serial primary key,
    energie varchar(200)
);

create table boite_vitesse(
    idbv serial primary key,
    nom varchar(200)
);

create table couleur(
    idcouleur serial primary key,
    couleur varchar(200)
);

create table pays(
    idpays serial primary key,
    nom varchar(200)
);

create table voiture(
    idvoiture serial primary key,
    type int references type(idtype),
    marque int references marque(idmarque),
    modele int references modele(idmodele),
    energie int references energie(idenergie),
    boite_vitesse int references boite_vitesse(idbv),
    annee int,
    kilometrage double precision,
    prix double precision,
    couleur int references couleur(idcouleur),
    provenance int references pays(idpays),
    nbplace int,
    nbporte int,
    status int
);

create table picture(
    idpicture serial primary key,
    picture varchar(200),
    idvoiture int references voiture(idvoiture)
);

create table annonce(
    idannonce serial primary key,
    iduser int references utilisateur(iduser),
    idvoiture int references voiture(idvoiture),
    etat int
);

create table stat(
    idstat serial primary key,
    idvoiture int references voiture(idvoiture),
    status int
);

create table commission(
    idtype int references type(idtype),
    commission decimal(5, 2)
);

create table vente_mensuelle (
    idvente serial primary key,
    mois int,
    annee int,
    idtype int references type(idtype),
    chiffre_affaire double precision
);

create table favoris(
    idfavoris serial primary key,
    iduser int references utilisateur(iduser),
    idannonce int references annonce(idannonce)
);

-- VIEW --
create or replace view v_annonce as
select a.idannonce, a.iduser, v.idvoiture, v.type as idtype, t.nom as type, v.marque as idmarque, m.nom as marque, v.modele as idmodele, mo.nom as modele, v.energie as idenergie, e.energie, v.boite_vitesse as idbv, bv.nom as boite_vitesse, v.annee, v.kilometrage, v.prix, v.couleur as idcouleur, c.couleur, v.provenance as idpays, p.nom as provenance, v.nbplace, v.nbporte, a.etat
from annonce a
join voiture v on a.idvoiture = v.idvoiture
join utilisateur u on a.iduser = u.iduser
join type t on v.type = t.idtype
join marque m on v.marque = m.idmarque
join modele mo on v.modele = mo.idmodele
join energie e on v.energie = e.idenergie
join boite_vitesse bv on v.boite_vitesse = bv.idbv
join couleur c on v.couleur = c.idcouleur
join pays p on v.provenance = p.idpays;

create or replace view v_stat_type as
select v.type as idtype, t.nom as type, count(v.status) as nombre, v.status
from voiture v
join type t on v.type = t.idtype
group by v.type, t.nom, v.status;

--modif
create or replace view v_stat_type as
select v.type as idtype, t.nom as type, extract(month from current_date) as mois, extract(year from current_date) as annee, count(v.status) as nombre, v.status
from voiture v
join type t on v.type = t.idtype
group by v.type, t.nom, v.status, mois, annee;


create or replace view v_stat_marque as
select v.marque as idmarque, m.nom as marque, count(v.status) as nombre, v.status
from voiture v
join marque m on v.marque = m.idmarque
group by v.marque, m.nom, v.status;

create or replace view v_stat_modele as
select v.modele as idmodele, m.nom as modele, count(v.status) as nombre, v.status
from voiture v
join modele m on v.marque = m.idmodele
group by v.modele, m.nom, v.status;


-- Création de la vue pour les chiffres d'affaires
create or replace view v_chiffres_affaires as
select
    v.idvoiture,
    v.prix as prix_vente,
    a.etat as etat_annonce,
    c.commission,
    v.prix - c.commission as chiffre_affaire_net
from
    voiture v
join
    annonce a on v.idvoiture = a.idvoiture
join
    commission c on v.type = c.idtype;

--utilisation de la vue pour obtenir le chiffre d'affaires total
select sum(chiffre_affaire_net) as chiffre_affaires_total
from v_chiffres_affaires;


CREATE TABLE token (
    id serial PRIMARY KEY ,
    id_utilisateur int REFERENCES utilisateur(iduser),
    token VARCHAR(100),
    date_expiration DATE 

);

