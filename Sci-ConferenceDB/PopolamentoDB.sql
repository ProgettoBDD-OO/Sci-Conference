--Popolamento del DB
--N.B. 
--  gli organizzatori devono avere l'afferenza tra gli enti che organizzano la conferenza. 
--  gli ID numerici sono gli unici valori che NON devono essere contenuti tra gli apici.

--collocazioni
INSERT INTO collocazione VALUES
    (DEFAULT, 'Viale J. F. Kennedy 54, 80125 Napoli NA', 'Campania'), --3000
    (DEFAULT, 'Via Giovanni Paolo II 132, 25126', 'Lombardia'),
    (DEFAULT, 'Via del Politecnico 1, 00133', 'Lazio'),
    (DEFAULT, 'Via Università 100, 80055', 'Campania'),
    (DEFAULT, 'Via Giuseppe Moruzzi 1, 56124', 'Toscana'), --3004
    (DEFAULT, 'Via Irnerio 42, 40126', 'Emilia-Romagna'),
    (DEFAULT, 'Via Enrico Fermi 40, 00044', 'Lazio'),
    (DEFAULT, 'Via Alfonso Corti 12, 20133', 'Lombardia'), --3007
    (DEFAULT, 'Via Guglielmo Marconi 40, 00146', 'Lazio'),
    (DEFAULT, 'Via delle Scienze 206, 33100', 'Friuli Venezia Giulia'),
    (DEFAULT, 'Via San Francesco 22, 52100', 'Toscana'), --3010
    (DEFAULT, 'Via Vicinale Cupa Cintia 26, 80126 Napoli NA', 'Campania'),
    (DEFAULT, 'Via Claudio 21, 80125 Napoli NA', 'Campania'),
    (DEFAULT, 'Piazzale Vincenzio Tecchio 80, 80125 Napoli NA', 'Campania'),
    (DEFAULT, 'Viale Regina Margherita 6, 09125', 'Sardegna'), --3014
    (DEFAULT, 'Piazza Marina 61, 90133 Palermo PA', 'Sicilia'),
    (DEFAULT, 'Via Francesco Sforza 35, 20122', 'Lombardia'),
    (DEFAULT, 'Via delle Scienze Ed. 18, 33100', 'Friuli Venezia Giulia'),
    (DEFAULT, 'Piazzale Aldo Moro 5, 00185', 'Lazio'),
    (DEFAULT, 'Piazza Domenicani 3, 53100', 'Toscana'), --3019
    (DEFAULT, 'Via Alfonso Corti 12, 20133', 'Lombardia'),
    (DEFAULT, 'Via Mazzini 122, 70022', 'Puglia'),
    (DEFAULT, 'Via Goffredo Mameli 39, 09123', 'Sardegna'), --3022
    (DEFAULT, 'Via Valerio Flacco 7, 00193', 'Lazio'),
    (DEFAULT, 'Dorsoduro 3246, 30123', 'Veneto'),
    (DEFAULT, 'Via Balbi 5, 16126', 'Liguria'),
    (DEFAULT, 'Via Sant''Ottavio 12, 10124', 'Piemonte'),
    (DEFAULT, 'Via Lodovico Menicucci 6, 60121', 'Marche'),
    (DEFAULT, 'Piazza Università 1, 06123', 'Umbria'); --3028
--




-- conferenze
INSERT INTO conferenza VALUES
    (DEFAULT, 'Saggitarius A*', '2023-04-27', '2023-04-29', 'Come e perché fotografare buchi neri.', 'Astrologia', 3000), --1000
    (DEFAULT, 'Città Verde', '2023-12-27', '2023-12-28', 'Discussione di piani volti al miglioramento della vita in città tramite la realizzazione di nuove aree verdi', 'Sostenibilità', 3014),
    (DEFAULT, 'Digitalizzare il Paese', '2023-05-17', '2023-05-19', 'Una discussione sullo sviluppo tecnologico nel nostro paese.', 'Informatica', 3010), --1002
    (DEFAULT, 'L''Atomica di Oppenheimer', '2024-02-13', '2024-02-15', 'Chi, come e cosa portò la creazione dell''ordigno nucleare.', 'Fisica', 3012),
    (DEFAULT, 'Oltrepassando un wormhole...', '2023-12-02', '2023-12-03', 'Alla scoperta dei "tunnel spaziali" ipotizzati da Einstein e Ross che permetterebbero il viaggio nel tempo', 'Astrologia', 3022),
    (DEFAULT, 'La teoria delle stringhe', '2023-09-18', '2023-09-24', 'Su cosa si basa e perché è così importante.', 'Fisica', 3017), --1005
    (DEFAULT, 'IA', '2023-10-17', '2023-10-20', 'Presentazione dei recenti sviluppi della nuova frontiera dell''intelligenza artificiale.', 'Informatica', 3022),
    (DEFAULT, 'Il telescopio di Galileo', '2023-05-10', '2023-05-12', 'Ricostruzione degli eventi che portarono l''astronomo Galileo Galilei alla creazione di un oggetto ancora oggi fondamentale.', 'Astrologia', 3016),
    (DEFAULT, 'Heisenberg', '2023-09-24', '2023-09-27', 'Esposizione delle principali scoperte fisiche del premio Nobel Werner Heisenberg', 'Fisica', 3013),
    (DEFAULT, 'Europa, Ganymede, Callisto e...', '2023-11-27', '2023-11-30', 'Discussione sulle recenti conquiste spaziali come la scoperta di nuove lune di Giove', 'Astrologia', 3011), --1009
    (DEFAULT, 'Chimica moderna', '2023-03-20', '2023-03-22', 'Uno sguardo alle origini della chimica', 'Chimica', 3004), --1010
    (DEFAULT, 'Ieri, Oggi, Domani', '2023-04-25', '2023-04-30', 'La storia del nostro pianeta e di come lo abbiamo abbandonato', 'Ambiente', 3024),
    (DEFAULT, 'Più futuro per noi', '2023-06-18', '2023-06-20', 'Una raccolta di esperienze da chi ha fatto la differenza', 'Ambiente', 3009),
    (DEFAULT, 'Affidiamoci ai girasoli', '2023-08-02', '2023-08-02', 'Imparando ad adottare i pannelli solari come energia ecosostenibile', 'Sostenibilità', 3025), --1013
    (DEFAULT, 'Un cielo sano', '2023-03-24', '2023-03-25', 'Discussione sugli effetti degli agenti inquinanti nell''atmosfera', 'Sostenibilità', 3023),
    (DEFAULT, 'Alta quota', '2023-05-15', '2023-05-19', 'Insieme al Premio Nobel per la Fisica Antonio Calcasti per conoscere le leggi che alzano in volo gli aerei', 'Fisica', 3026),
    (DEFAULT, 'FISICAmente', '2023-10-20', '2023-10-23', 'Insegnare il mondo della fisica ai più piccoli con le giostre e tanti altri esempi divertenti', 'Fisica', 3027),
    (DEFAULT, 'Una svolta rara', '2023-06-01', '2023-06-01', 'Commenti a caldo sulla scoperta del nuovo maxi-giacimento di Terre rare in Svezia', 'Geologia', 3028), --1017
    (DEFAULT, 'La schiena della Terra', '2023-12-10', '2023-12-12', 'In compagnia di veri geologi per capire come si formarono le Alpi', 'Geologia', 3015),
    (DEFAULT, 'Il bar della Scienza', '2023-09-15', '2023-09-26', 'La scienza che ci aiuta a preparare i drink', 'Chimica', 3021), --1019
    (DEFAULT, 'Tutto ha un peso', '2023-04-23', '2023-04-26', 'Scoprendo il bosone di Higgs e che ruolo svolge nell''universo', 'Fisica', 3017),
    (DEFAULT, 'Hacking etico', '2024-01-02', '2024-01-04', 'Capire l''Hacking etico e i suoi benefici', 'Informatica', 3023), --1021
    (DEFAULT, 'I computer del futuro', '2023-04-12', '2023-04-13', 'In concomitanza di un informatico Google all''interno dei computer quantistici e dei loro segreti', 'Informatica', 3015),
    (DEFAULT, 'Un''invenzione geniale', '2024-02-20', '2024-02-21', 'Ripercorrendo le origini dei numeri e i suoi più grandi quesiti posti fino ad oggi', 'Matematica', 3020), --1023
    (DEFAULT, 'Quando tutto ha un senso', '2023-11-15', '2023-11-15', 'In compagnia del Nobel per la matematica Manuel Vestari capiamo come tutto sia connesso ai numeri', 'Matematica', 3005),
    (DEFAULT, 'Non una qualunque', '2023-12-28', '2023-12-30', 'La storia della stella che ci accompagna da milioni di anni', 'Astrologia', 3011), --1025
    (DEFAULT, 'Gemelli stellari', '2023-05-29', '2023-06-05', 'Alla scoperta di pianeti e stelle a noi simili, partendo da Mercurio, Proxima Centauri ed allontanandoci sempre più!', 'Astrologia', 3018),
    (DEFAULT, 'La scienza della vita', '2024-01-27', '2024-02-04', 'L''evoluzione della nostra specie così come non l''avete mai vista', 'Biologia', 3008),
    (DEFAULT, 'I colori della natura', '2023-10-29', '2023-10-30', 'I mille aspetti della natura e dei suoi abitanti', 'Biologia', 3001), --1028
    (DEFAULT, 'Geologia Applicata', '2024-02-10', '2024-02-12', 'Discussione sulle applicazioni della geologia in campo ambientale, industriale e infrastrutturale.', 'Geologia', 3000); --1029
