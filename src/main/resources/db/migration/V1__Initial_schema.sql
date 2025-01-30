create sequence skillflowai.organisation_seq start with 1 increment by 50;

create table skillflowai.event_publication (
                                               completion_date timestamp(6) with time zone,
                                               publication_date timestamp(6) with time zone,
                                               id uuid not null,
                                               event_type varchar(255),
                                               listener_id varchar(255),
                                               serialized_event varchar(255),
                                               primary key (id)
);

create table skillflowai.organization (
                                          created_by_id bigint,
                                          created_date timestamp(6),
                                          id bigint not null,
                                          last_modified_by_id bigint,
                                          last_modified_date timestamp(6),
                                          description varchar(255),
                                          name varchar(255) not null,
                                          primary key (id)
);

create table skillflowai.roles (
                                   id bigint generated by default as identity,
                                   name varchar(255) not null unique,
                                   primary key (id)
);

create table skillflowai.user (
                                  id bigint generated by default as identity,
                                  password varchar(255) not null,
                                  username varchar(255) not null unique,
                                  primary key (id)
);

create table skillflowai.user_roles (
                                        role_id bigint not null,
                                        user_id bigint not null,
                                        primary key (role_id, user_id)
);

alter table if exists skillflowai.organization
    add constraint FKgv11yfjo1i0mspyfw1sm8ylqk
    foreign key (created_by_id)
    references skillflowai.user;

alter table if exists skillflowai.organization
    add constraint FKqcfvhx8iaycu5l7in3fwqwhis
    foreign key (last_modified_by_id)
    references skillflowai.user;

alter table if exists skillflowai.user_roles
    add constraint FKh8ciramu9cc9q3qcqiv4ue8a6
    foreign key (role_id)
    references skillflowai.roles;

alter table if exists skillflowai.user_roles
    add constraint FK55itppkw3i07do3h7qoclqd4k
    foreign key (user_id)
    references skillflowai.user;
