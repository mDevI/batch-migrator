DROP TABLE PEOPLE IF EXISTS;

CREATE TABLE PEOPLE (
  id         BIGINT IDENTITY NOT NULL PRIMARY KEY,
  first_name VARCHAR(20),
  last_name  VARCHAR(20),
  salary     integer
);


insert into people (first_name, last_name, salary)
values ('John', 'Doe', 2000);
insert into people (first_name, last_name, salary)
values ('Jim', 'Doe', 3000);
insert into people (first_name, last_name, salary)
values ('Jane', 'Doe', 3000);
insert into people (first_name, last_name, salary)
values ('Isaac', 'Newton', 3000);
insert into people (first_name, last_name, salary)
values ('Eric', 'Clapton', 3000);
insert into people (first_name, last_name, salary)
values ('John', 'Read', 3000);
insert into people (first_name, last_name, salary)
values ('Ann', 'Gail', 3000);
insert into people (first_name, last_name, salary)
values ('Beth', 'Mill', 3000);
insert into people (first_name, last_name, salary)
values ('Antony', 'Hicks', 3000);
insert into people (first_name, last_name, salary)
values ('Amanda', 'Star', 3000);
insert into people (first_name, last_name, salary)
values ('Vick', 'Nilson', 3000);
insert into people (first_name, last_name, salary)
values ('Abbie', 'McRoy', 3000);
insert into people (first_name, last_name, salary)
values ('Henry', 'Stew', 3000);
insert into people (first_name, last_name, salary)
values ('Mary', 'Wilson', 3000);
insert into people (first_name, last_name, salary)
values ('Harley', 'Shin', 3000);
insert into people (first_name, last_name, salary)
values ('Danial', 'Morrow', 3000);
insert into people (first_name, last_name, salary)
values ('Zak', 'Elk', 3000);
insert into people (first_name, last_name, salary)
values ('Peter', 'Norman', 3000);
insert into people (first_name, last_name, salary)
values ('Martin', 'Groo', 3000);
insert into people (first_name, last_name, salary)
values ('Garry', 'Potter', 3000);

