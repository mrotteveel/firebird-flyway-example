create table PERSON (
    ID int generated by default as identity constraint PK_PERSON primary key,
    NAME varchar(100) not null
);
