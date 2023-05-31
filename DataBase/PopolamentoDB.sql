--Popolamento del DB

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
    ('Università di Bologna'),
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
    ('ISS'),
    ('Comune di Roma'),
    ('Regione Lazio');
--


--organizzazioni
INSERT INTO organizzazione VALUES
    (1000, 'Università degli Studi di Napoli Federico II'), (1000, 'Università degli Studi di Salerno'),

    (1001, 'Università degli Studi di Cagliari'),

    (1002, 'Università degli Studi di Firenze'), (1002, 'Università degli Studi di Siena'),

    (1003, 'Università degli Studi di Napoli Federico II'),

    (1004, 'Università degli Studi di Sassari'), (1004, 'Università degli Studi di Cagliari'),

    (1005, 'Università degli Studi di Udine'), (1005, 'Università degli Studi di Trieste'),

    (1006, 'Università degli Studi di Cagliari'),

    (1007, 'Università degli Studi di Milano'), (1007, 'Università degli Studi di Milano-Bicocca'),

    (1008, 'Università degli Studi di Napoli Federico II'),

    (1009, 'Università degli Studi di Napoli Federico II'), (1009, 'Università degli Studi di Salerno'),

    (1010, 'Università di Pisa'), (1010, 'Università degli Studi di Siena'),

    (1011, 'Università Ca'' Foscari di Venezia'), (1011, 'Università degli Studi di Verona'),

    (1012, 'Università degli Studi di Udine'), (1012, 'Università degli Studi di Trieste'),

    (1013, 'FIT'),

    (1014, 'Università degli Studi di Roma "La Sapienza"'),

    (1015, 'Università degli Studi di Torino'),

    (1016, 'Università Politecnica delle Marche'),

    (1017, 'Università degli Studi di Perugia'), (1017, 'Università degli Studi di Siena'),

    (1018, 'Università degli Studi di Palermo'),

    (1019,'Università degli Studi di Bari Aldo Moro'), (1019,'Politecnico di Bari'), (1019,'Università del Salento'),

    (1020,'Università degli Studi di Trieste'), (1020,'FIT'), (1020,'IGM'),

    (1021,'Università degli Studi di Roma "La Sapienza"'), (1021,'Comune di Roma'), (1021,'Regione Lazio'),

    (1022, 'Università degli Studi di Palermo'), (1022, 'Google LLC'),

    (1023, 'Università degli Studi di Milano'), (1023, 'Università degli Studi di Brescia'), (1023, 'INFN'),

    (1024, 'Università di Bologna'),

    (1025, 'Università degli Studi di Napoli Federico II'),

    (1026, 'Università degli Studi di Roma Tor Vergata'),

    (1027, 'ISS'),

    (1028, 'Università degli Studi di Milano-Bicocca'), (1028, 'Università degli Studi di Milano'),

    (1029, 'Università degli Studi di Napoli Federico II');
--




--sponsor
INSERT INTO sponsor VALUES
    ('Celestron Italia'),
    ('BioTech Italia'),
    ('NanoTech Innovations'),
    ('Dispositivi Medici Innovativi'),
    ('BioTech Solutions'),
	('Earthlife Research'),
    ('Quantum Dynamics'),
    ('NanoGen'),
	('Numbering'),
	('MCM Solutions'),
	('OverLab Italia'),
	('Settore0 Inc.'),
	('AlphaGround Tech'),
	('Gaia Systemics'),
    ('GenoSys'),
	('Prolife'),
	('Biogenetycs'),
	('Innovatech'),
    ('LabPro'),
	('GeminiLab Italia'),
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
	('MarsTech Solutions'),
    ('OptoGen'),
	('ProFactor'),
	('OverSystem Italia'),
	('Apogeo Intesys'),
    ('BioAnalytica'),
    ('MedTech Innovations'),
    ('NanoStrumenti'),
	('PhisiLab'),
	('AlphaCentaury'),
	('GeoSys Lab Italia'),
    ('GenoPharma Italia');
