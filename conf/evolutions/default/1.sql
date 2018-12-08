# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            integer auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table author_libraryitem (
  author_id                     integer not null,
  libraryitem_isbn              integer not null,
  constraint pk_author_libraryitem primary key (author_id,libraryitem_isbn)
);

create table borrowitem (
  isbnnumber                    integer auto_increment not null,
  readerid                      integer not null,
  datetimeborrowed              varchar(255),
  constraint pk_borrowitem primary key (isbnnumber)
);

create table libraryitem (
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
  borrowedstatus                varchar(255),
  nooftimesborrowed             integer not null,
  avgtimeborrowed               double not null,
  constraint pk_libraryitem primary key (isbn)
);

create table reader (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobilenumber                  varchar(255),
  email                         varchar(255),
  constraint pk_reader primary key (id)
);

create table reserveitem (
  reserveid                     integer auto_increment not null,
  isbn                          integer not null,
  readerid                      integer not null,
  constraint pk_reserveitem primary key (reserveid)
);

alter table author_libraryitem add constraint fk_author_libraryitem_author foreign key (author_id) references author (id) on delete restrict on update restrict;
create index ix_author_libraryitem_author on author_libraryitem (author_id);

alter table author_libraryitem add constraint fk_author_libraryitem_libraryitem foreign key (libraryitem_isbn) references libraryitem (isbn) on delete restrict on update restrict;
create index ix_author_libraryitem_libraryitem on author_libraryitem (libraryitem_isbn);


# --- !Downs

alter table author_libraryitem drop foreign key fk_author_libraryitem_author;
drop index ix_author_libraryitem_author on author_libraryitem;

alter table author_libraryitem drop foreign key fk_author_libraryitem_libraryitem;
drop index ix_author_libraryitem_libraryitem on author_libraryitem;

drop table if exists author;

drop table if exists author_libraryitem;

drop table if exists borrowitem;

drop table if exists libraryitem;

drop table if exists reader;

drop table if exists reserveitem;

