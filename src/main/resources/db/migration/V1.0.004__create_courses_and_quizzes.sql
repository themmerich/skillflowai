
create table course (
    id                  uuid primary key not null,
    tenant_id           VARCHAR(40) not null,
    title               VARCHAR(255) not null,
    description         VARCHAR(2000),
    status              VARCHAR(50) not null,
    repeat_interval     VARCHAR(20),
    course_image        uuid
);
alter table course add constraint unique_title_tenant unique (title, tenant_id);

create table enrolled_user (
    id                  uuid primary key not null,
    tenant_id           VARCHAR(40) not null,
    user_id             uuid not null,
    course_id           uuid not null,
    enrolled_at         timestamp not null,
    constraint fk_enrolled_user_user_id foreign key(user_id) references "user"(id),
    constraint fk_enrolled_user_course_id foreign key(course_id) references course(id)
);
alter table enrolled_user add constraint unique_user_course unique (user_id, course_id);

create table lesson (
    id                  uuid primary key not null,
    tenant_id           VARCHAR(40) not null,
    course_id           uuid not null,
    title               varchar(255) not null,
    description         varchar(1000),
    "order"             integer not null,
    constraint fk_lesson_course_id foreign key(course_id) references course(id)
);

create table section (
    id                  uuid primary key not null,
    tenant_id           VARCHAR(40) not null,
    lesson_id           uuid not null,
    title               varchar(255) not null,
    description         varchar(1000),
    "order"             integer not null,
    constraint fk_section_lesson_id foreign key(lesson_id) references lesson(id)
);

create table block (
    id                  uuid primary key not null,
    tenant_id           VARCHAR(40) not null,
    section_id          uuid not null,
    type                varchar(255) not null,
    content             varchar(3000)
);

create table progress_finished_lessons (
    lesson_id           uuid not null,
    user_id             uuid not null,
    constraint fk_progress_finished_lesson_lesson_id foreign key(lesson_id) references lesson(id),
    constraint fk_progress_finished_lesson_user_id foreign key(user_id) references "user"(id)
);