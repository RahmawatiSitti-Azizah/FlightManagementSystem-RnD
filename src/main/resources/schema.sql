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
    available_seats integer not null,
    primary key (id),
    foreign key (aircraft_id) references aircraft(id),
    foreign key (from_destination_id) references destination(id),
    foreign key (to_destination_id) references destination(id)
);

create table if not exists seat (
    id uuid not null,
    route_id uuid,
    seat_number integer not null,
    is_available boolean default true,
    primary key(id),
    foreign key (route_id) references route(id)
);

create table if not exists booking (
    id uuid not null,
    booking_id varchar(255) unique,
    seat_id uuid,
    status varchar(255) not null,
    aircraft_id uuid,
    from_destination_id uuid,
    to_destination_id uuid,
    flight_day integer not null,
    transit_booking_id varchar(255),
    user_id uuid,
    primary key (id),
    foreign key (aircraft_id) references aircraft(id),
    foreign key (seat_id) references seat(id),
    foreign key (from_destination_id) references destination(id),
    foreign key (to_destination_id) references destination(id),
    foreign key (user_id) references app_user(id),
    unique(aircraft_id, transit_booking_id, from_destination_id, to_destination_id, flight_day, user_id)
);

create table if not exists system_config (
    id int GENERATED ALWAYS AS IDENTITY,
    name varchar(50) unique,
    config_value varchar(50),
    primary key (id)
);

ALTER TABLE destination ADD COLUMN IF NOT EXISTS created_by uuid;
ALTER TABLE booking ADD COLUMN IF NOT EXISTS transit_booking_id varchar(255);