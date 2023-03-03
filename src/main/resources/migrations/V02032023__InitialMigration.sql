-- DROP SCHEMA public;

-- CREATE SCHEMA public AUTHORIZATION pg_database_owner;

-- COMMENT ON SCHEMA public IS 'standard public schema';
-- public."role" definition

-- Drop table

-- DROP TABLE public."role";


CREATE TABLE public."role" (
                               role_id uuid NOT NULL,
                               created_at timestamp(6) NULL,
                               created_by varchar(255) NULL,
                               last_modified_by varchar(255) NULL,
                               modified_at timestamp(6) NULL,
                               "name" varchar(255) NOT NULL,
                               CONSTRAINT role_pkey PRIMARY KEY (role_id)
);

-- Permissions

ALTER TABLE public."role" OWNER TO postgres;
GRANT ALL ON TABLE public."role" TO postgres;


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
                              user_id uuid NOT NULL,
                              created_at timestamp(6) NULL,
                              created_by varchar(255) NULL,
                              last_modified_by varchar(255) NULL,
                              modified_at timestamp(6) NULL,
                              email varchar(255) NOT NULL,
                              "name" varchar(255) NOT NULL,
                              "password" varchar(255) NOT NULL,
                              surname varchar(255) NOT NULL,
                              role_id uuid NOT NULL,
                              CONSTRAINT users_pkey PRIMARY KEY (user_id),
                              CONSTRAINT fk4qu1gr772nnf6ve5af002rwya FOREIGN KEY (role_id) REFERENCES public."role"(role_id)
);

-- Permissions

ALTER TABLE public.users OWNER TO postgres;
GRANT ALL ON TABLE public.users TO postgres;


-- public.realestate definition

-- Drop table

-- DROP TABLE public.realestate;

CREATE TABLE public.realestate (
                                   realestate_id uuid NOT NULL,
                                   created_at timestamp(6) NULL,
                                   created_by varchar(255) NULL,
                                   last_modified_by varchar(255) NULL,
                                   modified_at timestamp(6) NULL,
                                   canton varchar(255) NOT NULL,
                                   "name" varchar(255) NOT NULL,
                                   price numeric(38, 2) NOT NULL,
                                   square varchar(255) NOT NULL,
                                   url varchar(255) NOT NULL,
                                   user_user_id uuid NULL,
                                   CONSTRAINT realestate_pkey PRIMARY KEY (realestate_id),
                                   CONSTRAINT fkcvrdf7l4q8rb3syhl1letkocq FOREIGN KEY (user_user_id) REFERENCES public.users(user_id)
);

-- Permissions

ALTER TABLE public.realestate OWNER TO postgres;
GRANT ALL ON TABLE public.realestate TO postgres;


-- public.userrealestate definition

-- Drop table

-- DROP TABLE public.userrealestate;

CREATE TABLE public.userrealestate (
                                       userrealestate_id uuid NOT NULL,
                                       created_at timestamp(6) NULL,
                                       created_by varchar(255) NULL,
                                       last_modified_by varchar(255) NULL,
                                       modified_at timestamp(6) NULL,
                                       status varchar(255) NOT NULL,
                                       realestate_id uuid NULL,
                                       user_id uuid NULL,
                                       CONSTRAINT userrealestate_pkey PRIMARY KEY (userrealestate_id),
                                       CONSTRAINT fkks8jalen8ioh4ol0o6yqty3e8 FOREIGN KEY (realestate_id) REFERENCES public.realestate(realestate_id),
                                       CONSTRAINT fkpi6ks616imjsetuqgicualdra FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);

-- Permissions

ALTER TABLE public.userrealestate OWNER TO postgres;
GRANT ALL ON TABLE public.userrealestate TO postgres;




-- Permissions

GRANT ALL ON SCHEMA public TO pg_database_owner;
GRANT USAGE ON SCHEMA public TO public;
