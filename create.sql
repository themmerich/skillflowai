
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
        id uuid not null,
        name varchar(255) not null,
        tenant_id varchar(255) not null,
        primary key (id)
    );

    create table skillflowai.user (
        birthday date,
        id uuid not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        tenant_id varchar(255) not null,
        primary key (id)
    );

    create table skillflowai.user_role (
        user_id uuid not null,
        role_id varchar(255)
    );

    alter table if exists skillflowai.user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references skillflowai.user;
