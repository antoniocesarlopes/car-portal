CREATE SEQUENCE public.car_post_seq
    INCREMENT 10
    START 1
    MINVALUE 1
    MAXVALUE 99999999
    OWNED BY car_post.id;

ALTER SEQUENCE public.car_post_seq
    OWNER TO postgres;
    
CREATE SEQUENCE public.owner_post_seq
    INCREMENT 10
    START 1
    MINVALUE 1
    MAXVALUE 99999999
    OWNED BY owner_post.id;

ALTER SEQUENCE public.owner_post_seq
    OWNER TO postgres;