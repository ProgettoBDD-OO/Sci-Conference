-- sequenze pkey

CREATE SEQUENCE id_conferenza_seq
    INCREMENT 1
    START 999
    MINVALUE 1
    MAXVALUE 2998
    CACHE 1;

CREATE SEQUENCE id_collocazione_seq
    INCREMENT 1
    START 2999
    MINVALUE 1
    MAXVALUE 4998
    CACHE 1;

CREATE SEQUENCE id_sponsor_seq
    INCREMENT 1
    START 4999
    MINVALUE 1
    MAXVALUE 6998
    CACHE 1;

CREATE SEQUENCE id_ente_seq
    INCREMENT 1
    START 6999
    MINVALUE 1
    MAXVALUE 8998
    CACHE 1;

CREATE SEQUENCE id_proposta_bacheca_seq
    INCREMENT 1
    START 39999
    MINVALUE 1
    MAXVALUE 49998
    CACHE 1;



-- tabelle 

CREATE TABLE conferenza
(
    id_conferenza INTEGER NOT NULL DEFAULT nextval('id_conferenza_seq'::regclass),
    nome VARCHAR(255) NOT NULL,
    data_inizio DATE,
    data_fine DATE,
    descrizione VARCHAR(510),
    tema VARCHAR(255),
    id_collocazione INTEGER,
    CONSTRAINT conferenza_pkey PRIMARY KEY (id_conferenza)
);


CREATE TABLE collocazione
(
    id_collocazione INTEGER NOT NULL DEFAULT nextval('id_collocazione_seq'::regclass),
    sede VARCHAR(255),
    regione VARCHAR(255),
    CONSTRAINT collocazione_pkey PRIMARY KEY (id_collocazione)
);


CREATE TABLE ente
(
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT ente_pkey PRIMARY KEY (nome)
);


CREATE TABLE sponsor
(
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT sponsor_pkey PRIMARY KEY (nome)
);


CREATE TABLE organizzatore
(
    email VARCHAR(255) NOT NULL,
    titolo VARCHAR(255),
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    afferenza VARCHAR(255),
    CONSTRAINT organizzatore_pkey PRIMARY KEY (email)
);


CREATE TABLE keynote_speaker
(
    email VARCHAR(255) NOT NULL,
    titolo VARCHAR(255),
    nome VARCHAR(255),
    cognome VARCHAR(255),
    afferenza VARCHAR(255),
    CONSTRAINT keynote_speaker_pkey PRIMARY KEY (email)
);


CREATE TABLE partecipante
(
    email VARCHAR(255) NOT NULL,
    titolo VARCHAR(255),
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    afferenza VARCHAR(255),
    CONSTRAINT partecipante_pkey PRIMARY KEY (email)
);


CREATE TABLE sessione
(
    id_sessione INTEGER NOT NULL,
    data_inizio DATE,
    data_fine DATE,
    coordinatore VARCHAR NOT NULL,
    keynote_speaker VARCHAR NOT NULL DEFAULT 'nessuno'::VARCHAR,
    locazione VARCHAR(255),
    id_conferenza INTEGER NOT NULL,
    CONSTRAINT sessione_pkey PRIMARY KEY (id_sessione)
);


CREATE TABLE intervento
(
    id_intervento INTEGER NOT NULL,
    ora_inizio TIME WITHOUT TIME ZONE,
    ora_fine TIME WITHOUT TIME ZONE,
    id_sessione INTEGER,
    descrizione VARCHAR(510),
    CONSTRAINT intervento_pkey PRIMARY KEY (id_intervento)
);



-- tabelle ponte

CREATE TABLE organizzazione
(
    id_conferenza INTEGER NOT NULL,
    ente VARCHAR(255) NOT NULL,
    CONSTRAINT organizzazione_pkey PRIMARY KEY (id_conferenza, ente)
);


CREATE TABLE sponsorizzazione
(
    id_conferenza INTEGER NOT NULL,
    sponsor VARCHAR(255) NOT NULL,
    CONSTRAINT sponsorizzazione_pkey PRIMARY KEY (id_conferenza, sponsor)
);


CREATE TABLE comitato_scientifico
(
    id_conferenza INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT comitato_scientifico_pkey PRIMARY KEY (id_conferenza, email)
);


