create table if not exists travelbuddy.flightspecial 
(
    id                            integer GENERATED ALWAYS AS IDENTITY,
    header                        varchar(255),
    body                          varchar(255),
    origin                        varchar(255),
    origin_code                   varchar(6),
    destination                   varchar(255),
    destination_code              varchar(6),
    cost                          integer,
    expiry_date                   DATE,
    primary key (id)
);
