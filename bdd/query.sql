select idtype, type, count(status), status
from voiture group by type, status;

select v.marque as idmarque, m.nom as marque, count(v.status) as nombre, v.status
from voiture v
join marque m on v.marque = m.idmarque
group by v.marque, m.nom, v.status;

select idmodele, modele, count(status), status
from voiture group by modele, status;

select a.idannonce, a.iduser, v.idvoiture, t.nom as type, m.nom as marque, mo.nom as modele, e.energie, bv.nom as boite_vitesse, v.annee, v.kilometrage, v.prix, c.couleur, p.nom as provenance, v.nbplace, v.nbporte
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

select * from type;
select * from modele;
select * from boite_vitesse;
select * from utilisateur;

drop view v_annonce;
drop table annonce;
drop table picture;
drop table voiture;
drop table utilisateur;
drop table boite_vitesse;
drop table modele;
drop table marque;
drop table energie;
drop table couleur;
drop table pays;
drop table type;