CREATE TABLE partecipazione
(
    id_intervento INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT partecipazione_pkey PRIMARY KEY (id_intervento, email)
);



-- tabelle application-side

CREATE TABLE utente
(
    email VARCHAR(255) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password_user VARCHAR(255) NOT NULL,
    admin_status boolean,
    CONSTRAINT utenti_pkey PRIMARY KEY (email),
    CONSTRAINT utenti_username_key UNIQUE (username)
);

CREATE TABLE db_token
(
    db_token character(16) NOT NULL,
    CONSTRAINT db_token_pkey PRIMARY KEY (db_token)
);


CREATE TABLE proposta_bacheca
(
    id_conferenza_bacheca INTEGER NOT NULL DEFAULT nextval('id_proposta_bacheca_seq'::regclass),
    nome VARCHAR(255) NOT NULL,
    descrizione VARCHAR(255) NOT NULL,
    tema VARCHAR(255) NOT NULL,
    CONSTRAINT proposta_bacheca_pkey PRIMARY KEY (id_conferenza_bacheca)
);


CREATE TABLE iscrizione_conferenza
(
    email VARCHAR(255) NOT NULL,
    id_conferenza INTEGER NOT NULL,
    CONSTRAINT iscrizione_conferenza_pkey PRIMARY KEY (email, id_conferenza)
);




-- foreign key

ALTER TABLE conferenza
    ADD CONSTRAINT conferenza_collocazione FOREIGN KEY (id_collocazione)
    REFERENCES collocazione (id_collocazione)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE organizzatore
    ADD CONSTRAINT organizzatore_ente FOREIGN KEY (afferenza)
    REFERENCES ente (nome)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE keynote_speaker
    ADD CONSTRAINT keynote_ente FOREIGN KEY (afferenza)
    REFERENCES ente (nome)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE partecipante
    ADD CONSTRAINT partecipante_ente FOREIGN KEY (afferenza)
    REFERENCES ente (nome)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE sessione
    ADD CONSTRAINT sessione_conferenza FOREIGN KEY (id_conferenza)
    REFERENCES conferenza (id_conferenza)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE sessione
    ADD CONSTRAINT sessione_keynote FOREIGN KEY (keynote_speaker)
    REFERENCES keynote_speaker (email)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE intervento
    ADD CONSTRAINT intervento_sessione FOREIGN KEY (id_sessione)
    REFERENCES sessione (id_sessione)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE organizzazione
    ADD CONSTRAINT conferenza_organizzazione FOREIGN KEY (id_conferenza)
    REFERENCES conferenza (id_conferenza)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE organizzazione
    ADD CONSTRAINT ente_organizzazione FOREIGN KEY (ente)
    REFERENCES ente (nome)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE sponsorizzazione
    ADD CONSTRAINT conferenza_sponsorizzazione FOREIGN KEY (id_conferenza)
    REFERENCES conferenza (id_conferenza)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE sponsorizzazione
    ADD CONSTRAINT sponsor_sponsorizzazione FOREIGN KEY (sponsor)
    REFERENCES sponsor (nome)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE comitato_scientifico
    ADD CONSTRAINT conferenza_comitato FOREIGN KEY (id_conferenza)
    REFERENCES conferenza (id_conferenza)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE comitato_scientifico
    ADD CONSTRAINT organizzatore_comitato FOREIGN KEY (email)
    REFERENCES organizzatore (email)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE partecipazione
    ADD CONSTRAINT intervento_partecipazione FOREIGN KEY (id_intervento)
    REFERENCES intervento (id_intervento)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE partecipazione
    ADD CONSTRAINT partecipante_partecipazione FOREIGN KEY (email)
    REFERENCES partecipante (email)
    ON UPDATE CASCADE
    ON DELETE CASCADE;



ALTER TABLE iscrizione_conferenza
    ADD CONSTRAINT conferenza_iscrizione FOREIGN KEY (id_conferenza)
    REFERENCES conferenza (id_conferenza)
    ON UPDATE CASCADE
    ON DELETE CASCADE;

ALTER TABLE iscrizione_conferenza
    ADD CONSTRAINT utente_iscrizione FOREIGN KEY (email)
    REFERENCES utente (email)
    ON UPDATE CASCADE
    ON DELETE CASCADE;





