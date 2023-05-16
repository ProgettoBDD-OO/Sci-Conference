CREATE SEQUENCE IF NOT EXISTS public.collocazioni_id_collocazione_seq
    INCREMENT 1
    START 1999
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS public.conferenze_id_conferenza_seq
    INCREMENT 1
    START 1124
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS public.enti_id_ente_seq
    INCREMENT 1
    START 5999
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS public.proposte_bacheca_id_conferenza_bacheca_seq
    INCREMENT 1
    START 199
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS public.sponsor_id_sponsor_seq
    INCREMENT 1
    START 4999
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;