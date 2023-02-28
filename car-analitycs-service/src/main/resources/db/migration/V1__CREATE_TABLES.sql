CREATE TABLE IF NOT EXISTS public.brand_analytics (
	id bigint NOT NULL,
	brand varchar(255),
	posts bigint, 
	
	CONSTRAINT brand_analytics_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;


CREATE TABLE IF NOT EXISTS public.car_model_analytics (
	id bigint NOT NULL,
	model varchar(255),
	posts bigint, 
	CONSTRAINT car_model_analytics_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;


CREATE TABLE IF NOT EXISTS public.car_model_price (
	id bigint NOT NULL,
	model varchar(255),
	price float(53),
	CONSTRAINT car_model_price_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;