--


--sponsorizzazioni
INSERT INTO sponsorizzazione VALUES
    (1000, 'Celestron Italia'), (1000, 'AstroLab Italia'), (1000, 'AstralTech'),

    (1001, 'BioTech Italia'), (1001, 'LabPro'),

    (1002, 'NanoTech Innovations'), (1002, 'Quantum Dynamics'), (1002, 'LabSolutions'),

    (1003, 'PhisiLab'),

    (1004, 'AlphaCentaury'), (1004, 'GeminiLab Italia'),

    (1005, 'NanoVision'),

    (1006, 'MedTech Innovations'), (1006, 'QuantumTech Solutions'),

    (1007, 'OptoGen'), (1007, 'Apogeo Intesys'), (1007, 'MarsTech Solutions'),

    (1008, 'NanoStrumenti'),

    (1009, 'Celestron Italia'), (1009, 'AstralTech'),

    (1010, 'Cybex Pharmaceuticals'), (1010, 'SynthiPharma'),

    (1011, 'BioAnalytica'),

    (1012, 'BioLab Italia'), (1012, 'MedGenix'), (1012, 'LabPro'),

    (1013, 'GenoPharma Italia'), (1013, 'BioTech Solutions'),

    (1014, 'AstralTech'),

    (1015, 'AlphaCentaury'),

    (1016, 'NeuroSynth'), (1016, 'NeuroTech Innovations'),

    (1017, 'GeoSys Lab Italia'), (1017, 'Earthlife Research'),

    (1018, 'Gaia Systemics'), (1018, 'AlphaGround Tech'), (1018, 'Settore0 Inc.'), (1018, 'GeoSys Lab Italia'),

    (1019, 'GenoSys'), (1019, 'BioGenetics Inc.'), (1019, 'SynthiPharma'),

    (1020, 'NanoGen'), (1020, 'AlphaCentaury'),

    (1021, 'LabSolutions'), (1021, 'Quantum Dynamics'),

    (1022, 'OverLab Italia'), (1022, 'MarsTech Solutions'),

    (1023, 'QuantumTech Solutions'), (1023, 'MCM Solutions'),

    (1024, 'Numbering'), (1024, 'OverSystem Italia'), (1024, 'ProFactor'),

    (1025, 'AstroLab Italia'), (1025, 'GeminiLab Italia'),

    (1026, 'PhisiLab'), (1026, 'Apogeo Intesys'),

    (1027, 'Dispositivi Medici Innovativi'), (1027, 'BioLab Italia'), (1027, 'MedGenix'), (1027, 'Innovatech'),

    (1028, 'Prolife'), (1028, 'Biogenetycs'),

    (1029, 'Gaia Systemics');
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
    ('vanessa.eulero@unibo.it', 'Docente universitaria', 'Vanessa', 'Eulero', 'Università di Bologna'),
    ('carmine.runica@unina.it', 'Docente universitario', 'Carmine', 'Runica', 'Università degli Studi di Napoli Federico II'),
    ('stefano.clessidri@uniroma.it', 'Amministratore universitario', 'Stefano', 'Clessidri', 'Università degli Studi di Roma "La Sapienza"'),
    ('olivia.ondanti@unimi.it', 'Professoressa', 'Olivia', 'Ondanti', 'Università degli Studi di Milano'),
    ('luca.denanni@unina.it', 'Collaboratore ambientale', 'Luca', 'De Nanni', 'Università degli Studi di Napoli Federico II'),
    ('jack.roshfert@unige.it', 'Analista marino', 'Jack', 'Roshfert', 'Università degli Studi di Genova'),
    ('gabriele.ferrara@uniss.it', 'Professore', 'Gabriele', 'Ferrara', 'Università degli Studi di Sassari'),
    ('chiara.ferraro@uniss.it', 'Professoressa', 'Chiara', 'Ferraro', 'Università degli Studi di Sassari'),
    ('marco.deluca@unica.it', 'Professore', 'Marco', 'De Luca', 'Università degli Studi di Cagliari'),
    ('serena.marchesin@units.it', 'Professoressa', 'Serena', 'Marchesin', 'Università degli Studi di Trieste'),
    ('valentina.ferri@uniud.it', 'Professoressa', 'Valentina', 'Ferri', 'Università degli Studi di Udine'),
    ('francesco.gentile@unica.it', 'Professore', 'Francesco', 'Gentile', 'Università degli Studi di Cagliari'),
    ('antonio.conte@unica.it', 'Professore', 'Antonio', 'Conte', 'Università degli Studi di Cagliari'),
    ('giuseppe.mazzaro@unica.it', 'Professore', 'Giuseppe', 'Mazzaro', 'Università degli Studi di Cagliari'),
    ('jacopo.dipietro@unica.it', 'Professore', 'Jacopo', 'Di Pietro', 'Università degli Studi di Cagliari'),
    ('massimo.ferrante@unica.it', 'Professore', 'Massimo', 'Ferrante', 'Università degli Studi di Cagliari'),
    ('asia.valente@unimi.it', 'Professoressa', 'Asia', 'Valente', 'Università degli Studi di Milano'),
    ('sofia.tammaro@unimi.it', 'Professoressa', 'Sofia', 'Tammaro', 'Università degli Studi di Milano'),
    ('filippo.dega@unimi.it', 'Professore', 'Filippo', 'Dega', 'Università degli Studi di Milano'),
    ('ugo.borghetti@unimib.it', 'Professore', 'Ugo', 'Borghetti', 'Università degli Studi di Milano-Bicocca'),
	('alessandra.ricciardi@unina.it', 'Professoressa', 'Alessandra', 'Ricciardi', 'Università degli Studi di Napoli Federico II'),
    ('matteo.caravaggio@unina.it', 'Professore', 'Matteo', 'Caravaggio', 'Università degli Studi di Napoli Federico II'),
    ('isabella.bellini@unina.it', 'Professoressa', 'Isabella', 'Bellini', 'Università degli Studi di Napoli Federico II'),
    ('luca.imprudente@unina.it', 'Professore', 'Luca', 'Imprudente', 'Università degli Studi di Napoli Federico II'),
    ('antonio.ricciardi@unina.it', 'Professore', 'Antonio', 'Ricciardi', 'Università degli Studi di Napoli Federico II'),
    ('alessandro.arena@unina.it', 'Professore', 'Alessandro', 'Arena', 'Università degli Studi di Napoli Federico II'),
    ('valerio.apice@unina.it', 'Professore', 'Valerio', 'Apice', 'Università degli Studi di Napoli Federico II'),
    ('clemente.maccaro@unina.it', 'Professore', 'Clemente', 'Maccaro', 'Università degli Studi di Napoli Federico II'),
    ('rocco.pagliarulo@unina.it', 'Professore', 'Rocco', 'Pagliarulo', 'Università degli Studi di Napoli Federico II'),
    ('giovanni.ballerini@unipi.it', 'Professore', 'Giovanni', 'Ballerini', 'Università di Pisa'),
    ('luca.mansione@unisi.it', 'Professore', 'Luca', 'Mansione', 'Università degli Studi di Siena'),
    ('alessia.barbieri@unive.it', 'Professoressa', 'Alessia', 'Barbieri', 'Università Ca'' Foscari di Venezia'),
    ('alessandra.forte@univr.it', 'Professoressa', 'Alessandra', 'Forte', 'Università degli Studi di Verona'),
    ('alessia.pozziani@univr.it', 'Professoressa', 'Alessia', 'Pozziani', 'Università degli Studi di Verona'),
    ('maria.russo@units.it', 'Professore', 'Maria', 'Russo', 'Università degli Studi di Trieste'),
    ('marco.bianchi@units.it', 'Professore', 'Marco', 'Bianchi', 'Università degli Studi di Trieste'),
    ('laura.rossi@uniud.it', 'Professoressa', 'Laura', 'Rossi', 'Università degli Studi di Udine'),
    ('giulia.conti@fitresearch.org', 'Professoressa', 'Giulia', 'Conti', 'FIT'),
    ('stefano.russo@fitresearch.org', 'Professore', 'Stefano', 'Russo', 'FIT'),
    ('enea.verdi@fitresearch.org', 'Professore', 'Enea', 'Verdi', 'FIT'),
    ('alessandro.lombardi@uniroma1.it', 'Professore', 'Alessandro', 'Lombardi', 'Università degli Studi di Roma "La Sapienza"'),
    ('serena.romano@uniroma1.it', 'Professoressa', 'Serena', 'Romano', 'Università degli Studi di Roma "La Sapienza"'),
    ('marco.deluca@uniroma1.it', 'Professore', 'Marco', 'De Luca', 'Università degli Studi di Roma "La Sapienza"'),
    ('chiara.esposito@uniroma1.it', 'Professoressa', 'Chiara', 'Esposito', 'Università degli Studi di Roma "La Sapienza"'),
    ('valentina.martini@unito.it', 'Professoressa', 'Valentina', 'Martini', 'Università degli Studi di Torino'),
    ('aurora.fiorelli@unito.it', 'Professoressa', 'Aurora', 'Fiorelli', 'Università degli Studi di Torino'),
    ('lorenzo.montanari@unito.it', 'Professore', 'Lorenzo', 'Montanari', 'Università degli Studi di Torino'),
    ('eleonora.romani@unito.it', 'Professoressa', 'Eleonora', 'Romani', 'Università degli Studi di Torino'),
    ('alessio.marchetti@unito.it', 'Professore', 'Alessio', 'Marchetti', 'Università degli Studi di Torino'),
    ('alessandro.lombardi@univpm.it', 'Professore', 'Alessandro', 'Lombardi', 'Università Politecnica delle Marche'),
    ('marco.deangelis@univpm.it', 'Professore', 'Marco', 'De Angelis', 'Università Politecnica delle Marche'),
    ('federica.ricci@univpm.it', 'Professoressa', 'Federica', 'Ricci', 'Università Politecnica delle Marche'),
    ('giulia.marino@univpm.it', 'Professoressa', 'Giulia', 'Marino', 'Università Politecnica delle Marche'),
    ('eleonora.rossi@unipg.it', 'Professoressa', 'Eleonora', 'Rossi', 'Università degli Studi di Perugia'),
    ('alessio.ferretti@unipg.it', 'Professore', 'Alessio', 'Ferretti', 'Università degli Studi di Perugia'),
    ('valeria.montanari@unipg.it', 'Professoressa', 'Valeria', 'Montanari', 'Università degli Studi di Perugia'),
    ('camilla.lombardi@unisi.it', 'Professoressa', 'Camilla', 'Lombardi', 'Università degli Studi di Siena'),
    ('matteo.romano@unisi.it', 'Professore', 'Matteo', 'Romano', 'Università degli Studi di Siena'),
    ('alessandro.rizzo@unipa.it', 'Professore', 'Alessandro', 'Rizzo', 'Università degli Studi di Palermo'),
    ('chiara.messina@unipa.it', 'Professoressa', 'Chiara', 'Messina', 'Università degli Studi di Palermo'),
    ('alessio.marino@unibo.it', 'Professore', 'Alessio', 'Marino', 'Università di Bologna'),
    ('valeria.ferrara@unibo.it', 'Professoressa', 'Valeria', 'Ferrara', 'Università di Bologna'),
    ('marco.romanucci@unibo.it', 'Professore', 'Marco', 'Romanucci', 'Università di Bologna'),
    ('stefano.ambrosini@unibo.it', 'Professore', 'Stefano', 'Ambrosini', 'Università di Bologna'),
    ('isabella.moretti@unina.it', 'Professoressa', 'Isabella', 'Moretti', 'Università degli Studi di Napoli Federico II'),
    ('valerio.cuomo@unian.it', 'Professore', 'Valerio', 'Cuomo', 'Università degli Studi di Napoli Federico II'),
    ('aurora.montanari@uniroma2.it', 'Professoressa', 'Aurora', 'Montanari', 'Università degli Studi di Roma Tor Vergata'),
    ('luca.ancelotti@uniroma2.it', 'Professore', 'Luca', 'Ancelotti', 'Università degli Studi di Roma Tor Vergata'),
    ('stefano.dimaggio@uniroma2.it', 'Professore', 'Stefano', 'Di Maggio', 'Università degli Studi di Roma Tor Vergata'),
    ('giovanni.rosa@uniroma2.it', 'Professore', 'Giovanni', 'Rosa', 'Università degli Studi di Roma Tor Vergata'),
    ('serena.morelli@issroma.it', 'Professoressa', 'Serena', 'Morelli', 'ISS'),
    ('felice.ambrosini@unimib.it', 'Professore', 'Felice', 'Ambrosini', 'Università degli Studi di Milano-Bicocca'),
    ('massimo.mariola@unimi.it', 'Professore', 'Massimo', 'Mariola', 'Università degli Studi di Milano'),
    ('lorenzo.capuano@unina.it', 'Professore', 'Lorenzo', 'Capuano', 'Università degli Studi di Napoli Federico II'),
    ('marialaura.fontana@unina.it', 'Professoressa', 'Marialaura', 'Fontana', 'Università degli Studi di Napoli Federico II');
