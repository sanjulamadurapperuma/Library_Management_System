# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            integer auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table author_books (
  author_id                     integer not null,
  books_isbn                    integer not null,
  constraint pk_author_books primary key (author_id,books_isbn)
);

create table books (
  isbn                          integer auto_increment not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               date,
  author                        varchar(255),
  publisher                     varchar(255),
  numberofpages                 integer not null,
  constraint pk_books primary key (isbn)
);

create table dvds (
  isbn                          integer auto_increment not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               date,
  languages                     varchar(255),
  subtitles                     varchar(255),
  producer                      varchar(255),
  actors                        varchar(255),
  constraint pk_dvds primary key (isbn)
);

create table reader (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobilenumber                  varchar(255),
  email                         varchar(255),
  constraint pk_reader primary key (id)
);

alter table author_books add constraint fk_author_books_author foreign key (author_id) references author (id) on delete restrict on update restrict;
create index ix_author_books_author on author_books (author_id);

alter table author_books add constraint fk_author_books_books foreign key (books_isbn) references books (isbn) on delete restrict on update restrict;
create index ix_author_books_books on author_books (books_isbn);


# --- !Downs

alter table author_books drop foreign key fk_author_books_author;
drop index ix_author_books_author on author_books;

alter table author_books drop foreign key fk_author_books_books;
drop index ix_author_books_books on author_books;

drop table if exists author;

drop table if exists author_books;

drop table if exists books;

drop table if exists dvds;

drop table if exists reader;

