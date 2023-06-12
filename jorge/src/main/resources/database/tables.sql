create table tasks
(
    id         bigint auto_increment
        primary key,
    title      varchar(255) null,
    content    varchar(255) null,
    status     varchar(255) null,
    created_at datetime(6)  not null,
    updated_at datetime(6)  null
);

create table categories
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table labels
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);


create table task_categories
(
    task_id     bigint not null,
    category_id bigint not null,
    constraint FK6u55qcnf7qt3lsnuw655aiy1
        foreign key (category_id) references categories (id),
    constraint FK8u3svjudiuq1t4laitwga0mc4
        foreign key (task_id) references tasks (id)
);

create table task_labels
(
    task_id bigint       not null,
    label_id bigint not null,
    constraint FK7wi3dfqb8gx9kiysuy980sbus
        foreign key (task_id) references tasks (id),
    constraint FK6u55qcnf7qt3l578uw655aiy1
        foreign key (label_id) references labels (id)
);

