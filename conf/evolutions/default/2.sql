# --- !Ups

CREATE SEQUENCE tech_id_seq;
CREATE TABLE technologies (
    id integer NOT NULL DEFAULT nextval('tech_id_seq'),
    title varchar(255) NOT NULL,
    body varchar(512) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE technologies;
DROP SEQUENCE tech_id_seq;