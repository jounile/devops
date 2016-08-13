# Contacts schema

# --- !Ups

CREATE SEQUENCE contact_id_seq;
CREATE TABLE contact (
    id integer NOT NULL DEFAULT nextval('contact_id_seq'),
    name varchar(255),
    email varchar(255),
    message varchar(255)
);

# --- !Downs

DROP TABLE contact;
DROP SEQUENCE contact_id_seq;