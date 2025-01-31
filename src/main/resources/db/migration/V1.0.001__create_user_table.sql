
create table "user" (
    id          uuid NOT NULL,
    email       VARCHAR(30) NOT NULL,
    password    VARCHAR(70) NOT NULL,
    first_name  VARCHAR(30) NOT NULL,
    last_name   VARCHAR(30) NOT NULL
)
