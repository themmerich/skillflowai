
create table image
(
    id              uuid PRIMARY KEY not null,
    tenant_id       VARCHAR(40) not null,
    filename        VARCHAR(255),
    mime_type       VARCHAR(100) not null,
    data            bytea
);