--




--enti
INSERT INTO ente VALUES
    ('null'),
    ('Università degli Studi di Napoli Federico II'),
    ('Università degli Studi di Salerno'),
    ('Università degli Studi di Bologna'),
    ('Università degli Studi di Palermo'),
    ('Università degli Studi di Firenze'),
    ('Università degli Studi di Milano'),
    ('Università degli Studi di Udine'),
    ('Università degli Studi di Trieste'),
    ('Università degli Studi di Cagliari'),
    ('Università degli Studi di Trento'),
    ('Università degli Studi di Torino'),
    ('Università Ca'' Foscari di Venezia'),
    ('Università degli Studi di Roma Tor Vergata'),
    ('Università degli Studi di Genova'),
    ('Università degli Studi di Padova'),
    ('Università degli Studi di Bari Aldo Moro'),
    ('Università degli Studi di Verona'),
    ('Università degli Studi di Sassari'),
    ('Università degli Studi di Brescia'),
    ('Università degli Studi del Sannio'),
    ('Università degli Studi di Siena'),
    ('Università degli Studi di Perugia'),
    ('Università degli Studi dell''Aquila'),
    ('Università del Salento'),
    ('Università di Pisa'),
    ('Università Politecnica delle Marche'),
    ('Università degli Studi di Roma "La Sapienza"'),
    ('Università degli Studi di Milano-Bicocca'),
    ('Politecnico di Milano'),
    ('Politecnico di Bari'),
    ('IGAG'),
    ('IGM'),
    ('INFN'),
    ('Google LLC'),
    ('FIT'),
    ('Comune di Roma'),
    ('Regione Lazio'),
--


--organizzazioni
INSERT INTO organizzazione VALUES
    (1000, 'Università degli Studi di Napoli Federico II'), (1000, 'Università degli Studi di Salerno'),

    (1001, 'Università degli Studi di Cagliari'), (1001, ),

    (1002, ), (1002, ), (1002, ),

    (1003, ), (1003, ),

    (1004, ), (1004, ), (1004, ),

    (1005, ), (1005, ),

    (1006, ),

    (1007, ), (1007, ),

    (1008, ),

    (1009, ), (1009, ),

    (1010, ), (1010, ), (1010, ),

    (1011, ), (1011, ),

    (1012, ), (1012, ),

    (1013, ),

    (1014, ),

    (1015, ), (1015, ),

    (1016, ),

    (1017, ), (1017, ),

    (1018, ), (1018, ), (1018, ),

    (1019,'Università degli Studi di Bari Aldo Moro'), (1019,'Politecnico di Bari'), (1019,'Università del Salento'),

    (1020,'Università degli Studi di Trieste'), (1020,'FIT'), (1020,'IGM'),

    (1021,'Università degli Studi di Roma "La Sapienza"'), (1021,'Comune di Roma'), (1021,'Regione Lazio'),

    (1022, 'Università degli Studi di Palermo'), (1022, 'Google LLC'),

    (1023, 'Università degli Studi di Milano'), (1023, 'Università degli Studi di Brescia'), (1023, 'INFN'),

    (1024, ), (1024, ), (1024, ),

    (1025, ), (1025, ),

    (1026, ), (1026, ), (1026, ),

    (1027, ),

    (1028, ), (1028, ),

    (1029, ), (1029, );
--




--sponsor
INSERT INTO sponsor VALUES
    ('Celestron Italia'),
    ('BioTech Italia '),
    ('NanoTech Innovations'),
    ('Dispositivi Medici Innovativi'),
    ('BioTech Solutions'),
    ('Quantum Dynamics'),
    ('NanoGen'),
    ('GenoSys'),
    ('LabPro'),
    ('Cybex Pharmaceuticals'),
    ('NeuroTech Innovations'),
    ('MedGenix'),
    ('AstralTech'),
    ('NanoVision'),
    ('BioGenetics Inc.'),
    ('LabSolutions'),
    ('BioLab Italia'),
    ('QuantumTech Solutions'),
    ('AstroLab Italia'),
    ('NeuroSynth'),
    ('SynthiPharma'),
    ('OptoGen'),
    ('BioAnalytica'),
    ('MedTech Innovations'),
    ('NanoStrumenti'),
    ('GenoPharma Italia');
--


