# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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


# --- !Downs

drop table if exists borrowitem;

drop table if exists libraryitem;

drop table if exists reader;

drop table if exists reserveitem;

