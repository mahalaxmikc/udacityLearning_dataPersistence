create schema critter;

create user 'dev'@'localhost' identified by 'dev1234'; -- Create the user
grant all on dev.* to 'dev'@'localhost'; -- Gives all privileges to that user on new db

