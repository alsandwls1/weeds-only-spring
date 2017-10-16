SELECT * FROM files;

DROP TABLE files;

delete table files;

CREATE TABLE files(
	f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	f_name VARCHAR(100) ,
	f_path VARCHAR(500)
);

INSERT INTO files (f_name, f_path) VALUES ('d', 'D:/uploads'); 

