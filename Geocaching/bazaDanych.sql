if exists(select 1 from master.dbo.sysdatabases where name = 'GeocachingDB') drop database GeocachingDB
GO
CREATE DATABASE GeocachingDB
GO

USE GeocachingDB

CREATE TABLE poszukiwacz (
pseudonim	VARCHAR(25) CONSTRAINT pseudonim_pk PRIMARY KEY (pseudonim),
email		VARCHAR(100) NOT NULL,
poziom		VARCHAR(10) NOT NULL,

CONSTRAINT poziom_z_zakresu CHECK ( poziom IN ('NOWICJUSZ','UCZEN','CZELADNIK','EKSPERT','MISTRZ'))
);
GO

CREATE TABLE skrzynka (
nazwa				  VARCHAR(50) CONSTRAINT nazwa_pk PRIMARY KEY (nazwa),
opis				  VARCHAR(200) NOT NULL DEFAULT 'Brak opisu',
liczba_odnalezien	  INT DEFAULT 0,
czyDostepna			  BIT NOT NULL DEFAULT 1, 
dataZalozenia		  DATETIME NOT NULL DEFAULT GETDATE(), 
wspolrzedne_dlugosc   VARCHAR(18) NOT NULL,
wspolrzedne_szerokosc VARCHAR(18) NOT NULL,
zalozyciel			  VARCHAR(25) NOT NULL,
rozmiar				  VARCHAR(8)  NOT NULL,
typSkrzynki			  VARCHAR(10) NOT NULL,

CONSTRAINT liczba_odnalezien_wieksza_od_zera CHECK( liczba_odnalezien >= 0),
CONSTRAINT wsporzedne_dlugosc_to_liczby CHECK(
	SUBSTRING(wspolrzedne_dlugosc,1,2) BETWEEN '0' AND '9' AND
	SUBSTRING(wspolrzedne_dlugosc,3,1) = '.' AND
	SUBSTRING(wspolrzedne_dlugosc,4,15) BETWEEN '0' AND '9'),
CONSTRAINT wsporzedne_szerokosc_to_liczby CHECK(
	SUBSTRING(wspolrzedne_dlugosc,1,2) BETWEEN '0' AND '9' AND
	SUBSTRING(wspolrzedne_dlugosc,3,1) = '.' AND
	SUBSTRING(wspolrzedne_dlugosc,4,15) BETWEEN '0' AND '9'),
CONSTRAINT zalozyciel_FK FOREIGN KEY(zalozyciel) REFERENCES poszukiwacz(pseudonim),
CONSTRAINT rozmiar_z_zakresu CHECK ( rozmiar IN ('MIKRO','MALY','NORMALNY','DUZY')),
CONSTRAINT typSkrzynki_z_zakresu CHECK ( typSkrzynki IN 
			('TRADYCYJNA','WYDARZENIE','ZAGADKOWA','ZDJECIE', 'EARTHCACHE'))
);
GO

CREATE TABLE odkrycie (
id_odkrycia		INT IDENTITY(1,1) CONSTRAINT id_odkrycia_pk PRIMARY KEY (id_odkrycia),
poszukiwacz		VARCHAR(25) NOT NULL,
skrzynka		VARCHAR(50) NOT NULL,
dataZnalezienia DATETIME NOT NULL DEFAULT GETDATE(),

CONSTRAINT poszukiwacz_FK FOREIGN KEY(poszukiwacz) REFERENCES poszukiwacz(pseudonim),
CONSTRAINT skrzynka_FK FOREIGN KEY(skrzynka) REFERENCES skrzynka(nazwa)
);
GO