
create table organization (
   id           uuid PRIMARY KEY NOT NULL,
   tenant_id    VARCHAR(40) NOT NULL,
   name         VARCHAR(255) UNIQUE NOT NULL
);


create table "user" (
    id          uuid PRIMARY KEY NOT NULL,
    email       VARCHAR(50) NOT NULL,
    password    VARCHAR(70) NOT NULL,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    tenant_id   VARCHAR(40) NOT NULL
);

alter table "user" add constraint unique_email_tenant unique (email, tenant_id);


