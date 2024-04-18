--liquibase formatted sql

--changeset belonogov:1
create table post_office
(
    id      bigserial,
    constraint post_office_pk primary key (id),
    index   varchar(6)   not null,
    name    varchar(300) not null,
    address varchar(300) not null,
    constraint unique (index)
);
--rollback drop table post_office

--changeset belonogov:2
create table postage
(
    id                bigserial,
    constraint postage_pk primary key (id),
    recipient_name    varchar(300) not null,
    postage_type      varchar(150) not null,
    sender_index      varchar(6)   not null,
    recipient_index   varchar(6)   not null,
    recipient_address varchar(300) not null,
    postage_status    varchar(150) not null

);
--rollback drop table postage

--changeset belonogov:3
create
    table postage_movements
(
    id                      bigserial,
    constraint postage_movements_pk primary key (id),
    post_office_id          bigint,
    constraint postage_movements_post_office_fk foreign key (post_office_id) references post_office (id),
    postage_id              bigint,
    constraint postage_movements_postage_fk foreign key (postage_id) references postage (id),
    postage_movement_status varchar(150) not null,
    date_time               timestamp    not null

)
--rollback drop table postage_movements