BEGIN TRANSACTION;

DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS adoptions;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pets (
	pet_id SERIAL PRIMARY KEY,
	pet_name varchar(50) NOT NULL,
	pet_breed varchar (50),
	pet_color varchar(50),
	pet_age INT,
	is_available BOOLEAN,
	pet_description TEXT,
	pet_weight INT,
	pet_zip INT,
	pet_city varchar (50),
	pet_state varchar (10)
);

CREATE TABLE applications (
	applicant_id SERIAL PRIMARY KEY,
	app_email varchar (50),
	app_name varchar (50),
	app_phonenumber varchar(50),
	status  varchar (25) DEFAULT 'pending',
	application_date DATE,
	approved_by varchar(50)
);

CREATE TABLE adoptions (
	adoption_id SERIAL,
	pet_id INT REFERENCES pets(pet_id),
	date_adopted DATE,
	CONSTRAINT FK_adoptions FOREIGN KEY  (pet_id) REFERENCES pets(pet_id)
);

CREATE TABLE photos (
	photo_id SERIAL PRIMARY KEY,
	photo_URL varchar (250),
	pet_id INT REFERENCES pets(pet_id)
);



COMMIT TRANSACTION;
