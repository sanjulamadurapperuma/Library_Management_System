# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            integer auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table author_libraryitems (
  author_id                     integer not null,
  libraryitems_isbn             integer not null,
  constraint pk_author_libraryitems primary key (author_id,libraryitems_isbn)
);

create table libraryitems (
  isbn                          integer auto_increment not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               date,
  author                        varchar(255),
  publisher                     varchar(255),
  numberofpages                 integer not null,
  languages                     varchar(255),
  subtitles                     varchar(255),
  producer                      varchar(255),
  actors                        varchar(255),
  type                          varchar(255),
  constraint pk_libraryitems primary key (isbn)
);

create table reader (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobilenumber                  varchar(255),
  email                         varchar(255),
  constraint pk_reader primary key (id)
);

alter table author_libraryitems add constraint fk_author_libraryitems_author foreign key (author_id) references author (id) on delete restrict on update restrict;
create index ix_author_libraryitems_author on author_libraryitems (author_id);

alter table author_libraryitems add constraint fk_author_libraryitems_libraryitems foreign key (libraryitems_isbn) references libraryitems (isbn) on delete restrict on update restrict;
create index ix_author_libraryitems_libraryitems on author_libraryitems (libraryitems_isbn);


# --- !Downs

alter table author_libraryitems drop foreign key fk_author_libraryitems_author;
drop index ix_author_libraryitems_author on author_libraryitems;

alter table author_libraryitems drop foreign key fk_author_libraryitems_libraryitems;
drop index ix_author_libraryitems_libraryitems on author_libraryitems;

drop table if exists author;

drop table if exists author_libraryitems;

drop table if exists libraryitems;

drop table if exists reader;