--


--comitati scientifici
INSERT INTO comitato_scientifico VALUES
    (1000, 'giandomenico.lavazza@unina.it'), (1000, 'sofia.nerano@docenti.unina.it'), (1000, 'alberto.moro@unisa.it'),

    (1001, 'chiara.grieco@unica.it'), (1001, 'franco.manca@unica.it'), (1001, 'ugo.pinna@unica.it'), (1001, 'francesco.tozzi@unica.it'), (1001, 'manco.piras@unica.it'),

    (1002, 'anna.bianchi@unifi.it'), (1002, 'tommaso.fabbri@unipi.it'), (1002, 'eugenio.storti@unipi.it'), (1002, 'claudia.moneta@unisi.it'),

    (1003, 'alessandra.ricciardi@unina.it'), (1003, 'matteo.caravaggio@unina.it'), (1003, 'isabella.bellini@unina.it'),

    (1004, 'gabriele.ferrara@uniss.it'), (1004, 'chiara.ferraro@uniss.it'), (1004, 'marco.deluca@unica.it'),

    (1005, 'serena.marchesin@units.it'), (1005, 'valentina.ferri@uniud.it'),

    (1006, 'francesco.gentile@unica.it'), (1006, 'antonio.conte@unica.it'), (1006, 'giuseppe.mazzaro@unica.it'), (1006, 'jacopo.dipietro@unica.it'), (1006, 'massimo.ferrante@unica.it'),

    (1007, 'asia.valente@unimi.it'), (1007, 'sofia.tammaro@unimi.it'), (1007, 'filippo.dega@unimi.it'), (1007, 'ugo.borghetti@unimib.it'),

    (1008, 'luca.imprudente@unina.it'), (1008, 'antonio.ricciardi@unina.it'), (1008, 'alessandro.arena@unina.it'), (1008, 'valerio.apice@unina.it'),

    (1009, 'clemente.maccaro@unina.it'), (1009, 'rocco.pagliarulo@unina.it'),

    (1010, 'giovanni.ballerini@unipi.it'), (1010, 'luca.mansione@unisi.it'),

    (1011, 'alessia.barbieri@unive.it'), (1011, 'alessandra.forte@univr.it'), (1011, 'alessia.pozziani@univr.it'),

    (1012, 'maria.russo@units.it'), (1012, 'marco.bianchi@units.it'), (1012, 'laura.rossi@uniud.it'),

    (1013, 'giulia.conti@fitresearch.org'), (1013, 'stefano.russo@fitresearch.org'), (1013, 'enea.verdi@fitresearch.org'),

    (1014, 'alessandro.lombardi@uniroma1.it'), (1014, 'serena.romano@uniroma1.it'), (1014, 'marco.deluca@uniroma1.it'), (1014, 'chiara.esposito@uniroma1.it'),

    (1015, 'valentina.martini@unito.it'), (1015, 'aurora.fiorelli@unito.it'), (1015, 'lorenzo.montanari@unito.it'), (1015, 'eleonora.romani@unito.it'), (1015, 'alessio.marchetti@unito.it'),

    (1016, 'alessandro.lombardi@univpm.it'), (1016, 'marco.deangelis@univpm.it'), (1016, 'federica.ricci@univpm.it'), (1016, 'giulia.marino@univpm.it'),

    (1017, 'eleonora.rossi@unipg.it'), (1017, 'alessio.ferretti@unipg.it'), (1017, 'valeria.montanari@unipg.it'), (1017, 'camilla.lombardi@unisi.it'), (1017, 'matteo.romano@unisi.it'),

    (1018, 'alessandro.rizzo@unipa.it'), (1018, 'chiara.messina@unipa.it'),

    (1019, 'giulia.verdi@uniba.it'), (1019, 'andrea.esposito@poliba.it'), (1019, 'martina.russo@unile.it'), (1019, 'marco.bianchi@uniba.it'), (1019, 'alessia.moretti@poliba.it'),

    (1020, 'carlo.franchi@fitresearch.org'), (1020, 'mattia.orlando@fitresearch.org'),

    (1021, 'gioia.cavallo@uniroma.it'), (1021, 'salvatore.fabrico@uniroma.it'), (1021, 'raul.sozzi@uniroma.it'),

    (1022, 'giovanni.fulco@unipa.it'), (1022, 'mattia.pizzo@unipa.it'), (1022, 'marco.messina@unipa.it'),

    (1023, 'umberto.saporetti@infn.it' ),

    (1024, 'alessio.marino@unibo.it'), (1024, 'valeria.ferrara@unibo.it'), (1024, 'marco.romanucci@unibo.it'), (1024, 'stefano.ambrosini@unibo.it'), 

    (1025, 'isabella.moretti@unina.it'), (1025, 'valerio.cuomo@unian.it'),

    (1026, 'aurora.montanari@uniroma2.it'), (1026, 'luca.ancelotti@uniroma2.it'), (1026, 'stefano.dimaggio@uniroma2.it'), (1026, 'giovanni.rosa@uniroma2.it'),

    (1027, 'serena.morelli@issroma.it'),

    (1028, 'felice.ambrosini@unimib.it'), (1028, 'massimo.mariola@unimi.it'),

    (1029, 'lorenzo.capuano@unina.it'), (1029, 'marialaura.fontana@unina.it');
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
    ('giovanna.ambrosia@unibo.it', 'Ricercatrice senior', 'Giovanna', 'Ambrosio', 'Università di Bologna'),
    ('maria.potta@unina.it', 'Collaboratrice di ricerca', 'Maria', 'Potta', 'Università degli Studi di Napoli Federico II'),
    ('mariateresa.screma@uniroma.it', 'Ricercatrice junior', 'Mariateresa', 'Screma', 'Università degli Studi di Roma "La Sapienza"'),
    ('antonio.botti@issroma.it', 'Biochimico', 'Antonio', 'Botti', 'ISS'),
    ('flavia.botti@issroma.it', 'Esperta di biologia', 'Flavia', 'Botti', 'ISS'),
    ('gabriele.errante@unimi.it', 'Professore', 'Gabriele', 'Errante', 'Università degli Studi di Milano'),
    ('melissa.altopiano@unina.it', 'Ricercatrice', 'Melissa', 'Altopiano', 'Università degli Studi di Napoli Federico II');
