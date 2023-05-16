sql functions


CREATE OR REPLACE FUNCTION public.afferenze_by_month(
	mese integer,
	anno integer)
    RETURNS TABLE(ente character varying, occorrenze bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT afferenza, count(afferenza) FROM keynote_speaker JOIN 
  (SELECT DISTINCT keynote_speaker FROM sessioni 
   WHERE EXTRACT(MONTH FROM data_ora_inizio) = mese + 1 AND EXTRACT(YEAR FROM data_ora_inizio) = anno
   ) AS occorrenze_enti ON keynote_speaker.email = occorrenze_enti.keynote_speaker 
     GROUP BY afferenza;
END;
$BODY$;


CREATE OR REPLACE FUNCTION public.afferenze_by_year(
	anno integer)
    RETURNS TABLE(ente character varying, occorrenze bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT afferenza, count(afferenza) FROM keynote_speaker JOIN 
  (SELECT DISTINCT keynote_speaker FROM sessioni 
   WHERE EXTRACT(YEAR FROM data_ora_inizio) = anno
   ) AS occorrenze_enti ON keynote_speaker.email = occorrenze_enti.keynote_speaker 
     GROUP BY afferenza;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.collocazione_conferenza(
	id_conf integer)
    RETURNS TABLE(sede character varying, regione character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT colloc.sede, colloc.regione FROM collocazioni AS colloc NATURAL JOIN conferenze_scientifiche
  WHERE id_conferenza = id_conf;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.collocazioni(
	sede_in character varying,
	regione_in character varying)
    RETURNS SETOF integer 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
RETURN QUERY SELECT id_collocazione FROM collocazioni WHERE sede = sede_in AND regione = regione_in;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.conferenze_utente(
	email_in character varying)
    RETURNS TABLE(id_conferenza integer, nome_conferenza character varying, tema_conferenza character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT cs.id_conferenza, cs.nome, cs.tema FROM conferenze_scientifiche AS cs 
  NATURAL JOIN iscrizioni_conferenze AS ic
  WHERE ic.email = email_in;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.enti(
	id_conf integer)
    RETURNS SETOF character varying 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
RETURN QUERY SELECT ente FROM organizzazione
WHERE id_conferenza = id_conf;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.filtered_research(
	nome_ricerca character varying DEFAULT NULL::character varying,
	temi character varying[] DEFAULT NULL::character varying[],
	regioni character varying[] DEFAULT NULL::character varying[])
    RETURNS TABLE(id_conf integer, nome_conf character varying, tema_conf character varying, regione_conf character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
		SELECT id_conferenza, nome, tema, regione 
		FROM conferenze_scientifiche NATURAL JOIN collocazioni
		WHERE nome ILIKE '%' || nome_ricerca || '%'
		  AND ($2 IS NULL OR tema = ANY($2)) 
		  AND ($3 IS NULL OR regione = ANY($3))
		ORDER BY data_inizio;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.iscrizioni(
	email_in character varying,
	id_conf integer)
    RETURNS SETOF integer 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
RETURN QUERY SELECT id_conferenza FROM iscrizioni_conferenze 
WHERE email = email_in AND id_conferenza = id_conf;
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.sponsor(
	id_conf integer)
    RETURNS SETOF character varying 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
RETURN QUERY SELECT nome FROM sponsor NATURAL JOIN sponsorizzazione
WHERE id_conferenza = id_conf;
END;
$BODY$;
