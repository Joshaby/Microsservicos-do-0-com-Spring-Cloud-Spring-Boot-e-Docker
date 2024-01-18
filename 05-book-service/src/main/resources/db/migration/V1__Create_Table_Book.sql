create table book (price float(53) not null, id bigserial not null, launch_date TIMESTAMP not null, author varchar(180) not null, title varchar(255) not null, primary key (id));