--




--sessioni
INSERT INTO sessione VALUES
    (100001, '2023-04-27', '2023-04-27', 'Giandomenico Lavazza', 'giorgio.parisi@unina.it', 'Padiglione 4', 1000),
    (100002, '2023-04-27', '2023-04-27', 'Sofia Nerano', 'mfelicia.delaurentis@infn.it', 'Padiglione 4', 1000),
    (100003, '2023-04-28', '2023-04-28', 'Giandomenico Lavazza', 'antonio.marinelli@infn.it', 'Padiglione 4', 1000),
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
    
    (102901, '2024-02-10', '2024-02-10', 'Luca De Nanni', 'Nessuno', 'Complesso Ovest Sala riunioni', 1029),
    (102902, '2024-02-11', '2024-02-11', 'Raimondo Squisiti', 'melissa.altopiano@unina.it', 'Complesso Ovest Sala riunioni', 1029),
    (102903, '2024-02-11', '2024-02-11', 'Raimondo Squisiti', 'melissa.altopiano@unina.it', 'Complesso Ovest Sala riunion', 1029),
    (102904, '2024-02-12', '2024-02-12', 'Jack Roshfert', 'Nessuno', 'Complesso Ovest Sala riunioni', 1029); 
--



--interventi
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

    (10240101, '10:00:00', '15:00:00', 102401, 'Giorno 1 - Intervallo dalle 13:00 alle 13:25'),
    (10240102, '15:30:00', '18:00:00', 102401, 'Giorno 1 - Coffee Break dalle 16:30 alle 16:45'),


    (10250101, '09:00:00', '12:00:00', 102501, 'Giorno 1'),
    (10250102, '15:00:00', '18:00:00', 102501, 'Giorno 1 - Coffee Break dalle 16:30 alle 16:45'),

    (10250201, '09:00:00', '14:00:00', 102502, 'Giorno 2 - Intervallo dalle 11:00 alle 11:35'),
    (10250202, '15:30:00', '18:00:00', 102502, 'Giorno 2'),

    (10250301, '10:00:00', '12:00:00', 102503, 'Giorno 3'),
    (10250302, '13:30:00', '15:00:00', 102503, 'Giorno 3'),


    (10260101, '15:00:00', '20:00:00', 102601, 'Giorno 1 - Intervallo dalle 17:00 alle 17:45'),
    (10260102, '09:30:00', '14:00:00', 102601, 'Giorno 2 - Coffee Break dalle 12:00 alle 12:15'),

    (10260201, '15:00:00', '20:00:00', 102602, 'Giorno 2 - Intervallo dalle 17:45 alle 18:25'), 


    (10270101, '08:00:00', '12:00:00', 102701, 'Giorno 1 - Coffee Break adlle 10:00 alle 10:05'),

    (10270201, '15:00:00', '20:00:00', 102702, 'Giorno 1 - Intervallo dalle 17:30 alle 18:00'),


    (10280101, '10:00:00', '17:00:00', 102801, 'Giorno 1 - Intervallo dalle 13:00 alle 14:00'),
    (10280102, '10:00:00', '13:30:00', 102801, 'Giorno 2'),
    (10280103, '15:00:00', '20:00:00', 102801, 'Giorno 2 - Intervallo dalle 18:00 alle 18:20'),


    (10290101, '10:00:00', '14:00:00', 102901, 'Giorno 1 - Coffee Break dalle 12:15 alle 12:30'),
    (10290201, '08:00:00', '13:00:00', 102902, 'Giorno 2'),
    (10290301, '15:00:00', '17:30:00', 102903, 'Giorno 2'),
    (10290401, '10:00:00', '14:00:00', 102904, 'Giorno 3 - Coffee Break dalle 12:15 alle 12:30');
