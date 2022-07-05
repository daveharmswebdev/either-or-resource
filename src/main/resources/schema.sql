drop table if exists `option`;
drop table if exists hibernate_sequence;

create table `option` (
                          id bigint not null,
                          category varchar(255),
                          name varchar(255),
                          primary key (id)
) engine=InnoDB;

create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );