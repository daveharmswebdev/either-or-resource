create table question
(
    id          bigint not null,
    title       varchar(255),
    description       varchar(255),
    primary key(id)
) engine = InnoDB;