-- funzioni

CREATE FUNCTION prima_sesto_spazio(
    descrizione VARCHAR)
    RETURNS VARCHAR
    LANGUAGE 'plpgsql'

AS $BODY$
DECLARE 
desc_originale VARCHAR(1000);
spazio INTEGER;
secondo_spazio INTEGER;
prime_sei_parole INTEGER;
BEGIN
    desc_originale := descrizione;
    prime_sei_parole := 0;
    FOR i IN 1..6 LOOP
        spazio := POSITION(' ' IN descrizione);
        descrizione := SUBSTRING(descrizione, spazio + 1, LENGTH(descrizione));
        prime_sei_parole := prime_sei_parole + spazio;
        END LOOP;
    IF spazio = 0 THEN
        RETURN desc_originale;
    ELSE
        RETURN SUBSTRING(desc_originale, 1, prime_sei_parole);
    END IF;
END;
$BODY$;


CREATE OR REPLACE FUNCTION public.doposestospazio(
    descrizione VARCHAR)
    RETURNS VARCHAR
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE 
prima_parte INTEGER;
BEGIN
    prima_parte := LENGTH(primasestospazio(descrizione));
    RETURN SUBSTRING(descrizione, prima_parte+1,LENGTH(descrizione));
END;
$BODY$;



CREATE FUNCTION afferenze_by_month(
	mese INTEGER,
	anno INTEGER)
    RETURNS TABLE(ente VARCHAR, occorrenze BIGINT) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT afferenza, count(afferenza) FROM keynote_speaker JOIN 
  (SELECT DISTINCT keynote_speaker FROM sessione 
   WHERE EXTRACT(MONTH FROM data_inizio) = mese + 1 AND EXTRACT(YEAR FROM data_inizio) = anno
   AND keynote_speaker != 'Nessuno'
   ) AS occorrenze_enti ON keynote_speaker.email = occorrenze_enti.keynote_speaker 
     GROUP BY afferenza
     ORDER BY count(afferenza) DESC;
END;
$BODY$;



CREATE FUNCTION afferenze_by_year(
	anno INTEGER)
    RETURNS TABLE(ente VARCHAR, occorrenze BIGINT) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT afferenza, count(afferenza) FROM keynote_speaker JOIN 
  (SELECT DISTINCT keynote_speaker FROM sessione 
   WHERE EXTRACT(YEAR FROM data_inizio) = anno AND EXTRACT(MONTH FROM data_inizio) < EXTRACT(MONTH FROM current_date)
   AND keynote_speaker != 'Nessuno'
   ) AS occorrenze_enti ON keynote_speaker.email = occorrenze_enti.keynote_speaker 
     GROUP BY afferenza
     ORDER BY count(afferenza) DESC;
END;
$BODY$;



CREATE FUNCTION collocazione_conferenza(
	id_conf INTEGER)
    RETURNS TABLE(sede VARCHAR, regione VARCHAR) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT colloc.sede, colloc.regione FROM collocazione AS colloc NATURAL JOIN conferenza
  WHERE id_conferenza = id_conf;
END;
$BODY$;



CREATE FUNCTION collocazione(
	sede_in VARCHAR,
	regione_in VARCHAR)
    RETURNS SETOF INTEGER 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT id_collocazione 
    FROM collocazione 
    WHERE sede = sede_in AND regione = regione_in;
END;
$BODY$;



CREATE FUNCTION conferenze(id_conf INTEGER)
    RETURNS TABLE(nome_conf VARCHAR, data_inizio_conf DATE, data_fine_conf DATE,
				  descrizione_prima_parte VARCHAR, descrizione_seconda_parte VARCHAR, tema_conf VARCHAR) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT nome, data_inizio, data_fine, prima_sesto_spazio(descrizione), dopo_sesto_spazio(descrizione), tema 
  FROM conferenza
  WHERE id_conferenza = id_conf;
END;
$BODY$;



CREATE FUNCTION conferenze_utente(
	email_in VARCHAR)
    RETURNS TABLE(id_conferenza INTEGER, nome_conferenza VARCHAR, tema_conferenza VARCHAR) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT cs.id_conferenza, cs.nome, cs.tema FROM conferenza AS cs 
  NATURAL JOIN iscrizione_conferenza AS ic
  WHERE ic.email = email_in;
