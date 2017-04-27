
CREATE USER 'userapp'@'localhost' IDENTIFIED BY 'usrapp';
GRANT CREATE, DROP, ALTER, INSERT, UPDATE, SELECT, DELETE,
INDEX ON BDTP.* TO 'userapp'@'localhost';