TRUNCATE TABLE patient RESTART IDENTITY CASCADE;

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('John Doe', 30, '1993-01-01', 'Male', 'john@gmail.com', 'O_POSITIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('Jane Smith', 25, '1998-05-15', 'Female', 'smith@gmail.com', 'A_POSITIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('Michael Brown', 40, '1984-07-20', 'Male', 'michael@gmail.com', 'B_POSITIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('Emily Davis', 28, '1996-11-12', 'Female', 'emily@gmail.com', 'AB_POSITIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('David Wilson', 35, '1989-03-08', 'Male', 'david@gmail.com', 'O_NEGATIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('Sophia Taylor', 22, '2002-09-25', 'Female', 'sophia@gmail.com', 'A_NEGATIVE');

INSERT INTO patient (name, age, date_of_birth, gender, email, blood_group)
VALUES ('Daniel Johnson', 31, '1993-06-18', 'Male', 'daniel@gmail.com', 'B_NEGATIVE');