END;
$BODY$;



CREATE FUNCTION enti(
	id_conf INTEGER)
    RETURNS SETOF VARCHAR 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT ente 
    FROM organizzazione
    WHERE id_conferenza = id_conf;
END;
$BODY$;



CREATE FUNCTION sponsor(
	id_conf INTEGER)
    RETURNS SETOF VARCHAR 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT sponsor
    FROM sponsorizzazione
    WHERE id_conferenza = id_conf;
END;
$BODY$;



CREATE FUNCTION filtered_research(
	nome_ricerca VARCHAR DEFAULT NULL::VARCHAR,
	temi VARCHAR[] DEFAULT NULL::VARCHAR[],
	regioni VARCHAR[] DEFAULT NULL::VARCHAR[])
    RETURNS TABLE(id_conf INTEGER, nome_conf VARCHAR, tema_conf VARCHAR, regione_conf VARCHAR) 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY
		SELECT id_conferenza, nome, tema, regione
		FROM conferenza NATURAL JOIN collocazione
		WHERE nome ILIKE '%' || nome_ricerca || '%'
		  AND ($2 IS NULL OR tema = ANY($2))
		  AND ($3 IS NULL OR regione = ANY($3))
		  AND (($4 IS NOT NULL AND data_inizio = data_precisa)
		   OR ($5 IS NOT NULL AND data_inizio BETWEEN inizio_periodo AND fine_periodo))
		ORDER BY data_inizio;
END;
$BODY$;



CREATE FUNCTION iscrizioni(
	email_in VARCHAR,
	id_conf INTEGER)
    RETURNS SETOF INTEGER 
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT id_conferenza 
    FROM iscrizione_conferenza 
    WHERE email = email_in AND id_conferenza = id_conf;
END;
$BODY$;





--procedure

CREATE PROCEDURE insert_ente(
	IN nome VARCHAR,
	IN id_conf INTEGER)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  INSERT INTO ente
  VALUES(nome)
  ON CONFLICT DO NOTHING;

  INSERT INTO organizzazione
  VALUES(id_conf,nome)
  ON CONFLICT DO NOTHING;

END;
$BODY$;



CREATE PROCEDURE insert_keynote(
	IN email VARCHAR,
	IN titolo VARCHAR,
	IN nome VARCHAR,
	IN cognome VARCHAR,
	IN afferenza VARCHAR)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  INSERT INTO ente
  VALUES (afferenza)
  ON CONFLICT DO NOTHING;

  INSERT INTO keynote_speaker 
  VALUES(email, titolo, nome, cognome, afferenza)
  ON CONFLICT DO NOTHING;
END
$BODY$;



CREATE PROCEDURE insert_organizzatore(
	IN email VARCHAR,
	IN titolo VARCHAR,
	IN nome VARCHAR,
	IN cognome VARCHAR,
	IN afferenza VARCHAR,
	IN id_conf integer)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  INSERT INTO organizzatore 
  VALUES(email, titolo, nome, cognome, afferenza)
  ON CONFLICT DO NOTHING;

  INSERT INTO comitato_scientifico
  VALUES(id_conf, email)
  ON CONFLICT DO NOTHING;
END;
$BODY$;



CREATE PROCEDURE insert_partecipante(
	IN email VARCHAR,
	IN titolo VARCHAR,
	IN nome VARCHAR,
	IN cognome VARCHAR,
	IN afferenza VARCHAR,
	IN id_intervento integer)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO ente
	VALUES(afferenza)
	ON CONFLICT DO NOTHING;
	
  	INSERT INTO partecipante
  	VALUES(email, titolo, nome, cognome, afferenza)
  	ON CONFLICT DO NOTHING;
  	
  	INSERT INTO partecipazione
  	VALUES (id_intervento, email)
  	ON CONFLICT DO NOTHING;
END
$BODY$;



CREATE PROCEDURE insert_sponsor(
	IN nome VARCHAR,
	IN id_conf integer)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
  INSERT INTO sponsor
  VALUES(nome)
  ON CONFLICT DO NOTHING;

  INSERT INTO Sponsorizzazione
  VALUES(id_conf, nome)
  ON CONFLICT DO NOTHING;
END;
$BODY$;

---------------------------------------------------------------------