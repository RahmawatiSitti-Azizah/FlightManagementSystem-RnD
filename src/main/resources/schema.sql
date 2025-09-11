create table if not exists aircraft (
    seat_capacity integer not null,
    id uuid default RANDOM_UUID() not null,
    name varchar(255),
    primary key (id)
);
create table if not exists app_user (
    id uuid default RANDOM_UUID() not null,
    name varchar(255),
    password varchar(255),
    role varchar(255),
    username varchar(255) unique,
    primary key (id)
);
create table if not exists destination (
    id uuid not null,
    name varchar(255) unique,
    created_by uuid,
    primary key (id),
    foreign key (created_by) references app_user(id)
);
create table if not exists route (
    aircraft_id uuid,
    from_destination_id uuid,
    id uuid not null,
    to_destination_id uuid,
    flight_day integer not null,
    status varchar(255) not null,
    primary key (id),
    foreign key (aircraft_id) references aircraft(id),
    foreign key (from_destination_id) references destination(id),
    foreign key (to_destination_id) references destination(id)
);

ALTER TABLE destination ADD COLUMN IF NOT EXISTS created_by uuid;
