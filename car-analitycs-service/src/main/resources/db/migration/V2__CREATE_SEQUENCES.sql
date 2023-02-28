CREATE SEQUENCE public.brand_analytics_seq
    INCREMENT 10
    START 1
    MINVALUE 1
    MAXVALUE 99999999
    OWNED BY brand_analytics.id;

ALTER SEQUENCE public.brand_analytics_seq
    OWNER TO postgres;
    
CREATE SEQUENCE public.car_model_analytics_seq
    INCREMENT 10
    START 1
    MINVALUE 1
    MAXVALUE 99999999
    OWNED BY car_model_analytics.id;

ALTER SEQUENCE public.car_model_analytics_seq
    OWNER TO postgres;
    
CREATE SEQUENCE public.car_model_price_seq
    INCREMENT 10
    START 1
    MINVALUE 1
    MAXVALUE 99999999
    OWNED BY car_model_price.id;

ALTER SEQUENCE public.car_model_price_seq
    OWNER TO postgres;    