--sponsorizzazioni
INSERT INTO sponsorizzazione VALUES
    (1000, 'Celestron Italia'), (1000, ), (1000, ),

    (1001, ), (1001, ),

    (1002, ), (1002, ), (1002, ),

    (1003, ),

    (1004, ), (1004, ),

    (1005, ),

    (1006, ), (1006, ),

    (1007, ), (1007, ), (1007, ),

    (1008, ),

    (1009, ), (1009, ),

    (1010, ), (1010, ),

    (1011, ),

    (1012, ), (1012, ), (1012, ),

    (1013, ), (1013, ),

    (1014, ),

    (1015, ),

    (1016, ), (1016, ),

    (1017, ), (1017, ),

    (1018, ), (1018, ), (1018, ), (1018, ),

    (1019, ), (1019, ), (1019, ),

    (1020, ), (1020, ),

    (1021, ), (1021, ),

    (1022, ), (1022, ),

    (1023, ), (1023, ),

    (1024, ), (1024, ), (1024, ),

    (1025, ), (1025, ),

    (1026, ), (1026, ),

    (1027, ), (1027, ), (1027, ), (1027, ),

    (1028, ), (1028, ), (1028, ),

    (1029, );
--




--organizzatori
INSERT INTO organizzatore VALUES
    ('giandomenico.lavazza@unina.it', 'Dottore', 'Giandomenico', 'Lavazza', 'Università degli Studi di Napoli Federico II'),
    ('sofia.nerano@docenti.unina.it', 'Professoressa', 'Sofia', 'Nerano', 'Università degli Studi di Napoli Federico II'),
    ('federico.santoro@unina.it', 'Professore', 'Federico', 'Santoro', 'Università degli Studi di Napoli Federico II'),
    ('alessandra.fiore@unina.it', 'Professoressa', 'Alessandra', 'Fiore', 'Università degli Studi di Napoli Federico II'),
    ('anna.bianchi@unifi.it', 'Professoressa', 'Anna', 'Bianchi', 'Università degli Studi di Firenze'),
    ('tommaso.fabbri@unipi.it', 'Professore', 'Tommaso', 'Fabbri', 'Università di Pisa'),
    ('eugenio.storti@unipi.it', 'Professore', 'Eugenio', 'Storti', 'Università di Pisa'),
    ('claudia.moneta@unisi.it', 'Professoressa', 'Claudia', 'Moneta', 'Università degli Studi di Siena'),
    ('alberto.moro@unisa.it', 'Professore', 'Alberto', 'Moro', 'Università degli Studi di Salerno'),
    ('chiara.grieco@unica.it', 'Dottoressa', 'Chiara', 'Grieco', 'Università degli Studi di Cagliari'),
    ('franco.manca@unica.it', 'Dottore', 'Franco', 'Manca', 'Università degli Studi di Cagliari'),
    ('ugo.pinna@unica.it', 'Professore', 'Ugo', 'Pinna', 'Università degli Studi di Cagliari'),
    ('manco.piras@unica.it', 'Dottore', 'Manco', 'Piras', 'Università degli Studi di Cagliari'),
    ('francesco.tozzi@unica.it', 'Dottore', 'Francesco', 'Tozzi', 'Università degli Studi di Cagliari'),
    ('giulia.verdi@uniba.it', 'Professoressa', 'Giulia', 'Verdi', 'Università degli Studi di Bari Aldo Moro'),
    ('andrea.esposito@poliba.it', 'Ricercatore', 'Andrea', 'Esposito', 'Politecnico di Bari'),
    ('martina.russo@unile.it', 'Dottore', 'Martina', 'Russo', 'Università del Salento'),
    ('marco.bianchi@uniba.it', 'Docente', 'Marco', 'Bianchi', 'Università degli Studi di Bari Aldo Moro'),
    ('alessia.moretti@poliba.it', 'Ricercatrice', 'Alessia', 'Moretti', 'Politecnico di Bari'), 
    ('carlo.franchi@fitresearch.org', 'Direttore di Ricerca', 'Carlo', 'Franchi', 'FIT'),
    ('mattia.orlando@fitresearch.org', 'Co-Direttore di Ricerca', 'Mattia', 'Orlando', 'FIT'),
    ('gioia.cavallo@uniroma.it', 'Assistente Ricercatrice', 'Gioia', 'Cavallo', 'Università degli Studi di Roma "La Sapienza"'),
    ('salvatore.fabrico@uniroma.it', 'Ricercatore', 'Salvatore', 'Fabrico', 'Università degli Studi di Roma "La Sapienza"'),
    ('raul.sozzi@uniroma.it', 'Programmatore Senior', 'Raul', 'Sozzi', 'Università degli Studi di Roma "La Sapienza"'),
    ('giovanni.fulco@unipa.it', 'Professore', 'Giovanni', 'Fulco', 'Università degli Studi di Palermo'),
    ('mattia.pizzo@unipa.it', 'Professore', 'Mattia', 'Pizzo', 'Università degli Studi di Palermo'),
    ('marco.messina@unipa.it', 'Professore', 'Marco', 'Messina', 'Università degli Studi di Palermo'),
    ('umberto.saporetti@infn.it', 'Fisico teorico nucleare', 'Umberto', 'Saporetti', 'INFN'),
    ('vanessa.eulero@unibo.it', 'Docente universitaria', 'Vanessa', 'Eulero', 'Università degli Studi di Bologna'),
    ('carmine.runica@unina.it', 'Docente universitario', 'Carmine', 'Runica', 'Università degli Studi di Napoli Federico II'),
    ('stefano.clessidri@uniroma.it', 'Amministratore universitario', 'Stefano', 'Clessidri', 'Università degli Studi di Roma "La Sapienza"'),
    ('olivia.ondanti@unimi.it', 'Professoressa', 'Olivia', 'Ondanti', 'Università degli Studi di Milano'),
    ('luca.denanni@unina.it', 'Collaboratore ambientale', 'Luca', 'De Nanni', 'Università degli Studi di Napoli Federico II'),
    ('jack.roshfert@IAMCresearch.org', 'Analista marino', 'Jack', 'Roshfert', 'IAMC'),
--


--comitati scientifici
INSERT INTO comitato_scientifico VALUES
    (1000, 'giandomenico.lavazza@unina.it'), (1000, 'sofia.nerano@docenti.unina.it'), (1000, 'alberto.moro@unisa.it'),

    (1001, 'chiara.grieco@unica.it'), (1001, 'franco.manca@unica.it'), (1001, 'ugo.pinna@unica.it'), (1001, 'francesco.tozzi@unica.it'), (1001, 'manco.piras@unica.it'),

    (1002, 'anna.bianchi@unifi.it'), (1002, 'tommaso.fabbri@unipi.it'), (1002, 'eugenio.storti@unipi.it'), (1002, 'claudia.moneta@unisi.it'),

    (1003, ), (1003, ), (1003, ), (1003, ), (1003, ),

    (1004, ), (1004, ), (1004, ),

    (1005, ), (1005, ), (1005, ), (1005, ), (1005, ),

    (1006, ), (1006, ), (1006, ), (1006, ), (1006, ),

    (1007, ), (1007, ), (1007, ), (1007, ),

    (1008, ), (1008, ), (1008, ), (1008, ), (1008, ),

    (1009, ), (1009, ), (1009, ),

    (1010, ), (1010, ), (1010, ),

    (1011, ), (1011, ), (1011, ), (1011, ),

    (1012, ), (1012, ), (1012, ),

    (1013, ), (1013, ), (1013, ), (1013, ), (1013, ),

    (1014, ), (1014, ), (1014, ),

    (1015, ), (1015, ), (1015, ), (1015, ), (1015, ),

    (1016, ), (1016, ), (1016, ), (1016, ), (1016, ),

    (1017, ), (1017, ), (1017, ), (1017, ),

    (1018, ), (1018, ), (1018, ), (1018, ), (1018, ),

    (1019, 'giulia.verdi@uniba.it'), (1019, 'andrea.esposito@poliba.it'), (1019, 'martina.russo@unile.it'), (1019, 'marco.bianchi@uniba.it'), (1019, 'alessia.moretti@poliba.it'),

    (1020, 'carlo.franchi@fitresearch.org'), (1020, 'mattia.orlando@fitresearch.org'),

    (1021, 'gioia.cavallo@uniroma.it'), (1021, 'salvatore.fabrico@uniroma.it'), (1021, 'raul.sozzi@uniroma.it'),

    (1022, 'giovanni.fulco@unipa.it'), (1022, 'mattia.pizzo@unipa.it'), (1022, 'marco.messina@unipa.it'),

    (1023, 'umberto.saporetti@infn.it' ),

    (1024, ), (1024, ), (1024, ), (1024, ), (1024, ),

    (1025, ), (1025, ), (1025, ), (1025, ),

    (1026, ), (1026, ), (1026, ), (1026, ), (1026, ),

    (1027, ), (1027, ), (1027, ), (1027, ), (1027, ),

    (1028, ), (1028, ), (1028, ), (1028, ), (1028, ),

    (1029, ), (1029, ), (1029, );
