create table depot_type (
    id serial not null primary key,
    type varchar(100) not null
);

insert into depot_type(type) values ('Локомотивное');
insert into depot_type(type) values ('Моторвагонное');
insert into depot_type(type) values ('Вагонное');
insert into depot_type(type) values ('Трамвайное');
insert into depot_type(type) values ('Метродепо/Электродепо');