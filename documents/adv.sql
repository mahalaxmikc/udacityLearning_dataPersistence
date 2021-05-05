create schema testDB;

create user 'sa'@'localhost' identified by 'sa1234'; -- Create the user
grant all on sa.* to 'test1'@'localhost'; -- Gives all privileges to that user on new db

