
create schema test;
drop user 'test'@'localhost';
create user 'test'@'localhost' identified by 'test1234'; -- Create the user
grant all on test.* to 'test'@'localhost'; -- Gives all privileges to that user on new db