--




--partecipanti
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
    ('alessio.sole@unimi.it', 'Docente universitario', 'Alessio', 'Sole', 'Università degli Studi di Milano'),
    ('manuel.vestari@gmail.com', 'Nobel per la Matematica', 'Manuel', 'Vestari', 'Università di Bologna'),
    ('giovanni.mara@unina.it', 'Ricercatore', 'Giovanni', 'Mara', 'Università degli Studi di Napoli Federico II'),
    ('diego.volderi@unina.it', 'Ricercatore', 'Diego', 'Volderi', 'Università degli Studi di Napoli Federico II'),
    ('michela.manuali@unina.it', 'Assistente di fisica', 'Michela', 'Manuali', 'Università degli Studi di Napoli Federico II'),
    ('camilla.fiaschi@infn.it', 'Tecnica astronomica', 'Camilla', 'Fiaschi', 'INFN'),
    ('raimondo.volta@infn.it', 'Fisico teorico', 'Raimondo', 'Volta', 'INFN'),
    ('david.mcdaniel@unimi.it', 'Biologo', 'David', 'McDaniel', 'Università degli Studi di Milano'),
    ('august.sevili@unimi.it', 'Ricercatore esterno', 'August', 'Sevili', 'Università degli Studi di Milano'),
    ('carolina.malta@unina.it', 'Ricercatrice', 'Carolina', 'Malta', 'Università degli Studi di Napoli Federico II'),
    ('piero.tarasso@unina.it', 'Ignegnere edile', 'Piero', 'tarasso', 'Università degli Studi di Napoli Federico II'),
    ('joseph.camossa@unina.it', 'Geometra geotecnico', 'Joseph', 'Camossa', 'Università degli Studi di Napoli Federico II');
