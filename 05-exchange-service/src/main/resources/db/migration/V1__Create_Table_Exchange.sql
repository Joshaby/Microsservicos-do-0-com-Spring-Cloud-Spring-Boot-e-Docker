create table exchange (conversion_factor numeric(38,2) not null, from_currency varchar(3) not null, to_currency varchar(3) not null, id bigserial not null, primary key (id));
