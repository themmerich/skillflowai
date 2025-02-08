
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
        id uuid not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        tenant_id varchar(255) not null,
        primary key (id)
    );
