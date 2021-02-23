create database wawibay;
use wawibay;

##Erstellung der Kunden-Tabelle anhand des ER-Diagramms
create table Kunden
(
	Kunden_ID int primary key auto_increment not null,
    EBay_Benutzername varchar(50) not null,								##ist der Benutzername notwendig?
    Anrede varchar(30) not null,
	Vorname varchar(50),
    Nachname varchar(50) not null,
    Strasse_Hausnummer varchar(50) not null,
    Postleitzahl varchar(10) not null,
    Wohnort varchar(50) not null,
    Adresszusatz varchar(50),									##nicht unbedingt notwendig
    Land varchar(30) not null,
    Email_Adresse varchar(50),
    Telefonnummer varchar(30)									##ist eine Telefonnummer notwendig?
);

##Erstellung der Kategorie-Tabelle
create table Kategorie
(
	Kategorie_ID int primary key auto_increment not null,
    Kategoriename varchar(50) not null
);


##Erstellung der Artikel-Tabelle
create table Artikel
(
	Artikel_ID int primary key auto_increment not null,
    Bezeichnung varchar(50) not null,
    Stueckpreis decimal(10,2) not null,
    Artikelbeschreibung varchar(100),						##reichen 100 Zeichen?
    Material varchar(50),
    ##Bild blob, 											wird online als eher schlecht beschrieben, kein Plan ob das unbedingt in der DB sein muss
    Farbe varchar(30),
    Steuersatz int not null,
    Groesse varchar(50),
    Kategorie_ID_Fremd int,
    foreign key(Kategorie_ID_Fremd) references Kategorie(Kategorie_ID)
);

##Erstellung der Lager-Tabelle
create table Lager
(
	Artikel_ID_Fremd int,
	foreign key(Artikel_ID_Fremd) references Artikel(Artikel_ID),
    Anzahl int not null
);

##describe Kunden;					##Infos über Tabelle anzeigen		

##Testdaten einfügen
##Kundendatenbank bestücken

insert into Kunden (EBay_Benutzername, Anrede, Vorname, Nachname, Strasse_Hausnummer, Postleitzahl, Wohnort, Adresszusatz, Land, Email_Adresse, Telefonnummer)
values
	("Ditti_L", "Herr", "Dittmar", "Lorentz", "Neuhofer Straße 100", "97618", "Hohenroth", "", "Deutschland", "dittmar-lorentz@web.none", "0151/6959151"),
    ("Woderwoman87", "Frau", "Irena", "Wunderle", "Weitblick 20", "58313", "Herdecke an der Ruhr", "3. Etage", "Deutschland", "irena-94@spam-mail.none", "0170/7447168"),
    ("Hermine12", "Frau", "Herline", "Mueller", "Silvesterstraße 113", "50823", "Köln", "", "Deutschland", "h-mueller@gmx.de", "0166/3703532"),
    ("RedDevil_LOL", "Frau", "Catharina", "Leipold", "Borker Straße 77", "29593", "Schwiebenau", "", "Deutschland", "catharina-leipold@company.net", "05822/775470541"),
    ("Gamer64", "Herr", "Jost", "Tautz", "Johannes-Grüter-Straße 94", "54426", "Breit", "", "Deutschland", "jost.tautz@hotmail.none", "0172/33254654"),
	("Ebay_Profi69", "Frau", "Heimgard", "Hoyer", "Habichtweg 27", "95666", "Mitterteich", "", "Deutschland", "heimgard.04@web.none", "0151/6141191"),
    ("Schalke-Rockt04", "Frau", "Regelindis", "Jakob", "Zum Wiesengrund 17", "73272", "Neidlingen", "", "Deutschland", "r1913@funmail.none", "0173/737380"),
    ("Coke_Zero", "Herr", "Burckhardt", "Beine", "Längenfeldweg 187", "27804", "Berne", "Keine Werbung", "Deutschland", "b_beine@trashmail.none", "0187/42069187"),
	("MLG v R3FL3X", "Herr", "Yannik", "Eichhorn", "Reifträgerweg 52", "55606", "Brauweiler", "", "Österreich", "y-eichhorn@mymail.none", "04156/64165814"),
     ("GZUZ_187", "Herr", "Dietbert", "Löb", "Im Blauen Garn 23", "79595", "Rümmingen", "", "Schweiz", "dietbert-1998@domain.none", "07621/74071473");
     
##select * from Kunden;				##Tabelle Kunden anzeigen
    
#Kategorietabelle bestücken
insert into Kategorie (Kategoriename)
values    
	("Anhänger"),
	("Applikationen Bügelbilder"),   
    ("Bastelmaterial"),
    ("Bodyverschluss"),
    ("Etiketten"),
    ("Filze"),
    ("Leder Material"),
    ("Satinbänder"),
    ("Schlüsselringe"),
    ("Stoffe"),
    ("Webbänder");
    
##select * from Kategorie;		##Tabelle Kategorie anzeigen

#Artikeltabelle bestücken
insert into Artikel (Bezeichnung, Stueckpreis, Artikelbeschreibung, Material, Farbe, Steuersatz, Groesse, Kategorie_ID_Fremd)
values
	("10 ANHÄNGER EULE", 1.99, "11x18mm Armband Kettenanhänger silber Charms", "Metall", "Silber", 7, "Durchmesser 12mm", 1),
    ("10 ANHÄNGER Baum RUND", 2.99, "Armband Kettenanhänger messing Bäume Charms", "Metall", "Silber", 7, "11x18mm",  1),
    ("Applikation Herz Einhorn", 1.99, "Happy Day doppelseitigen Pailletten 15x16,5cm Unikorn", "", "", 7, "15x16,5cm", 2),
    ("Applikation Eule", 1.99, "Aufnäher Aufbügler Bügelbild rot bordeaux", "", "", 7, "5x6,5cm", 2),
    ("Kissenfüllung", 3.99, "Füllung aus Schaumstoff Flocken 500 g Sofakissen Plüschtier", "", "", 7, "500Gramm", 3),
    ("5m Druckknopfband schwarz", 7.49, "Bodyverschluss Druckknopfverschluss Druckknopf", "", "", 7, "18mm x 5m", 4),
    ("Aufnäher Textiletiketten Prinzessin", 2.49, "lila gelb Krone-gold", "", "", 7, "1,5 x 6 cm", 5),
    ("1m Webband Tropfen", 1.40, "Paisley Farbenmix 12mm dunkelblau", "Polyester", "Blau", 7, "12 mm breit", 11);
    
##select * from Artikel;  	##Tabelle Artikel anzeigen

#Lagertabelle befüllen
insert into Lager (Artikel_ID_Fremd, Anzahl)
values
	(1, 27),
    (2, 6),
    (3, 12),
    (4, 900),
    (5, 28),
    (6, 88),
    (7, 96),
    (8, 4);
##select*from Lager;		##Tabelle Lager anzeigen

##drop table Lager, Artikel, Kategorie, Kunden;		##alle Tabellen löschen