--




--keynote_speaker
INSERT INTO keynote_speaker VALUES
    ('Nessuno', 'null', 'null', 'null', 'null'),
    ('giorgio.parisi@unina.it', 'Professor', 'Giorgio', 'Parisi', 'Università degli Studi di Napoli Federico II'),
    ('elisa.rancati@unimib.it', 'Ricercatrice', 'Elisa', 'Rancati', 'Università degli Studi di Milano-Bicocca'),
    ('marco.costa@unifi.it', 'Ricercatore', 'Marco', 'Costa', 'Università degli Studi di Firenze'),
    ('adele.romano@uniroma1.it', 'Professoressa','Adele', 'Romano', 'Università degli Studi di Roma "La Sapienza"'),
    ('mfelicia.delaurentis@infn.it', 'Ricercatrice', 'Mariafelicia', 'De Laurentis', 'INFN'),
    ('antonio.marinelli@infn.it', 'Dottore', 'Antonio', 'Marinelli', 'INFN'),
    ('ilaria.mazzini@igag.cnr.it', 'Ricercatrice', 'Ilaria', 'Mazzini', 'IGAG'),
    ('grazia.caielli@igag.cnr.it', 'Ricercatrice', 'Grazia', 'Caielli', 'IGAG'),
    ('johnkrasinski@gmail.com', 'Informatico', 'John', 'Krasinski', 'Google LLC'),
    ('vittoria.cerasi@unimib.it', 'Professoressa',  'Vittoria',  'Cerasi',  'Università degli Studi di Milano-Bicocca'),
    ('alberto.piras@unica.it', 'Dottore', 'Alberto', 'Piras', 'Università degli Studi di Cagliari'),
    ('francesco.tozzi@unica.it', 'Dottore', 'Francesco', 'Tozzi', 'Università degli Studi di Cagliari'),
    ('francesco.fontana@unisi.it', 'Professore', 'Francesco', 'Fontana', 'Università degli Studi di Siena'),
    ('stefano.rinaldi@unipi.it', 'Professore', 'Stefano', 'Rinaldi', 'Università di Pisa'),
    ('matteo.lombardo@unina.it', 'Ricercatore', 'Matteo', 'Lombardo', 'Università degli Studi di Napoli Federico II'),
    ('riccardo.greco@unina.it', 'Professore', 'Riccardo', 'Greco', 'Università degli Studi di Napoli Federico II'),
    ('martina.esposito@unina.it', 'Dottoranda', 'Martina', 'Esposito', 'Università degli Studi di Napoli Federico II'),
    ('paola.doria@unina.it', 'Dottoranda', 'Paola', 'Doria', 'Università degli Studi di Napoli Federico II'),
    ('andrea.deluca@unisa.it', 'Professore', 'Andrea', 'De Luca', 'Università degli Studi di Salerno'),
    ('giulia.fabbri@univr.it', 'Ricercatrice', 'Giulia', 'Fabbri', 'Università degli Studi di Verona'),
    ('marta.arcopinto@uniss.it', 'Ricercatrice', 'Marta', 'Arcopinto', 'Università degli Studi di Sassari'),
    ('paolo.verdi@unimi.it', 'Professore', 'Paolo', 'Verdi', 'Università degli Studi di Milano'),
    ('simone.giorgi@uniba.it', 'Ricercatore', 'Simone', 'Giorgi', 'Università degli Studi di Bari Aldo Moro'),
    ('giuseppe.rosa@uniba.it', 'Ricercatore', 'Giuseppe', 'Rosa', 'Università degli Studi di Bari Aldo Moro'),
    ('matteo.rinaldi@uniba.it', 'Dottore', 'Matteo', 'Rinaldi', 'Università degli Studi di Bari Aldo Moro'),
    ('giovanni.rossi@uniba.it', 'Dottore', 'Giovanni', 'Rossi', 'Università degli Studi di Bari Aldo Moro'),
    ('davide.ferrari@poliba.it', 'Dottore', 'Davide', 'Ferrari', 'Politecnico di Bari'),
    ('elena.basile@univaq.it', 'Ricercatrice', 'Elena', 'Basile', 'Università degli Studi dell''Aquila'),
    ('lorenzo.sartori@unive.it', 'Ricercatore', 'Lorenzo', 'Sartori', 'Università Ca'' Foscari di Venezia'),
    ('alessandro.masiero@unipd.it', 'Dottore', 'Alessandro', 'Msiero', 'Università degli Studi di Padova'),
    ('giulia.ricci@uniroma1.it', 'Dottoressa', 'Giulia', 'Ricci', 'Università degli Studi di Roma "La Sapienza"'),
    ('sara.amato@unimi.it', 'Dottoranda', 'Sara', 'Amato', 'Università degli Studi di Milano'),
    ('roberto.moretti@unito.it', 'Professore', 'Roberto', 'Moretti', 'Università degli Studi di Torino'),
    ('emanuele.rizzo@unipa.it', 'Professore', 'Emanuele', 'Rizzo', 'Università degli Studi di Palermo'),
    ('davide.desantis@units.it', 'Ricercatore', 'Davide', 'De Santis', 'Università degli Studi di Trieste'),
    ('clara.svarloga@igm.cnr.it', 'Tecnica di laboratorio', 'Clara', 'Svarloga', 'IGM'),
    ('federica.baderoni@regionelazio.it', 'Programmatrice Senior', 'Federica', 'Baderoni', 'Regione Lazio'),
    ('rachele.tammaro@mi.infn.it', 'Analista dati sperimentali', 'Rachele', 'Tammaro', 'INFN'),
    ('giovanna.ambrosia@unibo.it', 'Ricercatrice senior', 'Giovanna', 'Ambrosio', 'Università degli Studi di Bologna'),
    ('maria.potta@unina.it', 'Collaboratrice di ricerca', 'Maria', 'Potta', 'Università degli Studi di Napoli Federico II'),
    ('mariateresa.screma@uniroma.it', 'Ricercatrice junior', 'Mariateresa', 'Screma', 'Università degli Studi di Roma "La Sapienza"'),
    ('antonio.botti@issroma.it', 'Biochimico', 'Antonio', 'Botti', 'ISS'),
    ('flavia.botti@issroma.it', 'Esperta di biologia', 'Flavia', 'Botti', 'ISS'),
    ('gabriele.errante@unimi.it', 'Professore', 'Gabriele', 'Errante', 'Università degli Studi di Milano'),
    ('melissa.altopiano@unina.it', 'Ricercatrice', 'Melissa', 'Altopiano', 'Università degli Studi di Napoli Federico II'),
