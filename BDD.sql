------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: Salle
------------------------------------------------------------
CREATE TABLE public.Salle(
	sal_id       SERIAL NOT NULL ,
	sal_nom      VARCHAR (25)  ,
	sal_capacite INT   ,
	CONSTRAINT prk_constraint_Salle PRIMARY KEY (sal_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Equipements
------------------------------------------------------------
CREATE TABLE public.Equipements(
	equ_id  SERIAL NOT NULL ,
	equ_nom VARCHAR (25)  ,
	equ_qte INT   ,
	CONSTRAINT prk_constraint_Equipements PRIMARY KEY (equ_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Cours
------------------------------------------------------------
CREATE TABLE public.Cours(
	cou_id  SERIAL NOT NULL ,
	cou_nom VARCHAR (25)  ,
	CONSTRAINT prk_constraint_Cours PRIMARY KEY (cou_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Membres
------------------------------------------------------------
CREATE TABLE public.Membres(
	mem_id           SERIAL NOT NULL ,
	mem_nom          VARCHAR (25) NOT NULL ,
	mem_prenom       VARCHAR (25)  ,
	mem_adresse      VARCHAR (25)  ,
	mem_ville        VARCHAR (25)  ,
	mem_cp           INT   ,
	mem_entree       DATE   ,
	mem_date__sortie DATE   ,
	mem_date_entree  DATE   ,
	mem_actif        BOOL   ,
	pro_id           INT   ,
	com_id           INT   ,
	CONSTRAINT prk_constraint_Membres PRIMARY KEY (mem_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Formations
------------------------------------------------------------
CREATE TABLE public.Formations(
	for_id            SERIAL NOT NULL ,
	for_nom           VARCHAR (25)  ,
	for_periode_debut DATE   ,
	for_periode_fin   DATE   ,
	CONSTRAINT prk_constraint_Formations PRIMARY KEY (for_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Campus
------------------------------------------------------------
CREATE TABLE public.Campus(
	cam_id       SERIAL NOT NULL ,
	cam_nom      VARCHAR (25)  ,
	cam_addresse VARCHAR (25)  ,
	cam_ville    VARCHAR (25)  ,
	cam_cp       VARCHAR (6)  ,
	CONSTRAINT prk_constraint_Campus PRIMARY KEY (cam_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Droits
------------------------------------------------------------
CREATE TABLE public.Droits(
	dro_id  SERIAL NOT NULL ,
	dro_nom VARCHAR (25)  ,
	CONSTRAINT prk_constraint_Droits PRIMARY KEY (dro_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Promo
------------------------------------------------------------
CREATE TABLE public.Promo(
	pro_id          SERIAL NOT NULL ,
	pro_nom         VARCHAR (25)  ,
	pro_nb          INT   ,
	pro_description VARCHAR (25) NOT NULL ,
	CONSTRAINT prk_constraint_Promo PRIMARY KEY (pro_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Matiere
------------------------------------------------------------
CREATE TABLE public.Matiere(
	mat_id  SERIAL NOT NULL ,
	mat_nom CHAR (25)   ,
	CONSTRAINT prk_constraint_Matiere PRIMARY KEY (mat_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Comptes
------------------------------------------------------------
CREATE TABLE public.Comptes(
	com_id    SERIAL NOT NULL ,
	com_login VARCHAR (25)  ,
	com_pw    VARCHAR (25)  ,
	dro_id    INT   ,
	CONSTRAINT prk_constraint_Comptes PRIMARY KEY (com_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Poceder
------------------------------------------------------------
CREATE TABLE public.Poceder(
	cam_id INT  NOT NULL ,
	for_id INT  NOT NULL ,
	mem_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_Poceder PRIMARY KEY (cam_id,for_id,mem_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Equiper
------------------------------------------------------------
CREATE TABLE public.Equiper(
	sal_id INT  NOT NULL ,
	equ_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_Equiper PRIMARY KEY (sal_id,equ_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Reserver
------------------------------------------------------------
CREATE TABLE public.Reserver(
	res_date DATE  NOT NULL ,
	pro_id   INT  NOT NULL ,
	sal_id   INT  NOT NULL ,
	cou_id   INT  NOT NULL ,
	CONSTRAINT prk_constraint_Reserver PRIMARY KEY (pro_id,sal_id,cou_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Enseigner
------------------------------------------------------------
CREATE TABLE public.Enseigner(
	mem_id INT  NOT NULL ,
	mat_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_Enseigner PRIMARY KEY (mem_id,mat_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Constituer
------------------------------------------------------------
CREATE TABLE public.Constituer(
	cou_id INT  NOT NULL ,
	mat_id INT  NOT NULL ,
	mem_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_Constituer PRIMARY KEY (cou_id,mat_id,mem_id)
)WITHOUT OIDS;



ALTER TABLE public.Membres ADD CONSTRAINT FK_Membres_pro_id FOREIGN KEY (pro_id) REFERENCES public.Promo(pro_id);
ALTER TABLE public.Membres ADD CONSTRAINT FK_Membres_com_id FOREIGN KEY (com_id) REFERENCES public.Comptes(com_id);
ALTER TABLE public.Comptes ADD CONSTRAINT FK_Comptes_dro_id FOREIGN KEY (dro_id) REFERENCES public.Droits(dro_id);
ALTER TABLE public.Poceder ADD CONSTRAINT FK_Poceder_cam_id FOREIGN KEY (cam_id) REFERENCES public.Campus(cam_id);
ALTER TABLE public.Poceder ADD CONSTRAINT FK_Poceder_for_id FOREIGN KEY (for_id) REFERENCES public.Formations(for_id);
ALTER TABLE public.Poceder ADD CONSTRAINT FK_Poceder_mem_id FOREIGN KEY (mem_id) REFERENCES public.Membres(mem_id);
ALTER TABLE public.Equiper ADD CONSTRAINT FK_Equiper_sal_id FOREIGN KEY (sal_id) REFERENCES public.Salle(sal_id);
ALTER TABLE public.Equiper ADD CONSTRAINT FK_Equiper_equ_id FOREIGN KEY (equ_id) REFERENCES public.Equipements(equ_id);
ALTER TABLE public.Reserver ADD CONSTRAINT FK_Reserver_pro_id FOREIGN KEY (pro_id) REFERENCES public.Promo(pro_id);
ALTER TABLE public.Reserver ADD CONSTRAINT FK_Reserver_sal_id FOREIGN KEY (sal_id) REFERENCES public.Salle(sal_id);
ALTER TABLE public.Reserver ADD CONSTRAINT FK_Reserver_cou_id FOREIGN KEY (cou_id) REFERENCES public.Cours(cou_id);
ALTER TABLE public.Enseigner ADD CONSTRAINT FK_Enseigner_mem_id FOREIGN KEY (mem_id) REFERENCES public.Membres(mem_id);
ALTER TABLE public.Enseigner ADD CONSTRAINT FK_Enseigner_mat_id FOREIGN KEY (mat_id) REFERENCES public.Matiere(mat_id);
ALTER TABLE public.Constituer ADD CONSTRAINT FK_Constituer_cou_id FOREIGN KEY (cou_id) REFERENCES public.Cours(cou_id);
ALTER TABLE public.Constituer ADD CONSTRAINT FK_Constituer_mat_id FOREIGN KEY (mat_id) REFERENCES public.Matiere(mat_id);
ALTER TABLE public.Constituer ADD CONSTRAINT FK_Constituer_mem_id FOREIGN KEY (mem_id) REFERENCES public.Membres(mem_id);
