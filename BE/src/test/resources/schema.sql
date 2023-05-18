drop table if exists issue;

create table if not exists issue
(
    id bigint primary key auto_increment,
    member_id bigint not null,
    title varchar(255) not null,
    description varchar(255) not null,
    is_open tinyint not null,
    create_date_time datetime default current_timestamp,
    milestone_id bigint
);