--




--sessioni
INSERT INTO sessione VALUES
    (100001, '2023-04-27', '2023-04-27', 'Giandomenico Lavazza', 'giorgio.parisi@unina.it', 'Padiglione 4', 1000),
    (100002, '2023-04-27', '2023-04-27', 'Sofia Nerano', 'mfelicia.delaurentis@infn.it', 'Padiglione 4', 1000),
    (100003, '2023-04-28', '2023-04-28', 'Giandomenico Lavazza', 'antonio.marinelli@inaf.it', 'Padiglione 4', 1000),
    (100004, '2023-04-28', '2023-04-28', 'Sofia Nerano', 'mfelicia.delaurentis@infn.it', 'Padiglione 4', 1000),

    (100101, '2023-12-27', '2023-12-27', 'Chiara Greco', 'alberto.piras@unica.it', 'CeSAR', 1001),
    (100102, '2023-12-28', '2023-12-28', 'Chiara Greco', 'francesco.tozzi@unica.it', 'Edif. A', 1001),

    (100201, '2023-05-17', '2023-05-17', 'Anna Bianchi', 'francesco.fontana@unisi.it', 'Aula E10', 1002),
    (100202, '2023-05-18', '2023-05-19', 'Anna Bianchi', 'stefano.rinaldi@unipi.it', 'Pad. SUD', 1002),

    (100301, '2024-02-13', '2024-02-14', 'Alessandra Fiore', 'matteo.lombardo@unina.it', 'Aula Grassi', 1003),
    (100302, '2024-02-14', '2024-02-14', 'Alessandra Fiore', 'riccardo.greco@unina.it', 'Aula Grassi', 1003),
    (100303, '2024-02-15', '2024-02-15', 'Federico Santoro', 'andrea.deluca@unisa.it', 'Aula 2', 1003),

    (100401, '2023-12-02', '2023-12-02', 'Marco Drigo', 'Nessuno', 'Edif. 1', 1004),
    (100402, '2023-12-02', '2023-12-02', 'Marco Drigo', 'giulia.fabbri@univr.it', 'Edif. 1', 1004),
    (100403, '2023-12-03', '2023-12-03', 'Alberto Cescon', 'giulia.fabbri@univr.it', 'Edif. 1', 1004),
    (100404, '2023-12-03', '2023-12-03', 'Alberto Cescon', 'Nessuno', 'Edif. 1', 1004),

    (100501, '2023-09-18', '2023-09-20', 'Francesco Forte', 'Nessuno', 'Sala Zonta', 1005),
    (100502, '2023-09-21', '2023-09-21', 'Lorenzo Neri', 'Nessuno', 'Sala Zonta', 1005),
    (100503, '2023-09-22', '2023-09-23', 'Andrea Ratti', 'marco.costa@unifi.it', 'Sala Radis', 1005),
    (100504, '2023-09-24', '2023-09-24', 'Francesco Forte', 'marco.costa@unifi.it', 'Sala Radis', 1005),

    (100601, '2023-10-17', '2023-10-17', 'Marianna Solinas', 'Nessuno', 'Aula Magna', 1006),
    (100602, '2023-10-17', '2023-10-18', 'Marianna Solinas', 'marta.arcopinto@uniss.it', 'Aula Magna', 1006),
    (100603, '2023-10-19', '2023-10-20', 'Salvatore Sanna', 'Nessuno', 'Aula Magna', 1006),

    (100701, '2023-05-10', '2023-05-10', 'Claudia Ferrari', 'Nessuno', 'Pad. Ovest', 1007),
    (100702, '2023-05-11', '2023-05-12', 'Claudia Ferrari', 'paolo.verdi@unimi.it', 'Pad. Ovest', 1007),
    (100703, '2023-05-12', '2023-05-12', 'Claudia Ferrari', 'Nessuno', 'Pad. Ovest', 1007),

    (100801, '2023-09-24', '2023-09-24', 'Andrea Scognamiglio', 'simone.giorgi@uniba.it', 'Aula Fermi', 1008),
    (100802, '2023-09-24', '2023-09-24', 'Andrea Scognamiglio', 'Nessuno', 'Aula Fermi', 1008),
    (100803, '2023-09-25', '2023-09-26', 'Federico Santoro', 'Nessuno', 'Aula Fermi', 1008),
    (100804, '2023-09-26', '2023-09-26', 'Federico Santoro', 'matteo.lombardo@unina.it', 'Aula A4', 1008),
    (100805, '2023-09-26', '2023-09-27', 'Alessandra Fiore', 'martina.esposito@unina.it', 'Aula A4', 1008),

    (100901, '2023-11-27', '2023-11-27', 'Federica Tocchetti', 'Nessuno', 'Edif. 6', 1009),
    (100902, '2023-11-28', '2023-11-29', 'Federica Tocchetti', 'paola.doria@unina.it', 'Edif. 6', 1009),
    (100903, '2023-11-30', '2023-11-30', 'Valentina Esposito', 'Nessuno', 'Edif. 6', 1009),

    (101001, '2023-03-20', '2023-03-21', 'Michele Pardini', 'Nessuno', 'Pad. 3', 1010),
    (101002, '2023-03-22', '2023-03-22', 'Stefano Rinaldi', 'elena.basile@univaq.it', 'Pad. 3', 1010),

    (101101, '2023-04-25', '2023-04-25', 'Matteo Cardin', 'lorenzo.sartori@unive.it', 'Sala Verde', 1011),
    (101102, '2023-04-26', '2023-04-26', 'Matteo Cardin', 'Nessuno', 'Sala Verde', 1011),
    (101103, '2023-04-27', '2023-04-28', 'Alba Trevisan', 'Nessuno', 'Sala Azzurra', 1011),
    (101104, '2023-04-29', '2023-04-29', 'Sofia Ballarin', 'Nessuno', 'Sala Azzurra', 1011),
    (101105, '2023-04-29', '2023-04-30', 'Sofia Ballarin', 'alessandro.masiero@unipd.it', 'Sala Verde', 1011),

    (101201, '2023-06-18', '2023-06-19', 'Marco Rizzo', 'giuseppe.rosa@uniba.it', 'Aula 3', 1012),
    (101202, '2023-06-20', '2023-06-20', 'Marco Rizzo', 'simone.giorgi@uniba.it', 'Aula 3', 1012),

    (101301, '2023-08-02', '2023-08-02', 'Claudio Marinelli', 'Nessuno', 'Pad. A1', 1013),
    (101302, '2023-08-02', '2023-08-02', 'Giovanni Canepa', 'Nessuno', 'Pad. A1', 1013),

    (101401, '2023-03-24', '2023-03-25', 'Lorenza Donati', 'Nessuno', 'Pad. F', 1014),
    (101402, '2023-03-25', '2023-03-25', 'Lorenza Donati', 'giulia.ricci@uniroma1.it', 'Pad. F', 1014),
    (101403, '2023-03-25', '2023-03-25', 'Aurelio Mancini', 'Nessuno', 'Pad. D', 1014),

    (101501, '2023-05-15', '2023-05-15', 'Mario Rossi', 'Nessuno', 'Aula B2', 1015),
    (101502, '2023-05-15', '2023-05-15', 'Roberto Ferrero', 'Nessuno', 'Aula B4', 1015),
    (101503, '2023-05-16', '2023-05-18', 'Mario Rossi', 'sara.amato@unimi.it', 'Aula B2', 1015),
    (101504, '2023-05-19', '2023-05-19', 'Mario Rossi', 'roberto.moretti@unito.it', 'Aula B4', 1015),

    (101601, '2023-10-20', '2023-10-21', 'Giovanni Serra', 'Nessuno', 'Sala S1', 1016),
    (101602, '2023-10-22', '2023-10-23', 'Giovanni Serra', 'elena.basile@univaq.it', 'Sala S1', 1016),
    (101603, '2023-10-23', '2023-10-23', 'Alfredo Nappi', 'elena.basile@univaq.it', 'Sala S1', 1016),

    (101701, '2023-06-01', '2023-06-01', 'Alfonso Di Bene', 'vittoria.cerasi@unimib.it', 'Primo Piano Aula 24', 1017),
    (101702, '2023-06-01', '2023-06-01', 'Alfonso Di Bene', 'elisa.rancati@unimib.it', 'Primo Piano Aula 24', 1017),

    (101801, '2023-12-10', '2023-12-10', 'Pierfrancesco Gambino', 'Nessuno', 'Sala Polifunzionale 1', 1018),
    (101802, '2023-12-11', '2023-12-11', 'Giovanni Fulco', 'Nessuno', 'Sala Polifunzionale 1', 1018),
    (101803, '2023-12-12', '2023-12-12', 'Giovanni Fulco', 'emanuele.rizzo@unipa.it', 'Sala Polifunzionale 3', 1018),

    (101901, '2023-09-15', '2023-09-16', 'Giulia Verdi', 'matteo.rinaldi@uniba.it', 'Padiglione Aula 1', 1019),
    (101902, '2023-09-16', '2023-09-18', 'Andrea Esposito', 'davide.ferrari@poliba.it', 'Sala Conferenze 2', 1019),
    (101903, '2023-09-19', '2023-09-20', 'Martina Russo', 'Nessuno', 'Padiglione B Aula 3', 1019),
    (101904, '2023-09-21', '2023-09-24', 'Marco Bianchi', 'giovanni.rossi@uniba.it', 'Sala Studio Camera 4', 1019),
    (101905, '2023-09-21', '2023-09-26', 'Alessia Moretti', 'Nessuno', 'Padiglione C Aula 5', 1019),

    (102001, '2023-04-23', '2023-04-24', 'Carlo Franchi', 'Nessuno', 'Camera C Secondo Piano', 1020),
    (102002, '2023-04-25', '2023-04-26', 'Carlo Franchi', 'davide.desantis@units.it', 'Camera B Secondo Piano', 1020),
    (102003, '2023-04-25', '2023-04-26', 'Mattia Orlando', 'clara.svarloga@igm.cnr.it', 'Camera A Secondo Piano', 1020),

    (102101, '2024-01-02', '2024-01-02', 'Gioia Cavallo', 'federica.baderoni@regionelazio.it', 'Auditorium Sala 1', 1021),
    (102102, '2024-01-03', '2024-01-03', 'Salvatore Fabrico', 'federica.baderoni@regionelazio.it', 'Auditorium Sala 1', 1021),
    (102103, '2024-01-04', '2024-01-04', 'Raul Sozzi', 'federica.baderoni@regionelazio.it', 'Auditorium Sala 1', 1021),

    (102202, '2023-04-12', '2023-04-12', 'Elisa Di Bonito', 'johnkrasinski@gmail.com', 'Edificio 4 Aula F2', 1022),
    (102203, '2023-04-12', '2023-04-12', 'Elisa Di Bonito', 'johnkrasinski@gmail.com', 'Edificio 4 Aula F2', 1022),
    (102204, '2023-04-12', '2023-04-12', 'Elisa Di Bonito', 'johnkrasinski@gmail.com', 'Edificio 4 Aula F2', 1022),

    (102301, '2024-02-20', '2024-02-21', 'Umberto Saporetti', 'rachele.tammaro@mi.infn.it', 'Aula stampa Piano 4', 1023),

    (102401, '2023-11-15', '2023-11-15', 'Vanessa Eulero', 'giovanna.ambrosia@unibo.it', 'Aula principale Nord', 1024),

    (102501, '2023-12-28', '2023-12-28', 'Carmine Runica', 'maria.potta@unina.it', 'Edificio 7 Secondo piano', 1025),
    (102502, '2023-12-29', '2023-12-29', 'Carmine Runica', 'maria.potta@unina.it', 'Edificio 7 Secondo piano', 1025),
    (102503, '2023-12-30', '2023-12-30', 'Ichiga Quinti', 'maria.potta@unina.it', 'Edificio 7 Primo piano', 1025),

    (102601, '2023-05-29', '2023-05-30', 'Stefano Clessidri', 'mariateresa.screma@uniroma.it', 'Auditorium A', 1026),
    (102602, '2023-05-30', '2023-05-31', 'Andrea Ciubi', 'mariateresa.screma@uniroma.it', 'Auditorium B', 1026),

    (102701, '2024-05-30', '2024-05-31', 'Tania Blacher', 'antonio.botti@issroma.it', 'Padiglione 3A', 1027),
    (102702, '2024-05-30', '2024-05-31', 'Tania Blacher', 'flavia.botti@issroma.it', 'Padiglione 3A', 1027),

    (102801, '2023-10-29', '2023-10-30', 'Olivia Ondanti', 'gabriele.errante@unimi.it', 'Edificio B aula 6', 1028),
    
    (102901, '2024-02-10', '2024-02-10', 'Luca De Nanni', 'Nessuno', 'Complesso Ovest Sala riunioni', 1029),  --manca keynote
    (102902, '2024-02-11', '2024-02-11', 'Raimondo Squisiti', 'melissa.altopiano@unina.it', 'Complesso Ovest Sala riunioni', 1029),
    (102903, '2024-02-11', '2024-02-11', 'Raimondo Squisiti', 'melissa.altopiano@unina.it', 'Complesso Ovest Sala riunion', 1029),
    (102904, '2024-02-12', '2024-02-12', 'Jack Roshfert', 'Nessuno', 'Complesso Ovest Sala riunioni', 1029), --manca keynote
