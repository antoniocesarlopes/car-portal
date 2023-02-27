CREATE TABLE IF NOT EXISTS public.owner_post
(
    id bigint NOT NULL,
    contact_number varchar(20) COLLATE pg_catalog."default" NOT NULL,
    name varchar(100) COLLATE pg_catalog."default" NOT NULL,
    type varchar(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT owner_post_pkey PRIMARY KEY (id),
    CONSTRAINT owner_post_ck_type CHECK (type IN ('RETAILER', 'PARTICULAR'))
)

TABLESPACE pg_default;