--


--partecipazione
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
    (10200201,'mario.doccia@units.it'), (10200202,'paolo.perforza@fitresearch.org'),
    (10200301,'mariangela.cartini@igm.cnr.it'), (10200302,'mariangela.cartini@igm.cnr.it'),

    (10210101,'emanuele.dellarossa@comune.roma.it'),
    (10210201,'nicola.ontario@uniroma.it'), (10210201, 'davide.stella@regionelazio.it'),
    (10210202,'nicola.ontario@uniroma.it'), (10210202, 'davide.stella@regionelazio.it'),
    (10210301,'wang.ferrari@uniroma.it'), (10210301, 'chiara.bomoldi@regionelazio.it'),
    (10210302,'wang.ferrari@uniroma.it'), (10210302,'chiara.bomoldi@regionelazio.it'),

    (10230102,'filippo.prosima@unimi.it'), (10230102,'filippo.centauri@unimi.it'), (10230102,'domenico.tuono@unibs.it'),
    (10230103,'raffaele.gelo@unimi.it'), (10230103,'alessio.sole@unimi.it'), (10230103, 'domenico.tuono@unibs.it'),
    
    (10240101,'manuel.vestari@gmail.com'), (10240102,'manuel.vestari@gmail.com'),

    (10250101,'giovanni.mara@unina.it'), (10250102,'giovanni.mara@unina.it'),
    (10250201,'diego.volderi@unina.it'), (10250202,'diego.volderi@unina.it'),
    (10250301,'michela.manuali@unina.it'), (10250302,'michela.manuali@unina.it'),

    (10260101,'camilla.fiaschi@infn.it'), (10260101, 'raimondo.volta@infn.it'), (10260102,'camilla.fiaschi@infn.it'), (10260102,'raimondo.volta@infn.it'),
    (10260201, 'raimondo.volta@infn.it'),

    (10280101,'david.mcdaniel@unimi.it'), (10280102,'august.sevili@unimi.it'), (10280103,'david.mcdaniel@unimi.it'),

    (10290101,'carolina.malta@unina.it'),
    (10290201,'carolina.malta@unina.it'), (10290201, 'joseph.camossa@unina.it'),
    (10290301,'piero.tarasso@unina.it'), (10290301, 'joseph.camossa@unina.it'),
    (10290401,'piero.tarasso@unina.it');
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