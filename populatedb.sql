-- Timestamp format
-- yyyy-MM-dd hh:mm:ss[.nnnnnnnnn]

-- user
create table user(id bigint primary key auto_increment, username varchar, password varchar);

-- events
create table event(id bigint primary key auto_increment, name varchar, start_date timestamp, end_date timestamp, description varchar, hashtag varchar, logo varchar, tags varchar, last_update timestamp, location varchar);

-- tracks
create table track(id bigint primary key auto_increment, name varchar, event_id bigint, foreign key (event_id) references event(id));

-- talks
create table talk(id bigint primary key auto_increment, event_id bigint, foreign key (event_id) references event(id), track_id bigint, foreign key (track_id) references track(id), name varchar, start_date timestamp, minutes int, description varchar, room_name varchar, max_atendees int, tags varchar, hashtag varchar);

-- speakers
create table speaker(id bigint primary key auto_increment, talk_id bigint, foreign key (talk_id) references talk(id), event_id bigint, foreign key (event_id) references event(id), name varchar, twitter varchar, bio varchar, photo varchar);

-- TEST DATASET
insert into event (name, start_date, end_date, description, hashtag, logo, tags, last_update, location) values ('Greach 2014', '2014-01-01', '2014-01-03', 'Conferencia de Greach awesómica', '#greach2014', 'http://myUrl', 'groovy, grails', '2014-01-01', 'http://location.png');
insert into event (name, start_date, end_date, description, hashtag, logo, tags, last_update, location) values ('Greach 2015', '2015-01-01', '2015-01-03', 'Conferencia de Greach awesómica', '#greach2015', 'http://myUrl', 'groovy, gradle', '2015-01-01', 'http://location.png');

insert into track (name, event_id) values ('Groovy Track', 1);
insert into track (name, event_id) values ('Grails Track', 1);
insert into track (name, event_id) values ('Gradle Track', 2);
insert into track (name, event_id) values ('University Track', 2);

insert into talk (event_id, track_id, name, start_date, minutes, description, room_name, max_atendees, tags, hashtag) values (1, 1, 'International Groovy', '2014-01-01 08:00:00', 60, 'Managing international stuff in groovy', 'Sala de abajo', 200, 'groovy, i18n, stuff', '#intgroovy');
insert into talk (event_id, track_id, name, start_date, minutes, description, room_name, max_atendees, tags, hashtag) values (1, 1, 'International Groovy 2', '2014-01-01 09:00:00', 30, 'Managing stuff in groovy', 'Sala de arriba', 120, 'groovy, i18n, stuff', '#intgroovy2');
insert into talk (event_id, track_id, name, start_date, minutes, description, room_name, max_atendees, tags, hashtag) values (1, 2, 'International Grails', '2014-01-01 08:00:00', 60, 'Managing international stuff in grails', 'Sala de abajo', 200, 'grails, i18n, stuff', '#intgrails');
insert into talk (event_id, track_id, name, start_date, minutes, description, room_name, max_atendees, tags, hashtag) values (1, 2, 'International Grails 2', '2014-01-01 09:00:00', 30, 'Managing stuff in grails', 'Sala de arriba', 120, 'grails, i18n, stuff', '#intgrails2');


insert into speaker (talk_id, name, twitter, bio, photo, event_id) values (1, 'Iván', 'ilopmar', 'rockstar', 'http://photo.jpg', 1);
insert into speaker (talk_id, name, twitter, bio, photo, event_id) values (2, 'Burt', 'burtbeckwith', 'more than a rockstar', 'http://photoB.jpg', 1);
insert into speaker (talk_id, name, twitter, bio, photo, event_id) values (3, 'Iván 2', 'ilopmar', 'rockstar', 'http://photo.jpg', 1);
insert into speaker (talk_id, name, twitter, bio, photo, event_id) values (4, 'Burt 2', 'burtbeckwith', 'more than a rockstar', 'http://photoB.jpg', 1);
