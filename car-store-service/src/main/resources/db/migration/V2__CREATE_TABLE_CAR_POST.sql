CREATE TABLE IF NOT EXISTS public.car_post
(
    id bigint NOT NULL,
    brand varchar(50) COLLATE pg_catalog."default" NOT NULL,
    city varchar(50) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp(6) without time zone NOT NULL,
    description varchar(200) COLLATE pg_catalog."default" NOT NULL,
    engine_version varchar(5) COLLATE pg_catalog."default" NOT NULL,
    model varchar(50) COLLATE pg_catalog."default" NOT NULL,
    price double precision NOT NULL,
    owner_post_id bigint NOT NULL,
    CONSTRAINT car_post_pkey PRIMARY KEY (id),
    CONSTRAINT car_post_owner_post_fk FOREIGN KEY (owner_post_id)
        REFERENCES public.owner_post (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.car_post
    OWNER to postgres;