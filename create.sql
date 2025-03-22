
    create table skillflowai.course (
        course_image uuid,
        id uuid not null,
        description varchar(255),
        repeat_interval varchar(255),
        status varchar(255),
        tenant_id varchar(255) not null,
        title varchar(255),
        primary key (id)
    );

    create table skillflowai.enrolled_user (
        enrolled_at timestamp(6),
        course_id uuid,
        id uuid not null,
        user_id uuid,
        tenant_id varchar(255) not null,
        primary key (id)
    );

    create table skillflowai.event_publication (
        completion_date timestamp(6) with time zone,
        publication_date timestamp(6) with time zone,
        id uuid not null,
        event_type varchar(255),
        listener_id varchar(255),
        serialized_event varchar(255),
        primary key (id)
    );

    create table skillflowai.image (
        id uuid not null,
        filename varchar(255),
        mime_type varchar(255),
        tenant_id varchar(255) not null,
        data bytea,
        primary key (id)
    );

    create table skillflowai.organization (
        id uuid not null,
        image uuid,
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
