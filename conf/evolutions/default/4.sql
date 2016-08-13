# --- !Ups

CREATE SEQUENCE page_id_seq;
CREATE TABLE pages (
  id integer NOT NULL DEFAULT nextval('page_id_seq'),
  title varchar(255) NOT NULL,
  link varchar(255) NOT NULL,
  body varchar(512) NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE pages;
DROP SEQUENCE pages_id_seq;