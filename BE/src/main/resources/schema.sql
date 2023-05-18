drop table if exists issue;

create table if not exists issue
(
    id bigint primary key auto_increment,
    member_id bigint,
    title varchar(255),
    description varchar(255),
    is_open tinyint,
    create_date_time datetime default current_timestamp,
    milestone_id bigint
);