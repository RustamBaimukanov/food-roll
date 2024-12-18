create table if not exists food
(
    id                   bigint default nextval('food_seq'::regclass) not null
    primary key,
    created_date         timestamp(6),
    updated_date         timestamp(6),
    difficulty           varchar(255)
    constraint food_difficulty_check
    check ((difficulty)::text = ANY
((ARRAY ['EASY'::character varying, 'NORMAL'::character varying, 'HARD'::character varying])::text[])),
    image                bytea,
    image_file_extension varchar(255),
    name                 varchar(255)
    );