--



--interventi
--(id_intervento, 'ora:inizio', 'ora:fine', id_sessione, 'descrizione'),
INSERT INTO intervento VALUES
    (10190101, '10:00:00', '18:30:00', 101901, 'Giorno 1 - Intervallo dalle 12:00 alle 13:30 e Coffee Break dalle 16:30 alle 16:45'),
    (10190102, '10:00:00', '14:30:00', 101901, 'Giorno 2 - Intervallo dalle 12:00 alle 13:00'),
    (10190103, '15:00:00', '20:00:00', 101901, 'Giorno 2 - Intervallo dalle 17:00 alle 17:30'),
        
    (10190201, '15:00:00', '17:00:00', 101902, 'Giorno 2 - Coffee Break dalle 16:15 alle 16:30'),
    (10190202, '15:00:00', '20:00:00', 101902, 'Giorno 3 - Intervallo dalle 17:00 alle 17:30'),
    (10190203, '15:00:00', '18:30:00', 101902, 'Giorno 4 - Coffee Break dalle 16:45 alle 17:00'),

    (10190301, '10:00:00', '15:00:00', 101903, 'Giorno 5 - Intervallo dalle 13:00 alle 14:00'),
    (10190302, '17:30:00', '20:30:00', 101903, 'Giorno 6 - Intervallo dalle 18:45 alle 19:30'),

    (10190401, '13:00:00', '15:00:00', 101904,'Giorno 7 - Coffee Break dalle 14:00 alle 14:10'),
    (10190402, '13:00:00', '16:30:00', 101904,'Giorno 8 - Coffee Break dalle 14:00 alle 14:10'),
    (10190403, '13:00:00', '14:00:00', 101904,'Giorno 9'),
    (10190404, '13:00:00', '17:30:00', 101904,'Giorno 10 - Coffee Break dalle 14:00 alle 14:10'),

    (10190501, '11:30:00', '16:45:00', 101905,'Giorno 7 - Intervallo dalle 15:00 alle 15:30'),
    (10190502, '14:15:00', '19:20:00', 101905,'Giorno 8 - Intervallo dalle 17:00 alle 18:00'),
    (10190503, '10:50:00', '17:00:00', 101905,'Giorno 9 - Intervallo dalle 12:00 alle 13:30 e Coffee Break dalle 16:00 alle 16:10'),
    (10190504, '12:40:00', '20:15:00', 101905,'Giorno 10 - Intervallo dalle 15:00 alle 15:30 e Coffee Break dalle 18:30 alle 18:45'),
    (10190505, '15:25:00', '18:30:00', 101905,'Giorno 11 - Coffee Break dalle 17:00 alle 17:20'),
    (10190506, '13:55:00', '18:10:00', 101905,'Giorno 12 - Coffee Break dalle 17:00 alle 17:10'),


    (10200101, '08:00:00', '12:00:00', 102001, 'Giorno 1 - Intervallo dalle 10:00 alle 10:30'),
    (10200102, '08:00:00', '12:00:00', 102001, 'Giorno 2 - Intervallo dalle 10:00 alle 10:30'),

    (10200201, '08:00:00', '12:00:00', 102002, 'Giorno 3 - Intervallo dalle 10:00 alle 10:30'),
    (10200202, '09:00:00', '15:00:00', 102002, 'Giorno 4 - Intervallo dalle 12:00 alle 13:00'),
    (10200301, '08:00:00', '12:00:00', 102003, 'Giorno 3 -Intervallo dalle 10:00 alle 10:30'),
    (10200302, '09:00:00', '15:00:00', 102003, 'Giorno 4 -Intervallo dalle 12:00 alle 13:00'),


    (10210101, '10:00:00', '12:00:00', 102101, 'Giorno 1 - Coffee Break dalle 11:00 alle 11:05'),          
       
    (10210201, '10:00:00', '14:00:00', 102102, 'Giorno 2 - Coffee Break dalle 11:00 alle 11:15'),    
    (10210202, '15:00:00', '19:00:00', 102102, 'Giorno 2 - Coffee Break dalle 17:00 alle 17:10'),     

    (10210301, '10:00:00', '14:00:00', 102103, 'Giorno 3 - Coffee Break dalle 11:00 alle 11:15'),     
    (10210302, '15:00:00', '19:00:00', 102103, 'Giorno 3 - Coffee Break dalle 17:00 alle 17:10'),


    (10230101, '14:00:00', '18:00:00', 102301, 'Giorno 1 - Intervallo dalle 16:00 alle 16:20'),          
    (10230102, '15:00:00', '16:00:00', 102301, 'Giorno 2'),
    (10230103, '16:30:00', '18:00:00', 102301, 'Giorno 2'),
