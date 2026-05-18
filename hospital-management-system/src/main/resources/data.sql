INSERT INTO patient (name, gender, date_of_birth, email, blood_group)
VALUES
    ('Aarav Sharma', 'MALE', '1990-05-10', 'aarav.sharma@example.com', 'O_POSITIVE'),
    ('Divya Patel', 'FEMALE', '1995-08-20', 'divya.patel@example.com', 'A_POSITIVE'),
    ('Dishant Verma', 'MALE', '1988-03-15', 'dishant.verma@example.com', 'A_POSITIVE'),
    ('Neha Iyer', 'FEMALE', '1992-12-01', 'neha.iyer@example.com', 'AB_POSITIVE'),
    ('Kabir Singh', 'MALE', '1993-07-11', 'kabir.singh@example.com', 'O_POSITIVE');


INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');


INSERT INTO appointment
(appointment_date, reason, status, doctor_id, patient_id)
VALUES
    ('2025-07-01', 'General Checkup', 'Scheduled', 1, 2),
    ('2025-07-02', 'Skin Rash', 'Scheduled', 2, 2),
    ('2025-07-03', 'Knee Pain', 'Completed', 3, 3),
    ('2025-07-04', 'Follow-up Visit', 'Scheduled', 1, 1),
    ('2025-07-05', 'Consultation', 'Pending', 1, 4),
    ('2025-07-06', 'Allergy Treatment', 'Scheduled', 2, 5);