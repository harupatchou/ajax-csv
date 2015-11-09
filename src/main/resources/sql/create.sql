DROP TABLE shops;
DROP TABLE categories_defene;
DROP TABLE categories_exp;
DROP TABLE users;

CREATE TABLE shops
(
  id integer NOT NULL,
  name character varying(30) NOT NULL,
  address character varying(50),
  detail character varying(200)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shops
  add constraint shops_PKC primary key (id);
ALTER TABLE shops  
  OWNER TO postgres;

CREATE TABLE categories_defene
(
  id integer NOT NULL,
  name character varying(20) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE categories_defene
  add constraint categories_defene_PKC primary key (id);
ALTER TABLE categories_defene
  OWNER TO postgres;

CREATE TABLE categories_exp
(
  shop_id integer NOT NULL,
  category_id integer NOT NULL,
  other character varying(20)
);

create unique index categories_exp_PKI
  on categories_exp(category_id,shop_id);

alter table categories_exp
  add constraint categories_exp_PKC primary key (category_id,shop_id);
  
CREATE TABLE users
(
  id integer NOT NULL,
  name character varying(10) NOT NULL,
  nickname character varying(10) NOT NULL,
  password character varying(10) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
