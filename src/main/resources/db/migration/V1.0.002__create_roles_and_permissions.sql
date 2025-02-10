
create table user_role (
    user_id uuid not null,
    role_id VARCHAR(40) not null
);

/*
create table role (
   id           VARCHAR(40) PRIMARY KEY NOT NULL,
   tenant_id    VARCHAR(40),
   name         VARCHAR(255) UNIQUE NOT NULL
);
create index user_role_idx on user_role (user_id, role_id);


create table permission (
    code         VARCHAR(50) PRIMARY KEY NOT NULL,
    description  VARCHAR(2000)
);

create table role_permission (
    role_id VARCHAR(40) not null,
    permission_id VARCHAR(50) not null
);
create index role_permission_idx on role_permission (role_id, permission_id);
*/