--




--partecipanti
--(stesso formato di organizzatori e keynote_speaker)
INSERT INTO partecipante VALUES
    ('salvatore.sannazaro@uniba.it', 'Professore', 'Salvatore', 'Sannazaro', 'Università degli Studi di Bari Aldo Moro'),
    ('carmine.campidoglio@poliba.it', 'Dottore', 'Carmine', 'Campidoglio', 'Politecnico di Bari'),
    ('sara.vallata@poliba.it', 'Dottore', 'Sara', 'Vallata', 'Politecnico di Bari'),
    ('giovanna.arrao@uniba.it', 'Professoressa', 'Giovanna', 'Arrao', 'Università degli Studi di Bari Aldo Moro'),
    ('luca.ariosto@uniba.it', 'Dottore', 'Luca', 'Ariosto', 'Università degli Studi di Bari Aldo Moro'),
    ('carlo.zari@unile.it', 'Dottore', 'Carlo', 'Zari', 'Università del Salento'),
    ('mario.stasi@poliba.it', 'Professore', 'Mario', 'Stasi', 'Politecnico di Bari'),
    ('annarita.cielo@uniba.it', 'Dottore', 'Annarita', 'Cielo', 'Università degli Studi di Bari Aldo Moro'),
    ('chiara.devito@unile.it', 'Dottore', 'Chiara', 'De Vito', 'Università del Salento'),
    ('tommaso.schiatti@uniba.it', 'Professore', 'Tommaso', 'Schiatti', 'Università degli Studi di Bari Aldo Moro'),
    ('ugo.piscopo@uniba.it', 'Dottore', 'Ugo', 'Piscopo', 'Università degli Studi di Bari Aldo Moro'),
    ('flavia.ricciardi@unile.it', 'Dottore', 'Flavia', 'Ricciardi', 'Università del Salento'),
    ('carlo.ghianda@unile.it', 'Professore', 'Carlo', 'Ghianda', 'Università del Salento'),
    ('paolo.montagna@poliba.it', 'Professore', 'Paolo', 'Montagna', 'Politecnico di Bari'),
    ('umberto.gioia@uniba.it', 'Dottore', 'Umberto', 'Gioia', 'Università degli Studi di Bari Aldo Moro'),
    ('gennaro.ariosto@fitresearch.org', 'Ricercatore', 'Gennaro', 'Ariosto', 'FIT'),
    ('paolo.perforza@fitresearch.org', 'Assegnista di ricerca', 'Paolo', 'Perforza', 'FIT'),
    ('mario.doccia@units.it', 'Professore', 'Mario', 'Doccia', 'Università degli Studi di Trieste'),
    ('mariangela.cartini@igm.cnr.it', 'Dottore', 'Mariangela', 'Cartini', 'IGM'),
    ('emanuele.dellarossa@comune.roma.it', 'Ingengere Informatico', 'Emanuele', 'Della Rossa', 'Comune di Roma'),
    ('nicola.ontario@uniroma.it', 'Docente universitario', 'Nicola', 'Ontario', 'Università degli Studi di Roma "La Sapienza"'),
    ('davide.stella@regionelazio.it', 'Responsabile dell''Ufficio Tecnico', 'Davide', 'Stella', 'Regione Lazio'),
    ('wang.ferrari@uniroma.it', 'Programmatore Senior', 'Wang', 'Ferrara', 'Università degli Studi di Roma "La Sapienza"'),
    ('chiara.bomoldi@regionelazio.it', 'Responsabile dell''Ufficio Tecnico', 'Chiara', 'Bomoldi', 'Regione Lazio'),
    ('filippo.prosima@unimi.it', 'Ricercatore', 'Filippo', 'Prosima', 'Università degli Studi di Milano'),
    ('filippo.centauri@unimi.it', 'Docente universitario', 'Filippo', 'Centauri', 'Università degli Studi di Milano'),
    ('domenico.tuono@unibs.it', 'Ricercatore', 'Domenico', 'Tuono', 'Università degli Studi di Brescia'),
    ('raffaele.gelo@unimi.it', 'Docente universitario', 'Raffaele', 'Gelo', 'Università degli Studi di Milano'),
    ('alessio.sole@unimi.it', 'Docente universitario', 'Alessio', 'Sole', 'Università degli Studi di Milano');
