CREATE OR REPLACE PROCEDURE public.insert_ente(
	IN nome character varying,
	IN id_conf integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
  INSERT INTO enti
  VALUES(nome)
  ON CONFLICT DO NOTHING;

  INSERT INTO organizzazione
  VALUES(id_conf,nome)
  ON CONFLICT DO NOTHING;

END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.insert_keynote(
	IN email character varying,
	IN titolo character varying,
	IN nome character varying,
	IN cognome character varying,
	IN afferenza character varying)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
  INSERT INTO enti
  VALUES (afferenza)
  ON CONFLICT DO NOTHING;

  INSERT INTO keynote_speaker 
  VALUES(email, titolo, nome, cognome, afferenza)
  ON CONFLICT DO NOTHING;
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.insert_organizzatore(
	IN email character varying,
	IN titolo character varying,
	IN nome character varying,
	IN cognome character varying,
	IN afferenza character varying,
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

CREATE OR REPLACE PROCEDURE public.insert_partecipante(
	IN email character varying,
	IN titolo character varying,
	IN nome character varying,
	IN cognome character varying,
	IN afferenza character varying,
	IN id_intervento integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
	INSERT INTO enti
	VALUES(afferenza)
	ON CONFLICT DO NOTHING;
	
  	INSERT INTO partecipanti
  	VALUES(email, titolo, nome, cognome, afferenza)
  	ON CONFLICT DO NOTHING;
  	
  	INSERT INTO partecipazione
  	VALUES (id_intervento, email)
  	ON CONFLICT DO NOTHING;
END
$BODY$;

CREATE OR REPLACE PROCEDURE public.insert_sponsor(
	IN nome character varying,
	IN id_conf integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
  INSERT INTO sponsor
  VALUES(nome)
  ON CONFLICT DO NOTHING;

  INSERT INTO Sponsorizzazione
  VALUES(id_conf,nome)
  ON CONFLICT DO NOTHING;

END;
$BODY$;