--


--partecipazione
--(idintervento, 'email partecipante')
INSERT INTO partecipazione VALUES
    (10190101,'salvatore.sannazaro@uniba.it'), (10190101,'carmine.campidoglio@poliba.it'),
    (10190102,'salvatore.sannazaro@uniba.it'), (10190102,'sara.vallata@poliba.it'),
    (10190103,'giovanna.arrao@uniba.it'), (10190103,'luca.ariosto@uniba.it'),
    (10190201,'carlo.zari@unile.it'), (10190201,'mario.stasi@poliba.it'),
    (10190202,'carlo.zari@unile.it'), (10190202,'mario.stasi@poliba.it'),
    (10190203,'carlo.zari@unile.it'), (10190203,'mario.stasi@poliba.it'),
    (10190301,'annarita.cielo@uniba.it'), (10190301,'chiara.devito@unile.it'),
    (10190302,'annarita.cielo@uniba.it'), (10190302,'tommaso.schiatti@uniba.it'),
    (10190401,'annarita.cielo@uniba.it'), (10190401,'chiara.devito@unile.it'),
    (10190402,'annarita.cielo@uniba.it'), (10190402,'tommaso.schiatti@uniba.it'), 
    (10190403,'ugo.piscopo@uniba.it'), (10190403,'flavia.ricciardi@unile.it'),
    (10190404,'ugo.piscopo@uniba.it'), (10190404,'flavia.ricciardi@unile.it'),   
    (10190501,'salvatore.sannazaro@uniba.it'), (10190501,'carmine.campidoglio@poliba.it'),
    (10190502,'salvatore.sannazaro@uniba.it'), (10190502,'mario.stasi@poliba.it'), 
    (10190503,'carlo.zari@unile.it'), (10190503,'chiara.devito@unile.it'),
    (10190504,'carlo.zari@unile.it'), (10190504,'carlo.ghianda@unile.it'),   
    (10190505,'ugo.piscopo@uniba.it'), (10190505,'paolo.montagna@poliba.it'), (10190505,'carlo.ghianda@unile.it'),
    (10190506,'ugo.piscopo@uniba.it'), (10190506,'paolo.montagna@poliba.it'), (10190506,'umberto.gioia@uniba.it'),

    (10200102,'gennaro.ariosto@fitresearch.org'),
    (10200201,'mario.doccia@units.it'),
    (10200202,'paolo.perforza@fitresearch.org'),
    (10200301,'mariangela.cartini@igm.cnr.it'),
    (10200302,'mariangela.cartini@igm.cnr.it'),

    (10210101,'emanuele.dellarossa@comune.roma.it'),
    (10210201,'nicola.ontario@uniroma.it'), (10210201, 'davide.stella@regionelazio.it'),
    (10210202,'nicola.ontario@uniroma.it'), (10210202, 'davide.stella@regionelazio.it'),
    (10210301,'wang.ferrari@uniroma.it'), (10210301, 'chiara.bomoldi@regionelazio.it'),
    (10210302,'wang.ferrari@uniroma.it'), (10210302,'chiara.bomoldi@regionelazio.it'),

    (10230102,'filippo.prosima@unimi.it'), (10230102,'filippo.centauri@unimi.it'), (10230102,'domenico.tuono@unibs.it'),
    (10230103,'raffaele.gelo@unimi.it'), (10230103,'alessio.sole@unimi.it'), (10230103, 'domenico.tuono@unibs.it'),
--




-- proposte bacheca
INSERT INTO proposta_bacheca VALUES
    (DEFAULT, 'Il nucleare: pro e contro', 'L''energia nucleare è davvero la soluzione all''inquinamento del nostro pianeta?', 'Sostenibilità'),
    (DEFAULT, 'Andare su Marte', 'Tra quanto l''uomo riuscirà nell''impresa epocale di raggiungere il pianeta rosso?', 'Astrologia'),
    (DEFAULT, 'I progressi della medicina', 'Quali sono stati gli ultimi progressi in ambito della medicina e quali saranno i prossimi?', 'Medicina'),
    (DEFAULT, 'Proteggere', 'Bisogna incrementare le aree protette del nostro pianeta.', 'Ambiente'),
    (DEFAULT, 'Il ruolo dello psicologo', 'In questi giorni difficili per i giovani è necessario sensibilizzare la figura dello psicologo.', 'Psicologia'),
    (DEFAULT, 'AI: passato, presente e futuro', 'Progresso dell''intelligenza artificiale nel corso degli anni e possibili direzioni future.', 'Informatica'),
    (DEFAULT, 'Economia circolare: un approccio sostenibile', 'Analisi dei vantaggi dell''economia circolare per ridurre gli sprechi.', 'Ambiente'),
    (DEFAULT, 'Il futuro dei trasporti: veicoli autonomi', 'Esplorazione delle tecnologie emergenti nel settore dei trasporti.', 'Informatica'),
    (DEFAULT, 'Salute mentale e benessere', 'Discussione sulla consapevolezza del benessere mentale nella società di oggi e sui modi per promuoverlo.', 'Medicina'),
    (DEFAULT, 'Innovazioni nel settore alimentare.', 'Esplorazione delle nuove tecnologie e soluzioni per affrontare le sfide dell''alimentazione sostenibile.', 'Sostenibilità');
--




--token admin
INSERT INTO db_token VALUES
    ('%Ib8F27VNm^34_S5'),
    ('123!bFO€8A$b124N'),
    ('DhsB546€Tr43F#?A');
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------